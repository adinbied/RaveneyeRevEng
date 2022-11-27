package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal
  extends CrashlyticsReport.Session.Event.Application.Execution.Signal
{
  private final long address;
  private final String code;
  private final String name;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String paramString1, String paramString2, long paramLong)
  {
    this.name = paramString1;
    this.code = paramString2;
    this.address = paramLong;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject;
      return (this.name.equals(((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getName())) && (this.code.equals(((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getCode())) && (this.address == ((CrashlyticsReport.Session.Event.Application.Execution.Signal)paramObject).getAddress());
    }
    return false;
  }
  
  public long getAddress()
  {
    return this.address;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    int i = this.name.hashCode();
    int j = this.code.hashCode();
    long l = this.address;
    return ((i ^ 0xF4243) * 1000003 ^ j) * 1000003 ^ (int)(l ^ l >>> 32);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Signal{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", address=");
    localStringBuilder.append(this.address);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder
  {
    private Long address;
    private String code;
    private String name;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal build()
    {
      Object localObject2 = this.name;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" name");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.code == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" code");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.address == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" address");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.name, this.code, this.address.longValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long paramLong)
    {
      this.address = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String paramString)
    {
      if (paramString != null)
      {
        this.code = paramString;
        return this;
      }
      throw new NullPointerException("Null code");
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String paramString)
    {
      if (paramString != null)
      {
        this.name = paramString;
        return this;
      }
      throw new NullPointerException("Null name");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */