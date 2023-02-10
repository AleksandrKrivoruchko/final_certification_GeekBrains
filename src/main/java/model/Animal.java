package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Animal {
    private String animal;
    private String name;
    private Date birthday;

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBirthday(String birthday) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date date = format.parse(birthday);
            this.birthday = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String formatDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.format(birthday);
    }
}
