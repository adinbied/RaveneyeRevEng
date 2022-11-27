package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_CustomAttribute
  extends CrashlyticsReport.CustomAttribute
{
  private final String key;
  private final String value;
  
  private AutoValue_CrashlyticsReport_CustomAttribute(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.CustomAttribute))
    {
      paramObject = (CrashlyticsReport.CustomAttribute)paramObject;
      return (this.key.equals(((CrashlyticsReport.CustomAttribute)paramObject).getKey())) && (this.value.equals(((CrashlyticsReport.CustomAttribute)paramObject).getValue()));
    }
    return false;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return (this.key.hashCode() ^ 0xF4243) * 1000003 ^ this.value.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CustomAttribute{key=");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.value);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.CustomAttribute.Builder
  {
    private String key;
    private String value;
    
    public CrashlyticsReport.CustomAttribute build()
    {
      Object localObject2 = this.key;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" key");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.value == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" value");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_CustomAttribute(this.key, this.value, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.CustomAttribute.Builder setKey(String paramString)
    {
      if (paramString != null)
      {
        this.key = paramString;
        return this;
      }
      throw new NullPointerException("Null key");
    }
    
    public CrashlyticsReport.CustomAttribute.Builder setValue(String paramString)
    {
      if (paramString != null)
      {
        this.value = paramString;
        return this;
      }
      throw new NullPointerException("Null value");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_CustomAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */