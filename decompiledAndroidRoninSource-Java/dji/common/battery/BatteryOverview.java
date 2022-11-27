package dji.common.battery;

public class BatteryOverview
{
  private int chargeRemainingInPercent;
  private boolean connected;
  private int index;
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getChargeRemainingInPercent()
  {
    return this.chargeRemainingInPercent;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isConnected()
  {
    return this.connected;
  }
  
  public void setChargeRemainingInPercent(int paramInt)
  {
    this.chargeRemainingInPercent = paramInt;
  }
  
  public void setConnected(boolean paramBoolean)
  {
    this.connected = paramBoolean;
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\BatteryOverview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */