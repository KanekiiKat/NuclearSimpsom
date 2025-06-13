package org.foobarspam.proxypattern.mrmeeseeks;


import java.util.List;

import org.foobarspam.proxypattern.mrmeeseeks.employees.Department;
import org.foobarspam.proxypattern.mrmeeseeks.employees.Employee;
import org.foobarspam.proxypattern.mrmeeseeks.employees.EmployeeManagementService;
import org.foobarspam.proxypattern.mrmeeseeks.employees.EmployeeManagementServiceImpl;
import org.foobarspam.proxypattern.mrmeeseeks.employees.ExperienceLevel;
import org.foobarspam.proxypattern.mrmeeseeks.employees.Shift;

public class App {
    public static void main(String[] args) {

        System.out.println("=== Springfield Power Plant Employee Management System ===\n");

        // Inicializa el servicio de gestión de empleados
        EmployeeManagementService employeeService = new EmployeeManagementServiceImpl();

        /* 
         * Historia de Usuario 1: Crear personas empleadas y asignarlas a departamentos
         * Crea los 4 departamentos indicados
         * Crea los 3 niveles de experiencia indicados
         * Crea los 4 turnos indicados
         * Crea los 4 empleados indicados
         * Añade los empleados a la plantilla
         */
        
        System.out.println("1. Creando empleados y asignándolos a departamentos...\n");

        Employee homer = employeeService.createEmployee("Homer Simpson", 1, Department.REACTOR_CONTROL, 
            ExperienceLevel.NOVATO, Shift.MORNING);
        Employee lenny = employeeService.createEmployee("Lenny Leonard", 2, Department.SECURITY, 
            ExperienceLevel.INTERMEDIO, Shift.AFTERNOON);
        Employee carl = employeeService.createEmployee("Carl Carlson", 3, Department.MAINTENANCE, 
            ExperienceLevel.INTERMEDIO, Shift.NIGHT);
        Employee smithers = employeeService.createEmployee("Smithers", 4, Department.ADMINISTRATION, 
            ExperienceLevel.EXPERTO, Shift.MORNING);

        // Visualiza el numero de personas empleadas en plantilla
        System.out.println("""
                              \n2. Usuarios creados:
                                                """);
        System.err.println("""
                Empleados dados de alta: %d
                """.formatted(employeeService.crewSize()));

        /*
         * Muestra el listado de empleadas con su info
         */
        employeeService.listCrew();

        /* 
         * Historia de Usuario 3: Buscar empleadas por departamento
         */
        System.out.println("\n3. Buscando empleados por departamento...\n");
        List<Employee> reactorEmployees = employeeService.findEmployeesByDepartment(Department.REACTOR_CONTROL);
        System.out.println("Empleados en Control de Reactor:");
        reactorEmployees.forEach(employee -> 
            System.out.println("- " + employee.toString()));
        
       /*
         * Historia de Usuario 4: cambio de experiencia
         * Cambia el nivel de experiencia de un empleado
         * Carl cambia de INTERMEDIO a EXPERTO
         */
        System.out.println("\n4. Cambio de experiencia...\n");
        employeeService.changeEmployeeExperienceLevel(carl, ExperienceLevel.EXPERTO);
        System.out.println("Empleado " + carl.getName() + " cambió su nivel de experiencia a " + carl.getExperienceLevel().name());
        System.out.println("Empleado " + carl.toString());


    }
}
