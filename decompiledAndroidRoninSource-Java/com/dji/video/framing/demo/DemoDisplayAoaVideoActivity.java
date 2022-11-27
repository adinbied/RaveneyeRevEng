package com.dji.video.framing.demo;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.dji.video.framing.internal.VideoFrame;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.parser.VideoStreamParseController;
import com.dji.video.framing.internal.parser.VideoStreamParseController.FrameDataOutputCallback;

public class DemoDisplayAoaVideoActivity
  extends Activity
  implements CompoundButton.OnCheckedChangeListener
{
  private static final String TAG = "DemoDisplayAoaVideoActi";
  private static final float rate = 1.3333334F;
  private long createTime;
  private int lastMainHeight;
  private int lastMainWidth;
  private int lastSecondHeight;
  private int lastSecondWidth;
  private DJIVideoDecoder mainDecoder;
  private SurfaceView mainDisplaySv;
  private VideoStreamParseController mainParseController;
  private SurfaceInterface mainRenderManager;
  private DJIVideoDecoder secondDecoder;
  private SurfaceView secondDisplaySv;
  private ToggleButton secondDisplaySw;
  private VideoStreamParseController secondParseController;
  private SurfaceInterface secondRenderManager;
  
  /* Error */
  private void initDecoding()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void resizeSurfaceView(SurfaceView arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onCheckedChanged(android.widget.CompoundButton arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\demo\DemoDisplayAoaVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */