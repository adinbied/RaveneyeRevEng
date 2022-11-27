package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DERExternal
  extends ASN1Primitive
{
  private ASN1Primitive dataValueDescriptor;
  private ASN1ObjectIdentifier directReference;
  private int encoding;
  private ASN1Primitive externalContent;
  private ASN1Integer indirectReference;
  
  public DERExternal(ASN1EncodableVector paramASN1EncodableVector)
  {
    int j = 0;
    Object localObject2 = getObjFromVector(paramASN1EncodableVector, 0);
    Object localObject1 = localObject2;
    if ((localObject2 instanceof ASN1ObjectIdentifier))
    {
      this.directReference = ((ASN1ObjectIdentifier)localObject2);
      localObject1 = getObjFromVector(paramASN1EncodableVector, 1);
      j = 1;
    }
    int i = j;
    localObject2 = localObject1;
    if ((localObject1 instanceof ASN1Integer))
    {
      this.indirectReference = ((ASN1Integer)localObject1);
      i = j + 1;
      localObject2 = getObjFromVector(paramASN1EncodableVector, i);
    }
    j = i;
    localObject1 = localObject2;
    if (!(localObject2 instanceof ASN1TaggedObject))
    {
      this.dataValueDescriptor = ((ASN1Primitive)localObject2);
      j = i + 1;
      localObject1 = getObjFromVector(paramASN1EncodableVector, j);
    }
    if (paramASN1EncodableVector.size() == j + 1)
    {
      if ((localObject1 instanceof ASN1TaggedObject))
      {
        paramASN1EncodableVector = (ASN1TaggedObject)localObject1;
        setEncoding(paramASN1EncodableVector.getTagNo());
        this.externalContent = paramASN1EncodableVector.getObject();
        return;
      }
      throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    }
    throw new IllegalArgumentException("input vector too large");
  }
  
  public DERExternal(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Integer paramASN1Integer, ASN1Primitive paramASN1Primitive1, int paramInt, ASN1Primitive paramASN1Primitive2)
  {
    setDirectReference(paramASN1ObjectIdentifier);
    setIndirectReference(paramASN1Integer);
    setDataValueDescriptor(paramASN1Primitive1);
    setEncoding(paramInt);
    setExternalContent(paramASN1Primitive2.toASN1Primitive());
  }
  
  public DERExternal(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Integer paramASN1Integer, ASN1Primitive paramASN1Primitive, DERTaggedObject paramDERTaggedObject)
  {
    this(paramASN1ObjectIdentifier, paramASN1Integer, paramASN1Primitive, paramDERTaggedObject.getTagNo(), paramDERTaggedObject.toASN1Primitive());
  }
  
  private ASN1Primitive getObjFromVector(ASN1EncodableVector paramASN1EncodableVector, int paramInt)
  {
    if (paramASN1EncodableVector.size() > paramInt) {
      return paramASN1EncodableVector.get(paramInt).toASN1Primitive();
    }
    throw new IllegalArgumentException("too few objects in input vector");
  }
  
  private void setDataValueDescriptor(ASN1Primitive paramASN1Primitive)
  {
    this.dataValueDescriptor = paramASN1Primitive;
  }
  
  private void setDirectReference(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.directReference = paramASN1ObjectIdentifier;
  }
  
  private void setEncoding(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 2))
    {
      this.encoding = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid encoding value: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void setExternalContent(ASN1Primitive paramASN1Primitive)
  {
    this.externalContent = paramASN1Primitive;
  }
  
  private void setIndirectReference(ASN1Integer paramASN1Integer)
  {
    this.indirectReference = paramASN1Integer;
  }
  
  boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (!(paramASN1Primitive instanceof DERExternal)) {
      return false;
    }
    if (this == paramASN1Primitive) {
      return true;
    }
    paramASN1Primitive = (DERExternal)paramASN1Primitive;
    Object localObject1 = this.directReference;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = paramASN1Primitive.directReference;
      if ((localObject2 == null) || (!((ASN1ObjectIdentifier)localObject2).equals(localObject1))) {
        return false;
      }
    }
    localObject1 = this.indirectReference;
    if (localObject1 != null)
    {
      localObject2 = paramASN1Primitive.indirectReference;
      if ((localObject2 == null) || (!((ASN1Integer)localObject2).equals(localObject1))) {
        return false;
      }
    }
    localObject1 = this.dataValueDescriptor;
    if (localObject1 != null)
    {
      localObject2 = paramASN1Primitive.dataValueDescriptor;
      if ((localObject2 == null) || (!((ASN1Primitive)localObject2).equals(localObject1))) {
        return false;
      }
    }
    return this.externalContent.equals(paramASN1Primitive.externalContent);
  }
  
  void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = this.directReference;
    if (localObject != null) {
      localByteArrayOutputStream.write(((ASN1ObjectIdentifier)localObject).getEncoded("DER"));
    }
    localObject = this.indirectReference;
    if (localObject != null) {
      localByteArrayOutputStream.write(((ASN1Integer)localObject).getEncoded("DER"));
    }
    localObject = this.dataValueDescriptor;
    if (localObject != null) {
      localByteArrayOutputStream.write(((ASN1Primitive)localObject).getEncoded("DER"));
    }
    localByteArrayOutputStream.write(new DERTaggedObject(true, this.encoding, this.externalContent).getEncoded("DER"));
    paramASN1OutputStream.writeEncoded(32, 8, localByteArrayOutputStream.toByteArray());
  }
  
  int encodedLength()
    throws IOException
  {
    return getEncoded().length;
  }
  
  public ASN1Primitive getDataValueDescriptor()
  {
    return this.dataValueDescriptor;
  }
  
  public ASN1ObjectIdentifier getDirectReference()
  {
    return this.directReference;
  }
  
  public int getEncoding()
  {
    return this.encoding;
  }
  
  public ASN1Primitive getExternalContent()
  {
    return this.externalContent;
  }
  
  public ASN1Integer getIndirectReference()
  {
    return this.indirectReference;
  }
  
  public int hashCode()
  {
    Object localObject = this.directReference;
    if (localObject != null) {
      j = ((ASN1ObjectIdentifier)localObject).hashCode();
    } else {
      j = 0;
    }
    localObject = this.indirectReference;
    int i = j;
    if (localObject != null) {
      i = j ^ ((ASN1Integer)localObject).hashCode();
    }
    localObject = this.dataValueDescriptor;
    int j = i;
    if (localObject != null) {
      j = i ^ ((ASN1Primitive)localObject).hashCode();
    }
    return j ^ this.externalContent.hashCode();
  }
  
  boolean isConstructed()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERExternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */