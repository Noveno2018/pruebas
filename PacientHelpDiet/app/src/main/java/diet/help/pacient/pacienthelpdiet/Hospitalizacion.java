package diet.help.pacient.pacienthelpdiet;

/**
 * Created by mauuu on 12/12/2017.
 */

public class Hospitalizacion {

    String numeroCama,pacienteKey,motivoIngreso,observaciones;

    public Hospitalizacion() {
    }

    public Hospitalizacion(String numeroCama, String pacienteKey, String motivoIngreso, String observaciones) {
        this.numeroCama = numeroCama;
        this.pacienteKey = pacienteKey;
        this.motivoIngreso = motivoIngreso;
        this.observaciones = observaciones;
    }

    public String getNumeroCama() {
        return numeroCama;
    }

    public void setNumeroCama(String numeroCama) {
        this.numeroCama = numeroCama;
    }

    public String getPacienteKey() {
        return pacienteKey;
    }

    public void setPacienteKey(String pacienteKey) {
        this.pacienteKey = pacienteKey;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

