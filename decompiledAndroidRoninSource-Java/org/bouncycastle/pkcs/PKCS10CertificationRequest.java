package org.bouncycastle.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;

public class PKCS10CertificationRequest
{
  private static Attribute[] EMPTY_ARRAY = new Attribute[0];
  private CertificationRequest certificationRequest;
  
  public PKCS10CertificationRequest(CertificationRequest paramCertificationRequest)
  {
    this.certificationRequest = paramCertificationRequest;
  }
  
  public PKCS10CertificationRequest(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static CertificationRequest parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = CertificationRequest.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof PKCS10CertificationRequest)) {
      return false;
    }
    paramObject = (PKCS10CertificationRequest)paramObject;
    return toASN1Structure().equals(((PKCS10CertificationRequest)paramObject).toASN1Structure());
  }
  
  public Attribute[] getAttributes()
  {
    ASN1Set localASN1Set = this.certificationRequest.getCertificationRequestInfo().getAttributes();
    if (localASN1Set == null) {
      return EMPTY_ARRAY;
    }
    Attribute[] arrayOfAttribute = new Attribute[localASN1Set.size()];
    int i = 0;
    while (i != localASN1Set.size())
    {
      arrayOfAttribute[i] = Attribute.getInstance(localASN1Set.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttribute;
  }
  
  public Attribute[] getAttributes(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    ASN1Set localASN1Set = this.certificationRequest.getCertificationRequestInfo().getAttributes();
    if (localASN1Set == null) {
      return EMPTY_ARRAY;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != localASN1Set.size())
    {
      Attribute localAttribute = Attribute.getInstance(localASN1Set.getObjectAt(i));
      if (localAttribute.getAttrType().equals(paramASN1ObjectIdentifier)) {
        localArrayList.add(localAttribute);
      }
      i += 1;
    }
    if (localArrayList.size() == 0) {
      return EMPTY_ARRAY;
    }
    return (Attribute[])localArrayList.toArray(new Attribute[localArrayList.size()]);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.certificationRequest.getEncoded();
  }
  
  public byte[] getSignature()
  {
    return this.certificationRequest.getSignature().getOctets();
  }
  
  public AlgorithmIdentifier getSignatureAlgorithm()
  {
    return this.certificationRequest.getSignatureAlgorithm();
  }
  
  public X500Name getSubject()
  {
    return X500Name.getInstance(this.certificationRequest.getCertificationRequestInfo().getSubject());
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.certificationRequest.getCertificationRequestInfo().getSubjectPublicKeyInfo();
  }
  
  public int hashCode()
  {
    return toASN1Structure().hashCode();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws PKCSException
  {
    Object localObject = this.certificationRequest.getCertificationRequestInfo();
    try
    {
      paramContentVerifierProvider = paramContentVerifierProvider.get(this.certificationRequest.getSignatureAlgorithm());
      OutputStream localOutputStream = paramContentVerifierProvider.getOutputStream();
      localOutputStream.write(((CertificationRequestInfo)localObject).getEncoded("DER"));
      localOutputStream.close();
      return paramContentVerifierProvider.verify(getSignature());
    }
    catch (Exception paramContentVerifierProvider)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to process signature: ");
      ((StringBuilder)localObject).append(paramContentVerifierProvider.getMessage());
      throw new PKCSException(((StringBuilder)localObject).toString(), paramContentVerifierProvider);
    }
  }
  
  public CertificationRequest toASN1Structure()
  {
    return this.certificationRequest;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS10CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */