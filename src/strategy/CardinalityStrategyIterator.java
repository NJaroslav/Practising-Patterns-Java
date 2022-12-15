package strategy;

import iterator.Iterator;
import model.BitSet;

public class CardinalityStrategyIterator implements CardinalityStrategy {
    @Override
    public int getCardinality(BitSet mySet) {
        int count = 0;
        Iterator it = mySet.createMyIterator();
        while (it.hasNext()) {
            if (it.next() == 1) {
                count++;
            }
        }
        return count;
    }
}
