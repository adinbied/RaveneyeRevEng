package org.bouncycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.GCMParameters;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CCMBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.CTSBlockCipher;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.bouncycastle.crypto.modes.GCFBBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.modes.GOFBBlockCipher;
import org.bouncycastle.crypto.modes.OCBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.PGPCFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.TBCPadding;
import org.bouncycastle.crypto.paddings.X923Padding;
import org.bouncycastle.crypto.paddings.ZeroBytePadding;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.RC5Parameters;
import org.bouncycastle.jcajce.PBKDF1Key;
import org.bouncycastle.jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.RepeatedSecretKeySpec;
import org.bouncycastle.util.Strings;

public class BaseBlockCipher
  extends BaseWrapCipher
  implements PBE
{
  private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
  private AEADParameters aeadParams;
  private Class[] availableSpecs = { RC2ParameterSpec.class, RC5ParameterSpec.class, gcmSpecClass, IvParameterSpec.class, PBEParameterSpec.class, GOST28147ParameterSpec.class };
  private BlockCipher baseEngine;
  private GenericBlockCipher cipher;
  private int digest;
  private BlockCipherProvider engineProvider;
  private boolean fixedIv = true;
  private int ivLength = 0;
  private ParametersWithIV ivParam;
  private int keySizeInBits;
  private String modeName = null;
  private boolean padded;
  private String pbeAlgorithm = null;
  private PBEParameterSpec pbeSpec = null;
  private int scheme = -1;
  
  protected BaseBlockCipher(BlockCipher paramBlockCipher)
  {
    this.baseEngine = paramBlockCipher;
    this.cipher = new BufferedGenericBlockCipher(paramBlockCipher);
  }
  
  protected BaseBlockCipher(BlockCipher paramBlockCipher, int paramInt)
  {
    this.baseEngine = paramBlockCipher;
    this.cipher = new BufferedGenericBlockCipher(paramBlockCipher);
    this.ivLength = (paramInt / 8);
  }
  
  protected BaseBlockCipher(BlockCipher paramBlockCipher, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.baseEngine = paramBlockCipher;
    this.scheme = paramInt1;
    this.digest = paramInt2;
    this.keySizeInBits = paramInt3;
    this.ivLength = paramInt4;
    this.cipher = new BufferedGenericBlockCipher(paramBlockCipher);
  }
  
  protected BaseBlockCipher(BufferedBlockCipher paramBufferedBlockCipher, int paramInt)
  {
    this.baseEngine = paramBufferedBlockCipher.getUnderlyingCipher();
    this.cipher = new BufferedGenericBlockCipher(paramBufferedBlockCipher);
    this.ivLength = (paramInt / 8);
  }
  
  protected BaseBlockCipher(AEADBlockCipher paramAEADBlockCipher)
  {
    BlockCipher localBlockCipher = paramAEADBlockCipher.getUnderlyingCipher();
    this.baseEngine = localBlockCipher;
    this.ivLength = localBlockCipher.getBlockSize();
    this.cipher = new AEADGenericBlockCipher(paramAEADBlockCipher);
  }
  
  protected BaseBlockCipher(AEADBlockCipher paramAEADBlockCipher, boolean paramBoolean, int paramInt)
  {
    this.baseEngine = paramAEADBlockCipher.getUnderlyingCipher();
    this.fixedIv = paramBoolean;
    this.ivLength = paramInt;
    this.cipher = new AEADGenericBlockCipher(paramAEADBlockCipher);
  }
  
  protected BaseBlockCipher(BlockCipherProvider paramBlockCipherProvider)
  {
    this.baseEngine = paramBlockCipherProvider.get();
    this.engineProvider = paramBlockCipherProvider;
    this.cipher = new BufferedGenericBlockCipher(paramBlockCipherProvider.get());
  }
  
  private CipherParameters adjustParameters(AlgorithmParameterSpec paramAlgorithmParameterSpec, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      CipherParameters localCipherParameters = ((ParametersWithIV)paramCipherParameters).getParameters();
      if ((paramAlgorithmParameterSpec instanceof IvParameterSpec)) {}
      for (paramAlgorithmParameterSpec = new ParametersWithIV(localCipherParameters, ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());; paramAlgorithmParameterSpec = new ParametersWithIV(localCipherParameters, paramAlgorithmParameterSpec.getIV()))
      {
        this.ivParam = paramAlgorithmParameterSpec;
        return paramAlgorithmParameterSpec;
        localObject = paramCipherParameters;
        if (!(paramAlgorithmParameterSpec instanceof GOST28147ParameterSpec)) {
          return localObject;
        }
        paramAlgorithmParameterSpec = (GOST28147ParameterSpec)paramAlgorithmParameterSpec;
        paramCipherParameters = new ParametersWithSBox(paramCipherParameters, paramAlgorithmParameterSpec.getSbox());
        if ((paramAlgorithmParameterSpec.getIV() == null) || (this.ivLength == 0)) {
          break;
        }
      }
      return paramCipherParameters;
    }
    if ((paramAlgorithmParameterSpec instanceof IvParameterSpec))
    {
      paramAlgorithmParameterSpec = new ParametersWithIV(paramCipherParameters, ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());
      this.ivParam = paramAlgorithmParameterSpec;
    }
    do
    {
      do
      {
        return paramAlgorithmParameterSpec;
        localObject = paramCipherParameters;
        if (!(paramAlgorithmParameterSpec instanceof GOST28147ParameterSpec)) {
          break;
        }
        localObject = (GOST28147ParameterSpec)paramAlgorithmParameterSpec;
        paramCipherParameters = new ParametersWithSBox(paramCipherParameters, ((GOST28147ParameterSpec)localObject).getSbox());
        paramAlgorithmParameterSpec = paramCipherParameters;
      } while (((GOST28147ParameterSpec)localObject).getIV() == null);
      paramAlgorithmParameterSpec = paramCipherParameters;
    } while (this.ivLength == 0);
    Object localObject = new ParametersWithIV(paramCipherParameters, ((GOST28147ParameterSpec)localObject).getIV());
    return (CipherParameters)localObject;
  }
  
  private boolean isAEADModeName(String paramString)
  {
    return ("CCM".equals(paramString)) || ("EAX".equals(paramString)) || ("GCM".equals(paramString)) || ("OCB".equals(paramString));
  }
  
  private static Class lookup(String paramString)
  {
    try
    {
      paramString = BaseBlockCipher.class.getClassLoader().loadClass(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  protected int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalBlockSizeException, BadPaddingException, ShortBufferException
  {
    if (engineGetOutputSize(paramInt2) + paramInt3 <= paramArrayOfByte2.length) {
      if (paramInt2 == 0) {
        break label94;
      }
    }
    for (;;)
    {
      try
      {
        paramInt1 = this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
        paramInt2 = this.cipher.doFinal(paramArrayOfByte2, paramInt3 + paramInt1);
        return paramInt1 + paramInt2;
      }
      catch (DataLengthException paramArrayOfByte1)
      {
        throw new IllegalBlockSizeException(paramArrayOfByte1.getMessage());
      }
      catch (OutputLengthException paramArrayOfByte1)
      {
        throw new IllegalBlockSizeException(paramArrayOfByte1.getMessage());
      }
      throw new ShortBufferException("output buffer too short for input.");
      label94:
      paramInt1 = 0;
    }
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalBlockSizeException, BadPaddingException
  {
    int i = engineGetOutputSize(paramInt2);
    byte[] arrayOfByte = new byte[i];
    if (paramInt2 != 0) {
      paramInt1 = this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    } else {
      paramInt1 = 0;
    }
    try
    {
      paramInt2 = this.cipher.doFinal(arrayOfByte, paramInt1);
      paramInt1 += paramInt2;
      if (paramInt1 == i) {
        return arrayOfByte;
      }
      paramArrayOfByte = new byte[paramInt1];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (DataLengthException paramArrayOfByte)
    {
      throw new IllegalBlockSizeException(paramArrayOfByte.getMessage());
    }
  }
  
  protected int engineGetBlockSize()
  {
    return this.baseEngine.getBlockSize();
  }
  
  protected byte[] engineGetIV()
  {
    Object localObject = this.aeadParams;
    if (localObject != null) {
      return ((AEADParameters)localObject).getNonce();
    }
    localObject = this.ivParam;
    if (localObject != null) {
      return ((ParametersWithIV)localObject).getIV();
    }
    return null;
  }
  
  protected int engineGetKeySize(Key paramKey)
  {
    return paramKey.getEncoded().length * 8;
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return this.cipher.getOutputSize(paramInt);
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams != null) || (this.pbeSpec != null)) {}
    try
    {
      this.engineParams = createParametersInstance(this.pbeAlgorithm);
      this.engineParams.init(this.pbeSpec);
    }
    catch (Exception localException3)
    {
      String str;
      Object localObject;
      for (;;) {}
    }
    return null;
    if (this.aeadParams != null)
    {
      try
      {
        this.engineParams = createParametersInstance("GCM");
        this.engineParams.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
      }
      catch (Exception localException1)
      {
        throw new RuntimeException(localException1.toString());
      }
    }
    else if (this.ivParam != null)
    {
      str = this.cipher.getUnderlyingCipher().getAlgorithmName();
      localObject = str;
      if (str.indexOf('/') >= 0) {
        localObject = str.substring(0, str.indexOf('/'));
      }
      try
      {
        this.engineParams = createParametersInstance((String)localObject);
        this.engineParams.init(this.ivParam.getIV());
      }
      catch (Exception localException2)
      {
        throw new RuntimeException(localException2.toString());
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
        if ((i == arrayOfClass.length) || (arrayOfClass[i] != null)) {}
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
    engineInit(paramInt, paramKey, (AlgorithmParameterSpec)localObject1, paramSecureRandom);
    this.engineParams = paramAlgorithmParameters;
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
      throw new InvalidKeyException(paramKey.getMessage());
    }
  }
  
  protected void engineInit(int paramInt, Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    Object localObject2 = null;
    Object localObject1 = null;
    this.pbeSpec = null;
    this.pbeAlgorithm = null;
    this.engineParams = null;
    this.aeadParams = null;
    if (!(paramKey instanceof SecretKey))
    {
      paramSecureRandom = new StringBuilder();
      paramSecureRandom.append("Key for algorithm ");
      paramAlgorithmParameterSpec = (AlgorithmParameterSpec)localObject1;
      if (paramKey != null) {
        paramAlgorithmParameterSpec = paramKey.getAlgorithm();
      }
      paramSecureRandom.append(paramAlgorithmParameterSpec);
      paramSecureRandom.append(" not suitable for symmetric enryption.");
      throw new InvalidKeyException(paramSecureRandom.toString());
    }
    if ((paramAlgorithmParameterSpec == null) && (this.baseEngine.getAlgorithmName().startsWith("RC5-64"))) {
      throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
    }
    int i = this.scheme;
    if ((i != 2) && (!(paramKey instanceof PKCS12Key)))
    {
      if ((paramKey instanceof PBKDF1Key))
      {
        localObject1 = (PBKDF1Key)paramKey;
        if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
          this.pbeSpec = ((PBEParameterSpec)paramAlgorithmParameterSpec);
        }
        if (((localObject1 instanceof PBKDF1KeyWithParameters)) && (this.pbeSpec == null))
        {
          localObject2 = (PBKDF1KeyWithParameters)localObject1;
          this.pbeSpec = new PBEParameterSpec(((PBKDF1KeyWithParameters)localObject2).getSalt(), ((PBKDF1KeyWithParameters)localObject2).getIterationCount());
        }
        localObject2 = PBE.Util.makePBEParameters(((PBKDF1Key)localObject1).getEncoded(), 0, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
        localObject1 = localObject2;
        if (!(localObject2 instanceof ParametersWithIV)) {
          break label889;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.ivParam = ((ParametersWithIV)localObject1);
        break label889;
        if ((paramKey instanceof BCPBEKey))
        {
          localObject2 = (BCPBEKey)paramKey;
          if (((BCPBEKey)localObject2).getOID() != null) {
            localObject1 = ((BCPBEKey)localObject2).getOID().getId();
          } else {
            localObject1 = ((BCPBEKey)localObject2).getAlgorithm();
          }
          this.pbeAlgorithm = ((String)localObject1);
          if (((BCPBEKey)localObject2).getParam() != null)
          {
            localObject2 = adjustParameters(paramAlgorithmParameterSpec, ((BCPBEKey)localObject2).getParam());
          }
          else
          {
            if (!(paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
              break label416;
            }
            this.pbeSpec = ((PBEParameterSpec)paramAlgorithmParameterSpec);
            localObject2 = PBE.Util.makePBEParameters((BCPBEKey)localObject2, paramAlgorithmParameterSpec, this.cipher.getUnderlyingCipher().getAlgorithmName());
          }
          localObject1 = localObject2;
          if (!(localObject2 instanceof ParametersWithIV)) {
            break label889;
          }
          localObject1 = localObject2;
          continue;
          label416:
          throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
        }
        else
        {
          if (!(paramKey instanceof PBEKey)) {
            break;
          }
          localObject1 = (PBEKey)paramKey;
          localObject2 = (PBEParameterSpec)paramAlgorithmParameterSpec;
          this.pbeSpec = ((PBEParameterSpec)localObject2);
          if (((localObject1 instanceof PKCS12KeyWithParameters)) && (localObject2 == null)) {
            this.pbeSpec = new PBEParameterSpec(((PBEKey)localObject1).getSalt(), ((PBEKey)localObject1).getIterationCount());
          }
          localObject2 = PBE.Util.makePBEParameters(((PBEKey)localObject1).getEncoded(), this.scheme, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
          localObject1 = localObject2;
          if (!(localObject2 instanceof ParametersWithIV)) {
            break label889;
          }
          localObject1 = localObject2;
        }
      }
      localObject1 = localObject2;
      if ((paramKey instanceof RepeatedSecretKeySpec)) {
        break label889;
      }
      if ((i != 0) && (i != 4) && (i != 1) && (i != 5))
      {
        localObject1 = new KeyParameter(paramKey.getEncoded());
        break label889;
      }
      throw new InvalidKeyException("Algorithm requires a PBE key");
    }
    for (;;)
    {
      try
      {
        localObject2 = (SecretKey)paramKey;
        if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
          this.pbeSpec = ((PBEParameterSpec)paramAlgorithmParameterSpec);
        }
        boolean bool = localObject2 instanceof PBEKey;
        if ((bool) && (this.pbeSpec == null))
        {
          localObject1 = (PBEKey)localObject2;
          if (((PBEKey)localObject1).getSalt() != null) {
            this.pbeSpec = new PBEParameterSpec(((PBEKey)localObject1).getSalt(), ((PBEKey)localObject1).getIterationCount());
          } else {
            throw new InvalidAlgorithmParameterException("PBEKey requires parameters to specify salt");
          }
        }
        if ((this.pbeSpec == null) && (!bool)) {
          throw new InvalidKeyException("Algorithm requires a PBE key");
        }
        if ((paramKey instanceof BCPBEKey))
        {
          localObject1 = ((BCPBEKey)paramKey).getParam();
          if (!(localObject1 instanceof ParametersWithIV))
          {
            if (localObject1 == null) {
              localObject1 = PBE.Util.makePBEParameters(((SecretKey)localObject2).getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
            }
          }
          else
          {
            localObject2 = localObject1;
            continue;
          }
          throw new InvalidKeyException("Algorithm requires a PBE key suitable for PKCS12");
        }
        else
        {
          localObject2 = PBE.Util.makePBEParameters(((SecretKey)localObject2).getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
        }
        localObject1 = localObject2;
        if ((localObject2 instanceof ParametersWithIV))
        {
          localObject1 = localObject2;
          break;
        }
        label889:
        if ((paramAlgorithmParameterSpec instanceof AEADParameterSpec))
        {
          if ((!isAEADModeName(this.modeName)) && (!(this.cipher instanceof AEADGenericBlockCipher))) {
            throw new InvalidAlgorithmParameterException("AEADParameterSpec can only be used with AEAD modes.");
          }
          paramAlgorithmParameterSpec = (AEADParameterSpec)paramAlgorithmParameterSpec;
          if ((localObject1 instanceof ParametersWithIV)) {
            paramKey = (KeyParameter)((ParametersWithIV)localObject1).getParameters();
          } else {
            paramKey = (KeyParameter)localObject1;
          }
          paramKey = new AEADParameters(paramKey, paramAlgorithmParameterSpec.getMacSizeInBits(), paramAlgorithmParameterSpec.getNonce(), paramAlgorithmParameterSpec.getAssociatedData());
          this.aeadParams = paramKey;
        }
        else if ((paramAlgorithmParameterSpec instanceof IvParameterSpec))
        {
          if (this.ivLength != 0)
          {
            paramKey = (IvParameterSpec)paramAlgorithmParameterSpec;
            if ((paramKey.getIV().length != this.ivLength) && (!(this.cipher instanceof AEADGenericBlockCipher)) && (this.fixedIv))
            {
              paramKey = new StringBuilder();
              paramKey.append("IV must be ");
              paramKey.append(this.ivLength);
              paramKey.append(" bytes long.");
              throw new InvalidAlgorithmParameterException(paramKey.toString());
            }
            if ((localObject1 instanceof ParametersWithIV)) {
              paramKey = new ParametersWithIV(((ParametersWithIV)localObject1).getParameters(), paramKey.getIV());
            } else {
              paramKey = new ParametersWithIV((CipherParameters)localObject1, paramKey.getIV());
            }
            this.ivParam = ((ParametersWithIV)paramKey);
          }
          else
          {
            paramAlgorithmParameterSpec = this.modeName;
            paramKey = (Key)localObject1;
            if (paramAlgorithmParameterSpec != null) {
              if (!paramAlgorithmParameterSpec.equals("ECB")) {
                paramKey = (Key)localObject1;
              } else {
                throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
              }
            }
          }
        }
        else if ((paramAlgorithmParameterSpec instanceof GOST28147ParameterSpec))
        {
          localObject1 = (GOST28147ParameterSpec)paramAlgorithmParameterSpec;
          paramAlgorithmParameterSpec = new ParametersWithSBox(new KeyParameter(paramKey.getEncoded()), ((GOST28147ParameterSpec)localObject1).getSbox());
          paramKey = paramAlgorithmParameterSpec;
          if (((GOST28147ParameterSpec)localObject1).getIV() != null)
          {
            paramKey = paramAlgorithmParameterSpec;
            if (this.ivLength != 0)
            {
              if ((paramAlgorithmParameterSpec instanceof ParametersWithIV)) {
                paramKey = new ParametersWithIV(((ParametersWithIV)paramAlgorithmParameterSpec).getParameters(), ((GOST28147ParameterSpec)localObject1).getIV());
              } else {
                paramKey = new ParametersWithIV(paramAlgorithmParameterSpec, ((GOST28147ParameterSpec)localObject1).getIV());
              }
              this.ivParam = ((ParametersWithIV)paramKey);
            }
          }
        }
        else if ((paramAlgorithmParameterSpec instanceof RC2ParameterSpec))
        {
          localObject1 = (RC2ParameterSpec)paramAlgorithmParameterSpec;
          paramAlgorithmParameterSpec = new RC2Parameters(paramKey.getEncoded(), ((RC2ParameterSpec)localObject1).getEffectiveKeyBits());
          paramKey = paramAlgorithmParameterSpec;
          if (((RC2ParameterSpec)localObject1).getIV() != null)
          {
            paramKey = paramAlgorithmParameterSpec;
            if (this.ivLength != 0)
            {
              if ((paramAlgorithmParameterSpec instanceof ParametersWithIV))
              {
                paramKey = new ParametersWithIV(((ParametersWithIV)paramAlgorithmParameterSpec).getParameters(), ((RC2ParameterSpec)localObject1).getIV());
                continue;
              }
              paramKey = new ParametersWithIV(paramAlgorithmParameterSpec, ((RC2ParameterSpec)localObject1).getIV());
            }
          }
        }
        else if ((paramAlgorithmParameterSpec instanceof RC5ParameterSpec))
        {
          localObject1 = (RC5ParameterSpec)paramAlgorithmParameterSpec;
          paramAlgorithmParameterSpec = new RC5Parameters(paramKey.getEncoded(), ((RC5ParameterSpec)localObject1).getRounds());
          if (this.baseEngine.getAlgorithmName().startsWith("RC5"))
          {
            if (this.baseEngine.getAlgorithmName().equals("RC5-32"))
            {
              if (((RC5ParameterSpec)localObject1).getWordSize() != 32)
              {
                paramKey = new StringBuilder();
                paramKey.append("RC5 already set up for a word size of 32 not ");
                paramKey.append(((RC5ParameterSpec)localObject1).getWordSize());
                paramKey.append(".");
                throw new InvalidAlgorithmParameterException(paramKey.toString());
              }
            }
            else if ((this.baseEngine.getAlgorithmName().equals("RC5-64")) && (((RC5ParameterSpec)localObject1).getWordSize() != 64))
            {
              paramKey = new StringBuilder();
              paramKey.append("RC5 already set up for a word size of 64 not ");
              paramKey.append(((RC5ParameterSpec)localObject1).getWordSize());
              paramKey.append(".");
              throw new InvalidAlgorithmParameterException(paramKey.toString());
            }
            paramKey = paramAlgorithmParameterSpec;
            if (((RC5ParameterSpec)localObject1).getIV() != null)
            {
              paramKey = paramAlgorithmParameterSpec;
              if (this.ivLength != 0)
              {
                if ((paramAlgorithmParameterSpec instanceof ParametersWithIV))
                {
                  paramKey = new ParametersWithIV(((ParametersWithIV)paramAlgorithmParameterSpec).getParameters(), ((RC5ParameterSpec)localObject1).getIV());
                  continue;
                }
                paramKey = new ParametersWithIV(paramAlgorithmParameterSpec, ((RC5ParameterSpec)localObject1).getIV());
              }
            }
          }
          else
          {
            throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
          }
        }
        else
        {
          paramKey = gcmSpecClass;
          if ((paramKey != null) && (paramKey.isInstance(paramAlgorithmParameterSpec))) {
            if ((!isAEADModeName(this.modeName)) && (!(this.cipher instanceof AEADGenericBlockCipher))) {
              throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
            }
          }
        }
      }
      catch (Exception paramKey)
      {
        Method localMethod;
        continue;
      }
      try
      {
        localObject2 = gcmSpecClass.getDeclaredMethod("getTLen", new Class[0]);
        localMethod = gcmSpecClass.getDeclaredMethod("getIV", new Class[0]);
        paramKey = (Key)localObject1;
        if ((localObject1 instanceof ParametersWithIV)) {
          paramKey = ((ParametersWithIV)localObject1).getParameters();
        }
        paramKey = new AEADParameters((KeyParameter)paramKey, ((Integer)((Method)localObject2).invoke(paramAlgorithmParameterSpec, new Object[0])).intValue(), (byte[])localMethod.invoke(paramAlgorithmParameterSpec, new Object[0]));
        this.aeadParams = paramKey;
      }
      catch (Exception paramKey) {}
    }
    throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
    paramKey = (Key)localObject1;
    if (paramAlgorithmParameterSpec != null) {
      if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
        paramKey = (Key)localObject1;
      } else {
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
      }
    }
    paramAlgorithmParameterSpec = paramKey;
    if (this.ivLength != 0)
    {
      paramAlgorithmParameterSpec = paramKey;
      if (!(paramKey instanceof ParametersWithIV))
      {
        paramAlgorithmParameterSpec = paramKey;
        if (!(paramKey instanceof AEADParameters))
        {
          if (paramSecureRandom == null) {
            paramAlgorithmParameterSpec = new SecureRandom();
          } else {
            paramAlgorithmParameterSpec = paramSecureRandom;
          }
          if ((paramInt != 1) && (paramInt != 3))
          {
            if (this.cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") >= 0) {
              paramAlgorithmParameterSpec = paramKey;
            } else {
              throw new InvalidAlgorithmParameterException("no IV set when one expected");
            }
          }
          else
          {
            localObject1 = new byte[this.ivLength];
            paramAlgorithmParameterSpec.nextBytes((byte[])localObject1);
            paramAlgorithmParameterSpec = new ParametersWithIV(paramKey, (byte[])localObject1);
            this.ivParam = ((ParametersWithIV)paramAlgorithmParameterSpec);
          }
        }
      }
    }
    paramKey = paramAlgorithmParameterSpec;
    if (paramSecureRandom != null)
    {
      paramKey = paramAlgorithmParameterSpec;
      if (this.padded) {
        paramKey = new ParametersWithRandom(paramAlgorithmParameterSpec, paramSecureRandom);
      }
    }
    if ((paramInt == 1) || ((paramInt != 2) && ((paramInt == 3) || (paramInt != 4)))) {}
    try
    {
      paramKey = new StringBuilder();
      paramKey.append("unknown opmode ");
      paramKey.append(paramInt);
      paramKey.append(" passed");
      throw new InvalidParameterException(paramKey.toString());
    }
    catch (Exception paramKey)
    {
      label2120:
      throw new InvalidKeyOrParametersException(paramKey.getMessage(), paramKey);
    }
    this.cipher.init(false, paramKey);
    break label2120;
    this.cipher.init(true, paramKey);
    if (((this.cipher instanceof AEADGenericBlockCipher)) && (this.aeadParams == null))
    {
      paramKey = ((AEADGenericBlockCipher)this.cipher).cipher;
      this.aeadParams = new AEADParameters((KeyParameter)this.ivParam.getParameters(), paramKey.getMac().length * 8, this.ivParam.getIV());
    }
    return;
    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
  }
  
  protected void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    Object localObject = Strings.toUpperCase(paramString);
    this.modeName = ((String)localObject);
    if (((String)localObject).equals("ECB"))
    {
      this.ivLength = 0;
      paramString = new BufferedGenericBlockCipher(this.baseEngine);
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      if (this.modeName.equals("CBC"))
      {
        this.ivLength = this.baseEngine.getBlockSize();
        paramString = new BufferedGenericBlockCipher(new CBCBlockCipher(this.baseEngine));
      }
      else
      {
        int i;
        if (this.modeName.startsWith("OFB"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          if (this.modeName.length() != 3)
          {
            i = Integer.parseInt(this.modeName.substring(3));
            paramString = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, i));
          }
        }
        for (;;)
        {
          this.cipher = paramString;
          return;
          paramString = this.baseEngine;
          paramString = new BufferedGenericBlockCipher(new OFBBlockCipher(paramString, paramString.getBlockSize() * 8));
          break;
          if (this.modeName.startsWith("CFB"))
          {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3)
            {
              i = Integer.parseInt(this.modeName.substring(3));
              paramString = new BufferedGenericBlockCipher(new CFBBlockCipher(this.baseEngine, i));
              continue;
            }
            paramString = this.baseEngine;
            paramString = new BufferedGenericBlockCipher(new CFBBlockCipher(paramString, paramString.getBlockSize() * 8));
            break;
          }
          if (!this.modeName.startsWith("PGP")) {
            break label367;
          }
          boolean bool = this.modeName.equalsIgnoreCase("PGPCFBwithIV");
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, bool));
        }
        label367:
        if (this.modeName.equalsIgnoreCase("OpenPGPCFB"))
        {
          this.ivLength = 0;
          paramString = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
        }
        else if (this.modeName.startsWith("SIC"))
        {
          i = this.baseEngine.getBlockSize();
          this.ivLength = i;
          if (i >= 16)
          {
            this.fixedIv = false;
            paramString = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
          }
          else
          {
            throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
          }
        }
        else if (this.modeName.startsWith("CTR"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          this.fixedIv = false;
          paramString = new BufferedGenericBlockCipher(new BufferedBlockCipher(new SICBlockCipher(this.baseEngine)));
        }
        else if (this.modeName.startsWith("GOFB"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
        }
        else if (this.modeName.startsWith("GCFB"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new BufferedGenericBlockCipher(new BufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
        }
        else if (this.modeName.startsWith("CTS"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new BufferedGenericBlockCipher(new CTSBlockCipher(new CBCBlockCipher(this.baseEngine)));
        }
        else if (this.modeName.startsWith("CCM"))
        {
          this.ivLength = 13;
          paramString = new AEADGenericBlockCipher(new CCMBlockCipher(this.baseEngine));
        }
        else if (this.modeName.startsWith("OCB"))
        {
          localObject = this.engineProvider;
          if (localObject != null)
          {
            this.ivLength = 15;
            paramString = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, ((BlockCipherProvider)localObject).get()));
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("can't support mode ");
            ((StringBuilder)localObject).append(paramString);
            throw new NoSuchAlgorithmException(((StringBuilder)localObject).toString());
          }
        }
        else if (this.modeName.startsWith("EAX"))
        {
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
        }
        else
        {
          if (!this.modeName.startsWith("GCM")) {
            break;
          }
          this.ivLength = this.baseEngine.getBlockSize();
          paramString = new AEADGenericBlockCipher(new GCMBlockCipher(this.baseEngine));
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can't support mode ");
    ((StringBuilder)localObject).append(paramString);
    throw new NoSuchAlgorithmException(((StringBuilder)localObject).toString());
  }
  
  protected void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    Object localObject = Strings.toUpperCase(paramString);
    if (((String)localObject).equals("NOPADDING"))
    {
      if (!this.cipher.wrapOnNoPadding()) {
        break label419;
      }
      paramString = new BufferedGenericBlockCipher(new BufferedBlockCipher(this.cipher.getUnderlyingCipher()));
    }
    else
    {
      if (!((String)localObject).equals("WITHCTS")) {
        break label94;
      }
      paramString = new BufferedGenericBlockCipher(new CTSBlockCipher(this.cipher.getUnderlyingCipher()));
    }
    for (;;)
    {
      this.cipher = paramString;
      return;
      label94:
      this.padded = true;
      if (isAEADModeName(this.modeName)) {
        break;
      }
      if ((!((String)localObject).equals("PKCS5PADDING")) && (!((String)localObject).equals("PKCS7PADDING")))
      {
        if (((String)localObject).equals("ZEROBYTEPADDING")) {
          paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ZeroBytePadding());
        } else if ((!((String)localObject).equals("ISO10126PADDING")) && (!((String)localObject).equals("ISO10126-2PADDING")))
        {
          if ((!((String)localObject).equals("X9.23PADDING")) && (!((String)localObject).equals("X923PADDING")))
          {
            if ((!((String)localObject).equals("ISO7816-4PADDING")) && (!((String)localObject).equals("ISO9797-1PADDING")))
            {
              if (((String)localObject).equals("TBCPADDING"))
              {
                paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new TBCPadding());
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
              paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            }
          }
          else {
            paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new X923Padding());
          }
        }
        else {
          paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher(), new ISO10126d2Padding());
        }
      }
      else {
        paramString = new BufferedGenericBlockCipher(this.cipher.getUnderlyingCipher());
      }
    }
    label419:
    return;
    throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    if (this.cipher.getUpdateOutputSize(paramInt2) + paramInt3 <= paramArrayOfByte2.length) {
      try
      {
        paramInt1 = this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
        return paramInt1;
      }
      catch (DataLengthException paramArrayOfByte1)
      {
        throw new IllegalStateException(paramArrayOfByte1.toString());
      }
    }
    throw new ShortBufferException("output buffer too short for input.");
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.cipher.getUpdateOutputSize(paramInt2);
    if (i > 0)
    {
      byte[] arrayOfByte = new byte[i];
      paramInt1 = this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
      if (paramInt1 == 0) {
        return null;
      }
      if (paramInt1 != i)
      {
        paramArrayOfByte = new byte[paramInt1];
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, paramInt1);
        return paramArrayOfByte;
      }
      return arrayOfByte;
    }
    this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, null, 0);
    return null;
  }
  
  protected void engineUpdateAAD(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.arrayOffset();
    int j = paramByteBuffer.position();
    int k = paramByteBuffer.limit();
    int m = paramByteBuffer.position();
    engineUpdateAAD(paramByteBuffer.array(), i + j, k - m);
  }
  
  protected void engineUpdateAAD(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.cipher.updateAAD(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static class AEADGenericBlockCipher
    implements BaseBlockCipher.GenericBlockCipher
  {
    private static final Constructor aeadBadTagConstructor;
    private AEADBlockCipher cipher;
    
    static
    {
      Object localObject = BaseBlockCipher.lookup("javax.crypto.AEADBadTagException");
      if (localObject != null) {
        localObject = findExceptionConstructor((Class)localObject);
      } else {
        localObject = null;
      }
      aeadBadTagConstructor = (Constructor)localObject;
    }
    
    AEADGenericBlockCipher(AEADBlockCipher paramAEADBlockCipher)
    {
      this.cipher = paramAEADBlockCipher;
    }
    
    private static Constructor findExceptionConstructor(Class paramClass)
    {
      try
      {
        paramClass = paramClass.getConstructor(new Class[] { String.class });
        return paramClass;
      }
      catch (Exception paramClass)
      {
        for (;;) {}
      }
      return null;
    }
    
    public int doFinal(byte[] paramArrayOfByte, int paramInt)
      throws IllegalStateException, BadPaddingException
    {
      Object localObject;
      try
      {
        paramInt = this.cipher.doFinal(paramArrayOfByte, paramInt);
        return paramInt;
      }
      catch (InvalidCipherTextException localInvalidCipherTextException)
      {
        localObject = aeadBadTagConstructor;
        if (localObject == null) {
          break label57;
        }
      }
      paramArrayOfByte = null;
      try
      {
        localObject = (BadPaddingException)((Constructor)localObject).newInstance(new Object[] { localInvalidCipherTextException.getMessage() });
        paramArrayOfByte = (byte[])localObject;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      if (paramArrayOfByte != null) {
        throw paramArrayOfByte;
      }
      label57:
      throw new BadPaddingException(localInvalidCipherTextException.getMessage());
    }
    
    public String getAlgorithmName()
    {
      return this.cipher.getUnderlyingCipher().getAlgorithmName();
    }
    
    public int getOutputSize(int paramInt)
    {
      return this.cipher.getOutputSize(paramInt);
    }
    
    public BlockCipher getUnderlyingCipher()
    {
      return this.cipher.getUnderlyingCipher();
    }
    
    public int getUpdateOutputSize(int paramInt)
    {
      return this.cipher.getUpdateOutputSize(paramInt);
    }
    
    public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
      throws IllegalArgumentException
    {
      this.cipher.init(paramBoolean, paramCipherParameters);
    }
    
    public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
      throws DataLengthException
    {
      return this.cipher.processByte(paramByte, paramArrayOfByte, paramInt);
    }
    
    public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
      throws DataLengthException
    {
      return this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
    }
    
    public void updateAAD(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.cipher.processAADBytes(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public boolean wrapOnNoPadding()
    {
      return false;
    }
  }
  
  private static class BufferedGenericBlockCipher
    implements BaseBlockCipher.GenericBlockCipher
  {
    private BufferedBlockCipher cipher;
    
    BufferedGenericBlockCipher(BlockCipher paramBlockCipher)
    {
      this.cipher = new PaddedBufferedBlockCipher(paramBlockCipher);
    }
    
    BufferedGenericBlockCipher(BlockCipher paramBlockCipher, BlockCipherPadding paramBlockCipherPadding)
    {
      this.cipher = new PaddedBufferedBlockCipher(paramBlockCipher, paramBlockCipherPadding);
    }
    
    BufferedGenericBlockCipher(BufferedBlockCipher paramBufferedBlockCipher)
    {
      this.cipher = paramBufferedBlockCipher;
    }
    
    public int doFinal(byte[] paramArrayOfByte, int paramInt)
      throws IllegalStateException, BadPaddingException
    {
      try
      {
        paramInt = this.cipher.doFinal(paramArrayOfByte, paramInt);
        return paramInt;
      }
      catch (InvalidCipherTextException paramArrayOfByte)
      {
        throw new BadPaddingException(paramArrayOfByte.getMessage());
      }
    }
    
    public String getAlgorithmName()
    {
      return this.cipher.getUnderlyingCipher().getAlgorithmName();
    }
    
    public int getOutputSize(int paramInt)
    {
      return this.cipher.getOutputSize(paramInt);
    }
    
    public BlockCipher getUnderlyingCipher()
    {
      return this.cipher.getUnderlyingCipher();
    }
    
    public int getUpdateOutputSize(int paramInt)
    {
      return this.cipher.getUpdateOutputSize(paramInt);
    }
    
    public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
      throws IllegalArgumentException
    {
      this.cipher.init(paramBoolean, paramCipherParameters);
    }
    
    public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
      throws DataLengthException
    {
      return this.cipher.processByte(paramByte, paramArrayOfByte, paramInt);
    }
    
    public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
      throws DataLengthException
    {
      return this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
    }
    
    public void updateAAD(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      throw new UnsupportedOperationException("AAD is not supported in the current mode.");
    }
    
    public boolean wrapOnNoPadding()
    {
      return this.cipher instanceof CTSBlockCipher ^ true;
    }
  }
  
  private static abstract interface GenericBlockCipher
  {
    public abstract int doFinal(byte[] paramArrayOfByte, int paramInt)
      throws IllegalStateException, BadPaddingException;
    
    public abstract String getAlgorithmName();
    
    public abstract int getOutputSize(int paramInt);
    
    public abstract BlockCipher getUnderlyingCipher();
    
    public abstract int getUpdateOutputSize(int paramInt);
    
    public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters)
      throws IllegalArgumentException;
    
    public abstract int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
      throws DataLengthException;
    
    public abstract int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
      throws DataLengthException;
    
    public abstract void updateAAD(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    public abstract boolean wrapOnNoPadding();
  }
  
  private static class InvalidKeyOrParametersException
    extends InvalidKeyException
  {
    private final Throwable cause;
    
    InvalidKeyOrParametersException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */