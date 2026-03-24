package modelo.personas;
//Completado por el momento
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.abstractas.Persona;
import modelo.hospital.CitaMedica;

public class Paciente extends Persona {

    private String historiaClinicaId;
    private String grupoSanguineo;
    private List<String> alergias;
    private List<CitaMedica> citas;

    public Paciente(int id, String nombre, String apellido, LocalDate fechaNacimiento, String email, String historiaClinicaId, String grupoSanguineo) {

        super(id, nombre, apellido, fechaNacimiento, email);
        this.historiaClinicaId = historiaClinicaId;
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = new ArrayList<>();
        this.citas = new ArrayList<>();
    }
//Getter y setter
    public String getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public void setHistoriaClinicaId(String historiaClinicaId) {
        this.historiaClinicaId = historiaClinicaId;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public List<String> getAlergias() {
        return new ArrayList<>(alergias);
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<CitaMedica> getCitas() {
        return new ArrayList<>(citas);
    }

    public void setCitas(List<CitaMedica> citas) {
        this.citas = citas;
    }
    
    //Métodos propios de la clase Paciente
    public void agregarAlergia(String alergia) {
        alergias.add(alergia);
    }

    public List<CitaMedica> obtenerHistorial() {
        return new ArrayList<>(citas);
    }
    
    //Métodos sobreescritos
    @Override
    public int calcularEdad() {
        return super.calcularEdad(); 
    }

    @Override
    public String obtenerTipo() {
        return "Paciente";
    }


}
