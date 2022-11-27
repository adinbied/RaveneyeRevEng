package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.DERBitString;

public class NetscapeCertType
  extends DERBitString
{
  public static final int objectSigning = 16;
  public static final int objectSigningCA = 1;
  public static final int reserved = 8;
  public static final int smime = 32;
  public static final int smimeCA = 2;
  public static final int sslCA = 4;
  public static final int sslClient = 128;
  public static final int sslServer = 64;
  
  public NetscapeCertType(int paramInt)
  {
    super(getBytes(paramInt), getPadBits(paramInt));
  }
  
  public NetscapeCertType(DERBitString paramDERBitString)
  {
    super(paramDERBitString.getBytes(), paramDERBitString.getPadBits());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetscapeCertType: 0x");
    localStringBuilder.append(Integer.toHexString(this.data[0] & 0xFF));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\misc\NetscapeCertType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */