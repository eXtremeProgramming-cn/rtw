package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ComponentNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class Components {
    private final List<Object> components = new ArrayList<>();

    public void add(Object component) {
        components.add(component);
    }

    public int size() {
        return components.size();
    }

    <T> T findByType(Class<T> clazz) {
        Optional<Object> candidate = components.stream().filter(clazz::isInstance).findFirst();
        if (!candidate.isPresent()) {
            throw new ComponentNotFound(clazz);
        }
        return (T) candidate.get();
    }

    public List<Object> findByTypes(List<Class> types) {
        return types.stream()
                .map(type -> findByType(type))
                .filter(Objects::nonNull)
                .collect(toList());
    }

}
