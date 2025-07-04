package org.foobarspam.proxypattern.mrmeeseeks.employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    List<Employee> employeesList = new ArrayList<>();

    public EmployeeManagementServiceImpl(){}

    @Override
    public Employee createEmployee(String name, int ID, Department departament, ExperienceLevel experience, Shift shift){
        Employee employee = new Employee(name, ID, departament, shift, experience);
        for (Employee employeeInList : employeesList){
            if (employeeInList.getID() == ID){
                throw new IllegalArgumentException("El ID " + ID + " ya está en uso");
            } 
        }
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
    
    @Override
    public List<Employee> findEmployeesByDepartment(Department department){
        List<Employee> employeesDepartament = new ArrayList<>();
        for (Employee employee : employeesList){
            if (employee.getdepartment().equals(department)){
                employeesDepartament.add(employee);
            }
        }
        return employeesDepartament;
    }

    @Override
    public void changeEmployeeExperienceLevel(Employee employee, ExperienceLevel experience){
        int numEmployee = employeesList.indexOf(employee);

        employee.setExperienceLevel(experience);

        employeesList.set(numEmployee, employee);

    }

    @Override
    public Map<String, Long> getExperienceLevelStatistics(){

        Map<String, Long> experienceLevelsMap = new HashMap<>();
        
        int countNovatos = 0;
        int countIntermedios = 0;
        int countExpertos = 0;

        
        for (Employee employee : employeesList){
                if (employee.getExperienceLevel().equals(ExperienceLevel.NOVATO)){
                    countNovatos++;
                }
                if (employee.getExperienceLevel().equals(ExperienceLevel.INTERMEDIO)){
                    countIntermedios++;
                }
                if (employee.getExperienceLevel().equals(ExperienceLevel.EXPERTO)){
                    countExpertos++;
                }
        }

        experienceLevelsMap.put(ExperienceLevel.NOVATO.getName(), Long.valueOf(countNovatos));
        experienceLevelsMap.put(ExperienceLevel.INTERMEDIO.getName(), Long.valueOf(countIntermedios));
        experienceLevelsMap.put(ExperienceLevel.EXPERTO.getName(), Long.valueOf(countExpertos));

        return experienceLevelsMap;

    }

    @Override
    public Boolean isDepartmentFullyCovered(Department department){
    boolean bmoring = false;
    boolean bafternoon = false;
    boolean bnigth = false;

        for (Employee employee : employeesList){
            if (employee.getdepartment().equals(department)){
                if (employee.getShift().equals(Shift.MORNING)){
                    bmoring = true;
                } else if (employee.getShift().equals(Shift.AFTERNOON)){
                    bafternoon = true;
                } else if (employee.getShift().equals(Shift.NIGHT)){
                    bnigth = true;
                }
            }
        }
        
        if (bmoring && bafternoon && bnigth){
            return true;
        } else {
            return false;
        }
    }
    

}
