package org.foobarspam.proxypattern.mrmeeseeks.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    List<Employee> employeesList = new ArrayList<>();

    public EmployeeManagementServiceImpl(){}

    @Override
    public Employee createEmployee(String name, int ID, Department departament, ExperienceLevel experience, Shift shift){
        Employee employee = new Employee(name, ID, departament, shift, experience);
        this.addEmployee(employee);
        this.display(employee);
        return employee;
    }

    @Override
    public void addEmployee(Employee employee){
        this.employeesList.add(employee);
    }

    @Override
    public void employeeClear(){
        this.employeesList.clear();
    }


    @Override
    public int crewSize(){
        return employeesList.size();
    }

    @Override
    public void display(Employee employee){
        System.out.println("Empleado " + employee.getName() + "asignado al departamento " + employee.getdepartment().getName());
    }

    @Override
    public void listCrew(){
        for (Employee employee : employeesList){
            System.out.println(employee.toString());
        }
    }
}
