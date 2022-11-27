package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ByteStringKt;

@Metadata(bv={1, 0, 3}, d1={"\000p\n\002\030\002\n\002\030\002\n\002\020\017\n\000\n\002\020\022\n\002\b\004\n\002\020\b\n\002\b\006\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\b\n\002\020\013\n\002\b\002\n\002\020\000\n\000\n\002\020\005\n\002\b\032\n\002\020\002\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\t\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\026\030\000 Z2\0020\0012\b\022\004\022\0020\0000\002:\001ZB\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\b\020\025\032\0020\026H\026J\b\020\027\032\0020\020H\026J\b\020\030\032\0020\020H\026J\021\020\031\032\0020\t2\006\020\032\032\0020\000H\002J\025\020\033\032\0020\0002\006\020\034\032\0020\020H\020¢\006\002\b\035J\016\020\036\032\0020\0372\006\020 \032\0020\004J\016\020\036\032\0020\0372\006\020 \032\0020\000J\023\020!\032\0020\0372\b\020\032\032\004\030\0010\"H\002J\026\020#\032\0020$2\006\020%\032\0020\tH\002¢\006\002\b&J\025\020&\032\0020$2\006\020%\032\0020\tH\007¢\006\002\b'J\r\020(\032\0020\tH\020¢\006\002\b)J\b\020\b\032\0020\tH\026J\b\020*\032\0020\020H\026J\035\020+\032\0020\0002\006\020\034\032\0020\0202\006\020,\032\0020\000H\020¢\006\002\b-J\020\020.\032\0020\0002\006\020,\032\0020\000H\026J\020\020/\032\0020\0002\006\020,\032\0020\000H\026J\020\0200\032\0020\0002\006\020,\032\0020\000H\026J\032\0201\032\0020\t2\006\020\032\032\0020\0042\b\b\002\0202\032\0020\tH\027J\032\0201\032\0020\t2\006\020\032\032\0020\0002\b\b\002\0202\032\0020\tH\007J\r\0203\032\0020\004H\020¢\006\002\b4J\025\0205\032\0020$2\006\0206\032\0020\tH\020¢\006\002\b7J\032\0208\032\0020\t2\006\020\032\032\0020\0042\b\b\002\0202\032\0020\tH\027J\032\0208\032\0020\t2\006\020\032\032\0020\0002\b\b\002\0202\032\0020\tH\007J\b\0209\032\0020\000H\026J(\020:\032\0020\0372\006\020;\032\0020\t2\006\020\032\032\0020\0042\006\020<\032\0020\t2\006\020=\032\0020\tH\026J(\020:\032\0020\0372\006\020;\032\0020\t2\006\020\032\032\0020\0002\006\020<\032\0020\t2\006\020=\032\0020\tH\026J\020\020>\032\0020?2\006\020@\032\0020AH\002J\b\020B\032\0020\000H\026J\b\020C\032\0020\000H\026J\b\020D\032\0020\000H\026J\r\020\016\032\0020\tH\007¢\006\002\bEJ\016\020F\032\0020\0372\006\020G\032\0020\004J\016\020F\032\0020\0372\006\020G\032\0020\000J\020\020H\032\0020\0202\006\020I\032\0020JH\026J\034\020K\032\0020\0002\b\b\002\020L\032\0020\t2\b\b\002\020M\032\0020\tH\027J\b\020N\032\0020\000H\026J\b\020O\032\0020\000H\026J\b\020P\032\0020\004H\026J\b\020Q\032\0020\020H\026J\b\020\017\032\0020\020H\026J\020\020R\032\0020?2\006\020S\032\0020TH\026J%\020R\032\0020?2\006\020U\032\0020V2\006\020;\032\0020\t2\006\020=\032\0020\tH\020¢\006\002\bWJ\020\020X\032\0020?2\006\020S\032\0020YH\002R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\006\020\007R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b\n\020\013\"\004\b\f\020\rR\021\020\016\032\0020\t8G¢\006\006\032\004\b\016\020\013R\034\020\017\032\004\030\0010\020X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024¨\006["}, d2={"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k=1, mv={1, 1, 16})
public class ByteString
  implements Serializable, Comparable<ByteString>
{
  public static final Companion Companion = new Companion(null);
  public static final ByteString EMPTY = new ByteString(new byte[0]);
  private static final long serialVersionUID = 1L;
  private final byte[] data;
  private transient int hashCode;
  private transient String utf8;
  
  public ByteString(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  @JvmStatic
  public static final ByteString decodeBase64(String paramString)
  {
    return Companion.decodeBase64(paramString);
  }
  
  @JvmStatic
  public static final ByteString decodeHex(String paramString)
  {
    return Companion.decodeHex(paramString);
  }
  
  @JvmStatic
  public static final ByteString encodeString(String paramString, Charset paramCharset)
  {
    return Companion.encodeString(paramString, paramCharset);
  }
  
  @JvmStatic
  public static final ByteString encodeUtf8(String paramString)
  {
    return Companion.encodeUtf8(paramString);
  }
  
  @JvmStatic
  public static final ByteString of(ByteBuffer paramByteBuffer)
  {
    return Companion.of(paramByteBuffer);
  }
  
  @JvmStatic
  public static final ByteString of(byte... paramVarArgs)
  {
    return Companion.of(paramVarArgs);
  }
  
  @JvmStatic
  public static final ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return Companion.of(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  @JvmStatic
  public static final ByteString read(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return Companion.read(paramInputStream, paramInt);
  }
  
  private final void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    int i = paramObjectInputStream.readInt();
    paramObjectInputStream = Companion.read((InputStream)paramObjectInputStream, i);
    Field localField = ByteString.class.getDeclaredField("data");
    Intrinsics.checkExpressionValueIsNotNull(localField, "field");
    localField.setAccessible(true);
    localField.set(this, paramObjectInputStream.data);
  }
  
  private final void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeInt(this.data.length);
    paramObjectOutputStream.write(this.data);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to operator function", replaceWith=@ReplaceWith(expression="this[index]", imports={}))
  public final byte -deprecated_getByte(int paramInt)
  {
    return getByte(paramInt);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
  public final int -deprecated_size()
  {
    return size();
  }
  
  public ByteBuffer asByteBuffer()
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
    return localByteBuffer;
  }
  
  public String base64()
  {
    return -Base64.encodeBase64$default(getData$okio(), null, 1, null);
  }
  
  public String base64Url()
  {
    return -Base64.encodeBase64(getData$okio(), -Base64.getBASE64_URL_SAFE());
  }
  
  public int compareTo(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    int j = size();
    int k = paramByteString.size();
    int m = Math.min(j, k);
    int i = 0;
    while (i < m)
    {
      int n = getByte(i) & 0xFF;
      int i1 = paramByteString.getByte(i) & 0xFF;
      if (n == i1)
      {
        i += 1;
      }
      else
      {
        if (n >= i1) {
          break label96;
        }
        break label94;
      }
    }
    if (j == k) {
      return 0;
    }
    if (j < k) {
      label94:
      return -1;
    }
    label96:
    return 1;
  }
  
  public ByteString digest$okio(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    paramString = MessageDigest.getInstance(paramString).digest(this.data);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MessageDigest.getInstance(algorithm).digest(data)");
    return new ByteString(paramString);
  }
  
  public final boolean endsWith(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "suffix");
    return rangeEquals(size() - paramByteString.size(), paramByteString, 0, paramByteString.size());
  }
  
  public final boolean endsWith(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "suffix");
    return rangeEquals(size() - paramArrayOfByte.length, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((((ByteString)paramObject).size() == getData$okio().length) && (((ByteString)paramObject).rangeEquals(0, getData$okio(), 0, getData$okio().length))) {
        return true;
      }
    }
    return false;
  }
  
  public final byte getByte(int paramInt)
  {
    return internalGet$okio(paramInt);
  }
  
  public final byte[] getData$okio()
  {
    return this.data;
  }
  
  public final int getHashCode$okio()
  {
    return this.hashCode;
  }
  
  public int getSize$okio()
  {
    return getData$okio().length;
  }
  
  public final String getUtf8$okio()
  {
    return this.utf8;
  }
  
  public int hashCode()
  {
    int i = getHashCode$okio();
    if (i != 0) {
      return i;
    }
    i = Arrays.hashCode(getData$okio());
    setHashCode$okio(i);
    return i;
  }
  
  public String hex()
  {
    char[] arrayOfChar = new char[getData$okio().length * 2];
    byte[] arrayOfByte = getData$okio();
    int k = arrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = arrayOfByte[i];
      int n = j + 1;
      arrayOfChar[j] = ByteStringKt.getHEX_DIGIT_CHARS()[(m >> 4 & 0xF)];
      j = n + 1;
      arrayOfChar[n] = ByteStringKt.getHEX_DIGIT_CHARS()[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public ByteString hmac$okio(String paramString, ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "algorithm");
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    try
    {
      Mac localMac = Mac.getInstance(paramString);
      localMac.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      paramString = localMac.doFinal(this.data);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "mac.doFinal(data)");
      paramString = new ByteString(paramString);
      return paramString;
    }
    catch (InvalidKeyException paramString)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramString));
    }
  }
  
  public ByteString hmacSha1(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA1", paramByteString);
  }
  
  public ByteString hmacSha256(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA256", paramByteString);
  }
  
  public ByteString hmacSha512(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "key");
    return hmac$okio("HmacSHA512", paramByteString);
  }
  
  public final int indexOf(ByteString paramByteString)
  {
    return indexOf$default(this, paramByteString, 0, 2, null);
  }
  
  public final int indexOf(ByteString paramByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return indexOf(paramByteString.internalArray$okio(), paramInt);
  }
  
  public int indexOf(byte[] paramArrayOfByte)
  {
    return indexOf$default(this, paramArrayOfByte, 0, 2, null);
  }
  
  public int indexOf(byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    int i = getData$okio().length - paramArrayOfByte.length;
    paramInt = Math.max(paramInt, 0);
    if (paramInt <= i) {
      for (;;)
      {
        if (-Util.arrayRangeEquals(getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
          return paramInt;
        }
        if (paramInt == i) {
          break;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public byte[] internalArray$okio()
  {
    return getData$okio();
  }
  
  public byte internalGet$okio(int paramInt)
  {
    return getData$okio()[paramInt];
  }
  
  public final int lastIndexOf(ByteString paramByteString)
  {
    return lastIndexOf$default(this, paramByteString, 0, 2, null);
  }
  
  public final int lastIndexOf(ByteString paramByteString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return lastIndexOf(paramByteString.internalArray$okio(), paramInt);
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte)
  {
    return lastIndexOf$default(this, paramArrayOfByte, 0, 2, null);
  }
  
  public int lastIndexOf(byte[] paramArrayOfByte, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    paramInt = Math.min(paramInt, getData$okio().length - paramArrayOfByte.length);
    while (paramInt >= 0)
    {
      if (-Util.arrayRangeEquals(getData$okio(), paramInt, paramArrayOfByte, 0, paramArrayOfByte.length)) {
        return paramInt;
      }
      paramInt -= 1;
    }
    return -1;
  }
  
  public ByteString md5()
  {
    return digest$okio("MD5");
  }
  
  public boolean rangeEquals(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "other");
    return paramByteString.rangeEquals(paramInt2, getData$okio(), paramInt1, paramInt3);
  }
  
  public boolean rangeEquals(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "other");
    return (paramInt1 >= 0) && (paramInt1 <= getData$okio().length - paramInt3) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt3) && (-Util.arrayRangeEquals(getData$okio(), paramInt1, paramArrayOfByte, paramInt2, paramInt3));
  }
  
  public final void setHashCode$okio(int paramInt)
  {
    this.hashCode = paramInt;
  }
  
  public final void setUtf8$okio(String paramString)
  {
    this.utf8 = paramString;
  }
  
  public ByteString sha1()
  {
    return digest$okio("SHA-1");
  }
  
  public ByteString sha256()
  {
    return digest$okio("SHA-256");
  }
  
  public ByteString sha512()
  {
    return digest$okio("SHA-512");
  }
  
  public final int size()
  {
    return getSize$okio();
  }
  
  public final boolean startsWith(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "prefix");
    return rangeEquals(0, paramByteString, 0, paramByteString.size());
  }
  
  public final boolean startsWith(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "prefix");
    return rangeEquals(0, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public String string(Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    return new String(this.data, paramCharset);
  }
  
  public ByteString substring()
  {
    return substring$default(this, 0, 0, 3, null);
  }
  
  public ByteString substring(int paramInt)
  {
    return substring$default(this, paramInt, 0, 2, null);
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if (paramInt1 >= 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramInt2 <= getData$okio().length) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramInt2 - paramInt1 >= 0) {
          i = j;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((paramInt1 == 0) && (paramInt2 == getData$okio().length)) {
            return this;
          }
          return new ByteString(ArraysKt.copyOfRange(getData$okio(), paramInt1, paramInt2));
        }
        throw ((Throwable)new IllegalArgumentException("endIndex < beginIndex".toString()));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endIndex > length(");
      localStringBuilder.append(getData$okio().length);
      localStringBuilder.append(')');
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
    }
    throw ((Throwable)new IllegalArgumentException("beginIndex < 0".toString()));
  }
  
  public ByteString toAsciiLowercase()
  {
    int i = 0;
    while (i < getData$okio().length)
    {
      int n = getData$okio()[i];
      int k = (byte)65;
      if (n >= k)
      {
        int m = (byte)90;
        if (n <= m)
        {
          byte[] arrayOfByte = getData$okio();
          arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
          Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          arrayOfByte[i] = ((byte)(n + 32));
          i = j;
          while (i < arrayOfByte.length)
          {
            j = arrayOfByte[i];
            if ((j >= k) && (j <= m)) {
              arrayOfByte[i] = ((byte)(j + 32));
            }
            i += 1;
          }
          return new ByteString(arrayOfByte);
        }
      }
      i += 1;
    }
    return this;
  }
  
  public ByteString toAsciiUppercase()
  {
    int i = 0;
    while (i < getData$okio().length)
    {
      int n = getData$okio()[i];
      int k = (byte)97;
      if (n >= k)
      {
        int m = (byte)122;
        if (n <= m)
        {
          byte[] arrayOfByte = getData$okio();
          arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
          Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
          int j = i + 1;
          arrayOfByte[i] = ((byte)(n - 32));
          i = j;
          while (i < arrayOfByte.length)
          {
            j = arrayOfByte[i];
            if ((j >= k) && (j <= m)) {
              arrayOfByte[i] = ((byte)(j - 32));
            }
            i += 1;
          }
          return new ByteString(arrayOfByte);
        }
      }
      i += 1;
    }
    return this;
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = getData$okio();
    arrayOfByte = Arrays.copyOf(arrayOfByte, arrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return arrayOfByte;
  }
  
  public String toString()
  {
    int i = getData$okio().length;
    int j = 1;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return "[size=0]";
    }
    i = ByteStringKt.access$codePointIndexToCharIndex(getData$okio(), 64);
    Object localObject1;
    if (i == -1)
    {
      if (getData$okio().length <= 64)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[hex=");
        ((StringBuilder)localObject1).append(hex());
        ((StringBuilder)localObject1).append(']');
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[size=");
      ((StringBuilder)localObject2).append(getData$okio().length);
      ((StringBuilder)localObject2).append(" hex=");
      if (64 <= getData$okio().length) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (64 == getData$okio().length) {
          localObject1 = this;
        } else {
          localObject1 = new ByteString(ArraysKt.copyOfRange(getData$okio(), 0, 64));
        }
        ((StringBuilder)localObject2).append(((ByteString)localObject1).hex());
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("endIndex > length(");
      ((StringBuilder)localObject1).append(getData$okio().length);
      ((StringBuilder)localObject1).append(')');
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject1).toString().toString()));
    }
    Object localObject2 = utf8();
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String)localObject1, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
      if (i < ((String)localObject2).length())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[size=");
        ((StringBuilder)localObject2).append(getData$okio().length);
        ((StringBuilder)localObject2).append(" text=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("…]");
        return ((StringBuilder)localObject2).toString();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[text=");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(']');
      return ((StringBuilder)localObject2).toString();
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public String utf8()
  {
    String str2 = getUtf8$okio();
    String str1 = str2;
    if (str2 == null)
    {
      str1 = -Platform.toUtf8String(internalArray$okio());
      setUtf8$okio(str1);
    }
    return str1;
  }
  
  public void write(OutputStream paramOutputStream)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "out");
    paramOutputStream.write(this.data);
  }
  
  public void write$okio(Buffer paramBuffer, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "buffer");
    ByteStringKt.commonWrite(this, paramBuffer, paramInt1, paramInt2);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000N\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\002\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\020\022\n\002\020\005\n\002\b\002\n\002\020\b\n\002\b\003\n\002\030\002\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\027\020\007\032\004\030\0010\0042\006\020\b\032\0020\tH\007¢\006\002\b\nJ\025\020\013\032\0020\0042\006\020\b\032\0020\tH\007¢\006\002\b\fJ\035\020\r\032\0020\0042\006\020\b\032\0020\t2\006\020\016\032\0020\017H\007¢\006\002\b\020J\025\020\021\032\0020\0042\006\020\b\032\0020\tH\007¢\006\002\b\022J\025\020\023\032\0020\0042\006\020\024\032\0020\025H\007¢\006\002\b\026J\024\020\023\032\0020\0042\n\020\027\032\0020\030\"\0020\031H\007J%\020\023\032\0020\0042\006\020\032\032\0020\0302\006\020\033\032\0020\0342\006\020\035\032\0020\034H\007¢\006\002\b\026J\035\020\036\032\0020\0042\006\020\037\032\0020 2\006\020\035\032\0020\034H\007¢\006\002\b!J\016\020\007\032\004\030\0010\004*\0020\tH\007J\f\020\013\032\0020\004*\0020\tH\007J\033\020\"\032\0020\004*\0020\t2\b\b\002\020\016\032\0020\017H\007¢\006\002\b\rJ\f\020\021\032\0020\004*\0020\tH\007J\031\020#\032\0020\004*\0020 2\006\020\035\032\0020\034H\007¢\006\002\b\036J\021\020$\032\0020\004*\0020\025H\007¢\006\002\b\023J%\020$\032\0020\004*\0020\0302\b\b\002\020\033\032\0020\0342\b\b\002\020\035\032\0020\034H\007¢\006\002\b\023R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\016\020\005\032\0020\006XT¢\006\002\n\000¨\006%"}, d2={"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeBase64()", imports={"okio.ByteString.Companion.decodeBase64"}))
    public final ByteString -deprecated_decodeBase64(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "string");
      return ((Companion)this).decodeBase64(paramString);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.decodeHex()", imports={"okio.ByteString.Companion.decodeHex"}))
    public final ByteString -deprecated_decodeHex(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "string");
      return ((Companion)this).decodeHex(paramString);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encode(charset)", imports={"okio.ByteString.Companion.encode"}))
    public final ByteString -deprecated_encodeString(String paramString, Charset paramCharset)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "string");
      Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
      return ((Companion)this).encodeString(paramString, paramCharset);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.encodeUtf8()", imports={"okio.ByteString.Companion.encodeUtf8"}))
    public final ByteString -deprecated_encodeUtf8(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "string");
      return ((Companion)this).encodeUtf8(paramString);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="buffer.toByteString()", imports={"okio.ByteString.Companion.toByteString"}))
    public final ByteString -deprecated_of(ByteBuffer paramByteBuffer)
    {
      Intrinsics.checkParameterIsNotNull(paramByteBuffer, "buffer");
      return ((Companion)this).of(paramByteBuffer);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="array.toByteString(offset, byteCount)", imports={"okio.ByteString.Companion.toByteString"}))
    public final ByteString -deprecated_of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
      return ((Companion)this).of(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="inputstream.readByteString(byteCount)", imports={"okio.ByteString.Companion.readByteString"}))
    public final ByteString -deprecated_read(InputStream paramInputStream, int paramInt)
    {
      Intrinsics.checkParameterIsNotNull(paramInputStream, "inputstream");
      return ((Companion)this).read(paramInputStream, paramInt);
    }
    
    @JvmStatic
    public final ByteString decodeBase64(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$decodeBase64");
      paramString = -Base64.decodeBase64ToArray(paramString);
      if (paramString != null) {
        return new ByteString(paramString);
      }
      return null;
    }
    
    @JvmStatic
    public final ByteString decodeHex(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$decodeHex");
      int i = paramString.length();
      int j = 0;
      if (i % 2 == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        int k = paramString.length() / 2;
        localObject = new byte[k];
        i = j;
        while (i < k)
        {
          j = i * 2;
          localObject[i] = ((byte)((ByteStringKt.access$decodeHexDigit(paramString.charAt(j)) << 4) + ByteStringKt.access$decodeHexDigit(paramString.charAt(j + 1))));
          i += 1;
        }
        return new ByteString((byte[])localObject);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected hex string: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
    }
    
    @JvmStatic
    public final ByteString encodeString(String paramString, Charset paramCharset)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$encode");
      Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
      paramString = paramString.getBytes(paramCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      return new ByteString(paramString);
    }
    
    @JvmStatic
    public final ByteString encodeUtf8(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "$this$encodeUtf8");
      ByteString localByteString = new ByteString(-Platform.asUtf8ToByteArray(paramString));
      localByteString.setUtf8$okio(paramString);
      return localByteString;
    }
    
    @JvmStatic
    public final ByteString of(ByteBuffer paramByteBuffer)
    {
      Intrinsics.checkParameterIsNotNull(paramByteBuffer, "$this$toByteString");
      byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
      paramByteBuffer.get(arrayOfByte);
      return new ByteString(arrayOfByte);
    }
    
    @JvmStatic
    public final ByteString of(byte... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "data");
      paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
      Intrinsics.checkExpressionValueIsNotNull(paramVarArgs, "java.util.Arrays.copyOf(this, size)");
      return new ByteString(paramVarArgs);
    }
    
    @JvmStatic
    public final ByteString of(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toByteString");
      -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      return new ByteString(ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2 + paramInt1));
    }
    
    @JvmStatic
    public final ByteString read(InputStream paramInputStream, int paramInt)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$readByteString");
      int j = 0;
      int i;
      if (paramInt >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        byte[] arrayOfByte = new byte[paramInt];
        i = j;
        while (i < paramInt)
        {
          j = paramInputStream.read(arrayOfByte, i, paramInt - i);
          if (j != -1) {
            i += j;
          } else {
            throw ((Throwable)new EOFException());
          }
        }
        return new ByteString(arrayOfByte);
      }
      paramInputStream = new StringBuilder();
      paramInputStream.append("byteCount < 0: ");
      paramInputStream.append(paramInt);
      throw ((Throwable)new IllegalArgumentException(paramInputStream.toString().toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\ByteString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */