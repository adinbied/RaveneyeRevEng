package dji.thirdparty.afinal.https;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class DJISSLSocketFactoryForApache
  extends SSLSocketFactory
{
  private SSLContext mSSLContext = SSLContext.getInstance("TLS");
  
  public DJISSLSocketFactoryForApache(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\https\DJISSLSocketFactoryForApache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */