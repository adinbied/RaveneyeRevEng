package com.huawei.updatesdk.sdk.a.d;

import com.huawei.updatesdk.sdk.a.c.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class d
{
  private static final String a = d.class.getSimpleName();
  
  public static Class a(Field paramField)
  {
    if (Map.class.isAssignableFrom(paramField.getType())) {}
    for (int i = 1;; i = 0)
    {
      return a(paramField, i);
      if (!List.class.isAssignableFrom(paramField.getType())) {
        break;
      }
    }
    return null;
  }
  
  private static Class a(Field paramField, int paramInt)
  {
    paramField = paramField.getGenericType();
    if ((paramField instanceof ParameterizedType))
    {
      paramField = ((ParameterizedType)paramField).getActualTypeArguments();
      if ((paramField != null) && (paramField.length > paramInt)) {
        try
        {
          if ((paramField[paramInt] instanceof Class)) {
            return (Class)paramField[paramInt];
          }
          paramField = paramField[paramInt].toString();
          int i = paramField.indexOf("class ");
          paramInt = i;
          if (i < 0) {
            paramInt = 0;
          }
          int j = paramField.indexOf("<");
          i = j;
          if (j < 0) {
            i = paramField.length();
          }
          paramField = Class.forName(paramField.substring(paramInt, i));
          return paramField;
        }
        catch (ClassNotFoundException paramField)
        {
          String str = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getType exception!");
          localStringBuilder.append(paramField.getMessage());
          a.d(str, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  public static Field[] a(Class paramClass)
  {
    if (paramClass.getSuperclass() != null) {
      localObject1 = a(paramClass.getSuperclass());
    } else {
      localObject1 = null;
    }
    Object localObject2 = paramClass.getDeclaredFields();
    int i = 0;
    paramClass = (Class)localObject2;
    if (localObject1 != null)
    {
      paramClass = (Class)localObject2;
      if (localObject1.length > 0)
      {
        paramClass = new Field[localObject2.length + localObject1.length];
        System.arraycopy(localObject1, 0, paramClass, 0, localObject1.length);
        System.arraycopy(localObject2, 0, paramClass, localObject1.length, localObject2.length);
      }
    }
    localObject2 = new ArrayList();
    int j = paramClass.length;
    while (i < j)
    {
      localObject1 = paramClass[i];
      if (((Field)localObject1).getName().indexOf("$") < 0) {
        ((List)localObject2).add(localObject1);
      }
      i += 1;
    }
    Object localObject1 = paramClass;
    if (((List)localObject2).size() != paramClass.length)
    {
      localObject1 = new Field[((List)localObject2).size()];
      ((List)localObject2).toArray((Object[])localObject1);
    }
    return (Field[])localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawe\\updatesdk\sdk\a\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */