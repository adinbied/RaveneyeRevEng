package org.bouncycastle.asn1.x509;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class Extensions
  extends ASN1Object
{
  private Hashtable extensions = new Hashtable();
  private Vector ordering;
  
  private Extensions(ASN1Sequence paramASN1Sequence)
  {
    this.ordering = new Vector();
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      Extension localExtension = Extension.getInstance(paramASN1Sequence.nextElement());
      this.extensions.put(localExtension.getExtnId(), localExtension);
      this.ordering.addElement(localExtension.getExtnId());
    }
  }
  
  public Extensions(Extension paramExtension)
  {
    Vector localVector = new Vector();
    this.ordering = localVector;
    localVector.addElement(paramExtension.getExtnId());
    this.extensions.put(paramExtension.getExtnId(), paramExtension);
  }
  
  public Extensions(Extension[] paramArrayOfExtension)
  {
    this.ordering = new Vector();
    int i = 0;
    while (i != paramArrayOfExtension.length)
    {
      Extension localExtension = paramArrayOfExtension[i];
      this.ordering.addElement(localExtension.getExtnId());
      this.extensions.put(localExtension.getExtnId(), localExtension);
      i += 1;
    }
  }
  
  private ASN1ObjectIdentifier[] getExtensionOIDs(boolean paramBoolean)
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i != this.ordering.size())
    {
      Object localObject = this.ordering.elementAt(i);
      if (((Extension)this.extensions.get(localObject)).isCritical() == paramBoolean) {
        localVector.addElement(localObject);
      }
      i += 1;
    }
    return toOidArray(localVector);
  }
  
  public static Extensions getInstance(Object paramObject)
  {
    if ((paramObject instanceof Extensions)) {
      return (Extensions)paramObject;
    }
    if (paramObject != null) {
      return new Extensions(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static Extensions getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  private ASN1ObjectIdentifier[] toOidArray(Vector paramVector)
  {
    int j = paramVector.size();
    ASN1ObjectIdentifier[] arrayOfASN1ObjectIdentifier = new ASN1ObjectIdentifier[j];
    int i = 0;
    while (i != j)
    {
      arrayOfASN1ObjectIdentifier[i] = ((ASN1ObjectIdentifier)paramVector.elementAt(i));
      i += 1;
    }
    return arrayOfASN1ObjectIdentifier;
  }
  
  public boolean equivalent(Extensions paramExtensions)
  {
    if (this.extensions.size() != paramExtensions.extensions.size()) {
      return false;
    }
    Enumeration localEnumeration = this.extensions.keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject = localEnumeration.nextElement();
      if (!this.extensions.get(localObject).equals(paramExtensions.extensions.get(localObject))) {
        return false;
      }
    }
    return true;
  }
  
  public ASN1ObjectIdentifier[] getCriticalExtensionOIDs()
  {
    return getExtensionOIDs(true);
  }
  
  public Extension getExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return (Extension)this.extensions.get(paramASN1ObjectIdentifier);
  }
  
  public ASN1ObjectIdentifier[] getExtensionOIDs()
  {
    return toOidArray(this.ordering);
  }
  
  public ASN1Encodable getExtensionParsedValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    paramASN1ObjectIdentifier = getExtension(paramASN1ObjectIdentifier);
    if (paramASN1ObjectIdentifier != null) {
      return paramASN1ObjectIdentifier.getParsedValue();
    }
    return null;
  }
  
  public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs()
  {
    return getExtensionOIDs(false);
  }
  
  public Enumeration oids()
  {
    return this.ordering.elements();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Enumeration localEnumeration = this.ordering.elements();
    while (localEnumeration.hasMoreElements())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)localEnumeration.nextElement();
      localASN1EncodableVector.add((Extension)this.extensions.get(localASN1ObjectIdentifier));
    }
    return new DERSequence(localASN1EncodableVector);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\Extensions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */