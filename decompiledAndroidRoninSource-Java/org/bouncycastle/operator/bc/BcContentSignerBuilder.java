package org.bouncycastle.operator.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RuntimeOperatorException;

public abstract class BcContentSignerBuilder
{
  private AlgorithmIdentifier digAlgId;
  protected BcDigestProvider digestProvider;
  private SecureRandom random;
  private AlgorithmIdentifier sigAlgId;
  
  public BcContentSignerBuilder(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    this.sigAlgId = paramAlgorithmIdentifier1;
    this.digAlgId = paramAlgorithmIdentifier2;
    this.digestProvider = BcDefaultDigestProvider.INSTANCE;
  }
  
  public ContentSigner build(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws OperatorCreationException
  {
    final Signer localSigner = createSigner(this.sigAlgId, this.digAlgId);
    SecureRandom localSecureRandom = this.random;
    if (localSecureRandom != null) {
      localSigner.init(true, new ParametersWithRandom(paramAsymmetricKeyParameter, localSecureRandom));
    } else {
      localSigner.init(true, paramAsymmetricKeyParameter);
    }
    new ContentSigner()
    {
      private BcSignerOutputStream stream = new BcSignerOutputStream(localSigner);
      
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return BcContentSignerBuilder.this.sigAlgId;
      }
      
      public OutputStream getOutputStream()
      {
        return this.stream;
      }
      
      public byte[] getSignature()
      {
        try
        {
          byte[] arrayOfByte = this.stream.getSignature();
          return arrayOfByte;
        }
        catch (CryptoException localCryptoException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("exception obtaining signature: ");
          localStringBuilder.append(localCryptoException.getMessage());
          throw new RuntimeOperatorException(localStringBuilder.toString(), localCryptoException);
        }
      }
    };
  }
  
  protected abstract Signer createSigner(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
    throws OperatorCreationException;
  
  public BcContentSignerBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcContentSignerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */