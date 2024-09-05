package family_tree.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import family_tree.model.human.Gender;
import family_tree.model.tree.Service;
import family_tree.presenter.Presenter;

public class ConsoleUI implements View {
    private static final String error = "Ошибочный ввод!!!";
    private Scanner scanner;
    private Presenter presenter;
    private boolean isWork;
    private MainMenu menu;
    private Service service;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        isWork = true;
        menu = new MainMenu(this);
        service = new Service();

    }

    @Override
    public void start() {
        hello();
        while (isWork) {
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void hello() {
        printAnswer("Приветствуем!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkInput(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        printAnswer(error);

    }

    private boolean checkInput(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    public void finish() {
        printAnswer("До свидания");
        isWork = false;
    }

    public void addHuman() {
        String name;
        Gender gender;
        LocalDate birthDate;
        String dateForm = "dd.MM.yyyy";
        printAnswer("Введите имя:");
        name = scanner.nextLine();
        printAnswer("Укажите пол\n1 - мужской, 2- женский");
        String gend = scanner.nextLine();
        while (!(gend.charAt(0) == '1' || gend.charAt(0) == '2')) {
            inputError();
            printAnswer("Укажите пол\n1 - мужской, 2- женский");
            gend = scanner.nextLine();
        }
        if (gend.equals("1"))
            gender = Gender.Male;
        else
            gender = Gender.Female;

        printAnswer("Введите дату рождения в формате " + dateForm);
        String strDate = scanner.nextLine();
        while (strDate.length() != 10 && strDate.split(".").length != 3) {
            inputError();
            printAnswer("Введите дату рождения в формате " + dateForm);
            strDate = scanner.nextLine();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateForm);
        birthDate = LocalDate.parse(strDate, dateTimeFormatter);
        presenter.addHuman(name, gender, birthDate);
    }

    public void addParent() {
        String childName, parentName;
        int childId, parentId;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите имя ребёнка");
            childName = scanner.nextLine();
            printAnswer("Введите имя родителя");
            parentName = scanner.nextLine();
            presenter.addParent(childName, parentName);
        } else {
            printAnswer("Введите id ребёнка");
            childId = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите id родителя");
            parentId = Integer.parseInt(scanner.nextLine());
            presenter.addParent(childId, parentId);
        }
        presenter.getFamilyTreeInfo();
    }

    public void addChild() {
        String childName, parentName;
        int childId, parentId;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите имя родителя");
            parentName = scanner.nextLine();
            printAnswer("Введите имя ребёнка");
            childName = scanner.nextLine();
            presenter.addChild(parentName, childName);
        } else {
            printAnswer("Введите id родителя");
            parentId = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите id ребёнка");
            childId = Integer.parseInt(scanner.nextLine());
            presenter.addChild(parentId, childId);
        }
        presenter.getFamilyTreeInfo();
    }

    public void getFamilyTreeinfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void save() throws IOException {
        String filename;
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        if (service.saveFamilyTree(filename))
            printAnswer("Файл " + filename + " сохранен");
        else
            printAnswer("Ошибка сохранения");
    }
    public void download() throws ClassNotFoundException, IOException {
        String filename;
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        if (service.downloadFamilyTree(filename))
            printAnswer("Файл " + filename + " успешно загружен");
        else
            printAnswer("Ошибка загрузки");
    }

}
