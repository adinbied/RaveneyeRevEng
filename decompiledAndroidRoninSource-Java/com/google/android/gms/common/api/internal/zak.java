package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zak
{
  private final ArrayMap<zai<?>, ConnectionResult> zaay = new ArrayMap();
  private final ArrayMap<zai<?>, String> zadb = new ArrayMap();
  private final TaskCompletionSource<Map<zai<?>, String>> zadc = new TaskCompletionSource();
  private int zadd;
  private boolean zade = false;
  
  public zak(Iterable<? extends GoogleApi<?>> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      GoogleApi localGoogleApi = (GoogleApi)paramIterable.next();
      this.zaay.put(localGoogleApi.zak(), null);
    }
    this.zadd = this.zaay.keySet().size();
  }
  
  public final Task<Map<zai<?>, String>> getTask()
  {
    return this.zadc.getTask();
  }
  
  public final void zaa(zai<?> paramzai, ConnectionResult paramConnectionResult, String paramString)
  {
    this.zaay.put(paramzai, paramConnectionResult);
    this.zadb.put(paramzai, paramString);
    this.zadd -= 1;
    if (!paramConnectionResult.isSuccess()) {
      this.zade = true;
    }
    if (this.zadd == 0)
    {
      if (this.zade)
      {
        paramzai = new AvailabilityException(this.zaay);
        this.zadc.setException(paramzai);
        return;
      }
      this.zadc.setResult(this.zadb);
    }
  }
  
  public final Set<zai<?>> zap()
  {
    return this.zaay.keySet();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */