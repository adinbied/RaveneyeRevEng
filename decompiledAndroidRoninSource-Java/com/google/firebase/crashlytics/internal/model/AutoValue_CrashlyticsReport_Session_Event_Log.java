package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Log
  extends CrashlyticsReport.Session.Event.Log
{
  private final String content;
  
  private AutoValue_CrashlyticsReport_Session_Event_Log(String paramString)
  {
    this.content = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Log))
    {
      paramObject = (CrashlyticsReport.Session.Event.Log)paramObject;
      return this.content.equals(((CrashlyticsReport.Session.Event.Log)paramObject).getContent());
    }
    return false;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public int hashCode()
  {
    return this.content.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Log{content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Log.Builder
  {
    private String content;
    
    public CrashlyticsReport.Session.Event.Log build()
    {
      Object localObject2 = this.content;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" content");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Log(this.content, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Log.Builder setContent(String paramString)
    {
      if (paramString != null)
      {
        this.content = paramString;
        return this;
      }
      throw new NullPointerException("Null content");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */