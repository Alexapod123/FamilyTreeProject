package family_tree.model.tree;

import java.io.IOException;
import java.time.LocalDate;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanBuilder;
import family_tree.model.readAndDownload.FileHandler;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder hb;
    private FileHandler fh;

    public Service() {
        familyTree = new FamilyTree<>();
        hb = new HumanBuilder();
        fh = new FileHandler();
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
        return (familyTree.getByName(human)).addChild(familyTree.getByName(child));
    }

    public boolean addChild(int idHuman, int idChild) {
        return familyTree.getById(idHuman).addChild(familyTree.getById(idChild));
    }

    public boolean addParent(String child, String parent) {
        return (familyTree.getByName(child)).addParent(familyTree.getByName(parent));
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

    public boolean saveFamilyTree(String nameFile) throws IOException {
        return fh.saveFamilyTree(nameFile, familyTree);
    }

    public boolean downloadFamilyTree(String nameFile) throws ClassNotFoundException, IOException {
        fh.downloadFamilyTree(nameFile);
        if (familyTree.equals(null))
            return false;
        else
            return true;
    }

}
