public class Renfe {
    private static final int NTRENS = 5;
    private static final int NCREUAMENTS = 10;

    private Tren[] trens;
    private Recorregut[] recorreguts;
    private Creuament[] creuaments;
    public Renfe() {
        // Inicialitzem els arrays
        trens = new Tren[NTRENS];
        recorreguts = new Recorregut[NTRENS];
        creuaments = new Creuament[NCREUAMENTS];

        // Creem els creuaments
        for (int i = 0; i < NCREUAMENTS; i++) {
            creuaments[i] = new Creuament(i);
        }

        // Creem els trens i els recorreguts associats
        for (int i = 0; i < NTRENS; i++) {
            Recorregut recorregut = new Recorregut(creuaments);
            Tren tren = new Tren("Tren[" + i + "]", recorregut);
            trens[i] = tren;
            recorreguts[i] = recorregut;
        }
    }

    public void iniciarTrens() {
        // Iniciem els threads dels trens
        for (int i = 0; i < NTRENS; i++) {
            Tren tren = trens[i];
            Thread thread = new Thread(tren);
            thread.start();
        }
    }

    public static void main(String[] args) {
        Renfe renfe = new Renfe();
        renfe.iniciarTrens();
    }
}
