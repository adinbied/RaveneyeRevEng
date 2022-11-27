package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;

public class ParameterConfigurationLicense
  extends WhiteListLicense
{
  private int type;
  private int[] values;
  
  public ParameterConfigurationLicense() {}
  
  public ParameterConfigurationLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    super(paramDataWhiteListRequestLicense, paramInt);
    this.type = paramDataWhiteListRequestLicense.getParameterConfigurationType();
    this.values = paramDataWhiteListRequestLicense.getParameterConfigurationValues();
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int[] getValues()
  {
    return this.values;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public void setValues(int[] paramArrayOfInt)
  {
    this.values = paramArrayOfInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\ParameterConfigurationLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */