package eccezioni;

public class CorsoNotFoundException extends Exception {

    public CorsoNotFoundException() {
        super("Corso non presente nella Lista");
    }

    public CorsoNotFoundException(String message) {
        super(message);
    }
}
