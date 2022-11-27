package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DigitallySigned
{
  protected SignatureAndHashAlgorithm algorithm;
  protected byte[] signature;
  
  public DigitallySigned(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.algorithm = paramSignatureAndHashAlgorithm;
      this.signature = paramArrayOfByte;
      return;
    }
    throw new IllegalArgumentException("'signature' cannot be null");
  }
  
  public static DigitallySigned parse(TlsContext paramTlsContext, InputStream paramInputStream)
    throws IOException
  {
    if (TlsUtils.isTLSv12(paramTlsContext)) {
      paramTlsContext = SignatureAndHashAlgorithm.parse(paramInputStream);
    } else {
      paramTlsContext = null;
    }
    return new DigitallySigned(paramTlsContext, TlsUtils.readOpaque16(paramInputStream));
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = this.algorithm;
    if (localSignatureAndHashAlgorithm != null) {
      localSignatureAndHashAlgorithm.encode(paramOutputStream);
    }
    TlsUtils.writeOpaque16(this.signature, paramOutputStream);
  }
  
  public SignatureAndHashAlgorithm getAlgorithm()
  {
    return this.algorithm;
  }
  
  public byte[] getSignature()
  {
    return this.signature;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DigitallySigned.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */