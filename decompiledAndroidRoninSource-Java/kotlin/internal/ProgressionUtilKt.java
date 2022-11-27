package kotlin.internal;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\000\n\002\020\b\n\002\b\003\n\002\020\t\n\002\b\006\032 \020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\0012\006\020\004\032\0020\001H\002\032 \020\000\032\0020\0052\006\020\002\032\0020\0052\006\020\003\032\0020\0052\006\020\004\032\0020\005H\002\032 \020\006\032\0020\0012\006\020\007\032\0020\0012\006\020\b\032\0020\0012\006\020\t\032\0020\001H\001\032 \020\006\032\0020\0052\006\020\007\032\0020\0052\006\020\b\032\0020\0052\006\020\t\032\0020\005H\001\032\030\020\n\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\001H\002\032\030\020\n\032\0020\0052\006\020\002\032\0020\0052\006\020\003\032\0020\005H\002¨\006\013"}, d2={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ProgressionUtilKt
{
  private static final int differenceModulo(int paramInt1, int paramInt2, int paramInt3)
  {
    return mod(mod(paramInt1, paramInt3) - mod(paramInt2, paramInt3), paramInt3);
  }
  
  private static final long differenceModulo(long paramLong1, long paramLong2, long paramLong3)
  {
    return mod(mod(paramLong1, paramLong3) - mod(paramLong2, paramLong3), paramLong3);
  }
  
  public static final int getProgressionLastElement(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      if (paramInt1 >= paramInt2) {
        return paramInt2;
      }
      return paramInt2 - differenceModulo(paramInt2, paramInt1, paramInt3);
    }
    if (paramInt3 < 0)
    {
      if (paramInt1 <= paramInt2) {
        return paramInt2;
      }
      return paramInt2 + differenceModulo(paramInt1, paramInt2, -paramInt3);
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  public static final long getProgressionLastElement(long paramLong1, long paramLong2, long paramLong3)
  {
    boolean bool = paramLong3 < 0L;
    if (bool)
    {
      if (paramLong1 >= paramLong2) {
        return paramLong2;
      }
      return paramLong2 - differenceModulo(paramLong2, paramLong1, paramLong3);
    }
    if (bool)
    {
      if (paramLong1 <= paramLong2) {
        return paramLong2;
      }
      return paramLong2 + differenceModulo(paramLong1, paramLong2, -paramLong3);
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  private static final int mod(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
  
  private static final long mod(long paramLong1, long paramLong2)
  {
    paramLong1 %= paramLong2;
    if (paramLong1 >= 0L) {
      return paramLong1;
    }
    return paramLong1 + paramLong2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\internal\ProgressionUtilKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */