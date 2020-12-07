package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.exception.TestSuiteFailed;
import cn.extremeprogramming.rtw.xunit.fixture.FailedTestSuite;
import cn.extremeprogramming.rtw.xunit.fixture.SuccessfulTestSuite;
import org.junit.Test;

public class RTWTestRunnerTest {
    @Test
    public void should_execute_specified_test_suite() throws Exception {
        RTWTestRunner testRunner = new RTWTestRunner();
        testRunner.execute(SuccessfulTestSuite.class);
    }

    @Test(expected = TestSuiteFailed.class)
    public void should_throw_exception_when_execute_failed_test_suite() throws Exception {
        RTWTestRunner testRunner = new RTWTestRunner();
        testRunner.execute(FailedTestSuite.class);
    }

    @Test(expected = TestSuiteFailed.class)
    public void should_execute_test_suite_in_main_method() throws Exception {
        String testSuiteClassName = FailedTestSuite.class.getCanonicalName();
        RTWTestRunner.main(testSuiteClassName);
    }
}
