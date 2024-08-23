package family_tree.view.commands;

import java.io.IOException;

import family_tree.view.ConsoleUI;

public class DownloadFamilyTree extends Command {
    public DownloadFamilyTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Загрузить из файла";
    }

    @Override
    public void execute() {
        try {
            consoleUI.download();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
