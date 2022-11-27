package org.bouncycastle.jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

public abstract interface BrokenPBE
{
  public static final int MD5 = 0;
  public static final int OLD_PKCS12 = 3;
  public static final int PKCS12 = 2;
  public static final int PKCS5S1 = 0;
  public static final int PKCS5S2 = 1;
  public static final int RIPEMD160 = 2;
  public static final int SHA1 = 1;
  
  public static class Util
  {
    private static PBEParametersGenerator makePBEGenerator(int paramInt1, int paramInt2)
    {
      if (paramInt1 == 0)
      {
        if (paramInt2 != 0)
        {
          if (paramInt2 == 1) {
            return new PKCS5S1ParametersGenerator(new SHA1Digest());
          }
          throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
        }
        return new PKCS5S1ParametersGenerator(new MD5Digest());
      }
      if (paramInt1 == 1) {
        return new PKCS5S2ParametersGenerator();
      }
      if (paramInt1 == 3)
      {
        if (paramInt2 != 0)
        {
          if (paramInt2 != 1)
          {
            if (paramInt2 == 2) {
              return new OldPKCS12ParametersGenerator(new RIPEMD160Digest());
            }
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
          }
          return new OldPKCS12ParametersGenerator(new SHA1Digest());
        }
        return new OldPKCS12ParametersGenerator(new MD5Digest());
      }
      if (paramInt2 != 0)
      {
        if (paramInt2 != 1)
        {
          if (paramInt2 == 2) {
            return new PKCS12ParametersGenerator(new RIPEMD160Digest());
          }
          throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        }
        return new PKCS12ParametersGenerator(new SHA1Digest());
      }
      return new PKCS12ParametersGenerator(new MD5Digest());
    }
    
    static CipherParameters makePBEMacParameters(BCPBEKey paramBCPBEKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramAlgorithmParameterSpec != null) && ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)))
      {
        paramAlgorithmParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
        paramBCPBEKey = paramBCPBEKey.getEncoded();
        localPBEParametersGenerator.init(paramBCPBEKey, paramAlgorithmParameterSpec.getSalt(), paramAlgorithmParameterSpec.getIterationCount());
        paramAlgorithmParameterSpec = localPBEParametersGenerator.generateDerivedMacParameters(paramInt3);
        paramInt1 = 0;
        while (paramInt1 != paramBCPBEKey.length)
        {
          paramBCPBEKey[paramInt1] = 0;
          paramInt1 += 1;
        }
        return paramAlgorithmParameterSpec;
      }
      throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
    }
    
    static CipherParameters makePBEParameters(BCPBEKey paramBCPBEKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
    {
      if ((paramAlgorithmParameterSpec != null) && ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)))
      {
        PBEParameterSpec localPBEParameterSpec = (PBEParameterSpec)paramAlgorithmParameterSpec;
        PBEParametersGenerator localPBEParametersGenerator = makePBEGenerator(paramInt1, paramInt2);
        paramAlgorithmParameterSpec = paramBCPBEKey.getEncoded();
        localPBEParametersGenerator.init(paramAlgorithmParameterSpec, localPBEParameterSpec.getSalt(), localPBEParameterSpec.getIterationCount());
        if (paramInt4 != 0) {
          paramBCPBEKey = localPBEParametersGenerator.generateDerivedParameters(paramInt3, paramInt4);
        } else {
          paramBCPBEKey = localPBEParametersGenerator.generateDerivedParameters(paramInt3);
        }
        if (paramString.startsWith("DES")) {
          if ((paramBCPBEKey instanceof ParametersWithIV)) {
            setOddParity(((KeyParameter)((ParametersWithIV)paramBCPBEKey).getParameters()).getKey());
          } else {
            setOddParity(((KeyParameter)paramBCPBEKey).getKey());
          }
        }
        paramInt1 = 0;
        while (paramInt1 != paramAlgorithmParameterSpec.length)
        {
          paramAlgorithmParameterSpec[paramInt1] = 0;
          paramInt1 += 1;
        }
        return paramBCPBEKey;
      }
      throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
    }
    
    private static void setOddParity(byte[] paramArrayOfByte)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        paramArrayOfByte[i] = ((byte)(j >> 7 ^ j >> 1 ^ j >> 2 ^ j >> 3 ^ j >> 4 ^ j >> 5 ^ j >> 6 ^ 0x1 | j & 0xFE));
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\BrokenPBE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */