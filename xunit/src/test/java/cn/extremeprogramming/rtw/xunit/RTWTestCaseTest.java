package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.fixture.EmptyTestCase;
import cn.extremeprogramming.rtw.xunit.fixture.TestCaseWithFailedMethod;
import cn.extremeprogramming.rtw.xunit.fixture.TestCaseWithSingleMethod;
import cn.extremeprogramming.rtw.xunit.result.RTWTestCaseResult;
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
        assertThat(successfulTestCaseResult.numberOfTestMethods(), is(1));
        assertThat(successfulTestCaseResult.isSuccessful(), is(true));

        TestCaseWithFailedMethod failedTestCase = new TestCaseWithFailedMethod();
        RTWTestCaseResult failedTestCaseResult = failedTestCase.execute();
        assertThat(failedTestCaseResult.isSuccessful(), is(false));
    }
}

