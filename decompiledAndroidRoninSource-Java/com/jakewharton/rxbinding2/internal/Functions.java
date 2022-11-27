package com.jakewharton.rxbinding2.internal;

import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

public final class Functions
{
  private static final Always ALWAYS_TRUE;
  public static final Callable<Boolean> CALLABLE_ALWAYS_TRUE;
  public static final Predicate<Object> PREDICATE_ALWAYS_TRUE;
  
  static
  {
    Always localAlways = new Always(Boolean.valueOf(true));
    ALWAYS_TRUE = localAlways;
    CALLABLE_ALWAYS_TRUE = localAlways;
    PREDICATE_ALWAYS_TRUE = localAlways;
  }
  
  private Functions()
  {
    throw new AssertionError("No instances.");
  }
  
  private static final class Always
    implements Callable<Boolean>, Predicate<Object>
  {
    private final Boolean value;
    
    Always(Boolean paramBoolean)
    {
      this.value = paramBoolean;
    }
    
    public Boolean call()
    {
      return this.value;
    }
    
    public boolean test(Object paramObject)
    {
      return this.value.booleanValue();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\internal\Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */