package modelo.personas;
//Avance de medico, fala implementar aumento de salario por especialidad
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.abstractas.Empleado;
import modelo.hospital.CitaMedica;

public class Medico extends Empleado {

    private int numeroLicencia;
    private String especialidad;
    private List<Paciente> pacientesAsignados;
    private List<CitaMedica> citasAtendidas;

    public Medico(int id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo,
            int numeroLicencia, String especialidad) {

        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);

        this.numeroLicencia = numeroLicencia;
        this.especialidad = especialidad;
        this.pacientesAsignados = new ArrayList<>();
        this.citasAtendidas = new ArrayList<>();
    }

    //Setter y getter de la clase
    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        if (numeroLicencia > 0) {
            this.numeroLicencia = numeroLicencia;
        }

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Paciente> getPacientesAsignados() {
        return new ArrayList<>(pacientesAsignados);
    }

    public void setPacientesAsignados(List<Paciente> pacientesAsignados) {
        this.pacientesAsignados = pacientesAsignados;
    }

    public List<CitaMedica> getCitasAtendidas() {
        return new ArrayList<>(citasAtendidas);
    }

    public void setCitasAtendidas(List<CitaMedica> citasAtendidas) {
        this.citasAtendidas = citasAtendidas;
    }

    //Método propio de la clase Medico
    public void atenderPaciente(Paciente paciente, CitaMedica cita) {
        if (paciente != null) {
            pacientesAsignados.add(paciente);
            citasAtendidas.add(cita);
        }
    }

    //Método para contar la cant de citas atendidas
    public int cantCitasAtendidas() {
        return citasAtendidas.size();
    }

    //Métodos sobreescritos, Salario de Empleado y Tipo de persona
    @Override
    public double calcularSalario() {
        return getsalarioBase() + (getsalarioBase() * 0.5 * antiguedad());
    }

    @Override
    public String obtenerTipo() {
        return "Medico";
    }

}
