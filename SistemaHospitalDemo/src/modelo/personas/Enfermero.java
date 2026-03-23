//Lo siguiente a avanzar
package modelo.personas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.abstractas.Empleado;
import modelo.abstractas.Persona;
import modelo.enums.Turno;
import static modelo.enums.Turno.Mañana;

public class Enfermero extends Empleado {
//turno, areaAsignada, pacientesACargo

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
        return getsalarioBase()+bonoHorario;               
    }

    @Override
    public String obtenerTipo() {
        return "Enfermero";
    }

}
