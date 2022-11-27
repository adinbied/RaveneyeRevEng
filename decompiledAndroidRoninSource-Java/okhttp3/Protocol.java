package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\n\b\001\030\000 \f2\b\022\004\022\0020\0000\001:\001\fB\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\003H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000j\002\b\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013¨\006\r"}, d2={"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public enum Protocol
{
  public static final Companion Companion = new Companion(null);
  private final String protocol;
  
  static
  {
    Protocol localProtocol1 = new Protocol("HTTP_1_0", 0, "http/1.0");
    HTTP_1_0 = localProtocol1;
    Protocol localProtocol2 = new Protocol("HTTP_1_1", 1, "http/1.1");
    HTTP_1_1 = localProtocol2;
    Protocol localProtocol3 = new Protocol("SPDY_3", 2, "spdy/3.1");
    SPDY_3 = localProtocol3;
    Protocol localProtocol4 = new Protocol("HTTP_2", 3, "h2");
    HTTP_2 = localProtocol4;
    Protocol localProtocol5 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
    H2_PRIOR_KNOWLEDGE = localProtocol5;
    Protocol localProtocol6 = new Protocol("QUIC", 5, "quic");
    QUIC = localProtocol6;
    $VALUES = new Protocol[] { localProtocol1, localProtocol2, localProtocol3, localProtocol4, localProtocol5, localProtocol6 };
  }
  
  private Protocol(String paramString)
  {
    this.protocol = paramString;
  }
  
  @JvmStatic
  public static final Protocol get(String paramString)
    throws IOException
  {
    return Companion.get(paramString);
  }
  
  public String toString()
  {
    return this.protocol;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007¨\006\007"}, d2={"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @JvmStatic
    public final Protocol get(String paramString)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramString, "protocol");
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.HTTP_1_0))) {
        return Protocol.HTTP_1_0;
      }
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.HTTP_1_1))) {
        return Protocol.HTTP_1_1;
      }
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.H2_PRIOR_KNOWLEDGE))) {
        return Protocol.H2_PRIOR_KNOWLEDGE;
      }
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.HTTP_2))) {
        return Protocol.HTTP_2;
      }
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.SPDY_3))) {
        return Protocol.SPDY_3;
      }
      if (Intrinsics.areEqual(paramString, Protocol.access$getProtocol$p(Protocol.QUIC))) {
        return Protocol.QUIC;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected protocol: ");
      localStringBuilder.append(paramString);
      throw ((Throwable)new IOException(localStringBuilder.toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Protocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */