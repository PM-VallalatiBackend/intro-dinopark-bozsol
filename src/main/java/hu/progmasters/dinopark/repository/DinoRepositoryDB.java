package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Dinosaur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DinoRepositoryDB implements DinoRepository {

    private final JdbcTemplate jdbcTemplate;

    public DinoRepositoryDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        initTable();
    }

    private void initTable() {
        jdbcTemplate.execute(
                "CREATE TABLE IF NOT EXISTS `dinosaur` (" +
                        "  `id` INT NOT NULL AUTO_INCREMENT, " +
                        "  `name` VARCHAR(50) NULL, " +
                        "  `breed` VARCHAR(50) NULL, " +
                        "  `type` VARCHAR(50) NULL, " +
                        "  PRIMARY KEY (`id`));");
    }

    @Override
    public List<Dinosaur> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM `dinosaur`",
                (rs, rn) -> getDinosaurFromResultSet(rs)
        );
    }

    @Override
    public Dinosaur findById(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM `dinosaur` WHERE `id` = ?",
                (rs, rn) -> getDinosaurFromResultSet(rs),
                id
        );
    }

    @Override
    public List<Dinosaur> findByType(DinoType dinoType) {
        return jdbcTemplate.query(
                "SELECT * FROM `dinosaur` WHERE `type` = ?",
                (rs, rn) -> getDinosaurFromResultSet(rs),
                dinoType
        );
    }

    @Override
    public Dinosaur saveDinosaur(Dinosaur dinosaur) {
        jdbcTemplate.update(
                "INSERT INTO `dinosaur` (`name`, `breed`, `type`) VALUES (?, ?, ?)",
                dinosaur.getName(), dinosaur.getBreed(), dinosaur.getType().toString()
        );

        return jdbcTemplate.queryForObject(
                "SELECT * FROM `dinosaur` ORDER BY `id` DESC LIMIT 1",
                (rs, rn) -> getDinosaurFromResultSet(rs)
        );
    }

    private Dinosaur getDinosaurFromResultSet(ResultSet rs) throws SQLException {
        return new Dinosaur()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setBreed(rs.getString("breed"))
                .setType(DinoType.valueOf(rs.getString("type")));
    }
}
