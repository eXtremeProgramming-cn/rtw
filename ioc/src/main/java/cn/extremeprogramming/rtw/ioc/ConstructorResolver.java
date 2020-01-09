package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class ConstructorResolver {
    private final Class clazz;

    public ConstructorResolver(Class clazz) {
        this.clazz = clazz;
    }

    public ConstructorExecutable resolve(List<Object> dependencies) {
        List<Constructor> constructors = asList(clazz.getConstructors());
        constructors.sort((ctor1, ctor2) -> ctor2.getParameterCount() - ctor1.getParameterCount());
        for (Constructor constructor : constructors) {
            ConstructorExecutable constructorExecutable = satisfy(constructor, dependencies);
            if (constructorExecutable != null) {
                return constructorExecutable;
            }
        }

        throw new ConstructorNotFound(clazz, dependencies);
    }

    private ConstructorExecutable satisfy(Constructor constructor, List<Object> dependencies) {
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
}
