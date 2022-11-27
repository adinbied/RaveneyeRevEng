package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class ObjectWrapper<T>
  extends IObjectWrapper.Stub
{
  private final T zzib;
  
  private ObjectWrapper(T paramT)
  {
    this.zzib = paramT;
  }
  
  public static <T> T unwrap(IObjectWrapper paramIObjectWrapper)
  {
    if ((paramIObjectWrapper instanceof ObjectWrapper)) {
      return (T)((ObjectWrapper)paramIObjectWrapper).zzib;
    }
    IBinder localIBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = localIBinder.getClass().getDeclaredFields();
    paramIObjectWrapper = null;
    int m = arrayOfField.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Field localField = arrayOfField[i];
      k = j;
      if (!localField.isSynthetic())
      {
        k = j + 1;
        paramIObjectWrapper = localField;
      }
      i += 1;
    }
    if (j == 1)
    {
      if (!paramIObjectWrapper.isAccessible())
      {
        paramIObjectWrapper.setAccessible(true);
        try
        {
          paramIObjectWrapper = paramIObjectWrapper.get(localIBinder);
          return paramIObjectWrapper;
        }
        catch (IllegalAccessException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", paramIObjectWrapper);
        }
        catch (NullPointerException paramIObjectWrapper)
        {
          throw new IllegalArgumentException("Binder object is null.", paramIObjectWrapper);
        }
      }
      throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    }
    i = arrayOfField.length;
    paramIObjectWrapper = new StringBuilder(64);
    paramIObjectWrapper.append("Unexpected number of IObjectWrapper declared fields: ");
    paramIObjectWrapper.append(i);
    throw new IllegalArgumentException(paramIObjectWrapper.toString());
  }
  
  public static <T> IObjectWrapper wrap(T paramT)
  {
    return new ObjectWrapper(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\ObjectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */