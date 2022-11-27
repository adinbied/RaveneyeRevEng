package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo
  implements SubscriberInfo
{
  private final boolean shouldCheckSuperclass;
  private final Class subscriberClass;
  private final Class<? extends SubscriberInfo> superSubscriberInfoClass;
  
  protected AbstractSubscriberInfo(Class paramClass, Class<? extends SubscriberInfo> paramClass1, boolean paramBoolean)
  {
    this.subscriberClass = paramClass;
    this.superSubscriberInfoClass = paramClass1;
    this.shouldCheckSuperclass = paramBoolean;
  }
  
  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass)
  {
    return createSubscriberMethod(paramString, paramClass, ThreadMode.POSTING, 0, false);
  }
  
  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass, ThreadMode paramThreadMode)
  {
    return createSubscriberMethod(paramString, paramClass, paramThreadMode, 0, false);
  }
  
  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramString = new SubscriberMethod(this.subscriberClass.getDeclaredMethod(paramString, new Class[] { paramClass }), paramClass, paramThreadMode, paramInt, paramBoolean);
      return paramString;
    }
    catch (NoSuchMethodException paramString)
    {
      paramClass = new StringBuilder();
      paramClass.append("Could not find subscriber method in ");
      paramClass.append(this.subscriberClass);
      paramClass.append(". Maybe a missing ProGuard rule?");
      throw new EventBusException(paramClass.toString(), paramString);
    }
  }
  
  public Class getSubscriberClass()
  {
    return this.subscriberClass;
  }
  
  public SubscriberInfo getSuperSubscriberInfo()
  {
    Object localObject = this.superSubscriberInfoClass;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = (SubscriberInfo)((Class)localObject).newInstance();
      return (SubscriberInfo)localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
  }
  
  public boolean shouldCheckSuperclass()
  {
    return this.shouldCheckSuperclass;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\meta\AbstractSubscriberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */