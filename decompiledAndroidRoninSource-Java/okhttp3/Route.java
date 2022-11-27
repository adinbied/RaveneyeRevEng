package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\004\n\002\020\016\n\000\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\r\020\002\032\0020\003H\007¢\006\002\b\fJ\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\001H\002J\b\020\020\032\0020\021H\026J\r\020\004\032\0020\005H\007¢\006\002\b\022J\006\020\023\032\0020\016J\r\020\006\032\0020\007H\007¢\006\002\b\024J\b\020\025\032\0020\026H\026R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020\tR\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020\nR\023\020\006\032\0020\0078\007¢\006\b\n\000\032\004\b\006\020\013¨\006\027"}, d2={"Lokhttp3/Route;", "", "address", "Lokhttp3/Address;", "proxy", "Ljava/net/Proxy;", "socketAddress", "Ljava/net/InetSocketAddress;", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "()Lokhttp3/Address;", "()Ljava/net/Proxy;", "()Ljava/net/InetSocketAddress;", "-deprecated_address", "equals", "", "other", "hashCode", "", "-deprecated_proxy", "requiresTunnel", "-deprecated_socketAddress", "toString", "", "okhttp"}, k=1, mv={1, 1, 16})
public final class Route
{
  private final Address address;
  private final Proxy proxy;
  private final InetSocketAddress socketAddress;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    this.address = paramAddress;
    this.proxy = paramProxy;
    this.socketAddress = paramInetSocketAddress;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="address", imports={}))
  public final Address -deprecated_address()
  {
    return this.address;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxy", imports={}))
  public final Proxy -deprecated_proxy()
  {
    return this.proxy;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="socketAddress", imports={}))
  public final InetSocketAddress -deprecated_socketAddress()
  {
    return this.socketAddress;
  }
  
  public final Address address()
  {
    return this.address;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Route))
    {
      paramObject = (Route)paramObject;
      if ((Intrinsics.areEqual(((Route)paramObject).address, this.address)) && (Intrinsics.areEqual(((Route)paramObject).proxy, this.proxy)) && (Intrinsics.areEqual(((Route)paramObject).socketAddress, this.socketAddress))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.address.hashCode()) * 31 + this.proxy.hashCode()) * 31 + this.socketAddress.hashCode();
  }
  
  public final Proxy proxy()
  {
    return this.proxy;
  }
  
  public final boolean requiresTunnel()
  {
    return (this.address.sslSocketFactory() != null) && (this.proxy.type() == Proxy.Type.HTTP);
  }
  
  public final InetSocketAddress socketAddress()
  {
    return this.socketAddress;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Route{");
    localStringBuilder.append(this.socketAddress);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Route.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */