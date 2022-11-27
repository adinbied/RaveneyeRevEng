package dji.thirdparty.okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route
{
  final Address address;
  final InetSocketAddress inetSocketAddress;
  final Proxy proxy;
  
  public Route(Address paramAddress, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (paramAddress != null)
    {
      if (paramProxy != null)
      {
        if (paramInetSocketAddress != null)
        {
          this.address = paramAddress;
          this.proxy = paramProxy;
          this.inetSocketAddress = paramInetSocketAddress;
          return;
        }
        throw new NullPointerException("inetSocketAddress == null");
      }
      throw new NullPointerException("proxy == null");
    }
    throw new NullPointerException("address == null");
  }
  
  public Address address()
  {
    return this.address;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public Proxy proxy()
  {
    return this.proxy;
  }
  
  public boolean requiresTunnel()
  {
    return false;
  }
  
  public InetSocketAddress socketAddress()
  {
    return this.inetSocketAddress;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Route.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */