package cn.extremeprogramming.rtw.ioc;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

class Sample {
    String stringInput;
    private double doubleInput;

    // real setters
    public void setString(String stringInput) {
        this.stringInput = stringInput;
    }

    public void setDouble(Double doubleInput) {
        this.doubleInput = doubleInput;
    }

    // fake setters
    public int setInt(int input) {
        return 0;
    }

    public void setTwoParams(String input1, int input2) {

    }

    private void setFloat(float input) {

    }
}

public class SettersTest {
    @Test
    public void should_find_all_setters() {
        Setters setters = new Setters(Sample.class);
        assertThat(setters.size(), is(2));
    }

    @Test
    public void should_find_setter_by_type() throws NoSuchMethodException {
        Setters setters = new Setters(Sample.class);
        Method setter = setters.findByParameterType(Double.class);
        assertThat(setter, is(Sample.class.getMethod("setDouble", Double.class)));
    }

    @Test
    public void should_invoke_setters_with_matching_parameters() {
        Sample sample = new Sample();
        Setters setters = new Setters(sample.getClass());
        Components dependencies = new Components();
        dependencies.add("str-1");
        dependencies.add(1.0);
        setters.invoke(sample, dependencies);
        assertThat(sample.stringInput, is("str-1"));
    }

    @Test
    public void should_handle_exception_gracefully() {
        Sample sample = new Sample();
        Setters setters = new Setters(sample.getClass());
        Components dependencies = new Components();
        dependencies.add("str-2");
        setters.invoke(sample, dependencies);
        assertThat(sample.stringInput, is("str-2"));
    }
}