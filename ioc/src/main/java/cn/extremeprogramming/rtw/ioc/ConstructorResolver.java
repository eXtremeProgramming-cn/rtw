package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;

import java.lang.reflect.Constructor;
import java.util.List;

public class ConstructorResolver {
    private final Class clazz;

    public ConstructorResolver(Class clazz) {
        this.clazz = clazz;
    }

    public Constructor resolve(List<Object> dependencies) {
        try {
            return clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new ConstructorNotFound(e);
        }
    }
}
