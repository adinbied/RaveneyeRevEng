package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCipher;
import org.bouncycastle.pqc.crypto.mceliece.McElieceKeyParameters;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricBlockCipher;

public class McEliecePKCSCipherSpi
  extends AsymmetricBlockCipher
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private McElieceCipher cipher;
  
  public McEliecePKCSCipherSpi(McElieceCipher paramMcElieceCipher)
  {
    this.cipher = paramMcElieceCipher;
  }
  
  public int getKeySize(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof PublicKey)) {
      paramKey = McElieceKeysToParams.generatePublicKeyParameter((PublicKey)paramKey);
    } else {
      paramKey = McElieceKeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey);
    }
    paramKey = (McElieceKeyParameters)paramKey;
    return this.cipher.getKeySize(paramKey);
  }
  
  public String getName()
  {
    return "McEliecePKCS";
  }
  
  protected void initCipherDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    paramKey = McElieceKeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey);
    this.cipher.init(false, paramKey);
    this.maxPlainTextSize = this.cipher.maxPlainTextSize;
    this.cipherTextSize = this.cipher.cipherTextSize;
  }
  
  protected void initCipherEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    paramKey = new ParametersWithRandom(McElieceKeysToParams.generatePublicKeyParameter((PublicKey)paramKey), paramSecureRandom);
    this.cipher.init(true, paramKey);
    this.maxPlainTextSize = this.cipher.maxPlainTextSize;
    this.cipherTextSize = this.cipher.cipherTextSize;
  }
  
  protected byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException
  {
    try
    {
      paramArrayOfByte = this.cipher.messageDecrypt(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  protected byte[] messageEncrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException
  {
    try
    {
      paramArrayOfByte = this.cipher.messageEncrypt(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static class McEliecePKCS
    extends McEliecePKCSCipherSpi
  {
    public McEliecePKCS()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McEliecePKCSCipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */