package org.bouncycastle.asn1.dvcs;

import java.util.Arrays;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class PathProcInput
  extends ASN1Object
{
  private PolicyInformation[] acceptablePolicySet;
  private boolean explicitPolicyReqd = false;
  private boolean inhibitAnyPolicy = false;
  private boolean inhibitPolicyMapping = false;
  
  public PathProcInput(PolicyInformation[] paramArrayOfPolicyInformation)
  {
    this.acceptablePolicySet = paramArrayOfPolicyInformation;
  }
  
  public PathProcInput(PolicyInformation[] paramArrayOfPolicyInformation, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.acceptablePolicySet = paramArrayOfPolicyInformation;
    this.inhibitPolicyMapping = paramBoolean1;
    this.explicitPolicyReqd = paramBoolean2;
    this.inhibitAnyPolicy = paramBoolean3;
  }
  
  private static PolicyInformation[] fromSequence(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    PolicyInformation[] arrayOfPolicyInformation = new PolicyInformation[j];
    int i = 0;
    while (i != j)
    {
      arrayOfPolicyInformation[i] = PolicyInformation.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfPolicyInformation;
  }
  
  public static PathProcInput getInstance(Object paramObject)
  {
    if ((paramObject instanceof PathProcInput)) {
      return (PathProcInput)paramObject;
    }
    if (paramObject != null)
    {
      paramObject = ASN1Sequence.getInstance(paramObject);
      PathProcInput localPathProcInput = new PathProcInput(fromSequence(ASN1Sequence.getInstance(((ASN1Sequence)paramObject).getObjectAt(0))));
      int i = 1;
      while (i < ((ASN1Sequence)paramObject).size())
      {
        Object localObject = ((ASN1Sequence)paramObject).getObjectAt(i);
        if ((localObject instanceof ASN1Boolean))
        {
          localPathProcInput.setInhibitPolicyMapping(ASN1Boolean.getInstance(localObject).isTrue());
        }
        else if ((localObject instanceof ASN1TaggedObject))
        {
          localObject = ASN1TaggedObject.getInstance(localObject);
          int j = ((ASN1TaggedObject)localObject).getTagNo();
          if (j != 0)
          {
            if (j == 1)
            {
              localPathProcInput.setInhibitAnyPolicy(ASN1Boolean.getInstance((ASN1TaggedObject)localObject, false).isTrue());
            }
            else
            {
              paramObject = new StringBuilder();
              ((StringBuilder)paramObject).append("Unknown tag encountered: ");
              ((StringBuilder)paramObject).append(((ASN1TaggedObject)localObject).getTagNo());
              throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
            }
          }
          else {
            localPathProcInput.setExplicitPolicyReqd(ASN1Boolean.getInstance((ASN1TaggedObject)localObject, false).isTrue());
          }
        }
        i += 1;
      }
      return localPathProcInput;
    }
    return null;
  }
  
  public static PathProcInput getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private void setExplicitPolicyReqd(boolean paramBoolean)
  {
    this.explicitPolicyReqd = paramBoolean;
  }
  
  private void setInhibitAnyPolicy(boolean paramBoolean)
  {
    this.inhibitAnyPolicy = paramBoolean;
  }
  
  private void setInhibitPolicyMapping(boolean paramBoolean)
  {
    this.inhibitPolicyMapping = paramBoolean;
  }
  
  public PolicyInformation[] getAcceptablePolicySet()
  {
    return this.acceptablePolicySet;
  }
  
  public boolean isExplicitPolicyReqd()
  {
    return this.explicitPolicyReqd;
  }
  
  public boolean isInhibitAnyPolicy()
  {
    return this.inhibitAnyPolicy;
  }
  
  public boolean isInhibitPolicyMapping()
  {
    return this.inhibitPolicyMapping;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
    int i = 0;
    for (;;)
    {
      PolicyInformation[] arrayOfPolicyInformation = this.acceptablePolicySet;
      if (i == arrayOfPolicyInformation.length) {
        break;
      }
      localASN1EncodableVector2.add(arrayOfPolicyInformation[i]);
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    boolean bool = this.inhibitPolicyMapping;
    if (bool) {
      localASN1EncodableVector1.add(ASN1Boolean.getInstance(bool));
    }
    bool = this.explicitPolicyReqd;
    if (bool) {
      localASN1EncodableVector1.add(new DERTaggedObject(false, 0, ASN1Boolean.getInstance(bool)));
    }
    bool = this.inhibitAnyPolicy;
    if (bool) {
      localASN1EncodableVector1.add(new DERTaggedObject(false, 1, ASN1Boolean.getInstance(bool)));
    }
    return new DERSequence(localASN1EncodableVector1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PathProcInput: {\nacceptablePolicySet: ");
    localStringBuilder.append(Arrays.asList(this.acceptablePolicySet));
    localStringBuilder.append("\n");
    localStringBuilder.append("inhibitPolicyMapping: ");
    localStringBuilder.append(this.inhibitPolicyMapping);
    localStringBuilder.append("\n");
    localStringBuilder.append("explicitPolicyReqd: ");
    localStringBuilder.append(this.explicitPolicyReqd);
    localStringBuilder.append("\n");
    localStringBuilder.append("inhibitAnyPolicy: ");
    localStringBuilder.append(this.inhibitAnyPolicy);
    localStringBuilder.append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\PathProcInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */