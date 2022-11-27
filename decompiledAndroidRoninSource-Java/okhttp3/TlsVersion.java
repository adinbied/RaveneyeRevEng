package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\n\b\001\030\000 \f2\b\022\004\022\0020\0000\001:\001\fB\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\002\032\0020\003H\007¢\006\002\b\006R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\005j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013¨\006\r"}, d2={"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public enum TlsVersion
{
  public static final Companion Companion = new Companion(null);
  private final String javaName;
  
  static
  {
    TlsVersion localTlsVersion1 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
    TLS_1_3 = localTlsVersion1;
    TlsVersion localTlsVersion2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
    TLS_1_2 = localTlsVersion2;
    TlsVersion localTlsVersion3 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
    TLS_1_1 = localTlsVersion3;
    TlsVersion localTlsVersion4 = new TlsVersion("TLS_1_0", 3, "TLSv1");
    TLS_1_0 = localTlsVersion4;
    TlsVersion localTlsVersion5 = new TlsVersion("SSL_3_0", 4, "SSLv3");
    SSL_3_0 = localTlsVersion5;
    $VALUES = new TlsVersion[] { localTlsVersion1, localTlsVersion2, localTlsVersion3, localTlsVersion4, localTlsVersion5 };
  }
  
  private TlsVersion(String paramString)
  {
    this.javaName = paramString;
  }
  
  @JvmStatic
  public static final TlsVersion forJavaName(String paramString)
  {
    return Companion.forJavaName(paramString);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="javaName", imports={}))
  public final String -deprecated_javaName()
  {
    return this.javaName;
  }
  
  public final String javaName()
  {
    return this.javaName;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2={"Lokhttp3/TlsVersion$Companion;", "", "()V", "forJavaName", "Lokhttp3/TlsVersion;", "javaName", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final TlsVersion forJavaName(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "javaName");
      int i = paramString.hashCode();
      if (i != 79201641)
      {
        if (i != 79923350) {
          switch (i)
          {
          default: 
            break;
          case -503070501: 
            if (!paramString.equals("TLSv1.3")) {
              break;
            }
            return TlsVersion.TLS_1_3;
          case -503070502: 
            if (!paramString.equals("TLSv1.2")) {
              break;
            }
            return TlsVersion.TLS_1_2;
          case -503070503: 
            if (!paramString.equals("TLSv1.1")) {
              break;
            }
            return TlsVersion.TLS_1_1;
          }
        } else if (paramString.equals("TLSv1")) {
          return TlsVersion.TLS_1_0;
        }
      }
      else if (paramString.equals("SSLv3")) {
        return TlsVersion.SSL_3_0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected TLS version: ");
      localStringBuilder.append(paramString);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\TlsVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */