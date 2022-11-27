package dji.midware.data.model.extension;

public class ThirdPartyCameraDataConverter
{
  private static String TAG = "ThirdPartyCameraDataConverter";
  private static ThirdPartyCameraDataConverter instance;
  private boolean debug = false;
  
  /* Error */
  private void convertToShootInfoData(dji.midware.data.model.P3.DataThirdPartyCameraGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void convertToShootParamData(dji.midware.data.model.P3.DataThirdPartyCameraGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void convertToStateInfoData(dji.midware.data.model.P3.DataThirdPartyCameraGetPushParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static ThirdPartyCameraDataConverter getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new ThirdPartyCameraDataConverter();
      }
      ThirdPartyCameraDataConverter localThirdPartyCameraDataConverter = instance;
      return localThirdPartyCameraDataConverter;
    }
    finally {}
  }
  
  /* Error */
  public void converterData()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\extension\ThirdPartyCameraDataConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */