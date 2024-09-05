package family_tree.model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.human.HumanIterator;
import family_tree.model.human.comparators.HumanComparatorByAge;
import family_tree.model.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends GeneralTree<E>> implements Serializable, Iterable<E> {
    private List<E> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(E human) {

        this.familyTree.add(human);
    }

    public E getByName(String name) {
        for (E human :familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
        
    }
    public E getById(int id){
        for(E human :familyTree){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<E> getTree() {
        return familyTree;
    }

    public String toString() {
        return familyTree.toString();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void sortByName() {
       familyTree.sort(new HumanComparatorByName());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void sortByAge() {
       familyTree.sort(new HumanComparatorByAge());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new HumanIterator(familyTree);
    }
}
