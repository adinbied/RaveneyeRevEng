package dji.utils;

import dji.utils.function.Consumer;
import dji.utils.function.Function;
import dji.utils.function.Predicate;
import dji.utils.function.Supplier;
import java.util.Objects;

public final class Optional<T>
{
  private static final Optional<?> EMPTY = new Optional();
  private final T value;
  
  private Optional()
  {
    this.value = null;
  }
  
  private Optional(T paramT)
  {
    this.value = Objects.requireNonNull(paramT);
  }
  
  public static <T> Optional<T> empty()
  {
    return EMPTY;
  }
  
  public static <T> Optional<T> of(T paramT)
  {
    return new Optional(paramT);
  }
  
  public static <T> Optional<T> ofNullable(T paramT)
  {
    if (paramT == null) {
      return empty();
    }
    return of(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Optional<T> filter(Predicate<? super T> paramPredicate)
  {
    return null;
  }
  
  public <U> Optional<U> flatMap(Function<? super T, Optional<U>> paramFunction)
  {
    return null;
  }
  
  public T get()
  {
    return null;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(this.value);
  }
  
  public void ifPresent(Consumer<? super T> paramConsumer)
  {
    Object localObject = this.value;
    if (localObject != null) {
      paramConsumer.accept(localObject);
    }
  }
  
  public boolean isPresent()
  {
    return this.value != null;
  }
  
  public <U> Optional<U> map(Function<? super T, ? extends U> paramFunction)
  {
    return null;
  }
  
  public T orElse(T paramT)
  {
    Object localObject = this.value;
    if (localObject != null) {
      paramT = (T)localObject;
    }
    return paramT;
  }
  
  public T orElseGet(Supplier<? extends T> paramSupplier)
  {
    return null;
  }
  
  public <X extends Throwable> T orElseThrow(Supplier<? extends X> paramSupplier)
    throws Throwable
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\Optional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */