# Codificación en Java de la entidad `Employee`

## Codificación

Escribe en un folio la codificación de la clase `Employee` siguiendo esta descripción.

## Descripción de la Clase Employee

La clase `Employee` representa a un empleado de la central nuclear de Springfield. Es una clase final que encapsula la información básica de un empleado.

## Paquete

`com.springfield.powerplant.model`

## Propiedades de instancia

Declara las propiedades del tipo de dato que estimes adecuado cuando no se indica ninguno (señalado con -):

| Atributo | Tipo | Modificador | Descripción |
|----------|------|-------------|-------------|
| name | - | - | Nombre de la empleada |
| id | - | - | Identificador único de la empleada |
| department | Department | - | Departamento al que pertenece la empleada |
| experienceLevel | ExperienceLevel | - | Nivel de experiencia de la empleada |
| shift | Shift | - | Turno de trabajo de la empleada |

## Interfaz (métodos)

### Constructor

- Crea una nueva instancia de Employee.
- Valida que el parámetro `id` no sea nulo.
- Parámetros:
  - `name`: nombre del empleado
  - `id`: identificador único
  - `department`: departamento asignado
  - `experienceLevel`: nivel de experiencia
  - `shift`: turno de trabajo

### Getters

_Getters_ de:

- `name`: nombre del empleado
- `id`: identificador único
- `department`: departamento asignado
- `experienceLevel`: nivel de experiencia
- `shift`: turno de trabajo

### Setters

_Setter_ de:

- `experienceLevel`: nivel de experiencia

### Métodos

```java
toString()
```
- Retorna una representación en `String` del empleado
- Formato: "nombre (ID: id, Nivel: nivel, Turno: turno)"

## Relaciones

- La clase `Employee` tiene una relación _HAS-A_ con los tipos enumerados:
  - `Department`
  - `ExperienceLevel`
  - `Shift`

## Notas de Implementación

- La clase es final, lo que significa que no puede ser extendida.
- El ID es inmutable.
- El parámetro del constructor `id` es validado contra nulos.
- La igualdad entre empleados se basa únicamente en su ID. 