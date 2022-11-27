package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

public class AuthorityKeyIdentifier
  extends ASN1Object
{
  GeneralNames certissuer;
  ASN1Integer certserno;
  ASN1OctetString keyidentifier;
  
  protected AuthorityKeyIdentifier(ASN1Sequence paramASN1Sequence)
  {
    this.keyidentifier = null;
    this.certissuer = null;
    this.certserno = null;
    paramASN1Sequence = paramASN1Sequence.getObjects();
    while (paramASN1Sequence.hasMoreElements())
    {
      ASN1TaggedObject localASN1TaggedObject = DERTaggedObject.getInstance(paramASN1Sequence.nextElement());
      int i = localASN1TaggedObject.getTagNo();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.certserno = ASN1Integer.getInstance(localASN1TaggedObject, false);
          } else {
            throw new IllegalArgumentException("illegal tag");
          }
        }
        else {
          this.certissuer = GeneralNames.getInstance(localASN1TaggedObject, false);
        }
      }
      else {
        this.keyidentifier = ASN1OctetString.getInstance(localASN1TaggedObject, false);
      }
    }
  }
  
  public AuthorityKeyIdentifier(GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    this((byte[])null, paramGeneralNames, paramBigInteger);
  }
  
  public AuthorityKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.keyidentifier = null;
    this.certissuer = null;
    this.certserno = null;
    SHA1Digest localSHA1Digest = new SHA1Digest();
    byte[] arrayOfByte = new byte[localSHA1Digest.getDigestSize()];
    paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    localSHA1Digest.update(paramSubjectPublicKeyInfo, 0, paramSubjectPublicKeyInfo.length);
    localSHA1Digest.doFinal(arrayOfByte, 0);
    this.keyidentifier = new DEROctetString(arrayOfByte);
  }
  
  public AuthorityKeyIdentifier(SubjectPublicKeyInfo paramSubjectPublicKeyInfo, GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    this.keyidentifier = null;
    this.certissuer = null;
    this.certserno = null;
    SHA1Digest localSHA1Digest = new SHA1Digest();
    byte[] arrayOfByte = new byte[localSHA1Digest.getDigestSize()];
    paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    localSHA1Digest.update(paramSubjectPublicKeyInfo, 0, paramSubjectPublicKeyInfo.length);
    localSHA1Digest.doFinal(arrayOfByte, 0);
    this.keyidentifier = new DEROctetString(arrayOfByte);
    this.certissuer = GeneralNames.getInstance(paramGeneralNames.toASN1Primitive());
    this.certserno = new ASN1Integer(paramBigInteger);
  }
  
  public AuthorityKeyIdentifier(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, null, null);
  }
  
  public AuthorityKeyIdentifier(byte[] paramArrayOfByte, GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    Object localObject = null;
    this.keyidentifier = null;
    this.certissuer = null;
    this.certserno = null;
    if (paramArrayOfByte != null) {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte);
    } else {
      paramArrayOfByte = null;
    }
    this.keyidentifier = paramArrayOfByte;
    this.certissuer = paramGeneralNames;
    paramArrayOfByte = (byte[])localObject;
    if (paramBigInteger != null) {
      paramArrayOfByte = new ASN1Integer(paramBigInteger);
    }
    this.certserno = paramArrayOfByte;
  }
  
  public static AuthorityKeyIdentifier fromExtensions(Extensions paramExtensions)
  {
    return getInstance(paramExtensions.getExtensionParsedValue(Extension.authorityKeyIdentifier));
  }
  
  public static AuthorityKeyIdentifier getInstance(Object paramObject)
  {
    if ((paramObject instanceof AuthorityKeyIdentifier)) {
      return (AuthorityKeyIdentifier)paramObject;
    }
    if (paramObject != null) {
      return new AuthorityKeyIdentifier(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static AuthorityKeyIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralNames getAuthorityCertIssuer()
  {
    return this.certissuer;
  }
  
  public BigInteger getAuthorityCertSerialNumber()
  {
    ASN1Integer localASN1Integer = this.certserno;
    if (localASN1Integer != null) {
      return localASN1Integer.getValue();
    }
    return null;
  }
  
  public byte[] getKeyIdentifier()
  {
    ASN1OctetString localASN1OctetString = this.keyidentifier;
    if (localASN1OctetString != null) {
      return localASN1OctetString.getOctets();
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = this.keyidentifier;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable)localObject));
    }
    localObject = this.certissuer;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable)localObject));
    }
    localObject = this.certserno;
    if (localObject != null) {
      localASN1EncodableVector.add(new DERTaggedObject(false, 2, (ASN1Encodable)localObject));
    }
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AuthorityKeyIdentifier: KeyID(");
    localStringBuilder.append(this.keyidentifier.getOctets());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\AuthorityKeyIdentifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */