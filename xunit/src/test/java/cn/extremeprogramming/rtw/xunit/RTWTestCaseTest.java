package cn.extremeprogramming.rtw.xunit;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RTWTestCaseTest {
    @Test
    public void should_create_test_case_object() {
        EmptyTestCase testCase = new EmptyTestCase();
        assertThat(testCase.numberOfTestMethods(), is(0));
    }

    @Test
    public void should_register_test_methods() {
        TestCaseWithSingleMethod testCase = new TestCaseWithSingleMethod();
        assertThat(testCase.numberOfTestMethods(), is(1));
    }

    @Test
    public void should_execute_and_return_result() {
        TestCaseWithSingleMethod successfulTestCase = new TestCaseWithSingleMethod();
        RTWTestCaseResult successfulTestCaseResult = successfulTestCase.execute();
        assertThat(successfulTestCaseResult.size(), is(1));
        assertThat(successfulTestCaseResult.isSuccessful(), is(true));

        TestCaseWithFailedMethod failedTestCase = new TestCaseWithFailedMethod();
        RTWTestCaseResult failedTestCaseResult = failedTestCase.execute();
        assertThat(failedTestCaseResult.isSuccessful(), is(false));
    }
}

class EmptyTestCase extends RTWTestCase {
    @Override
    protected void registerTestMethods() {

    }
}

class TestCaseWithSingleMethod extends RTWTestCase {
    public void test_method_that_should_always_pass() {

    }

    @Override
    protected void registerTestMethods() {
        addTestMethod(this::test_method_that_should_always_pass);
    }
}

class TestCaseWithFailedMethod extends RTWTestCase {
    public void test_method_that_should_always_fail() {
        throw new RuntimeException("fail!");
    }

    @Override
    protected void registerTestMethods() {
        addTestMethod(this::test_method_that_should_always_fail);
    }
}