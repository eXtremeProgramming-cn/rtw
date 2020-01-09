package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
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
//        List<Constructor> constructors = asList(clazz.getConstructors());
//        constructors.sort((ctor1, ctor2) -> ctor2.getParameterCount() - ctor1.getParameterCount());
//        for (Constructor constructor : constructors) {
//            if (satisfied(constructor, dependencies)) {
//                return constructor;
//            }
//        }
//
//        throw new ConstructorNotFound(clazz, dependencies);
        Constructor constructor = null;
        try {
            constructor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new ConstructorNotFound(e);
        }
        return new ConstructorExecutable(constructor, emptyList());
    }

    private boolean satisfied(Constructor constructor, List<Object> dependencies) {
        List<Class> parameterTypes = asList(constructor.getParameterTypes());
        for (Class parameterType : parameterTypes) {
            Optional<Object> parameterCandidate = dependencies.stream().filter(d -> d.getClass().equals(parameterType)).findFirst();
            if(!parameterCandidate.isPresent()) {
                return false;
            }
        }
        return true;
    }
}
