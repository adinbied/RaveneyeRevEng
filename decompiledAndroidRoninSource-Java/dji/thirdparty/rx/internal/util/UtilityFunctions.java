package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.functions.Func3;
import dji.thirdparty.rx.functions.Func4;
import dji.thirdparty.rx.functions.Func5;
import dji.thirdparty.rx.functions.Func6;
import dji.thirdparty.rx.functions.Func7;
import dji.thirdparty.rx.functions.Func8;
import dji.thirdparty.rx.functions.Func9;
import dji.thirdparty.rx.functions.FuncN;

public final class UtilityFunctions
{
  private static final NullFunction NULL_FUNCTION = new NullFunction();
  
  public static <T> Func1<? super T, Boolean> alwaysFalse()
  {
    return AlwaysFalse.INSTANCE;
  }
  
  public static <T> Func1<? super T, Boolean> alwaysTrue()
  {
    return AlwaysTrue.INSTANCE;
  }
  
  public static <T> Func1<T, T> identity()
  {
    new Func1()
    {
      public T call(T paramAnonymousT)
      {
        return paramAnonymousT;
      }
    };
  }
  
  public static <T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> NullFunction<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R> returnNull()
  {
    return NULL_FUNCTION;
  }
  
  private static enum AlwaysFalse
    implements Func1<Object, Boolean>
  {
    static
    {
      AlwaysFalse localAlwaysFalse = new AlwaysFalse("INSTANCE", 0);
      INSTANCE = localAlwaysFalse;
      $VALUES = new AlwaysFalse[] { localAlwaysFalse };
    }
    
    private AlwaysFalse() {}
    
    public Boolean call(Object paramObject)
    {
      return Boolean.valueOf(false);
    }
  }
  
  private static enum AlwaysTrue
    implements Func1<Object, Boolean>
  {
    static
    {
      AlwaysTrue localAlwaysTrue = new AlwaysTrue("INSTANCE", 0);
      INSTANCE = localAlwaysTrue;
      $VALUES = new AlwaysTrue[] { localAlwaysTrue };
    }
    
    private AlwaysTrue() {}
    
    public Boolean call(Object paramObject)
    {
      return Boolean.valueOf(true);
    }
  }
  
  private static final class NullFunction<T0, T1, T2, T3, T4, T5, T6, T7, T8, T9, R>
    implements Func0<R>, Func1<T0, R>, Func2<T0, T1, R>, Func3<T0, T1, T2, R>, Func4<T0, T1, T2, T3, R>, Func5<T0, T1, T2, T3, T4, R>, Func6<T0, T1, T2, T3, T4, T5, R>, Func7<T0, T1, T2, T3, T4, T5, T6, R>, Func8<T0, T1, T2, T3, T4, T5, T6, T7, R>, Func9<T0, T1, T2, T3, T4, T5, T6, T7, T8, R>, FuncN<R>
  {
    public R call()
    {
      return null;
    }
    
    public R call(T0 paramT0)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, T6 paramT6)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, T6 paramT6, T7 paramT7)
    {
      return null;
    }
    
    public R call(T0 paramT0, T1 paramT1, T2 paramT2, T3 paramT3, T4 paramT4, T5 paramT5, T6 paramT6, T7 paramT7, T8 paramT8)
    {
      return null;
    }
    
    public R call(Object... paramVarArgs)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\UtilityFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */