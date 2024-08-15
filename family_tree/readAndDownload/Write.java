package family_tree.readAndDownload;

import java.io.IOException;
import java.util.List;

import family_tree.human.Human;
import family_tree.tree.FamilyTree;

public interface Write {

    void saveFamilyTree(String nameFile, List<Human> humanList) throws IOException;

    FamilyTree downloadFamilyTree(String nameFile) throws IOException, ClassNotFoundException;

}