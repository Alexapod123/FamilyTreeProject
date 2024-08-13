package family_tree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class FileHandler implements  Write {
    @Override
    public void saveFamilyTree(String nameFile, List<Human> family) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nameFile))){
            oos.writeObject(family);
            oos.close();
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public FamilyTree downloadFamilyTree(String nameFile) throws IOException, ClassNotFoundException{
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nameFile));
        List<Human>family=(List<Human>)ois.readObject();
        ois.close();
        FamilyTree downloadTree=new FamilyTree(family);
        return downloadTree;
       
 
    }
}
