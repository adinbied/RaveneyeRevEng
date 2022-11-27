package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame
  extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
{
  private final String file;
  private final int importance;
  private final long offset;
  private final long pc;
  private final String symbol;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt)
  {
    this.pc = paramLong1;
    this.symbol = paramString1;
    this.file = paramString2;
    this.offset = paramLong2;
    this.importance = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject;
      if ((this.pc == ((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getPc()) && (this.symbol.equals(((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getSymbol())))
      {
        String str = this.file;
        if ((str == null ? ((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getFile() == null : str.equals(((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getFile())) && (this.offset == ((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getOffset()) && (this.importance == ((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)paramObject).getImportance())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public String getFile()
  {
    return this.file;
  }
  
  public int getImportance()
  {
    return this.importance;
  }
  
  public long getOffset()
  {
    return this.offset;
  }
  
  public long getPc()
  {
    return this.pc;
  }
  
  public String getSymbol()
  {
    return this.symbol;
  }
  
  public int hashCode()
  {
    long l = this.pc;
    int j = (int)(l ^ l >>> 32);
    int k = this.symbol.hashCode();
    String str = this.file;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    l = this.offset;
    int m = (int)(l >>> 32 ^ l);
    return this.importance ^ ((((j ^ 0xF4243) * 1000003 ^ k) * 1000003 ^ i) * 1000003 ^ m) * 1000003;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame{pc=");
    localStringBuilder.append(this.pc);
    localStringBuilder.append(", symbol=");
    localStringBuilder.append(this.symbol);
    localStringBuilder.append(", file=");
    localStringBuilder.append(this.file);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(", importance=");
    localStringBuilder.append(this.importance);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
  {
    private String file;
    private Integer importance;
    private Long offset;
    private Long pc;
    private String symbol;
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build()
    {
      Object localObject2 = this.pc;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" pc");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.symbol == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" symbol");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (this.offset == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" offset");
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
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String paramString)
    {
      this.file = paramString;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int paramInt)
    {
      this.importance = Integer.valueOf(paramInt);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long paramLong)
    {
      this.offset = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long paramLong)
    {
      this.pc = Long.valueOf(paramLong);
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String paramString)
    {
      if (paramString != null)
      {
        this.symbol = paramString;
        return this;
      }
      throw new NullPointerException("Null symbol");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */