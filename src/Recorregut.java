public class Recorregut {
    private Creuament[] creuaments;
    private int paradaActual;

    public Recorregut(Creuament[] creuaments) {
        this.creuaments = creuaments;
        this.paradaActual = 0;
    }

    public Creuament seguentCreuament() {
        if (paradaActual < creuaments.length) {
            return creuaments[paradaActual++];
        } else {
            return null;
        }
    }
}
