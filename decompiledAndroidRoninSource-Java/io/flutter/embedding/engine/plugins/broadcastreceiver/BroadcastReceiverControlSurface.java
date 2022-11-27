package io.flutter.embedding.engine.plugins.broadcastreceiver;

import android.content.BroadcastReceiver;
import androidx.lifecycle.Lifecycle;

public abstract interface BroadcastReceiverControlSurface
{
  public abstract void attachToBroadcastReceiver(BroadcastReceiver paramBroadcastReceiver, Lifecycle paramLifecycle);
  
  public abstract void detachFromBroadcastReceiver();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\broadcastreceiver\BroadcastReceiverControlSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */