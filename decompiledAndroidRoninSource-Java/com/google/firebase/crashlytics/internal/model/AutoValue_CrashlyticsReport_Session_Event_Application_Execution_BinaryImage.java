package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable.Ignore;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage
  extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage
{
  private final long baseAddress;
  private final String name;
  private final long size;
  private final String uuid;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.baseAddress = paramLong1;
    this.size = paramLong2;
    this.name = paramString1;
    this.uuid = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject;
      if ((this.baseAddress == ((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getBaseAddress()) && (this.size == ((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getSize()) && (this.name.equals(((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getName())))
      {
        String str = this.uuid;
        if (str == null)
        {
          if (((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getUuid() == null) {
            return true;
          }
        }
        else if (str.equals(((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)paramObject).getUuid())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public long getBaseAddress()
  {
    return this.baseAddress;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  @Encodable.Ignore
  public String getUuid()
  {
    return this.uuid;
  }
  
  public int hashCode()
  {
    long l = this.baseAddress;
    int j = (int)(l ^ l >>> 32);
    l = this.size;
    int k = (int)(l >>> 32 ^ l);
    int m = this.name.hashCode();
    String str = this.uuid;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return i ^ (((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ m) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BinaryImage{baseAddress=");
    localStringBuilder.append(this.baseAddress);
    localStringBuilder.append(", size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", uuid=");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder
  {
    private Long baseAddress;
    private String name;
    private Long size;
    private String uuid;
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build()
    {
      Object localObject2 = this.baseAddress;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" baseAddress");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.size == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" size");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.name == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" name");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (((String)localObject1).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid, null);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Missing required properties:");
      ((StringBuilder)localObject2).append((String)localObject1);
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long paramLong)
    {
      this.baseAddress = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String paramString)
    {
      if (paramString != null)
      {
        this.name = paramString;
        return this;
      }
      throw new NullPointerException("Null name");
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long paramLong)
    {
      this.size = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String paramString)
    {
      this.uuid = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */