package dji.thirdparty.okhttp3;

import java.util.Collections;
import java.util.List;

public abstract interface CookieJar
{
  public static final CookieJar NO_COOKIES = new CookieJar()
  {
    public List<Cookie> loadForRequest(HttpUrl paramAnonymousHttpUrl)
    {
      return Collections.emptyList();
    }
    
    public void saveFromResponse(HttpUrl paramAnonymousHttpUrl, List<Cookie> paramAnonymousList) {}
  };
  
  public abstract List<Cookie> loadForRequest(HttpUrl paramHttpUrl);
  
  public abstract void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\CookieJar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */