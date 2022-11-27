package com.dji.video.framing.demo;

import android.app.Activity;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import com.dji.video.framing.internal.VideoFrame;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.parser.VideoStreamParseController;
import com.dji.video.framing.internal.parser.VideoStreamParseController.FrameDataOutputCallback;
import com.dji.video.framing.utils.VideoStreamFilePreviewer;
import java.io.File;

public class DemoDecodeDisplayActivity
  extends Activity
  implements CompoundButton.OnCheckedChangeListener
{
  private static final String TAG = "DemoDecodeDisplayActivi";
  private Switch dlogLutSw;
  private DJIVideoDecoder mainDecoder;
  private SurfaceView mainDisplaySv;
  private VideoStreamParseController mainParseController;
  private VideoStreamFilePreviewer mainPreviewer;
  private SurfaceInterface mainRenderManager;
  private File mainStreamSrc;
  private Switch overExpSw;
  private Switch peakingFocusSw;
  private DJIVideoDecoder secondDecoder;
  private SurfaceView secondDisplaySv;
  private Switch secondDisplaySw;
  private VideoStreamParseController secondParseController;
  private VideoStreamFilePreviewer secondPreviewer;
  private File secondStreamSrc;
  
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
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\demo\DemoDecodeDisplayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */