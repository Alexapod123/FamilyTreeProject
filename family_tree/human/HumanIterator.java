package family_tree.human;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import family_tree.tree.GeneralTree;

public class HumanIterator<G extends GeneralTree<G>> implements Comparator<G> {
    private int curIndex;
    private List<G> humanList;

    public HumanIterator(List<G> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>curIndex;
    }

    @Override
    public G next() {
        return humanList.get(curIndex++);
    }

    @Override
    public int compare(G o1, G o2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compare'");
    }

}
