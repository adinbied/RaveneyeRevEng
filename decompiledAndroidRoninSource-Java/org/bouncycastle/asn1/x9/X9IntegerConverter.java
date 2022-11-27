package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9IntegerConverter
{
  public int getByteLength(ECCurve paramECCurve)
  {
    return (paramECCurve.getFieldSize() + 7) / 8;
  }
  
  public int getByteLength(ECFieldElement paramECFieldElement)
  {
    return (paramECFieldElement.getFieldSize() + 7) / 8;
  }
  
  public byte[] integerToBytes(BigInteger paramBigInteger, int paramInt)
  {
    paramBigInteger = paramBigInteger.toByteArray();
    byte[] arrayOfByte;
    if (paramInt < paramBigInteger.length)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, paramBigInteger.length - paramInt, arrayOfByte, 0, paramInt);
      return arrayOfByte;
    }
    if (paramInt > paramBigInteger.length)
    {
      arrayOfByte = new byte[paramInt];
      System.arraycopy(paramBigInteger, 0, arrayOfByte, paramInt - paramBigInteger.length, paramBigInteger.length);
      return arrayOfByte;
    }
    return paramBigInteger;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9IntegerConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */