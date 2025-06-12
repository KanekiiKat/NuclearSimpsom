package org.foobarspam.proxypattern.mrmeeseeks.employees;

public interface EmployeeManagementService {

    Employee createEmployee(String name, int ID, Department department, ExperienceLevel experience, Shift shift);
    int crewSize();
    void addEmployee(Employee employee);
    void display(Employee employee);
    void employeeClear();
    void listCrew();
}
