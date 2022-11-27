package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Device
  extends CrashlyticsReport.Session.Event.Device
{
  private final Double batteryLevel;
  private final int batteryVelocity;
  private final long diskUsed;
  private final int orientation;
  private final boolean proximityOn;
  private final long ramUsed;
  
  private AutoValue_CrashlyticsReport_Session_Event_Device(Double paramDouble, int paramInt1, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    this.batteryLevel = paramDouble;
    this.batteryVelocity = paramInt1;
    this.proximityOn = paramBoolean;
    this.orientation = paramInt2;
    this.ramUsed = paramLong1;
    this.diskUsed = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Device))
    {
      paramObject = (CrashlyticsReport.Session.Event.Device)paramObject;
      Double localDouble = this.batteryLevel;
      return (localDouble == null ? ((CrashlyticsReport.Session.Event.Device)paramObject).getBatteryLevel() == null : localDouble.equals(((CrashlyticsReport.Session.Event.Device)paramObject).getBatteryLevel())) && (this.batteryVelocity == ((CrashlyticsReport.Session.Event.Device)paramObject).getBatteryVelocity()) && (this.proximityOn == ((CrashlyticsReport.Session.Event.Device)paramObject).isProximityOn()) && (this.orientation == ((CrashlyticsReport.Session.Event.Device)paramObject).getOrientation()) && (this.ramUsed == ((CrashlyticsReport.Session.Event.Device)paramObject).getRamUsed()) && (this.diskUsed == ((CrashlyticsReport.Session.Event.Device)paramObject).getDiskUsed());
    }
    return false;
  }
  
  public Double getBatteryLevel()
  {
    return this.batteryLevel;
  }
  
  public int getBatteryVelocity()
  {
    return this.batteryVelocity;
  }
  
  public long getDiskUsed()
  {
    return this.diskUsed;
  }
  
  public int getOrientation()
  {
    return this.orientation;
  }
  
  public long getRamUsed()
  {
    return this.ramUsed;
  }
  
  public int hashCode()
  {
    Double localDouble = this.batteryLevel;
    int i;
    if (localDouble == null) {
      i = 0;
    } else {
      i = localDouble.hashCode();
    }
    int k = this.batteryVelocity;
    int j;
    if (this.proximityOn) {
      j = 1231;
    } else {
      j = 1237;
    }
    int m = this.orientation;
    long l = this.ramUsed;
    int n = (int)(l ^ l >>> 32);
    l = this.diskUsed;
    return (((((i ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ j) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public boolean isProximityOn()
  {
    return this.proximityOn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Device{batteryLevel=");
    localStringBuilder.append(this.batteryLevel);
    localStringBuilder.append(", batteryVelocity=");
    localStringBuilder.append(this.batteryVelocity);
    localStringBuilder.append(", proximityOn=");
    localStringBuilder.append(this.proximityOn);
    localStringBuilder.append(", orientation=");
    localStringBuilder.append(this.orientation);
    localStringBuilder.append(", ramUsed=");
    localStringBuilder.append(this.ramUsed);
    localStringBuilder.append(", diskUsed=");
    localStringBuilder.append(this.diskUsed);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Device.Builder
  {
    private Double batteryLevel;
    private Integer batteryVelocity;
    private Long diskUsed;
    private Integer orientation;
    private Boolean proximityOn;
    private Long ramUsed;
    
    public CrashlyticsReport.Session.Event.Device build()
    {
      Object localObject2 = this.batteryVelocity;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" batteryVelocity");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.proximityOn == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" proximityOn");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.orientation == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" orientation");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.ramUsed == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ramUsed");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.diskUsed == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" diskUsed");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Device(this.batteryLevel, this.batteryVelocity.intValue(), this.proximityOn.booleanValue(), this.orientation.intValue(), this.ramUsed.longValue(), this.diskUsed.longValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double paramDouble)
    {
      this.batteryLevel = paramDouble;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int paramInt)
    {
      this.batteryVelocity = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long paramLong)
    {
      this.diskUsed = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setOrientation(int paramInt)
    {
      this.orientation = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean paramBoolean)
    {
      this.proximityOn = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long paramLong)
    {
      this.ramUsed = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */