package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushShotInfo
  extends DJICameraDataBase
{
  private static DataCameraGetPushShotInfo instance;
  
  public static DataCameraGetPushShotInfo getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushShotInfo();
      }
      DataCameraGetPushShotInfo localDataCameraGetPushShotInfo = instance;
      return localDataCameraGetPushShotInfo;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCurFocusDistance()
  {
    return 0;
  }
  
  public int getDemarcateValue()
  {
    return 0;
  }
  
  public FocusMotorState getFocusMotorState()
  {
    return null;
  }
  
  public int getFocusStatus()
  {
    return 0;
  }
  
  public int getFocusWindowRealNumX()
  {
    return 0;
  }
  
  public int getFocusWindowRealNumY()
  {
    return 0;
  }
  
  public int getFocusWindowStartX()
  {
    return 0;
  }
  
  public int getFocusWindowStartY()
  {
    return 0;
  }
  
  public FuselageFocusMode getFuselageFocusMode(int... paramVarArgs)
  {
    return null;
  }
  
  public MFDemarcateResult getMFDemarcateResult()
  {
    return null;
  }
  
  public MFDemarcateState getMFDemarcateState()
  {
    return null;
  }
  
  public float getMFFocusProbability()
  {
    return 0.0F;
  }
  
  public int getMFFocusStatus()
  {
    return 0;
  }
  
  public int getMaxAperture(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getMaxFocusDistance(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getMinAperture(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getMinFocusDistance(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getMinFocusDistanceStep(int... paramVarArgs)
  {
    return 0;
  }
  
  public float getObjDistance()
  {
    return 0.0F;
  }
  
  public ShotFDType getShotFDType(int... paramVarArgs)
  {
    return null;
  }
  
  public int getShotFocusCurStroke()
  {
    return 0;
  }
  
  public int getShotFocusMaxStroke(int... paramVarArgs)
  {
    return 0;
  }
  
  public ShotFocusMode getShotFocusMode()
  {
    return null;
  }
  
  public ShotType getShotType()
  {
    return null;
  }
  
  public float getSpotAFAxisX()
  {
    return 0.0F;
  }
  
  public float getSpotAFAxisY()
  {
    return 0.0F;
  }
  
  public int getSupportType()
  {
    return 0;
  }
  
  public int getXAxisFocusWindowNum()
  {
    return 0;
  }
  
  public int getYAxisFocusWindowNum()
  {
    return 0;
  }
  
  public ZoomFocusType getZoomFocusType(int... paramVarArgs)
  {
    return null;
  }
  
  public boolean isDigitalFocusAEnable()
  {
    return false;
  }
  
  public boolean isDigitalFocusEnable()
  {
    return false;
  }
  
  public boolean isDigitalFocusMEnable()
  {
    return false;
  }
  
  public boolean isShotConnected()
  {
    return false;
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum FocusMotorState
  {
    private final int data;
    
    static
    {
      INIT_FAIL = new FocusMotorState("INIT_FAIL", 1, 1);
      STUCK = new FocusMotorState("STUCK", 2, 2);
      BROKEN = new FocusMotorState("BROKEN", 3, 3);
      FocusMotorState localFocusMotorState = new FocusMotorState("OTHER", 4, 100);
      OTHER = localFocusMotorState;
      $VALUES = new FocusMotorState[] { NORMAL, INIT_FAIL, STUCK, BROKEN, localFocusMotorState };
    }
    
    private FocusMotorState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FocusMotorState find(int paramInt)
    {
      FocusMotorState localFocusMotorState1 = NORMAL;
      FocusMotorState[] arrayOfFocusMotorState = values();
      int j = arrayOfFocusMotorState.length;
      int i = 0;
      while (i < j)
      {
        FocusMotorState localFocusMotorState2 = arrayOfFocusMotorState[i];
        if (localFocusMotorState2._equals(paramInt)) {
          return localFocusMotorState2;
        }
        i += 1;
      }
      return localFocusMotorState1;
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
  
  public static enum FuselageFocusMode
  {
    private int data;
    
    static
    {
      ContinuousAuto = new FuselageFocusMode("ContinuousAuto", 2, 2);
      ManualFine = new FuselageFocusMode("ManualFine", 3, 3);
      FuselageFocusMode localFuselageFocusMode = new FuselageFocusMode("OTHER", 4, 6);
      OTHER = localFuselageFocusMode;
      $VALUES = new FuselageFocusMode[] { Manual, OneAuto, ContinuousAuto, ManualFine, localFuselageFocusMode };
    }
    
    private FuselageFocusMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FuselageFocusMode find(int paramInt)
    {
      FuselageFocusMode localFuselageFocusMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFuselageFocusMode;
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
  
  public static enum MFDemarcateResult
  {
    private final int data;
    
    static
    {
      COMPLETED = new MFDemarcateResult("COMPLETED", 1, 1);
      FAIL = new MFDemarcateResult("FAIL", 2, 2);
      MFDemarcateResult localMFDemarcateResult = new MFDemarcateResult("OTHER", 3, 100);
      OTHER = localMFDemarcateResult;
      $VALUES = new MFDemarcateResult[] { IDLE, COMPLETED, FAIL, localMFDemarcateResult };
    }
    
    private MFDemarcateResult(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MFDemarcateResult find(int paramInt)
    {
      MFDemarcateResult localMFDemarcateResult1 = IDLE;
      MFDemarcateResult[] arrayOfMFDemarcateResult = values();
      int j = arrayOfMFDemarcateResult.length;
      int i = 0;
      while (i < j)
      {
        MFDemarcateResult localMFDemarcateResult2 = arrayOfMFDemarcateResult[i];
        if (localMFDemarcateResult2._equals(paramInt)) {
          return localMFDemarcateResult2;
        }
        i += 1;
      }
      return localMFDemarcateResult1;
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
  
  public static enum MFDemarcateState
  {
    private final int data;
    
    static
    {
      DEMARCATED = new MFDemarcateState("DEMARCATED", 1, 1);
      DEMARCATING = new MFDemarcateState("DEMARCATING", 2, 2);
      MFDemarcateState localMFDemarcateState = new MFDemarcateState("OTHER", 3, 100);
      OTHER = localMFDemarcateState;
      $VALUES = new MFDemarcateState[] { NOT_DEMARCATE, DEMARCATED, DEMARCATING, localMFDemarcateState };
    }
    
    private MFDemarcateState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MFDemarcateState find(int paramInt)
    {
      MFDemarcateState localMFDemarcateState1 = NOT_DEMARCATE;
      MFDemarcateState[] arrayOfMFDemarcateState = values();
      int j = arrayOfMFDemarcateState.length;
      int i = 0;
      while (i < j)
      {
        MFDemarcateState localMFDemarcateState2 = arrayOfMFDemarcateState[i];
        if (localMFDemarcateState2._equals(paramInt)) {
          return localMFDemarcateState2;
        }
        i += 1;
      }
      return localMFDemarcateState1;
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
  
  public static enum ShotFDType
  {
    private int data;
    
    static
    {
      ShotFDType localShotFDType = new ShotFDType("OTHER", 2, 6);
      OTHER = localShotFDType;
      $VALUES = new ShotFDType[] { FixedShotFD, ZoomShotFD, localShotFDType };
    }
    
    private ShotFDType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ShotFDType find(int paramInt)
    {
      ShotFDType localShotFDType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localShotFDType;
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
  
  public static enum ShotFocusMode
  {
    private int data;
    
    static
    {
      Auto = new ShotFocusMode("Auto", 1, 1);
      ShotFocusMode localShotFocusMode = new ShotFocusMode("OTHER", 2, 6);
      OTHER = localShotFocusMode;
      $VALUES = new ShotFocusMode[] { Manual, Auto, localShotFocusMode };
    }
    
    private ShotFocusMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ShotFocusMode find(int paramInt)
    {
      ShotFocusMode localShotFocusMode = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localShotFocusMode;
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
  
  public static enum ShotType
  {
    private int data;
    
    static
    {
      ShotType localShotType = new ShotType("OTHER", 2, 6);
      OTHER = localShotType;
      $VALUES = new ShotType[] { AF, MF, localShotType };
    }
    
    private ShotType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ShotType find(int paramInt)
    {
      ShotType localShotType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localShotType;
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
  
  public static enum ZoomFocusType
  {
    private int data;
    
    static
    {
      AutoZoomFocus = new ZoomFocusType("AutoZoomFocus", 1, 1);
      ZoomFocusType localZoomFocusType = new ZoomFocusType("OTHER", 2, 6);
      OTHER = localZoomFocusType;
      $VALUES = new ZoomFocusType[] { ManualZoomFocus, AutoZoomFocus, localZoomFocusType };
    }
    
    private ZoomFocusType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ZoomFocusType find(int paramInt)
    {
      ZoomFocusType localZoomFocusType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localZoomFocusType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushShotInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */