package visitor;

import iterator.MyIterator;
import model.MySet;

public class SizeVisitor implements Visitor {
    int c = 0;

    @Override
    public void visit(MySet set) {
        MyIterator it = set.createMyIterator();
        while (it.hasNext()) {
            c++;
        }
    }

    public int getSizeByVisitor() {
        return c;
    }
}
