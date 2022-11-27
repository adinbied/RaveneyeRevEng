package dji.thirdparty.okhttp3.internal;

import dji.thirdparty.okhttp3.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase
{
  private final Set<Route> failedRoutes = new LinkedHashSet();
  
  /* Error */
  public void connected(Route arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void failed(Route arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int failedRoutesCount()
  {
    return 0;
  }
  
  public boolean shouldPostpone(Route paramRoute)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\RouteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */