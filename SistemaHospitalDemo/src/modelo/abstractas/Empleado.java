package modelo.abstractas;

import java.time.LocalDate;

public abstract class Empleado extends Persona {

    private String legajo;
    private LocalDate fechaContratacion;
    private double salarioBase;
    private boolean activo;

    public Empleado(int id, String nombre, String apellido, LocalDate fechaNacimiento, String email,
            String legajo, LocalDate fechaContratacion, double salarioBase, boolean activo) {
        
        super(id, nombre, apellido, fechaNacimiento, email);
        this.legajo = legajo;
        this.fechaContratacion = fechaContratacion;
        this.salarioBase = salarioBase;
        this.activo = activo;
    }

    public abstract double calcularSalario();

    public int antiguedad() {
        return LocalDate.now().getYear() - fechaContratacion.getYear();
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getsalarioBase() {
        return salarioBase;
    }

    public void setsalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public abstract String obtenerTipo();
    
}
