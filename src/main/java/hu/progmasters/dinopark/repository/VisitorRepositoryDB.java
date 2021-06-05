package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.DinoType;
import hu.progmasters.dinopark.domain.Visitor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class VisitorRepositoryDB implements VisitorRepository {
    private final JdbcTemplate jdbcTemplate;

    public VisitorRepositoryDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        initTable();
    }

    private void initTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `visitor` ( " +
                "`id` INT NOT NULL AUTO_INCREMENT, " +
                "`name` VARCHAR(50) NULL, " +
                "`preference` VARCHAR(50) NULL, " +
                "`rating` INT NULL, " +
                "PRIMARY KEY (`id`));");
    }

    @Override
    public List<Visitor> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM `visitor`",
                (rs, rn) -> getVisitorFromResultSet(rs)
        );
    }

    @Override
    public Visitor saveVisitor(Visitor visitor) {
        jdbcTemplate.update(
                "INSERT INTO `visitor` (`name`, `preference`, `rating`) VALUES (?, ?, ?)",
                visitor.getName(), visitor.getPreference().toString(), visitor.getRating()
        );

        return jdbcTemplate.queryForObject(
                "SELECT * FROM `visitor` ORDER BY `id` DESC LIMIT 1",
                (rs, rn) -> getVisitorFromResultSet(rs)
        );
    }

    private Visitor getVisitorFromResultSet(ResultSet rs) throws SQLException {
        return new Visitor()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setPreference(DinoType.valueOf(rs.getString("preference")))
                .setRating(rs.getInt("rating"));
    }
}
