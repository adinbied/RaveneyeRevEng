package dji.thirdparty.rx.singles;

import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.SingleSubscriber;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class BlockingSingle<T>
{
  private final Single<? extends T> single;
  
  private BlockingSingle(Single<? extends T> paramSingle)
  {
    this.single = paramSingle;
  }
  
  public static <T> BlockingSingle<T> from(Single<? extends T> paramSingle)
  {
    return new BlockingSingle(paramSingle);
  }
  
  public Future<T> toFuture()
  {
    return null;
  }
  
  public T value()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\singles\BlockingSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */