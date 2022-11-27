package org.bouncycastle.cert.crmf;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.crmf.PKMACValue;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.MacCalculator;

class PKMACValueGenerator
{
  private PKMACBuilder builder;
  
  public PKMACValueGenerator(PKMACBuilder paramPKMACBuilder)
  {
    this.builder = paramPKMACBuilder;
  }
  
  public PKMACValue generate(char[] paramArrayOfChar, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws CRMFException
  {
    paramArrayOfChar = this.builder.build(paramArrayOfChar);
    OutputStream localOutputStream = paramArrayOfChar.getOutputStream();
    try
    {
      localOutputStream.write(paramSubjectPublicKeyInfo.getEncoded("DER"));
      localOutputStream.close();
      return new PKMACValue(paramArrayOfChar.getAlgorithmIdentifier(), new DERBitString(paramArrayOfChar.getMac()));
    }
    catch (IOException paramArrayOfChar)
    {
      paramSubjectPublicKeyInfo = new StringBuilder();
      paramSubjectPublicKeyInfo.append("exception encoding mac input: ");
      paramSubjectPublicKeyInfo.append(paramArrayOfChar.getMessage());
      throw new CRMFException(paramSubjectPublicKeyInfo.toString(), paramArrayOfChar);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKMACValueGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */