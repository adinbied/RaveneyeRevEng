package org.bouncycastle.operator.bc;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;

public class BcDigestCalculatorProvider
  implements DigestCalculatorProvider
{
  private BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;
  
  public DigestCalculator get(final AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException
  {
    new DigestCalculator()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return paramAlgorithmIdentifier;
      }
      
      public byte[] getDigest()
      {
        return this.val$stream.getDigest();
      }
      
      public OutputStream getOutputStream()
      {
        return this.val$stream;
      }
    };
  }
  
  private class DigestOutputStream
    extends OutputStream
  {
    private Digest dig;
    
    DigestOutputStream(Digest paramDigest)
    {
      this.dig = paramDigest;
    }
    
    byte[] getDigest()
    {
      byte[] arrayOfByte = new byte[this.dig.getDigestSize()];
      this.dig.doFinal(arrayOfByte, 0);
      return arrayOfByte;
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.dig.update((byte)paramInt);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      this.dig.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.dig.update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcDigestCalculatorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */