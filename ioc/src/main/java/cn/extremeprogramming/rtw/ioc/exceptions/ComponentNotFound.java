package cn.extremeprogramming.rtw.ioc.exceptions;

import static java.lang.String.format;

public class ComponentNotFound extends RuntimeException {
    public ComponentNotFound(Class clazz) {
        super(format("Component of type [%s] is not found", clazz.getCanonicalName()));
    }
}
