package com.huawei.hms.support.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class a
{
  public static Class<?> a(Type paramType)
  {
    if ((paramType instanceof Class)) {
      return (Class)paramType;
    }
    if ((paramType instanceof ParameterizedType)) {
      return (Class)((ParameterizedType)paramType).getRawType();
    }
    if ((paramType instanceof TypeVariable))
    {
      paramType = (TypeVariable)paramType;
      if (paramType.getBounds().length == 0) {
        return Object.class;
      }
      return a(paramType.getBounds()[0]);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("not supported: ");
    localStringBuilder.append(paramType.getClass());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */