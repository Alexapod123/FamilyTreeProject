package family_tree.view;

import java.util.ArrayList;
import java.util.List;

import family_tree.view.commands.AddChild;
import family_tree.view.commands.AddHuman;
import family_tree.view.commands.AddParent;
import family_tree.view.commands.Command;
import family_tree.view.commands.DownloadFamilyTree;
import family_tree.view.commands.Finish;
import family_tree.view.commands.GetFamilyTreeInfo;
import family_tree.view.commands.SaveFamilyTree;
import family_tree.view.commands.SortByAge;
import family_tree.view.commands.SortByName;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddParent(consoleUI));
        commandList.add(new AddChild(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add((new GetFamilyTreeInfo(consoleUI)));
        commandList.add((new SaveFamilyTree(consoleUI)));
        commandList.add((new DownloadFamilyTree(consoleUI)));
        commandList.add((new Finish(consoleUI)));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}
