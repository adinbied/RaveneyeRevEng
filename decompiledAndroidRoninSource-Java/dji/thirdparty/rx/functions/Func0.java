package dji.thirdparty.rx.functions;

import java.util.concurrent.Callable;

public abstract interface Func0<R>
  extends Function, Callable<R>
{
  public abstract R call();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\functions\Func0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */