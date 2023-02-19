public class Creuament {
    private int nTrens;
    private int id;

    public Creuament(int id) {
        this.nTrens = 0;
        this.id = id;
    }

    public void entrar() {
        nTrens++;
    }

    public void sortir() {
        nTrens--;
    }

    public int getId() {
        return id;
    }

    public int getNTrens() {
        return nTrens;
    }
}