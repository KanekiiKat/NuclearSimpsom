package org.foobarspam.proxypattern.mrmeeseeks.employees;
import java.util.List;
import java.util.Map;

public interface EmployeeManagementService {

    Employee createEmployee(String name, int ID, Department department, ExperienceLevel experience, Shift shift);
    int crewSize();
    void addEmployee(Employee employee);
    void display(Employee employee);
    void employeeClear();
    void listCrew();
    List<Employee> findEmployeesByDepartment(Department department);
    void changeEmployeeExperienceLevel(Employee employee, ExperienceLevel newExperienceLevel);
    Map<String, Long> getExperienceLevelStatistics();
    Boolean isDepartmentFullyCovered(Department department);
}
