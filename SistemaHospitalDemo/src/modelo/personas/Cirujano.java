package modelo.personas;
import java.time.LocalDate;

//Cirujano completo hasta el momento
public class Cirujano extends Medico {

    private int cirugiasRealizadas;
    private boolean disponibleEmergencias;

    public Cirujano(int cirugiasRealizadas, boolean disponibleEmergencias, int id, String nombre, String apellido,
            LocalDate fechaNacimiento, String email, String legajo, LocalDate fechaContratacion, double salarioBase,
            boolean activo, int numeroLicencia, String especialidad) {

        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo, numeroLicencia, especialidad);
        this.cirugiasRealizadas = cirugiasRealizadas;
        this.disponibleEmergencias = disponibleEmergencias;
    }

    //Getter y Setter
    public int getCirugiasRealizadas() {
        return cirugiasRealizadas;
    }

    public void setCirugiasRealizadas(int cirugiasRealizadas) {
        this.cirugiasRealizadas = cirugiasRealizadas;
    }

    public boolean isDisponibleEmergencias() {
        return disponibleEmergencias;
    }

    public void setDisponibleEmergencias(boolean disponibleEmergencias) {
        this.disponibleEmergencias = disponibleEmergencias;
    }

    //Métodos sobreescritos de Empleado (Calc.Salario) y Persona (obt.Tipo)
    @Override
    public double calcularSalario() {
        return getsalarioBase() + (getsalarioBase() * 0.5 * antiguedad() + calcularBono());
    }

    @Override
    public String obtenerTipo() {
        return "Cirujano";
    }
// Métodos propios de Cirujano

    public void realizarCirugia() {
        System.out.println("Se le realizó un procedimiento quirurgico al paciente: ");
        this.cirugiasRealizadas++;
    }

    public double calcularBono() {
        double bono = cirugiasRealizadas * 50;
        return bono;
    }
}
