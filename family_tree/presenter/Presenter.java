package family_tree.presenter;

import java.io.IOException;
import java.time.LocalDate;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.readAndDownload.FileHandler;
import family_tree.model.tree.FamilyTree;
import family_tree.model.tree.Service;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;
    private FileHandler fh;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        fh = new FileHandler();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name, gender, birthDate);
        getFamilyTreeInfo();
    }

    public boolean addParent(String childName, String parentName) {
        return service.addParent(childName, parentName);
    }

    public boolean addParent(int childId, int parentId) {
        return service.addParent(childId, parentId);
    }

    public boolean addChild(String parentName, String childName) {
        return service.addChild(parentName, childName);
    }

    public boolean addChild(int parentId, int childId) {
        return service.addChild(parentId, childId);
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        FamilyTree<Human> familyTree = service.getFamilyTree();
        view.printAnswer(familyTree.toString());
    }

    public boolean saveFamilyTree(String nameFile) throws IOException {
        return fh.saveFamilyTree(nameFile, service.getFamilyTree());
    }

    @SuppressWarnings("unchecked")
    public boolean downloadFamilyTree(String nameFile) throws ClassNotFoundException, IOException {
        fh.downloadFamilyTree(nameFile);
        service.setFamilyTree(fh.downloadFamilyTree(nameFile));
        if (service.getFamilyTree().equals(null))
            return false;
        else
            return true;
    }

}
