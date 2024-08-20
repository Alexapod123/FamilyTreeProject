package family_tree.tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface GeneralTree <G> extends Serializable{
    String getName();
    LocalDate getBirthDate();
    G getFather();
    G getMother();
    boolean addChild (G human);
    boolean addParent (G human);
    List <G> getChildren();
    List <G> getParents();


}
