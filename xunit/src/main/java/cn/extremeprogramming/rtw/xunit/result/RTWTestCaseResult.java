package cn.extremeprogramming.rtw.xunit.result;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RTWTestCaseResult {
    private final List<RTWTestMethodResult> testMethodResults;

    public RTWTestCaseResult(List<RTWTestMethodResult> testMethodResults) {
        this.testMethodResults = testMethodResults;
    }

    public boolean isSuccessful() {
        return testMethodResults.stream().allMatch(result -> result.isSuccessful);
    }

    public int numberOfTestMethods() {
        return testMethodResults.size();
    }

    @Override
    public String toString() {
        return testMethodResults.stream().map(Object::toString).collect(Collectors.joining());
    }
}
