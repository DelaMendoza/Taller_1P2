package modelo.hospital;

public class Especialidad {

    //codigo, nombre, descripcion, costoConsulta
    private String codigo;
    private String nombre;
    private String descripcion;
    private double costoConsulta;
    private double bonoPorcentual;

    public Especialidad(String codigo, String nombre, String descripcion, double costoConsulta, double bonoPorcentual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoConsulta = costoConsulta;
        this.bonoPorcentual = bonoPorcentual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(double costoConsulta) {
        if (costoConsulta > 0) {
            this.costoConsulta = costoConsulta;
        }

    }

    public double getBonoPorcentual() {
        return bonoPorcentual;
    }

    public void setBonoPorcentual(double bonoPorcentual) {
        if (bonoPorcentual >= 0 && bonoPorcentual <= 1) {
            this.bonoPorcentual = bonoPorcentual;
        }

    }

}
