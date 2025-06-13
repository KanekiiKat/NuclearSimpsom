package org.foobarspam.proxypattern.mrmeeseeks.employees;

public class Employee {
    
    private String name = "";
    private final  int ID;
    private Department department;
    private Shift shift;
    private ExperienceLevel experienceLevel;


    public Employee(String name, int ID, Department department, Shift shift, ExperienceLevel experienceLevel){
        this.name = name;
        this.ID = ID;
        this.department = department;
        this.shift = shift;
        this.experienceLevel = experienceLevel;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

    public Department getdepartment() {
        return this.department;
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
        return getName() + "\s(ID:\s" + getID() + "\sNivel:\s" + getExperienceLevel().getName() + "\sTurno:\s"
                + getShift().getName() + "\s)";
    }
}
