package vecmath;

public class SingularMatrixException extends RuntimeException{

    /**
     * Create the exception object with default values.
     */
    public SingularMatrixException(){
    }

    /**
     * Create the exception object that outputs message.
     * @param str the message string to be output.
     */
    public SingularMatrixException(String str){

        super(str);
    }

}

