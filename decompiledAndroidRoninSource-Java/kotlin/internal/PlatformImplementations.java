package kotlin.internal;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\020\003\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\b\020\030\0002\0020\001:\001\020B\005¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\006H\026J\b\020\b\032\0020\tH\026J\032\020\n\032\004\030\0010\0132\006\020\f\032\0020\r2\006\020\016\032\0020\017H\026¨\006\021"}, d2={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public class PlatformImplementations
{
  public void addSuppressed(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable1, "cause");
    Intrinsics.checkParameterIsNotNull(paramThrowable2, "exception");
    Method localMethod = ReflectAddSuppressedMethod.method;
    if (localMethod != null) {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
    }
  }
  
  public Random defaultPlatformRandom()
  {
    return (Random)new FallbackThreadLocalRandom();
  }
  
  public MatchGroup getMatchResultNamedGroup(MatchResult paramMatchResult, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMatchResult, "matchResult");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    throw ((Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform."));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\bÂ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\022\020\003\032\004\030\0010\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  private static final class ReflectAddSuppressedMethod
  {
    public static final ReflectAddSuppressedMethod INSTANCE = new ReflectAddSuppressedMethod();
    public static final Method method;
    
    static
    {
      Method[] arrayOfMethod = Throwable.class.getMethods();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfMethod, "throwableClass.methods");
      int k = arrayOfMethod.length;
      int i = 0;
      while (i < k)
      {
        localMethod = arrayOfMethod[i];
        Intrinsics.checkExpressionValueIsNotNull(localMethod, "it");
        if (Intrinsics.areEqual(localMethod.getName(), "addSuppressed"))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "it.parameterTypes");
          if (Intrinsics.areEqual((Class)ArraysKt.singleOrNull(arrayOfClass), Throwable.class))
          {
            j = 1;
            break label94;
          }
        }
        int j = 0;
        label94:
        if (j != 0) {
          break label110;
        }
        i += 1;
      }
      Method localMethod = null;
      label110:
      method = localMethod;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\internal\PlatformImplementations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */