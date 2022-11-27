package dji.common.gimbal;

public enum BalanceTestStatus
{
  private int data;
  
  static
  {
    FINISH = new BalanceTestStatus("FINISH", 2, 2);
    BalanceTestStatus localBalanceTestStatus = new BalanceTestStatus("ERROR", 3, 3);
    ERROR = localBalanceTestStatus;
    $VALUES = new BalanceTestStatus[] { DEFAULT, TESTING, FINISH, localBalanceTestStatus };
  }
  
  private BalanceTestStatus(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static BalanceTestStatus find(int paramInt)
  {
    BalanceTestStatus localBalanceTestStatus = DEFAULT;
    BalanceTestStatus[] arrayOfBalanceTestStatus = values();
    int i = 0;
    while (i < arrayOfBalanceTestStatus.length)
    {
      if (arrayOfBalanceTestStatus[i]._equals(paramInt)) {
        return arrayOfBalanceTestStatus[i];
      }
      i += 1;
    }
    return localBalanceTestStatus;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\BalanceTestStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */