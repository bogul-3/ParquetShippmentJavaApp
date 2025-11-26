package transfer;

import java.io.Serializable;

public class ServerskiOdgovor implements Serializable {

    private Object parametar;
    private Exception exception;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object parametar, Exception exception) {
        this.parametar = parametar;
        this.exception = exception;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
