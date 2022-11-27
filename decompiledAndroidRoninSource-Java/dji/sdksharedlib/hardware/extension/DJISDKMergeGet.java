package dji.sdksharedlib.hardware.extension;

import android.os.Handler;
import android.os.Looper;
import dji.midware.util.BackgroundLooper;
import java.util.ArrayList;
import java.util.List;

public abstract class DJISDKMergeGet
{
  protected static final int MSG_ADD = 0;
  protected static final int MSG_EXCUTE = 1;
  private int DELAY_TIME = 200;
  private List<Object> commandList = new ArrayList();
  protected Handler handler = new Handler(BackgroundLooper.getLooper())
  {
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  /* Error */
  private void innerAdd(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void innerExecute()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void addCommand(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void execute(List<Object> paramList);
  
  protected long getDelayTime()
  {
    return this.DELAY_TIME;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKMergeGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */