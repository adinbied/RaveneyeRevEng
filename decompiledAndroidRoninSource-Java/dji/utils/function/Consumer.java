package dji.utils.function;

@FunctionalInterface
public abstract interface Consumer<T>
{
  public abstract void accept(T paramT);
  
  public abstract Consumer<T> andThen(Consumer<? super T> paramConsumer);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\Consumer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */