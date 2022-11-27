package dji.common.camera;

public enum CameraSSDVideoLicense
{
  private int value;
  
  static
  {
    CameraSSDVideoLicense localCameraSSDVideoLicense = new CameraSSDVideoLicense("Unknown", 3, 255);
    Unknown = localCameraSSDVideoLicense;
    $VALUES = new CameraSSDVideoLicense[] { LicenseKeyTypeCinemaDNG, LicenseKeyTypeProRes422HQ, LicenseKeyTypeProRes4444XQ, localCameraSSDVideoLicense };
  }
  
  private CameraSSDVideoLicense(int paramInt)
  {
    this.value = paramInt;
  }
  
  private boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public static CameraSSDVideoLicense find(int paramInt)
  {
    CameraSSDVideoLicense localCameraSSDVideoLicense = Unknown;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localCameraSSDVideoLicense;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\CameraSSDVideoLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */