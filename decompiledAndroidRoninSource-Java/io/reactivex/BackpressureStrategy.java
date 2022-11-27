package io.reactivex;

public enum BackpressureStrategy
{
  static
  {
    ERROR = new BackpressureStrategy("ERROR", 1);
    BUFFER = new BackpressureStrategy("BUFFER", 2);
    DROP = new BackpressureStrategy("DROP", 3);
    BackpressureStrategy localBackpressureStrategy = new BackpressureStrategy("LATEST", 4);
    LATEST = localBackpressureStrategy;
    $VALUES = new BackpressureStrategy[] { MISSING, ERROR, BUFFER, DROP, localBackpressureStrategy };
  }
  
  private BackpressureStrategy() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\BackpressureStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */