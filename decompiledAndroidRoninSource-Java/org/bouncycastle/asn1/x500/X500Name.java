package org.bouncycastle.asn1.x500;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.style.BCStyle;

public class X500Name
  extends ASN1Object
  implements ASN1Choice
{
  private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
  private int hashCodeValue;
  private boolean isHashCodeCalculated;
  private RDN[] rdns;
  private X500NameStyle style;
  
  public X500Name(String paramString)
  {
    this(defaultStyle, paramString);
  }
  
  private X500Name(ASN1Sequence paramASN1Sequence)
  {
    this(defaultStyle, paramASN1Sequence);
  }
  
  public X500Name(X500NameStyle paramX500NameStyle, String paramString)
  {
    this(paramX500NameStyle.fromString(paramString));
    this.style = paramX500NameStyle;
  }
  
  private X500Name(X500NameStyle paramX500NameStyle, ASN1Sequence paramASN1Sequence)
  {
    this.style = paramX500NameStyle;
    this.rdns = new RDN[paramASN1Sequence.size()];
    paramX500NameStyle = paramASN1Sequence.getObjects();
    int i = 0;
    while (paramX500NameStyle.hasMoreElements())
    {
      this.rdns[i] = RDN.getInstance(paramX500NameStyle.nextElement());
      i += 1;
    }
  }
  
  public X500Name(X500NameStyle paramX500NameStyle, X500Name paramX500Name)
  {
    this.rdns = paramX500Name.rdns;
    this.style = paramX500NameStyle;
  }
  
  public X500Name(X500NameStyle paramX500NameStyle, RDN[] paramArrayOfRDN)
  {
    this.rdns = paramArrayOfRDN;
    this.style = paramX500NameStyle;
  }
  
  public X500Name(RDN[] paramArrayOfRDN)
  {
    this(defaultStyle, paramArrayOfRDN);
  }
  
  public static X500NameStyle getDefaultStyle()
  {
    return defaultStyle;
  }
  
  public static X500Name getInstance(Object paramObject)
  {
    if ((paramObject instanceof X500Name)) {
      return (X500Name)paramObject;
    }
    if (paramObject != null) {
      return new X500Name(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static X500Name getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, true));
  }
  
  public static X500Name getInstance(X500NameStyle paramX500NameStyle, Object paramObject)
  {
    if ((paramObject instanceof X500Name)) {
      return new X500Name(paramX500NameStyle, (X500Name)paramObject);
    }
    if (paramObject != null) {
      return new X500Name(paramX500NameStyle, ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static void setDefaultStyle(X500NameStyle paramX500NameStyle)
  {
    if (paramX500NameStyle != null)
    {
      defaultStyle = paramX500NameStyle;
      return;
    }
    throw new NullPointerException("cannot set style to null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((!(paramObject instanceof X500Name)) && (!(paramObject instanceof ASN1Sequence))) {
      return false;
    }
    ASN1Primitive localASN1Primitive = ((ASN1Encodable)paramObject).toASN1Primitive();
    if (toASN1Primitive().equals(localASN1Primitive)) {
      return true;
    }
    try
    {
      boolean bool = this.style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((ASN1Encodable)paramObject).toASN1Primitive())));
      return bool;
    }
    catch (Exception paramObject) {}
    return false;
  }
  
  public ASN1ObjectIdentifier[] getAttributeTypes()
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      localObject1 = this.rdns;
      if (i == localObject1.length) {
        break;
      }
      j += localObject1[i].size();
      i += 1;
    }
    Object localObject1 = new ASN1ObjectIdentifier[j];
    int k = 0;
    for (i = 0;; i = j)
    {
      Object localObject2 = this.rdns;
      if (k == localObject2.length) {
        break;
      }
      localObject2 = localObject2[k];
      if (((RDN)localObject2).isMultiValued())
      {
        localObject2 = ((RDN)localObject2).getTypesAndValues();
        int m = 0;
        for (;;)
        {
          j = i;
          if (m == localObject2.length) {
            break;
          }
          localObject1[i] = localObject2[m].getType();
          m += 1;
          i += 1;
        }
      }
      j = i;
      if (((RDN)localObject2).size() != 0)
      {
        localObject1[i] = ((RDN)localObject2).getFirst().getType();
        j = i + 1;
      }
      k += 1;
    }
    return (ASN1ObjectIdentifier[])localObject1;
  }
  
  public RDN[] getRDNs()
  {
    RDN[] arrayOfRDN1 = this.rdns;
    int i = arrayOfRDN1.length;
    RDN[] arrayOfRDN2 = new RDN[i];
    System.arraycopy(arrayOfRDN1, 0, arrayOfRDN2, 0, i);
    return arrayOfRDN2;
  }
  
  public RDN[] getRDNs(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    RDN[] arrayOfRDN = new RDN[this.rdns.length];
    int j = 0;
    int k;
    for (int i = 0;; i = k)
    {
      Object localObject = this.rdns;
      if (j == localObject.length) {
        break;
      }
      localObject = localObject[j];
      if (((RDN)localObject).isMultiValued())
      {
        AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = ((RDN)localObject).getTypesAndValues();
        int m = 0;
        for (;;)
        {
          k = i;
          if (m == arrayOfAttributeTypeAndValue.length) {
            break label138;
          }
          if (arrayOfAttributeTypeAndValue[m].getType().equals(paramASN1ObjectIdentifier))
          {
            k = i + 1;
            arrayOfRDN[i] = localObject;
            i = k;
            break;
          }
          m += 1;
        }
      }
      k = i;
      if (((RDN)localObject).getFirst().getType().equals(paramASN1ObjectIdentifier))
      {
        k = i + 1;
        arrayOfRDN[i] = localObject;
        i = k;
        k = i;
      }
      label138:
      j += 1;
    }
    paramASN1ObjectIdentifier = new RDN[i];
    System.arraycopy(arrayOfRDN, 0, paramASN1ObjectIdentifier, 0, i);
    return paramASN1ObjectIdentifier;
  }
  
  public int hashCode()
  {
    if (this.isHashCodeCalculated) {
      return this.hashCodeValue;
    }
    this.isHashCodeCalculated = true;
    int i = this.style.calculateHashCode(this);
    this.hashCodeValue = i;
    return i;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return new DERSequence(this.rdns);
  }
  
  public String toString()
  {
    return this.style.toString(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\x500\X500Name.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */