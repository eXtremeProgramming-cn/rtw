package cn.extremeprogramming.rtw.xunit.exception;

import cn.extremeprogramming.rtw.xunit.fixture.FailedTestSuite;
import cn.extremeprogramming.rtw.xunit.result.RTWTestSuiteResult;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSuiteFailedTest {
    @Test
    public void should_carry_more_meaningful_message() {
        FailedTestSuite testSuite = new FailedTestSuite();
        RTWTestSuiteResult testSuiteResult = testSuite.execute();
        TestSuiteFailed testSuiteFailed = new TestSuiteFailed(testSuiteResult);
        String expectedMessage = "Some tests failed.\n" +
                "Failed test cases are:\n" +
                "   - cn.extremeprogramming.rtw.xunit.fixture.TestCaseWithFailedMethod";
        assertThat(testSuiteFailed.getMessage(), is(expectedMessage));
    }
}