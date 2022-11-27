package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

public class ErrorDialogConfig
{
  int defaultDialogIconId;
  final int defaultErrorMsgId;
  Class<?> defaultEventTypeOnDialogClosed;
  final int defaultTitleId;
  EventBus eventBus;
  boolean logExceptions = true;
  final ExceptionToResourceMapping mapping;
  final Resources resources;
  String tagForLoggingExceptions;
  
  public ErrorDialogConfig(Resources paramResources, int paramInt1, int paramInt2)
  {
    this.resources = paramResources;
    this.defaultTitleId = paramInt1;
    this.defaultErrorMsgId = paramInt2;
    this.mapping = new ExceptionToResourceMapping();
  }
  
  public ErrorDialogConfig addMapping(Class<? extends Throwable> paramClass, int paramInt)
  {
    this.mapping.addMapping(paramClass, paramInt);
    return this;
  }
  
  public void disableExceptionLogging()
  {
    this.logExceptions = false;
  }
  
  EventBus getEventBus()
  {
    EventBus localEventBus = this.eventBus;
    if (localEventBus != null) {
      return localEventBus;
    }
    return EventBus.getDefault();
  }
  
  public int getMessageIdForThrowable(Throwable paramThrowable)
  {
    Object localObject = this.mapping.mapThrowable(paramThrowable);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = EventBus.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("No specific message ressource ID found for ");
    localStringBuilder.append(paramThrowable);
    Log.d((String)localObject, localStringBuilder.toString());
    return this.defaultErrorMsgId;
  }
  
  public void setDefaultDialogIconId(int paramInt)
  {
    this.defaultDialogIconId = paramInt;
  }
  
  public void setDefaultEventTypeOnDialogClosed(Class<?> paramClass)
  {
    this.defaultEventTypeOnDialogClosed = paramClass;
  }
  
  public void setEventBus(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
  }
  
  public void setTagForLoggingExceptions(String paramString)
  {
    this.tagForLoggingExceptions = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\ErrorDialogConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */