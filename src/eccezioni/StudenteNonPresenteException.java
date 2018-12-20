package eccezioni;

public class StudenteNonPresenteException extends  Exception {
    public StudenteNonPresenteException() {
        super("Studente non presente nella lista");
    }

    public StudenteNonPresenteException(String message) {
        super(message);
    }
}
