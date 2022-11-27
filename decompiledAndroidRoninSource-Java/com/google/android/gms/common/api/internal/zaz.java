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

final class zaz
  implements OnCompleteListener<Map<zai<?>, String>>
{
  private zaz(zax paramzax) {}
  
  public final void onComplete(Task<Map<zai<?>, String>> paramTask)
  {
    zax.zaa(this.zafi).lock();
    try
    {
      boolean bool = zax.zab(this.zafi);
      if (!bool) {
        return;
      }
      Object localObject;
      if (paramTask.isSuccessful())
      {
        zax.zaa(this.zafi, new ArrayMap(zax.zac(this.zafi).size()));
        paramTask = zax.zac(this.zafi).values().iterator();
        while (paramTask.hasNext())
        {
          localObject = (zaw)paramTask.next();
          zax.zad(this.zafi).put(((GoogleApi)localObject).zak(), ConnectionResult.RESULT_SUCCESS);
        }
      }
      if ((paramTask.getException() instanceof AvailabilityException))
      {
        paramTask = (AvailabilityException)paramTask.getException();
        if (zax.zae(this.zafi))
        {
          zax.zaa(this.zafi, new ArrayMap(zax.zac(this.zafi).size()));
          localObject = zax.zac(this.zafi).values().iterator();
          while (((Iterator)localObject).hasNext())
          {
            zaw localzaw = (zaw)((Iterator)localObject).next();
            zai localzai = localzaw.zak();
            ConnectionResult localConnectionResult = paramTask.getConnectionResult(localzaw);
            if (zax.zaa(this.zafi, localzaw, localConnectionResult)) {
              zax.zad(this.zafi).put(localzai, new ConnectionResult(16));
            } else {
              zax.zad(this.zafi).put(localzai, localConnectionResult);
            }
          }
        }
        zax.zaa(this.zafi, paramTask.zaj());
        zax.zaa(this.zafi, zax.zaf(this.zafi));
      }
      else
      {
        Log.e("ConnectionlessGAC", "Unexpected availability exception", paramTask.getException());
        zax.zaa(this.zafi, Collections.emptyMap());
        zax.zaa(this.zafi, new ConnectionResult(8));
      }
      if (zax.zag(this.zafi) != null)
      {
        zax.zad(this.zafi).putAll(zax.zag(this.zafi));
        zax.zaa(this.zafi, zax.zaf(this.zafi));
      }
      if (zax.zah(this.zafi) == null)
      {
        zax.zai(this.zafi);
        zax.zaj(this.zafi);
      }
      else
      {
        zax.zaa(this.zafi, false);
        zax.zak(this.zafi).zac(zax.zah(this.zafi));
      }
      zax.zal(this.zafi).signalAll();
      return;
    }
    finally
    {
      zax.zaa(this.zafi).unlock();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */