package com.huawei.gamebox.plugin.gameservice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IGameBuoyService
  extends IInterface
{
  public abstract void request(RequestInfo paramRequestInfo, ICallback paramICallback)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IGameBuoyService
  {
    private static final String DESCRIPTOR = "com.huawei.gamebox.plugin.gameservice.service.IGameBuoyService";
    static final int TRANSACTION_request = 1;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.gamebox.plugin.gameservice.service.IGameBuoyService");
    }
    
    public static IGameBuoyService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.gamebox.plugin.gameservice.service.IGameBuoyService");
      if ((localIInterface != null) && ((localIInterface instanceof IGameBuoyService))) {
        return (IGameBuoyService)localIInterface;
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
      implements IGameBuoyService
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
        return "com.huawei.gamebox.plugin.gameservice.service.IGameBuoyService";
      }
      
      /* Error */
      public void request(RequestInfo arg1, ICallback arg2)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\gamebox\plugin\gameservice\service\IGameBuoyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */