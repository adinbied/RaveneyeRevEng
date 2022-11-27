package org.bouncycastle.asn1.eac;

import java.io.UnsupportedEncodingException;

public class CertificateHolderReference
{
  private static final String ReferenceEncoding = "ISO-8859-1";
  private String countryCode;
  private String holderMnemonic;
  private String sequenceNumber;
  
  public CertificateHolderReference(String paramString1, String paramString2, String paramString3)
  {
    this.countryCode = paramString1;
    this.holderMnemonic = paramString2;
    this.sequenceNumber = paramString3;
  }
  
  CertificateHolderReference(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "ISO-8859-1");
      this.countryCode = paramArrayOfByte.substring(0, 2);
      this.holderMnemonic = paramArrayOfByte.substring(2, paramArrayOfByte.length() - 5);
      this.sequenceNumber = paramArrayOfByte.substring(paramArrayOfByte.length() - 5);
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new IllegalStateException(paramArrayOfByte.toString());
    }
  }
  
  public String getCountryCode()
  {
    return this.countryCode;
  }
  
  public byte[] getEncoded()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.countryCode);
    ((StringBuilder)localObject).append(this.holderMnemonic);
    ((StringBuilder)localObject).append(this.sequenceNumber);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      localObject = ((String)localObject).getBytes("ISO-8859-1");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException(localUnsupportedEncodingException.toString());
    }
  }
  
  public String getHolderMnemonic()
  {
    return this.holderMnemonic;
  }
  
  public String getSequenceNumber()
  {
    return this.sequenceNumber;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\eac\CertificateHolderReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */