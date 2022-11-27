package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;

public class CountryUnlockLicense
  extends WhiteListLicense
{
  private int countryId;
  
  public CountryUnlockLicense() {}
  
  public CountryUnlockLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    super(paramDataWhiteListRequestLicense, paramInt);
    this.countryId = paramDataWhiteListRequestLicense.getCountryUnlockId();
  }
  
  public int getCountryId()
  {
    return this.countryId;
  }
  
  public void setCountryId(int paramInt)
  {
    this.countryId = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\CountryUnlockLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */