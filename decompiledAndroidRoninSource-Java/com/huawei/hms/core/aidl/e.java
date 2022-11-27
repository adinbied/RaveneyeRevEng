package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface e
  extends IInterface
{
  public abstract void a(b paramb)
    throws RemoteException;
  
  public abstract void a(b paramb, d paramd)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements e
  {
    public static e a(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
      if ((localIInterface != null) && ((localIInterface instanceof e))) {
        return (e)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 1598968902) {
            return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
          }
          paramParcel2.writeString("com.huawei.hms.core.aidl.IAIDLInvoke");
          return true;
        }
        paramParcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (b)b.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, d.a.asInterface(paramParcel1.readStrongBinder()));
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.hms.core.aidl.IAIDLInvoke");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (b)b.CREATOR.createFromParcel(paramParcel1);
      }
      a((b)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements e
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      /* Error */
      public void a(b arg1)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      /* Error */
      public void a(b arg1, d arg2)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\core\aidl\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */