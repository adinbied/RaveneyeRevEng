package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class Targets
  extends ASN1Object
{
  private ASN1Sequence targets;
  
  private Targets(ASN1Sequence paramASN1Sequence)
  {
    this.targets = paramASN1Sequence;
  }
  
  public Targets(Target[] paramArrayOfTarget)
  {
    this.targets = new DERSequence(paramArrayOfTarget);
  }
  
  public static Targets getInstance(Object paramObject)
  {
    if ((paramObject instanceof Targets)) {
      return (Targets)paramObject;
    }
    if (paramObject != null) {
      return new Targets(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Target[] getTargets()
  {
    Target[] arrayOfTarget = new Target[this.targets.size()];
    Enumeration localEnumeration = this.targets.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfTarget[i] = Target.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfTarget;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.targets;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Targets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */