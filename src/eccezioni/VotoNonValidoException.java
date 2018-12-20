package eccezioni;

public class VotoNonValidoException extends Exception {
    public VotoNonValidoException() {
        super("Voto non valido");
    }

    public VotoNonValidoException(String message) {
        super(message);
    }
}
