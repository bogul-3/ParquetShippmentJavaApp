package transfer;

import java.io.Serializable;
import operacije.OperacijeENUM;

public class KlijentskiZahtev implements Serializable {

    private OperacijeENUM operacija;
    private Object parametar;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(OperacijeENUM operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public OperacijeENUM getOperacija() {
        return operacija;
    }

    public void setOperacija(OperacijeENUM operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

}
