package io.reactivex.internal.fuseable;

public abstract interface QueueFuseable<T>
  extends SimpleQueue<T>
{
  public static final int ANY = 3;
  public static final int ASYNC = 2;
  public static final int BOUNDARY = 4;
  public static final int NONE = 0;
  public static final int SYNC = 1;
  
  public abstract int requestFusion(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\QueueFuseable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */