package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.Visitor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@Repository
public class VisitorRepositoryInMemory implements VisitorRepository {

    private final Map<Integer, Visitor> visitors = new HashMap<>();
    private int lastIndexUsed = 0;

    @Override
    public List<Visitor> findAll() {
        return visitors.values().stream()
                .sorted(Comparator.comparing(Visitor::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Visitor saveVisitor(Visitor visitor) {
        visitors.put(++lastIndexUsed, visitor);
        visitor.setId(lastIndexUsed);
        return visitor;
    }
}
