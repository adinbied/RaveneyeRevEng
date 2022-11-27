package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Extension;

public class ExtensionReq
  extends ASN1Object
{
  private final Extension[] extensions;
  
  private ExtensionReq(ASN1Sequence paramASN1Sequence)
  {
    this.extensions = new Extension[paramASN1Sequence.size()];
    int i = 0;
    while (i != paramASN1Sequence.size())
    {
      this.extensions[i] = Extension.getInstance(paramASN1Sequence.getObjectAt(i));
      i += 1;
    }
  }
  
  public ExtensionReq(Extension paramExtension)
  {
    this.extensions = new Extension[] { paramExtension };
  }
  
  public ExtensionReq(Extension[] paramArrayOfExtension)
  {
    this.extensions = Utils.clone(paramArrayOfExtension);
  }
  
  public static ExtensionReq getInstance(Object paramObject)
  {
    if ((paramObject instanceof ExtensionReq)) {
      return (ExtensionReq)paramObject;
    }
    if (paramObject != null) {
      return new ExtensionReq(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static ExtensionReq getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public Extension[] getExtensions()
  {
    return Utils.clone(this.extensions);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.extensions);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\ExtensionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */