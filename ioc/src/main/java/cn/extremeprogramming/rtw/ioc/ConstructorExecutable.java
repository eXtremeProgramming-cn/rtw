package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.InstantiationFailure;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConstructorExecutable {
    static ConstructorExecutable satisfy(Constructor constructor, List<Object> dependencies) {
        Class[] parameterTypes = constructor.getParameterTypes();
        List<Object> parameters = new ArrayList<>();
        for (Class parameterType : parameterTypes) {
            Optional<Object> parameterCandidate = dependencies.stream().filter(parameterType::isInstance).findFirst();
            if(!parameterCandidate.isPresent()) {
                return null;
            }
            parameters.add(parameterCandidate.get());
        }
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
