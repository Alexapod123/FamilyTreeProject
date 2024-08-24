package family_tree.model.tree;

import java.time.LocalDate;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanBuilder;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder hb;

    public Service() {
        familyTree = new FamilyTree<>();
        hb = new HumanBuilder();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = hb.setName(name).setGender(gender).setBirthDate(birthDate).build();
        familyTree.add(human);
    }

    public boolean addChild(String human, String child) {
        return ((Human) familyTree.getByName(human)).addChild((Human) familyTree.getByName(child));
    }

    public boolean addChild(int idHuman, int idChild) {
        return familyTree.getById(idHuman).addChild(familyTree.getById(idChild));
    }

    public boolean addParent(String child, String parent) {
        return ((Human) familyTree.getByName(child)).addParent((Human) familyTree.getByName(parent));
    }

    public boolean addParent(int child, int parent) {
        return familyTree.getById(child).addParent(familyTree.getById(parent));
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

}
