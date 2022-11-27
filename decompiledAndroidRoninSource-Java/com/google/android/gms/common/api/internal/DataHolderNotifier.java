package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class DataHolderNotifier<L>
  implements ListenerHolder.Notifier<L>
{
  private final DataHolder mDataHolder;
  
  protected DataHolderNotifier(DataHolder paramDataHolder)
  {
    this.mDataHolder = paramDataHolder;
  }
  
  public final void notifyListener(L paramL)
  {
    notifyListener(paramL, this.mDataHolder);
  }
  
  protected abstract void notifyListener(L paramL, DataHolder paramDataHolder);
  
  public void onNotifyListenerFailed()
  {
    DataHolder localDataHolder = this.mDataHolder;
    if (localDataHolder != null) {
      localDataHolder.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\DataHolderNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */