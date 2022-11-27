package org.bouncycastle.asn1.isismtt.x509;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x500.DirectoryString;

public class Restriction
  extends ASN1Object
{
  private DirectoryString restriction;
  
  public Restriction(String paramString)
  {
    this.restriction = new DirectoryString(paramString);
  }
  
  private Restriction(DirectoryString paramDirectoryString)
  {
    this.restriction = paramDirectoryString;
  }
  
  public static Restriction getInstance(Object paramObject)
  {
    if ((paramObject instanceof Restriction)) {
      return (Restriction)paramObject;
    }
    if (paramObject != null) {
      return new Restriction(DirectoryString.getInstance(paramObject));
    }
    return null;
  }
  
  public DirectoryString getRestriction()
  {
    return this.restriction;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.restriction.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\isismtt\x509\Restriction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */