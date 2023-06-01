package org.example;

public class Woman extends Person {
    private Men partner;
    private String maidenName;
    private static final int RESTRICTED_AGE = 60;


    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.maidenName = lastName;
        this.partner = null;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public boolean isRetired() {
        return super.getAge() >= RESTRICTED_AGE;
    }

    @Override
    public String introduce() {
        return "Nice to meet you";
    }

    public String introduceSuper() {
        super.introduce();
        return "Nice to meet you";
    }


    public Men getPartner() {
        return partner;
    }

    public void setPartner(Men partner) {
        this.partner = partner;
    }

    public void registerPartnership(Men newPartner) {
        if (partner == null && newPartner.getPartner() == null) {
            partner = newPartner;
            newPartner.setPartner(this);
            setLastName(newPartner.getLastName());
            System.out.println("lastname is changing for " + newPartner.getLastName());
        } else {
            System.out.println("Someone among the partners has an undissolved marriage");
        }
    }

    @Override
    public void deregisterPartnership() {
        getPartner().setPartner(null);
        partner = null;
        this.setLastName(maidenName);
    }

    public void setAge(int age) {
    }
}
