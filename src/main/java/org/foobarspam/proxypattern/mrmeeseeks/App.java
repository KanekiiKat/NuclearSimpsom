package org.foobarspam.proxypattern.mrmeeseeks;


import org.foobarspam.proxypattern.mrmeeseeks.employees.*;

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
    }
}
