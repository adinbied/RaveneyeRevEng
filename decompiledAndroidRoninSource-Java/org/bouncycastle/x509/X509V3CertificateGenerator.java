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
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.asn1.x509.V3TBSCertificateGenerator;
import org.bouncycastle.asn1.x509.X509ExtensionsGenerator;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.x509.extension.X509ExtensionUtil;

public class X509V3CertificateGenerator
{
  private final JcaJceHelper bcHelper = new BCJcaJceHelper();
  private final CertificateFactory certificateFactory = new CertificateFactory();
  private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();
  private AlgorithmIdentifier sigAlgId;
  private ASN1ObjectIdentifier sigOID;
  private String signatureAlgorithm;
  private V3TBSCertificateGenerator tbsGen = new V3TBSCertificateGenerator();
  
  private DERBitString booleanToBitString(boolean[] paramArrayOfBoolean)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfBoolean.length + 7) / 8];
    int i = 0;
    while (i != paramArrayOfBoolean.length)
    {
      int k = i / 8;
      int m = arrayOfByte[k];
      int j;
      if (paramArrayOfBoolean[i] != 0) {
        j = 1 << 7 - i % 8;
      } else {
        j = 0;
      }
      arrayOfByte[k] = ((byte)(m | j));
      i += 1;
    }
    i = paramArrayOfBoolean.length % 8;
    if (i == 0) {
      return new DERBitString(arrayOfByte);
    }
    return new DERBitString(arrayOfByte, 8 - i);
  }
  
  private X509Certificate generateJcaObject(TBSCertificate paramTBSCertificate, byte[] paramArrayOfByte)
    throws Exception
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramTBSCertificate);
    localASN1EncodableVector.add(this.sigAlgId);
    localASN1EncodableVector.add(new DERBitString(paramArrayOfByte));
    return (X509Certificate)this.certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(localASN1EncodableVector).getEncoded("DER")));
  }
  
  private TBSCertificate generateTbsCert()
  {
    if (!this.extGenerator.isEmpty()) {
      this.tbsGen.setExtensions(this.extGenerator.generate());
    }
    return this.tbsGen.generateTBSCertificate();
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
  
  public void copyAndAddExtension(String paramString, boolean paramBoolean, X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    paramX509Certificate = paramX509Certificate.getExtensionValue(paramString);
    if (paramX509Certificate != null) {
      try
      {
        addExtension(paramString, paramBoolean, X509ExtensionUtil.fromExtensionValue(paramX509Certificate));
        return;
      }
      catch (IOException paramString)
      {
        throw new CertificateParsingException(paramString.toString());
      }
    }
    paramX509Certificate = new StringBuilder();
    paramX509Certificate.append("extension ");
    paramX509Certificate.append(paramString);
    paramX509Certificate.append(" not present");
    throw new CertificateParsingException(paramX509Certificate.toString());
  }
  
  public void copyAndAddExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    copyAndAddExtension(paramASN1ObjectIdentifier.getId(), paramBoolean, paramX509Certificate);
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
  
  /* Error */
  public X509Certificate generate(PrivateKey paramPrivateKey, String paramString, SecureRandom paramSecureRandom)
    throws CertificateEncodingException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 184	org/bouncycastle/x509/X509V3CertificateGenerator:generateTbsCert	()Lorg/bouncycastle/asn1/x509/TBSCertificate;
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 186	org/bouncycastle/x509/X509V3CertificateGenerator:sigOID	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   10: aload_0
    //   11: getfield 188	org/bouncycastle/x509/X509V3CertificateGenerator:signatureAlgorithm	Ljava/lang/String;
    //   14: aload_2
    //   15: aload_1
    //   16: aload_3
    //   17: aload 4
    //   19: invokestatic 194	org/bouncycastle/x509/X509Util:calculateSignature	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljava/lang/String;Ljava/lang/String;Ljava/security/PrivateKey;Ljava/security/SecureRandom;Lorg/bouncycastle/asn1/ASN1Encodable;)[B
    //   22: astore_1
    //   23: aload_0
    //   24: aload 4
    //   26: aload_1
    //   27: invokespecial 196	org/bouncycastle/x509/X509V3CertificateGenerator:generateJcaObject	(Lorg/bouncycastle/asn1/x509/TBSCertificate;[B)Ljava/security/cert/X509Certificate;
    //   30: astore_1
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: new 198	org/bouncycastle/x509/ExtCertificateEncodingException
    //   37: dup
    //   38: ldc -56
    //   40: aload_1
    //   41: invokespecial 203	org/bouncycastle/x509/ExtCertificateEncodingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    //   45: astore_1
    //   46: new 198	org/bouncycastle/x509/ExtCertificateEncodingException
    //   49: dup
    //   50: ldc -51
    //   52: aload_1
    //   53: invokespecial 203	org/bouncycastle/x509/ExtCertificateEncodingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	X509V3CertificateGenerator
    //   0	57	1	paramPrivateKey	PrivateKey
    //   0	57	2	paramString	String
    //   0	57	3	paramSecureRandom	SecureRandom
    //   4	21	4	localTBSCertificate	TBSCertificate
    // Exception table:
    //   from	to	target	type
    //   23	31	33	java/lang/Exception
    //   6	23	45	java/io/IOException
  }
  
  /* Error */
  public X509Certificate generate(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws CertificateEncodingException, IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 184	org/bouncycastle/x509/X509V3CertificateGenerator:generateTbsCert	()Lorg/bouncycastle/asn1/x509/TBSCertificate;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 186	org/bouncycastle/x509/X509V3CertificateGenerator:sigOID	Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;
    //   9: aload_0
    //   10: getfield 188	org/bouncycastle/x509/X509V3CertificateGenerator:signatureAlgorithm	Ljava/lang/String;
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokestatic 208	org/bouncycastle/x509/X509Util:calculateSignature	(Lorg/bouncycastle/asn1/ASN1ObjectIdentifier;Ljava/lang/String;Ljava/security/PrivateKey;Ljava/security/SecureRandom;Lorg/bouncycastle/asn1/ASN1Encodable;)[B
    //   19: astore_1
    //   20: aload_0
    //   21: aload_3
    //   22: aload_1
    //   23: invokespecial 196	org/bouncycastle/x509/X509V3CertificateGenerator:generateJcaObject	(Lorg/bouncycastle/asn1/x509/TBSCertificate;[B)Ljava/security/cert/X509Certificate;
    //   26: astore_1
    //   27: aload_1
    //   28: areturn
    //   29: astore_1
    //   30: new 198	org/bouncycastle/x509/ExtCertificateEncodingException
    //   33: dup
    //   34: ldc -56
    //   36: aload_1
    //   37: invokespecial 203	org/bouncycastle/x509/ExtCertificateEncodingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: athrow
    //   41: astore_1
    //   42: new 198	org/bouncycastle/x509/ExtCertificateEncodingException
    //   45: dup
    //   46: ldc -51
    //   48: aload_1
    //   49: invokespecial 203	org/bouncycastle/x509/ExtCertificateEncodingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	X509V3CertificateGenerator
    //   0	53	1	paramPrivateKey	PrivateKey
    //   0	53	2	paramSecureRandom	SecureRandom
    //   4	18	3	localTBSCertificate	TBSCertificate
    // Exception table:
    //   from	to	target	type
    //   20	27	29	java/lang/Exception
    //   5	20	41	java/io/IOException
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
    this.tbsGen = new V3TBSCertificateGenerator();
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
  
  public void setIssuerUniqueID(boolean[] paramArrayOfBoolean)
  {
    this.tbsGen.setIssuerUniqueID(booleanToBitString(paramArrayOfBoolean));
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
    throws IllegalArgumentException
  {
    try
    {
      this.tbsGen.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(paramPublicKey.getEncoded()).readObject()));
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
      localObject = X509Util.getAlgorithmOID(paramString);
      this.sigOID = ((ASN1ObjectIdentifier)localObject);
      paramString = X509Util.getSigAlgID((ASN1ObjectIdentifier)localObject, paramString);
      this.sigAlgId = paramString;
      this.tbsGen.setSignature(paramString);
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown signature type requested: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
  
  public void setSubjectUniqueID(boolean[] paramArrayOfBoolean)
  {
    this.tbsGen.setSubjectUniqueID(booleanToBitString(paramArrayOfBoolean));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509V3CertificateGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */