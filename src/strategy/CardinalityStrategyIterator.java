package strategy;

import iterator.MyIterator;
import model.MySet;

public class CardinalityStrategyIterator implements CardinalityStrategy {
    @Override
    public int getCardinality(MySet mySet) {
        int count = 0;
        MyIterator it = mySet.createMyIterator();
        while (it.hasNext()) {
            if (it.next() == 1) {
                count++;
            }
        }
        return count;
    }
}
