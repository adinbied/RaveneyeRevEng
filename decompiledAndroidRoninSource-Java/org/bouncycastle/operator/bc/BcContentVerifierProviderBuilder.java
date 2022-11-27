package org.bouncycastle.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;

public abstract class BcContentVerifierProviderBuilder
{
  protected BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;
  
  private BcSignerOutputStream createSignatureStream(AlgorithmIdentifier paramAlgorithmIdentifier, AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws OperatorCreationException
  {
    paramAlgorithmIdentifier = createSigner(paramAlgorithmIdentifier);
    paramAlgorithmIdentifier.init(false, paramAsymmetricKeyParameter);
    return new BcSignerOutputStream(paramAlgorithmIdentifier);
  }
  
  public ContentVerifierProvider build(final X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException
  {
    new ContentVerifierProvider()
    {
      public ContentVerifier get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        try
        {
          localObject = BcContentVerifierProviderBuilder.this.extractKeyParameters(paramX509CertificateHolder.getSubjectPublicKeyInfo());
          localObject = BcContentVerifierProviderBuilder.this.createSignatureStream(paramAnonymousAlgorithmIdentifier, (AsymmetricKeyParameter)localObject);
          paramAnonymousAlgorithmIdentifier = new BcContentVerifierProviderBuilder.SigVerifier(BcContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, (BcSignerOutputStream)localObject);
          return paramAnonymousAlgorithmIdentifier;
        }
        catch (IOException paramAnonymousAlgorithmIdentifier)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exception on setup: ");
          ((StringBuilder)localObject).append(paramAnonymousAlgorithmIdentifier);
          throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAnonymousAlgorithmIdentifier);
        }
      }
      
      public X509CertificateHolder getAssociatedCertificate()
      {
        return paramX509CertificateHolder;
      }
      
      public boolean hasAssociatedCertificate()
      {
        return true;
      }
    };
  }
  
  public ContentVerifierProvider build(final AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws OperatorCreationException
  {
    new ContentVerifierProvider()
    {
      public ContentVerifier get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        BcSignerOutputStream localBcSignerOutputStream = BcContentVerifierProviderBuilder.this.createSignatureStream(paramAnonymousAlgorithmIdentifier, paramAsymmetricKeyParameter);
        return new BcContentVerifierProviderBuilder.SigVerifier(BcContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, localBcSignerOutputStream);
      }
      
      public X509CertificateHolder getAssociatedCertificate()
      {
        return null;
      }
      
      public boolean hasAssociatedCertificate()
      {
        return false;
      }
    };
  }
  
  protected abstract Signer createSigner(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException;
  
  protected abstract AsymmetricKeyParameter extractKeyParameters(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException;
  
  private class SigVerifier
    implements ContentVerifier
  {
    private AlgorithmIdentifier algorithm;
    private BcSignerOutputStream stream;
    
    SigVerifier(AlgorithmIdentifier paramAlgorithmIdentifier, BcSignerOutputStream paramBcSignerOutputStream)
    {
      this.algorithm = paramAlgorithmIdentifier;
      this.stream = paramBcSignerOutputStream;
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return this.algorithm;
    }
    
    public OutputStream getOutputStream()
    {
      BcSignerOutputStream localBcSignerOutputStream = this.stream;
      if (localBcSignerOutputStream != null) {
        return localBcSignerOutputStream;
      }
      throw new IllegalStateException("verifier not initialised");
    }
    
    public boolean verify(byte[] paramArrayOfByte)
    {
      return this.stream.verify(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcContentVerifierProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */