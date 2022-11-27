package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataAsync2Listener;

public class DataCameraVirtualKey
  extends DataBase
  implements DJIDataAsync2Listener
{
  private static DataCameraVirtualKey instance;
  private KEY key;
  
  public static DataCameraVirtualKey getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraVirtualKey();
      }
      DataCameraVirtualKey localDataCameraVirtualKey = instance;
      return localDataCameraVirtualKey;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraVirtualKey setKey(KEY paramKEY)
  {
    this.key = paramKEY;
    return this;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum KEY
  {
    private int data;
    
    static
    {
      REC = new KEY("REC", 2, 3);
      DEL = new KEY("DEL", 3, 4);
      MODE = new KEY("MODE", 4, 5);
      UP = new KEY("UP", 5, 6);
      DOWN = new KEY("DOWN", 6, 7);
      LEFT = new KEY("LEFT", 7, 8);
      RIGHT = new KEY("RIGHT", 8, 9);
      OK = new KEY("OK", 9, 10);
      BACK = new KEY("BACK", 10, 11);
      ZOOMIN = new KEY("ZOOMIN", 11, 12);
      ZOOMOUT = new KEY("ZOOMOUT", 12, 13);
      EnterMultiDisplay = new KEY("EnterMultiDisplay", 13, 14);
      PagePrev = new KEY("PagePrev", 14, 15);
      PageNext = new KEY("PageNext", 15, 16);
      Cancel = new KEY("Cancel", 16, 17);
      Download = new KEY("Download", 17, 18);
      KEY localKEY = new KEY("OTHER", 18, 100);
      OTHER = localKEY;
      $VALUES = new KEY[] { S1, S2, REC, DEL, MODE, UP, DOWN, LEFT, RIGHT, OK, BACK, ZOOMIN, ZOOMOUT, EnterMultiDisplay, PagePrev, PageNext, Cancel, Download, localKEY };
    }
    
    private KEY(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static KEY find(int paramInt)
    {
      KEY localKEY = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localKEY;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraVirtualKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */