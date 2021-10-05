public enum menu {
    OPCION_1 (1, ".- Jugar"),
    OPCION_2 (2, ".- Introducir palabra"),
    OPCION_3 (3, ".- Lista de palabras"),
    OPCION_4 (4,".- Salir");

    private final int NUMBEROPT;
    private final String NAMEOPT;

    menu(int NUMBEROPT, String NAMEOPT) {
        this.NUMBEROPT = NUMBEROPT;
        this.NAMEOPT = NAMEOPT;
    }

    public int getNUMBEROPT() {
        return NUMBEROPT;
    }

    public String getNAMEOPT() {
        return NAMEOPT;
    }
}
