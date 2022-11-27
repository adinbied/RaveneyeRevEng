package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

final class ScalarXMapZHelper
{
  private ScalarXMapZHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  static <T> boolean tryAsCompletable(Object paramObject, Function<? super T, ? extends CompletableSource> paramFunction, CompletableObserver paramCompletableObserver)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (CompletableSource)ObjectHelper.requireNonNull(paramFunction.apply(localObject), "The mapper returned a null CompletableSource");
        }
        if (paramObject == null)
        {
          EmptyDisposable.complete(paramCompletableObserver);
          return true;
        }
        ((CompletableSource)paramObject).subscribe(paramCompletableObserver);
        return true;
      }
      finally
      {
        Exceptions.throwIfFatal((Throwable)paramObject);
        EmptyDisposable.error((Throwable)paramObject, paramCompletableObserver);
        return true;
      }
    }
    return false;
  }
  
  static <T, R> boolean tryAsMaybe(Object paramObject, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, Observer<? super R> paramObserver)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (MaybeSource)ObjectHelper.requireNonNull(paramFunction.apply(localObject), "The mapper returned a null MaybeSource");
        }
        if (paramObject == null)
        {
          EmptyDisposable.complete(paramObserver);
          return true;
        }
        ((MaybeSource)paramObject).subscribe(MaybeToObservable.create(paramObserver));
        return true;
      }
      finally
      {
        Exceptions.throwIfFatal((Throwable)paramObject);
        EmptyDisposable.error((Throwable)paramObject, paramObserver);
        return true;
      }
    }
    return false;
  }
  
  static <T, R> boolean tryAsSingle(Object paramObject, Function<? super T, ? extends SingleSource<? extends R>> paramFunction, Observer<? super R> paramObserver)
  {
    if ((paramObject instanceof Callable))
    {
      Object localObject = (Callable)paramObject;
      paramObject = null;
      try
      {
        localObject = ((Callable)localObject).call();
        if (localObject != null) {
          paramObject = (SingleSource)ObjectHelper.requireNonNull(paramFunction.apply(localObject), "The mapper returned a null SingleSource");
        }
        if (paramObject == null)
        {
          EmptyDisposable.complete(paramObserver);
          return true;
        }
        ((SingleSource)paramObject).subscribe(SingleToObservable.create(paramObserver));
        return true;
      }
      finally
      {
        Exceptions.throwIfFatal((Throwable)paramObject);
        EmptyDisposable.error((Throwable)paramObject, paramObserver);
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\mixed\ScalarXMapZHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */