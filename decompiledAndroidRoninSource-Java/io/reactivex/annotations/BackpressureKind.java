package io.reactivex.annotations;

public enum BackpressureKind
{
  static
  {
    FULL = new BackpressureKind("FULL", 1);
    SPECIAL = new BackpressureKind("SPECIAL", 2);
    UNBOUNDED_IN = new BackpressureKind("UNBOUNDED_IN", 3);
    ERROR = new BackpressureKind("ERROR", 4);
    BackpressureKind localBackpressureKind = new BackpressureKind("NONE", 5);
    NONE = localBackpressureKind;
    $VALUES = new BackpressureKind[] { PASS_THROUGH, FULL, SPECIAL, UNBOUNDED_IN, ERROR, localBackpressureKind };
  }
  
  private BackpressureKind() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\annotations\BackpressureKind.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */