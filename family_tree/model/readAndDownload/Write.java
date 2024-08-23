package family_tree.model.readAndDownload;

import java.io.IOException;


import family_tree.model.human.Human;
import family_tree.model.tree.FamilyTree;

public interface Write {

    boolean saveFamilyTree(String nameFile, FamilyTree<Human>familyTree) throws IOException;

    @SuppressWarnings("rawtypes")
    FamilyTree downloadFamilyTree(String nameFile) throws IOException, ClassNotFoundException;

}