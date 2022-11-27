package dji.midware.data.model.P3;

import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataNewSpecialControl
  extends DataSpecialControl
  implements DJIDataSyncListener
{
  private static DataNewSpecialControl instance;
  protected static volatile int mSequence;
  protected int mDataLength = 12;
  protected DataSpecialControl.FlyCtrlCmd mFlyCtrlCmd = DataSpecialControl.FlyCtrlCmd.INIT;
  protected DataSpecialControl.FlyGoHomeStaus mFlyGoHomeStatus = DataSpecialControl.FlyGoHomeStaus.INIT;
  protected DataFlycSetJoyStickParams.FlycMode mFlycMode = DataFlycSetJoyStickParams.FlycMode.OTHER;
  protected byte mGimbalByte = 0;
  protected final byte[] mKeyData = { 0, 0 };
  protected final byte[] mMultiData = { 0, 0, 0, 0 };
  protected boolean mNeedAck = false;
  protected byte mSecondaryGimbalByte = 0;
  protected SubCmd mSubMode = SubCmd.COMMON;
  protected int mVersion = 0;
  protected WorkView mWorkView = WorkView.LiveView;
  
  /* Error */
  private void doCommonPack(byte[] arg1, int arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void fillArray(byte[] arg1, int arg2, byte arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DataNewSpecialControl getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataNewSpecialControl();
      }
      DataNewSpecialControl localDataNewSpecialControl = instance;
      return localDataNewSpecialControl;
    }
    finally {}
  }
  
  private int getSequence()
  {
    return 0;
  }
  
  /* Error */
  protected void _reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataNewSpecialControl init()
  {
    _reset();
    return this;
  }
  
  protected DataNewSpecialControl reset()
  {
    _reset();
    return this;
  }
  
  public DataNewSpecialControl resetGimbal()
  {
    return null;
  }
  
  public DataNewSpecialControl selfieGimbal()
  {
    return null;
  }
  
  public DataNewSpecialControl setCameraMode(DataCameraGetMode.MODE paramMODE)
  {
    return null;
  }
  
  public DataNewSpecialControl setFlyGoHomeStatus(DataSpecialControl.FlyGoHomeStaus paramFlyGoHomeStaus)
  {
    return null;
  }
  
  public DataNewSpecialControl setFlycMode(DataFlycSetJoyStickParams.FlycMode paramFlycMode)
  {
    return null;
  }
  
  public DataNewSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE)
  {
    return null;
  }
  
  public DataNewSpecialControl setGimbalMode(DataGimbalControl.MODE paramMODE, boolean paramBoolean)
  {
    return null;
  }
  
  public DataNewSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE)
  {
    return null;
  }
  
  public DataNewSpecialControl setPhotoType(DataCameraSetPhoto.TYPE paramTYPE, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataNewSpecialControl setPlayBackBrowserScaleType(short paramShort)
  {
    return null;
  }
  
  public DataNewSpecialControl setPlayBackBrowserType(DataSpecialControl.PlayBrowseType paramPlayBrowseType, byte paramByte1, byte paramByte2)
  {
    return null;
  }
  
  public DataNewSpecialControl setPlayBackPlayCtr(DataSpecialControl.PlayCtrType paramPlayCtrType, byte paramByte)
  {
    return null;
  }
  
  public DataNewSpecialControl setPlayBackType(boolean paramBoolean)
  {
    return null;
  }
  
  public DataNewSpecialControl setRecordType(boolean paramBoolean)
  {
    return null;
  }
  
  public DataNewSpecialControl setRecordType(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public DataNewSpecialControl setWorkView(WorkView paramWorkView)
  {
    return null;
  }
  
  public void start(long paramLong)
  {
    start((DJIDataCallBack)null);
  }
  
  /* Error */
  public void start(DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stop() {}
  
  public static enum SubCmd
  {
    private final int data;
    
    static
    {
      CAMERA = new SubCmd("CAMERA", 3, 3);
      SubCmd localSubCmd = new SubCmd("OTHER", 4, 100);
      OTHER = localSubCmd;
      $VALUES = new SubCmd[] { COMMON, FLYC, GIMBAL, CAMERA, localSubCmd };
    }
    
    private SubCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static SubCmd find(int paramInt)
    {
      SubCmd localSubCmd1 = COMMON;
      SubCmd[] arrayOfSubCmd = values();
      int j = arrayOfSubCmd.length;
      int i = 0;
      while (i < j)
      {
        SubCmd localSubCmd2 = arrayOfSubCmd[i];
        if (localSubCmd2._equals(paramInt)) {
          return localSubCmd2;
        }
        i += 1;
      }
      return localSubCmd1;
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
  
  public static enum WorkView
  {
    private final int data;
    
    static
    {
      Library = new WorkView("Library", 2, 2);
      Rc = new WorkView("Rc", 3, 3);
      WorkView localWorkView = new WorkView("OTHER", 4, 100);
      OTHER = localWorkView;
      $VALUES = new WorkView[] { LiveView, PlayBack, Library, Rc, localWorkView };
    }
    
    private WorkView(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static WorkView find(int paramInt)
    {
      WorkView localWorkView1 = LiveView;
      WorkView[] arrayOfWorkView = values();
      int j = arrayOfWorkView.length;
      int i = 0;
      while (i < j)
      {
        WorkView localWorkView2 = arrayOfWorkView[i];
        if (localWorkView2._equals(paramInt)) {
          return localWorkView2;
        }
        i += 1;
      }
      return localWorkView1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataNewSpecialControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */