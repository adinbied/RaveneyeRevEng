package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020#\n\002\030\002\n\000\n\002\020\002\n\002\b\004\n\002\020\013\n\000\030\0002\0020\001B\005¢\006\002\020\002J\016\020\006\032\0020\0072\006\020\b\032\0020\005J\016\020\t\032\0020\0072\006\020\n\032\0020\005J\016\020\013\032\0020\f2\006\020\b\032\0020\005R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/internal/connection/RouteDatabase;", "", "()V", "failedRoutes", "", "Lokhttp3/Route;", "connected", "", "route", "failed", "failedRoute", "shouldPostpone", "", "okhttp"}, k=1, mv={1, 1, 16})
public final class RouteDatabase
{
  private final Set<Route> failedRoutes = (Set)new LinkedHashSet();
  
  public final void connected(Route paramRoute)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramRoute, "route");
      this.failedRoutes.remove(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public final void failed(Route paramRoute)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramRoute, "failedRoute");
      this.failedRoutes.add(paramRoute);
      return;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
  
  public final boolean shouldPostpone(Route paramRoute)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramRoute, "route");
      boolean bool = this.failedRoutes.contains(paramRoute);
      return bool;
    }
    finally
    {
      paramRoute = finally;
      throw paramRoute;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\connection\RouteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */