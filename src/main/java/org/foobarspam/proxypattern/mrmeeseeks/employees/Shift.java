package org.foobarspam.proxypattern.mrmeeseeks.employees;

public enum Shift {

    MORNING("Mañana"),
    AFTERNOON("Tarde"),
    NIGHT("Noche");

    private final String name;

    private Shift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}