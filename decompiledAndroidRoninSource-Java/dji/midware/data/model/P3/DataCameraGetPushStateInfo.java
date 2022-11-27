package dji.midware.data.model.P3;

import dji.midware.data.model.base.DJICameraDataBase;

public class DataCameraGetPushStateInfo
  extends DJICameraDataBase
{
  private static DataCameraGetPushStateInfo instance;
  
  public static DataCameraGetPushStateInfo getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataCameraGetPushStateInfo = new DataCameraGetPushStateInfo();
        instance = localDataCameraGetPushStateInfo;
        localDataCameraGetPushStateInfo.isNeedPushLosed = true;
        instance.isRemoteModel = true;
      }
      DataCameraGetPushStateInfo localDataCameraGetPushStateInfo = instance;
      return localDataCameraGetPushStateInfo;
    }
    finally {}
  }
  
  public boolean beInDebugMode()
  {
    return false;
  }
  
  public boolean beInTrackingMode(int... paramVarArgs)
  {
    return false;
  }
  
  public void clear()
  {
    super.clear();
  }
  
  protected void doPack() {}
  
  public CameraProtocolType getCameraProtocolType(int... paramVarArgs)
  {
    return null;
  }
  
  public CameraType getCameraType(int... paramVarArgs)
  {
    return null;
  }
  
  public boolean getConnectState()
  {
    return false;
  }
  
  public boolean getEnabledPhoto(int... paramVarArgs)
  {
    return false;
  }
  
  public EncryptStatus getEncryptStatus()
  {
    return null;
  }
  
  public boolean getFastPlayBackEnabled()
  {
    return false;
  }
  
  public int getFastPlayBackTime()
  {
    return 0;
  }
  
  public DataCameraSetFileIndexMode.FileIndexMode getFileIndexMode()
  {
    return null;
  }
  
  public DataCameraGetStateInfo.FirmErrorType getFirmUpgradeErrorState()
  {
    return null;
  }
  
  public boolean getFirmUpgradeState()
  {
    return false;
  }
  
  public boolean getHotState()
  {
    return false;
  }
  
  public boolean getIsGimbalBusy()
  {
    return false;
  }
  
  public boolean getIsStoring(int... paramVarArgs)
  {
    return false;
  }
  
  public boolean getIsTimePhotoing(int... paramVarArgs)
  {
    return false;
  }
  
  public int getMaxPhotoNum()
  {
    return 0;
  }
  
  public DataCameraGetMode.MODE getMode(int... paramVarArgs)
  {
    return null;
  }
  
  public boolean getPhotoOsdApertureIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdContrastIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdExposureIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdIsoIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdSaturationIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdSharpeIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdShutterIsShow()
  {
    return false;
  }
  
  public boolean getPhotoOsdTimeIsShow()
  {
    return false;
  }
  
  public DataCameraGetStateInfo.PhotoState getPhotoState(int... paramVarArgs)
  {
    return null;
  }
  
  public RecordType getRecordState(int... paramVarArgs)
  {
    return null;
  }
  
  public long getRemainedShots()
  {
    return 277830241L;
  }
  
  public int getRemainedTime()
  {
    return 0;
  }
  
  public int getSDCardFreeSize()
  {
    return 0;
  }
  
  public boolean getSDCardInsertState(int... paramVarArgs)
  {
    return false;
  }
  
  public DataCameraGetStateInfo.SDCardState getSDCardState(boolean paramBoolean)
  {
    return null;
  }
  
  public DataCameraGetStateInfo.SDCardState getSDCardState(int... paramVarArgs)
  {
    return null;
  }
  
  public int getSDCardTotalSize()
  {
    return 0;
  }
  
  public boolean getSensorState()
  {
    return false;
  }
  
  public boolean getTimeSyncState()
  {
    return false;
  }
  
  public boolean getUsbState()
  {
    return false;
  }
  
  public int getVerstion(int... paramVarArgs)
  {
    return 0;
  }
  
  public int getVideoRecordTime()
  {
    return 0;
  }
  
  public boolean hasPrimaryCameraRecData()
  {
    return false;
  }
  
  public boolean hasSecondaryCameraRecData()
  {
    return false;
  }
  
  public boolean isHistogramEnable()
  {
    return false;
  }
  
  public boolean isOK()
  {
    return false;
  }
  
  /* Error */
  protected void setPushLose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void setPushRecData(byte[] paramArrayOfByte)
  {
    super.setPushRecData(paramArrayOfByte);
  }
  
  public static enum CameraProtocolType
  {
    private int data;
    
    static
    {
      APP2_LIB = new CameraProtocolType("APP2_LIB", 1, 1);
      P3SSupport2_7k = new CameraProtocolType("P3SSupport2_7k", 2, 2);
      FC350Support1080_120 = new CameraProtocolType("FC350Support1080_120", 3, 3);
      FC350SupportDigiZoomAndOSMONO368 = new CameraProtocolType("FC350SupportDigiZoomAndOSMONO368", 4, 4);
      CameraProtocolType localCameraProtocolType = new CameraProtocolType("FC330XTureColor", 5, 7);
      FC330XTureColor = localCameraProtocolType;
      $VALUES = new CameraProtocolType[] { Default, APP2_LIB, P3SSupport2_7k, FC350Support1080_120, FC350SupportDigiZoomAndOSMONO368, localCameraProtocolType };
    }
    
    private CameraProtocolType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraProtocolType find(int paramInt)
    {
      CameraProtocolType localCameraProtocolType = Default;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localCameraProtocolType;
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
  
  public static enum CameraType
  {
    private static volatile CameraType[] sValues = null;
    private int data;
    
    static
    {
      DJICameraTypeFC260 = new CameraType("DJICameraTypeFC260", 2, 2);
      DJICameraTypeFC300S = new CameraType("DJICameraTypeFC300S", 3, 3);
      DJICameraTypeFC300X = new CameraType("DJICameraTypeFC300X", 4, 4);
      DJICameraTypeFC550Raw = new CameraType("DJICameraTypeFC550Raw", 5, 5);
      DJICameraTypeFC330X = new CameraType("DJICameraTypeFC330X", 6, 6);
      DJICameraTypeTau640 = new CameraType("DJICameraTypeTau640", 7, 7);
      DJICameraTypeTau336 = new CameraType("DJICameraTypeTau336", 8, 8);
      DJICameraTypeFC220 = new CameraType("DJICameraTypeFC220", 9, 9);
      DJICameraTypeFC300XW = new CameraType("DJICameraTypeFC300XW", 10, 10);
      DJICameraTypeCV600 = new CameraType("DJICameraTypeCV600", 11, 11);
      DJICameraTypeFC6310 = new CameraType("DJICameraTypeFC6310", 12, 13);
      DJICameraTypeFC6510 = new CameraType("DJICameraTypeFC6510", 13, 14);
      DJICameraTypeFC6520 = new CameraType("DJICameraTypeFC6520", 14, 15);
      DJICameraTypeFC220S = new CameraType("DJICameraTypeFC220S", 15, 18);
      DJICameraTypeFC1102 = new CameraType("DJICameraTypeFC1102", 16, 19);
      DJICameraTypeGD600 = new CameraType("DJICameraTypeGD600", 17, 20);
      DJICameraTypeHasselH6D_50C = new CameraType("DJICameraTypeHasselH6D_50C", 18, 166);
      DJICameraTypeHasselH6D_100C = new CameraType("DJICameraTypeHasselH6D_100C", 19, 167);
      DJICameraTypeRed = new CameraType("DJICameraTypeRed", 20, 168);
      DJICameraTypeArri = new CameraType("DJICameraTypeArri", 21, 169);
      DJICameraTypeUSBNikon = new CameraType("DJICameraTypeUSBNikon", 22, 173);
      DJICameraTypeThirdParty_Sony = new CameraType("DJICameraTypeThirdParty_Sony", 23, 174);
      DJICameraTypeThirdParty_Panasonic = new CameraType("DJICameraTypeThirdParty_Panasonic", 24, 175);
      DJICameraTypeThirdParty_Canon = new CameraType("DJICameraTypeThirdParty_Canon", 25, 176);
      DJICameraTypeThirdParty_DefaultSony = new CameraType("DJICameraTypeThirdParty_DefaultSony", 26, 177);
      DJICameraTypeThirdParty_Hassel = new CameraType("DJICameraTypeThirdParty_Hassel", 27, 178);
      DJICameraTypeThirdParty_FUJI = new CameraType("DJICameraTypeThirdParty_FUJI", 28, 179);
      DJICameraTypeThirdParty_BMPCC = new CameraType("DJICameraTypeThirdParty_BMPCC", 29, 180);
      DJICameraTypeThirdParty_ZCam = new CameraType("DJICameraTypeThirdParty_ZCam", 30, 181);
      DJICameraTypeThirdParty_OLYMPUS = new CameraType("DJICameraTypeThirdParty_OLYMPUS", 31, 182);
      CameraType localCameraType = new CameraType("OTHER", 32, 255);
      OTHER = localCameraType;
      $VALUES = new CameraType[] { DJICameraTypeFC350, DJICameraTypeFC550, DJICameraTypeFC260, DJICameraTypeFC300S, DJICameraTypeFC300X, DJICameraTypeFC550Raw, DJICameraTypeFC330X, DJICameraTypeTau640, DJICameraTypeTau336, DJICameraTypeFC220, DJICameraTypeFC300XW, DJICameraTypeCV600, DJICameraTypeFC6310, DJICameraTypeFC6510, DJICameraTypeFC6520, DJICameraTypeFC220S, DJICameraTypeFC1102, DJICameraTypeGD600, DJICameraTypeHasselH6D_50C, DJICameraTypeHasselH6D_100C, DJICameraTypeRed, DJICameraTypeArri, DJICameraTypeUSBNikon, DJICameraTypeThirdParty_Sony, DJICameraTypeThirdParty_Panasonic, DJICameraTypeThirdParty_Canon, DJICameraTypeThirdParty_DefaultSony, DJICameraTypeThirdParty_Hassel, DJICameraTypeThirdParty_FUJI, DJICameraTypeThirdParty_BMPCC, DJICameraTypeThirdParty_ZCam, DJICameraTypeThirdParty_OLYMPUS, localCameraType };
    }
    
    private CameraType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static CameraType find(int paramInt)
    {
      if (sValues == null) {
        sValues = values();
      }
      CameraType localCameraType = OTHER;
      int i = 0;
      while (i < sValues.length)
      {
        if (sValues[i]._equals(paramInt)) {
          return sValues[i];
        }
        i += 1;
      }
      return localCameraType;
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
  
  public static enum EncryptStatus
  {
    private int data;
    
    static
    {
      CHECK_FAILED = new EncryptStatus("CHECK_FAILED", 1, 1);
      CHECK_SUCCESS = new EncryptStatus("CHECK_SUCCESS", 2, 2);
      EncryptStatus localEncryptStatus = new EncryptStatus("OTHER", 3, 7);
      OTHER = localEncryptStatus;
      $VALUES = new EncryptStatus[] { NON_ENCRYPT, CHECK_FAILED, CHECK_SUCCESS, localEncryptStatus };
    }
    
    private EncryptStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static EncryptStatus find(int paramInt)
    {
      EncryptStatus localEncryptStatus = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localEncryptStatus;
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
  
  public static enum RecordType
  {
    private int data;
    
    static
    {
      RecordType localRecordType = new RecordType("OTHER", 4, 7);
      OTHER = localRecordType;
      $VALUES = new RecordType[] { NO, START, STARTING, STOP, localRecordType };
    }
    
    private RecordType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static RecordType find(int paramInt)
    {
      RecordType localRecordType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localRecordType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushStateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */