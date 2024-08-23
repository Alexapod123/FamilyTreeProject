package family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.human.HumanIterator;
import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends GeneralTree<E>> implements Serializable, Iterable<E> {
    private final List<E> humanList;

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        humanList = new ArrayList<>();
    }

    public boolean add(E human) {
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

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }
    public E getById(int id){
        for(E human : humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<E> getTree() {
        return humanList;
    }

    public String toString() {
        return humanList.toString();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new HumanIterator(humanList);
    }
}
