package family_tree.model.human.comparators;

import java.util.Comparator;

import family_tree.model.tree.GeneralTree;

public class HumanComparatorByAge<G extends GeneralTree<G>> implements Comparator<G> {

    @Override
    public int compare(G o1, G o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
