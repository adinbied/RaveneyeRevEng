package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;

public class BaseStreamCipher
  extends BaseWrapCipher
  implements PBE
{
  private Class[] availableSpecs = { RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class };
  private StreamCipher cipher;
  private int digest;
  private int ivLength = 0;
  private ParametersWithIV ivParam;
  private int keySizeInBits;
  private String pbeAlgorithm = null;
  private PBEParameterSpec pbeSpec = null;
  
  protected BaseStreamCipher(StreamCipher paramStreamCipher, int paramInt)
  {
    this(paramStreamCipher, paramInt, -1, -1);
  }
  
  protected BaseStreamCipher(StreamCipher paramStreamCipher, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cipher = paramStreamCipher;
    this.ivLength = paramInt1;
    this.keySizeInBits = paramInt2;
    this.digest = paramInt3;
  }
  
  protected int engineDoFinal(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
    {
      if (paramInt2 != 0) {
        this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
      }
      this.cipher.reset();
      return paramInt2;
    }
    throw new ShortBufferException("output buffer too short for input.");
  }
  
  protected byte[] engineDoFinal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      paramArrayOfByte = engineUpdate(paramArrayOfByte, paramInt1, paramInt2);
      this.cipher.reset();
      return paramArrayOfByte;
    }
    this.cipher.reset();
    return new byte[0];
  }
  
  protected int engineGetBlockSize()
  {
    return 0;
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
    return paramKey.getEncoded().length * 8;
  }
  
  protected int engineGetOutputSize(int paramInt)
  {
    return paramInt;
  }
  
  protected AlgorithmParameters engineGetParameters()
  {
    if ((this.engineParams == null) && (this.pbeSpec != null)) {}
    try
    {
      AlgorithmParameters localAlgorithmParameters = createParametersInstance(this.pbeAlgorithm);
      localAlgorithmParameters.init(this.pbeSpec);
      return localAlgorithmParameters;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return null;
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
    this.pbeSpec = null;
    this.pbeAlgorithm = null;
    this.engineParams = null;
    if ((paramKey instanceof SecretKey))
    {
      if ((paramKey instanceof PKCS12Key))
      {
        paramKey = (PKCS12Key)paramKey;
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        this.pbeSpec = paramAlgorithmParameterSpec;
        if (((paramKey instanceof PKCS12KeyWithParameters)) && (paramAlgorithmParameterSpec == null))
        {
          paramAlgorithmParameterSpec = (PKCS12KeyWithParameters)paramKey;
          this.pbeSpec = new PBEParameterSpec(paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        }
        paramKey = PBE.Util.makePBEParameters(paramKey.getEncoded(), 2, this.digest, this.keySizeInBits, this.ivLength * 8, this.pbeSpec, this.cipher.getAlgorithmName());
      }
      else
      {
        if ((paramKey instanceof BCPBEKey))
        {
          BCPBEKey localBCPBEKey = (BCPBEKey)paramKey;
          if (localBCPBEKey.getOID() != null) {
            paramKey = localBCPBEKey.getOID().getId();
          } else {
            paramKey = localBCPBEKey.getAlgorithm();
          }
          this.pbeAlgorithm = paramKey;
          if (localBCPBEKey.getParam() != null)
          {
            paramKey = localBCPBEKey.getParam();
            this.pbeSpec = new PBEParameterSpec(localBCPBEKey.getSalt(), localBCPBEKey.getIterationCount());
          }
          else
          {
            if (!(paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
              break label255;
            }
            paramKey = PBE.Util.makePBEParameters(localBCPBEKey, paramAlgorithmParameterSpec, this.cipher.getAlgorithmName());
            this.pbeSpec = ((PBEParameterSpec)paramAlgorithmParameterSpec);
          }
          paramAlgorithmParameterSpec = paramKey;
          if (localBCPBEKey.getIvSize() != 0)
          {
            this.ivParam = ((ParametersWithIV)paramKey);
            paramAlgorithmParameterSpec = paramKey;
            break label290;
            label255:
            throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
          }
        }
        else
        {
          if (paramAlgorithmParameterSpec != null) {
            break label305;
          }
          if (this.digest > 0) {
            break label295;
          }
          paramAlgorithmParameterSpec = new KeyParameter(paramKey.getEncoded());
        }
        label290:
        paramKey = paramAlgorithmParameterSpec;
        break label348;
        label295:
        throw new InvalidKeyException("Algorithm requires a PBE key");
        label305:
        if (!(paramAlgorithmParameterSpec instanceof IvParameterSpec)) {
          break label538;
        }
        paramKey = new ParametersWithIV(new KeyParameter(paramKey.getEncoded()), ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());
        this.ivParam = ((ParametersWithIV)paramKey);
      }
      label348:
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
        throw new InvalidKeyException(paramKey.getMessage());
      }
      this.cipher.init(false, paramAlgorithmParameterSpec);
      return;
      this.cipher.init(true, paramAlgorithmParameterSpec);
      return;
      label538:
      throw new InvalidAlgorithmParameterException("unknown parameter type.");
    }
    paramAlgorithmParameterSpec = new StringBuilder();
    paramAlgorithmParameterSpec.append("Key for algorithm ");
    paramAlgorithmParameterSpec.append(paramKey.getAlgorithm());
    paramAlgorithmParameterSpec.append(" not suitable for symmetric enryption.");
    throw new InvalidKeyException(paramAlgorithmParameterSpec.toString());
  }
  
  protected void engineSetMode(String paramString)
    throws NoSuchAlgorithmException
  {
    if (paramString.equalsIgnoreCase("ECB")) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("can't support mode ");
    localStringBuilder.append(paramString);
    throw new NoSuchAlgorithmException(localStringBuilder.toString());
  }
  
  protected void engineSetPadding(String paramString)
    throws NoSuchPaddingException
  {
    if (paramString.equalsIgnoreCase("NoPadding")) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Padding ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" unknown.");
    throw new NoSuchPaddingException(localStringBuilder.toString());
  }
  
  protected int engineUpdate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws ShortBufferException
  {
    if (paramInt3 + paramInt2 <= paramArrayOfByte2.length) {
      try
      {
        this.cipher.processBytes(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
        return paramInt2;
      }
      catch (DataLengthException paramArrayOfByte1)
      {
        throw new IllegalStateException(paramArrayOfByte1.getMessage());
      }
    }
    throw new ShortBufferException("output buffer too short for input.");
  }
  
  protected byte[] engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    this.cipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseStreamCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */