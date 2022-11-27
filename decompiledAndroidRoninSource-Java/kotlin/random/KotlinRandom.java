package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000B\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\b\n\002\b\003\n\002\020\002\n\000\n\002\020\022\n\000\n\002\020\006\n\000\n\002\020\007\n\002\b\003\n\002\020\t\n\002\b\003\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\t\032\0020\n2\006\020\013\032\0020\nH\024J\b\020\f\032\0020\bH\026J\020\020\r\032\0020\0162\006\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\024H\026J\b\020\025\032\0020\nH\026J\020\020\025\032\0020\n2\006\020\026\032\0020\nH\026J\b\020\027\032\0020\030H\026J\020\020\031\032\0020\0162\006\020\032\032\0020\030H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\016\020\007\032\0020\bX\016¢\006\002\n\000¨\006\033"}, d2={"Lkotlin/random/KotlinRandom;", "Ljava/util/Random;", "impl", "Lkotlin/random/Random;", "(Lkotlin/random/Random;)V", "getImpl", "()Lkotlin/random/Random;", "seedInitialized", "", "next", "", "bits", "nextBoolean", "nextBytes", "", "bytes", "", "nextDouble", "", "nextFloat", "", "nextInt", "bound", "nextLong", "", "setSeed", "seed", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class KotlinRandom
  extends java.util.Random
{
  private final Random impl;
  private boolean seedInitialized;
  
  public KotlinRandom(Random paramRandom)
  {
    this.impl = paramRandom;
  }
  
  public final Random getImpl()
  {
    return this.impl;
  }
  
  protected int next(int paramInt)
  {
    return this.impl.nextBits(paramInt);
  }
  
  public boolean nextBoolean()
  {
    return this.impl.nextBoolean();
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "bytes");
    this.impl.nextBytes(paramArrayOfByte);
  }
  
  public double nextDouble()
  {
    return this.impl.nextDouble();
  }
  
  public float nextFloat()
  {
    return this.impl.nextFloat();
  }
  
  public int nextInt()
  {
    return this.impl.nextInt();
  }
  
  public int nextInt(int paramInt)
  {
    return this.impl.nextInt(paramInt);
  }
  
  public long nextLong()
  {
    return this.impl.nextLong();
  }
  
  public void setSeed(long paramLong)
  {
    if (!this.seedInitialized)
    {
      this.seedInitialized = true;
      return;
    }
    throw ((Throwable)new UnsupportedOperationException("Setting seed is not supported."));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\KotlinRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */