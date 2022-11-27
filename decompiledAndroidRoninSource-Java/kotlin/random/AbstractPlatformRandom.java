package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\013\n\000\n\002\020\022\n\002\b\002\n\002\020\006\n\000\n\002\020\007\n\002\b\003\n\002\020\t\n\000\b \030\0002\0020\001B\005¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\bH\026J\b\020\n\032\0020\013H\026J\020\020\f\032\0020\r2\006\020\016\032\0020\rH\026J\b\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\bH\026J\020\020\023\032\0020\b2\006\020\024\032\0020\bH\026J\b\020\025\032\0020\026H\026R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006\027"}, d2={"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "nextDouble", "", "nextFloat", "", "nextInt", "until", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class AbstractPlatformRandom
  extends Random
{
  public abstract java.util.Random getImpl();
  
  public int nextBits(int paramInt)
  {
    return RandomKt.takeUpperBits(getImpl().nextInt(), paramInt);
  }
  
  public boolean nextBoolean()
  {
    return getImpl().nextBoolean();
  }
  
  public byte[] nextBytes(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    getImpl().nextBytes(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public double nextDouble()
  {
    return getImpl().nextDouble();
  }
  
  public float nextFloat()
  {
    return getImpl().nextFloat();
  }
  
  public int nextInt()
  {
    return getImpl().nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return getImpl().nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return getImpl().nextLong();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\AbstractPlatformRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */