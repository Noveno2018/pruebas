package diet.help.pacient.pacienthelpdiet;

/**
 * Created by mauuu on 12/12/2017.
 */

public class Operacion {
    String hospitalizacionKey,area,descripcion,fecha,sala;

    public Operacion() {
    }

    public Operacion(String hospitalizacionKey, String area, String descripcion, String fecha, String sala) {
        this.hospitalizacionKey = hospitalizacionKey;
        this.area = area;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.sala = sala;
    }

    public String getHospitalizacionKey() {
        return hospitalizacionKey;
    }

    public void setHospitalizacionKey(String hospitalizacionKey) {
        this.hospitalizacionKey = hospitalizacionKey;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
