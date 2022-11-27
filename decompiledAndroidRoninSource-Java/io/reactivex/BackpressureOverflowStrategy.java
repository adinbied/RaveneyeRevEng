package io.reactivex;

public enum BackpressureOverflowStrategy
{
  static
  {
    DROP_OLDEST = new BackpressureOverflowStrategy("DROP_OLDEST", 1);
    BackpressureOverflowStrategy localBackpressureOverflowStrategy = new BackpressureOverflowStrategy("DROP_LATEST", 2);
    DROP_LATEST = localBackpressureOverflowStrategy;
    $VALUES = new BackpressureOverflowStrategy[] { ERROR, DROP_OLDEST, localBackpressureOverflowStrategy };
  }
  
  private BackpressureOverflowStrategy() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\BackpressureOverflowStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */