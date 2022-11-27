package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

public final class ListenerHolder<L>
{
  private final zaa zajj;
  private volatile L zajk;
  private final ListenerKey<L> zajl;
  
  ListenerHolder(Looper paramLooper, L paramL, String paramString)
  {
    this.zajj = new zaa(paramLooper);
    this.zajk = Preconditions.checkNotNull(paramL, "Listener must not be null");
    this.zajl = new ListenerKey(paramL, Preconditions.checkNotEmpty(paramString));
  }
  
  public final void clear()
  {
    this.zajk = null;
  }
  
  public final ListenerKey<L> getListenerKey()
  {
    return this.zajl;
  }
  
  public final boolean hasListener()
  {
    return this.zajk != null;
  }
  
  public final void notifyListener(Notifier<? super L> paramNotifier)
  {
    Preconditions.checkNotNull(paramNotifier, "Notifier must not be null");
    paramNotifier = this.zajj.obtainMessage(1, paramNotifier);
    this.zajj.sendMessage(paramNotifier);
  }
  
  final void notifyListenerInternal(Notifier<? super L> paramNotifier)
  {
    Object localObject = this.zajk;
    if (localObject == null)
    {
      paramNotifier.onNotifyListenerFailed();
      return;
    }
    try
    {
      paramNotifier.notifyListener(localObject);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramNotifier.onNotifyListenerFailed();
      throw localRuntimeException;
    }
  }
  
  public static final class ListenerKey<L>
  {
    private final L zajk;
    private final String zajn;
    
    ListenerKey(L paramL, String paramString)
    {
      this.zajk = paramL;
      this.zajn = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof ListenerKey)) {
        return false;
      }
      paramObject = (ListenerKey)paramObject;
      return (this.zajk == ((ListenerKey)paramObject).zajk) && (this.zajn.equals(((ListenerKey)paramObject).zajn));
    }
    
    public final int hashCode()
    {
      return System.identityHashCode(this.zajk) * 31 + this.zajn.hashCode();
    }
  }
  
  public static abstract interface Notifier<L>
  {
    public abstract void notifyListener(L paramL);
    
    public abstract void onNotifyListenerFailed();
  }
  
  private final class zaa
    extends zap
  {
    public zaa(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      Preconditions.checkArgument(bool);
      ListenerHolder.this.notifyListenerInternal((ListenerHolder.Notifier)paramMessage.obj);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\ListenerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */