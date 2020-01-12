package cn.extremeprogramming.rtw.ioc;

import static java.lang.String.format;

public class SetterNotFound extends RuntimeException {
    public SetterNotFound(Class componentType, Class parameterType) {
        super(format("Cannot find setter with parameter [%s] for component [%s]",
                parameterType, componentType));
    }
}
