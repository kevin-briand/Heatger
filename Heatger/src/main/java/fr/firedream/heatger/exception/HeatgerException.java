package fr.firedream.heatger.exception;

public class HeatgerException extends Exception {
    private int errorCode = 0;

    public HeatgerException(int errorCode) throws Exception {
        super();
        this.errorCode =  errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
