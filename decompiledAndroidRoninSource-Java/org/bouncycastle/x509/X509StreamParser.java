package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParser;
import org.bouncycastle.x509.util.StreamParsingException;

public class X509StreamParser
  implements StreamParser
{
  private Provider _provider;
  private X509StreamParserSpi _spi;
  
  private X509StreamParser(Provider paramProvider, X509StreamParserSpi paramX509StreamParserSpi)
  {
    this._provider = paramProvider;
    this._spi = paramX509StreamParserSpi;
  }
  
  private static X509StreamParser createParser(X509Util.Implementation paramImplementation)
  {
    X509StreamParserSpi localX509StreamParserSpi = (X509StreamParserSpi)paramImplementation.getEngine();
    return new X509StreamParser(paramImplementation.getProvider(), localX509StreamParserSpi);
  }
  
  public static X509StreamParser getInstance(String paramString)
    throws NoSuchParserException
  {
    try
    {
      paramString = createParser(X509Util.getImplementation("X509StreamParser", paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new NoSuchParserException(paramString.getMessage());
    }
  }
  
  public static X509StreamParser getInstance(String paramString1, String paramString2)
    throws NoSuchParserException, NoSuchProviderException
  {
    return getInstance(paramString1, X509Util.getProvider(paramString2));
  }
  
  public static X509StreamParser getInstance(String paramString, Provider paramProvider)
    throws NoSuchParserException
  {
    try
    {
      paramString = createParser(X509Util.getImplementation("X509StreamParser", paramString, paramProvider));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new NoSuchParserException(paramString.getMessage());
    }
  }
  
  public Provider getProvider()
  {
    return this._provider;
  }
  
  public void init(InputStream paramInputStream)
  {
    this._spi.engineInit(paramInputStream);
  }
  
  public void init(byte[] paramArrayOfByte)
  {
    this._spi.engineInit(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public Object read()
    throws StreamParsingException
  {
    return this._spi.engineRead();
  }
  
  public Collection readAll()
    throws StreamParsingException
  {
    return this._spi.engineReadAll();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */