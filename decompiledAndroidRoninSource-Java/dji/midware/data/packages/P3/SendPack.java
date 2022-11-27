package dji.midware.data.packages.P3;

public class SendPack
  extends Pack
{
  public static final int packRepeatTimes = 2;
  public static final int packTimeOut = 1000;
  public PackBufferObject bufferObject;
  public int repeatTimes = 2;
  public int timeOut = 1000;
  
  /* Error */
  public void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void reCrc()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\P3\SendPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */