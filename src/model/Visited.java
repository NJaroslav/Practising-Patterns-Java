package model;

import visitor.Visitor;

public interface Visited {
    void accept(Visitor visitor);
}
