package dji.internal.logics.whitelist.licenses;

import dji.midware.data.model.P3.DataWhiteListRequestLicense;

public class CircleUnlockAreaLicense
  extends WhiteListLicense
{
  private float latitude;
  private float limitedHeight;
  private float longitude;
  private float radius;
  
  public CircleUnlockAreaLicense() {}
  
  public CircleUnlockAreaLicense(DataWhiteListRequestLicense paramDataWhiteListRequestLicense, int paramInt)
  {
    super(paramDataWhiteListRequestLicense, paramInt);
    this.latitude = paramDataWhiteListRequestLicense.getCircleUnlockAreaLatitude();
    this.longitude = paramDataWhiteListRequestLicense.getCircleUnlockAreaLongitude();
    this.radius = paramDataWhiteListRequestLicense.getCircleUnlockAreaRadius();
    this.limitedHeight = paramDataWhiteListRequestLicense.getCircleUnlockAreaLimitedHeight();
  }
  
  public float getLatitude()
  {
    return this.latitude;
  }
  
  public float getLimitedHeight()
  {
    return this.limitedHeight;
  }
  
  public float getLongitude()
  {
    return this.longitude;
  }
  
  public float getRadius()
  {
    return this.radius;
  }
  
  public void setLatitude(float paramFloat)
  {
    this.latitude = paramFloat;
  }
  
  public void setLimitedHeight(float paramFloat)
  {
    this.limitedHeight = paramFloat;
  }
  
  public void setLongitude(float paramFloat)
  {
    this.longitude = paramFloat;
  }
  
  public void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\CircleUnlockAreaLicense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */