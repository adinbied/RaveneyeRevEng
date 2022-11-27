package dji.thirdparty.okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns()
  {
    public List<InetAddress> lookup(String paramAnonymousString)
      throws UnknownHostException
    {
      return null;
    }
  };
  
  public abstract List<InetAddress> lookup(String paramString)
    throws UnknownHostException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */