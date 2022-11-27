package org.bouncycastle.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class JcaDigestCalculatorProviderBuilder
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  
  public DigestCalculatorProvider build()
    throws OperatorCreationException
  {
    new DigestCalculatorProvider()
    {
      public DigestCalculator get(final AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        try
        {
          localObject = JcaDigestCalculatorProviderBuilder.this.helper.createDigest(paramAnonymousAlgorithmIdentifier);
          localObject = new JcaDigestCalculatorProviderBuilder.DigestOutputStream(JcaDigestCalculatorProviderBuilder.this, (MessageDigest)localObject);
          new DigestCalculator()
          {
            public AlgorithmIdentifier getAlgorithmIdentifier()
            {
              return paramAnonymousAlgorithmIdentifier;
            }
            
            public byte[] getDigest()
            {
              return localObject.getDigest();
            }
            
            public OutputStream getOutputStream()
            {
              return localObject;
            }
          };
        }
        catch (GeneralSecurityException paramAnonymousAlgorithmIdentifier)
        {
          final Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exception on setup: ");
          ((StringBuilder)localObject).append(paramAnonymousAlgorithmIdentifier);
          throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAnonymousAlgorithmIdentifier);
        }
      }
    };
  }
  
  public JcaDigestCalculatorProviderBuilder setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JcaDigestCalculatorProviderBuilder setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  private class DigestOutputStream
    extends OutputStream
  {
    private MessageDigest dig;
    
    DigestOutputStream(MessageDigest paramMessageDigest)
    {
      this.dig = paramMessageDigest;
    }
    
    byte[] getDigest()
    {
      return this.dig.digest();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.dig.update((byte)paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.dig.update(paramArrayOfByte);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.dig.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JcaDigestCalculatorProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */