package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange
  extends Observable<Integer>
{
  private final long end;
  private final int start;
  
  public ObservableRange(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = (paramInt1 + paramInt2);
  }
  
  /* Error */
  protected void subscribeActual(Observer<? super Integer> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class RangeDisposable
    extends BasicIntQueueDisposable<Integer>
  {
    private static final long serialVersionUID = 396518478098735504L;
    final Observer<? super Integer> downstream;
    final long end;
    boolean fused;
    long index;
    
    RangeDisposable(Observer<? super Integer> paramObserver, long paramLong1, long paramLong2)
    {
      this.downstream = paramObserver;
      this.index = paramLong1;
      this.end = paramLong2;
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void dispose()
    {
      set(1);
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Integer poll()
      throws Exception
    {
      return null;
    }
    
    public int requestFusion(int paramInt)
    {
      return 0;
    }
    
    /* Error */
    void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */