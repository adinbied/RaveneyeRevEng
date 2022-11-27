package dji.thirdparty.rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;

public final class RxAndroidPlugins
{
  private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
  private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference();
  
  public static RxAndroidPlugins getInstance()
  {
    return INSTANCE;
  }
  
  public RxAndroidSchedulersHook getSchedulersHook()
  {
    return null;
  }
  
  /* Error */
  public void registerSchedulersHook(RxAndroidSchedulersHook arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void reset()
  {
    this.schedulersHook.set(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\android\plugins\RxAndroidPlugins.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */