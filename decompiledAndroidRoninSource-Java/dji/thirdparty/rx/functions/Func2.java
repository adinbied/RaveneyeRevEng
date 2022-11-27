package dji.thirdparty.rx.functions;

public abstract interface Func2<T1, T2, R>
  extends Function
{
  public abstract R call(T1 paramT1, T2 paramT2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\functions\Func2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */