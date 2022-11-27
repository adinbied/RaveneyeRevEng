package okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\003\030\000 \0262\0020\001:\001\026B\027\b\020\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006B\037\b\020\022\006\020\002\032\0020\003\022\006\020\007\032\0020\b\022\006\020\004\032\0020\005¢\006\002\020\tJ\r\020\n\032\0020\bH\007¢\006\002\b\020J\030\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\022H\026R\021\020\n\032\0020\b8G¢\006\006\032\004\b\n\020\013R\020\020\f\032\004\030\0010\rX\004¢\006\002\n\000R\020\020\016\032\004\030\0010\017X\004¢\006\002\n\000¨\006\027"}, d2={"Lokio/HashingSource;", "Lokio/ForwardingSource;", "source", "Lokio/Source;", "algorithm", "", "(Lokio/Source;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "read", "", "sink", "Lokio/Buffer;", "byteCount", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSource
  extends ForwardingSource
{
  public static final Companion Companion = new Companion(null);
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  public HashingSource(Source paramSource, String paramString)
  {
    super(paramSource);
    this.messageDigest = MessageDigest.getInstance(paramString);
    this.mac = ((Mac)null);
  }
  
  public HashingSource(Source paramSource, ByteString paramByteString, String paramString)
  {
    super(paramSource);
    try
    {
      paramSource = Mac.getInstance(paramString);
      paramSource.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.mac = paramSource;
      this.messageDigest = ((MessageDigest)null);
      return;
    }
    catch (InvalidKeyException paramSource)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramSource));
    }
  }
  
  @JvmStatic
  public static final HashingSource hmacSha1(Source paramSource, ByteString paramByteString)
  {
    return Companion.hmacSha1(paramSource, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSource hmacSha256(Source paramSource, ByteString paramByteString)
  {
    return Companion.hmacSha256(paramSource, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSource hmacSha512(Source paramSource, ByteString paramByteString)
  {
    return Companion.hmacSha512(paramSource, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSource md5(Source paramSource)
  {
    return Companion.md5(paramSource);
  }
  
  @JvmStatic
  public static final HashingSource sha1(Source paramSource)
  {
    return Companion.sha1(paramSource);
  }
  
  @JvmStatic
  public static final HashingSource sha256(Source paramSource)
  {
    return Companion.sha256(paramSource);
  }
  
  @JvmStatic
  public static final HashingSource sha512(Source paramSource)
  {
    return Companion.sha512(paramSource);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hash", imports={}))
  public final ByteString -deprecated_hash()
  {
    return hash();
  }
  
  public final ByteString hash()
  {
    Object localObject = this.messageDigest;
    if (localObject != null)
    {
      localObject = ((MessageDigest)localObject).digest();
    }
    else
    {
      localObject = this.mac;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((Mac)localObject).doFinal();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "result");
    return new ByteString((byte[])localObject);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    long l4 = super.read(paramBuffer, paramLong);
    if (l4 != -1L)
    {
      long l3 = paramBuffer.size() - l4;
      long l1 = paramBuffer.size();
      Object localObject2 = paramBuffer.head;
      paramLong = l1;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        Intrinsics.throwNpe();
        localObject1 = localObject2;
      }
      long l2;
      for (paramLong = l1;; paramLong -= ((Segment)localObject1).limit - ((Segment)localObject1).pos)
      {
        l1 = l3;
        l2 = paramLong;
        localObject2 = localObject1;
        if (paramLong <= l3) {
          break;
        }
        localObject1 = ((Segment)localObject1).prev;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
      }
      while (l2 < paramBuffer.size())
      {
        int i = (int)(((Segment)localObject2).pos + l1 - l2);
        localObject1 = this.messageDigest;
        if (localObject1 != null)
        {
          ((MessageDigest)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        else
        {
          localObject1 = this.mac;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((Mac)localObject1).update(((Segment)localObject2).data, i, ((Segment)localObject2).limit - i);
        }
        l2 += ((Segment)localObject2).limit - ((Segment)localObject2).pos;
        localObject2 = ((Segment)localObject2).next;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        l1 = l2;
      }
    }
    return l4;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\030\020\t\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\030\020\n\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\020\020\013\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\f\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\r\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\016\032\0020\0042\006\020\005\032\0020\006H\007¨\006\017"}, d2={"Lokio/HashingSource$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSource;", "source", "Lokio/Source;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final HashingSource hmacSha1(Source paramSource, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSource(paramSource, paramByteString, "HmacSHA1");
    }
    
    @JvmStatic
    public final HashingSource hmacSha256(Source paramSource, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSource(paramSource, paramByteString, "HmacSHA256");
    }
    
    @JvmStatic
    public final HashingSource hmacSha512(Source paramSource, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSource(paramSource, paramByteString, "HmacSHA512");
    }
    
    @JvmStatic
    public final HashingSource md5(Source paramSource)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      return new HashingSource(paramSource, "MD5");
    }
    
    @JvmStatic
    public final HashingSource sha1(Source paramSource)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      return new HashingSource(paramSource, "SHA-1");
    }
    
    @JvmStatic
    public final HashingSource sha256(Source paramSource)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      return new HashingSource(paramSource, "SHA-256");
    }
    
    @JvmStatic
    public final HashingSource sha512(Source paramSource)
    {
      Intrinsics.checkParameterIsNotNull(paramSource, "source");
      return new HashingSource(paramSource, "SHA-512");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\HashingSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */