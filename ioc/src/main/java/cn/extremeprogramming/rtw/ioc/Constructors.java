package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ComponentNotFound;
import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.util.List;

import static java.util.Arrays.asList;

class Constructors {
    private final List<Constructor> constructors;
    private final Class clazz;

    Constructors(Class clazz) {
        this.clazz = clazz;
        constructors = asList(clazz.getConstructors());
        constructors.sort((ctor1, ctor2) ->
                ctor2.getParameterCount() - ctor1.getParameterCount());
    }

    ConstructorExecutable satisfy(Components dependencies) {
        for (Constructor constructor : constructors) {
            try {
                return ConstructorExecutable.satisfy(constructor, dependencies);
            }catch (ComponentNotFound ignored){
            }
        }
        throw new ConstructorNotFound(clazz, dependencies);
    }
}
