package cn.extremeprogramming.rtw.xunit.result;

import java.util.List;
import java.util.stream.Collectors;

public class RTWTestSuiteResult {
    private final List<RTWTestCaseResult> testCaseResults;

    public RTWTestSuiteResult(List<RTWTestCaseResult> testCaseResults) {
        this.testCaseResults = testCaseResults;
    }

    public int numberOfTestCases() {
        return testCaseResults.size();
    }

    public int numberOfTestMethods() {
        return testCaseResults.stream().map(RTWTestCaseResult::numberOfTestMethods).reduce(0, Integer::sum);
    }

    public boolean isSuccessful() {
        return testCaseResults.stream().allMatch(RTWTestCaseResult::isSuccessful);
    }

    @Override
    public String toString() {
        return testCaseResults.stream().map(Object::toString).collect(Collectors.joining());
    }
}
