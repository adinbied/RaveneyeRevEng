package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event
  extends CrashlyticsReport.Session.Event
{
  private final CrashlyticsReport.Session.Event.Application app;
  private final CrashlyticsReport.Session.Event.Device device;
  private final CrashlyticsReport.Session.Event.Log log;
  private final long timestamp;
  private final String type;
  
  private AutoValue_CrashlyticsReport_Session_Event(long paramLong, String paramString, CrashlyticsReport.Session.Event.Application paramApplication, CrashlyticsReport.Session.Event.Device paramDevice, CrashlyticsReport.Session.Event.Log paramLog)
  {
    this.timestamp = paramLong;
    this.type = paramString;
    this.app = paramApplication;
    this.device = paramDevice;
    this.log = paramLog;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event))
    {
      paramObject = (CrashlyticsReport.Session.Event)paramObject;
      if ((this.timestamp == ((CrashlyticsReport.Session.Event)paramObject).getTimestamp()) && (this.type.equals(((CrashlyticsReport.Session.Event)paramObject).getType())) && (this.app.equals(((CrashlyticsReport.Session.Event)paramObject).getApp())) && (this.device.equals(((CrashlyticsReport.Session.Event)paramObject).getDevice())))
      {
        CrashlyticsReport.Session.Event.Log localLog = this.log;
        if (localLog == null)
        {
          if (((CrashlyticsReport.Session.Event)paramObject).getLog() == null) {
            return true;
          }
        }
        else if (localLog.equals(((CrashlyticsReport.Session.Event)paramObject).getLog())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public CrashlyticsReport.Session.Event.Application getApp()
  {
    return this.app;
  }
  
  public CrashlyticsReport.Session.Event.Device getDevice()
  {
    return this.device;
  }
  
  public CrashlyticsReport.Session.Event.Log getLog()
  {
    return this.log;
  }
  
  public long getTimestamp()
  {
    return this.timestamp;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    long l = this.timestamp;
    int j = (int)(l ^ l >>> 32);
    int k = this.type.hashCode();
    int m = this.app.hashCode();
    int n = this.device.hashCode();
    CrashlyticsReport.Session.Event.Log localLog = this.log;
    int i;
    if (localLog == null) {
      i = 0;
    } else {
      i = localLog.hashCode();
    }
    return i ^ ((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003;
  }
  
  public CrashlyticsReport.Session.Event.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Event{timestamp=");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", app=");
    localStringBuilder.append(this.app);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", log=");
    localStringBuilder.append(this.log);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Builder
  {
    private CrashlyticsReport.Session.Event.Application app;
    private CrashlyticsReport.Session.Event.Device device;
    private CrashlyticsReport.Session.Event.Log log;
    private Long timestamp;
    private String type;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Event paramEvent)
    {
      this.timestamp = Long.valueOf(paramEvent.getTimestamp());
      this.type = paramEvent.getType();
      this.app = paramEvent.getApp();
      this.device = paramEvent.getDevice();
      this.log = paramEvent.getLog();
    }
    
    public CrashlyticsReport.Session.Event build()
    {
      Object localObject2 = this.timestamp;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" timestamp");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.type == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" type");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.app == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" app");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.device == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" device");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.app, this.device, this.log, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Builder setApp(CrashlyticsReport.Session.Event.Application paramApplication)
    {
      if (paramApplication != null)
      {
        this.app = paramApplication;
        return this;
      }
      throw new NullPointerException("Null app");
    }
    
    public CrashlyticsReport.Session.Event.Builder setDevice(CrashlyticsReport.Session.Event.Device paramDevice)
    {
      if (paramDevice != null)
      {
        this.device = paramDevice;
        return this;
      }
      throw new NullPointerException("Null device");
    }
    
    public CrashlyticsReport.Session.Event.Builder setLog(CrashlyticsReport.Session.Event.Log paramLog)
    {
      this.log = paramLog;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setTimestamp(long paramLong)
    {
      this.timestamp = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Builder setType(String paramString)
    {
      if (paramString != null)
      {
        this.type = paramString;
        return this;
      }
      throw new NullPointerException("Null type");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */