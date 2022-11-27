package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.security.SignatureException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;

public class SignatureSpiLe
  extends SignatureSpi
{
  protected byte[] engineSign()
    throws SignatureException
  {
    byte[] arrayOfByte = ASN1OctetString.getInstance(super.engineSign()).getOctets();
    reverseBytes(arrayOfByte);
    try
    {
      arrayOfByte = new DEROctetString(arrayOfByte).getEncoded();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      throw new SignatureException(localException.toString());
    }
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    try
    {
      paramArrayOfByte = ((ASN1OctetString)ASN1OctetString.fromByteArray(paramArrayOfByte)).getOctets();
      reverseBytes(paramArrayOfByte);
      try
      {
        boolean bool = super.engineVerify(new DEROctetString(paramArrayOfByte).getEncoded());
        return bool;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new SignatureException(paramArrayOfByte.toString());
      }
      catch (SignatureException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new SignatureException("error decoding signature bytes.");
  }
  
  void reverseBytes(byte[] paramArrayOfByte)
  {
    int j = 0;
    while (j < paramArrayOfByte.length / 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(paramArrayOfByte.length - 1 - j)];
      paramArrayOfByte[(paramArrayOfByte.length - 1 - j)] = i;
      j += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\SignatureSpiLe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */