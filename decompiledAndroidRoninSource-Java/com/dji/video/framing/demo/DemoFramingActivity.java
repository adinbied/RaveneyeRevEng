package com.dji.video.framing.demo;

import android.app.Activity;
import android.util.Log;
import com.dji.video.framing.internal.parser.IFrameParser;
import com.dji.video.framing.internal.parser.IFrameParser.OnFrameParserListener;
import com.dji.video.framing.utils.BytesUtil;
import java.io.InputStream;
import java.util.Locale;

public class DemoFramingActivity
  extends Activity
{
  private static final String TAG = "[DECODER_INPUT]";
  IFrameParser parser;
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract class MockDataRunnable
    implements Runnable
  {
    private boolean isStop = false;
    private InputStream sourceStream;
    
    public MockDataRunnable(InputStream paramInputStream)
    {
      this.sourceStream = paramInputStream;
    }
    
    public abstract void onDataComing(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract void onDestroy();
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void stop()
    {
      this.isStop = true;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\demo\DemoFramingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */