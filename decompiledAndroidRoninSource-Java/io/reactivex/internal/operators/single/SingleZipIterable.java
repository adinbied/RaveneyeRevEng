package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public final class SingleZipIterable<T, R>
  extends Single<R>
{
  final Iterable<? extends SingleSource<? extends T>> sources;
  final Function<? super Object[], ? extends R> zipper;
  
  public SingleZipIterable(Iterable<? extends SingleSource<? extends T>> paramIterable, Function<? super Object[], ? extends R> paramFunction)
  {
    this.sources = paramIterable;
    this.zipper = paramFunction;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.SingleObserver<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  final class SingletonArrayFunc
    implements Function<T, R>
  {
    SingletonArrayFunc() {}
    
    public R apply(T paramT)
      throws Exception
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleZipIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */