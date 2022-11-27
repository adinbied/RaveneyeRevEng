package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.TigerDigest;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.util.DigestFactory;

public abstract interface PBE
{
  public static final int GOST3411 = 6;
  public static final int MD2 = 5;
  public static final int MD5 = 0;
  public static final int OPENSSL = 3;
  public static final int PKCS12 = 2;
  public static final int PKCS5S1 = 0;
  public static final int PKCS5S1_UTF8 = 4;
  public static final int PKCS5S2 = 1;
  public static final int PKCS5S2_UTF8 = 5;
  public static final int RIPEMD160 = 2;
  public static final int SHA1 = 1;
  public static final int SHA224 = 7;
  public static final int SHA256 = 4;
  public static final int SHA384 = 8;
  public static final int SHA512 = 9;
  public static final int TIGER = 3;
  
  public static class Util
  {
    private static byte[] convertPassword(int paramInt, PBEKeySpec paramPBEKeySpec)
    {
      if (paramInt == 2) {
        return PBEParametersGenerator.PKCS12PasswordToBytes(paramPBEKeySpec.getPassword());
      }
      if ((paramInt != 5) && (paramInt != 4)) {
        return PBEParametersGenerator.PKCS5PasswordToBytes(paramPBEKeySpec.getPassword());
      }
      return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(paramPBEKeySpec.getPassword());
    }
    
    private static PBEParametersGenerator makePBEGenerator(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        if ((paramInt1 != 1) && (paramInt1 != 5))
        {
          if (paramInt1 == 2)
          {
            switch (paramInt2)
            {
            default: 
              throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            case 9: 
              return new PKCS12ParametersGenerator(DigestFactory.createSHA512());
            case 8: 
              return new PKCS12ParametersGenerator(DigestFactory.createSHA384());
            case 7: 
              return new PKCS12ParametersGenerator(DigestFactory.createSHA224());
            case 6: 
              return new PKCS12ParametersGenerator(new GOST3411Digest());
            case 5: 
              return new PKCS12ParametersGenerator(new MD2Digest());
            case 4: 
              return new PKCS12ParametersGenerator(DigestFactory.createSHA256());
            case 3: 
              return new PKCS12ParametersGenerator(new TigerDigest());
            case 2: 
              return new PKCS12ParametersGenerator(new RIPEMD160Digest());
            case 1: 
              return new PKCS12ParametersGenerator(DigestFactory.createSHA1());
            }
            return new PKCS12ParametersGenerator(DigestFactory.createMD5());
          }
          return new OpenSSLPBEParametersGenerator();
        }
        switch (paramInt2)
        {
        default: 
          throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
        case 9: 
          return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512());
        case 8: 
          return new PKCS5S2ParametersGenerator(DigestFactory.createSHA384());
        case 7: 
          return new PKCS5S2ParametersGenerator(DigestFactory.createSHA224());
        case 6: 
          return new PKCS5S2ParametersGenerator(new GOST3411Digest());
        case 5: 
          return new PKCS5S2ParametersGenerator(new MD2Digest());
        case 4: 
          return new PKCS5S2ParametersGenerator(DigestFactory.createSHA256());
        case 3: 
          return new PKCS5S2ParametersGenerator(new TigerDigest());
        case 2: 
          return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
        case 1: 
          return new PKCS5S2ParametersGenerator(DigestFactory.createSHA1());
        }
        return new PKCS5S2ParametersGenerator(DigestFactory.createMD5());
      }
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 == 5) {
            return new PKCS5S1ParametersGenerator(new MD2Digest());
          }
          throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
        }
        return new PKCS5S1ParametersGenerator(DigestFactory.createSHA1());
      }
      return new PKCS5S1ParametersGenerator(DigestFactory.createMD5());
    }
    
    public static CipherParameters makePBEMacParameters(SecretKey paramSecretKey, int paramInt1, int paramInt2, int paramInt3, PBEParameterSpec paramPBEParameterSpec)
    {
      PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
      byte[] arrayOfByte = paramSecretKey.getEncoded();
      localPBEParametersGenerator.init(paramSecretKey.getEncoded(), paramPBEParameterSpec.getSalt(), paramPBEParameterSpec.getIterationCount());
      paramSecretKey = localPBEParametersGenerator.generateDerivedMacParameters(paramInt3);
      paramInt1 = 0;
      while (paramInt1 != arrayOfByte.length)
      {
        arrayOfByte[paramInt1] = 0;
        paramInt1 += 1;
      }
      return paramSecretKey;
    }
    
    public static CipherParameters makePBEMacParameters(PBEKeySpec paramPBEKeySpec, int paramInt1, int paramInt2, int paramInt3)
    {
      PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
      byte[] arrayOfByte = convertPassword(paramInt1, paramPBEKeySpec);
      localPBEParametersGenerator.init(arrayOfByte, paramPBEKeySpec.getSalt(), paramPBEKeySpec.getIterationCount());
      paramPBEKeySpec = localPBEParametersGenerator.generateDerivedMacParameters(paramInt3);
      paramInt1 = 0;
      while (paramInt1 != arrayOfByte.length)
      {
        arrayOfByte[paramInt1] = 0;
        paramInt1 += 1;
      }
      return paramPBEKeySpec;
    }
    
    public static CipherParameters makePBEMacParameters(BCPBEKey paramBCPBEKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    {
      if ((paramAlgorithmParameterSpec != null) && ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)))
      {
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramBCPBEKey.getType(), paramBCPBEKey.getDigest());
        localPBEParametersGenerator.init(paramBCPBEKey.getEncoded(), paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        return localPBEParametersGenerator.generateDerivedMacParameters(paramBCPBEKey.getKeySize());
      }
      throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
    }
    
    public static CipherParameters makePBEParameters(PBEKeySpec paramPBEKeySpec, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
      byte[] arrayOfByte = convertPassword(paramInt1, paramPBEKeySpec);
      localPBEParametersGenerator.init(arrayOfByte, paramPBEKeySpec.getSalt(), paramPBEKeySpec.getIterationCount());
      if (paramInt4 != 0) {
        paramPBEKeySpec = localPBEParametersGenerator.generateDerivedParameters(paramInt3, paramInt4);
      } else {
        paramPBEKeySpec = localPBEParametersGenerator.generateDerivedParameters(paramInt3);
      }
      paramInt1 = 0;
      while (paramInt1 != arrayOfByte.length)
      {
        arrayOfByte[paramInt1] = 0;
        paramInt1 += 1;
      }
      return paramPBEKeySpec;
    }
    
    public static CipherParameters makePBEParameters(BCPBEKey paramBCPBEKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, String paramString)
    {
      if ((paramAlgorithmParameterSpec != null) && ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)))
      {
        PBEParameterSpec localPBEParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramBCPBEKey.getType(), paramBCPBEKey.getDigest());
        paramAlgorithmParameterSpec = paramBCPBEKey.getEncoded();
        if (paramBCPBEKey.shouldTryWrongPKCS12()) {
          paramAlgorithmParameterSpec = new byte[2];
        }
        localPBEParametersGenerator.init(paramAlgorithmParameterSpec, localPBEParameterSpec.getSalt(), localPBEParameterSpec.getIterationCount());
        if (paramBCPBEKey.getIvSize() != 0) {
          paramBCPBEKey = localPBEParametersGenerator.generateDerivedParameters(paramBCPBEKey.getKeySize(), paramBCPBEKey.getIvSize());
        } else {
          paramBCPBEKey = localPBEParametersGenerator.generateDerivedParameters(paramBCPBEKey.getKeySize());
        }
        if (paramString.startsWith("DES"))
        {
          if ((paramBCPBEKey instanceof ParametersWithIV))
          {
            DESParameters.setOddParity(((KeyParameter)((ParametersWithIV)paramBCPBEKey).getParameters()).getKey());
            return paramBCPBEKey;
          }
          DESParameters.setOddParity(((KeyParameter)paramBCPBEKey).getKey());
        }
        return paramBCPBEKey;
      }
      throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
    }
    
    public static CipherParameters makePBEParameters(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, AlgorithmParameterSpec paramAlgorithmParameterSpec, String paramString)
      throws InvalidAlgorithmParameterException
    {
      if ((paramAlgorithmParameterSpec != null) && ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)))
      {
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
        localPBEParametersGenerator.init(paramArrayOfByte, paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        if (paramInt4 != 0) {
          paramArrayOfByte = localPBEParametersGenerator.generateDerivedParameters(paramInt3, paramInt4);
        } else {
          paramArrayOfByte = localPBEParametersGenerator.generateDerivedParameters(paramInt3);
        }
        if (paramString.startsWith("DES"))
        {
          if ((paramArrayOfByte instanceof ParametersWithIV))
          {
            DESParameters.setOddParity(((KeyParameter)((ParametersWithIV)paramArrayOfByte).getParameters()).getKey());
            return paramArrayOfByte;
          }
          DESParameters.setOddParity(((KeyParameter)paramArrayOfByte).getKey());
        }
        return paramArrayOfByte;
      }
      throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\PBE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */