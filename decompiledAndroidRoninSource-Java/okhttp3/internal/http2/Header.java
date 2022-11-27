package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio.ByteString.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\004\n\002\020\013\n\002\b\005\b\b\030\000 \0232\0020\001:\001\023B\027\b\026\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005B\027\b\026\022\006\020\002\032\0020\006\022\006\020\004\032\0020\003¢\006\002\020\007B\025\022\006\020\002\032\0020\006\022\006\020\004\032\0020\006¢\006\002\020\bJ\t\020\013\032\0020\006HÆ\003J\t\020\f\032\0020\006HÆ\003J\035\020\r\032\0020\0002\b\b\002\020\002\032\0020\0062\b\b\002\020\004\032\0020\006HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\nHÖ\001J\b\020\022\032\0020\003H\026R\020\020\t\032\0020\n8\006X\004¢\006\002\n\000R\020\020\002\032\0020\0068\006X\004¢\006\002\n\000R\020\020\004\032\0020\0068\006X\004¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/internal/http2/Header;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokio/ByteString;", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "hpackSize", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Header
{
  public static final Companion Companion = new Companion(null);
  public static final ByteString PSEUDO_PREFIX = ByteString.Companion.encodeUtf8(":");
  public static final ByteString RESPONSE_STATUS = ByteString.Companion.encodeUtf8(":status");
  public static final String RESPONSE_STATUS_UTF8 = ":status";
  public static final ByteString TARGET_AUTHORITY = ByteString.Companion.encodeUtf8(":authority");
  public static final String TARGET_AUTHORITY_UTF8 = ":authority";
  public static final ByteString TARGET_METHOD = ByteString.Companion.encodeUtf8(":method");
  public static final String TARGET_METHOD_UTF8 = ":method";
  public static final ByteString TARGET_PATH = ByteString.Companion.encodeUtf8(":path");
  public static final String TARGET_PATH_UTF8 = ":path";
  public static final ByteString TARGET_SCHEME = ByteString.Companion.encodeUtf8(":scheme");
  public static final String TARGET_SCHEME_UTF8 = ":scheme";
  public final int hpackSize;
  public final ByteString name;
  public final ByteString value;
  
  public Header(String paramString1, String paramString2)
  {
    this(ByteString.Companion.encodeUtf8(paramString1), ByteString.Companion.encodeUtf8(paramString2));
  }
  
  public Header(ByteString paramByteString, String paramString)
  {
    this(paramByteString, ByteString.Companion.encodeUtf8(paramString));
  }
  
  public Header(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.name = paramByteString1;
    this.value = paramByteString2;
    this.hpackSize = (paramByteString1.size() + 32 + this.value.size());
  }
  
  public final ByteString component1()
  {
    return this.name;
  }
  
  public final ByteString component2()
  {
    return this.value;
  }
  
  public final Header copy(ByteString paramByteString1, ByteString paramByteString2)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString1, "name");
    Intrinsics.checkParameterIsNotNull(paramByteString2, "value");
    return new Header(paramByteString1, paramByteString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Header))
      {
        paramObject = (Header)paramObject;
        if ((Intrinsics.areEqual(this.name, ((Header)paramObject).name)) && (Intrinsics.areEqual(this.value, ((Header)paramObject).value))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    ByteString localByteString = this.name;
    int j = 0;
    int i;
    if (localByteString != null) {
      i = localByteString.hashCode();
    } else {
      i = 0;
    }
    localByteString = this.value;
    if (localByteString != null) {
      j = localByteString.hashCode();
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name.utf8());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.value.utf8());
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\t\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0048\006X\004¢\006\002\n\000R\016\020\006\032\0020\007XT¢\006\002\n\000R\020\020\b\032\0020\0048\006X\004¢\006\002\n\000R\016\020\t\032\0020\007XT¢\006\002\n\000R\020\020\n\032\0020\0048\006X\004¢\006\002\n\000R\016\020\013\032\0020\007XT¢\006\002\n\000R\020\020\f\032\0020\0048\006X\004¢\006\002\n\000R\016\020\r\032\0020\007XT¢\006\002\n\000R\020\020\016\032\0020\0048\006X\004¢\006\002\n\000R\016\020\017\032\0020\007XT¢\006\002\n\000¨\006\020"}, d2={"Lokhttp3/internal/http2/Header$Companion;", "", "()V", "PSEUDO_PREFIX", "Lokio/ByteString;", "RESPONSE_STATUS", "RESPONSE_STATUS_UTF8", "", "TARGET_AUTHORITY", "TARGET_AUTHORITY_UTF8", "TARGET_METHOD", "TARGET_METHOD_UTF8", "TARGET_PATH", "TARGET_PATH_UTF8", "TARGET_SCHEME", "TARGET_SCHEME_UTF8", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Header.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */