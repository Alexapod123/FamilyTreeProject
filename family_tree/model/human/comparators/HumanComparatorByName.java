package family_tree.model.human.comparators;

import java.util.Comparator;

import family_tree.model.tree.GeneralTree;

public class HumanComparatorByName<G extends GeneralTree<G>> implements Comparator<G> {

    @Override
    public int compare(G o1, G o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
