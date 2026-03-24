//Completado
package modelo.personas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.abstractas.Empleado;
import modelo.abstractas.Persona;
import modelo.enums.Turno;

public class Enfermero extends Empleado {

    private Turno turno;
    private String areaAsignada;
    private List<Persona> pacientesACargo;

    public Enfermero(int id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo, Turno turno, String areaAsignada) {

        super(id, nombre, apellido, fechaNacimiento, email, legajo, fechaContratacion, salarioBase, activo);
        this.turno = turno;
        this.areaAsignada = areaAsignada;
        this.pacientesACargo = new ArrayList<>();
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        if (turno != null) {
            this.turno = turno;
        }

    }

    public String getAreaAsignada() {
        return areaAsignada;
    }

    public void setAreaAsignada(String areaAsignada) {
        if (!areaAsignada.isBlank()) {
            this.areaAsignada = areaAsignada;
        }
    }

    public List<Persona> getPacientesACargo() {
        return new ArrayList<>(pacientesACargo);
    }

    public void setPacientesACargo(List<Persona> pacientesACargo) {
        this.pacientesACargo = pacientesACargo;
    }

    //Métodos propios de la clase Enfermero
    public void asistirCirugia(){
        System.out.println("El enfermero asiste en cirugia");
    }
    
    //Métodos sobreescritos
    @Override
    public double calcularSalario() {
        double bonoHorario = 0;
        switch (turno) {
            case Mañana:
                bonoHorario = 100000;
                break;
            case tarde:
                bonoHorario = 150000;
                break;
            case noche:
                bonoHorario = 200000;
                break;
        }
        double bonoAntiguedad= getsalarioBase() * 0.5 * antiguedad();
        return getsalarioBase() + bonoHorario + bonoAntiguedad;
    }

    @Override
    public String obtenerTipo() {
        return "Enfermero";
    }

}
