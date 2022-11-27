package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;

public abstract class RemoteCreator<T>
{
  private final String zzic;
  private T zzid;
  
  protected RemoteCreator(String paramString)
  {
    this.zzic = paramString;
  }
  
  protected abstract T getRemoteCreator(IBinder paramIBinder);
  
  protected final T getRemoteCreatorInstance(Context paramContext)
    throws RemoteCreator.RemoteCreatorException
  {
    if (this.zzid == null)
    {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.getClassLoader();
        try
        {
          this.zzid = getRemoteCreator((IBinder)paramContext.loadClass(this.zzic).newInstance());
        }
        catch (IllegalAccessException paramContext)
        {
          throw new RemoteCreatorException("Could not access creator.", paramContext);
        }
        catch (InstantiationException paramContext)
        {
          throw new RemoteCreatorException("Could not instantiate creator.", paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          throw new RemoteCreatorException("Could not load creator class.", paramContext);
        }
      }
      else
      {
        throw new RemoteCreatorException("Could not get remote context.");
      }
    }
    return (T)this.zzid;
  }
  
  public static class RemoteCreatorException
    extends Exception
  {
    public RemoteCreatorException(String paramString)
    {
      super();
    }
    
    public RemoteCreatorException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\RemoteCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */