package kotlin.random;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\r\b\000\030\0002\0020\001B\027\b\020\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005B7\b\000\022\006\020\006\032\0020\003\022\006\020\007\032\0020\003\022\006\020\b\032\0020\003\022\006\020\t\032\0020\003\022\006\020\n\032\0020\003\022\006\020\013\032\0020\003¢\006\002\020\fJ\020\020\r\032\0020\0032\006\020\016\032\0020\003H\026J\b\020\017\032\0020\003H\026R\016\020\013\032\0020\003X\016¢\006\002\n\000R\016\020\n\032\0020\003X\016¢\006\002\n\000R\016\020\t\032\0020\003X\016¢\006\002\n\000R\016\020\006\032\0020\003X\016¢\006\002\n\000R\016\020\007\032\0020\003X\016¢\006\002\n\000R\016\020\b\032\0020\003X\016¢\006\002\n\000¨\006\020"}, d2={"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class XorWowRandom
  extends Random
{
  private int addend;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public XorWowRandom(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 0, 0, paramInt1, paramInt1 << 10 ^ paramInt2 >>> 4);
  }
  
  public XorWowRandom(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.w = paramInt4;
    this.v = paramInt5;
    this.addend = paramInt6;
    paramInt6 = 0;
    if ((paramInt1 | paramInt2 | paramInt3 | paramInt4 | paramInt5) != 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      paramInt1 = paramInt6;
      while (paramInt1 < 64)
      {
        nextInt();
        paramInt1 += 1;
      }
      return;
    }
    throw ((Throwable)new IllegalArgumentException("Initial state must have at least one non-zero element.".toString()));
  }
  
  public int nextBits(int paramInt)
  {
    return RandomKt.takeUpperBits(nextInt(), paramInt);
  }
  
  public int nextInt()
  {
    int i = this.x;
    i ^= i >>> 2;
    this.x = this.y;
    this.y = this.z;
    this.z = this.w;
    int j = this.v;
    this.w = j;
    i = i ^ i << 1 ^ j ^ j << 4;
    this.v = i;
    j = this.addend + 362437;
    this.addend = j;
    return i + j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\XorWowRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */