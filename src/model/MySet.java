package model;

import iterator.MyIterable;
import iterator.MyIterator;
import strategy.CardinalityStrategy;
import visitor.SizeVisitor;
import visitor.Visitor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MySet implements MyIterable, Visited {

    private final ArrayList<Integer> set = new ArrayList<>();

    private CardinalityStrategy cardinalityStrategy = null;

    public void addPos(int pos) {
        set.add(pos);
    }

    public void add(int element) {
        if (element >= size()) {
            for (int i = size(); i <= element; ++i) {
                addPos(0);
            }
        }
        set.set(element, 1);
    }

    public void setCardinalityStrategy(CardinalityStrategy s) {
        this.cardinalityStrategy = s;
    }

    public int getCardinalityByStrategy() {
        if (cardinalityStrategy != null) {
            return cardinalityStrategy.getCardinality(this);
        } else {
            return -1;
        }
    }

    public int size() {
        return set.size();
    }

    public int sizeVisitor() {
        SizeVisitor sizeVisitor = new SizeVisitor();
        this.accept(sizeVisitor);
        return sizeVisitor.getSizeByVisitor();
    }

    @Override
    public String toString() {
        return "MySet{" +
                set +
                '}';
    }


    public int get(int pos) {
        return set.get(pos);
    }

    @Override
    public MyIterator createMyIterator() {
        return new MyIterator() {
            private int pos = -1;

            @Override
            public Integer next() {
                pos++;
                return get(pos);
            }

            @Override
            public Boolean hasNext() {
                return pos < size() - 1;
            }
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
