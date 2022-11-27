package io.flutter.view;

import android.view.Choreographer.FrameCallback;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate;

public class VsyncWaiter
{
  private static VsyncWaiter instance;
  private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate()
  {
    /* Error */
    public void asyncWaitForVsync(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  };
  private final WindowManager windowManager;
  
  private VsyncWaiter(WindowManager paramWindowManager)
  {
    this.windowManager = paramWindowManager;
  }
  
  public static VsyncWaiter getInstance(WindowManager paramWindowManager)
  {
    if (instance == null) {
      instance = new VsyncWaiter(paramWindowManager);
    }
    return instance;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\VsyncWaiter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */