package family_tree;

import java.io.IOException;
import java.util.List;

public interface Write {

    void saveFamilyTree(String nameFile, List<Human> humanList) throws IOException;

    FamilyTree downloadFamilyTree(String nameFile) throws IOException, ClassNotFoundException;

}