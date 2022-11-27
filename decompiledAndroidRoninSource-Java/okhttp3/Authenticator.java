package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\bf\030\000 \b2\0020\001:\001\bJ\034\020\002\032\004\030\0010\0032\b\020\004\032\004\030\0010\0052\006\020\006\032\0020\007H&\002\007\n\005\bF0\001¨\006\t"}, d2={"Lokhttp3/Authenticator;", "", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Authenticator
{
  public static final Companion Companion = new Companion(null);
  public static final Authenticator NONE = (Authenticator)new Authenticator.Companion.AuthenticatorNone();
  
  public abstract Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException;
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001:\001\005B\007\b\002¢\006\002\020\002R\026\020\003\032\0020\0048\006X\004ø\001\000¢\006\002\n\000¨\006\001\002\007\n\005\bF0\001¨\006\006"}, d2={"Lokhttp3/Authenticator$Companion;", "", "()V", "NONE", "Lokhttp3/Authenticator;", "AuthenticatorNone", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\002\030\0002\0020\001B\005¢\006\002\020\002J\034\020\003\032\004\030\0010\0042\b\020\005\032\004\030\0010\0062\006\020\007\032\0020\bH\026¨\006\t"}, d2={"Lokhttp3/Authenticator$Companion$AuthenticatorNone;", "Lokhttp3/Authenticator;", "()V", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "okhttp"}, k=1, mv={1, 1, 16})
    private static final class AuthenticatorNone
      implements Authenticator
    {
      public Request authenticate(Route paramRoute, Response paramResponse)
      {
        Intrinsics.checkParameterIsNotNull(paramResponse, "response");
        return null;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */