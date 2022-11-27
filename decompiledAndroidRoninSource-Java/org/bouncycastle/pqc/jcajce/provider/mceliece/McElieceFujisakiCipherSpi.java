package org.bouncycastle.pqc.jcajce.provider.mceliece;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2KeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McElieceFujisakiCipherSpi
  extends AsymmetricHybridCipher
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private ByteArrayOutputStream buf;
  private McElieceFujisakiCipher cipher;
  private Digest digest;
  
  protected McElieceFujisakiCipherSpi(Digest paramDigest, McElieceFujisakiCipher paramMcElieceFujisakiCipher)
  {
    this.digest = paramDigest;
    this.cipher = paramMcElieceFujisakiCipher;
    this.buf = new ByteArrayOutputStream();
  }
  
  protected int decryptOutputSize(int paramInt)
  {
    return 0;
  }
  
  public byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws BadPaddingException
  {
    update(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.buf.toByteArray();
    this.buf.reset();
    if (this.opMode == 1)
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
    }
    else if (this.opMode == 2)
    {
      paramArrayOfByte = this.cipher.messageDecrypt(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  protected int encryptOutputSize(int paramInt)
  {
    return 0;
  }
  
  public int getKeySize(Key paramKey)
    throws InvalidKeyException
  {
    if ((paramKey instanceof PublicKey)) {
      paramKey = McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey)paramKey);
    } else {
      paramKey = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey);
    }
    paramKey = (McElieceCCA2KeyParameters)paramKey;
    return this.cipher.getKeySize(paramKey);
  }
  
  public String getName()
  {
    return "McElieceFujisakiCipher";
  }
  
  protected void initCipherDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    paramKey = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey);
    this.digest.reset();
    this.cipher.init(false, paramKey);
  }
  
  protected void initCipherEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    paramKey = new ParametersWithRandom(McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey)paramKey), paramSecureRandom);
    this.digest.reset();
    this.cipher.init(true, paramKey);
  }
  
  public byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException
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
  
  public byte[] messageEncrypt(byte[] paramArrayOfByte)
    throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException
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
  
  public byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buf.write(paramArrayOfByte, paramInt1, paramInt2);
    return new byte[0];
  }
  
  public static class McElieceFujisaki
    extends McElieceFujisakiCipherSpi
  {
    public McElieceFujisaki()
    {
      super(new McElieceFujisakiCipher());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceFujisakiCipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */