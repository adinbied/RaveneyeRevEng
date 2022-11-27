package dji.pilot.active;

public class DJIActiveErrorModel
{
  public String devices;
  public String errorCode;
  public String errorLog;
  public String errorType;
  public String responseJson;
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\DJIActiveErrorModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */