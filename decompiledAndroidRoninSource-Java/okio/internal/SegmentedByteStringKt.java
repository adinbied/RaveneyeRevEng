package okio.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.-Util;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;

@Metadata(bv={1, 0, 3}, d1={"\000R\n\000\n\002\020\b\n\002\020\025\n\002\b\004\n\002\020\013\n\002\030\002\n\000\n\002\020\000\n\002\b\003\n\002\020\005\n\002\b\003\n\002\020\022\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\004\032$\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\0012\006\020\004\032\0020\0012\006\020\005\032\0020\001H\000\032\027\020\006\032\0020\007*\0020\b2\b\020\t\032\004\030\0010\nH\b\032\r\020\013\032\0020\001*\0020\bH\b\032\r\020\f\032\0020\001*\0020\bH\b\032\025\020\r\032\0020\016*\0020\b2\006\020\017\032\0020\001H\b\032-\020\020\032\0020\007*\0020\b2\006\020\021\032\0020\0012\006\020\t\032\0020\0222\006\020\023\032\0020\0012\006\020\024\032\0020\001H\b\032-\020\020\032\0020\007*\0020\b2\006\020\021\032\0020\0012\006\020\t\032\0020\0252\006\020\023\032\0020\0012\006\020\024\032\0020\001H\b\032\035\020\026\032\0020\025*\0020\b2\006\020\027\032\0020\0012\006\020\030\032\0020\001H\b\032\r\020\031\032\0020\022*\0020\bH\b\032%\020\032\032\0020\033*\0020\b2\006\020\034\032\0020\0352\006\020\021\032\0020\0012\006\020\024\032\0020\001H\b\032Z\020\036\032\0020\033*\0020\b2K\020\037\032G\022\023\022\0210\022¢\006\f\b!\022\b\b\"\022\004\b\b(#\022\023\022\0210\001¢\006\f\b!\022\b\b\"\022\004\b\b(\021\022\023\022\0210\001¢\006\f\b!\022\b\b\"\022\004\b\b(\024\022\004\022\0020\0330 H\b\032j\020\036\032\0020\033*\0020\b2\006\020\027\032\0020\0012\006\020\030\032\0020\0012K\020\037\032G\022\023\022\0210\022¢\006\f\b!\022\b\b\"\022\004\b\b(#\022\023\022\0210\001¢\006\f\b!\022\b\b\"\022\004\b\b(\021\022\023\022\0210\001¢\006\f\b!\022\b\b\"\022\004\b\b(\024\022\004\022\0020\0330 H\b\032\024\020$\032\0020\001*\0020\b2\006\020\017\032\0020\001H\000¨\006%"}, d2={"binarySearch", "", "", "value", "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", "other", "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "offset", "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "data", "segment", "okio"}, k=2, mv={1, 1, 16})
public final class SegmentedByteStringKt
{
  public static final int binarySearch(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    paramInt3 -= 1;
    while (paramInt2 <= paramInt3)
    {
      int i = paramInt2 + paramInt3 >>> 1;
      int j = paramArrayOfInt[i];
      if (j < paramInt1) {
        paramInt2 = i + 1;
      } else if (j > paramInt1) {
        paramInt3 = i - 1;
      } else {
        return i;
      }
    }
    return -paramInt2 - 1;
  }
  
  public static final boolean commonEquals(SegmentedByteString paramSegmentedByteString, Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonEquals");
    if (paramObject == paramSegmentedByteString) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((((ByteString)paramObject).size() == paramSegmentedByteString.size()) && (paramSegmentedByteString.rangeEquals(0, (ByteString)paramObject, 0, paramSegmentedByteString.size()))) {
        return true;
      }
    }
    return false;
  }
  
  public static final int commonGetSize(SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonGetSize");
    return paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length - 1)];
  }
  
  public static final int commonHashCode(SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonHashCode");
    int i = paramSegmentedByteString.getHashCode$okio();
    if (i != 0) {
      return i;
    }
    int i2 = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int j = 0;
    int k = 0;
    int m = 1;
    while (j < i2)
    {
      int i1 = paramSegmentedByteString.getDirectory$okio()[(i2 + j)];
      int n = paramSegmentedByteString.getDirectory$okio()[j];
      byte[] arrayOfByte = paramSegmentedByteString.getSegments$okio()[j];
      i = i1;
      while (i < n - k + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      j += 1;
      k = n;
    }
    paramSegmentedByteString.setHashCode$okio(m);
    return m;
  }
  
  public static final byte commonInternalGet(SegmentedByteString paramSegmentedByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonInternalGet");
    -Util.checkOffsetAndCount(paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length - 1)], paramInt, 1L);
    int j = segment(paramSegmentedByteString, paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = paramSegmentedByteString.getDirectory$okio()[(j - 1)];
    }
    int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + j)];
    return paramSegmentedByteString.getSegments$okio()[j][(paramInt - i + k)];
  }
  
  public static final boolean commonRangeEquals(SegmentedByteString paramSegmentedByteString, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    if (paramInt1 >= 0)
    {
      if (paramInt1 > paramSegmentedByteString.size() - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = segment(paramSegmentedByteString, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
        }
        int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
        int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!paramByteString.rangeEquals(paramInt3, paramSegmentedByteString.getSegments$okio()[paramInt1], k + (paramInt2 - i), m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final boolean commonRangeEquals(SegmentedByteString paramSegmentedByteString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonRangeEquals");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    if ((paramInt1 >= 0) && (paramInt1 <= paramSegmentedByteString.size() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = paramInt3 + paramInt1;
      int i = segment(paramSegmentedByteString, paramInt1);
      paramInt3 = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      while (paramInt2 < j)
      {
        if (paramInt1 == 0) {
          i = 0;
        } else {
          i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
        }
        int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
        int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
        m = Math.min(j, m - i + i) - paramInt2;
        if (!-Util.arrayRangeEquals(paramSegmentedByteString.getSegments$okio()[paramInt1], k + (paramInt2 - i), paramArrayOfByte, paramInt3, m)) {
          return false;
        }
        paramInt3 += m;
        paramInt2 += m;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public static final ByteString commonSubstring(SegmentedByteString paramSegmentedByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonSubstring");
    int j = 0;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= paramSegmentedByteString.size()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        int m = paramInt2 - paramInt1;
        if (m >= 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == paramSegmentedByteString.size())) {
            return (ByteString)paramSegmentedByteString;
          }
          if (paramInt1 == paramInt2) {
            return ByteString.EMPTY;
          }
          int k = segment(paramSegmentedByteString, paramInt1);
          int n = segment(paramSegmentedByteString, paramInt2 - 1);
          localObject = (byte[][])ArraysKt.copyOfRange((Object[])paramSegmentedByteString.getSegments$okio(), k, n + 1);
          Object[] arrayOfObject = (Object[])localObject;
          int[] arrayOfInt = new int[arrayOfObject.length * 2];
          if (k <= n)
          {
            i = k;
            paramInt2 = 0;
            for (;;)
            {
              arrayOfInt[paramInt2] = Math.min(paramSegmentedByteString.getDirectory$okio()[i] - paramInt1, m);
              arrayOfInt[(paramInt2 + arrayOfObject.length)] = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + i)];
              if (i == n) {
                break;
              }
              i += 1;
              paramInt2 += 1;
            }
          }
          if (k == 0) {
            paramInt2 = j;
          } else {
            paramInt2 = paramSegmentedByteString.getDirectory$okio()[(k - 1)];
          }
          i = arrayOfObject.length;
          arrayOfInt[i] += paramInt1 - paramInt2;
          return (ByteString)new SegmentedByteString((byte[][])localObject, arrayOfInt);
        }
        paramSegmentedByteString = new StringBuilder();
        paramSegmentedByteString.append("endIndex=");
        paramSegmentedByteString.append(paramInt2);
        paramSegmentedByteString.append(" < beginIndex=");
        paramSegmentedByteString.append(paramInt1);
        throw ((Throwable)new IllegalArgumentException(paramSegmentedByteString.toString().toString()));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("endIndex=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" > length(");
      ((StringBuilder)localObject).append(paramSegmentedByteString.size());
      ((StringBuilder)localObject).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    paramSegmentedByteString = new StringBuilder();
    paramSegmentedByteString.append("beginIndex=");
    paramSegmentedByteString.append(paramInt1);
    paramSegmentedByteString.append(" < 0");
    throw ((Throwable)new IllegalArgumentException(paramSegmentedByteString.toString().toString()));
  }
  
  public static final byte[] commonToByteArray(SegmentedByteString paramSegmentedByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonToByteArray");
    byte[] arrayOfByte1 = new byte[paramSegmentedByteString.size()];
    int n = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < n)
    {
      int i1 = paramSegmentedByteString.getDirectory$okio()[(n + i)];
      int m = paramSegmentedByteString.getDirectory$okio()[i];
      byte[] arrayOfByte2 = paramSegmentedByteString.getSegments$okio()[i];
      k = m - k;
      ArraysKt.copyInto(arrayOfByte2, arrayOfByte1, j, i1, i1 + k);
      j += k;
      i += 1;
      k = m;
    }
    return arrayOfByte1;
  }
  
  public static final void commonWrite(SegmentedByteString paramSegmentedByteString, Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    int j = paramInt2 + paramInt1;
    int i = segment(paramSegmentedByteString, paramInt1);
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt2 < j)
    {
      if (paramInt1 == 0) {
        i = 0;
      } else {
        i = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
      }
      int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
      int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
      m = Math.min(j, m - i + i) - paramInt2;
      i = k + (paramInt2 - i);
      Segment localSegment1 = new Segment(paramSegmentedByteString.getSegments$okio()[paramInt1], i, i + m, true, false);
      if (paramBuffer.head == null)
      {
        localSegment1.prev = localSegment1;
        localSegment1.next = localSegment1.prev;
        paramBuffer.head = localSegment1.next;
      }
      else
      {
        Segment localSegment2 = paramBuffer.head;
        if (localSegment2 == null) {
          Intrinsics.throwNpe();
        }
        localSegment2 = localSegment2.prev;
        if (localSegment2 == null) {
          Intrinsics.throwNpe();
        }
        localSegment2.push(localSegment1);
      }
      paramInt2 += m;
      paramInt1 += 1;
    }
    paramBuffer.setSize$okio(paramBuffer.size() + paramSegmentedByteString.size());
  }
  
  private static final void forEachSegment(SegmentedByteString paramSegmentedByteString, int paramInt1, int paramInt2, Function3<? super byte[], ? super Integer, ? super Integer, Unit> paramFunction3)
  {
    int j = segment(paramSegmentedByteString, paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      if (paramInt1 == 0) {
        j = 0;
      } else {
        j = paramSegmentedByteString.getDirectory$okio()[(paramInt1 - 1)];
      }
      int m = paramSegmentedByteString.getDirectory$okio()[paramInt1];
      int k = paramSegmentedByteString.getDirectory$okio()[(((Object[])paramSegmentedByteString.getSegments$okio()).length + paramInt1)];
      m = Math.min(paramInt2, m - j + j) - i;
      paramFunction3.invoke(paramSegmentedByteString.getSegments$okio()[paramInt1], Integer.valueOf(k + (i - j)), Integer.valueOf(m));
      i += m;
      paramInt1 += 1;
    }
  }
  
  public static final void forEachSegment(SegmentedByteString paramSegmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$forEachSegment");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "action");
    int m = ((Object[])paramSegmentedByteString.getSegments$okio()).length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = paramSegmentedByteString.getDirectory$okio()[(m + i)];
      k = paramSegmentedByteString.getDirectory$okio()[i];
      paramFunction3.invoke(paramSegmentedByteString.getSegments$okio()[i], Integer.valueOf(n), Integer.valueOf(k - j));
      i += 1;
    }
  }
  
  public static final int segment(SegmentedByteString paramSegmentedByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSegmentedByteString, "$this$segment");
    paramInt = binarySearch(paramSegmentedByteString.getDirectory$okio(), paramInt + 1, 0, ((Object[])paramSegmentedByteString.getSegments$okio()).length);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\internal\SegmentedByteStringKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */