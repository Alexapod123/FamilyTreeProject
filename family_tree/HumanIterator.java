package family_tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>curIndex;
    }

    @Override
    public Human next() {
        return humanList.get(curIndex++);
    }

}
