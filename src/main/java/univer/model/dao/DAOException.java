package univer.model.dao;

public class DAOException extends Exception {
    public DAOException(){
        super();
    }

    public DAOException(String mesage){
        super(mesage);
    }

    public DAOException(String message, Throwable cause){
    super(message, cause);
    }
}
