package cn.extremeprogramming.rtw.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class Setters {
    private final List<Method> setters;

    public Setters(Class clazz) {
        setters = stream(clazz.getMethods())
                .filter(this::isSetter)
                .collect(toList());
    }

    public int size() {
        return setters.size();
    }

    private boolean isSetter(Method method) {
        return method.getName().startsWith("set")
                && method.getReturnType() == void.class
                && method.getParameterCount() == 1;
    }

    public Method findByParameterType(Class parameterType) {
        return findByParameterTypeNullable(parameterType).get();
    }

    private Optional<Method> findByParameterTypeNullable(Class parameterType) {
        return setters.stream()
                .filter(method -> method.getParameterTypes()[0].equals(parameterType))
                .findFirst();
    }

    public void invoke(Object target, Components dependencies) {
        for (Method setter : setters) {
            Class parameterType = setter.getParameterTypes()[0];
            try {
                Object dependency = dependencies.findByType(parameterType);
                setter.invoke(target, dependency);
            } catch (Exception ignored) {
            }
        }
    }
}
