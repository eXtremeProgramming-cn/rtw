package cn.extremeprogramming.rtw.ioc.exceptions;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(NoSuchMethodException cause) {
        super(cause);
    }
}
