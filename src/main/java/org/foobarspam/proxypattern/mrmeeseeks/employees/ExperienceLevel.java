package org.foobarspam.proxypattern.mrmeeseeks.employees;

public enum ExperienceLevel {

    NOVATO("Novato"),
    INTERMEDIO("Intermedio"),
    EXPERTO("Experto");

    private final String name;

    private ExperienceLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}