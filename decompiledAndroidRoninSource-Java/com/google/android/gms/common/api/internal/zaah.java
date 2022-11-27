package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zaah
  implements zabd
{
  private final zabe zaft;
  private boolean zafu = false;
  
  public zaah(zabe paramzabe)
  {
    this.zaft = paramzabe;
  }
  
  public final void begin() {}
  
  public final void connect()
  {
    if (this.zafu)
    {
      this.zafu = false;
      this.zaft.zaa(new zaaj(this, this));
    }
  }
  
  public final boolean disconnect()
  {
    if (this.zafu) {
      return false;
    }
    if (this.zaft.zaee.zaax())
    {
      this.zafu = true;
      Iterator localIterator = this.zaft.zaee.zahe.iterator();
      while (localIterator.hasNext()) {
        ((zacm)localIterator.next()).zabv();
      }
      return false;
    }
    this.zaft.zaf(null);
    return true;
  }
  
  public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T paramT)
  {
    return execute(paramT);
  }
  
  public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T paramT)
  {
    try
    {
      this.zaft.zaee.zahf.zab(paramT);
      Object localObject1 = this.zaft.zaee;
      Object localObject2 = paramT.getClientKey();
      localObject2 = (Api.Client)((zaaw)localObject1).zagz.get(localObject2);
      Preconditions.checkNotNull(localObject2, "Appropriate Api was not requested.");
      if ((!((Api.Client)localObject2).isConnected()) && (this.zaft.zahp.containsKey(paramT.getClientKey())))
      {
        paramT.setFailedResult(new Status(17));
        return paramT;
      }
      localObject1 = localObject2;
      if ((localObject2 instanceof SimpleClientAdapter)) {
        localObject1 = ((SimpleClientAdapter)localObject2).getClient();
      }
      paramT.run((Api.AnyClient)localObject1);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      for (;;) {}
    }
    this.zaft.zaa(new zaai(this, this));
    return paramT;
  }
  
  public final void onConnected(Bundle paramBundle) {}
  
  public final void onConnectionSuspended(int paramInt)
  {
    this.zaft.zaf(null);
    this.zaft.zaht.zab(paramInt, this.zafu);
  }
  
  public final void zaa(ConnectionResult paramConnectionResult, Api<?> paramApi, boolean paramBoolean) {}
  
  final void zaam()
  {
    if (this.zafu)
    {
      this.zafu = false;
      this.zaft.zaee.zahf.release();
      disconnect();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */