package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PetAnimal extends Animal implements IAnimal{
    private int age;

    public PetAnimal(String name, Date birthday) {
        super();
        super.setName(name);
        super.setBirthday(birthday);
        setAge();
    }

    public PetAnimal(String name, String birthday) {
        super();
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
}
