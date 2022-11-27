package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;

public class KeyUsage
  extends ASN1Object
{
  public static final int cRLSign = 2;
  public static final int dataEncipherment = 16;
  public static final int decipherOnly = 32768;
  public static final int digitalSignature = 128;
  public static final int encipherOnly = 1;
  public static final int keyAgreement = 8;
  public static final int keyCertSign = 4;
  public static final int keyEncipherment = 32;
  public static final int nonRepudiation = 64;
  private DERBitString bitString;
  
  public KeyUsage(int paramInt)
  {
    this.bitString = new DERBitString(paramInt);
  }
  
  private KeyUsage(DERBitString paramDERBitString)
  {
    this.bitString = paramDERBitString;
  }
  
  public static KeyUsage fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.keyUsage));
  }
  
  public static KeyUsage getInstance(Object paramObject)
  {
    if ((paramObject instanceof KeyUsage)) {
      return (KeyUsage)paramObject;
    }
    if (paramObject != null) {
      return new KeyUsage(DERBitString.getInstance(paramObject));
    }
    return null;
  }
  
  public byte[] getBytes()
  {
    return this.bitString.getBytes();
  }
  
  public int getPadBits()
  {
    return this.bitString.getPadBits();
  }
  
  public boolean hasUsages(int paramInt)
  {
    return (this.bitString.intValue() & paramInt) == paramInt;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.bitString;
  }
  
  public String toString()
  {
    byte[] arrayOfByte = this.bitString.getBytes();
    StringBuilder localStringBuilder;
    if (arrayOfByte.length == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyUsage: 0x");
    }
    for (int i = arrayOfByte[0] & 0xFF;; i = arrayOfByte[0] & 0xFF | (i & 0xFF) << 8)
    {
      localStringBuilder.append(Integer.toHexString(i));
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KeyUsage: 0x");
      i = arrayOfByte[1];
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\KeyUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */