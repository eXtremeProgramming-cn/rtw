package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.fixture.FailedTestSuite;
import cn.extremeprogramming.rtw.xunit.fixture.SuccessfulTestSuite;
import cn.extremeprogramming.rtw.xunit.result.RTWTestSuiteResult;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RTWTestSuiteTest {
    @Test
    public void should_create_test_suite_contains_multiple_test_cases() {
        SuccessfulTestSuite testSuite = new SuccessfulTestSuite();
        assertThat(testSuite.numberOfTestCases(), is(2));
    }

    @Test
    public void should_run_test_suite_and_collect_results() {
        FailedTestSuite testSuite = new FailedTestSuite();
        RTWTestSuiteResult testSuiteResult = testSuite.execute();
        assertThat(testSuiteResult.numberOfTestCases(), is(3));
        assertThat(testSuiteResult.numberOfTestMethods(), is(2));
        assertThat(testSuiteResult.isSuccessful(), is(false));
        assertThat(testSuiteResult.toString(), is(".x"));
    }
}
