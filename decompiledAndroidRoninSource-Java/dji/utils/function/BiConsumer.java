package dji.utils.function;

@FunctionalInterface
public abstract interface BiConsumer<T, U>
{
  public abstract void accept(T paramT, U paramU);
  
  public abstract BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> paramBiConsumer);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\BiConsumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */