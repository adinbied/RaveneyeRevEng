package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception
  extends CrashlyticsReport.Session.Event.Application.Execution.Exception
{
  private final CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
  private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
  private final int overflowCount;
  private final String reason;
  private final String type;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String paramString1, String paramString2, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList, CrashlyticsReport.Session.Event.Application.Execution.Exception paramException, int paramInt)
  {
    this.type = paramString1;
    this.reason = paramString2;
    this.frames = paramImmutableList;
    this.causedBy = paramException;
    this.overflowCount = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject;
      if (this.type.equals(((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getType()))
      {
        Object localObject = this.reason;
        if ((localObject == null ? ((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getReason() == null : ((String)localObject).equals(((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getReason())) && (this.frames.equals(((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getFrames())))
        {
          localObject = this.causedBy;
          if ((localObject == null ? ((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getCausedBy() == null : localObject.equals(((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getCausedBy())) && (this.overflowCount == ((CrashlyticsReport.Session.Event.Application.Execution.Exception)paramObject).getOverflowCount())) {
            return true;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy()
  {
    return this.causedBy;
  }
  
  public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames()
  {
    return this.frames;
  }
  
  public int getOverflowCount()
  {
    return this.overflowCount;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    int k = this.type.hashCode();
    Object localObject = this.reason;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((String)localObject).hashCode();
    }
    int m = this.frames.hashCode();
    localObject = this.causedBy;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return ((((k ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ m) * 1000003 ^ j) * 1000003 ^ this.overflowCount;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Exception{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", reason=");
    localStringBuilder.append(this.reason);
    localStringBuilder.append(", frames=");
    localStringBuilder.append(this.frames);
    localStringBuilder.append(", causedBy=");
    localStringBuilder.append(this.causedBy);
    localStringBuilder.append(", overflowCount=");
    localStringBuilder.append(this.overflowCount);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder
  {
    private CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private Integer overflowCount;
    private String reason;
    private String type;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception build()
    {
      Object localObject2 = this.type;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" type");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.frames == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" frames");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.overflowCount == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" overflowCount");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(this.type, this.reason, this.frames, this.causedBy, this.overflowCount.intValue(), null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(CrashlyticsReport.Session.Event.Application.Execution.Exception paramException)
    {
      this.causedBy = paramException;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList)
    {
      if (paramImmutableList != null)
      {
        this.frames = paramImmutableList;
        return this;
      }
      throw new NullPointerException("Null frames");
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int paramInt)
    {
      this.overflowCount = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String paramString)
    {
      this.reason = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String paramString)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */