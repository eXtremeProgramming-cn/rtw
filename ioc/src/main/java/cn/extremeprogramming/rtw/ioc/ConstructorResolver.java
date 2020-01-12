package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ComponentNotFound;
import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.util.List;

import static cn.extremeprogramming.rtw.ioc.ConstructorExecutable.satisfy;
import static java.util.Arrays.asList;

public class ConstructorResolver {
    private final Class clazz;

    public ConstructorResolver(Class clazz) {
        this.clazz = clazz;
    }

    public ConstructorExecutable resolve(Components dependencies) {
        List<Constructor> constructors = asList(clazz.getConstructors());
        constructors.sort((ctor1, ctor2) ->
                ctor2.getParameterCount() - ctor1.getParameterCount());
        for (Constructor constructor : constructors) {
            try {
                return satisfy(constructor, dependencies);
            }catch (ComponentNotFound ignored){
            }
        }

        throw new ConstructorNotFound(clazz, dependencies);
    }
}
