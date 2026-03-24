package modelo.hospital;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.abstractas.Empleado;
import modelo.personas.Medico;
import modelo.personas.Paciente;

public class Hospital {

    private String nombre;
    private String direccion;
    private List<Empleado> empleados;
    private List<Paciente> pacientes;
    private List<CitaMedica> citas;

    public Hospital(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleados = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<CitaMedica> getCitas() {
        return new ArrayList<>(citas);
    }

    public void setCitas(List<CitaMedica> citas) {
        this.citas = citas;
    }

    public void contratarEmpleado(Empleado empleado) {
        if (empleado != null) {
            empleados.add(empleado);
            System.out.println(empleado.getNombre() + empleado.getApellido() + " Ha sido contratado/a");
        }
    }

    public CitaMedica agendarCita(Paciente paciente, Medico medico, LocalDateTime fechaHora, String motivo) {
        if (!pacientes.contains(paciente)) {
            System.out.println("No se puede agendar la cita. El paciente no esta registrado en el hospital");
            return null;
        }

        if (!medico.isActivo()) {
            System.out.println("No se puede agendar la cita. El medico no está disponible");
            return null;
        }

        int id = citas.size() + 1;
        CitaMedica cita = new CitaMedica(id, paciente, medico, fechaHora, motivo);
        citas.add(cita);
        System.out.println("La cita ha sido agendada");
        return cita;
    }

    public double calcularNominaTotal() {
        double nominaTotal = 0;
        for (Empleado empleado : empleados) {
            nominaTotal += empleado.calcularSalario();
        }
        return nominaTotal;
    }
}
