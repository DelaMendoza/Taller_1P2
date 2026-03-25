package modelo.hospital;
import java.time.LocalDateTime;
import modelo.enums.EstadoCita;
import modelo.personas.Medico;
import modelo.personas.Paciente;

public class CitaMedica {
    private int id;
    private Paciente paciente; 
    private Medico medico;
    private LocalDateTime fechaHora;
    private String motivo;
    private EstadoCita estado;
    private double costo;
    private Diagnostico diagnostico;

    public CitaMedica(int id, Paciente paciente, Medico medico, LocalDateTime fechaHora, String motivo, EstadoCita estado, double costo, Diagnostico diagnostico) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
        this.costo = costo;
        this.diagnostico = diagnostico;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public double calcularCosto(){
    return medico.getEspecialidad().getCostoConsulta();
            }
    
    public void completar(){
        if (estado == EstadoCita.En_atencion) {
            this.estado= EstadoCita.Completada;
            System.out.println("La cita ha sido completada");
        }
        
    }
    
    public void cancelar(){
        if (estado !=EstadoCita.Completada) {
            this.estado= EstadoCita.Cancelada;
            System.out.println("La cita ha sido cancelada");
            
        }
    }
    
}
