package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;

public class PentagonUnlockAreaLicense
  extends WhiteListLicense
{
  private float[][] points;
  
  public PentagonUnlockAreaLicense() {}
  
  public PentagonUnlockAreaLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    super(paramDataWhiteListRequestLicense, paramInt);
    this.points = paramDataWhiteListRequestLicense.getPentagonUnlockAreaPoints();
  }
  
  public float[][] getPoints()
  {
    return this.points;
  }
  
  public void setPoints(float[][] paramArrayOfFloat)
  {
    this.points = paramArrayOfFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\PentagonUnlockAreaLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */