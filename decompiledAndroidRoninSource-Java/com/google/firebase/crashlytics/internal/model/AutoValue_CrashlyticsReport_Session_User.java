package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_User
  extends CrashlyticsReport.Session.User
{
  private final String identifier;
  
  private AutoValue_CrashlyticsReport_Session_User(String paramString)
  {
    this.identifier = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.User))
    {
      paramObject = (CrashlyticsReport.Session.User)paramObject;
      return this.identifier.equals(((CrashlyticsReport.Session.User)paramObject).getIdentifier());
    }
    return false;
  }
  
  public String getIdentifier()
  {
    return this.identifier;
  }
  
  public int hashCode()
  {
    return this.identifier.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("User{identifier=");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.User.Builder
  {
    private String identifier;
    
    public CrashlyticsReport.Session.User build()
    {
      Object localObject2 = this.identifier;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" identifier");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_User(this.identifier, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.User.Builder setIdentifier(String paramString)
    {
      if (paramString != null)
      {
        this.identifier = paramString;
        return this;
      }
      throw new NullPointerException("Null identifier");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */