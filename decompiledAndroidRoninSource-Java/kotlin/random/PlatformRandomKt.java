package kotlin.random;

import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\000\n\002\030\002\n\000\n\002\020\006\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\002\032\t\020\000\032\0020\001H\b\032\030\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\000\032\f\020\007\032\0020\b*\0020\001H\007\032\f\020\t\032\0020\001*\0020\bH\007¨\006\n"}, d2={"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class PlatformRandomKt
{
  public static final java.util.Random asJavaRandom(Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$asJavaRandom");
    if (!(paramRandom instanceof AbstractPlatformRandom)) {
      localObject = null;
    } else {
      localObject = paramRandom;
    }
    Object localObject = (AbstractPlatformRandom)localObject;
    if (localObject != null)
    {
      localObject = ((AbstractPlatformRandom)localObject).getImpl();
      if (localObject != null) {
        return (java.util.Random)localObject;
      }
    }
    return (java.util.Random)new KotlinRandom(paramRandom);
  }
  
  public static final Random asKotlinRandom(java.util.Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$asKotlinRandom");
    if (!(paramRandom instanceof KotlinRandom)) {
      localObject = null;
    } else {
      localObject = paramRandom;
    }
    Object localObject = (KotlinRandom)localObject;
    if (localObject != null)
    {
      localObject = ((KotlinRandom)localObject).getImpl();
      if (localObject != null) {
        return (Random)localObject;
      }
    }
    return (Random)new PlatformRandom(paramRandom);
  }
  
  private static final Random defaultPlatformRandom()
  {
    return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
  }
  
  public static final double doubleFromParts(int paramInt1, int paramInt2)
  {
    return ((paramInt1 << 27) + paramInt2) / 9007199254740992L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\PlatformRandomKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */