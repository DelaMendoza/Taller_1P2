
package servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.enums.EstadoCita;
import modelo.hospital.CitaMedica;
import modelo.hospital.Especialidad;
import modelo.hospital.Hospital;
import modelo.personas.Medico;
import modelo.personas.Paciente;
import modelo.personas.Cirujano;
import modelo.personas.Enfermero;
import modelo.enums.Turno;


public class Servicios {

    private static Scanner entrada = new Scanner(System.in);
    private static List<Paciente> pacientes = new ArrayList<>();
    private static Hospital hospital = new Hospital("Hospital Los Castillos", "Calle 2913");

    public static void menuPacientes() {

        System.out.println("==== GESTION DE PACIENTES ====");
        System.out.println("1. Registrar Paciente");
        System.out.println("2. Volver");
        System.out.print("Seleccione una opcion: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
                registrarPaciente();
                break;
            case 2:
                return;
            default:
                System.out.println("Opcion no valida");
        }
    }

    private static void registrarPaciente() {

        System.out.println("=== REGISTRO DE PACIENTE ===");

        System.out.print("ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("Email: ");
        String email = entrada.nextLine();

        System.out.print("Historia Clinica ID: ");
        String historiaID = entrada.nextLine();

        System.out.print("Grupo sanguineo: ");
        String grupo = entrada.nextLine();

        LocalDate fechaNacimiento = leerFecha("Fecha de nacimiento (YYYY-MM-DD): ");

        Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, email, historiaID, grupo);

        System.out.print("¿Agregar alergias? (si/no): ");
        String resp = entrada.nextLine();

        while (resp.equalsIgnoreCase("si")) {
            System.out.print("Ingrese alergia: ");
            paciente.agregarAlergia(entrada.nextLine());

            System.out.print("¿Otra alergia? (si/no): ");
            resp = entrada.nextLine();
        }
        pacientes.add(paciente);
        System.out.println("Paciente registrado correctamente");
    }

    public static void menuEmpleados() {

        System.out.println("==== GESTION DE PERSONAL ====");
        System.out.println("1. Medico");
        System.out.println("2. Cirujano");
        System.out.println("3. Enfermero");
        System.out.println("4. Volver");
        System.out.print("Seleccione: ");

        int opcion = entrada.nextInt();
        entrada.nextLine();

        if (opcion == 4) {
            return;
        }

        System.out.print("Ingrese el ID: ");
        int id = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Ingrese el Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese el Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("Ingrese el Email: ");
        String email = entrada.nextLine();

        System.out.print("Ingrese el Legajo: ");
        String legajo = entrada.nextLine();

        System.out.print("Ingrese el Salario base: ");
        double salario = entrada.nextDouble();
        entrada.nextLine();

        LocalDate fechaNacimiento = leerFecha("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaContrato = leerFecha("Fecha contratacion (YYYY-MM-DD): ");
        Especialidad esp = crearEspecialidad();

        switch (opcion) {

            case 1:

                Medico medico = new Medico(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContrato, salario, true, opcion, esp);
                hospital.contratarEmpleado(medico);
                System.out.println("Medico registrado");
                break;

            case 2:

                Cirujano cirujano = new Cirujano(id, true, id, nombre, apellido, fechaNacimiento, email, legajo, fechaContrato, salario, true, opcion, esp);
                hospital.contratarEmpleado(cirujano);
                System.out.println("Cirujano registrado");
                break;

            case 3:
                System.out.print("Area asignada: ");
                String area = entrada.nextLine();
                Turno turno = seleccionarTurno();
                Enfermero enfermero = new Enfermero(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContrato, salario, true, turno, area);
                hospital.contratarEmpleado(enfermero);
                System.out.println("Enfermero registrado");
                break;

            default:
                System.out.println("Opcion invalida");
        }
    }

    private static Especialidad crearEspecialidad() {

        System.out.print("Ingrese el Codigo: ");
        String codigo = entrada.nextLine();

        System.out.print("Ingrese el Nombre de la especialidad: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese la Descripcion: ");
        String descripcion = entrada.nextLine();

        System.out.print("Ingrese el Costo de consulta: ");
        double costo = entrada.nextDouble();

        System.out.print("Porcentaje bono (ej: 0.2): ");
        double bono = entrada.nextDouble();
        entrada.nextLine();

        return new Especialidad(codigo, nombre, descripcion, costo, bono);
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(entrada.nextLine());
            } catch (Exception e) {
                System.out.println("Formato invalido (YYYY-MM-DD)");
            }
        }
    }

    private static Turno seleccionarTurno() {

        System.out.println("Turno:");
        System.out.println("1. Mañana");
        System.out.println("2. Tarde");
        System.out.println("3. Noche");

        int op = entrada.nextInt();
        entrada.nextLine();

        switch (op) {
            case 1:
                return Turno.Mañana;
            case 2:
                return Turno.tarde;
            case 3:
                return Turno.noche;
            default:
                System.out.println("Opcion invalida, se asigna MAÑANA");
                return Turno.Mañana;
        }
    }}
