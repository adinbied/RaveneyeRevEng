package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class SubscriberMethod
{
  final Class<?> eventType;
  final Method method;
  String methodString;
  final int priority;
  final boolean sticky;
  final ThreadMode threadMode;
  
  public SubscriberMethod(Method paramMethod, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.method = paramMethod;
    this.threadMode = paramThreadMode;
    this.eventType = paramClass;
    this.priority = paramInt;
    this.sticky = paramBoolean;
  }
  
  private void checkMethodString()
  {
    try
    {
      if (this.methodString == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append(this.method.getDeclaringClass().getName());
        localStringBuilder.append('#');
        localStringBuilder.append(this.method.getName());
        localStringBuilder.append('(');
        localStringBuilder.append(this.eventType.getName());
        this.methodString = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof SubscriberMethod))
    {
      checkMethodString();
      paramObject = (SubscriberMethod)paramObject;
      ((SubscriberMethod)paramObject).checkMethodString();
      return this.methodString.equals(((SubscriberMethod)paramObject).methodString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.method.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbus\SubscriberMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */