package p11_Online_Radio_Database.exceptions;

public class InvalidSongMinutesException extends InvalidSongLengthException {

    public InvalidSongMinutesException(String message) {
        super(message);
    }
}
