package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataFlycSetEscEcho
  extends DataBase
  implements DJIDataSyncListener
{
  private int mIndex = 0;
  private SetEchoCmd mSetEchoCmd = SetEchoCmd.OPEN_ALL;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public SetResult getSetResult()
  {
    return null;
  }
  
  public boolean isEchoing()
  {
    return false;
  }
  
  public DataFlycSetEscEcho setEchoCmd(SetEchoCmd paramSetEchoCmd)
  {
    this.mSetEchoCmd = paramSetEchoCmd;
    return this;
  }
  
  public DataFlycSetEscEcho setEchoIndex(int paramInt)
  {
    this.mIndex = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum SetEchoCmd
  {
    private final int data;
    
    static
    {
      CLOSE_ONE = new SetEchoCmd("CLOSE_ONE", 2, 3);
      OPEN_ONE = new SetEchoCmd("OPEN_ONE", 3, 4);
      REQUEST_SOME = new SetEchoCmd("REQUEST_SOME", 4, 5);
      SetEchoCmd localSetEchoCmd = new SetEchoCmd("OTHER", 5, 100);
      OTHER = localSetEchoCmd;
      $VALUES = new SetEchoCmd[] { CLOSE_ALL, OPEN_ALL, CLOSE_ONE, OPEN_ONE, REQUEST_SOME, localSetEchoCmd };
    }
    
    private SetEchoCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SetEchoCmd find(int paramInt)
    {
      SetEchoCmd localSetEchoCmd1 = CLOSE_ALL;
      SetEchoCmd[] arrayOfSetEchoCmd = values();
      int j = arrayOfSetEchoCmd.length;
      int i = 0;
      while (i < j)
      {
        SetEchoCmd localSetEchoCmd2 = arrayOfSetEchoCmd[i];
        if (localSetEchoCmd2._equals(paramInt)) {
          return localSetEchoCmd2;
        }
        i += 1;
      }
      return localSetEchoCmd1;
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
  
  public static enum SetResult
  {
    private final int data;
    
    static
    {
      FAIL_MOTORUP = new SetResult("FAIL_MOTORUP", 1, 1);
      FAIL_NONSMART = new SetResult("FAIL_NONSMART", 2, 2);
      FAIL_ILLEGALCMD = new SetResult("FAIL_ILLEGALCMD", 3, 3);
      FAIL_ERRORID = new SetResult("FAIL_ERRORID", 4, 4);
      SetResult localSetResult = new SetResult("OTHER", 5, 100);
      OTHER = localSetResult;
      $VALUES = new SetResult[] { SUCCESS, FAIL_MOTORUP, FAIL_NONSMART, FAIL_ILLEGALCMD, FAIL_ERRORID, localSetResult };
    }
    
    private SetResult(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SetResult find(int paramInt)
    {
      SetResult localSetResult1 = SUCCESS;
      SetResult[] arrayOfSetResult = values();
      int j = arrayOfSetResult.length;
      int i = 0;
      while (i < j)
      {
        SetResult localSetResult2 = arrayOfSetResult[i];
        if (localSetResult2._equals(paramInt)) {
          return localSetResult2;
        }
        i += 1;
      }
      return localSetResult1;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycSetEscEcho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */