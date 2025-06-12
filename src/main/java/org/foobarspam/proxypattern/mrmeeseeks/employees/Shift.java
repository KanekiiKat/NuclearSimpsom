package org.foobarspam.proxypattern.mrmeeseeks.employees;

public enum Shift {

    MAÑANA("Mañana"),
    TARDE("Tarde"),
    NOCHE("Noche");

    private final String name;

    private Shift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}