package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public final class zaab
{
  private final Map<BasePendingResult<?>, Boolean> zafk = Collections.synchronizedMap(new WeakHashMap());
  private final Map<TaskCompletionSource<?>, Boolean> zafl = Collections.synchronizedMap(new WeakHashMap());
  
  private final void zaa(boolean paramBoolean, Status paramStatus)
  {
    synchronized (this.zafk)
    {
      Object localObject2 = new HashMap(this.zafk);
      synchronized (this.zafl)
      {
        ??? = new HashMap(this.zafl);
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ??? = (Map.Entry)((Iterator)localObject2).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)???).getValue()).booleanValue())) {
            ((BasePendingResult)((Map.Entry)???).getKey()).zab(paramStatus);
          }
        }
        ??? = ((Map)???).entrySet().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)???).next();
          if ((paramBoolean) || (((Boolean)((Map.Entry)localObject2).getValue()).booleanValue())) {
            ((TaskCompletionSource)((Map.Entry)localObject2).getKey()).trySetException(new ApiException(paramStatus));
          }
        }
        return;
      }
    }
  }
  
  final void zaa(BasePendingResult<? extends Result> paramBasePendingResult, boolean paramBoolean)
  {
    this.zafk.put(paramBasePendingResult, Boolean.valueOf(paramBoolean));
    paramBasePendingResult.addStatusListener(new zaac(this, paramBasePendingResult));
  }
  
  final <TResult> void zaa(TaskCompletionSource<TResult> paramTaskCompletionSource, boolean paramBoolean)
  {
    this.zafl.put(paramTaskCompletionSource, Boolean.valueOf(paramBoolean));
    paramTaskCompletionSource.getTask().addOnCompleteListener(new zaad(this, paramTaskCompletionSource));
  }
  
  final boolean zaag()
  {
    return (!this.zafk.isEmpty()) || (!this.zafl.isEmpty());
  }
  
  public final void zaah()
  {
    zaa(false, GoogleApiManager.zahx);
  }
  
  public final void zaai()
  {
    zaa(true, zacp.zakx);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */