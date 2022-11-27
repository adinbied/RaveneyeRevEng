package dji.thirdparty.ciphersql;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IContentObserver
  extends IInterface
{
  public abstract void onChange(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IContentObserver
  {
    private static final String DESCRIPTOR = "dji.thirdparty.ciphersql.IContentObserver";
    static final int TRANSACTION_onChange = 1;
    
    public Stub()
    {
      attachInterface(this, "dji.thirdparty.ciphersql.IContentObserver");
    }
    
    public static IContentObserver asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("dji.thirdparty.ciphersql.IContentObserver");
      if ((localIInterface != null) && ((localIInterface instanceof IContentObserver))) {
        return (IContentObserver)localIInterface;
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
      implements IContentObserver
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
        return "dji.thirdparty.ciphersql.IContentObserver";
      }
      
      /* Error */
      public void onChange(boolean arg1)
        throws RemoteException
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: return
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\IContentObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */