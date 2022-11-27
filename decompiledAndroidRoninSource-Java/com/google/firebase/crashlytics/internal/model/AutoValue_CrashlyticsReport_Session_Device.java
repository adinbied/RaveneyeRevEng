package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Device
  extends CrashlyticsReport.Session.Device
{
  private final int arch;
  private final int cores;
  private final long diskSpace;
  private final String manufacturer;
  private final String model;
  private final String modelClass;
  private final long ram;
  private final boolean simulator;
  private final int state;
  
  private AutoValue_CrashlyticsReport_Session_Device(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, int paramInt3, String paramString2, String paramString3)
  {
    this.arch = paramInt1;
    this.model = paramString1;
    this.cores = paramInt2;
    this.ram = paramLong1;
    this.diskSpace = paramLong2;
    this.simulator = paramBoolean;
    this.state = paramInt3;
    this.manufacturer = paramString2;
    this.modelClass = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Device))
    {
      paramObject = (CrashlyticsReport.Session.Device)paramObject;
      return (this.arch == ((CrashlyticsReport.Session.Device)paramObject).getArch()) && (this.model.equals(((CrashlyticsReport.Session.Device)paramObject).getModel())) && (this.cores == ((CrashlyticsReport.Session.Device)paramObject).getCores()) && (this.ram == ((CrashlyticsReport.Session.Device)paramObject).getRam()) && (this.diskSpace == ((CrashlyticsReport.Session.Device)paramObject).getDiskSpace()) && (this.simulator == ((CrashlyticsReport.Session.Device)paramObject).isSimulator()) && (this.state == ((CrashlyticsReport.Session.Device)paramObject).getState()) && (this.manufacturer.equals(((CrashlyticsReport.Session.Device)paramObject).getManufacturer())) && (this.modelClass.equals(((CrashlyticsReport.Session.Device)paramObject).getModelClass()));
    }
    return false;
  }
  
  public int getArch()
  {
    return this.arch;
  }
  
  public int getCores()
  {
    return this.cores;
  }
  
  public long getDiskSpace()
  {
    return this.diskSpace;
  }
  
  public String getManufacturer()
  {
    return this.manufacturer;
  }
  
  public String getModel()
  {
    return this.model;
  }
  
  public String getModelClass()
  {
    return this.modelClass;
  }
  
  public long getRam()
  {
    return this.ram;
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public int hashCode()
  {
    int j = this.arch;
    int k = this.model.hashCode();
    int m = this.cores;
    long l = this.ram;
    int n = (int)(l ^ l >>> 32);
    l = this.diskSpace;
    int i1 = (int)(l ^ l >>> 32);
    int i;
    if (this.simulator) {
      i = 1231;
    } else {
      i = 1237;
    }
    return ((((((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ i) * 1000003 ^ this.state) * 1000003 ^ this.manufacturer.hashCode()) * 1000003 ^ this.modelClass.hashCode();
  }
  
  public boolean isSimulator()
  {
    return this.simulator;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Device{arch=");
    localStringBuilder.append(this.arch);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.model);
    localStringBuilder.append(", cores=");
    localStringBuilder.append(this.cores);
    localStringBuilder.append(", ram=");
    localStringBuilder.append(this.ram);
    localStringBuilder.append(", diskSpace=");
    localStringBuilder.append(this.diskSpace);
    localStringBuilder.append(", simulator=");
    localStringBuilder.append(this.simulator);
    localStringBuilder.append(", state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", manufacturer=");
    localStringBuilder.append(this.manufacturer);
    localStringBuilder.append(", modelClass=");
    localStringBuilder.append(this.modelClass);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Device.Builder
  {
    private Integer arch;
    private Integer cores;
    private Long diskSpace;
    private String manufacturer;
    private String model;
    private String modelClass;
    private Long ram;
    private Boolean simulator;
    private Integer state;
    
    public CrashlyticsReport.Session.Device build()
    {
      Object localObject2 = this.arch;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" arch");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.model == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" model");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.cores == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" cores");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.ram == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ram");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.diskSpace == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" diskSpace");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.simulator == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" simulator");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.state == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" state");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.manufacturer == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" manufacturer");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.modelClass == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" modelClass");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Device(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), this.diskSpace.longValue(), this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Device.Builder setArch(int paramInt)
    {
      this.arch = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setCores(int paramInt)
    {
      this.cores = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setDiskSpace(long paramLong)
    {
      this.diskSpace = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setManufacturer(String paramString)
    {
      if (paramString != null)
      {
        this.manufacturer = paramString;
        return this;
      }
      throw new NullPointerException("Null manufacturer");
    }
    
    public CrashlyticsReport.Session.Device.Builder setModel(String paramString)
    {
      if (paramString != null)
      {
        this.model = paramString;
        return this;
      }
      throw new NullPointerException("Null model");
    }
    
    public CrashlyticsReport.Session.Device.Builder setModelClass(String paramString)
    {
      if (paramString != null)
      {
        this.modelClass = paramString;
        return this;
      }
      throw new NullPointerException("Null modelClass");
    }
    
    public CrashlyticsReport.Session.Device.Builder setRam(long paramLong)
    {
      this.ram = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setSimulator(boolean paramBoolean)
    {
      this.simulator = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.Device.Builder setState(int paramInt)
    {
      this.state = Integer.valueOf(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */