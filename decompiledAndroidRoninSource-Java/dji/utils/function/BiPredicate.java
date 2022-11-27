package dji.utils.function;

@FunctionalInterface
public abstract interface BiPredicate<T, U>
{
  public abstract BiPredicate<T, U> and(BiPredicate<? super T, ? super U> paramBiPredicate);
  
  public abstract BiPredicate<T, U> negate();
  
  public abstract BiPredicate<T, U> or(BiPredicate<? super T, ? super U> paramBiPredicate);
  
  public abstract boolean test(T paramT, U paramU);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\BiPredicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */