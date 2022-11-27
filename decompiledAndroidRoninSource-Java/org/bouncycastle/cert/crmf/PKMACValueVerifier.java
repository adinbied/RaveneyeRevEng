package org.bouncycastle.cert.crmf;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.cmp.PBMParameter;
import org.bouncycastle.asn1.crmf.PKMACValue;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.Arrays;

class PKMACValueVerifier
{
  private final PKMACBuilder builder;
  
  public PKMACValueVerifier(PKMACBuilder paramPKMACBuilder)
  {
    this.builder = paramPKMACBuilder;
  }
  
  public boolean isValid(PKMACValue paramPKMACValue, char[] paramArrayOfChar, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws CRMFException
  {
    this.builder.setParameters(PBMParameter.getInstance(paramPKMACValue.getAlgId().getParameters()));
    paramArrayOfChar = this.builder.build(paramArrayOfChar);
    OutputStream localOutputStream = paramArrayOfChar.getOutputStream();
    try
    {
      localOutputStream.write(paramSubjectPublicKeyInfo.getEncoded("DER"));
      localOutputStream.close();
      return Arrays.areEqual(paramArrayOfChar.getMac(), paramPKMACValue.getValue().getBytes());
    }
    catch (IOException paramPKMACValue)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("exception encoding mac input: ");
      paramArrayOfChar.append(paramPKMACValue.getMessage());
      throw new CRMFException(paramArrayOfChar.toString(), paramPKMACValue);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKMACValueVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */