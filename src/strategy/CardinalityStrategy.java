package strategy;

import model.BitSet;

public interface CardinalityStrategy {
    int getCardinality(BitSet mySet);
}
