package hu.progmasters.dinopark.repository;

import hu.progmasters.dinopark.domain.Visitor;

import java.util.List;

public interface VisitorRepository {

    List<Visitor> findAll();

    Visitor saveVisitor(Visitor visitor);
}
