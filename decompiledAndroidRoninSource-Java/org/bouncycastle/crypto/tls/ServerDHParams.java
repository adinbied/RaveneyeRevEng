package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;

public class ServerDHParams
{
  protected DHPublicKeyParameters publicKey;
  
  public ServerDHParams(DHPublicKeyParameters paramDHPublicKeyParameters)
  {
    if (paramDHPublicKeyParameters != null)
    {
      this.publicKey = paramDHPublicKeyParameters;
      return;
    }
    throw new IllegalArgumentException("'publicKey' cannot be null");
  }
  
  public static ServerDHParams parse(InputStream paramInputStream)
    throws IOException
  {
    BigInteger localBigInteger1 = TlsDHUtils.readDHParameter(paramInputStream);
    BigInteger localBigInteger2 = TlsDHUtils.readDHParameter(paramInputStream);
    return new ServerDHParams(TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(paramInputStream), new DHParameters(localBigInteger1, localBigInteger2))));
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    DHParameters localDHParameters = this.publicKey.getParameters();
    BigInteger localBigInteger = this.publicKey.getY();
    TlsDHUtils.writeDHParameter(localDHParameters.getP(), paramOutputStream);
    TlsDHUtils.writeDHParameter(localDHParameters.getG(), paramOutputStream);
    TlsDHUtils.writeDHParameter(localBigInteger, paramOutputStream);
  }
  
  public DHPublicKeyParameters getPublicKey()
  {
    return this.publicKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ServerDHParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */