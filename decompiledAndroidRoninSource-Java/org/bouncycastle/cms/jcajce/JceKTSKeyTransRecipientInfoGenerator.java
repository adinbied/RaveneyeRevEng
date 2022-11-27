package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cms.KeyTransRecipientInfoGenerator;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyWrapper;
import org.bouncycastle.operator.jcajce.JceKTSKeyWrapper;
import org.bouncycastle.util.encoders.Hex;

public class JceKTSKeyTransRecipientInfoGenerator
  extends KeyTransRecipientInfoGenerator
{
  private static final byte[] ANONYMOUS_SENDER = Hex.decode("0c14416e6f6e796d6f75732053656e64657220202020");
  
  public JceKTSKeyTransRecipientInfoGenerator(X509Certificate paramX509Certificate, String paramString, int paramInt)
    throws CertificateEncodingException
  {
    this(paramX509Certificate, new IssuerAndSerialNumber(new JcaX509CertificateHolder(paramX509Certificate).toASN1Structure()), paramString, paramInt);
  }
  
  private JceKTSKeyTransRecipientInfoGenerator(X509Certificate paramX509Certificate, IssuerAndSerialNumber paramIssuerAndSerialNumber, String paramString, int paramInt)
    throws CertificateEncodingException
  {
    super(paramIssuerAndSerialNumber, new JceKTSKeyWrapper(paramX509Certificate, paramString, paramInt, ANONYMOUS_SENDER, getEncodedRecipID(paramIssuerAndSerialNumber)));
  }
  
  public JceKTSKeyTransRecipientInfoGenerator(X509Certificate paramX509Certificate, AlgorithmIdentifier paramAlgorithmIdentifier)
    throws CertificateEncodingException
  {
    super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(paramX509Certificate).toASN1Structure()), new JceAsymmetricKeyWrapper(paramAlgorithmIdentifier, paramX509Certificate.getPublicKey()));
  }
  
  public JceKTSKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, PublicKey paramPublicKey, String paramString, int paramInt)
  {
    super(paramArrayOfByte, new JceKTSKeyWrapper(paramPublicKey, paramString, paramInt, ANONYMOUS_SENDER, getEncodedSubKeyId(paramArrayOfByte)));
  }
  
  public JceKTSKeyTransRecipientInfoGenerator(byte[] paramArrayOfByte, AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
  {
    super(paramArrayOfByte, new JceAsymmetricKeyWrapper(paramAlgorithmIdentifier, paramPublicKey));
  }
  
  private static byte[] getEncodedRecipID(final IssuerAndSerialNumber paramIssuerAndSerialNumber)
    throws CertificateEncodingException
  {
    try
    {
      paramIssuerAndSerialNumber = paramIssuerAndSerialNumber.getEncoded("DER");
      return paramIssuerAndSerialNumber;
    }
    catch (IOException paramIssuerAndSerialNumber)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot process extracted IssuerAndSerialNumber: ");
      localStringBuilder.append(paramIssuerAndSerialNumber.getMessage());
      throw new CertificateEncodingException(localStringBuilder.toString())
      {
        public Throwable getCause()
        {
          return paramIssuerAndSerialNumber;
        }
      };
    }
  }
  
  private static byte[] getEncodedSubKeyId(final byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new DEROctetString(paramArrayOfByte).getEncoded();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot process subject key identifier: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new IllegalArgumentException(localStringBuilder.toString())
      {
        public Throwable getCause()
        {
          return paramArrayOfByte;
        }
      };
    }
  }
  
  public JceKTSKeyTransRecipientInfoGenerator setProvider(String paramString)
  {
    ((JceKTSKeyWrapper)this.wrapper).setProvider(paramString);
    return this;
  }
  
  public JceKTSKeyTransRecipientInfoGenerator setProvider(Provider paramProvider)
  {
    ((JceKTSKeyWrapper)this.wrapper).setProvider(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JceKTSKeyTransRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */