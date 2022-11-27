package dji.pilot.active;

public class ActivateDataManager
{
  private static ActivateDataManager ourInstance = new ActivateDataManager();
  private String cc = "";
  private boolean isInActive = false;
  private boolean isReportTermVer = false;
  private ActivateProductType mActivateProductType = ActivateProductType.SDR;
  private int mDeviceWifiId;
  private String mDeviceWifiSSID;
  private boolean mIsGlassActive = false;
  private boolean mIsLonganSeriesActive;
  public boolean mIsOSMOPHoneActive;
  private boolean mIsP3CActive = false;
  private String mPlaneName = "";
  private String ppVer = "1.1";
  private String termVer = "2.0";
  
  public static ActivateDataManager getInstance()
  {
    return ourInstance;
  }
  
  public String getCc()
  {
    return this.cc;
  }
  
  public int getDeviceWifi()
  {
    return this.mDeviceWifiId;
  }
  
  public String getDeviceWifiSSID()
  {
    return this.mDeviceWifiSSID;
  }
  
  public boolean getIsGlassActive()
  {
    return this.mIsGlassActive;
  }
  
  public boolean getIsNeedActiveGimbal()
  {
    return this.mIsOSMOPHoneActive;
  }
  
  public boolean getIsP3CActive()
  {
    return this.mIsP3CActive;
  }
  
  public boolean getIsReportTermVer()
  {
    return this.isReportTermVer;
  }
  
  public String getPlaneName()
  {
    return this.mPlaneName;
  }
  
  public ActivateProductType getProductType()
  {
    return this.mActivateProductType;
  }
  
  public String getTermVer()
  {
    return this.termVer;
  }
  
  public String getppVer()
  {
    return this.ppVer;
  }
  
  public boolean isInActive()
  {
    return this.isInActive;
  }
  
  public Boolean isLonganSeriesActive()
  {
    return null;
  }
  
  public boolean needShowFlightSafeWeb()
  {
    return false;
  }
  
  public void saveDeviceWifi(int paramInt)
  {
    this.mDeviceWifiId = paramInt;
  }
  
  public void setCc(String paramString)
  {
    this.cc = paramString;
  }
  
  public void setDeviceWifiSSID(String paramString)
  {
    this.mDeviceWifiSSID = paramString;
  }
  
  public void setInActive(boolean paramBoolean)
  {
    this.isInActive = paramBoolean;
  }
  
  public void setIsGlassActive(boolean paramBoolean)
  {
    this.mIsGlassActive = paramBoolean;
  }
  
  public void setIsLonganSeriesActive(boolean paramBoolean)
  {
    this.mIsLonganSeriesActive = paramBoolean;
  }
  
  public void setIsNeedActiveGimbal(boolean paramBoolean)
  {
    this.mIsOSMOPHoneActive = paramBoolean;
  }
  
  public void setIsNeedTermVer(boolean paramBoolean)
  {
    this.isReportTermVer = paramBoolean;
  }
  
  public void setIsP3CActive(boolean paramBoolean)
  {
    this.mIsP3CActive = paramBoolean;
  }
  
  public void setPlaneName(String paramString)
  {
    this.mPlaneName = paramString;
  }
  
  public void setPpVer(String paramString)
  {
    this.ppVer = paramString;
  }
  
  public void setProductType(ActivateProductType paramActivateProductType)
  {
    this.mActivateProductType = paramActivateProductType;
  }
  
  public void setTermVer(String paramString)
  {
    this.termVer = paramString;
  }
  
  public static enum ActivateAction
  {
    static
    {
      ACTIVE_START = new ActivateAction("ACTIVE_START", 3);
      ActivateAction localActivateAction = new ActivateAction("ACTIVE_FINISH", 4);
      ACTIVE_FINISH = localActivateAction;
      $VALUES = new ActivateAction[] { BACK_PRESSED, DESTROY, ON_RESUME, ACTIVE_START, localActivateAction };
    }
    
    private ActivateAction() {}
  }
  
  public static enum ActivateProductType
  {
    static
    {
      ActivateProductType localActivateProductType = new ActivateProductType("SDR", 1);
      SDR = localActivateProductType;
      $VALUES = new ActivateProductType[] { WIFI, localActivateProductType };
    }
    
    private ActivateProductType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\ActivateDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */