package org.example;

public abstract class Person {
    private final String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void happyBirthday() {
        age++;
        System.out.println("Happy Birthday! Celebrate your new..." + age);
    }


    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String introduce() {
        return "Hi, my name is:" + firstName + " " + lastName;
    }

    abstract boolean isRetired();

    abstract void deregisterPartnership();

    public void setAge(int age) {
    }
}