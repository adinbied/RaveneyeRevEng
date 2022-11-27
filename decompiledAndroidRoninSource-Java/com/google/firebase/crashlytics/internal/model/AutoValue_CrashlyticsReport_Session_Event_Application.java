package com.google.firebase.crashlytics.internal.model;

final class AutoValue_CrashlyticsReport_Session_Event_Application
  extends CrashlyticsReport.Session.Event.Application
{
  private final Boolean background;
  private final ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
  private final CrashlyticsReport.Session.Event.Application.Execution execution;
  private final int uiOrientation;
  
  private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution paramExecution, ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList, Boolean paramBoolean, int paramInt)
  {
    this.execution = paramExecution;
    this.customAttributes = paramImmutableList;
    this.background = paramBoolean;
    this.uiOrientation = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.Session.Event.Application))
    {
      paramObject = (CrashlyticsReport.Session.Event.Application)paramObject;
      if (this.execution.equals(((CrashlyticsReport.Session.Event.Application)paramObject).getExecution()))
      {
        Object localObject = this.customAttributes;
        if (localObject == null ? ((CrashlyticsReport.Session.Event.Application)paramObject).getCustomAttributes() == null : ((ImmutableList)localObject).equals(((CrashlyticsReport.Session.Event.Application)paramObject).getCustomAttributes()))
        {
          localObject = this.background;
          if ((localObject == null ? ((CrashlyticsReport.Session.Event.Application)paramObject).getBackground() == null : ((Boolean)localObject).equals(((CrashlyticsReport.Session.Event.Application)paramObject).getBackground())) && (this.uiOrientation == ((CrashlyticsReport.Session.Event.Application)paramObject).getUiOrientation())) {
            return true;
          }
        }
      }
      return false;
    }
    return false;
  }
  
  public Boolean getBackground()
  {
    return this.background;
  }
  
  public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes()
  {
    return this.customAttributes;
  }
  
  public CrashlyticsReport.Session.Event.Application.Execution getExecution()
  {
    return this.execution;
  }
  
  public int getUiOrientation()
  {
    return this.uiOrientation;
  }
  
  public int hashCode()
  {
    int k = this.execution.hashCode();
    Object localObject = this.customAttributes;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ImmutableList)localObject).hashCode();
    }
    localObject = this.background;
    if (localObject != null) {
      j = ((Boolean)localObject).hashCode();
    }
    return (((k ^ 0xF4243) * 1000003 ^ i) * 1000003 ^ j) * 1000003 ^ this.uiOrientation;
  }
  
  public CrashlyticsReport.Session.Event.Application.Builder toBuilder()
  {
    return new Builder(this, null);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Application{execution=");
    localStringBuilder.append(this.execution);
    localStringBuilder.append(", customAttributes=");
    localStringBuilder.append(this.customAttributes);
    localStringBuilder.append(", background=");
    localStringBuilder.append(this.background);
    localStringBuilder.append(", uiOrientation=");
    localStringBuilder.append(this.uiOrientation);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.Session.Event.Application.Builder
  {
    private Boolean background;
    private ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
    private CrashlyticsReport.Session.Event.Application.Execution execution;
    private Integer uiOrientation;
    
    Builder() {}
    
    private Builder(CrashlyticsReport.Session.Event.Application paramApplication)
    {
      this.execution = paramApplication.getExecution();
      this.customAttributes = paramApplication.getCustomAttributes();
      this.background = paramApplication.getBackground();
      this.uiOrientation = Integer.valueOf(paramApplication.getUiOrientation());
    }
    
    public CrashlyticsReport.Session.Event.Application build()
    {
      Object localObject2 = this.execution;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" execution");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.uiOrientation == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" uiOrientation");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.background, this.uiOrientation.intValue(), null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setBackground(Boolean paramBoolean)
    {
      this.background = paramBoolean;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> paramImmutableList)
    {
      this.customAttributes = paramImmutableList;
      return this;
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution paramExecution)
    {
      if (paramExecution != null)
      {
        this.execution = paramExecution;
        return this;
      }
      throw new NullPointerException("Null execution");
    }
    
    public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int paramInt)
    {
      this.uiOrientation = Integer.valueOf(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_Session_Event_Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */