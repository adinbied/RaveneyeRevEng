package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class TargetInformation
  extends ASN1Object
{
  private ASN1Sequence targets;
  
  private TargetInformation(ASN1Sequence paramASN1Sequence)
  {
    this.targets = paramASN1Sequence;
  }
  
  public TargetInformation(Targets paramTargets)
  {
    this.targets = new DERSequence(paramTargets);
  }
  
  public TargetInformation(Target[] paramArrayOfTarget)
  {
    this(new Targets(paramArrayOfTarget));
  }
  
  public static TargetInformation getInstance(Object paramObject)
  {
    if ((paramObject instanceof TargetInformation)) {
      return (TargetInformation)paramObject;
    }
    if (paramObject != null) {
      return new TargetInformation(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public Targets[] getTargetsObjects()
  {
    Targets[] arrayOfTargets = new Targets[this.targets.size()];
    Enumeration localEnumeration = this.targets.getObjects();
    int i = 0;
    while (localEnumeration.hasMoreElements())
    {
      arrayOfTargets[i] = Targets.getInstance(localEnumeration.nextElement());
      i += 1;
    }
    return arrayOfTargets;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.targets;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\TargetInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */