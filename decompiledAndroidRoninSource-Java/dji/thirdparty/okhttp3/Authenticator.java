package dji.thirdparty.okhttp3;

import java.io.IOException;

public abstract interface Authenticator
{
  public static final Authenticator NONE = new Authenticator()
  {
    public Request authenticate(Route paramAnonymousRoute, Response paramAnonymousResponse)
    {
      return null;
    }
  };
  
  public abstract Request authenticate(Route paramRoute, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */