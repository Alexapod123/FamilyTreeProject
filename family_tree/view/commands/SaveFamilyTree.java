package family_tree.view.commands;

import java.io.IOException;

import family_tree.view.ConsoleUI;

public class SaveFamilyTree extends Command{
     public SaveFamilyTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
       try {
        extracted();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    private void extracted() throws IOException {
        consoleUI.save();
    }

}
