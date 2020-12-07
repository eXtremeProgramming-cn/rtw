package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.result.RTWTestCaseResult;
import cn.extremeprogramming.rtw.xunit.result.RTWTestSuiteResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public abstract class RTWTestSuite {
    private final List<RTWTestCase> testCases = new ArrayList<>();

    public RTWTestSuite() {
        registerTestCases();
    }

    abstract protected void registerTestCases();

    protected void addTestCase(RTWTestCase testCase) {
        testCases.add(testCase);
    }

    public int numberOfTestCases() {
        return testCases.size();
    }

    public RTWTestSuiteResult execute() {
        List<RTWTestCaseResult> testCaseResults = testCases.stream().map(RTWTestCase::execute).collect(toList());
        return new RTWTestSuiteResult(testCaseResults);
    }
}
