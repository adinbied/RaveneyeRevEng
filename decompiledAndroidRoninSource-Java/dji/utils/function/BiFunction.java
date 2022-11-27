package dji.utils.function;

@FunctionalInterface
public abstract interface BiFunction<T, U, R>
{
  public abstract <V> BiFunction<T, U, V> andThen(Function<? super R, ? extends V> paramFunction);
  
  public abstract R apply(T paramT, U paramU);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\BiFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */