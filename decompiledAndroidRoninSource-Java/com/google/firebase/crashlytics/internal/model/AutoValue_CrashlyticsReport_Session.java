package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable.Ignore;

final class AutoValue_CrashlyticsReport_Session
  extends CrashlyticsReport.Session
{
  private final CrashlyticsReport.Session.Application app;
  private final boolean crashed;
  private final CrashlyticsReport.Session.Device device;
  private final Long endedAt;
  private final ImmutableList<CrashlyticsReport.Session.Event> events;
  private final String generator;
  private final int generatorType;
  private final String identifier;
  private final CrashlyticsReport.Session.OperatingSystem os;
  private final long startedAt;
  private final CrashlyticsReport.Session.User user;
  
  private AutoValue_CrashlyticsReport_Session(String paramString1, String paramString2, long paramLong, Long paramLong1, boolean paramBoolean, CrashlyticsReport.Session.Application paramApplication, CrashlyticsReport.Session.User paramUser, CrashlyticsReport.Session.OperatingSystem paramOperatingSystem, CrashlyticsReport.Session.Device paramDevice, ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList, int paramInt)
  {
    this.generator = paramString1;
    this.identifier = paramString2;
    this.startedAt = paramLong;
    this.endedAt = paramLong1;
    this.crashed = paramBoolean;
    this.app = paramApplication;
    this.user = paramUser;
    this.os = paramOperatingSystem;
    this.device = paramDevice;
    this.events = paramImmutableList;
    this.generatorType = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session))
    {
      paramObject = (CrashlyticsReport.Session)paramObject;
      if ((this.generator.equals(((CrashlyticsReport.Session)paramObject).getGenerator())) && (this.identifier.equals(((CrashlyticsReport.Session)paramObject).getIdentifier())) && (this.startedAt == ((CrashlyticsReport.Session)paramObject).getStartedAt()))
      {
        Object localObject = this.endedAt;
        if ((localObject == null ? ((CrashlyticsReport.Session)paramObject).getEndedAt() == null : ((Long)localObject).equals(((CrashlyticsReport.Session)paramObject).getEndedAt())) && (this.crashed == ((CrashlyticsReport.Session)paramObject).isCrashed()) && (this.app.equals(((CrashlyticsReport.Session)paramObject).getApp())))
        {
          localObject = this.user;
          if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getUser() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getUser()))
          {
            localObject = this.os;
            if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getOs() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getOs()))
            {
              localObject = this.device;
              if (localObject == null ? ((CrashlyticsReport.Session)paramObject).getDevice() == null : localObject.equals(((CrashlyticsReport.Session)paramObject).getDevice()))
              {
                localObject = this.events;
                if ((localObject == null ? ((CrashlyticsReport.Session)paramObject).getEvents() == null : ((ImmutableList)localObject).equals(((CrashlyticsReport.Session)paramObject).getEvents())) && (this.generatorType == ((CrashlyticsReport.Session)paramObject).getGeneratorType())) {
                  return true;
                }
              }
            }
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public CrashlyticsReport.Session.Application getApp()
  {
    return this.app;
  }
  
  public CrashlyticsReport.Session.Device getDevice()
  {
    return this.device;
  }
  
  public Long getEndedAt()
  {
    return this.endedAt;
  }
  
  public ImmutableList<CrashlyticsReport.Session.Event> getEvents()
  {
    return this.events;
  }
  
  public String getGenerator()
  {
    return this.generator;
  }
  
  public int getGeneratorType()
  {
    return this.generatorType;
  }
  
  @Encodable.Ignore
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public CrashlyticsReport.Session.OperatingSystem getOs()
  {
    return this.os;
  }
  
  public long getStartedAt()
  {
    return this.startedAt;
  }
  
  public CrashlyticsReport.Session.User getUser()
  {
    return this.user;
  }
  
  public int hashCode()
  {
    int i2 = this.generator.hashCode();
    int i3 = this.identifier.hashCode();
    long l = this.startedAt;
    int i4 = (int)(l ^ l >>> 32);
    Object localObject = this.endedAt;
    int i1 = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((Long)localObject).hashCode();
    }
    int j;
    if (this.crashed) {
      j = 1231;
    } else {
      j = 1237;
    }
    int i5 = this.app.hashCode();
    localObject = this.user;
    int k;
    if (localObject == null) {
      k = 0;
    } else {
      k = localObject.hashCode();
    }
    localObject = this.os;
    int m;
    if (localObject == null) {
      m = 0;
    } else {
      m = localObject.hashCode();
    }
    localObject = this.device;
    int n;
    if (localObject == null) {
      n = 0;
    } else {
      n = localObject.hashCode();
    }
    localObject = this.events;
    if (localObject != null) {
      i1 = ((ImmutableList)localObject).hashCode();
    }
    return ((((((((((i2 ^ 0xF4243) * 1000003 ^ i3) * 1000003 ^ i4) * 1000003 ^ i) * 1000003 ^ j) * 1000003 ^ i5) * 1000003 ^ k) * 1000003 ^ m) * 1000003 ^ n) * 1000003 ^ i1) * 1000003 ^ this.generatorType;
  }
  
  public boolean isCrashed()
  {
    return this.crashed;
  }
  
  public CrashlyticsReport.Session.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Session{generator=");
    localStringBuilder.append(this.generator);
    localStringBuilder.append(", identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append(", startedAt=");
    localStringBuilder.append(this.startedAt);
    localStringBuilder.append(", endedAt=");
    localStringBuilder.append(this.endedAt);
    localStringBuilder.append(", crashed=");
    localStringBuilder.append(this.crashed);
    localStringBuilder.append(", app=");
    localStringBuilder.append(this.app);
    localStringBuilder.append(", user=");
    localStringBuilder.append(this.user);
    localStringBuilder.append(", os=");
    localStringBuilder.append(this.os);
    localStringBuilder.append(", device=");
    localStringBuilder.append(this.device);
    localStringBuilder.append(", events=");
    localStringBuilder.append(this.events);
    localStringBuilder.append(", generatorType=");
    localStringBuilder.append(this.generatorType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Builder
  {
    private CrashlyticsReport.Session.Application app;
    private Boolean crashed;
    private CrashlyticsReport.Session.Device device;
    private Long endedAt;
    private ImmutableList<CrashlyticsReport.Session.Event> events;
    private String generator;
    private Integer generatorType;
    private String identifier;
    private CrashlyticsReport.Session.OperatingSystem os;
    private Long startedAt;
    private CrashlyticsReport.Session.User user;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session paramSession)
    {
      this.generator = paramSession.getGenerator();
      this.identifier = paramSession.getIdentifier();
      this.startedAt = Long.valueOf(paramSession.getStartedAt());
      this.endedAt = paramSession.getEndedAt();
      this.crashed = Boolean.valueOf(paramSession.isCrashed());
      this.app = paramSession.getApp();
      this.user = paramSession.getUser();
      this.os = paramSession.getOs();
      this.device = paramSession.getDevice();
      this.events = paramSession.getEvents();
      this.generatorType = Integer.valueOf(paramSession.getGeneratorType());
    }
    
    public CrashlyticsReport.Session build()
    {
      Object localObject2 = this.generator;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" generator");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.identifier == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" identifier");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.startedAt == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" startedAt");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.crashed == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" crashed");
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
      if (this.generatorType == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" generatorType");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session(this.generator, this.identifier, this.startedAt.longValue(), this.endedAt, this.crashed.booleanValue(), this.app, this.user, this.os, this.device, this.events, this.generatorType.intValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Builder setApp(CrashlyticsReport.Session.Application paramApplication)
    {
      if (paramApplication != null)
      {
        this.app = paramApplication;
        return this;
      }
      throw new NullPointerException("Null app");
    }
    
    public CrashlyticsReport.Session.Builder setCrashed(boolean paramBoolean)
    {
      this.crashed = Boolean.valueOf(paramBoolean);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setDevice(CrashlyticsReport.Session.Device paramDevice)
    {
      this.device = paramDevice;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setEndedAt(Long paramLong)
    {
      this.endedAt = paramLong;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setEvents(ImmutableList<CrashlyticsReport.Session.Event> paramImmutableList)
    {
      this.events = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setGenerator(String paramString)
    {
      if (paramString != null)
      {
        this.generator = paramString;
        return this;
      }
      throw new NullPointerException("Null generator");
    }
    
    public CrashlyticsReport.Session.Builder setGeneratorType(int paramInt)
    {
      this.generatorType = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setIdentifier(String paramString)
    {
      if (paramString != null)
      {
        this.identifier = paramString;
        return this;
      }
      throw new NullPointerException("Null identifier");
    }
    
    public CrashlyticsReport.Session.Builder setOs(CrashlyticsReport.Session.OperatingSystem paramOperatingSystem)
    {
      this.os = paramOperatingSystem;
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setStartedAt(long paramLong)
    {
      this.startedAt = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Builder setUser(CrashlyticsReport.Session.User paramUser)
    {
      this.user = paramUser;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */