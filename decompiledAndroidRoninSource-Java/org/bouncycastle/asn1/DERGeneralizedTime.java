package org.bouncycastle.asn1;

import java.util.Date;

public class DERGeneralizedTime
  extends ASN1GeneralizedTime
{
  public DERGeneralizedTime(String paramString)
  {
    super(paramString);
  }
  
  public DERGeneralizedTime(Date paramDate)
  {
    super(paramDate);
  }
  
  DERGeneralizedTime(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERGeneralizedTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */