package cn.extremeprogramming.rtw.ioc.exceptions;

public class InstantiationFailure extends RuntimeException {
    public InstantiationFailure(Exception cause) {
        super(cause);
    }
}
