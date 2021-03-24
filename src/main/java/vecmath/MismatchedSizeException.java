package vecmath;

public class MismatchedSizeException extends RuntimeException{


    /**
     * Create the exception object with default values.
     */
    public MismatchedSizeException(){
    }

    /**
     * Create the exception object that outputs a message.
     * @param str the message string to be output.
     */
    public MismatchedSizeException(String str){

        super(str);
    }

}