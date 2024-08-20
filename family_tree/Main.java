package family_tree;

import java.io.IOException;
import java.time.LocalDate;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.readAndDownload.FileHandler;
import family_tree.tree.FamilyTree;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String nameFile = "familyTree.txt";
        FamilyTree<Human> tree = testTree();
        // System.out.println(tree);
        FileHandler fh = new FileHandler();
        // fh.saveFamilyTree(nameFile, tree.getTree());
        // System.out.println(fh.downloadFamilyTree(nameFile));
        System.out.println(getInfoFamily());
        tree.sortByName();
        System.out.println(tree);
        tree.sortByAge();
        System.out.println(tree);
    }

    static FamilyTree<Human> testTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human vanya = new Human("Ivan", Gender.Male, LocalDate.of(1975, 6, 02), null, null, null);
        Human alena = new Human("Alena", Gender.Female, LocalDate.of(1980, 7, 03), null, null, null);
        tree.add(vanya);
        tree.add(alena);
        Human kira = new Human("Kira", Gender.Female, LocalDate.of(1999, 8, 5), null, alena, vanya);
        Human igor = new Human("Igor", Gender.Male, LocalDate.of(2002, 3, 16), null, alena, vanya);
        tree.add(kira);
        tree.add(igor);
        Human grandMother = new Human("Victoria", Gender.Female, LocalDate.of(1956, 6, 02), null, null, null);
        grandMother.addChild(alena);
        tree.add(grandMother);
        return tree;
    }

    public static String getInfoFamily() {
        StringBuilder sb = new StringBuilder();
        sb.append("Члены семьи: ");
        sb.append("\n");
        for (Human human : (testTree())) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
