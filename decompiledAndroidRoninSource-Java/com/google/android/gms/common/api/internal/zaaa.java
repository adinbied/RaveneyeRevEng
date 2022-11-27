package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class zaaa
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private SignInConnectionListener zafj;
  
  zaaa(zax paramzax, SignInConnectionListener paramSignInConnectionListener)
  {
    this.zafj = paramSignInConnectionListener;
  }
  
  final void cancel()
  {
    this.zafj.onComplete();
  }
  
  public final void onComplete(Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafi).lock();
    try
    {
      if (!zax.zab(this.zafi))
      {
        this.zafj.onComplete();
        return;
      }
      Object localObject;
      if (paramTask.isSuccessful())
      {
        zax.zab(this.zafi, new ArrayMap(zax.zam(this.zafi).size()));
        paramTask = zax.zam(this.zafi).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zaw)paramTask.next();
          zax.zag(this.zafi).put(((GoogleApi)localObject).zak(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if ((paramTask.getException() instanceof AvailabilityException))
      {
        paramTask = (AvailabilityException)paramTask.getException();
        if (zax.zae(this.zafi))
        {
          zax.zab(this.zafi, new ArrayMap(zax.zam(this.zafi).size()));
          localObject = zax.zam(this.zafi).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            zaw localzaw = (zaw)((Iterator)localObject).next();
            zai localzai = localzaw.zak();
            ConnectionResult localConnectionResult = paramTask.getConnectionResult(localzaw);
            if (zax.zaa(this.zafi, localzaw, localConnectionResult)) {
              zax.zag(this.zafi).put(localzai, new ConnectionResult(16));
            } else {
              zax.zag(this.zafi).put(localzai, localConnectionResult);
            }
          }
        }
        zax.zab(this.zafi, paramTask.zaj());
      }
      else
      {
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zax.zab(this.zafi, Collections.emptyMap());
      }
      if (this.zafi.isConnected())
      {
        zax.zad(this.zafi).putAll(zax.zag(this.zafi));
        if (zax.zaf(this.zafi) == null)
        {
          zax.zai(this.zafi);
          zax.zaj(this.zafi);
          zax.zal(this.zafi).signalAll();
        }
      }
      this.zafj.onComplete();
      return;
    }
    finally
    {
      zax.zaa(this.zafi).unlock();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */