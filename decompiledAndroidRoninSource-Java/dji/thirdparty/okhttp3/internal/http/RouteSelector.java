package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Address;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.Route;
import dji.thirdparty.okhttp3.internal.RouteDatabase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RouteSelector
{
  private final Address address;
  private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
  private InetSocketAddress lastInetSocketAddress;
  private Proxy lastProxy;
  private int nextInetSocketAddressIndex;
  private int nextProxyIndex;
  private final List<Route> postponedRoutes = new ArrayList();
  private List<Proxy> proxies = Collections.emptyList();
  private final RouteDatabase routeDatabase;
  
  public RouteSelector(Address paramAddress, RouteDatabase paramRouteDatabase)
  {
    this.address = paramAddress;
    this.routeDatabase = paramRouteDatabase;
    resetNextProxy(paramAddress.url(), paramAddress.proxy());
  }
  
  static String getHostString(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private boolean hasNextInetSocketAddress()
  {
    return false;
  }
  
  private boolean hasNextPostponed()
  {
    return false;
  }
  
  private boolean hasNextProxy()
  {
    return false;
  }
  
  private InetSocketAddress nextInetSocketAddress()
    throws IOException
  {
    return null;
  }
  
  private Route nextPostponed()
  {
    return null;
  }
  
  private Proxy nextProxy()
    throws IOException
  {
    return null;
  }
  
  /* Error */
  private void resetNextInetSocketAddress(Proxy arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void resetNextProxy(HttpUrl paramHttpUrl, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.proxies = Collections.singletonList(paramProxy);
    }
    else
    {
      this.proxies = new ArrayList();
      paramHttpUrl = this.address.proxySelector().select(paramHttpUrl.uri());
      if (paramHttpUrl != null) {
        this.proxies.addAll(paramHttpUrl);
      }
      this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
      this.proxies.add(Proxy.NO_PROXY);
    }
    this.nextProxyIndex = 0;
  }
  
  /* Error */
  public void connectFailed(Route arg1, IOException arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean hasNext()
  {
    return false;
  }
  
  public Route next()
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\RouteSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */