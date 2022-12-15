package visitor;

import iterator.Iterator;
import model.BitSet;

public class SizeVisitor implements Visitor {
    int c = 0;

    @Override
    public void visit(BitSet set) {
        Iterator it = set.createMyIterator();
        while (it.hasNext()) {
            c++;
        }
    }

    public int getSizeByVisitor() {
        return c;
    }
}
