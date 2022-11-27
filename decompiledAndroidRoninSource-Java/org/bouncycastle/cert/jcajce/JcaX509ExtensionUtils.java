package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.operator.DigestCalculator;

public class JcaX509ExtensionUtils
  extends X509ExtensionUtils
{
  public JcaX509ExtensionUtils()
    throws NoSuchAlgorithmException
  {
    super(new SHA1DigestCalculator(MessageDigest.getInstance("SHA1")));
  }
  
  public JcaX509ExtensionUtils(DigestCalculator paramDigestCalculator)
  {
    super(paramDigestCalculator);
  }
  
  public static ASN1Primitive parseExtensionValue(byte[] paramArrayOfByte)
    throws IOException
  {
    return ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(paramArrayOfByte).getOctets());
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey paramPublicKey)
  {
    return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()));
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey paramPublicKey, X500Principal paramX500Principal, BigInteger paramBigInteger)
  {
    return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()), new GeneralNames(new GeneralName(X500Name.getInstance(paramX500Principal.getEncoded()))), paramBigInteger);
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey paramPublicKey, GeneralNames paramGeneralNames, BigInteger paramBigInteger)
  {
    return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()), paramGeneralNames, paramBigInteger);
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(X509Certificate paramX509Certificate)
    throws CertificateEncodingException
  {
    return super.createAuthorityKeyIdentifier(new JcaX509CertificateHolder(paramX509Certificate));
  }
  
  public SubjectKeyIdentifier createSubjectKeyIdentifier(PublicKey paramPublicKey)
  {
    return super.createSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()));
  }
  
  public SubjectKeyIdentifier createTruncatedSubjectKeyIdentifier(PublicKey paramPublicKey)
  {
    return super.createTruncatedSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded()));
  }
  
  private static class SHA1DigestCalculator
    implements DigestCalculator
  {
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    private MessageDigest digest;
    
    public SHA1DigestCalculator(MessageDigest paramMessageDigest)
    {
      this.digest = paramMessageDigest;
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    }
    
    public byte[] getDigest()
    {
      byte[] arrayOfByte = this.digest.digest(this.bOut.toByteArray());
      this.bOut.reset();
      return arrayOfByte;
    }
    
    public OutputStream getOutputStream()
    {
      return this.bOut;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\jcajce\JcaX509ExtensionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */