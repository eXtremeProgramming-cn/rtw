package cn.extremeprogramming.rtw.ioc;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ComponentsTest {
    @Test
    public void should_add_component() {
        Components components = new Components();
        components.add("Hello");
        assertThat(components.size(), is(1));
    }

    @Test
    public void should_find_components_by_types() {
        Components components = new Components();
        components.add("Hello");
        components.add(1);
        List<Object> result = components.findByTypes(asList(Integer.class, String.class));
        assertThat(result, is(asList(1, "Hello")));
    }
}