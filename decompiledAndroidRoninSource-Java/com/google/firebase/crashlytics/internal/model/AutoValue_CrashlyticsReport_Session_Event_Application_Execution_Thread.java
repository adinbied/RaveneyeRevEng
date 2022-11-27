package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread
  extends CrashlyticsReport.Session.Event.Application.Execution.Thread
{
  private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
  private final int importance;
  private final String name;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String paramString, int paramInt, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList)
  {
    this.name = paramString;
    this.importance = paramInt;
    this.frames = paramImmutableList;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.Thread)paramObject;
      return (this.name.equals(((CrashlyticsReport.Session.Event.Application.Execution.Thread)paramObject).getName())) && (this.importance == ((CrashlyticsReport.Session.Event.Application.Execution.Thread)paramObject).getImportance()) && (this.frames.equals(((CrashlyticsReport.Session.Event.Application.Execution.Thread)paramObject).getFrames()));
    }
    return false;
  }
  
  public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames()
  {
    return this.frames;
  }
  
  public int getImportance()
  {
    return this.importance;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return ((this.name.hashCode() ^ 0xF4243) * 1000003 ^ this.importance) * 1000003 ^ this.frames.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Thread{name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", importance=");
    localStringBuilder.append(this.importance);
    localStringBuilder.append(", frames=");
    localStringBuilder.append(this.frames);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder
  {
    private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private Integer importance;
    private String name;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread build()
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
      if (this.importance == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" importance");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.frames == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" frames");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(this.name, this.importance.intValue(), this.frames, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> paramImmutableList)
    {
      if (paramImmutableList != null)
      {
        this.frames = paramImmutableList;
        return this;
      }
      throw new NullPointerException("Null frames");
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int paramInt)
    {
      this.importance = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String paramString)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */