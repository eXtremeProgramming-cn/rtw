package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ConstructorNotFound;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConstructorResolverTest {
    @Test
    public void should_resolve_default_constructor() {
        ConstructorResolver resolver = new ConstructorResolver(String.class);
        ConstructorExecutable constructorExecutable = resolver.resolve(new Components());
        assertThat(constructorExecutable.instantiate(), is(""));
    }

    @Test(expected = ConstructorNotFound.class)
    public void should_raise_exception_if_proper_constructor_not_found() {
        ConstructorResolver resolver = new ConstructorResolver(Integer.class);
        resolver.resolve(new Components());
    }

    @Test
    public void should_resolve_constructor_with_appropriate_parameters() throws NoSuchMethodException {
        ConstructorResolver resolver = new ConstructorResolver(Integer.class);
        Components components = new Components();
        components.add("1");
        ConstructorExecutable executable = resolver.resolve(components);
        assertThat(executable.instantiate(), is(1));
    }
}
