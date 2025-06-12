package org.foobarspam.proxypattern.mrmeeseeks.employees;

public class Employee {
    
    private String name = "";
    private final  int ID;
    private Departament departament;
    private Shift shift;
    private ExperienceLevel experienceLevel;


    public Employee(String name, int ID){
        this.name = name;
        this.ID = ID;

        this.shift = shift;
        this.experienceLevel = experienceLevel;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public Departament getDepartament() {
        return this.departament;
    }

    public Shift getShift() {
        return this.shift;
    }

    public ExperienceLevel getExperienceLevel() {
        return this.experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString() {
        return this.name + "\s(ID:\s" + this.ID + "\sNivel:\s" + getExperienceLevel().getName() + "\sTurno:\s"
                + getShift().getName() + "\s)";
    }
}
