package org.bouncycastle.openssl;

import java.io.IOException;
import org.bouncycastle.operator.OperatorCreationException;

public class PEMEncryptedKeyPair
{
  private final String dekAlgName;
  private final byte[] iv;
  private final byte[] keyBytes;
  private final PEMKeyPairParser parser;
  
  PEMEncryptedKeyPair(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PEMKeyPairParser paramPEMKeyPairParser)
  {
    this.dekAlgName = paramString;
    this.iv = paramArrayOfByte1;
    this.keyBytes = paramArrayOfByte2;
    this.parser = paramPEMKeyPairParser;
  }
  
  public PEMKeyPair decryptKeyPair(PEMDecryptorProvider paramPEMDecryptorProvider)
    throws IOException
  {
    try
    {
      paramPEMDecryptorProvider = paramPEMDecryptorProvider.get(this.dekAlgName);
      paramPEMDecryptorProvider = this.parser.parse(paramPEMDecryptorProvider.decrypt(this.keyBytes, this.iv));
      return paramPEMDecryptorProvider;
    }
    catch (Exception paramPEMDecryptorProvider)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception processing key pair: ");
      localStringBuilder.append(paramPEMDecryptorProvider.getMessage());
      throw new PEMException(localStringBuilder.toString(), paramPEMDecryptorProvider);
    }
    catch (OperatorCreationException paramPEMDecryptorProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot create extraction operator: ");
      localStringBuilder.append(paramPEMDecryptorProvider.getMessage());
      throw new PEMException(localStringBuilder.toString(), paramPEMDecryptorProvider);
    }
    catch (IOException paramPEMDecryptorProvider)
    {
      throw paramPEMDecryptorProvider;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMEncryptedKeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */