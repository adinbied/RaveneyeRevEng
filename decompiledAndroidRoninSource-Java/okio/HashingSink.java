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

@Metadata(bv={1, 0, 3}, d1={"\000B\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\t\n\002\b\002\030\000 \0272\0020\001:\001\027B\027\b\020\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006B\037\b\020\022\006\020\002\032\0020\003\022\006\020\007\032\0020\b\022\006\020\004\032\0020\005¢\006\002\020\tJ\r\020\n\032\0020\bH\007¢\006\002\b\020J\030\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\026H\026R\021\020\n\032\0020\b8G¢\006\006\032\004\b\n\020\013R\020\020\f\032\004\030\0010\rX\004¢\006\002\n\000R\020\020\016\032\004\030\0010\017X\004¢\006\002\n\000¨\006\030"}, d2={"Lokio/HashingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "key", "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "mac", "Ljavax/crypto/Mac;", "messageDigest", "Ljava/security/MessageDigest;", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"}, k=1, mv={1, 1, 16})
public final class HashingSink
  extends ForwardingSink
{
  public static final Companion Companion = new Companion(null);
  private final Mac mac;
  private final MessageDigest messageDigest;
  
  public HashingSink(Sink paramSink, String paramString)
  {
    super(paramSink);
    this.messageDigest = MessageDigest.getInstance(paramString);
    this.mac = ((Mac)null);
  }
  
  public HashingSink(Sink paramSink, ByteString paramByteString, String paramString)
  {
    super(paramSink);
    try
    {
      paramSink = Mac.getInstance(paramString);
      paramSink.init((Key)new SecretKeySpec(paramByteString.toByteArray(), paramString));
      this.mac = paramSink;
      this.messageDigest = ((MessageDigest)null);
      return;
    }
    catch (InvalidKeyException paramSink)
    {
      throw ((Throwable)new IllegalArgumentException((Throwable)paramSink));
    }
  }
  
  @JvmStatic
  public static final HashingSink hmacSha1(Sink paramSink, ByteString paramByteString)
  {
    return Companion.hmacSha1(paramSink, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSink hmacSha256(Sink paramSink, ByteString paramByteString)
  {
    return Companion.hmacSha256(paramSink, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSink hmacSha512(Sink paramSink, ByteString paramByteString)
  {
    return Companion.hmacSha512(paramSink, paramByteString);
  }
  
  @JvmStatic
  public static final HashingSink md5(Sink paramSink)
  {
    return Companion.md5(paramSink);
  }
  
  @JvmStatic
  public static final HashingSink sha1(Sink paramSink)
  {
    return Companion.sha1(paramSink);
  }
  
  @JvmStatic
  public static final HashingSink sha256(Sink paramSink)
  {
    return Companion.sha256(paramSink);
  }
  
  @JvmStatic
  public static final HashingSink sha512(Sink paramSink)
  {
    return Companion.sha512(paramSink);
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
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    Object localObject1 = paramBuffer.head;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    long l1 = 0L;
    while (l1 < paramLong)
    {
      int i = (int)Math.min(paramLong - l1, ((Segment)localObject1).limit - ((Segment)localObject1).pos);
      Object localObject2 = this.messageDigest;
      if (localObject2 != null)
      {
        ((MessageDigest)localObject2).update(((Segment)localObject1).data, ((Segment)localObject1).pos, i);
      }
      else
      {
        localObject2 = this.mac;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((Mac)localObject2).update(((Segment)localObject1).data, ((Segment)localObject1).pos, i);
      }
      long l2 = l1 + i;
      localObject2 = ((Segment)localObject1).next;
      localObject1 = localObject2;
      l1 = l2;
      if (localObject2 == null)
      {
        Intrinsics.throwNpe();
        localObject1 = localObject2;
        l1 = l2;
      }
    }
    super.write(paramBuffer, paramLong);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\030\020\t\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\030\020\n\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\007J\020\020\013\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\f\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\r\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\016\032\0020\0042\006\020\005\032\0020\006H\007¨\006\017"}, d2={"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", "key", "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final HashingSink hmacSha1(Sink paramSink, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSink(paramSink, paramByteString, "HmacSHA1");
    }
    
    @JvmStatic
    public final HashingSink hmacSha256(Sink paramSink, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSink(paramSink, paramByteString, "HmacSHA256");
    }
    
    @JvmStatic
    public final HashingSink hmacSha512(Sink paramSink, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      Intrinsics.checkParameterIsNotNull(paramByteString, "key");
      return new HashingSink(paramSink, paramByteString, "HmacSHA512");
    }
    
    @JvmStatic
    public final HashingSink md5(Sink paramSink)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      return new HashingSink(paramSink, "MD5");
    }
    
    @JvmStatic
    public final HashingSink sha1(Sink paramSink)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      return new HashingSink(paramSink, "SHA-1");
    }
    
    @JvmStatic
    public final HashingSink sha256(Sink paramSink)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      return new HashingSink(paramSink, "SHA-256");
    }
    
    @JvmStatic
    public final HashingSink sha512(Sink paramSink)
    {
      Intrinsics.checkParameterIsNotNull(paramSink, "sink");
      return new HashingSink(paramSink, "SHA-512");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\HashingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */