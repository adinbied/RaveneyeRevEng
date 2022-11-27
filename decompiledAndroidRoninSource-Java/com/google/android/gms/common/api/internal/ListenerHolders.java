package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class ListenerHolders
{
  private final Set<ListenerHolder<?>> zajo = Collections.newSetFromMap(new WeakHashMap());
  
  public static <L> ListenerHolder<L> createListenerHolder(L paramL, Looper paramLooper, String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder(paramLooper, paramL, paramString);
  }
  
  public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L paramL, String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    return new ListenerHolder.ListenerKey(paramL, paramString);
  }
  
  public final void release()
  {
    Iterator localIterator = this.zajo.iterator();
    while (localIterator.hasNext()) {
      ((ListenerHolder)localIterator.next()).clear();
    }
    this.zajo.clear();
  }
  
  public final <L> ListenerHolder<L> zaa(L paramL, Looper paramLooper, String paramString)
  {
    paramL = createListenerHolder(paramL, paramLooper, paramString);
    this.zajo.add(paramL);
    return paramL;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\ListenerHolders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */