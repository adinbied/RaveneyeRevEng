package dji.utils;

import android.os.Handler;
import android.os.Looper;

public class AssistUIHandler
{
  public static Handler handler = new Handler(Looper.getMainLooper());
  
  public static Handler get()
  {
    return handler;
  }
  
  public static void post(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\AssistUIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */