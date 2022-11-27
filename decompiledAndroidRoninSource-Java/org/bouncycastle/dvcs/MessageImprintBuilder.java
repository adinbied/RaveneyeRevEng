package org.bouncycastle.dvcs;

import java.io.OutputStream;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.operator.DigestCalculator;

public class MessageImprintBuilder
{
  private final DigestCalculator digestCalculator;
  
  public MessageImprintBuilder(DigestCalculator paramDigestCalculator)
  {
    this.digestCalculator = paramDigestCalculator;
  }
  
  public MessageImprint build(byte[] paramArrayOfByte)
    throws DVCSException
  {
    try
    {
      localObject = this.digestCalculator.getOutputStream();
      ((OutputStream)localObject).write(paramArrayOfByte);
      ((OutputStream)localObject).close();
      paramArrayOfByte = new MessageImprint(new DigestInfo(this.digestCalculator.getAlgorithmIdentifier(), this.digestCalculator.getDigest()));
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to build MessageImprint: ");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      throw new DVCSException(((StringBuilder)localObject).toString(), paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\MessageImprintBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */