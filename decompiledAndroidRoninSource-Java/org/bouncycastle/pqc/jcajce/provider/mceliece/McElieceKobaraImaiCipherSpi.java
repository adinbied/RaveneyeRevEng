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
import org.bouncycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.bouncycastle.pqc.jcajce.provider.util.AsymmetricHybridCipher;

public class McElieceKobaraImaiCipherSpi
  extends AsymmetricHybridCipher
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private ByteArrayOutputStream buf = new ByteArrayOutputStream();
  private McElieceKobaraImaiCipher cipher;
  private Digest digest;
  
  public McElieceKobaraImaiCipherSpi()
  {
    this.buf = new ByteArrayOutputStream();
  }
  
  protected McElieceKobaraImaiCipherSpi(Digest paramDigest, McElieceKobaraImaiCipher paramMcElieceKobaraImaiCipher)
  {
    this.digest = paramDigest;
    this.cipher = paramMcElieceKobaraImaiCipher;
    this.buf = new ByteArrayOutputStream();
  }
  
  private byte[] pad()
  {
    this.buf.write(1);
    byte[] arrayOfByte = this.buf.toByteArray();
    this.buf.reset();
    return arrayOfByte;
  }
  
  private byte[] unpad(byte[] paramArrayOfByte)
    throws BadPaddingException
  {
    int i = paramArrayOfByte.length - 1;
    while ((i >= 0) && (paramArrayOfByte[i] == 0)) {
      i -= 1;
    }
    if (paramArrayOfByte[i] == 1)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    throw new BadPaddingException("invalid ciphertext");
  }
  
  protected int decryptOutputSize(int paramInt)
  {
    return 0;
  }
  
  public byte[] doFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws BadPaddingException
  {
    update(paramArrayOfByte, paramInt1, paramInt2);
    if (this.opMode == 1)
    {
      try
      {
        paramArrayOfByte = this.cipher.messageEncrypt(pad());
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    else if (this.opMode == 2)
    {
      paramArrayOfByte = this.buf.toByteArray();
      this.buf.reset();
      paramArrayOfByte = unpad(this.cipher.messageDecrypt(paramArrayOfByte));
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
    if ((paramKey instanceof PublicKey)) {}
    for (paramKey = McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey)paramKey);; paramKey = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey))
    {
      paramKey = (McElieceCCA2KeyParameters)paramKey;
      return this.cipher.getKeySize(paramKey);
      if (!(paramKey instanceof PrivateKey)) {
        break;
      }
    }
    throw new InvalidKeyException();
  }
  
  public String getName()
  {
    return "McElieceKobaraImaiCipher";
  }
  
  protected void initCipherDecrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    this.buf.reset();
    paramKey = McElieceCCA2KeysToParams.generatePrivateKeyParameter((PrivateKey)paramKey);
    this.digest.reset();
    this.cipher.init(false, paramKey);
  }
  
  protected void initCipherEncrypt(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    this.buf.reset();
    paramKey = new ParametersWithRandom(McElieceCCA2KeysToParams.generatePublicKeyParameter((PublicKey)paramKey), paramSecureRandom);
    this.digest.reset();
    this.cipher.init(true, paramKey);
  }
  
  public byte[] messageDecrypt()
    throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException
  {
    byte[] arrayOfByte = this.buf.toByteArray();
    this.buf.reset();
    try
    {
      arrayOfByte = unpad(this.cipher.messageDecrypt(arrayOfByte));
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] messageEncrypt()
    throws IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException
  {
    try
    {
      byte[] arrayOfByte = this.cipher.messageEncrypt(pad());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.buf.write(paramArrayOfByte, paramInt1, paramInt2);
    return new byte[0];
  }
  
  public static class McElieceKobaraImai
    extends McElieceKobaraImaiCipherSpi
  {
    public McElieceKobaraImai()
    {
      super(new McElieceKobaraImaiCipher());
    }
  }
  
  public static class McElieceKobaraImai224
    extends McElieceKobaraImaiCipherSpi
  {
    public McElieceKobaraImai224()
    {
      super(new McElieceKobaraImaiCipher());
    }
  }
  
  public static class McElieceKobaraImai256
    extends McElieceKobaraImaiCipherSpi
  {
    public McElieceKobaraImai256()
    {
      super(new McElieceKobaraImaiCipher());
    }
  }
  
  public static class McElieceKobaraImai384
    extends McElieceKobaraImaiCipherSpi
  {
    public McElieceKobaraImai384()
    {
      super(new McElieceKobaraImaiCipher());
    }
  }
  
  public static class McElieceKobaraImai512
    extends McElieceKobaraImaiCipherSpi
  {
    public McElieceKobaraImai512()
    {
      super(new McElieceKobaraImaiCipher());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\mceliece\McElieceKobaraImaiCipherSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */