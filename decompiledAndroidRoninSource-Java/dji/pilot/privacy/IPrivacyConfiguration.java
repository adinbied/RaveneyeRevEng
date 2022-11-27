package dji.pilot.privacy;

import android.content.Context;

public abstract interface IPrivacyConfiguration
{
  public abstract void finishCheckPrivacyProcess();
  
  public abstract boolean getPrivacyDataState(PrivacyType paramPrivacyType);
  
  public abstract boolean isNeedCheckPrivacy();
  
  public abstract void setPrivacyDataState(PrivacyType paramPrivacyType, boolean paramBoolean);
  
  public abstract void showPrivacyConfigDialog(Context paramContext, PrivacyType paramPrivacyType, String paramString, boolean paramBoolean, AuthorizeDialogClickListener paramAuthorizeDialogClickListener);
  
  public static abstract interface AuthorizeDialogClickListener
  {
    public abstract void onLeftCancelClick();
    
    public abstract void onRightAuthorizeClick();
  }
  
  public static enum PrivacyConfigEvent
  {
    static
    {
      PrivacyConfigEvent localPrivacyConfigEvent = new PrivacyConfigEvent("PRIVACY_CONFIG_FLOW_FINISH", 0);
      PRIVACY_CONFIG_FLOW_FINISH = localPrivacyConfigEvent;
      $VALUES = new PrivacyConfigEvent[] { localPrivacyConfigEvent };
    }
    
    private PrivacyConfigEvent() {}
  }
  
  public static class PrivacyDataWrapper
  {
    public boolean isAuthorized;
    public IPrivacyConfiguration.PrivacyType mPrivacyType;
    
    public PrivacyDataWrapper(IPrivacyConfiguration.PrivacyType paramPrivacyType, boolean paramBoolean)
    {
      this.mPrivacyType = paramPrivacyType;
      this.isAuthorized = paramBoolean;
    }
  }
  
  public static enum PrivacyType
  {
    static
    {
      GPS_DJI_DEVICE = new PrivacyType("GPS_DJI_DEVICE", 1);
      SN_DJI_DEVICE = new PrivacyType("SN_DJI_DEVICE", 2);
      PrivacyType localPrivacyType = new PrivacyType("INFO_USER", 3);
      INFO_USER = localPrivacyType;
      $VALUES = new PrivacyType[] { GPS_PHONE, GPS_DJI_DEVICE, SN_DJI_DEVICE, localPrivacyType };
    }
    
    private PrivacyType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\privacy\IPrivacyConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */