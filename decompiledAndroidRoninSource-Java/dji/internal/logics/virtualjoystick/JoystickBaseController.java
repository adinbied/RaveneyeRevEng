package dji.internal.logics.virtualjoystick;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.model.P3.DataFlycSetJoyStickParams;
import dji.midware.data.model.P3.DataFlycSetJoyStickParams.FlycMode;
import dji.midware.util.BackgroundLooper;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;

public class JoystickBaseController
{
  public static final int BASE_CHANNEL_VALUE = 1024;
  private static final int DELAY_DOWN_STOP = 5000;
  private static final float DIVIDER_MAX = 0.89F;
  private static final int MAX_TIME_INTERVAL = 100;
  private static final int MSG_DOWN_STOP = 1001;
  private static final int ORIGINAL_MAX_CHANNEL_VALUE = 660;
  public static int maxChannelValue = 587;
  private DataFlycSetJoyStickParams flycSetJoyStickParams = new DataFlycSetJoyStickParams(false);
  private Handler handler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  private Timer joystickTimer = null;
  private DataFlycSetJoyStickParams.FlycMode mode = DataFlycSetJoyStickParams.FlycMode.P;
  private int pitch = 1024;
  private int roll = 1024;
  private int sendInterval = 100;
  private boolean showReachMaxDownThrottle = false;
  private int throttle = 1024;
  private int yaw = 1024;
  
  private JoystickBaseController()
  {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  public static JoystickBaseController getInstance()
  {
    try
    {
      JoystickBaseController localJoystickBaseController = SingletonHolder.joystickBaseController;
      return localJoystickBaseController;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  private void startTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopTimer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getMaxChannelVal()
  {
    return maxChannelValue;
  }
  
  public void init()
  {
    startTimer();
  }
  
  public boolean isConnected()
  {
    return this.joystickTimer != null;
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataCameraEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void restoreTimeInterval()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setMaxChannelVal(int paramInt)
  {
    maxChannelValue = paramInt;
  }
  
  public void setMode(DataFlycSetJoyStickParams.FlycMode paramFlycMode)
  {
    this.mode = paramFlycMode;
  }
  
  /* Error */
  public void setPitch(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRoll(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setThrottle(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setTimeInterval(int paramInt)
  {
    this.sendInterval = paramInt;
    stopTimer();
    startTimer();
  }
  
  /* Error */
  public void setYaw(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void touchLeftJoystick(int paramInt1, int paramInt2)
  {
    setThrottle(paramInt1);
    setYaw(paramInt2);
  }
  
  public void touchRightJoystick(int paramInt1, int paramInt2)
  {
    setPitch(paramInt1);
    setRoll(paramInt2);
  }
  
  private static class SingletonHolder
  {
    private static JoystickBaseController joystickBaseController = new JoystickBaseController(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\virtualjoystick\JoystickBaseController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */