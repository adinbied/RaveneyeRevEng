package org.bouncycastle.jce.provider;

import java.io.PrintStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.TwofishEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.util.Strings;

public class BrokenJCEBlockCipher
  implements BrokenPBE
{
  private Class[] availableSpecs = { IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class };
  private BufferedBlockCipher cipher;
  private AlgorithmParameters engineParams = null;
  private int ivLength = 0;
  private ParametersWithIV ivParam;
  private int pbeHash = 1;
  private int pbeIvSize;
  private int pbeKeySize;
  private int pbeType = 2;
  
  protected BrokenJCEBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = new PaddedBufferedBlockCipher(paramBlockCipher);
  }
  
  protected BrokenJCEBlockCipher(BlockCipher paramBlockCipher, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cipher = new PaddedBufferedBlockCipher(paramBlockCipher);
    this.pbeType = paramInt1;
    this.pbeHash = paramInt2;
    this.pbeKeySize = paramInt3;
    this.pbeIvSize = paramInt4;
  }
  
  protected int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalBlockSizeException, BadPaddingException
  {
    if (paramInt2 != 0) {
      paramInt1 = this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
    } else {
      paramInt1 = 0;
    }
    try
    {
      paramInt2 = this.cipher.doFinal(paramArrayOfByte2, paramInt3 + paramInt1);
      return paramInt1 + paramInt2;
    }
    catch (InvalidCipherTextException paramArrayOfByte1)
    {
      throw new BadPaddingException(paramArrayOfByte1.getMessage());
    }
    catch (DataLengthException paramArrayOfByte1)
    {
      throw new IllegalBlockSizeException(paramArrayOfByte1.getMessage());
    }
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    byte[] arrayOfByte = new byte[engineGetOutputSize(paramInt2)];
    if (paramInt2 != 0) {
      paramInt1 = this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    } else {
      paramInt1 = 0;
    }
    try
    {
      paramInt2 = this.cipher.doFinal(arrayOfByte, paramInt1);
      paramInt1 += paramInt2;
      paramArrayOfByte = new byte[paramInt1];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (InvalidCipherTextException paramArrayOfByte)
    {
      throw new BadPaddingException(paramArrayOfByte.getMessage());
    }
    catch (DataLengthException paramArrayOfByte)
    {
      throw new IllegalBlockSizeException(paramArrayOfByte.getMessage());
    }
  }
  
  protected int engineGetBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  protected byte[] engineGetIV()
  {
    ParametersWithIV localParametersWithIV = this.ivParam;
    if (localParametersWithIV != null) {
      return localParametersWithIV.getIV();
    }
    return null;
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    return paramKey.getEncoded().length;
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return this.cipher.getOutputSize(paramInt);
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams == null) && (this.ivParam != null))
    {
      String str = this.cipher.getUnderlyingCipher().getAlgorithmName();
      Object localObject = str;
      if (str.indexOf('/') >= 0) {
        localObject = str.substring(0, str.indexOf('/'));
      }
      try
      {
        localObject = AlgorithmParameters.getInstance((String)localObject, "BC");
        this.engineParams = ((AlgorithmParameters)localObject);
        ((AlgorithmParameters)localObject).init(this.ivParam.getIV());
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.toString());
      }
    }
    return this.engineParams;
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameters paramAlgorithmParameters, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramAlgorithmParameters != null)
    {
      int i = 0;
      for (;;)
      {
        Class[] arrayOfClass = this.availableSpecs;
        localObject1 = localObject2;
        if (i == arrayOfClass.length) {
          break;
        }
        try
        {
          localObject1 = paramAlgorithmParameters.getParameterSpec(arrayOfClass[i]);
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        i += 1;
      }
      if (localObject1 == null)
      {
        paramKey = new StringBuilder();
        paramKey.append("can't handle parameter ");
        paramKey.append(paramAlgorithmParameters.toString());
        throw new InvalidAlgorithmParameterException(paramKey.toString());
      }
    }
    this.engineParams = paramAlgorithmParameters;
    engineInit(paramInt, paramKey, (AlgorithmParameterSpec)localObject1, paramSecureRandom);
  }
  
  protected void engineInit(int paramInt, Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    try
    {
      engineInit(paramInt, paramKey, (AlgorithmParameterSpec)null, paramSecureRandom);
      return;
    }
    catch (InvalidAlgorithmParameterException paramKey)
    {
      throw new IllegalArgumentException(paramKey.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramKey instanceof BCPBEKey))
    {
      paramAlgorithmParameterSpec = BrokenPBE.Util.makePBEParameters((BCPBEKey)paramKey, paramAlgorithmParameterSpec, this.pbeType, this.pbeHash, this.cipher.getUnderlyingCipher().getAlgorithmName(), this.pbeKeySize, this.pbeIvSize);
      paramKey = paramAlgorithmParameterSpec;
      if (this.pbeIvSize != 0) {
        paramKey = paramAlgorithmParameterSpec;
      }
    }
    else
    {
      for (;;)
      {
        this.ivParam = ((ParametersWithIV)paramKey);
        break;
        if (paramAlgorithmParameterSpec == null)
        {
          paramKey = new KeyParameter(paramKey.getEncoded());
          break;
        }
        if ((paramAlgorithmParameterSpec instanceof IvParameterSpec)) {
          if (this.ivLength != 0)
          {
            paramKey = new ParametersWithIV(new KeyParameter(paramKey.getEncoded()), ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());
            this.ivParam = ((ParametersWithIV)paramKey);
          }
        }
        Object localObject;
        label225:
        do
        {
          do
          {
            do
            {
              do
              {
                break;
                paramKey = new KeyParameter(paramKey.getEncoded());
                break;
                if (!(paramAlgorithmParameterSpec instanceof RC2ParameterSpec)) {
                  break label225;
                }
                localObject = (RC2ParameterSpec)paramAlgorithmParameterSpec;
                paramAlgorithmParameterSpec = new RC2Parameters(paramKey.getEncoded(), ((RC2ParameterSpec)localObject).getEffectiveKeyBits());
                paramKey = paramAlgorithmParameterSpec;
              } while (((RC2ParameterSpec)localObject).getIV() == null);
              paramKey = paramAlgorithmParameterSpec;
            } while (this.ivLength == 0);
            paramKey = new ParametersWithIV(paramAlgorithmParameterSpec, ((RC2ParameterSpec)localObject).getIV());
            break;
            if (!(paramAlgorithmParameterSpec instanceof RC5ParameterSpec)) {
              break label454;
            }
            localObject = (RC5ParameterSpec)paramAlgorithmParameterSpec;
            paramAlgorithmParameterSpec = new RC5Parameters(paramKey.getEncoded(), ((RC5ParameterSpec)localObject).getRounds());
            if (((RC5ParameterSpec)localObject).getWordSize() != 32) {
              break label443;
            }
            paramKey = paramAlgorithmParameterSpec;
          } while (((RC5ParameterSpec)localObject).getIV() == null);
          paramKey = paramAlgorithmParameterSpec;
        } while (this.ivLength == 0);
        paramKey = new ParametersWithIV(paramAlgorithmParameterSpec, ((RC5ParameterSpec)localObject).getIV());
      }
    }
    paramAlgorithmParameterSpec = paramKey;
    if (this.ivLength != 0)
    {
      paramAlgorithmParameterSpec = paramKey;
      if (!(paramKey instanceof ParametersWithIV))
      {
        paramAlgorithmParameterSpec = paramSecureRandom;
        if (paramSecureRandom == null) {
          paramAlgorithmParameterSpec = new SecureRandom();
        }
        if ((paramInt != 1) && (paramInt != 3)) {
          throw new InvalidAlgorithmParameterException("no IV set when one expected");
        }
        paramSecureRandom = new byte[this.ivLength];
        paramAlgorithmParameterSpec.nextBytes(paramSecureRandom);
        paramAlgorithmParameterSpec = new ParametersWithIV(paramKey, paramSecureRandom);
        this.ivParam = ((ParametersWithIV)paramAlgorithmParameterSpec);
      }
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          break label433;
        }
        if (paramInt != 4)
        {
          System.out.println("eeek!");
          return;
        }
      }
      this.cipher.init(false, paramAlgorithmParameterSpec);
      return;
    }
    label433:
    this.cipher.init(true, paramAlgorithmParameterSpec);
    return;
    label443:
    throw new IllegalArgumentException("can only accept RC5 word size 32 (at the moment...)");
    label454:
    throw new InvalidAlgorithmParameterException("unknown parameter type.");
  }
  
  protected void engineSetMode(String paramString)
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (((String)localObject).equals("ECB"))
    {
      this.ivLength = 0;
      paramString = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      if (((String)localObject).equals("CBC"))
      {
        this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
        paramString = new PaddedBufferedBlockCipher(new CBCBlockCipher(this.cipher.getUnderlyingCipher()));
      }
      else
      {
        int i;
        if (((String)localObject).startsWith("OFB"))
        {
          this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
          if (((String)localObject).length() != 3) {
            i = Integer.parseInt(((String)localObject).substring(3));
          }
        }
        for (paramString = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), i));; paramString = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), i)))
        {
          this.cipher = paramString;
          return;
          paramString = new PaddedBufferedBlockCipher(new OFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
          break;
          if (!((String)localObject).startsWith("CFB")) {
            break label303;
          }
          this.ivLength = this.cipher.getUnderlyingCipher().getBlockSize();
          if (((String)localObject).length() == 3) {
            break label268;
          }
          i = Integer.parseInt(((String)localObject).substring(3));
        }
        label268:
        paramString = new PaddedBufferedBlockCipher(new CFBBlockCipher(this.cipher.getUnderlyingCipher(), this.cipher.getBlockSize() * 8));
      }
    }
    label303:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't support mode ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  protected void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (((String)localObject).equals("NOPADDING")) {
      paramString = new BufferedBlockCipher(this.cipher.getUnderlyingCipher());
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      if ((!((String)localObject).equals("PKCS5PADDING")) && (!((String)localObject).equals("PKCS7PADDING")) && (!((String)localObject).equals("ISO10126PADDING")))
      {
        if (((String)localObject).equals("WITHCTS"))
        {
          paramString = new CTSBlockCipher(this.cipher.getUnderlyingCipher());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Padding ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" unknown.");
          throw new NoSuchPaddingException(((StringBuilder)localObject).toString());
        }
      }
      else {
        paramString = new PaddedBufferedBlockCipher(this.cipher.getUnderlyingCipher());
      }
    }
  }
  
  /* Error */
  protected Key engineUnwrap(byte[] paramArrayOfByte, String paramString, int paramInt)
    throws InvalidKeyException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_0
    //   3: aload_1
    //   4: arraylength
    //   5: invokevirtual 353	org/bouncycastle/jce/provider/BrokenJCEBlockCipher:engineDoFinal	([BII)[B
    //   8: astore_1
    //   9: iload_3
    //   10: iconst_3
    //   11: if_icmpne +13 -> 24
    //   14: new 355	javax/crypto/spec/SecretKeySpec
    //   17: dup
    //   18: aload_1
    //   19: aload_2
    //   20: invokespecial 358	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   23: areturn
    //   24: aload_2
    //   25: ldc -93
    //   27: invokestatic 363	java/security/KeyFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyFactory;
    //   30: astore_2
    //   31: iload_3
    //   32: iconst_1
    //   33: if_icmpne +16 -> 49
    //   36: aload_2
    //   37: new 365	java/security/spec/X509EncodedKeySpec
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 366	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   45: invokevirtual 370	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   48: areturn
    //   49: iload_3
    //   50: iconst_2
    //   51: if_icmpne +18 -> 69
    //   54: aload_2
    //   55: new 372	java/security/spec/PKCS8EncodedKeySpec
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 373	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   63: invokevirtual 377	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   66: astore_1
    //   67: aload_1
    //   68: areturn
    //   69: new 191	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   76: astore_1
    //   77: aload_1
    //   78: ldc_w 379
    //   81: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: iload_3
    //   87: invokevirtual 382	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: new 183	java/security/InvalidKeyException
    //   94: dup
    //   95: aload_1
    //   96: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_1
    //   104: new 191	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   111: astore_2
    //   112: aload_2
    //   113: ldc_w 379
    //   116: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: aload_1
    //   122: invokevirtual 384	java/security/spec/InvalidKeySpecException:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: new 183	java/security/InvalidKeyException
    //   132: dup
    //   133: aload_2
    //   134: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: astore_1
    //   142: new 191	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   149: astore_2
    //   150: aload_2
    //   151: ldc_w 379
    //   154: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_2
    //   159: aload_1
    //   160: invokevirtual 385	java/security/NoSuchAlgorithmException:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: new 183	java/security/InvalidKeyException
    //   170: dup
    //   171: aload_2
    //   172: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   178: athrow
    //   179: astore_1
    //   180: new 191	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 192	java/lang/StringBuilder:<init>	()V
    //   187: astore_2
    //   188: aload_2
    //   189: ldc_w 379
    //   192: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_2
    //   197: aload_1
    //   198: invokevirtual 386	java/security/NoSuchProviderException:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: new 183	java/security/InvalidKeyException
    //   208: dup
    //   209: aload_2
    //   210: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   216: athrow
    //   217: astore_1
    //   218: new 183	java/security/InvalidKeyException
    //   221: dup
    //   222: aload_1
    //   223: invokevirtual 387	javax/crypto/IllegalBlockSizeException:getMessage	()Ljava/lang/String;
    //   226: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   229: athrow
    //   230: astore_1
    //   231: new 183	java/security/InvalidKeyException
    //   234: dup
    //   235: aload_1
    //   236: invokevirtual 388	javax/crypto/BadPaddingException:getMessage	()Ljava/lang/String;
    //   239: invokespecial 383	java/security/InvalidKeyException:<init>	(Ljava/lang/String;)V
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	BrokenJCEBlockCipher
    //   0	243	1	paramArrayOfByte	byte[]
    //   0	243	2	paramString	String
    //   0	243	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   24	31	103	java/security/spec/InvalidKeySpecException
    //   36	49	103	java/security/spec/InvalidKeySpecException
    //   54	67	103	java/security/spec/InvalidKeySpecException
    //   24	31	141	java/security/NoSuchAlgorithmException
    //   36	49	141	java/security/NoSuchAlgorithmException
    //   54	67	141	java/security/NoSuchAlgorithmException
    //   24	31	179	java/security/NoSuchProviderException
    //   36	49	179	java/security/NoSuchProviderException
    //   54	67	179	java/security/NoSuchProviderException
    //   0	9	217	javax/crypto/IllegalBlockSizeException
    //   0	9	230	javax/crypto/BadPaddingException
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    return this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.cipher.getUpdateOutputSize(paramInt2);
    if (i > 0)
    {
      byte[] arrayOfByte = new byte[i];
      this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
      return arrayOfByte;
    }
    this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, null, 0);
    return null;
  }
  
  protected byte[] engineWrap(Key paramKey)
    throws IllegalBlockSizeException, InvalidKeyException
  {
    paramKey = paramKey.getEncoded();
    if (paramKey != null) {
      try
      {
        paramKey = engineDoFinal(paramKey, 0, paramKey.length);
        return paramKey;
      }
      catch (BadPaddingException paramKey)
      {
        throw new IllegalBlockSizeException(paramKey.getMessage());
      }
    }
    throw new InvalidKeyException("Cannot wrap key, null encoding.");
  }
  
  public static class BrokePBEWithMD5AndDES
    extends BrokenJCEBlockCipher
  {
    public BrokePBEWithMD5AndDES()
    {
      super(0, 0, 64, 64);
    }
  }
  
  public static class BrokePBEWithSHA1AndDES
    extends BrokenJCEBlockCipher
  {
    public BrokePBEWithSHA1AndDES()
    {
      super(0, 1, 64, 64);
    }
  }
  
  public static class BrokePBEWithSHAAndDES2Key
    extends BrokenJCEBlockCipher
  {
    public BrokePBEWithSHAAndDES2Key()
    {
      super(2, 1, 128, 64);
    }
  }
  
  public static class BrokePBEWithSHAAndDES3Key
    extends BrokenJCEBlockCipher
  {
    public BrokePBEWithSHAAndDES3Key()
    {
      super(2, 1, 192, 64);
    }
  }
  
  public static class OldPBEWithSHAAndDES3Key
    extends BrokenJCEBlockCipher
  {
    public OldPBEWithSHAAndDES3Key()
    {
      super(3, 1, 192, 64);
    }
  }
  
  public static class OldPBEWithSHAAndTwofish
    extends BrokenJCEBlockCipher
  {
    public OldPBEWithSHAAndTwofish()
    {
      super(3, 1, 256, 128);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\BrokenJCEBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */