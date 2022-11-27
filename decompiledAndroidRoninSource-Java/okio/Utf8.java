package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000D\n\000\n\002\020\b\n\002\b\005\n\002\020\005\n\000\n\002\020\f\n\002\b\002\n\002\020\013\n\002\b\004\n\002\020\022\n\002\b\003\n\002\030\002\n\002\020\002\n\002\b\004\n\002\020\016\n\002\b\002\n\002\020\t\n\002\b\002\032\021\020\013\032\0020\f2\006\020\r\032\0020\001H\b\032\021\020\016\032\0020\f2\006\020\017\032\0020\007H\b\0321\020\020\032\0020\001*\0020\0212\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\001\022\004\022\0020\0260\025H\b\0321\020\027\032\0020\001*\0020\0212\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\001\022\004\022\0020\0260\025H\b\0321\020\030\032\0020\001*\0020\0212\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\001\022\004\022\0020\0260\025H\b\0321\020\031\032\0020\026*\0020\0212\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\t\022\004\022\0020\0260\025H\b\0321\020\032\032\0020\026*\0020\0332\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\007\022\004\022\0020\0260\025H\b\0321\020\034\032\0020\026*\0020\0212\006\020\022\032\0020\0012\006\020\023\032\0020\0012\022\020\024\032\016\022\004\022\0020\001\022\004\022\0020\0260\025H\b\032%\020\035\032\0020\036*\0020\0332\b\b\002\020\022\032\0020\0012\b\b\002\020\023\032\0020\001H\007¢\006\002\b\037\"\016\020\000\032\0020\001XT¢\006\002\n\000\"\016\020\002\032\0020\001XT¢\006\002\n\000\"\016\020\003\032\0020\001XT¢\006\002\n\000\"\016\020\004\032\0020\001XT¢\006\002\n\000\"\016\020\005\032\0020\001XT¢\006\002\n\000\"\016\020\006\032\0020\007XT¢\006\002\n\000\"\016\020\b\032\0020\tXT¢\006\002\n\000\"\016\020\n\032\0020\001XT¢\006\002\n\000¨\006 "}, d2={"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k=2, mv={1, 1, 16})
public final class Utf8
{
  public static final int HIGH_SURROGATE_HEADER = 55232;
  public static final int LOG_SURROGATE_HEADER = 56320;
  public static final int MASK_2BYTES = 3968;
  public static final int MASK_3BYTES = -123008;
  public static final int MASK_4BYTES = 3678080;
  public static final byte REPLACEMENT_BYTE = 63;
  public static final char REPLACEMENT_CHARACTER = '�';
  public static final int REPLACEMENT_CODE_POINT = 65533;
  
  public static final boolean isIsoControl(int paramInt)
  {
    return ((paramInt >= 0) && (31 >= paramInt)) || ((127 <= paramInt) && (159 >= paramInt));
  }
  
  public static final boolean isUtf8Continuation(byte paramByte)
  {
    return (paramByte & 0xC0) == 128;
  }
  
  public static final int process2Utf8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process2Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int i = paramInt1 + 1;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= i)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt2 = paramArrayOfByte[paramInt1];
    i = paramArrayOfByte[i];
    if ((i & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt1 = i ^ 0xF80 ^ paramInt2 << 6;
    if (paramInt1 < 128) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 2;
  }
  
  public static final int process3Utf8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process3Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int k = paramInt1 + 2;
    int i = 0;
    int j = 0;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= k)
    {
      paramFunction1.invoke(localInteger);
      i = paramInt1 + 1;
      if (paramInt2 > i)
      {
        paramInt1 = j;
        if ((paramArrayOfByte[i] & 0xC0) == 128) {
          paramInt1 = 1;
        }
        if (paramInt1 == 0) {
          return 1;
        }
        return 2;
      }
      return 1;
    }
    paramInt2 = paramArrayOfByte[paramInt1];
    j = paramArrayOfByte[(paramInt1 + 1)];
    if ((j & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    k = paramArrayOfByte[k];
    paramInt1 = i;
    if ((k & 0xC0) == 128) {
      paramInt1 = 1;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 2;
    }
    paramInt1 = k ^ 0xFFFE1F80 ^ j << 6 ^ paramInt2 << 12;
    if (paramInt1 < 2048) {
      paramFunction1.invoke(localInteger);
    } else if ((55296 <= paramInt1) && (57343 >= paramInt1)) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 3;
  }
  
  public static final int process4Utf8Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$process4Utf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    int m = paramInt1 + 3;
    int i = 0;
    int j = 0;
    Integer localInteger = Integer.valueOf(65533);
    if (paramInt2 <= m)
    {
      paramFunction1.invoke(localInteger);
      i = paramInt1 + 1;
      if (paramInt2 > i)
      {
        if ((paramArrayOfByte[i] & 0xC0) == 128) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {
          return 1;
        }
        i = paramInt1 + 2;
        if (paramInt2 > i)
        {
          paramInt1 = j;
          if ((paramArrayOfByte[i] & 0xC0) == 128) {
            paramInt1 = 1;
          }
          if (paramInt1 == 0) {
            return 2;
          }
          return 3;
        }
        return 2;
      }
      return 1;
    }
    j = paramArrayOfByte[paramInt1];
    int k = paramArrayOfByte[(paramInt1 + 1)];
    if ((k & 0xC0) == 128) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 1;
    }
    paramInt2 = paramArrayOfByte[(paramInt1 + 2)];
    if ((paramInt2 & 0xC0) == 128) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 2;
    }
    m = paramArrayOfByte[m];
    paramInt1 = i;
    if ((m & 0xC0) == 128) {
      paramInt1 = 1;
    }
    if (paramInt1 == 0)
    {
      paramFunction1.invoke(localInteger);
      return 3;
    }
    paramInt1 = m ^ 0x381F80 ^ paramInt2 << 6 ^ k << 12 ^ j << 18;
    if (paramInt1 > 1114111) {
      paramFunction1.invoke(localInteger);
    } else if ((55296 <= paramInt1) && (57343 >= paramInt1)) {
      paramFunction1.invoke(localInteger);
    } else if (paramInt1 < 65536) {
      paramFunction1.invoke(localInteger);
    } else {
      paramFunction1.invoke(Integer.valueOf(paramInt1));
    }
    return 4;
  }
  
  public static final void processUtf16Chars(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Function1<? super Character, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$processUtf16Chars");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    while (paramInt1 < paramInt2)
    {
      int i1 = paramArrayOfByte[paramInt1];
      if (i1 >= 0)
      {
        paramFunction1.invoke(Character.valueOf((char)i1));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramArrayOfByte[i] < 0) {
            break;
          }
          paramFunction1.invoke(Character.valueOf((char)paramArrayOfByte[i]));
          i += 1;
        }
      }
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      int i = 0;
      label136:
      char c;
      if (i1 >> 5 == -2)
      {
        k = paramInt1 + 1;
        if (paramInt2 <= k) {}
        do
        {
          paramFunction1.invoke(Character.valueOf((char)65533));
          i = 1;
          break;
          j = paramArrayOfByte[paramInt1];
          k = paramArrayOfByte[k];
          if ((k & 0xC0) == 128) {
            i = 1;
          }
        } while (i == 0);
        i = k ^ 0xF80 ^ j << 6;
        if (i < 128) {
          c = (char)65533;
        } else {
          c = (char)i;
        }
        paramFunction1.invoke(Character.valueOf(c));
        label223:
        i = 2;
      }
      for (;;)
      {
        label226:
        paramInt1 += i;
        break;
        if (i1 >> 4 == -2)
        {
          i1 = paramInt1 + 2;
          if (paramInt2 <= i1)
          {
            paramFunction1.invoke(Character.valueOf((char)65533));
            j = paramInt1 + 1;
            if (paramInt2 <= j) {
              break label136;
            }
            i = n;
            if ((paramArrayOfByte[j] & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              break label223;
            }
            break label136;
          }
          j = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[(paramInt1 + 1)];
          if ((m & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Character.valueOf((char)65533));
            break label136;
          }
          n = paramArrayOfByte[i1];
          i = k;
          if ((n & 0xC0) == 128) {
            i = 1;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Character.valueOf((char)65533));
            break label223;
          }
          i = n ^ 0xFFFE1F80 ^ m << 6 ^ j << 12;
          if (i < 2048) {}
          for (c = (char)65533;; c = (char)i)
          {
            paramFunction1.invoke(Character.valueOf(c));
            break label482;
            if ((55296 <= i) && (57343 >= i)) {
              break;
            }
          }
        }
        for (;;)
        {
          label482:
          i = 3;
          break label226;
          if (i1 >> 3 != -2) {
            break label877;
          }
          n = paramInt1 + 3;
          if (paramInt2 <= n)
          {
            paramFunction1.invoke(Character.valueOf(65533));
            i = paramInt1 + 1;
            if (paramInt2 <= i) {
              break;
            }
            if ((paramArrayOfByte[i] & 0xC0) == 128) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              break;
            }
            j = paramInt1 + 2;
            if (paramInt2 <= j) {
              break label223;
            }
            i = m;
            if ((paramArrayOfByte[j] & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              continue;
            }
            break label223;
          }
          k = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[(paramInt1 + 1)];
          if ((m & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Character.valueOf(65533));
            break;
          }
          i1 = paramArrayOfByte[(paramInt1 + 2)];
          if ((i1 & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Character.valueOf(65533));
            break label223;
          }
          n = paramArrayOfByte[n];
          i = j;
          if ((n & 0xC0) == 128) {
            i = 1;
          }
          if (i != 0) {
            break label748;
          }
          paramFunction1.invoke(Character.valueOf(65533));
        }
        label748:
        i = n ^ 0x381F80 ^ i1 << 6 ^ m << 12 ^ k << 18;
        if (i > 1114111) {}
        while (((55296 <= i) && (57343 >= i)) || (i < 65536) || (i == 65533))
        {
          paramFunction1.invoke(Character.valueOf(65533));
          break;
        }
        paramFunction1.invoke(Character.valueOf((char)((i >>> 10) + 55232)));
        paramFunction1.invoke(Character.valueOf((char)((i & 0x3FF) + 56320)));
        i = 4;
      }
      label877:
      paramFunction1.invoke(Character.valueOf(65533));
      paramInt1 += 1;
    }
  }
  
  public static final void processUtf8Bytes(String paramString, int paramInt1, int paramInt2, Function1<? super Byte, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$processUtf8Bytes");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    if (paramInt1 < paramInt2)
    {
      int i = paramString.charAt(paramInt1);
      if (i < 128)
      {
        paramFunction1.invoke(Byte.valueOf((byte)i));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramString.charAt(i) >= '') {
            break;
          }
          paramFunction1.invoke(Byte.valueOf((byte)paramString.charAt(i)));
          i += 1;
        }
      }
      if (i < 2048)
      {
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 | 0xC0)));
        paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((55296 <= i) && (57343 >= i))
        {
          if (i <= 56319)
          {
            int j = paramInt1 + 1;
            if (paramInt2 > j)
            {
              int k = paramString.charAt(j);
              if ((56320 <= k) && (57343 >= k))
              {
                i = (i << 10) + paramString.charAt(j) - 56613888;
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 18 | 0xF0)));
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 12 & 0x3F | 0x80)));
                paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 & 0x3F | 0x80)));
                paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
                paramInt1 += 2;
                break;
              }
            }
          }
          paramFunction1.invoke(Byte.valueOf((byte)63));
          continue;
        }
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 12 | 0xE0)));
        paramFunction1.invoke(Byte.valueOf((byte)(i >> 6 & 0x3F | 0x80)));
        paramFunction1.invoke(Byte.valueOf((byte)(i & 0x3F | 0x80)));
      }
    }
  }
  
  public static final void processUtf8CodePoints(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$processUtf8CodePoints");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "yield");
    while (paramInt1 < paramInt2)
    {
      int i1 = paramArrayOfByte[paramInt1];
      if (i1 >= 0)
      {
        paramFunction1.invoke(Integer.valueOf(i1));
        i = paramInt1 + 1;
        for (;;)
        {
          paramInt1 = i;
          if (i >= paramInt2) {
            break;
          }
          paramInt1 = i;
          if (paramArrayOfByte[i] < 0) {
            break;
          }
          paramFunction1.invoke(Integer.valueOf(paramArrayOfByte[i]));
          i += 1;
        }
      }
      int n = 0;
      int k = 0;
      int m = 0;
      int j = 0;
      int i = 0;
      label133:
      Integer localInteger;
      if (i1 >> 5 == -2)
      {
        k = paramInt1 + 1;
        if (paramInt2 <= k) {}
        do
        {
          paramFunction1.invoke(Integer.valueOf(65533));
          i = 1;
          break;
          j = paramArrayOfByte[paramInt1];
          k = paramArrayOfByte[k];
          if ((k & 0xC0) == 128) {
            i = 1;
          }
        } while (i == 0);
        i = k ^ 0xF80 ^ j << 6;
        if (i < 128) {
          localInteger = Integer.valueOf(65533);
        } else {
          localInteger = Integer.valueOf(i);
        }
        paramFunction1.invoke(localInteger);
        label221:
        i = 2;
      }
      for (;;)
      {
        label224:
        paramInt1 += i;
        break;
        if (i1 >> 4 == -2)
        {
          i1 = paramInt1 + 2;
          if (paramInt2 <= i1)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            j = paramInt1 + 1;
            if (paramInt2 <= j) {
              break label133;
            }
            i = n;
            if ((paramArrayOfByte[j] & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              break label221;
            }
            break label133;
          }
          j = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[(paramInt1 + 1)];
          if ((m & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            break label133;
          }
          n = paramArrayOfByte[i1];
          i = k;
          if ((n & 0xC0) == 128) {
            i = 1;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            break label221;
          }
          i = n ^ 0xFFFE1F80 ^ m << 6 ^ j << 12;
          if (i < 2048) {}
          for (localInteger = Integer.valueOf(65533);; localInteger = Integer.valueOf(i))
          {
            paramFunction1.invoke(localInteger);
            break label478;
            if ((55296 <= i) && (57343 >= i)) {
              break;
            }
          }
        }
        for (;;)
        {
          label478:
          i = 3;
          break label224;
          if (i1 >> 3 != -2) {
            break label841;
          }
          n = paramInt1 + 3;
          if (paramInt2 <= n)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            i = paramInt1 + 1;
            if (paramInt2 <= i) {
              break;
            }
            if ((paramArrayOfByte[i] & 0xC0) == 128) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              break;
            }
            j = paramInt1 + 2;
            if (paramInt2 <= j) {
              break label221;
            }
            i = m;
            if ((paramArrayOfByte[j] & 0xC0) == 128) {
              i = 1;
            }
            if (i != 0) {
              continue;
            }
            break label221;
          }
          k = paramArrayOfByte[paramInt1];
          m = paramArrayOfByte[(paramInt1 + 1)];
          if ((m & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            break;
          }
          i1 = paramArrayOfByte[(paramInt1 + 2)];
          if ((i1 & 0xC0) == 128) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramFunction1.invoke(Integer.valueOf(65533));
            break label221;
          }
          n = paramArrayOfByte[n];
          i = j;
          if ((n & 0xC0) == 128) {
            i = 1;
          }
          if (i != 0) {
            break label744;
          }
          paramFunction1.invoke(Integer.valueOf(65533));
        }
        label744:
        i = n ^ 0x381F80 ^ i1 << 6 ^ m << 12 ^ k << 18;
        if (i > 1114111) {}
        for (localInteger = Integer.valueOf(65533);; localInteger = Integer.valueOf(i))
        {
          paramFunction1.invoke(localInteger);
          break label835;
          if (((55296 <= i) && (57343 >= i)) || (i < 65536)) {
            break;
          }
        }
        label835:
        i = 4;
      }
      label841:
      paramFunction1.invoke(Integer.valueOf(65533));
      paramInt1 += 1;
    }
  }
  
  public static final long size(String paramString)
  {
    return size$default(paramString, 0, 0, 3, null);
  }
  
  public static final long size(String paramString, int paramInt)
  {
    return size$default(paramString, paramInt, 0, 2, null);
  }
  
  public static final long size(String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$utf8Size");
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 >= paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 <= paramString.length()) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          long l = 0L;
          while (paramInt1 < paramInt2)
          {
            int k = paramString.charAt(paramInt1);
            if (k < 128)
            {
              l += 1L;
              label89:
              paramInt1 += 1;
            }
            else
            {
              if (k < 2048) {}
              for (i = 2;; i = 3)
              {
                l += i;
                break label89;
                if ((k >= 55296) && (k <= 57343))
                {
                  j = paramInt1 + 1;
                  if (j < paramInt2) {
                    i = paramString.charAt(j);
                  } else {
                    i = 0;
                  }
                  if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                  {
                    l += 4;
                    paramInt1 += 2;
                    break;
                  }
                  l += 1L;
                  paramInt1 = j;
                  break;
                }
              }
            }
          }
          return l;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("endIndex > string.length: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" > ");
        localStringBuilder.append(paramString.length());
        throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
      }
      paramString = new StringBuilder();
      paramString.append("endIndex < beginIndex: ");
      paramString.append(paramInt2);
      paramString.append(" < ");
      paramString.append(paramInt1);
      throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
    }
    paramString = new StringBuilder();
    paramString.append("beginIndex < 0: ");
    paramString.append(paramInt1);
    throw ((Throwable)new IllegalArgumentException(paramString.toString().toString()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Utf8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */