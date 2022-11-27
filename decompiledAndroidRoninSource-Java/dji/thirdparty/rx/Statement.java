package dji.thirdparty.rx;

import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.operators.OperatorIfThen;
import dji.thirdparty.rx.operators.OperatorSwitchCase;
import dji.thirdparty.rx.operators.OperatorWhileDoWhile;
import java.util.Map;

public final class Statement
{
  private static final Func0True TRUE = new Func0True(null);
  
  private Statement()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Observable<T> doWhile(Observable<? extends T> paramObservable, Func0<Boolean> paramFunc0)
  {
    return Observable.create(new OperatorWhileDoWhile(paramObservable, TRUE, paramFunc0));
  }
  
  public static <R> Observable<R> ifThen(Func0<Boolean> paramFunc0, Observable<? extends R> paramObservable)
  {
    return ifThen(paramFunc0, paramObservable, Observable.empty());
  }
  
  public static <R> Observable<R> ifThen(Func0<Boolean> paramFunc0, Observable<? extends R> paramObservable1, Observable<? extends R> paramObservable2)
  {
    return Observable.create(new OperatorIfThen(paramFunc0, paramObservable1, paramObservable2));
  }
  
  public static <R> Observable<R> ifThen(Func0<Boolean> paramFunc0, Observable<? extends R> paramObservable, Scheduler paramScheduler)
  {
    return ifThen(paramFunc0, paramObservable, Observable.empty().subscribeOn(paramScheduler));
  }
  
  public static <K, R> Observable<R> switchCase(Func0<? extends K> paramFunc0, Map<? super K, ? extends Observable<? extends R>> paramMap)
  {
    return switchCase(paramFunc0, paramMap, Observable.empty());
  }
  
  public static <K, R> Observable<R> switchCase(Func0<? extends K> paramFunc0, Map<? super K, ? extends Observable<? extends R>> paramMap, Observable<? extends R> paramObservable)
  {
    return Observable.create(new OperatorSwitchCase(paramFunc0, paramMap, paramObservable));
  }
  
  public static <K, R> Observable<R> switchCase(Func0<? extends K> paramFunc0, Map<? super K, ? extends Observable<? extends R>> paramMap, Scheduler paramScheduler)
  {
    return switchCase(paramFunc0, paramMap, Observable.empty().subscribeOn(paramScheduler));
  }
  
  public static <T> Observable<T> whileDo(Observable<? extends T> paramObservable, Func0<Boolean> paramFunc0)
  {
    return Observable.create(new OperatorWhileDoWhile(paramObservable, paramFunc0, paramFunc0));
  }
  
  private static final class Func0True
    implements Func0<Boolean>
  {
    public Boolean call()
    {
      return Boolean.valueOf(true);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Statement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */