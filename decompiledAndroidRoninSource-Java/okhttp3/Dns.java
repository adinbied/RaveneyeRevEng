package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\016\n\002\b\002\bf\030\000 \0072\0020\001:\001\007J\026\020\002\032\b\022\004\022\0020\0040\0032\006\020\005\032\0020\006H&\002\007\n\005\bF0\001¨\006\b"}, d2={"Lokhttp3/Dns;", "", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Dns
{
  public static final Companion Companion = new Companion(null);
  public static final Dns SYSTEM = (Dns)new Dns.Companion.DnsSystem();
  
  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001:\001\005B\007\b\002¢\006\002\020\002R\026\020\003\032\0020\0048\006X\004ø\001\000¢\006\002\n\000¨\006\001\002\007\n\005\bF0\001¨\006\006"}, d2={"Lokhttp3/Dns$Companion;", "", "()V", "SYSTEM", "Lokhttp3/Dns;", "DnsSystem", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\020\016\n\000\b\002\030\0002\0020\001B\005¢\006\002\020\002J\026\020\003\032\b\022\004\022\0020\0050\0042\006\020\006\032\0020\007H\026¨\006\b"}, d2={"Lokhttp3/Dns$Companion$DnsSystem;", "Lokhttp3/Dns;", "()V", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "okhttp"}, k=1, mv={1, 1, 16})
    private static final class DnsSystem
      implements Dns
    {
      public List<InetAddress> lookup(String paramString)
      {
        Intrinsics.checkParameterIsNotNull(paramString, "hostname");
        try
        {
          Object localObject = InetAddress.getAllByName(paramString);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "InetAddress.getAllByName(hostname)");
          localObject = ArraysKt.toList((Object[])localObject);
          return (List<InetAddress>)localObject;
        }
        catch (NullPointerException localNullPointerException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Broken system behaviour for dns lookup of ");
          localStringBuilder.append(paramString);
          paramString = new UnknownHostException(localStringBuilder.toString());
          paramString.initCause((Throwable)localNullPointerException);
          throw ((Throwable)paramString);
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */