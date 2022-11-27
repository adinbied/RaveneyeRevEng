package com.dji.video.framing;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import java.util.concurrent.CountDownLatch;

public class MainTestActivity
  extends Activity
{
  private SurfaceView displayView;
  private CountDownLatch displayViewInitCdl;
  
  public SurfaceView getDisplayView()
  {
    return null;
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\MainTestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */