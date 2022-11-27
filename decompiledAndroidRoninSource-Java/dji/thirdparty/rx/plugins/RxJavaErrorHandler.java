package dji.thirdparty.rx.plugins;

public abstract class RxJavaErrorHandler
{
  protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";
  
  public void handleError(Throwable paramThrowable) {}
  
  public final String handleOnNextValueRendering(Object paramObject)
  {
    return null;
  }
  
  protected String render(Object paramObject)
    throws InterruptedException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\plugins\RxJavaErrorHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */