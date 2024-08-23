package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddParent extends Command{
    public AddParent(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить родителя";
    }

    @Override
    public void execute() {
        consoleUI.addParent();
    }

}
