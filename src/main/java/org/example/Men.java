package org.example;

public class Men extends Person {
    private Woman partner;
    private static final int RESTRICTED_AGE = 65;

    public Men(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        partner = null;
    }

    public Woman getPartner() {
        return partner;
    }

    public void setPartner(Woman partner) {
        this.partner = partner;
    }

    @Override
    public boolean isRetired() {
        return super.getAge() >= RESTRICTED_AGE;
    }

    public void registerPartnership(Woman newPartner) {
        if (partner == null && newPartner.getPartner() == null) {
            partner = newPartner;
            newPartner.setPartner(this);
            newPartner.setLastName(super.getLastName());
        } else {
            System.out.println("Someone among the partners has an undissolved marriage");
        }
    }

    @Override
    public void deregisterPartnership() {
        getPartner().setLastName(getPartner().getMaidenName());
        getPartner().setPartner(null);
        partner = null;
    }
}

