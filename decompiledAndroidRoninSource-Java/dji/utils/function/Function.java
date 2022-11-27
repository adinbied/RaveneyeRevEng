package dji.utils.function;

@FunctionalInterface
public abstract interface Function<T, R>
{
  public abstract <V> Function<T, V> andThen(Function<? super R, ? extends V> paramFunction);
  
  public abstract R apply(T paramT);
  
  public abstract <V> Function<V, R> compose(Function<? super V, ? extends T> paramFunction);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\Function.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */