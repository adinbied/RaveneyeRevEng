package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataThirdPartyCameraSetInfo
  extends DataBase
  implements DJIDataSyncListener
{
  private int mReceiverId;
  
  public static DataThirdPartyCameraSetInfo getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void setSendData(ThirdPartyCameraInfoTypeID arg1, int arg2, byte[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void doPack() {}
  
  public DataThirdPartyCameraSetInfo setCanonFocusSpeed(CameraFocusSpeedCanon paramCameraFocusSpeedCanon)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setLinearFocusSpeed(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setLinearZoomSpeed(int paramInt)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setNikonFocusSpeed(CameraFocusSpeedNikon paramCameraFocusSpeedNikon)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setPanasonicFocusSpeed(CameraFocusSpeedPanasonic paramCameraFocusSpeedPanasonic)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setReceiveId(int paramInt)
  {
    this.mReceiverId = paramInt;
    return this;
  }
  
  public DataThirdPartyCameraSetInfo setSonyFocusSpeed(CameraFocusSpeedSony paramCameraFocusSpeedSony)
  {
    return null;
  }
  
  public DataThirdPartyCameraSetInfo setZoomSpeed(CameraZoomSpeed paramCameraZoomSpeed)
  {
    return null;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum CameraFocusSpeedCanon
  {
    private int data;
    
    static
    {
      CameraFocusSpeedCanon localCameraFocusSpeedCanon = new CameraFocusSpeedCanon("CANON_FOCUS_SPEED_LEVEL_3", 2, 3);
      CANON_FOCUS_SPEED_LEVEL_3 = localCameraFocusSpeedCanon;
      $VALUES = new CameraFocusSpeedCanon[] { CANON_FOCUS_SPEED_LEVEL_1, CANON_FOCUS_SPEED_LEVEL_2, localCameraFocusSpeedCanon };
    }
    
    private CameraFocusSpeedCanon(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraFocusSpeedCanon find(int paramInt)
    {
      CameraFocusSpeedCanon localCameraFocusSpeedCanon = CANON_FOCUS_SPEED_LEVEL_1;
      CameraFocusSpeedCanon[] arrayOfCameraFocusSpeedCanon = values();
      int i = 0;
      while (i < arrayOfCameraFocusSpeedCanon.length)
      {
        if (arrayOfCameraFocusSpeedCanon[i]._equals(paramInt)) {
          return arrayOfCameraFocusSpeedCanon[i];
        }
        i += 1;
      }
      return localCameraFocusSpeedCanon;
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
  
  public static enum CameraFocusSpeedNikon
  {
    private int data;
    
    static
    {
      CameraFocusSpeedNikon localCameraFocusSpeedNikon = new CameraFocusSpeedNikon("NIKON_FOCUS_SPEED_LEVEL_5", 4, 5);
      NIKON_FOCUS_SPEED_LEVEL_5 = localCameraFocusSpeedNikon;
      $VALUES = new CameraFocusSpeedNikon[] { NIKON_FOCUS_SPEED_LEVEL_1, NIKON_FOCUS_SPEED_LEVEL_2, NIKON_FOCUS_SPEED_LEVEL_3, NIKON_FOCUS_SPEED_LEVEL_4, localCameraFocusSpeedNikon };
    }
    
    private CameraFocusSpeedNikon(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraFocusSpeedNikon find(int paramInt)
    {
      CameraFocusSpeedNikon localCameraFocusSpeedNikon = NIKON_FOCUS_SPEED_LEVEL_1;
      CameraFocusSpeedNikon[] arrayOfCameraFocusSpeedNikon = values();
      int i = 0;
      while (i < arrayOfCameraFocusSpeedNikon.length)
      {
        if (arrayOfCameraFocusSpeedNikon[i]._equals(paramInt)) {
          return arrayOfCameraFocusSpeedNikon[i];
        }
        i += 1;
      }
      return localCameraFocusSpeedNikon;
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
  
  public static enum CameraFocusSpeedPanasonic
  {
    private int data;
    
    static
    {
      CameraFocusSpeedPanasonic localCameraFocusSpeedPanasonic = new CameraFocusSpeedPanasonic("PANASONIC_FOCUS_SPEED_LEVEL_2", 1, 2);
      PANASONIC_FOCUS_SPEED_LEVEL_2 = localCameraFocusSpeedPanasonic;
      $VALUES = new CameraFocusSpeedPanasonic[] { PANASONIC_FOCUS_SPEED_LEVEL_1, localCameraFocusSpeedPanasonic };
    }
    
    private CameraFocusSpeedPanasonic(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraFocusSpeedPanasonic find(int paramInt)
    {
      CameraFocusSpeedPanasonic localCameraFocusSpeedPanasonic = PANASONIC_FOCUS_SPEED_LEVEL_1;
      CameraFocusSpeedPanasonic[] arrayOfCameraFocusSpeedPanasonic = values();
      int i = 0;
      while (i < arrayOfCameraFocusSpeedPanasonic.length)
      {
        if (arrayOfCameraFocusSpeedPanasonic[i]._equals(paramInt)) {
          return arrayOfCameraFocusSpeedPanasonic[i];
        }
        i += 1;
      }
      return localCameraFocusSpeedPanasonic;
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
  
  public static enum CameraFocusSpeedSony
  {
    private int data;
    
    static
    {
      CameraFocusSpeedSony localCameraFocusSpeedSony = new CameraFocusSpeedSony("SONY_FOCUS_SPEED_LEVEL_3", 2, 3);
      SONY_FOCUS_SPEED_LEVEL_3 = localCameraFocusSpeedSony;
      $VALUES = new CameraFocusSpeedSony[] { SONY_FOCUS_SPEED_LEVEL_1, SONY_FOCUS_SPEED_LEVEL_2, localCameraFocusSpeedSony };
    }
    
    private CameraFocusSpeedSony(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraFocusSpeedSony find(int paramInt)
    {
      CameraFocusSpeedSony localCameraFocusSpeedSony = SONY_FOCUS_SPEED_LEVEL_1;
      CameraFocusSpeedSony[] arrayOfCameraFocusSpeedSony = values();
      int i = 0;
      while (i < arrayOfCameraFocusSpeedSony.length)
      {
        if (arrayOfCameraFocusSpeedSony[i]._equals(paramInt)) {
          return arrayOfCameraFocusSpeedSony[i];
        }
        i += 1;
      }
      return localCameraFocusSpeedSony;
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
  
  public static enum CameraZoomSpeed
  {
    private int data;
    
    static
    {
      CameraZoomSpeed localCameraZoomSpeed = new CameraZoomSpeed("FAST", 1, 1);
      FAST = localCameraZoomSpeed;
      $VALUES = new CameraZoomSpeed[] { SLOW, localCameraZoomSpeed };
    }
    
    private CameraZoomSpeed(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraZoomSpeed find(int paramInt)
    {
      CameraZoomSpeed localCameraZoomSpeed = SLOW;
      CameraZoomSpeed[] arrayOfCameraZoomSpeed = values();
      int i = 0;
      while (i < arrayOfCameraZoomSpeed.length)
      {
        if (arrayOfCameraZoomSpeed[i]._equals(paramInt)) {
          return arrayOfCameraZoomSpeed[i];
        }
        i += 1;
      }
      return localCameraZoomSpeed;
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
  
  private static final class SingletonHolder
  {
    private static final DataThirdPartyCameraSetInfo mInstance = new DataThirdPartyCameraSetInfo();
  }
  
  public static enum ThirdPartyCameraInfoTypeID
  {
    private int data;
    
    static
    {
      USB_TYPE = new ThirdPartyCameraInfoTypeID("USB_TYPE", 1, 2);
      FOCUS_SPEED_NIKON = new ThirdPartyCameraInfoTypeID("FOCUS_SPEED_NIKON", 2, 3);
      FOCUS_SPEED_CANON = new ThirdPartyCameraInfoTypeID("FOCUS_SPEED_CANON", 3, 4);
      FOCUS_SPEED_FUJI = new ThirdPartyCameraInfoTypeID("FOCUS_SPEED_FUJI", 4, 5);
      FOCUS_SPEED_PANASONIC = new ThirdPartyCameraInfoTypeID("FOCUS_SPEED_PANASONIC", 5, 6);
      FOCUS_SPEED_SONY = new ThirdPartyCameraInfoTypeID("FOCUS_SPEED_SONY", 6, 7);
      LINEAR_ZOOM_SPEED = new ThirdPartyCameraInfoTypeID("LINEAR_ZOOM_SPEED", 7, 254);
      ThirdPartyCameraInfoTypeID localThirdPartyCameraInfoTypeID = new ThirdPartyCameraInfoTypeID("OTHER", 8, 255);
      OTHER = localThirdPartyCameraInfoTypeID;
      $VALUES = new ThirdPartyCameraInfoTypeID[] { ZOOM_SPEED, USB_TYPE, FOCUS_SPEED_NIKON, FOCUS_SPEED_CANON, FOCUS_SPEED_FUJI, FOCUS_SPEED_PANASONIC, FOCUS_SPEED_SONY, LINEAR_ZOOM_SPEED, localThirdPartyCameraInfoTypeID };
    }
    
    private ThirdPartyCameraInfoTypeID(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ThirdPartyCameraInfoTypeID find(int paramInt)
    {
      ThirdPartyCameraInfoTypeID localThirdPartyCameraInfoTypeID = OTHER;
      ThirdPartyCameraInfoTypeID[] arrayOfThirdPartyCameraInfoTypeID = values();
      int i = 0;
      while (i < arrayOfThirdPartyCameraInfoTypeID.length)
      {
        if (arrayOfThirdPartyCameraInfoTypeID[i]._equals(paramInt)) {
          return arrayOfThirdPartyCameraInfoTypeID[i];
        }
        i += 1;
      }
      return localThirdPartyCameraInfoTypeID;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataThirdPartyCameraSetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */