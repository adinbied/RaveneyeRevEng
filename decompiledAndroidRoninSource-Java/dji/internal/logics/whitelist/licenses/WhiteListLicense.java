package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;
import dji.midware.util.BytesUtil;
import java.nio.ByteBuffer;

public class WhiteListLicense
{
  protected String description;
  protected boolean enabled;
  protected int endTimeStamp;
  protected int index;
  protected boolean isValid;
  protected int level;
  protected LicenseType licenseType;
  protected byte[] liscenseAllBytes;
  protected int mLicenseId;
  protected int startTimeStamp;
  
  public WhiteListLicense() {}
  
  public WhiteListLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    this.description = BytesUtil.getStringUTF8(paramDataWhiteListRequestLicense.getDescription());
    this.startTimeStamp = ByteBuffer.wrap(paramDataWhiteListRequestLicense.getStartTime()).getInt();
    this.endTimeStamp = ByteBuffer.wrap(paramDataWhiteListRequestLicense.getEndTime()).getInt();
    this.licenseType = LicenseType.find(paramDataWhiteListRequestLicense.getType());
    this.level = paramDataWhiteListRequestLicense.getLevel();
    this.liscenseAllBytes = paramDataWhiteListRequestLicense.getLicenseBytes();
    this.enabled = paramDataWhiteListRequestLicense.isEnable();
    this.isValid = paramDataWhiteListRequestLicense.isValid();
    this.mLicenseId = paramDataWhiteListRequestLicense.getLicenseId();
    this.index = paramInt;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public int getEndTime()
  {
    return this.endTimeStamp;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getLicenseId()
  {
    return this.mLicenseId;
  }
  
  public LicenseType getLicenseType()
  {
    return this.licenseType;
  }
  
  public byte[] getLiscenseAllBytes()
  {
    return this.liscenseAllBytes;
  }
  
  public int getStartTime()
  {
    return this.startTimeStamp;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
  
  public void setDescription(String paramString)
  {
    this.description = paramString;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }
  
  public void setEndTime(int paramInt)
  {
    this.endTimeStamp = paramInt;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public void setLicenseId(int paramInt)
  {
    this.mLicenseId = paramInt;
  }
  
  public void setLicenseType(LicenseType paramLicenseType)
  {
    this.licenseType = paramLicenseType;
  }
  
  public void setLiscenseAllBytes(byte[] paramArrayOfByte)
  {
    this.liscenseAllBytes = paramArrayOfByte;
  }
  
  public void setStartTime(int paramInt)
  {
    this.startTimeStamp = paramInt;
  }
  
  public void setValid(boolean paramBoolean)
  {
    this.isValid = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\WhiteListLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */