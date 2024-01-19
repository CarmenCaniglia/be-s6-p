package carmencaniglia.bes6p.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("Elemento con id " + id + " non trovato!");
    }
}
