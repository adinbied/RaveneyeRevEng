package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class SingleInternalHelper
{
  private SingleInternalHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> Callable<NoSuchElementException> emptyThrower()
  {
    return NoSuchElementCallable.INSTANCE;
  }
  
  public static <T> Iterable<? extends Flowable<T>> iterableToFlowable(Iterable<? extends SingleSource<? extends T>> paramIterable)
  {
    return new ToFlowableIterable(paramIterable);
  }
  
  public static <T> Function<SingleSource<? extends T>, Publisher<? extends T>> toFlowable()
  {
    return ToFlowable.INSTANCE;
  }
  
  public static <T> Function<SingleSource<? extends T>, Observable<? extends T>> toObservable()
  {
    return ToObservable.INSTANCE;
  }
  
  static enum NoSuchElementCallable
    implements Callable<NoSuchElementException>
  {
    static
    {
      NoSuchElementCallable localNoSuchElementCallable = new NoSuchElementCallable("INSTANCE", 0);
      INSTANCE = localNoSuchElementCallable;
      $VALUES = new NoSuchElementCallable[] { localNoSuchElementCallable };
    }
    
    private NoSuchElementCallable() {}
    
    public NoSuchElementException call()
      throws Exception
    {
      return new NoSuchElementException();
    }
  }
  
  static enum ToFlowable
    implements Function<SingleSource, Publisher>
  {
    static
    {
      ToFlowable localToFlowable = new ToFlowable("INSTANCE", 0);
      INSTANCE = localToFlowable;
      $VALUES = new ToFlowable[] { localToFlowable };
    }
    
    private ToFlowable() {}
    
    public Publisher apply(SingleSource paramSingleSource)
    {
      return new SingleToFlowable(paramSingleSource);
    }
  }
  
  static final class ToFlowableIterable<T>
    implements Iterable<Flowable<T>>
  {
    private final Iterable<? extends SingleSource<? extends T>> sources;
    
    ToFlowableIterable(Iterable<? extends SingleSource<? extends T>> paramIterable)
    {
      this.sources = paramIterable;
    }
    
    public Iterator<Flowable<T>> iterator()
    {
      return null;
    }
  }
  
  static final class ToFlowableIterator<T>
    implements Iterator<Flowable<T>>
  {
    private final Iterator<? extends SingleSource<? extends T>> sit;
    
    ToFlowableIterator(Iterator<? extends SingleSource<? extends T>> paramIterator)
    {
      this.sit = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.sit.hasNext();
    }
    
    public Flowable<T> next()
    {
      return null;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static enum ToObservable
    implements Function<SingleSource, Observable>
  {
    static
    {
      ToObservable localToObservable = new ToObservable("INSTANCE", 0);
      INSTANCE = localToObservable;
      $VALUES = new ToObservable[] { localToObservable };
    }
    
    private ToObservable() {}
    
    public Observable apply(SingleSource paramSingleSource)
    {
      return new SingleToObservable(paramSingleSource);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\single\SingleInternalHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */