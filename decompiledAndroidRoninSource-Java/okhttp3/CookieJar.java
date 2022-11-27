package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\bf\030\000 \n2\0020\001:\001\nJ\026\020\002\032\b\022\004\022\0020\0040\0032\006\020\005\032\0020\006H&J\036\020\007\032\0020\b2\006\020\005\032\0020\0062\f\020\t\032\b\022\004\022\0020\0040\003H&\002\007\n\005\bF0\001¨\006\013"}, d2={"Lokhttp3/CookieJar;", "", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface CookieJar
{
  public static final Companion Companion = new Companion(null);
  public static final CookieJar NO_COOKIES = (CookieJar)new CookieJar.Companion.NoCookies();
  
  public abstract List<Cookie> loadForRequest(HttpUrl paramHttpUrl);
  
  public abstract void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList);
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001:\001\005B\007\b\002¢\006\002\020\002R\026\020\003\032\0020\0048\006X\004ø\001\000¢\006\002\n\000¨\006\001\002\007\n\005\bF0\001¨\006\006"}, d2={"Lokhttp3/CookieJar$Companion;", "", "()V", "NO_COOKIES", "Lokhttp3/CookieJar;", "NoCookies", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\b\002\030\0002\0020\001B\005¢\006\002\020\002J\026\020\003\032\b\022\004\022\0020\0050\0042\006\020\006\032\0020\007H\026J\036\020\b\032\0020\t2\006\020\006\032\0020\0072\f\020\n\032\b\022\004\022\0020\0050\004H\026¨\006\013"}, d2={"Lokhttp3/CookieJar$Companion$NoCookies;", "Lokhttp3/CookieJar;", "()V", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "okhttp"}, k=1, mv={1, 1, 16})
    private static final class NoCookies
      implements CookieJar
    {
      public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
      {
        Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
        return CollectionsKt.emptyList();
      }
      
      public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
      {
        Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
        Intrinsics.checkParameterIsNotNull(paramList, "cookies");
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\CookieJar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */