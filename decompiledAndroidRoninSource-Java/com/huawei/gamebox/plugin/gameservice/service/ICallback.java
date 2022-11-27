package com.huawei.gamebox.plugin.gameservice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface ICallback
  extends IInterface
{
  public abstract void onInit(int paramInt)
    throws RemoteException;
  
  public abstract void openView(String paramString)
    throws RemoteException;
  
  public abstract void response(String paramString1, String paramString2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements ICallback
  {
    private static final String DESCRIPTOR = "com.huawei.gamebox.plugin.gameservice.service.ICallback";
    static final int TRANSACTION_onInit = 1;
    static final int TRANSACTION_openView = 3;
    static final int TRANSACTION_response = 2;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.gamebox.plugin.gameservice.service.ICallback");
    }
    
    public static ICallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.gamebox.plugin.gameservice.service.ICallback");
      if ((localIInterface != null) && ((localIInterface instanceof ICallback))) {
        return (ICallback)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      return false;
    }
    
    private static class Proxy
      implements ICallback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.huawei.gamebox.plugin.gameservice.service.ICallback";
      }
      
      /* Error */
      public void onInit(int arg1)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: return
      }
      
      /* Error */
      public void openView(String arg1)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      /* Error */
      public void response(String arg1, String arg2)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\gamebox\plugin\gameservice\service\ICallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */