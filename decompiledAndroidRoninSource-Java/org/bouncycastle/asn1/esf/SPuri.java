package org.bouncycastle.asn1.esf;

import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERIA5String;

public class SPuri
{
  private DERIA5String uri;
  
  public SPuri(DERIA5String paramDERIA5String)
  {
    this.uri = paramDERIA5String;
  }
  
  public static SPuri getInstance(Object paramObject)
  {
    if ((paramObject instanceof SPuri)) {
      return (SPuri)paramObject;
    }
    if ((paramObject instanceof DERIA5String)) {
      return new SPuri(DERIA5String.getInstance(paramObject));
    }
    return null;
  }
  
  public DERIA5String getUri()
  {
    return this.uri;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.uri.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\esf\SPuri.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */