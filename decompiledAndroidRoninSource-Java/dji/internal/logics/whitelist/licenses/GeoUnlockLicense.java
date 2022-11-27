package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;
import java.util.List;

public class GeoUnlockLicense
  extends WhiteListLicense
{
  private int[] areaIds;
  
  public GeoUnlockLicense() {}
  
  public GeoUnlockLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    super(paramDataWhiteListRequestLicense, paramInt);
    this.areaIds = paramDataWhiteListRequestLicense.getGEOAreaIds();
  }
  
  public boolean containsByAreaIds(List<Integer> paramList)
  {
    return false;
  }
  
  public int[] getAreaIds()
  {
    return this.areaIds;
  }
  
  public void setAreaIds(int[] paramArrayOfInt)
  {
    this.areaIds = paramArrayOfInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\GeoUnlockLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */