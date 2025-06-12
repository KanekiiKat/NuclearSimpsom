package org.foobarspam.proxypattern.mrmeeseeks.employees;

public enum Departament {
    
    CONTROL_REACTOR("Control de Reactor"),
    SEGURIDAD("Seguridad"),
    MANTENIMIENTO("Mantenimiento"),
    ADMINISTRACION("Administracion");


    private String name;

    private Departament(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
