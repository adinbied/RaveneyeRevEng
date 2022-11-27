package dji.thirdparty.afinal.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore
  implements CookieStore
{
  private static final String COOKIE_NAME_PREFIX = "cookie_";
  private static final String COOKIE_NAME_STORE = "names";
  private static final String COOKIE_PREFS = "CookiePrefsFile";
  private final SharedPreferences cookiePrefs;
  private final ConcurrentHashMap<String, Cookie> cookies;
  
  public PreferencesCookieStore(Context paramContext)
  {
    int i = 0;
    this.cookiePrefs = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.cookies = new ConcurrentHashMap();
    paramContext = this.cookiePrefs.getString("names", null);
    if (paramContext != null)
    {
      paramContext = TextUtils.split(paramContext, ",");
      int j = paramContext.length;
      while (i < j)
      {
        String str = paramContext[i];
        Object localObject = this.cookiePrefs;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cookie_");
        localStringBuilder.append(str);
        localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
        if (localObject != null)
        {
          localObject = decodeCookie((String)localObject);
          if (localObject != null) {
            this.cookies.put(str, localObject);
          }
        }
        i += 1;
      }
      clearExpired(new Date());
    }
  }
  
  /* Error */
  public void addCookie(Cookie arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean clearExpired(Date paramDate)
  {
    return false;
  }
  
  protected Cookie decodeCookie(String paramString)
  {
    return null;
  }
  
  protected String encodeCookie(SerializableCookie paramSerializableCookie)
  {
    return null;
  }
  
  public List<Cookie> getCookies()
  {
    return null;
  }
  
  protected byte[] hexStringToByteArray(String paramString)
  {
    return null;
  }
  
  public class SerializableCookie
    implements Serializable
  {
    private static final long serialVersionUID = 6374381828722046732L;
    private transient BasicClientCookie clientCookie;
    private final transient Cookie cookie;
    
    public SerializableCookie(Cookie paramCookie)
    {
      this.cookie = paramCookie;
    }
    
    /* Error */
    private void readObject(java.io.ObjectInputStream arg1)
      throws java.io.IOException, java.lang.ClassNotFoundException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void writeObject(java.io.ObjectOutputStream arg1)
      throws java.io.IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Cookie getCookie()
    {
      Object localObject = this.cookie;
      BasicClientCookie localBasicClientCookie = this.clientCookie;
      if (localBasicClientCookie != null) {
        localObject = localBasicClientCookie;
      }
      return (Cookie)localObject;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\PreferencesCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */