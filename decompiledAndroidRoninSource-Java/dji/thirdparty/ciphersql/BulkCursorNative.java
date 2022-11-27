package dji.thirdparty.ciphersql;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class BulkCursorNative
  extends Binder
  implements IBulkCursor
{
  public BulkCursorNative()
  {
    attachInterface(this, "android.content.IBulkCursor");
  }
  
  public static IBulkCursor asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IBulkCursor localIBulkCursor = (IBulkCursor)paramIBinder.queryLocalInterface("android.content.IBulkCursor");
    if (localIBulkCursor != null) {
      return localIBulkCursor;
    }
    return new BulkCursorProxy(paramIBinder);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\BulkCursorNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */