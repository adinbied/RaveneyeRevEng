package in.srain.cube.views.ptr;

public abstract class PtrUIHandlerHook
  implements Runnable
{
  private static final byte STATUS_IN_HOOK = 1;
  private static final byte STATUS_PREPARE = 0;
  private static final byte STATUS_RESUMED = 2;
  private Runnable mResumeAction;
  private byte mStatus = 0;
  
  public void reset()
  {
    this.mStatus = 0;
  }
  
  /* Error */
  public void resume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setResumeAction(Runnable paramRunnable)
  {
    this.mResumeAction = paramRunnable;
  }
  
  public void takeOver()
  {
    takeOver(null);
  }
  
  /* Error */
  public void takeOver(Runnable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrUIHandlerHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */