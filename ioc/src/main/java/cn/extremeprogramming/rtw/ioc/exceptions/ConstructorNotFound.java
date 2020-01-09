package cn.extremeprogramming.rtw.ioc.exceptions;

import java.util.List;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(NoSuchMethodException cause) {
        super(cause);
    }

    public ConstructorNotFound(Class clazz, List<Object> dependencies) {

    }
}
