package org.bouncycastle.jce;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.KeyUsage;

public class X509KeyUsage
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
  private int usage = 0;
  
  public X509KeyUsage(int paramInt)
  {
    this.usage = paramInt;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new KeyUsage(this.usage).toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\X509KeyUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */