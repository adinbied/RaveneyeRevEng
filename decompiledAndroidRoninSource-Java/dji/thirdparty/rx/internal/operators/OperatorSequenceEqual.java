package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual
{
  static final Object LOCAL_ONCOMPLETED = new Object();
  
  private OperatorSequenceEqual()
  {
    throw new IllegalStateException("No instances!");
  }
  
  static <T> Observable<Object> materializeLite(Observable<T> paramObservable)
  {
    Observable.concat(paramObservable.map(new Func1()
    {
      public Object call(T paramAnonymousT)
      {
        return paramAnonymousT;
      }
    }), Observable.just(LOCAL_ONCOMPLETED));
  }
  
  public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Func2<? super T, ? super T, Boolean> paramFunc2)
  {
    Observable.zip(materializeLite(paramObservable1), materializeLite(paramObservable2), new Func2()
    {
      public Boolean call(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        return null;
      }
    }).all(UtilityFunctions.identity());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSequenceEqual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */