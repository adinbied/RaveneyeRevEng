package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.ObjectDigestInfo;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class AttributeCertificateHolder
  implements CertSelector, Selector
{
  final Holder holder;
  
  public AttributeCertificateHolder(int paramInt, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    this.holder = new Holder(new ObjectDigestInfo(paramInt, new ASN1ObjectIdentifier(paramString2), new AlgorithmIdentifier(new ASN1ObjectIdentifier(paramString1)), Arrays.clone(paramArrayOfByte)));
  }
  
  public AttributeCertificateHolder(X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    try
    {
      X509Principal localX509Principal = PrincipalUtil.getIssuerX509Principal(paramX509Certificate);
      this.holder = new Holder(new IssuerSerial(generateGeneralNames(localX509Principal), new ASN1Integer(paramX509Certificate.getSerialNumber())));
      return;
    }
    catch (Exception paramX509Certificate)
    {
      throw new CertificateParsingException(paramX509Certificate.getMessage());
    }
  }
  
  public AttributeCertificateHolder(X500Principal paramX500Principal)
  {
    this(X509Util.convertPrincipal(paramX500Principal));
  }
  
  public AttributeCertificateHolder(X500Principal paramX500Principal, BigInteger paramBigInteger)
  {
    this(X509Util.convertPrincipal(paramX500Principal), paramBigInteger);
  }
  
  AttributeCertificateHolder(ASN1Sequence paramASN1Sequence)
  {
    this.holder = Holder.getInstance(paramASN1Sequence);
  }
  
  public AttributeCertificateHolder(X509Principal paramX509Principal)
  {
    this.holder = new Holder(generateGeneralNames(paramX509Principal));
  }
  
  public AttributeCertificateHolder(X509Principal paramX509Principal, BigInteger paramBigInteger)
  {
    this.holder = new Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence(new GeneralName(paramX509Principal))), new ASN1Integer(paramBigInteger)));
  }
  
  private GeneralNames generateGeneralNames(X509Principal paramX509Principal)
  {
    return GeneralNames.getInstance(new DERSequence(new GeneralName(paramX509Principal)));
  }
  
  private Object[] getNames(GeneralName[] paramArrayOfGeneralName)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfGeneralName.length);
    int i = 0;
    for (;;)
    {
      if ((i == paramArrayOfGeneralName.length) || (paramArrayOfGeneralName[i].getTagNo() == 4)) {}
      try
      {
        localArrayList.add(new X500Principal(paramArrayOfGeneralName[i].getName().toASN1Primitive().getEncoded()));
      }
      catch (IOException paramArrayOfGeneralName)
      {
        for (;;) {}
      }
      throw new RuntimeException("badly formed Name object");
      i += 1;
    }
    return localArrayList.toArray(new Object[localArrayList.size()]);
  }
  
  private Principal[] getPrincipals(GeneralNames paramGeneralNames)
  {
    paramGeneralNames = getNames(paramGeneralNames.getNames());
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      if ((paramGeneralNames[i] instanceof Principal)) {
        localArrayList.add(paramGeneralNames[i]);
      }
      i += 1;
    }
    return (Principal[])localArrayList.toArray(new Principal[localArrayList.size()]);
  }
  
  private boolean matchesDN(X509Principal paramX509Principal, GeneralNames paramGeneralNames)
  {
    paramGeneralNames = paramGeneralNames.getNames();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      Object localObject = paramGeneralNames[i];
      if (((GeneralName)localObject).getTagNo() == 4) {}
      try
      {
        boolean bool = new X509Principal(((GeneralName)localObject).getName().toASN1Primitive().getEncoded()).equals(paramX509Principal);
        if (bool) {
          return true;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return false;
  }
  
  public Object clone()
  {
    return new AttributeCertificateHolder((ASN1Sequence)this.holder.toASN1Primitive());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof AttributeCertificateHolder)) {
      return false;
    }
    paramObject = (AttributeCertificateHolder)paramObject;
    return this.holder.equals(((AttributeCertificateHolder)paramObject).holder);
  }
  
  public String getDigestAlgorithm()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      return this.holder.getObjectDigestInfo().getDigestAlgorithm().getAlgorithm().getId();
    }
    return null;
  }
  
  public int getDigestedObjectType()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      return this.holder.getObjectDigestInfo().getDigestedObjectType().getValue().intValue();
    }
    return -1;
  }
  
  public Principal[] getEntityNames()
  {
    if (this.holder.getEntityName() != null) {
      return getPrincipals(this.holder.getEntityName());
    }
    return null;
  }
  
  public Principal[] getIssuer()
  {
    if (this.holder.getBaseCertificateID() != null) {
      return getPrincipals(this.holder.getBaseCertificateID().getIssuer());
    }
    return null;
  }
  
  public byte[] getObjectDigest()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
    }
    return null;
  }
  
  public String getOtherObjectTypeID()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
    }
    return null;
  }
  
  public BigInteger getSerialNumber()
  {
    if (this.holder.getBaseCertificateID() != null) {
      return this.holder.getBaseCertificateID().getSerial().getValue();
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.holder.hashCode();
  }
  
  public boolean match(Object paramObject)
  {
    if (!(paramObject instanceof X509Certificate)) {
      return false;
    }
    return match((Certificate)paramObject);
  }
  
  public boolean match(Certificate paramCertificate)
  {
    if (!(paramCertificate instanceof X509Certificate)) {
      return false;
    }
    Object localObject = (X509Certificate)paramCertificate;
    try
    {
      if (this.holder.getBaseCertificateID() != null)
      {
        if ((this.holder.getBaseCertificateID().getSerial().getValue().equals(((X509Certificate)localObject).getSerialNumber())) && (matchesDN(PrincipalUtil.getIssuerX509Principal((X509Certificate)localObject), this.holder.getBaseCertificateID().getIssuer()))) {
          return true;
        }
      }
      else
      {
        if ((this.holder.getEntityName() != null) && (matchesDN(PrincipalUtil.getSubjectX509Principal((X509Certificate)localObject), this.holder.getEntityName()))) {
          return true;
        }
        localObject = this.holder.getObjectDigestInfo();
        if (localObject != null)
        {
          localObject = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
          int i = getDigestedObjectType();
          if (i != 0)
          {
            if (i == 1) {
              ((MessageDigest)localObject).update(paramCertificate.getEncoded());
            }
          }
          else {
            ((MessageDigest)localObject).update(paramCertificate.getPublicKey().getEncoded());
          }
          boolean bool = Arrays.areEqual(((MessageDigest)localObject).digest(), getObjectDigest());
          if (bool) {}
        }
        return false;
      }
    }
    catch (CertificateEncodingException|Exception paramCertificate)
    {
      return false;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\AttributeCertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */