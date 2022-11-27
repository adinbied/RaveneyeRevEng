package dji.publics.DJIObject;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Window;
import com.dji.frame.util.V_AppUtils;
import dji.thirdparty.afinal.FinalActivity;

public class DJIBaseActivityForVirtualKey
  extends FinalActivity
{
  private Handler handler = new Handler(new Handler.Callback()
  {
    public boolean handleMessage(Message paramAnonymousMessage)
    {
      return false;
    }
  });
  protected boolean isVisible;
  protected Window window;
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void enter(Window paramWindow)
  {
    V_AppUtils.enter(paramWindow);
  }
  
  /* Error */
  public void onEventMainThread(com.dji.frame.util.V_AppUtils.DJI_SYS_UI_EVENT arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void onPause()
  {
    super.onPause();
    this.isVisible = false;
  }
  
  /* Error */
  protected void onResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.window = getWindow();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIObject\DJIBaseActivityForVirtualKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */