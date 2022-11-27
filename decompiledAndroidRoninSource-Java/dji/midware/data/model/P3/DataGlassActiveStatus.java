package dji.midware.data.model.P3;

import dji.midware.data.model.common.DataAbstractGetPushActiveStatus;
import dji.midware.data.model.common.DataAbstractGetPushActiveStatus.DJIActiveVersion;

public class DataGlassActiveStatus
  extends DataAbstractGetPushActiveStatus
{
  private static DataGlassActiveStatus instance;
  
  public static DataGlassActiveStatus getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataGlassActiveStatus = new DataGlassActiveStatus();
        instance = localDataGlassActiveStatus;
        localDataGlassActiveStatus.setVersion(DataAbstractGetPushActiveStatus.DJIActiveVersion.Ver1_1);
      }
      DataGlassActiveStatus localDataGlassActiveStatus = instance;
      return localDataGlassActiveStatus;
    }
    finally {}
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataGlassActiveStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */