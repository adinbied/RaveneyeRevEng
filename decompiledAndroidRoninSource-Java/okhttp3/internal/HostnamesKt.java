package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\000\n\002\020\013\n\000\n\002\020\016\n\000\n\002\020\b\n\002\b\002\n\002\020\022\n\002\b\002\n\002\030\002\n\002\b\004\0320\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0052\006\020\007\032\0020\b2\006\020\t\032\0020\005H\002\032\"\020\n\032\004\030\0010\0132\006\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\005H\002\032\020\020\f\032\0020\0032\006\020\007\032\0020\bH\002\032\f\020\r\032\0020\001*\0020\003H\002\032\f\020\016\032\004\030\0010\003*\0020\003¨\006\017"}, d2={"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k=2, mv={1, 1, 16})
public final class HostnamesKt
{
  private static final boolean containsInvalidHostnameAsciiCodes(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      char c = paramString.charAt(i);
      if (c > '\037')
      {
        if (c >= '') {
          return true;
        }
        if (StringsKt.indexOf$default((CharSequence)" #%/:?@[\\]", c, 0, false, 6, null) != -1) {
          return true;
        }
        i += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  private static final boolean decodeIpv4Suffix(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int j = paramInt3;
    int i = paramInt1;
    boolean bool;
    for (;;)
    {
      bool = false;
      if (i >= paramInt2) {
        break;
      }
      if (j == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i;
      if (j != paramInt3)
      {
        if (paramString.charAt(i) != '.') {
          return false;
        }
        paramInt1 = i + 1;
      }
      i = paramInt1;
      int k = 0;
      while (i < paramInt2)
      {
        int m = paramString.charAt(i);
        if ((m < 48) || (m > 57)) {
          break;
        }
        if ((k == 0) && (paramInt1 != i)) {
          return false;
        }
        k = k * 10 + m - 48;
        if (k > 255) {
          return false;
        }
        i += 1;
      }
      if (i - paramInt1 == 0) {
        return false;
      }
      paramArrayOfByte[j] = ((byte)k);
      j += 1;
    }
    if (j == paramInt3 + 4) {
      bool = true;
    }
    return bool;
  }
  
  private static final InetAddress decodeIpv6(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i = 0;
    int j = -1;
    int m = -1;
    int k = paramInt1;
    int n;
    for (;;)
    {
      paramInt1 = i;
      n = j;
      if (k >= paramInt2) {
        break label288;
      }
      if (i == 16) {
        return null;
      }
      n = k + 2;
      if ((n <= paramInt2) && (StringsKt.startsWith$default(paramString, "::", k, false, 4, null)))
      {
        if (j != -1) {
          return null;
        }
        paramInt1 = i + 2;
        if (n == paramInt2)
        {
          n = paramInt1;
          break label288;
        }
        k = n;
        j = paramInt1;
        i = paramInt1;
        paramInt1 = k;
      }
      else
      {
        paramInt1 = k;
        if (i != 0) {
          if (StringsKt.startsWith$default(paramString, ":", k, false, 4, null))
          {
            paramInt1 = k + 1;
          }
          else
          {
            if (StringsKt.startsWith$default(paramString, ".", k, false, 4, null))
            {
              if (!decodeIpv4Suffix(paramString, m, paramInt2, arrayOfByte, i - 2)) {
                return null;
              }
              paramInt1 = i + 2;
              n = j;
              break label288;
            }
            return null;
          }
        }
      }
      k = paramInt1;
      m = 0;
      while (k < paramInt2)
      {
        n = Util.parseHexDigit(paramString.charAt(k));
        if (n == -1) {
          break;
        }
        m = (m << 4) + n;
        k += 1;
      }
      n = k - paramInt1;
      if (n == 0) {
        break;
      }
      if (n > 4) {
        return null;
      }
      n = i + 1;
      arrayOfByte[i] = ((byte)(m >>> 8 & 0xFF));
      i = n + 1;
      arrayOfByte[n] = ((byte)(m & 0xFF));
      m = paramInt1;
    }
    return null;
    label288:
    if (paramInt1 != 16)
    {
      if (n == -1) {
        return null;
      }
      paramInt2 = paramInt1 - n;
      System.arraycopy(arrayOfByte, n, arrayOfByte, 16 - paramInt2, paramInt2);
      Arrays.fill(arrayOfByte, n, 16 - paramInt1 + n, (byte)0);
    }
    return InetAddress.getByAddress(arrayOfByte);
  }
  
  private static final String inet6AddressToAscii(byte[] paramArrayOfByte)
  {
    int i2 = 0;
    int k = -1;
    int i = 0;
    int m;
    int n;
    for (int j = 0; i < paramArrayOfByte.length; j = n)
    {
      m = i;
      while ((m < 16) && (paramArrayOfByte[m] == 0) && (paramArrayOfByte[(m + 1)] == 0)) {
        m += 2;
      }
      int i3 = m - i;
      int i1 = k;
      n = j;
      if (i3 > j)
      {
        i1 = k;
        n = j;
        if (i3 >= 4)
        {
          n = i3;
          i1 = i;
        }
      }
      i = m + 2;
      k = i1;
    }
    Buffer localBuffer = new Buffer();
    i = i2;
    while (i < paramArrayOfByte.length) {
      if (i == k)
      {
        localBuffer.writeByte(58);
        m = i + j;
        i = m;
        if (m == 16)
        {
          localBuffer.writeByte(58);
          i = m;
        }
      }
      else
      {
        if (i > 0) {
          localBuffer.writeByte(58);
        }
        localBuffer.writeHexadecimalUnsignedLong(Util.and(paramArrayOfByte[i], 255) << 8 | Util.and(paramArrayOfByte[(i + 1)], 255));
        i += 2;
      }
    }
    return localBuffer.readUtf8();
  }
  
  public static final String toCanonicalHost(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toCanonicalHost");
    Object localObject1 = (CharSequence)paramString;
    Object localObject2 = (CharSequence)":";
    int i = 0;
    if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)localObject2, false, 2, null))
    {
      if ((StringsKt.startsWith$default(paramString, "[", false, 2, null)) && (StringsKt.endsWith$default(paramString, "]", false, 2, null))) {
        localObject1 = decodeIpv6(paramString, 1, paramString.length() - 1);
      } else {
        localObject1 = decodeIpv6(paramString, 0, paramString.length());
      }
      if (localObject1 != null)
      {
        localObject2 = ((InetAddress)localObject1).getAddress();
        if (localObject2.length == 16)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "address");
          return inet6AddressToAscii((byte[])localObject2);
        }
        if (localObject2.length == 4) {
          return ((InetAddress)localObject1).getHostAddress();
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Invalid IPv6 address: '");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append('\'');
        throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
      }
      return null;
    }
    do
    {
      try
      {
        paramString = IDN.toASCII(paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "IDN.toASCII(host)");
        localObject1 = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "Locale.US");
        if (paramString != null)
        {
          paramString = paramString.toLowerCase((Locale)localObject1);
          Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).toLowerCase(locale)");
          if (((CharSequence)paramString).length() == 0)
          {
            i = 1;
            continue;
            if (!containsInvalidHostnameAsciiCodes(paramString)) {
              break;
            }
            return null;
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
    } while (i == 0);
    return null;
    return paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\HostnamesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */