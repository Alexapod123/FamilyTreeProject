package family_tree.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.comparators.HumanComparatorByAge;
import family_tree.comparators.HumanComparatorByName;
import family_tree.human.Human;
import family_tree.human.HumanIterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private final List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getTree() {
        return humanList;
    }

    public String toString() {
        return humanList.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
