package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable
  extends AtomicReferenceArray<Disposable>
  implements Disposable
{
  private static final long serialVersionUID = 2746389416410565408L;
  
  public ArrayCompositeDisposable(int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  public void dispose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isDisposed()
  {
    return false;
  }
  
  public Disposable replaceResource(int paramInt, Disposable paramDisposable)
  {
    return null;
  }
  
  public boolean setResource(int paramInt, Disposable paramDisposable)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\disposables\ArrayCompositeDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */