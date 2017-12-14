package diet.help.pacient.pacienthelpdiet;

/**
 * Created by mauuu on 12/12/2017.
 */

public class Detalledieta {
    String dietaKey,alimento_key;

    public Detalledieta() {
    }

    public Detalledieta(String dietaKey, String alimento_key) {
        this.dietaKey = dietaKey;
        this.alimento_key = alimento_key;
    }

    public String getDietaKey() {
        return dietaKey;
    }

    public void setDietaKey(String dietaKey) {
        this.dietaKey = dietaKey;
    }

    public String getAlimento_key() {
        return alimento_key;
    }

    public void setAlimento_key(String alimento_key) {
        this.alimento_key = alimento_key;
    }
}
