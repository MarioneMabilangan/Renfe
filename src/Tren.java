public class Tren extends Thread {
    private String nom;
    private Recorregut recorregut;
    private static final int TEMPS_ENTRE_PARADES = 300;

    public Tren(String nom, Recorregut recorregut) {
        this.nom = nom;
        this.recorregut = recorregut;
    }

    public void run() {
        System.out.println("Tren (" + nom + ") arranca");
        Creuament creuament;
        while ((creuament = recorregut.seguentCreuament()) != null) {
            System.out.println("Tren (" + nom + ") vol entrar en " + creuament.getId());
            synchronized (creuament) {
                while (creuament.getNTrens() > 0) {
                    try {
                        System.out.println("creuament [" + creuament.getId() + "].wait");
                        creuament.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                creuament.entrar();
            }
            System.out.println("Tren (" + nom + ") entra en " + creuament.getId());
            try {
                Thread.sleep(TEMPS_ENTRE_PARADES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (creuament) {
                creuament.sortir();
                System.out.println("Tren (" + nom + ") surt de " + creuament.getId());
                creuament.notifyAll();
            }
        }
        System.out.println("Tren [" + nom + "] fi de trajecte");
    }
}