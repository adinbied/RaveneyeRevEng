package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.functions.Action;
import java.util.concurrent.Callable;

public final class MaybeFromAction<T>
  extends Maybe<T>
  implements Callable<T>
{
  final Action action;
  
  public MaybeFromAction(Action paramAction)
  {
    this.action = paramAction;
  }
  
  public T call()
    throws Exception
  {
    this.action.run();
    return null;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */