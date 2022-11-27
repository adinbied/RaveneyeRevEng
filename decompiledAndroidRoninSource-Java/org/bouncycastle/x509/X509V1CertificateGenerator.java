package org.bouncycastle.x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V1TBSCertificateGenerator;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;

public class X509V1CertificateGenerator
{
  private final JcaJceHelper bcHelper = new BCJcaJceHelper();
  private final CertificateFactory certificateFactory = new CertificateFactory();
  private AlgorithmIdentifier sigAlgId;
  private ASN1ObjectIdentifier sigOID;
  private String signatureAlgorithm;
  private V1TBSCertificateGenerator tbsGen = new V1TBSCertificateGenerator();
  
  private X509Certificate generateJcaObject(TBSCertificate paramTBSCertificate, byte[] paramArrayOfByte)
    throws CertificateEncodingException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramTBSCertificate);
    localASN1EncodableVector.add(this.sigAlgId);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    try
    {
      paramTBSCertificate = (X509Certificate)this.certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(localASN1EncodableVector).getEncoded("DER")));
      return paramTBSCertificate;
    }
    catch (Exception paramTBSCertificate)
    {
      throw new ExtCertificateEncodingException("exception producing certificate object", paramTBSCertificate);
    }
  }
  
  public X509Certificate generate(PrivateKey paramPrivateKey)
    throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    return generate(paramPrivateKey, (SecureRandom)null);
  }
  
  public X509Certificate generate(PrivateKey paramPrivateKey, String paramString)
    throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    return generate(paramPrivateKey, paramString, null);
  }
  
  public X509Certificate generate(PrivateKey paramPrivateKey, String paramString, SecureRandom paramSecureRandom)
    throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    TBSCertificate localTBSCertificate = this.tbsGen.generateTBSCertificate();
    try
    {
      paramPrivateKey = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, paramString, paramPrivateKey, paramSecureRandom, localTBSCertificate);
      return generateJcaObject(localTBSCertificate, paramPrivateKey);
    }
    catch (IOException paramPrivateKey)
    {
      throw new ExtCertificateEncodingException("exception encoding TBS cert", paramPrivateKey);
    }
  }
  
  public X509Certificate generate(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    TBSCertificate localTBSCertificate = this.tbsGen.generateTBSCertificate();
    try
    {
      paramPrivateKey = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, paramPrivateKey, paramSecureRandom, localTBSCertificate);
      return generateJcaObject(localTBSCertificate, paramPrivateKey);
    }
    catch (IOException paramPrivateKey)
    {
      throw new ExtCertificateEncodingException("exception encoding TBS cert", paramPrivateKey);
    }
  }
  
  public X509Certificate generateX509Certificate(PrivateKey paramPrivateKey)
    throws SecurityException, SignatureException, InvalidKeyException
  {
    try
    {
      paramPrivateKey = generateX509Certificate(paramPrivateKey, "BC", null);
      return paramPrivateKey;
    }
    catch (NoSuchProviderException paramPrivateKey)
    {
      for (;;) {}
    }
    throw new SecurityException("BC provider not installed!");
  }
  
  public X509Certificate generateX509Certificate(PrivateKey paramPrivateKey, String paramString)
    throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException
  {
    return generateX509Certificate(paramPrivateKey, paramString, null);
  }
  
  public X509Certificate generateX509Certificate(PrivateKey paramPrivateKey, String paramString, SecureRandom paramSecureRandom)
    throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException
  {
    try
    {
      paramPrivateKey = generate(paramPrivateKey, paramString, paramSecureRandom);
      return paramPrivateKey;
    }
    catch (GeneralSecurityException paramPrivateKey)
    {
      paramString = new StringBuilder();
      paramString.append("exception: ");
      paramString.append(paramPrivateKey);
      throw new SecurityException(paramString.toString());
    }
    catch (InvalidKeyException paramPrivateKey)
    {
      throw paramPrivateKey;
    }
    catch (SignatureException paramPrivateKey)
    {
      throw paramPrivateKey;
    }
    catch (NoSuchProviderException paramPrivateKey)
    {
      throw paramPrivateKey;
    }
  }
  
  public X509Certificate generateX509Certificate(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws SecurityException, SignatureException, InvalidKeyException
  {
    try
    {
      paramPrivateKey = generateX509Certificate(paramPrivateKey, "BC", paramSecureRandom);
      return paramPrivateKey;
    }
    catch (NoSuchProviderException paramPrivateKey)
    {
      for (;;) {}
    }
    throw new SecurityException("BC provider not installed!");
  }
  
  public Iterator getSignatureAlgNames()
  {
    return X509Util.getAlgNames();
  }
  
  public void reset()
  {
    this.tbsGen = new V1TBSCertificateGenerator();
  }
  
  public void setIssuerDN(X500Principal paramX500Principal)
  {
    try
    {
      this.tbsGen.setIssuer(new X509Principal(paramX500Principal.getEncoded()));
      return;
    }
    catch (IOException paramX500Principal)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can't process principal: ");
      localStringBuilder.append(paramX500Principal);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public void setIssuerDN(X509Name paramX509Name)
  {
    this.tbsGen.setIssuer(paramX509Name);
  }
  
  public void setNotAfter(Date paramDate)
  {
    this.tbsGen.setEndDate(new Time(paramDate));
  }
  
  public void setNotBefore(Date paramDate)
  {
    this.tbsGen.setStartDate(new Time(paramDate));
  }
  
  public void setPublicKey(PublicKey paramPublicKey)
  {
    try
    {
      this.tbsGen.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()));
      return;
    }
    catch (Exception paramPublicKey)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to process key - ");
      localStringBuilder.append(paramPublicKey.toString());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public void setSerialNumber(BigInteger paramBigInteger)
  {
    if (paramBigInteger.compareTo(BigInteger.ZERO) > 0)
    {
      this.tbsGen.setSerialNumber(new ASN1Integer(paramBigInteger));
      return;
    }
    throw new IllegalArgumentException("serial number must be a positive integer");
  }
  
  public void setSignatureAlgorithm(String paramString)
  {
    this.signatureAlgorithm = paramString;
    try
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = X509Util.getAlgorithmOID(paramString);
      this.sigOID = localASN1ObjectIdentifier;
      paramString = X509Util.getSigAlgID(localASN1ObjectIdentifier, paramString);
      this.sigAlgId = paramString;
      this.tbsGen.setSignature(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Unknown signature type requested");
  }
  
  public void setSubjectDN(X500Principal paramX500Principal)
  {
    try
    {
      this.tbsGen.setSubject(new X509Principal(paramX500Principal.getEncoded()));
      return;
    }
    catch (IOException paramX500Principal)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("can't process principal: ");
      localStringBuilder.append(paramX500Principal);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public void setSubjectDN(X509Name paramX509Name)
  {
    this.tbsGen.setSubject(paramX509Name);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509V1CertificateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */