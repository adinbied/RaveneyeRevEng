package org.bouncycastle.crypto.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.util.io.Streams;

public class DHIESPublicKeyParser
  implements KeyParser
{
  private DHParameters dhParams;
  
  public DHIESPublicKeyParser(DHParameters paramDHParameters)
  {
    this.dhParams = paramDHParameters;
  }
  
  public AsymmetricKeyParameter readKey(InputStream paramInputStream)
    throws IOException
  {
    int i = (this.dhParams.getP().bitLength() + 7) / 8;
    byte[] arrayOfByte = new byte[i];
    Streams.readFully(paramInputStream, arrayOfByte, 0, i);
    return new DHPublicKeyParameters(new BigInteger(1, arrayOfByte), this.dhParams);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\parsers\DHIESPublicKeyParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */