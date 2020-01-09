package cn.extremeprogramming.rtw.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ConstructorExecutable {
    private final Constructor constructor;
    private final List<Object> parameters;

    public ConstructorExecutable(Constructor constructor, List<Object> parameters) {
        this.constructor = constructor;
        this.parameters = parameters;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public Object instantiate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return constructor.newInstance(parameters.toArray());
    }
}
