package dji.thirdparty.rx.plugins;

class RxJavaObservableExecutionHookDefault
  extends RxJavaObservableExecutionHook
{
  private static RxJavaObservableExecutionHookDefault INSTANCE = new RxJavaObservableExecutionHookDefault();
  
  public static RxJavaObservableExecutionHook getInstance()
  {
    return INSTANCE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaObservableExecutionHookDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */