package dji.thirdparty.rx.plugins;

class RxJavaSingleExecutionHookDefault
  extends RxJavaSingleExecutionHook
{
  private static final RxJavaSingleExecutionHookDefault INSTANCE = new RxJavaSingleExecutionHookDefault();
  
  public static RxJavaSingleExecutionHook getInstance()
  {
    return INSTANCE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaSingleExecutionHookDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */