package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class zae
  extends zab
  implements zad
{
  public zae()
  {
    super("com.google.android.gms.signin.internal.ISignInCallbacks");
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 3)
    {
      if (paramInt1 != 4)
      {
        if (paramInt1 != 6)
        {
          if (paramInt1 != 7)
          {
            if (paramInt1 != 8) {
              return false;
            }
            zab((zaj)zac.zaa(paramParcel1, zaj.CREATOR));
          }
          else
          {
            zaa((Status)zac.zaa(paramParcel1, Status.CREATOR), (GoogleSignInAccount)zac.zaa(paramParcel1, GoogleSignInAccount.CREATOR));
          }
        }
        else {
          zah((Status)zac.zaa(paramParcel1, Status.CREATOR));
        }
      }
      else {
        zag((Status)zac.zaa(paramParcel1, Status.CREATOR));
      }
    }
    else {
      zaa((ConnectionResult)zac.zaa(paramParcel1, ConnectionResult.CREATOR), (zaa)zac.zaa(paramParcel1, zaa.CREATOR));
    }
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\signin\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */