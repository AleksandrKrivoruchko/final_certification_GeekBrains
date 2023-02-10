package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PetAnimal extends Animal implements IAnimal{
    private int age;

    public PetAnimal(String animal, String name, Date birthday) {
        super();
        super.setAnimal(animal);
        super.setName(name);
        super.setBirthday(birthday);
        setAge();
    }

    public PetAnimal(String animal, String name, String birthday) {
        super();
        super.setAnimal(animal);
        super.setName(name);
        super.setBirthday(birthday);
        setAge();
    }

    public int getAge() {
        return age;
    }

    private void setAge() {
        Date thisDay = new Date();
        age = getYear(thisDay) - getYear(this.getBirthday());
    }

    private int getYear(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        return Integer.parseInt(format.format(date));
    }

    private int getMonth(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("M");
        return Integer.parseInt(format.format(date));
    }

    public String toString() {
        return String.format("Животное: %s  Имя: %s  дата рождения: %s",
                this.getAnimal(), this.getName(), this.formatDate());
    }
}
