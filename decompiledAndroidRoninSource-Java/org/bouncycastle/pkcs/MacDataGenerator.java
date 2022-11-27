package org.bouncycastle.pkcs;

import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.operator.MacCalculator;

class MacDataGenerator
{
  private PKCS12MacCalculatorBuilder builder;
  
  MacDataGenerator(PKCS12MacCalculatorBuilder paramPKCS12MacCalculatorBuilder)
  {
    this.builder = paramPKCS12MacCalculatorBuilder;
  }
  
  public MacData build(char[] paramArrayOfChar, byte[] paramArrayOfByte)
    throws PKCSException
  {
    try
    {
      paramArrayOfChar = this.builder.build(paramArrayOfChar);
      OutputStream localOutputStream = paramArrayOfChar.getOutputStream();
      localOutputStream.write(paramArrayOfByte);
      localOutputStream.close();
      paramArrayOfByte = paramArrayOfChar.getAlgorithmIdentifier();
      paramArrayOfChar = new DigestInfo(this.builder.getDigestAlgorithmIdentifier(), paramArrayOfChar.getMac());
      paramArrayOfByte = PKCS12PBEParams.getInstance(paramArrayOfByte.getParameters());
      return new MacData(paramArrayOfChar, paramArrayOfByte.getIV(), paramArrayOfByte.getIterations().intValue());
    }
    catch (Exception paramArrayOfChar)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("unable to process data: ");
      paramArrayOfByte.append(paramArrayOfChar.getMessage());
      throw new PKCSException(paramArrayOfByte.toString(), paramArrayOfChar);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\MacDataGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */