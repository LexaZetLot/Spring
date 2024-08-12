package org.example;

public class Singer {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString(){
        return "\tName: " + name + "\n\t" + "Age: " + age;
    }
}
