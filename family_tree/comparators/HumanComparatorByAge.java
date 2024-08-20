package family_tree.comparators;

import java.util.Comparator;

// import family_tree.human.Human;
import family_tree.tree.GeneralTree;

public class HumanComparatorByAge<G extends GeneralTree<G>> implements Comparator<G> {

    @Override
    public int compare(G o1, G o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
