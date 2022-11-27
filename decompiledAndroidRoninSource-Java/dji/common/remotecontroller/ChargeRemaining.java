package dji.common.remotecontroller;

public class ChargeRemaining
{
  private int remainingChargeInPercent;
  private int remainingChargeInmAh;
  
  public ChargeRemaining(int paramInt1, int paramInt2)
  {
    this.remainingChargeInPercent = paramInt2;
    this.remainingChargeInmAh = paramInt1;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getRemainingChargeInPercent()
  {
    return this.remainingChargeInPercent;
  }
  
  public int getRemainingChargeInmAh()
  {
    return this.remainingChargeInmAh;
  }
  
  public int hashCode()
  {
    return this.remainingChargeInmAh * 31 + this.remainingChargeInPercent;
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(ChargeRemaining paramChargeRemaining);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\ChargeRemaining.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */