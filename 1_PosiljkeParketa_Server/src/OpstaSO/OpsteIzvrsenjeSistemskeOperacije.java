package OpstaSO;

import database.BrokerBazePosiljke;

public abstract class OpsteIzvrsenjeSistemskeOperacije {

    static public BrokerBazePosiljke broker = new BrokerBazePosiljke();
    boolean signal = false;

    synchronized public boolean opsteIzvrsenjeSO() {
        broker.napraviKonekciju();
        signal = izvrsiSO();

        if (signal == true) {
            broker.commitTransakcije();
        } else {
            broker.rollbackTransakcije();
        }
        broker.zatvoriKonekciju();
        return signal;
    }

    synchronized public boolean opsteIzvrsenjeSOIzvestaj() {
        broker.napraviKonekciju();

        signal = izvrsiSO();

        broker.zatvoriKonekciju();

        return signal;
    }

    abstract public boolean izvrsiSO();
}
