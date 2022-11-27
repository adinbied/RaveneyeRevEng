package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class SetBuilder<T>
{
  private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
  private final List<T> contributions;
  
  private SetBuilder(int paramInt)
  {
    this.contributions = new ArrayList(paramInt);
  }
  
  public static <T> SetBuilder<T> newSetBuilder(int paramInt)
  {
    return new SetBuilder(paramInt);
  }
  
  public SetBuilder<T> add(T paramT)
  {
    return null;
  }
  
  public SetBuilder<T> addAll(Collection<? extends T> paramCollection)
  {
    return null;
  }
  
  public Set<T> build()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\SetBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */