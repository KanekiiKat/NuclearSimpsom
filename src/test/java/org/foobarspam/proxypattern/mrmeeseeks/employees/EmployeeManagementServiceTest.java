package org.foobarspam.proxypattern.mrmeeseeks.employees;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class EmployeeManagementServiceTest {

    EmployeeManagementService employeeService = new EmployeeManagementServiceImpl();



    @Before
    public void EmployeeManagementServiceTest(){
        employeeService.employeeClear();
        assertEquals(0, employeeService.crewSize());
    }

    @Test
    public void EmployeeTest(){

        Employee homer = employeeService.createEmployee("Homer Simpson", 1, Department.REACTOR_CONTROL, ExperienceLevel.NOVATO, Shift.MORNING);
        Employee lenny = employeeService.createEmployee("Lenny Leonard", 2, Department.SECURITY,  ExperienceLevel.INTERMEDIO, Shift.AFTERNOON);

        assertEquals("Homer Simpson", homer.getName());
        assertEquals("Seguridad", lenny.getdepartment().getName());
    }
    
    @Test
    public void crewSizeTest(){

        Employee homer = employeeService.createEmployee("Homer Simpson", 1, Department.REACTOR_CONTROL, ExperienceLevel.NOVATO, Shift.MORNING);
        Employee carl = employeeService.createEmployee("Carl Carlson", 3, Department.MAINTENANCE, ExperienceLevel.INTERMEDIO, Shift.NIGHT);
        Employee smithers = employeeService.createEmployee("Smithers", 4, Department.ADMINISTRATION, ExperienceLevel.EXPERTO, Shift.MORNING);

        assertEquals(3, employeeService.crewSize());
        employeeService.employeeClear();
        assertEquals(0, employeeService.crewSize());
    }

    @Test
    public void employeeForDepartament(){
        List<Employee> employeeList = employeeService.findEmployeesByDepartment(Department.ADMINISTRATION);

        Employee homer = employeeService.createEmployee("Homer Simpson", 1, Department.REACTOR_CONTROL, ExperienceLevel.NOVATO, Shift.MORNING);
        Employee carl = employeeService.createEmployee("Carl Carlson", 3, Department.MAINTENANCE, ExperienceLevel.INTERMEDIO, Shift.NIGHT);
        Employee smithers = employeeService.createEmployee("Smithers", 4, Department.ADMINISTRATION, ExperienceLevel.EXPERTO, Shift.MORNING);

        for (Employee employee : employeeList){
            assertEquals(smithers.getName(), employee.getName());
        }
    }

    @Test
    public void changeEmployeeExperienceLevelTest(){
        Employee homer = employeeService.createEmployee("Homer Simpson", 1, Department.REACTOR_CONTROL, ExperienceLevel.NOVATO, Shift.MORNING);

        assertEquals(ExperienceLevel.NOVATO, homer.getExperienceLevel());

        employeeService.changeEmployeeExperienceLevel(homer, ExperienceLevel.INTERMEDIO);

        assertEquals(ExperienceLevel.INTERMEDIO, homer.getExperienceLevel());

    }

    @Test
    public void getExperienceLevelStatisticsTest(){
        Employee carl = employeeService.createEmployee("Carl Carlson", 3, Department.MAINTENANCE, ExperienceLevel.INTERMEDIO, Shift.NIGHT);
        
        
        assertEquals(Long.valueOf(0), employeeService.getExperienceLevelStatistics().get("Novato"));
        assertEquals(Long.valueOf(1), employeeService.getExperienceLevelStatistics().get("Intermedio"));
        assertEquals(Long.valueOf(0), employeeService.getExperienceLevelStatistics().get("Experto"));

        employeeService.changeEmployeeExperienceLevel(carl, ExperienceLevel.EXPERTO);
        
        assertEquals(Long.valueOf(0), employeeService.getExperienceLevelStatistics().get("Novato"));
        assertEquals(Long.valueOf(0), employeeService.getExperienceLevelStatistics().get("Intermedio"));
        assertEquals(Long.valueOf(1), employeeService.getExperienceLevelStatistics().get("Experto"));
    }


}
