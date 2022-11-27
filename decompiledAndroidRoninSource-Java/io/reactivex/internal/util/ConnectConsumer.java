package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class ConnectConsumer
  implements Consumer<Disposable>
{
  public Disposable disposable;
  
  public void accept(Disposable paramDisposable)
    throws Exception
  {
    this.disposable = paramDisposable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\ConnectConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */