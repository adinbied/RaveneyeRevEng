package kotlin.random;

import java.util.Random;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2={"Lkotlin/random/PlatformRandom;", "Lkotlin/random/AbstractPlatformRandom;", "impl", "Ljava/util/Random;", "(Ljava/util/Random;)V", "getImpl", "()Ljava/util/Random;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class PlatformRandom
  extends AbstractPlatformRandom
{
  private final Random impl;
  
  public PlatformRandom(Random paramRandom)
  {
    this.impl = paramRandom;
  }
  
  public Random getImpl()
  {
    return this.impl;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\PlatformRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */