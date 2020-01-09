package cn.extremeprogramming.rtw.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Container {
    private final List<Object> components = new ArrayList<>();

    public void addComponent(Object component) {
        components.add(component);
    }

    public void addComponent(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor defaultConstructor = clazz.getConstructor();
        Object component = defaultConstructor.newInstance();
        addComponent(component);
    }

    public <T> T getComponent(Class<T> clazz) {
        Optional<Object> candidate = components.stream().filter(clazz::isInstance).findFirst();
        if(!candidate.isPresent()) {
            throw new ComponentNotFound(clazz);
        }
        return (T) candidate.get();
    }
}
