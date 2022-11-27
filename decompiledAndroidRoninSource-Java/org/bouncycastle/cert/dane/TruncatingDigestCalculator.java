package org.bouncycastle.cert.dane;

import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;

public class TruncatingDigestCalculator
  implements DigestCalculator
{
  private final DigestCalculator baseCalculator;
  private final int length;
  
  public TruncatingDigestCalculator(DigestCalculator paramDigestCalculator)
  {
    this(paramDigestCalculator, 28);
  }
  
  public TruncatingDigestCalculator(DigestCalculator paramDigestCalculator, int paramInt)
  {
    this.baseCalculator = paramDigestCalculator;
    this.length = paramInt;
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return this.baseCalculator.getAlgorithmIdentifier();
  }
  
  public byte[] getDigest()
  {
    int i = this.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.baseCalculator.getDigest(), 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public OutputStream getOutputStream()
  {
    return this.baseCalculator.getOutputStream();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\TruncatingDigestCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */