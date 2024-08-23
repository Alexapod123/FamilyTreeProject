package family_tree.model.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder {
    private int nId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    @SuppressWarnings("unused")
    private List<Human> children;

    public HumanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    private void setChildren() {
        human.setChildren(new ArrayList<>());
    }

    public HumanBuilder() {
        makeHuman();
    }

    private void makeHuman() {
        human = new Human(name, gender, birthDate);
    }

    private void nextId() {
        human.setId(nId++);
    }

    private void makeName() {
        human.setName(name);
    }

    private void makeGender() {
        human.setGender(gender);
    }

    private void makeBirthDate() {
        human.setBirthDate(birthDate);
    }

    public Human build() {
        makeHuman();
        makeName();
        makeGender();
        makeBirthDate();
        nextId();
        setChildren();
        return human;
    }

}
