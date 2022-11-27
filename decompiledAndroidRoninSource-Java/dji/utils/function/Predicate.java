package dji.utils.function;

@FunctionalInterface
public abstract interface Predicate<T>
{
  public abstract Predicate<T> and(Predicate<? super T> paramPredicate);
  
  public abstract Predicate<T> negate();
  
  public abstract Predicate<T> or(Predicate<? super T> paramPredicate);
  
  public abstract boolean test(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\function\Predicate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */