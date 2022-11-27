package dji.common.gimbal;

public enum BalanceTestResult
{
  static
  {
    MARGINAL = new BalanceTestResult("MARGINAL", 1);
    FAIL = new BalanceTestResult("FAIL", 2);
    BalanceTestResult localBalanceTestResult = new BalanceTestResult("UNKNOWN", 3);
    UNKNOWN = localBalanceTestResult;
    $VALUES = new BalanceTestResult[] { PASS, MARGINAL, FAIL, localBalanceTestResult };
  }
  
  private BalanceTestResult() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\BalanceTestResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */