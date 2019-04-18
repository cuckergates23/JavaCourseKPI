package check;

public class IncorrectInputDataException extends Exception {
    String inputData;

    public IncorrectInputDataException(String message){
        super(message);
    }
}
