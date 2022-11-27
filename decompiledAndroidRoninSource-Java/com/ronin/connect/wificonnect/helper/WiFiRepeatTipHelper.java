package com.ronin.connect.wificonnect.helper;

import android.net.ConnectivityManager.NetworkCallback;
import com.dji.basic.handler.ComTimeCounter;
import com.ronin.connect.wificonnect.bean.NetworkConnectState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WiFiRepeatTipHelper
{
  private final String TAG = "WiFiRepeatTipHelper";
  private final long TIME_OUT_LIMITED = 300000L;
  private ConnectivityManager.NetworkCallback networkCallback;
  private final Map<NetworkConnectState, List<SpecialState>> recorder = new HashMap();
  private ComTimeCounter timeCounter = new ComTimeCounter()
  {
    public void countdownOver()
    {
      WiFiRepeatTipHelper.this.reset();
    }
  };
  
  /* Error */
  private void commonCheckLogic()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void disconnect(NetworkConnectState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void specialCheckLogic()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void startCheck()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void stopTimer()
  {
    ComTimeCounter localComTimeCounter = this.timeCounter;
    if (localComTimeCounter != null) {
      localComTimeCounter.stopHandler();
    }
  }
  
  public void addNetworkCallback(ConnectivityManager.NetworkCallback paramNetworkCallback)
  {
    reset();
    this.networkCallback = paramNetworkCallback;
    startTimer();
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateState(NetworkConnectState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class SpecialState
  {
    public NetworkConnectState state;
    public long time;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\helper\WiFiRepeatTipHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */