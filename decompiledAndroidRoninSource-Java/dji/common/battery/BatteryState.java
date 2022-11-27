package dji.common.battery;

public class BatteryState
{
  private final BatteryCellVoltageLevel cellVoltageLevel;
  private final int chargeRemaining;
  private final int chargeRemainingInPercent;
  private final int current;
  private final int fullChargeCapacity;
  private final boolean isBeingCharged;
  private final boolean isSingleBattery;
  private final int lifetimeRemaining;
  private final int numberOfDischarges;
  private final int temperature;
  private final int voltage;
  
  private BatteryState(Builder paramBuilder)
  {
    this.cellVoltageLevel = paramBuilder.cellVoltageLevel;
    this.fullChargeCapacity = paramBuilder.fullChargeCapacity;
    this.chargeRemaining = paramBuilder.chargeRemaining;
    this.voltage = paramBuilder.voltage;
    this.current = paramBuilder.current;
    this.lifetimeRemaining = paramBuilder.lifetimeRemaining;
    this.chargeRemainingInPercent = paramBuilder.chargeRemainingInPercent;
    this.temperature = paramBuilder.temperature;
    this.numberOfDischarges = paramBuilder.numberOfDischarges;
    this.isBeingCharged = paramBuilder.isBeingCharged;
    this.isSingleBattery = paramBuilder.isSingleBattery;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public BatteryCellVoltageLevel getCellVoltageLevel()
  {
    return this.cellVoltageLevel;
  }
  
  public int getChargeRemaining()
  {
    return this.chargeRemaining;
  }
  
  public int getChargeRemainingInPercent()
  {
    return this.chargeRemainingInPercent;
  }
  
  public int getCurrent()
  {
    return this.current;
  }
  
  public int getFullChargeCapacity()
  {
    return this.fullChargeCapacity;
  }
  
  public int getLifetimeRemaining()
  {
    return this.lifetimeRemaining;
  }
  
  public int getNumberOfDischarges()
  {
    return this.numberOfDischarges;
  }
  
  public int getTemperature()
  {
    return this.temperature;
  }
  
  public int getVoltage()
  {
    return this.voltage;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isBeingCharged()
  {
    return this.isBeingCharged;
  }
  
  public boolean isInSingleBatteryMode()
  {
    return this.isSingleBattery;
  }
  
  public static final class Builder
  {
    private BatteryCellVoltageLevel cellVoltageLevel;
    private int chargeRemaining;
    private int chargeRemainingInPercent;
    private int current;
    private int fullChargeCapacity;
    private boolean isBeingCharged;
    private boolean isSingleBattery;
    private int lifetimeRemaining;
    private int numberOfDischarges;
    private int temperature;
    private int voltage;
    
    public BatteryState build()
    {
      return new BatteryState(this, null);
    }
    
    public Builder cellVoltageLevel(BatteryCellVoltageLevel paramBatteryCellVoltageLevel)
    {
      this.cellVoltageLevel = paramBatteryCellVoltageLevel;
      return this;
    }
    
    public Builder chargeRemaining(int paramInt)
    {
      this.chargeRemaining = paramInt;
      return this;
    }
    
    public Builder chargeRemainingInPercent(int paramInt)
    {
      this.chargeRemainingInPercent = paramInt;
      return this;
    }
    
    public Builder current(int paramInt)
    {
      this.current = paramInt;
      return this;
    }
    
    public Builder fullChargeCapacity(int paramInt)
    {
      this.fullChargeCapacity = paramInt;
      return this;
    }
    
    public Builder isBeingCharged(boolean paramBoolean)
    {
      this.isBeingCharged = paramBoolean;
      return this;
    }
    
    public Builder isSingleBattery(boolean paramBoolean)
    {
      this.isSingleBattery = paramBoolean;
      return this;
    }
    
    public Builder lifetimeRemaining(int paramInt)
    {
      this.lifetimeRemaining = paramInt;
      return this;
    }
    
    public Builder numberOfDischarges(int paramInt)
    {
      this.numberOfDischarges = paramInt;
      return this;
    }
    
    public Builder temperature(int paramInt)
    {
      this.temperature = paramInt;
      return this;
    }
    
    public Builder voltage(int paramInt)
    {
      this.voltage = paramInt;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(BatteryState paramBatteryState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\BatteryState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */