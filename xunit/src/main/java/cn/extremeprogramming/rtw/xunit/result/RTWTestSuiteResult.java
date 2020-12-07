package cn.extremeprogramming.rtw.xunit.result;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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
        return testCaseResults.stream().map(Object::toString).collect(joining());
    }

    public List<RTWTestCaseResult> failedTestCaseResults() {
        return testCaseResults.stream().filter(r -> !r.isSuccessful()).collect(toList());
    }

    public String failedTestCaseNames() {
        return failedTestCaseResults().stream().map(r -> String.format("   - %s", r.testCaseName())).collect(joining("\n"));
    }
}
