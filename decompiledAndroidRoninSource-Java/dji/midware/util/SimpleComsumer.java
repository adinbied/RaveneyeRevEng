package dji.midware.util;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleComsumer
  extends Thread
{
  private static final String TAG = "SimpleComsumer";
  private Callback callback;
  private BlockingQueue<Message> queue = new LinkedBlockingQueue();
  
  public SimpleComsumer(Callback paramCallback)
  {
    this.callback = paramCallback;
    start();
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void put(Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface Callback
  {
    public abstract void invoke(Message paramMessage);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\SimpleComsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */