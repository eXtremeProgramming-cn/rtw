package cn.extremeprogramming.rtw.ioc.exceptions;

import cn.extremeprogramming.rtw.ioc.Components;

import java.util.List;

public class ConstructorNotFound extends RuntimeException {
    public ConstructorNotFound(NoSuchMethodException cause) {
        super(cause);
    }

    public ConstructorNotFound(Class clazz, Components components) {

    }
}
