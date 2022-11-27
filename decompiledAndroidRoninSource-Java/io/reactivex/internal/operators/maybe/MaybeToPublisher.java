package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

public enum MaybeToPublisher
  implements Function<MaybeSource<Object>, Publisher<Object>>
{
  static
  {
    MaybeToPublisher localMaybeToPublisher = new MaybeToPublisher("INSTANCE", 0);
    INSTANCE = localMaybeToPublisher;
    $VALUES = new MaybeToPublisher[] { localMaybeToPublisher };
  }
  
  private MaybeToPublisher() {}
  
  public static <T> Function<MaybeSource<T>, Publisher<T>> instance()
  {
    return INSTANCE;
  }
  
  public Publisher<Object> apply(MaybeSource<Object> paramMaybeSource)
    throws Exception
  {
    return new MaybeToFlowable(paramMaybeSource);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeToPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */