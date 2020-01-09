package cn.extremeprogramming.rtw.ioc;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConstructorExecutableTest {
    @Test
    public void should_execute_constructor() throws Exception {
        Constructor<String> defaultConstructor = String.class.getConstructor();
        ConstructorExecutable executable = new ConstructorExecutable(defaultConstructor, emptyList());
        Object result = executable.instantiate();
        assertThat(result, is(""));

        Constructor<String> constructor = String.class.getConstructor(String.class);
        executable = new ConstructorExecutable(constructor, singletonList("Hello"));
        assertThat(executable.instantiate(), is("Hello"));
    }
}