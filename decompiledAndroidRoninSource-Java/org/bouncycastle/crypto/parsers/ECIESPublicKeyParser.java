package org.bouncycastle.crypto.parsers;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.KeyParser;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.io.Streams;

public class ECIESPublicKeyParser
  implements KeyParser
{
  private ECDomainParameters ecParams;
  
  public ECIESPublicKeyParser(ECDomainParameters paramECDomainParameters)
  {
    this.ecParams = paramECDomainParameters;
  }
  
  public AsymmetricKeyParameter readKey(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i != 0)
    {
      byte[] arrayOfByte;
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 6) && (i != 7))
        {
          paramInputStream = new StringBuilder();
          paramInputStream.append("Sender's public key has invalid point encoding 0x");
          paramInputStream.append(Integer.toString(i, 16));
          throw new IOException(paramInputStream.toString());
        }
        arrayOfByte = new byte[(this.ecParams.getCurve().getFieldSize() + 7) / 8 * 2 + 1];
      }
      else
      {
        arrayOfByte = new byte[(this.ecParams.getCurve().getFieldSize() + 7) / 8 + 1];
      }
      arrayOfByte[0] = ((byte)i);
      Streams.readFully(paramInputStream, arrayOfByte, 1, arrayOfByte.length - 1);
      return new ECPublicKeyParameters(this.ecParams.getCurve().decodePoint(arrayOfByte), this.ecParams);
    }
    throw new IOException("Sender's public key invalid.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\parsers\ECIESPublicKeyParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */