package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class CertificateID
{
  public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
  private final CertID id;
  
  public CertificateID(CertID paramCertID)
  {
    if (paramCertID != null)
    {
      this.id = paramCertID;
      return;
    }
    throw new IllegalArgumentException("'id' cannot be null");
  }
  
  public CertificateID(DigestCalculator paramDigestCalculator, X509CertificateHolder paramX509CertificateHolder, BigInteger paramBigInteger)
    throws OCSPException
  {
    this.id = createCertID(paramDigestCalculator, paramX509CertificateHolder, new ASN1Integer(paramBigInteger));
  }
  
  private static CertID createCertID(DigestCalculator paramDigestCalculator, X509CertificateHolder paramX509CertificateHolder, ASN1Integer paramASN1Integer)
    throws OCSPException
  {
    try
    {
      Object localObject = paramDigestCalculator.getOutputStream();
      ((OutputStream)localObject).write(paramX509CertificateHolder.toASN1Structure().getSubject().getEncoded("DER"));
      ((OutputStream)localObject).close();
      localObject = new DEROctetString(paramDigestCalculator.getDigest());
      paramX509CertificateHolder = paramX509CertificateHolder.getSubjectPublicKeyInfo();
      OutputStream localOutputStream = paramDigestCalculator.getOutputStream();
      localOutputStream.write(paramX509CertificateHolder.getPublicKeyData().getBytes());
      localOutputStream.close();
      paramX509CertificateHolder = new DEROctetString(paramDigestCalculator.getDigest());
      paramDigestCalculator = new CertID(paramDigestCalculator.getAlgorithmIdentifier(), (ASN1OctetString)localObject, paramX509CertificateHolder, paramASN1Integer);
      return paramDigestCalculator;
    }
    catch (Exception paramDigestCalculator)
    {
      paramX509CertificateHolder = new StringBuilder();
      paramX509CertificateHolder.append("problem creating ID: ");
      paramX509CertificateHolder.append(paramDigestCalculator);
      throw new OCSPException(paramX509CertificateHolder.toString(), paramDigestCalculator);
    }
  }
  
  public static CertificateID deriveCertificateID(CertificateID paramCertificateID, BigInteger paramBigInteger)
  {
    return new CertificateID(new CertID(paramCertificateID.id.getHashAlgorithm(), paramCertificateID.id.getIssuerNameHash(), paramCertificateID.id.getIssuerKeyHash(), new ASN1Integer(paramBigInteger)));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof CertificateID)) {
      return false;
    }
    paramObject = (CertificateID)paramObject;
    return this.id.toASN1Primitive().equals(((CertificateID)paramObject).id.toASN1Primitive());
  }
  
  public ASN1ObjectIdentifier getHashAlgOID()
  {
    return this.id.getHashAlgorithm().getAlgorithm();
  }
  
  public byte[] getIssuerKeyHash()
  {
    return this.id.getIssuerKeyHash().getOctets();
  }
  
  public byte[] getIssuerNameHash()
  {
    return this.id.getIssuerNameHash().getOctets();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.id.getSerialNumber().getValue();
  }
  
  public int hashCode()
  {
    return this.id.toASN1Primitive().hashCode();
  }
  
  public boolean matchesIssuer(X509CertificateHolder paramX509CertificateHolder, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws OCSPException
  {
    try
    {
      boolean bool = createCertID(paramDigestCalculatorProvider.get(this.id.getHashAlgorithm()), paramX509CertificateHolder, this.id.getSerialNumber()).equals(this.id);
      return bool;
    }
    catch (OperatorCreationException paramX509CertificateHolder)
    {
      paramDigestCalculatorProvider = new StringBuilder();
      paramDigestCalculatorProvider.append("unable to create digest calculator: ");
      paramDigestCalculatorProvider.append(paramX509CertificateHolder.getMessage());
      throw new OCSPException(paramDigestCalculatorProvider.toString(), paramX509CertificateHolder);
    }
  }
  
  public CertID toASN1Primitive()
  {
    return this.id;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\CertificateID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */