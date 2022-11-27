package dji.midware.data.model.P3;

import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataCallBack;

@Deprecated
public abstract class DataSpecialControl
  extends DataBase
{
  @Deprecated
  public static DataSpecialControl getInstance()
  {
    try
    {
      if (useNewControl())
      {
        localObject1 = DataNewSpecialControl.getInstance();
        return (DataSpecialControl)localObject1;
      }
      Object localObject1 = DataOldSpecialControl.getInstance();
      return (DataSpecialControl)localObject1;
    }
    finally {}
  }
  
  private static final boolean useNewControl()
  {
    ProductType localProductType = DJIProductManager.getInstance().getType();
    return (ProductType.Pomato == localProductType) || (ProductType.Orange2 == localProductType) || (ProductType.M200 == localProductType) || (ProductType.M210 == localProductType) || (ProductType.M210RTK == localProductType) || (ProductType.Potato == localProductType);
  }
  
  protected abstract void _reset();
  
  protected abstract void doPack();
  
  public abstract DataSpecialControl init();
  
  protected abstract DataSpecialControl reset();
  
  public abstract DataSpecialControl resetGimbal();
  
  public abstract DataSpecialControl selfieGimbal();
  
  public abstract DataSpecialControl setFlyGoHomeStatus(FlyGoHomeStaus paramFlyGoHomeStaus);
  
  public abstract DataSpecialControl setFlycMode(DataFlycSetJoyStickParams.FlycMode paramFlycMode);
  
  public abstract DataSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE);
  
  public abstract DataSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE, boolean paramBoolean);
  
  public abstract DataSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE);
  
  public abstract DataSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE, int paramInt1, int paramInt2);
  
  public abstract DataSpecialControl setPlayBackBrowserScaleType(short paramShort);
  
  public abstract DataSpecialControl setPlayBackBrowserType(PlayBrowseType paramPlayBrowseType, byte paramByte1, byte paramByte2);
  
  public abstract DataSpecialControl setPlayBackPlayCtr(PlayCtrType paramPlayCtrType, byte paramByte);
  
  public abstract DataSpecialControl setPlayBackType(boolean paramBoolean);
  
  public abstract DataSpecialControl setRecordType(boolean paramBoolean);
  
  public abstract DataSpecialControl setRecordType(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void start(long paramLong);
  
  public abstract void start(DJIDataCallBack paramDJIDataCallBack);
  
  public abstract void stop();
  
  public static enum FlyCtrlCmd
  {
    private final int data;
    
    static
    {
      LAND = new FlyCtrlCmd("LAND", 2, 3);
      FlyCtrlCmd localFlyCtrlCmd = new FlyCtrlCmd("OTHER", 3, 100);
      OTHER = localFlyCtrlCmd;
      $VALUES = new FlyCtrlCmd[] { INIT, TAKEOFF, LAND, localFlyCtrlCmd };
    }
    
    private FlyCtrlCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FlyCtrlCmd find(int paramInt)
    {
      FlyCtrlCmd localFlyCtrlCmd1 = INIT;
      FlyCtrlCmd[] arrayOfFlyCtrlCmd = values();
      int j = arrayOfFlyCtrlCmd.length;
      int i = 0;
      while (i < j)
      {
        FlyCtrlCmd localFlyCtrlCmd2 = arrayOfFlyCtrlCmd[i];
        if (localFlyCtrlCmd2._equals(paramInt)) {
          return localFlyCtrlCmd2;
        }
        i += 1;
      }
      return localFlyCtrlCmd1;
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
  
  public static enum FlyGoHomeStaus
  {
    private byte mData = 1;
    
    static
    {
      FlyGoHomeStaus localFlyGoHomeStaus = new FlyGoHomeStaus("EXIT", 2, (byte)3);
      EXIT = localFlyGoHomeStaus;
      $VALUES = new FlyGoHomeStaus[] { INIT, START, localFlyGoHomeStaus };
    }
    
    private FlyGoHomeStaus(byte paramByte)
    {
      this.mData = paramByte;
    }
    
    public static FlyGoHomeStaus find(int paramInt)
    {
      FlyGoHomeStaus localFlyGoHomeStaus = INIT;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFlyGoHomeStaus;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mData == paramInt;
    }
    
    public byte value()
    {
      return this.mData;
    }
  }
  
  public static enum MulDelValue
  {
    private byte data;
    
    static
    {
      MulDelValue localMulDelValue = new MulDelValue("INVALID", 4, (byte)0);
      INVALID = localMulDelValue;
      $VALUES = new MulDelValue[] { ALL_CANCEL, ALL_SELECT, PAGE_CANCEL, PAGE_SELECT, localMulDelValue };
    }
    
    private MulDelValue(byte paramByte)
    {
      this.data = paramByte;
    }
    
    public static MulDelValue find(byte paramByte)
    {
      MulDelValue localMulDelValue = INVALID;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramByte)) {
          return values()[i];
        }
        i += 1;
      }
      return localMulDelValue;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public byte value()
    {
      return this.data;
    }
  }
  
  public static enum PlayBrowseType
  {
    private int data;
    
    static
    {
      DELETE = new PlayBrowseType("DELETE", 2, 2);
      PAGEDOWN = new PlayBrowseType("PAGEDOWN", 3, 3);
      PAGEUP = new PlayBrowseType("PAGEUP", 4, 4);
      RIGHT = new PlayBrowseType("RIGHT", 5, 5);
      LEFT = new PlayBrowseType("LEFT", 6, 6);
      DOWN = new PlayBrowseType("DOWN", 7, 7);
      UP = new PlayBrowseType("UP", 8, 8);
      ZOOMOUT = new PlayBrowseType("ZOOMOUT", 9, 9);
      ZOOMIN = new PlayBrowseType("ZOOMIN", 10, 10);
      MULTIPLY = new PlayBrowseType("MULTIPLY", 11, 11);
      SINGLE = new PlayBrowseType("SINGLE", 12, 12);
      MULTIPLY_DEL = new PlayBrowseType("MULTIPLY_DEL", 13, 13);
      SCALE = new PlayBrowseType("SCALE", 14, 14);
      DRAG = new PlayBrowseType("DRAG", 15, 15);
      PlayBrowseType localPlayBrowseType = new PlayBrowseType("OTHER", 16, 100);
      OTHER = localPlayBrowseType;
      $VALUES = new PlayBrowseType[] { CANCEL, ENTER, DELETE, PAGEDOWN, PAGEUP, RIGHT, LEFT, DOWN, UP, ZOOMOUT, ZOOMIN, MULTIPLY, SINGLE, MULTIPLY_DEL, SCALE, DRAG, localPlayBrowseType };
    }
    
    private PlayBrowseType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PlayBrowseType find(int paramInt)
    {
      PlayBrowseType localPlayBrowseType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPlayBrowseType;
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
  
  public static enum PlayCtrType
  {
    private int data;
    
    static
    {
      PAUSE = new PlayCtrType("PAUSE", 2, 2);
      FastForward = new PlayCtrType("FastForward", 3, 3);
      FastRewind = new PlayCtrType("FastRewind", 4, 4);
      TouchProgress = new PlayCtrType("TouchProgress", 5, 5);
      PlayCtrType localPlayCtrType = new PlayCtrType("OTHER", 6, 100);
      OTHER = localPlayCtrType;
      $VALUES = new PlayCtrType[] { START, STOP, PAUSE, FastForward, FastRewind, TouchProgress, localPlayCtrType };
    }
    
    private PlayCtrType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PlayCtrType find(int paramInt)
    {
      PlayCtrType localPlayCtrType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPlayCtrType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSpecialControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */