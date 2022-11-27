package dji.thirdparty.ciphersql;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Map;

final class BulkCursorProxy
  implements IBulkCursor
{
  private Bundle mExtras;
  private IBinder mRemote;
  
  public BulkCursorProxy(IBinder paramIBinder)
  {
    this.mRemote = paramIBinder;
    this.mExtras = null;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  /* Error */
  public void close()
    throws RemoteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int count()
    throws RemoteException
  {
    return 0;
  }
  
  /* Error */
  public void deactivate()
    throws RemoteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean deleteRow(int paramInt)
    throws RemoteException
  {
    return false;
  }
  
  public String[] getColumnNames()
    throws RemoteException
  {
    return null;
  }
  
  public Bundle getExtras()
    throws RemoteException
  {
    return null;
  }
  
  public boolean getWantsAllOnMoveCalls()
    throws RemoteException
  {
    return false;
  }
  
  public CursorWindow getWindow(int paramInt)
    throws RemoteException
  {
    return null;
  }
  
  /* Error */
  public void onMove(int arg1)
    throws RemoteException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public int requery(IContentObserver paramIContentObserver, CursorWindow paramCursorWindow)
    throws RemoteException
  {
    return 0;
  }
  
  public Bundle respond(Bundle paramBundle)
    throws RemoteException
  {
    return null;
  }
  
  public boolean updateRows(Map paramMap)
    throws RemoteException
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\BulkCursorProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */