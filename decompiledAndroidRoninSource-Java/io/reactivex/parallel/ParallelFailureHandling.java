package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

public enum ParallelFailureHandling
  implements BiFunction<Long, Throwable, ParallelFailureHandling>
{
  static
  {
    ERROR = new ParallelFailureHandling("ERROR", 1);
    SKIP = new ParallelFailureHandling("SKIP", 2);
    ParallelFailureHandling localParallelFailureHandling = new ParallelFailureHandling("RETRY", 3);
    RETRY = localParallelFailureHandling;
    $VALUES = new ParallelFailureHandling[] { STOP, ERROR, SKIP, localParallelFailureHandling };
  }
  
  private ParallelFailureHandling() {}
  
  public ParallelFailureHandling apply(Long paramLong, Throwable paramThrowable)
  {
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\parallel\ParallelFailureHandling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */