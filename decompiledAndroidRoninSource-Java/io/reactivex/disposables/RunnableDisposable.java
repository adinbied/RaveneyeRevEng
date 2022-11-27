package io.reactivex.disposables;

final class RunnableDisposable
  extends ReferenceDisposable<Runnable>
{
  private static final long serialVersionUID = -8219729196779211169L;
  
  RunnableDisposable(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  protected void onDisposed(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\RunnableDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */