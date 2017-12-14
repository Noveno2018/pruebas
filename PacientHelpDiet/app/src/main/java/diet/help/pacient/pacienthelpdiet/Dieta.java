package diet.help.pacient.pacienthelpdiet;

/**
 * Created by mauuu on 12/12/2017.
 */

public class Dieta {

    String horario,pacienteKey,fecha;

    public Dieta() {
    }

    public Dieta(String horario, String pacienteKey, String fecha) {
        this.horario = horario;
        this.pacienteKey = pacienteKey;
        this.fecha = fecha;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPacienteKey() {
        return pacienteKey;
    }

    public void setPacienteKey(String pacienteKey) {
        this.pacienteKey = pacienteKey;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
