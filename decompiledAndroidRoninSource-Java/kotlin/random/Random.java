package kotlin.random;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\013\n\000\n\002\020\022\n\002\b\005\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\002\n\002\020\t\n\002\b\003\b'\030\000 \0302\0020\001:\002\027\030B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\004H&J\b\020\006\032\0020\007H\026J\020\020\b\032\0020\t2\006\020\n\032\0020\tH\026J$\020\b\032\0020\t2\006\020\n\032\0020\t2\b\b\002\020\013\032\0020\0042\b\b\002\020\f\032\0020\004H\026J\020\020\b\032\0020\t2\006\020\r\032\0020\004H\026J\b\020\016\032\0020\017H\026J\020\020\016\032\0020\0172\006\020\020\032\0020\017H\026J\030\020\016\032\0020\0172\006\020\021\032\0020\0172\006\020\020\032\0020\017H\026J\b\020\022\032\0020\023H\026J\b\020\024\032\0020\004H\026J\020\020\024\032\0020\0042\006\020\020\032\0020\004H\026J\030\020\024\032\0020\0042\006\020\021\032\0020\0042\006\020\020\032\0020\004H\026J\b\020\025\032\0020\026H\026J\020\020\025\032\0020\0262\006\020\020\032\0020\026H\026J\030\020\025\032\0020\0262\006\020\021\032\0020\0262\006\020\020\032\0020\026H\026¨\006\031"}, d2={"Lkotlin/random/Random;", "", "()V", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "Companion", "Default", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class Random
{
  public static final Companion Companion = Companion.INSTANCE;
  public static final Default Default = new Default(null);
  private static final Random defaultRandom = PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
  
  public abstract int nextBits(int paramInt);
  
  public boolean nextBoolean()
  {
    return nextBits(1) != 0;
  }
  
  public byte[] nextBytes(int paramInt)
  {
    return nextBytes(new byte[paramInt]);
  }
  
  public byte[] nextBytes(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return nextBytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public byte[] nextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    int i = paramArrayOfByte.length;
    int j = 0;
    int k = 1;
    if ((paramInt1 >= 0) && (i >= paramInt1))
    {
      i = paramArrayOfByte.length;
      if ((paramInt2 >= 0) && (i >= paramInt2))
      {
        i = 1;
        break label55;
      }
    }
    i = 0;
    label55:
    if (i != 0)
    {
      if (paramInt1 <= paramInt2) {
        i = k;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        k = (paramInt2 - paramInt1) / 4;
        i = 0;
        while (i < k)
        {
          int m = nextInt();
          paramArrayOfByte[paramInt1] = ((byte)m);
          paramArrayOfByte[(paramInt1 + 1)] = ((byte)(m >>> 8));
          paramArrayOfByte[(paramInt1 + 2)] = ((byte)(m >>> 16));
          paramArrayOfByte[(paramInt1 + 3)] = ((byte)(m >>> 24));
          paramInt1 += 4;
          i += 1;
        }
        i = paramInt2 - paramInt1;
        k = nextBits(i * 8);
        paramInt2 = j;
        while (paramInt2 < i)
        {
          paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k >>> paramInt2 * 8));
          paramInt2 += 1;
        }
        return paramArrayOfByte;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("fromIndex (");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(") must be not greater than toIndex (");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(").");
      throw ((Throwable)new IllegalArgumentException(paramArrayOfByte.toString().toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fromIndex (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") or toIndex (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") are out of range: 0..");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append('.');
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public double nextDouble()
  {
    return PlatformRandomKt.doubleFromParts(nextBits(26), nextBits(27));
  }
  
  public double nextDouble(double paramDouble)
  {
    return nextDouble(0.0D, paramDouble);
  }
  
  public double nextDouble(double paramDouble1, double paramDouble2)
  {
    RandomKt.checkRangeBounds(paramDouble1, paramDouble2);
    double d1 = paramDouble2 - paramDouble1;
    if (Double.isInfinite(d1))
    {
      boolean bool = Double.isInfinite(paramDouble1);
      int j = 1;
      int i;
      if ((!bool) && (!Double.isNaN(paramDouble1))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((!Double.isInfinite(paramDouble2)) && (!Double.isNaN(paramDouble2))) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          d1 = nextDouble();
          double d2 = 2;
          d1 *= (paramDouble2 / d2 - paramDouble1 / d2);
          paramDouble1 = paramDouble1 + d1 + d1;
          break label127;
        }
      }
    }
    paramDouble1 += nextDouble() * d1;
    label127:
    d1 = paramDouble1;
    if (paramDouble1 >= paramDouble2) {
      d1 = Math.nextAfter(paramDouble2, DoubleCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
    }
    return d1;
  }
  
  public float nextFloat()
  {
    return nextBits(24) / 16777216;
  }
  
  public int nextInt()
  {
    return nextBits(32);
  }
  
  public int nextInt(int paramInt)
  {
    return nextInt(0, paramInt);
  }
  
  public int nextInt(int paramInt1, int paramInt2)
  {
    RandomKt.checkRangeBounds(paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if ((i <= 0) && (i != Integer.MIN_VALUE))
    {
      do
      {
        i = nextInt();
      } while ((paramInt1 > i) || (paramInt2 <= i));
      return i;
    }
    if ((-i & i) == i)
    {
      paramInt2 = nextBits(RandomKt.fastLog2(i));
    }
    else
    {
      int j;
      do
      {
        j = nextInt() >>> 1;
        paramInt2 = j % i;
      } while (j - paramInt2 + (i - 1) < 0);
    }
    return paramInt1 + paramInt2;
  }
  
  public long nextLong()
  {
    return (nextInt() << 32) + nextInt();
  }
  
  public long nextLong(long paramLong)
  {
    return nextLong(0L, paramLong);
  }
  
  public long nextLong(long paramLong1, long paramLong2)
  {
    RandomKt.checkRangeBounds(paramLong1, paramLong2);
    long l1 = paramLong2 - paramLong1;
    if (l1 > 0L)
    {
      if ((-l1 & l1) == l1)
      {
        int i = (int)l1;
        int j = (int)(l1 >>> 32);
        if (i != 0) {}
        for (i = nextBits(RandomKt.fastLog2(i));; i = nextInt())
        {
          paramLong2 = i & 0xFFFFFFFF;
          break label135;
          if (j != 1) {
            break;
          }
        }
        paramLong2 = (nextBits(RandomKt.fastLog2(j)) << 32) + nextInt();
      }
      else
      {
        long l2;
        do
        {
          l2 = nextLong() >>> 1;
          paramLong2 = l2 % l1;
        } while (l2 - paramLong2 + (l1 - 1L) < 0L);
      }
      label135:
      return paramLong1 + paramLong2;
    }
    do
    {
      l1 = nextLong();
    } while ((paramLong1 > l1) || (paramLong2 <= l1));
    return l1;
  }
  
  @Deprecated(level=DeprecationLevel.HIDDEN, message="Use Default companion object instead")
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\004H\026¨\006\006"}, d2={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
    extends Random
  {
    public static final Companion INSTANCE = new Companion();
    
    public int nextBits(int paramInt)
    {
      return Random.Default.nextBits(paramInt);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\002\n\002\020\013\n\000\n\002\020\022\n\002\b\005\n\002\020\006\n\002\b\003\n\002\020\007\n\002\b\002\n\002\020\t\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\007\032\0020\b2\006\020\t\032\0020\bH\026J\b\020\n\032\0020\013H\026J\020\020\f\032\0020\r2\006\020\016\032\0020\rH\026J \020\f\032\0020\r2\006\020\016\032\0020\r2\006\020\017\032\0020\b2\006\020\020\032\0020\bH\026J\020\020\f\032\0020\r2\006\020\021\032\0020\bH\026J\b\020\022\032\0020\023H\026J\020\020\022\032\0020\0232\006\020\024\032\0020\023H\026J\030\020\022\032\0020\0232\006\020\025\032\0020\0232\006\020\024\032\0020\023H\026J\b\020\026\032\0020\027H\026J\b\020\030\032\0020\bH\026J\020\020\030\032\0020\b2\006\020\024\032\0020\bH\026J\030\020\030\032\0020\b2\006\020\025\032\0020\b2\006\020\024\032\0020\bH\026J\b\020\031\032\0020\032H\026J\020\020\031\032\0020\0322\006\020\024\032\0020\032H\026J\030\020\031\032\0020\0322\006\020\025\032\0020\0322\006\020\024\032\0020\032H\026R\026\020\003\032\0020\0048\006X\004¢\006\b\n\000\022\004\b\005\020\002R\016\020\006\032\0020\001X\004¢\006\002\n\000¨\006\033"}, d2={"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "()V", "Companion", "Lkotlin/random/Random$Companion;", "Companion$annotations", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Default
    extends Random
  {
    public int nextBits(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextBits(paramInt);
    }
    
    public boolean nextBoolean()
    {
      return Random.access$getDefaultRandom$cp().nextBoolean();
    }
    
    public byte[] nextBytes(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextBytes(paramInt);
    }
    
    public byte[] nextBytes(byte[] paramArrayOfByte)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
      return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte);
    }
    
    public byte[] nextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
      return Random.access$getDefaultRandom$cp().nextBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public double nextDouble()
    {
      return Random.access$getDefaultRandom$cp().nextDouble();
    }
    
    public double nextDouble(double paramDouble)
    {
      return Random.access$getDefaultRandom$cp().nextDouble(paramDouble);
    }
    
    public double nextDouble(double paramDouble1, double paramDouble2)
    {
      return Random.access$getDefaultRandom$cp().nextDouble(paramDouble1, paramDouble2);
    }
    
    public float nextFloat()
    {
      return Random.access$getDefaultRandom$cp().nextFloat();
    }
    
    public int nextInt()
    {
      return Random.access$getDefaultRandom$cp().nextInt();
    }
    
    public int nextInt(int paramInt)
    {
      return Random.access$getDefaultRandom$cp().nextInt(paramInt);
    }
    
    public int nextInt(int paramInt1, int paramInt2)
    {
      return Random.access$getDefaultRandom$cp().nextInt(paramInt1, paramInt2);
    }
    
    public long nextLong()
    {
      return Random.access$getDefaultRandom$cp().nextLong();
    }
    
    public long nextLong(long paramLong)
    {
      return Random.access$getDefaultRandom$cp().nextLong(paramLong);
    }
    
    public long nextLong(long paramLong1, long paramLong2)
    {
      return Random.access$getDefaultRandom$cp().nextLong(paramLong1, paramLong2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\random\Random.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */