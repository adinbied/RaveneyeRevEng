package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ListCompositeDisposable
  implements Disposable, DisposableContainer
{
  volatile boolean disposed;
  List<Disposable> resources;
  
  public ListCompositeDisposable() {}
  
  public ListCompositeDisposable(Iterable<? extends Disposable> paramIterable)
  {
    ObjectHelper.requireNonNull(paramIterable, "resources is null");
    this.resources = new LinkedList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Disposable localDisposable = (Disposable)paramIterable.next();
      ObjectHelper.requireNonNull(localDisposable, "Disposable item is null");
      this.resources.add(localDisposable);
    }
  }
  
  public ListCompositeDisposable(Disposable... paramVarArgs)
  {
    ObjectHelper.requireNonNull(paramVarArgs, "resources is null");
    this.resources = new LinkedList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Disposable localDisposable = paramVarArgs[i];
      ObjectHelper.requireNonNull(localDisposable, "Disposable item is null");
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
  void dispose(List<Disposable> arg1)
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\ListCompositeDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */