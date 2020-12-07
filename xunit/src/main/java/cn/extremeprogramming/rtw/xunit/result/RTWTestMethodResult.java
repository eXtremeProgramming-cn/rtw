package cn.extremeprogramming.rtw.xunit.result;

public class RTWTestMethodResult {
    final boolean isSuccessful;

    public RTWTestMethodResult(Throwable e) {
        isSuccessful = false;
    }

    public RTWTestMethodResult() {
        isSuccessful = true;
    }

    @Override
    public String toString() {
        return isSuccessful ? "." : "x";
    }
}
