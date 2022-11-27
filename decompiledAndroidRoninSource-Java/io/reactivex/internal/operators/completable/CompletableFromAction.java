package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.functions.Action;

public final class CompletableFromAction
  extends Completable
{
  final Action run;
  
  public CompletableFromAction(Action paramAction)
  {
    this.run = paramAction;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.CompletableObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableFromAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */