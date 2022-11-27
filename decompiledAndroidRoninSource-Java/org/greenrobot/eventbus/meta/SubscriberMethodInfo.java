package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo
{
  final Class<?> eventType;
  final String methodName;
  final int priority;
  final boolean sticky;
  final ThreadMode threadMode;
  
  public SubscriberMethodInfo(String paramString, Class<?> paramClass)
  {
    this(paramString, paramClass, ThreadMode.POSTING, 0, false);
  }
  
  public SubscriberMethodInfo(String paramString, Class<?> paramClass, ThreadMode paramThreadMode)
  {
    this(paramString, paramClass, paramThreadMode, 0, false);
  }
  
  public SubscriberMethodInfo(String paramString, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.methodName = paramString;
    this.threadMode = paramThreadMode;
    this.eventType = paramClass;
    this.priority = paramInt;
    this.sticky = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\meta\SubscriberMethodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */