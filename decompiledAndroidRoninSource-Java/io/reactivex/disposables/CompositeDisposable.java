package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.OpenHashSet;
import java.util.Iterator;

public final class CompositeDisposable
  implements Disposable, DisposableContainer
{
  volatile boolean disposed;
  OpenHashSet<Disposable> resources;
  
  public CompositeDisposable() {}
  
  public CompositeDisposable(Iterable<? extends Disposable> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "disposables is null");
    this.resources = new OpenHashSet();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Disposable localDisposable = (Disposable)paramIterable.next();
      ObjectHelper.requireNonNull(localDisposable, "A Disposable item in the disposables sequence is null");
      this.resources.add(localDisposable);
    }
  }
  
  public CompositeDisposable(Disposable... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "disposables is null");
    this.resources = new OpenHashSet(paramVarArgs.length + 1);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Disposable localDisposable = paramVarArgs[i];
      ObjectHelper.requireNonNull(localDisposable, "A Disposable in the disposables array is null");
      this.resources.add(localDisposable);
      i += 1;
    }
  }
  
  public boolean add(Disposable paramDisposable)
  {
    return false;
  }
  
  public boolean addAll(Disposable... paramVarArgs)
  {
    return false;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean delete(Disposable paramDisposable)
  {
    return false;
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void dispose(OpenHashSet<Disposable> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean isDisposed()
  {
    return this.disposed;
  }
  
  public boolean remove(Disposable paramDisposable)
  {
    return false;
  }
  
  public int size()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\disposables\CompositeDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */