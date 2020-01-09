package cn.extremeprogramming.rtw.ioc;

import static java.lang.String.format;

public class ComponentNotFound extends RuntimeException {
    private final Object clazz;

    ComponentNotFound(Object clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return format("Component of type [%s] is not found", clazz);
    }
}
