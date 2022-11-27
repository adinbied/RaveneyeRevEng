package org.bouncycastle.cert;

import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.ObjectDigestInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class AttributeCertificateHolder
  implements Selector
{
  private static DigestCalculatorProvider digestCalculatorProvider;
  final Holder holder;
  
  public AttributeCertificateHolder(int paramInt, ASN1ObjectIdentifier paramASN1ObjectIdentifier1, ASN1ObjectIdentifier paramASN1ObjectIdentifier2, byte[] paramArrayOfByte)
  {
    this.holder = new Holder(new ObjectDigestInfo(paramInt, paramASN1ObjectIdentifier2, new AlgorithmIdentifier(paramASN1ObjectIdentifier1), Arrays.clone(paramArrayOfByte)));
  }
  
  AttributeCertificateHolder(ASN1Sequence paramASN1Sequence)
  {
    this.holder = Holder.getInstance(paramASN1Sequence);
  }
  
  public AttributeCertificateHolder(X500Name paramX500Name)
  {
    this.holder = new Holder(generateGeneralNames(paramX500Name));
  }
  
  public AttributeCertificateHolder(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this.holder = new Holder(new IssuerSerial(generateGeneralNames(paramX500Name), new ASN1Integer(paramBigInteger)));
  }
  
  public AttributeCertificateHolder(X509CertificateHolder paramX509CertificateHolder)
  {
    this.holder = new Holder(new IssuerSerial(generateGeneralNames(paramX509CertificateHolder.getIssuer()), new ASN1Integer(paramX509CertificateHolder.getSerialNumber())));
  }
  
  private GeneralNames generateGeneralNames(X500Name paramX500Name)
  {
    return new GeneralNames(new GeneralName(paramX500Name));
  }
  
  private X500Name[] getPrincipals(GeneralName[] paramArrayOfGeneralName)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfGeneralName.length);
    int i = 0;
    while (i != paramArrayOfGeneralName.length)
    {
      if (paramArrayOfGeneralName[i].getTagNo() == 4) {
        localArrayList.add(X500Name.getInstance(paramArrayOfGeneralName[i].getName()));
      }
      i += 1;
    }
    return (X500Name[])localArrayList.toArray(new X500Name[localArrayList.size()]);
  }
  
  private boolean matchesDN(X500Name paramX500Name, GeneralNames paramGeneralNames)
  {
    paramGeneralNames = paramGeneralNames.getNames();
    int i = 0;
    while (i != paramGeneralNames.length)
    {
      Object localObject = paramGeneralNames[i];
      if ((((GeneralName)localObject).getTagNo() == 4) && (X500Name.getInstance(((GeneralName)localObject).getName()).equals(paramX500Name))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void setDigestCalculatorProvider(DigestCalculatorProvider paramDigestCalculatorProvider)
  {
    digestCalculatorProvider = paramDigestCalculatorProvider;
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
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      return this.holder.getObjectDigestInfo().getDigestAlgorithm();
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
  
  public X500Name[] getEntityNames()
  {
    if (this.holder.getEntityName() != null) {
      return getPrincipals(this.holder.getEntityName().getNames());
    }
    return null;
  }
  
  public X500Name[] getIssuer()
  {
    if (this.holder.getBaseCertificateID() != null) {
      return getPrincipals(this.holder.getBaseCertificateID().getIssuer().getNames());
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
  
  public ASN1ObjectIdentifier getOtherObjectTypeID()
  {
    if (this.holder.getObjectDigestInfo() != null) {
      new ASN1ObjectIdentifier(this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId());
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
    boolean bool1 = paramObject instanceof X509CertificateHolder;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (X509CertificateHolder)paramObject;
    if (this.holder.getBaseCertificateID() != null)
    {
      bool1 = bool2;
      if (this.holder.getBaseCertificateID().getSerial().getValue().equals(((X509CertificateHolder)paramObject).getSerialNumber()))
      {
        bool1 = bool2;
        if (matchesDN(((X509CertificateHolder)paramObject).getIssuer(), this.holder.getBaseCertificateID().getIssuer())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if ((this.holder.getEntityName() != null) && (matchesDN(((X509CertificateHolder)paramObject).getSubject(), this.holder.getEntityName()))) {
      return true;
    }
    if (this.holder.getObjectDigestInfo() != null) {}
    try
    {
      DigestCalculator localDigestCalculator = digestCalculatorProvider.get(this.holder.getObjectDigestInfo().getDigestAlgorithm());
      OutputStream localOutputStream = localDigestCalculator.getOutputStream();
      int i = getDigestedObjectType();
      if (i != 0)
      {
        if (i == 1) {
          localOutputStream.write(((X509CertificateHolder)paramObject).getEncoded());
        }
      }
      else {
        localOutputStream.write(((X509CertificateHolder)paramObject).getSubjectPublicKeyInfo().getEncoded());
      }
      localOutputStream.close();
      bool1 = Arrays.areEqual(localDigestCalculator.getDigest(), getObjectDigest());
      if (!bool1) {}
      return false;
    }
    catch (Exception paramObject) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\AttributeCertificateHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */