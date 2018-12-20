package eccezioni;

public class PianoDiStudiVuotoException extends Exception {
    public PianoDiStudiVuotoException() {
        super("Piano di studi non compilato");
    }

    public PianoDiStudiVuotoException(String message) {
        super(message);
    }
}
