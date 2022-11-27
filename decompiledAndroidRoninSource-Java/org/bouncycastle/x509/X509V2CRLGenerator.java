package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V2TBSCertListGenerator;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.jce.provider.X509CRLObject;

public class X509V2CRLGenerator
{
  private final JcaJceHelper bcHelper = new BCJcaJceHelper();
  private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
  private AlgorithmIdentifier sigAlgId;
  private ASN1ObjectIdentifier sigOID;
  private String signatureAlgorithm;
  private V2TBSCertListGenerator tbsGen = new V2TBSCertListGenerator();
  
  private TBSCertList generateCertList()
  {
    if (!this.extGenerator.isEmpty()) {
      this.tbsGen.setExtensions(this.extGenerator.generate());
    }
    return this.tbsGen.generateTBSCertList();
  }
  
  private X509CRL generateJcaObject(TBSCertList paramTBSCertList, byte[] paramArrayOfByte)
    throws CRLException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramTBSCertList);
    localASN1EncodableVector.add(this.sigAlgId);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    return new X509CRLObject(new CertificateList(new DERSequence(localASN1EncodableVector)));
  }
  
  public void addCRL(X509CRL paramX509CRL)
    throws CRLException
  {
    paramX509CRL = paramX509CRL.getRevokedCertificates();
    if (paramX509CRL != null)
    {
      paramX509CRL = paramX509CRL.iterator();
      while (paramX509CRL.hasNext())
      {
        Object localObject = new ASN1InputStream(((X509CRLEntry)paramX509CRL.next()).getEncoded());
        try
        {
          this.tbsGen.addCRLEntry(ASN1Sequence.getInstance(((ASN1InputStream)localObject).readObject()));
        }
        catch (IOException paramX509CRL)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exception processing encoding of CRL: ");
          ((StringBuilder)localObject).append(paramX509CRL.toString());
          throw new CRLException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void addCRLEntry(BigInteger paramBigInteger, Date paramDate, int paramInt)
  {
    this.tbsGen.addCRLEntry(new ASN1Integer(paramBigInteger), new Time(paramDate), paramInt);
  }
  
  public void addCRLEntry(BigInteger paramBigInteger, Date paramDate1, int paramInt, Date paramDate2)
  {
    this.tbsGen.addCRLEntry(new ASN1Integer(paramBigInteger), new Time(paramDate1), paramInt, new ASN1GeneralizedTime(paramDate2));
  }
  
  public void addCRLEntry(BigInteger paramBigInteger, Date paramDate, X509Extensions paramX509Extensions)
  {
    this.tbsGen.addCRLEntry(new ASN1Integer(paramBigInteger), new Time(paramDate), Extensions.getInstance(paramX509Extensions));
  }
  
  public void addExtension(String paramString, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
  {
    addExtension(new ASN1ObjectIdentifier(paramString), paramBoolean, paramASN1Encodable);
  }
  
  public void addExtension(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    addExtension(new ASN1ObjectIdentifier(paramString), paramBoolean, paramArrayOfByte);
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
  {
    this.extGenerator.addExtension(new ASN1ObjectIdentifier(paramASN1ObjectIdentifier.getId()), paramBoolean, paramASN1Encodable);
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.extGenerator.addExtension(new ASN1ObjectIdentifier(paramASN1ObjectIdentifier.getId()), paramBoolean, paramArrayOfByte);
  }
  
  public X509CRL generate(PrivateKey paramPrivateKey)
    throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    return generate(paramPrivateKey, (SecureRandom)null);
  }
  
  public X509CRL generate(PrivateKey paramPrivateKey, String paramString)
    throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    return generate(paramPrivateKey, paramString, null);
  }
  
  public X509CRL generate(PrivateKey paramPrivateKey, String paramString, SecureRandom paramSecureRandom)
    throws CRLException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    TBSCertList localTBSCertList = generateCertList();
    try
    {
      paramPrivateKey = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, paramString, paramPrivateKey, paramSecureRandom, localTBSCertList);
      return generateJcaObject(localTBSCertList, paramPrivateKey);
    }
    catch (IOException paramPrivateKey)
    {
      throw new ExtCRLException("cannot generate CRL encoding", paramPrivateKey);
    }
  }
  
  public X509CRL generate(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws CRLException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    TBSCertList localTBSCertList = generateCertList();
    try
    {
      paramPrivateKey = X509Util.calculateSignature(this.sigOID, this.signatureAlgorithm, paramPrivateKey, paramSecureRandom, localTBSCertList);
      return generateJcaObject(localTBSCertList, paramPrivateKey);
    }
    catch (IOException paramPrivateKey)
    {
      throw new ExtCRLException("cannot generate CRL encoding", paramPrivateKey);
    }
  }
  
  public X509CRL generateX509CRL(PrivateKey paramPrivateKey)
    throws SecurityException, SignatureException, InvalidKeyException
  {
    try
    {
      paramPrivateKey = generateX509CRL(paramPrivateKey, "BC", null);
      return paramPrivateKey;
    }
    catch (NoSuchProviderException paramPrivateKey)
    {
      for (;;) {}
    }
    throw new SecurityException("BC provider not installed!");
  }
  
  public X509CRL generateX509CRL(PrivateKey paramPrivateKey, String paramString)
    throws NoSuchProviderException, SecurityException, SignatureException, InvalidKeyException
  {
    return generateX509CRL(paramPrivateKey, paramString, null);
  }
  
  public X509CRL generateX509CRL(PrivateKey paramPrivateKey, String paramString, SecureRandom paramSecureRandom)
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
  
  public X509CRL generateX509CRL(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws SecurityException, SignatureException, InvalidKeyException
  {
    try
    {
      paramPrivateKey = generateX509CRL(paramPrivateKey, "BC", paramSecureRandom);
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
    this.tbsGen = new V2TBSCertListGenerator();
    this.extGenerator.reset();
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
  
  public void setNextUpdate(Date paramDate)
  {
    this.tbsGen.setNextUpdate(new Time(paramDate));
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
  
  public void setThisUpdate(Date paramDate)
  {
    this.tbsGen.setThisUpdate(new Time(paramDate));
  }
  
  private static class ExtCRLException
    extends CRLException
  {
    Throwable cause;
    
    ExtCRLException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509V2CRLGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */