package com.google.android.gms.dynamic;

import java.util.Iterator;
import java.util.LinkedList;

final class zaa
  implements OnDelegateCreatedListener<T>
{
  zaa(DeferredLifecycleHelper paramDeferredLifecycleHelper) {}
  
  public final void onDelegateCreated(T paramT)
  {
    DeferredLifecycleHelper.zaa(this.zarj, paramT);
    paramT = DeferredLifecycleHelper.zaa(this.zarj).iterator();
    while (paramT.hasNext()) {
      ((DeferredLifecycleHelper.zaa)paramT.next()).zaa(DeferredLifecycleHelper.zab(this.zarj));
    }
    DeferredLifecycleHelper.zaa(this.zarj).clear();
    DeferredLifecycleHelper.zaa(this.zarj, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */