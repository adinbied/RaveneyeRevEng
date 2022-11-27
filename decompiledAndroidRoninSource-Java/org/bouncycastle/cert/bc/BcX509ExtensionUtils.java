package org.bouncycastle.cert.bc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.operator.DigestCalculator;

public class BcX509ExtensionUtils
  extends X509ExtensionUtils
{
  public BcX509ExtensionUtils()
  {
    super(new SHA1DigestCalculator(null));
  }
  
  public BcX509ExtensionUtils(DigestCalculator paramDigestCalculator)
  {
    super(paramDigestCalculator);
  }
  
  public AuthorityKeyIdentifier createAuthorityKeyIdentifier(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(paramAsymmetricKeyParameter));
  }
  
  public SubjectKeyIdentifier createSubjectKeyIdentifier(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException
  {
    return super.createSubjectKeyIdentifier(SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(paramAsymmetricKeyParameter));
  }
  
  private static class SHA1DigestCalculator
    implements DigestCalculator
  {
    private ByteArrayOutputStream bOut = new ByteArrayOutputStream();
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1);
    }
    
    public byte[] getDigest()
    {
      byte[] arrayOfByte = this.bOut.toByteArray();
      this.bOut.reset();
      SHA1Digest localSHA1Digest = new SHA1Digest();
      localSHA1Digest.update(arrayOfByte, 0, arrayOfByte.length);
      arrayOfByte = new byte[localSHA1Digest.getDigestSize()];
      localSHA1Digest.doFinal(arrayOfByte, 0);
      return arrayOfByte;
    }
    
    public OutputStream getOutputStream()
    {
      return this.bOut;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\bc\BcX509ExtensionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */