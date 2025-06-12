```java

package com.springfield.powerplant;

import com.springfield.powerplant.model.Department;
import com.springfield.powerplant.model.Employee;
import com.springfield.powerplant.model.ExperienceLevel;
import com.springfield.powerplant.model.Shift;
import com.springfield.powerplant.service.EmployeeManagementService;
import com.springfield.powerplant.service.impl.EmployeeManagementServiceImpl;

import java.util.List;
import java.util.Map;

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

        /*
         * Historia de Usuario 5: Estadísticas por nivel de experiencia
         * getExperienceLevelStatistics() devuelve un mapa 
         * con el nivel de experiencia y el número de empleados en ese nivel
         */

        System.out.println("\n4. Estadísticas por nivel de experiencia:\n");
        Map<String, Long> experienceStats = employeeService.getExperienceLevelStatistics();
        experienceStats.forEach((level, count) -> 
            System.out.println(level + ": " + count + " empleados"));

        /* 
         * Historia de Usuario 6: Verificar cobertura de turnos
         * Verifica si cada departamento tiene los 4 turnos cubiertos
        */

        System.out.println("\n5. Verificando cobertura de turnos...\n");
        for (Department department : Department.values()) {
            boolean isFullyCovered = employeeService.isDepartmentFullyCovered(department);
            System.out.println("Departamento " + department + ": " + 
                (isFullyCovered ? "Cubierto en todos los turnos" : "No cubierto en todos los turnos"));
        }
    }
} 
```