package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private final List<Human> humanList;

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
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }
    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }
    public String toString(){
        return humanList.toString();
    }
}
