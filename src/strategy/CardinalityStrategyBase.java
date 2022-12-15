package strategy;

import model.BitSet;

public class CardinalityStrategyBase implements CardinalityStrategy {

    @Override
    public int getCardinality(BitSet mySet) {
        int count = 0;
        for (int i = 0; i < mySet.size(); ++i) {
            if (mySet.get(i) == 1) {
                count++;
            }
        }
        return count;
    }
}
