package dji.common.battery;

public class AggregationState
{
  private final boolean anyBatteryDisconnected;
  private final BatteryOverview[] batteryOverviews;
  private final boolean cellDamaged;
  private final int chargeRemaining;
  private final int chargeRemainingInPercent;
  private final int current;
  private final boolean firmwareDifferenceDetected;
  private final int fullChargeCapacity;
  private final int highestTemperature;
  private final boolean lowCellVoltageDetected;
  private final int numberOfConnectedBatteries;
  private final int voltage;
  private final boolean voltageDifferenceDetected;
  
  private AggregationState(Builder paramBuilder)
  {
    this.batteryOverviews = paramBuilder.batteryOverviews;
    this.voltage = paramBuilder.voltage;
    this.current = paramBuilder.current;
    this.fullChargeCapacity = paramBuilder.fullChargeCapacity;
    this.chargeRemaining = paramBuilder.chargeRemaining;
    this.chargeRemainingInPercent = paramBuilder.chargeRemainingInPercent;
    this.numberOfConnectedBatteries = paramBuilder.numberOfConnectedBatteries;
    this.highestTemperature = paramBuilder.highestTemperature;
    this.anyBatteryDisconnected = paramBuilder.anyBatteryDisconnected;
    this.voltageDifferenceDetected = paramBuilder.voltageDifferenceDetected;
    this.lowCellVoltageDetected = paramBuilder.lowCellVoltageDetected;
    this.cellDamaged = paramBuilder.cellDamaged;
    this.firmwareDifferenceDetected = paramBuilder.firmwareDifferenceDetected;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public BatteryOverview[] getBatteryOverviews()
  {
    return this.batteryOverviews;
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
  
  public int getHighestTemperature()
  {
    return this.highestTemperature;
  }
  
  public int getNumberOfConnectedBatteries()
  {
    return this.numberOfConnectedBatteries;
  }
  
  public int getVoltage()
  {
    return this.voltage;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isAnyBatteryDisconnected()
  {
    return this.anyBatteryDisconnected;
  }
  
  public boolean isCellDamaged()
  {
    return this.cellDamaged;
  }
  
  public boolean isFirmwareDifferenceDetected()
  {
    return this.firmwareDifferenceDetected;
  }
  
  public boolean isLowCellVoltageDetected()
  {
    return this.lowCellVoltageDetected;
  }
  
  public boolean isVoltageDifferenceDetected()
  {
    return this.voltageDifferenceDetected;
  }
  
  public static final class Builder
  {
    private boolean anyBatteryDisconnected;
    private BatteryOverview[] batteryOverviews;
    private boolean cellDamaged;
    private int chargeRemaining;
    private int chargeRemainingInPercent;
    private int current;
    private boolean firmwareDifferenceDetected;
    private int fullChargeCapacity;
    private int highestTemperature;
    private boolean lowCellVoltageDetected;
    private int numberOfConnectedBatteries;
    private int voltage;
    private boolean voltageDifferenceDetected;
    
    public Builder anyBatteryDisconnected(boolean paramBoolean)
    {
      this.anyBatteryDisconnected = paramBoolean;
      return this;
    }
    
    public Builder batteryOverviews(BatteryOverview[] paramArrayOfBatteryOverview)
    {
      this.batteryOverviews = paramArrayOfBatteryOverview;
      return this;
    }
    
    public AggregationState build()
    {
      return new AggregationState(this, null);
    }
    
    public Builder cellDamaged(boolean paramBoolean)
    {
      this.cellDamaged = paramBoolean;
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
    
    public Builder firmwareDifferenceDetected(boolean paramBoolean)
    {
      this.firmwareDifferenceDetected = paramBoolean;
      return this;
    }
    
    public Builder fullChargeCapacity(int paramInt)
    {
      this.fullChargeCapacity = paramInt;
      return this;
    }
    
    public Builder highestTemperature(int paramInt)
    {
      this.highestTemperature = paramInt;
      return this;
    }
    
    public Builder lowCellVoltageDetected(boolean paramBoolean)
    {
      this.lowCellVoltageDetected = paramBoolean;
      return this;
    }
    
    public Builder numberOfConnectedBatteries(int paramInt)
    {
      this.numberOfConnectedBatteries = paramInt;
      return this;
    }
    
    public Builder voltage(int paramInt)
    {
      this.voltage = paramInt;
      return this;
    }
    
    public Builder voltageDifferenceDetected(boolean paramBoolean)
    {
      this.voltageDifferenceDetected = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onUpdate(AggregationState paramAggregationState);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\battery\AggregationState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */