package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ComponentNotFound;
import cn.extremeprogramming.rtw.ioc.exceptions.InstantiationFailure;

import java.lang.reflect.Constructor;
import java.util.List;

import static java.util.Arrays.asList;

public class ConstructorExecutable {
    static ConstructorExecutable satisfy(Constructor constructor, Components dependencies) {
        List<Class> parameterTypes = asList(constructor.getParameterTypes());
        List<Object> parameters = dependencies.findByTypes(parameterTypes);
        return new ConstructorExecutable(constructor, parameters);
    }

    private final Constructor constructor;
    private final List<Object> parameters;

    public ConstructorExecutable(Constructor constructor, List<Object> parameters) {
        this.constructor = constructor;
        this.parameters = parameters;
    }

    public Object instantiate() {
        try {
            return constructor.newInstance(parameters.toArray());
        } catch (Exception e) {
            throw new InstantiationFailure(e);
        }
    }
}
