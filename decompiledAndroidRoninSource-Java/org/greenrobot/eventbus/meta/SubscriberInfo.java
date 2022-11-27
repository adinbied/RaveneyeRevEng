package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public abstract interface SubscriberInfo
{
  public abstract Class<?> getSubscriberClass();
  
  public abstract SubscriberMethod[] getSubscriberMethods();
  
  public abstract SubscriberInfo getSuperSubscriberInfo();
  
  public abstract boolean shouldCheckSuperclass();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\meta\SubscriberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */