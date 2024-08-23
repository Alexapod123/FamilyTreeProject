package family_tree.model.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GeneralTree <G> extends Serializable{
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();
    G getFather();
    G getMother();
    boolean addChild (G human);
    boolean addParent (G human);
    List <G> getChildren();
    List <G> getParents();
    int getAge();
    int getId();


}
