package org.foobarspam.proxypattern.mrmeeseeks.employees;

public enum Department {
    
    REACTOR_CONTROL("Control de Reactor"),
    SECURITY("Seguridad"),
    MAINTENANCE("Mantenimiento"),
    ADMINISTRATION("Administracion");


    private final String name;

    private Department(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
