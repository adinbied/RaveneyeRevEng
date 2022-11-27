package org.bouncycastle.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;

public class JcaContentSignerBuilder
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  private SecureRandom random;
  private AlgorithmIdentifier sigAlgId;
  private String signatureAlgorithm;
  
  public JcaContentSignerBuilder(String paramString)
  {
    this.signatureAlgorithm = paramString;
    this.sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find(paramString);
  }
  
  public ContentSigner build(PrivateKey paramPrivateKey)
    throws OperatorCreationException
  {
    try
    {
      localObject = this.helper.createSignature(this.sigAlgId);
      final AlgorithmIdentifier localAlgorithmIdentifier = this.sigAlgId;
      if (this.random != null) {
        ((Signature)localObject).initSign(paramPrivateKey, this.random);
      } else {
        ((Signature)localObject).initSign(paramPrivateKey);
      }
      paramPrivateKey = new ContentSigner()
      {
        private JcaContentSignerBuilder.SignatureOutputStream stream = new JcaContentSignerBuilder.SignatureOutputStream(JcaContentSignerBuilder.this, localObject);
        
        public AlgorithmIdentifier getAlgorithmIdentifier()
        {
          return localAlgorithmIdentifier;
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
          catch (SignatureException localSignatureException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("exception obtaining signature: ");
            localStringBuilder.append(localSignatureException.getMessage());
            throw new RuntimeOperatorException(localStringBuilder.toString(), localSignatureException);
          }
        }
      };
      return paramPrivateKey;
    }
    catch (GeneralSecurityException paramPrivateKey)
    {
      final Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot create signer: ");
      ((StringBuilder)localObject).append(paramPrivateKey.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramPrivateKey);
    }
  }
  
  public JcaContentSignerBuilder setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JcaContentSignerBuilder setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public JcaContentSignerBuilder setSecureRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  private class SignatureOutputStream
    extends OutputStream
  {
    private Signature sig;
    
    SignatureOutputStream(Signature paramSignature)
    {
      this.sig = paramSignature;
    }
    
    byte[] getSignature()
      throws SignatureException
    {
      return this.sig.sign();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      try
      {
        this.sig.update((byte)paramInt);
        return;
      }
      catch (SignatureException localSignatureException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(localSignatureException.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), localSignatureException);
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        this.sig.update(paramArrayOfByte);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.sig.update(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JcaContentSignerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */