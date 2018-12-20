package eccezioni;

public class EsameNotFoundException extends Exception {
    public EsameNotFoundException() {
        super("Esame non presente nel piano di studi");
    }

    public EsameNotFoundException(String message) {
        super(message);
    }
}
