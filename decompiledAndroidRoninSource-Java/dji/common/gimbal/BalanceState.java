package dji.common.gimbal;

public enum BalanceState
{
  static
  {
    BalanceState localBalanceState = new BalanceState("UNKNOWN", 3);
    UNKNOWN = localBalanceState;
    $VALUES = new BalanceState[] { BALANCED, TILTING_LEFT, TILTING_RIGHT, localBalanceState };
  }
  
  private BalanceState() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\BalanceState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */