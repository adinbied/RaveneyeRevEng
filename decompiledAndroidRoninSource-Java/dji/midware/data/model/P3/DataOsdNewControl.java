package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataOsdNewControl
  extends DJICameraDataBase
{
  private static DataOsdNewControl instance;
  
  public static DataOsdNewControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataOsdNewControl();
      }
      DataOsdNewControl localDataOsdNewControl = instance;
      return localDataOsdNewControl;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCtrObjectForOne()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataOsdNewControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */