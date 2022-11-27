package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

public class TlsRSAUtils
{
  public static byte[] generateEncryptedPreMasterSecret(TlsContext paramTlsContext, RSAKeyParameters paramRSAKeyParameters, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[48];
    paramTlsContext.getSecureRandom().nextBytes(arrayOfByte);
    TlsUtils.writeVersion(paramTlsContext.getClientVersion(), arrayOfByte, 0);
    PKCS1Encoding localPKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine());
    localPKCS1Encoding.init(true, new ParametersWithRandom(paramRSAKeyParameters, paramTlsContext.getSecureRandom()));
    try
    {
      paramRSAKeyParameters = localPKCS1Encoding.processBlock(arrayOfByte, 0, 48);
      if (TlsUtils.isSSL(paramTlsContext))
      {
        paramOutputStream.write(paramRSAKeyParameters);
        return arrayOfByte;
      }
      TlsUtils.writeOpaque16(paramRSAKeyParameters, paramOutputStream);
      return arrayOfByte;
    }
    catch (InvalidCipherTextException paramTlsContext)
    {
      throw new TlsFatalAlert((short)80, paramTlsContext);
    }
  }
  
  public static byte[] safeDecryptPreMasterSecret(TlsContext paramTlsContext, RSAKeyParameters paramRSAKeyParameters, byte[] paramArrayOfByte)
  {
    ProtocolVersion localProtocolVersion = paramTlsContext.getClientVersion();
    byte[] arrayOfByte2 = new byte[48];
    paramTlsContext.getSecureRandom().nextBytes(arrayOfByte2);
    byte[] arrayOfByte1 = Arrays.clone(arrayOfByte2);
    int i = 0;
    try
    {
      PKCS1Encoding localPKCS1Encoding = new PKCS1Encoding(new RSABlindedEngine(), arrayOfByte2);
      localPKCS1Encoding.init(false, new ParametersWithRandom(paramRSAKeyParameters, paramTlsContext.getSecureRandom()));
      paramTlsContext = localPKCS1Encoding.processBlock(paramArrayOfByte, 0, paramArrayOfByte.length);
      int j = localProtocolVersion.getMajorVersion() ^ paramTlsContext[0] & 0xFF | localProtocolVersion.getMinorVersion() ^ paramTlsContext[1] & 0xFF;
      j |= j >> 1;
      j |= j >> 2;
      j = ((j | j >> 4) & 0x1) - 1;
      while (i < 48)
      {
        paramTlsContext[i] = ((byte)(paramTlsContext[i] & j | arrayOfByte2[i] & j));
        i += 1;
      }
      return paramTlsContext;
    }
    catch (Exception paramTlsContext)
    {
      for (;;)
      {
        paramTlsContext = arrayOfByte1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsRSAUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */