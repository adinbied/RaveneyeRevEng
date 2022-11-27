package dji.utils;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import androidx.core.app.ActivityCompat;

public class CommonUtils
{
  private static final int MIN_DELAY_TIME = 680;
  private static long lastClickTime;
  
  public static boolean isFastClick()
  {
    long l = System.currentTimeMillis();
    boolean bool;
    if (l - lastClickTime >= 680L) {
      bool = false;
    } else {
      bool = true;
    }
    lastClickTime = l;
    return bool;
  }
  
  public static final boolean isLocationEnable(Context paramContext)
  {
    paramContext = (LocationManager)paramContext.getSystemService("location");
    boolean bool1 = paramContext.isProviderEnabled("network");
    boolean bool2 = paramContext.isProviderEnabled("gps");
    return (bool1) || (bool2);
  }
  
  public static boolean isPermisionDenied(Context paramContext, String paramString)
  {
    int i = ActivityCompat.checkSelfPermission(paramContext, paramString);
    return (Build.VERSION.SDK_INT >= 23) && (i != 0);
  }
  
  public static void setLongClick(Handler paramHandler, final View paramView, final long paramLong, View.OnLongClickListener paramOnLongClickListener)
  {
    paramView.setOnTouchListener(new View.OnTouchListener()
    {
      private int TOUCH_MAX = 50;
      private int mLastMotionX;
      private int mLastMotionY;
      private Runnable r = new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      };
      
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */