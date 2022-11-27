package io.reactivex.disposables;

import io.reactivex.functions.Action;

final class ActionDisposable
  extends ReferenceDisposable<Action>
{
  private static final long serialVersionUID = -8219729196779211169L;
  
  ActionDisposable(Action paramAction)
  {
    super(paramAction);
  }
  
  protected void onDisposed(Action paramAction)
  {
    try
    {
      paramAction.run();
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\ActionDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */