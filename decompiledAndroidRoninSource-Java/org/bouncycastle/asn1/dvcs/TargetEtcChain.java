package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class TargetEtcChain
  extends ASN1Object
{
  private ASN1Sequence chain;
  private PathProcInput pathProcInput;
  private CertEtcToken target;
  
  private TargetEtcChain(ASN1Sequence paramASN1Sequence)
  {
    this.target = CertEtcToken.getInstance(paramASN1Sequence.getObjectAt(0));
    if (paramASN1Sequence.size() > 1)
    {
      ASN1Encodable localASN1Encodable = paramASN1Sequence.getObjectAt(1);
      if ((localASN1Encodable instanceof ASN1TaggedObject))
      {
        extractPathProcInput(localASN1Encodable);
        return;
      }
      this.chain = ASN1Sequence.getInstance(localASN1Encodable);
      if (paramASN1Sequence.size() > 2) {
        extractPathProcInput(paramASN1Sequence.getObjectAt(2));
      }
    }
  }
  
  public TargetEtcChain(CertEtcToken paramCertEtcToken)
  {
    this(paramCertEtcToken, null, null);
  }
  
  public TargetEtcChain(CertEtcToken paramCertEtcToken, PathProcInput paramPathProcInput)
  {
    this(paramCertEtcToken, null, paramPathProcInput);
  }
  
  public TargetEtcChain(CertEtcToken paramCertEtcToken, CertEtcToken[] paramArrayOfCertEtcToken)
  {
    this(paramCertEtcToken, paramArrayOfCertEtcToken, null);
  }
  
  public TargetEtcChain(CertEtcToken paramCertEtcToken, CertEtcToken[] paramArrayOfCertEtcToken, PathProcInput paramPathProcInput)
  {
    this.target = paramCertEtcToken;
    if (paramArrayOfCertEtcToken != null) {
      this.chain = new DERSequence(paramArrayOfCertEtcToken);
    }
    this.pathProcInput = paramPathProcInput;
  }
  
  public static TargetEtcChain[] arrayFromSequence(ASN1Sequence paramASN1Sequence)
  {
    int j = paramASN1Sequence.size();
    TargetEtcChain[] arrayOfTargetEtcChain = new TargetEtcChain[j];
    int i = 0;
    while (i != j)
    {
      arrayOfTargetEtcChain[i] = getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfTargetEtcChain;
  }
  
  private void extractPathProcInput(ASN1Encodable paramASN1Encodable)
  {
    paramASN1Encodable = ASN1TaggedObject.getInstance(paramASN1Encodable);
    if (paramASN1Encodable.getTagNo() == 0)
    {
      this.pathProcInput = PathProcInput.getInstance(paramASN1Encodable, false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown tag encountered: ");
    localStringBuilder.append(paramASN1Encodable.getTagNo());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static TargetEtcChain getInstance(Object paramObject)
  {
    if ((paramObject instanceof TargetEtcChain)) {
      return (TargetEtcChain)paramObject;
    }
    if (paramObject != null) {
      return new TargetEtcChain(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static TargetEtcChain getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public CertEtcToken[] getChain()
  {
    ASN1Sequence localASN1Sequence = this.chain;
    if (localASN1Sequence != null) {
      return CertEtcToken.arrayFromSequence(localASN1Sequence);
    }
    return null;
  }
  
  public PathProcInput getPathProcInput()
  {
    return this.pathProcInput;
  }
  
  public CertEtcToken getTarget()
  {
    return this.target;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(this.target);
    Object localObject = this.chain;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.pathProcInput;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("TargetEtcChain {\n");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("target: ");
    localStringBuilder.append(this.target);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    if (this.chain != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("chain: ");
      localStringBuilder.append(this.chain);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.pathProcInput != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pathProcInput: ");
      localStringBuilder.append(this.pathProcInput);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append("}\n");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\TargetEtcChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */