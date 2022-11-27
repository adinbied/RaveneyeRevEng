package dji.midware.component.rc;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataCommonGetVersion;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.concurrent.CountDownLatch;

public class DM368GBlockRequest
{
  public final String TAG = "DM368GBlockRequest";
  private DataCommonGetVersion dm368_GGetter = null;
  private CountDownLatch latch = null;
  private boolean ret = false;
  
  public DataCommonGetVersion getDM368()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\component\rc\DM368GBlockRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */