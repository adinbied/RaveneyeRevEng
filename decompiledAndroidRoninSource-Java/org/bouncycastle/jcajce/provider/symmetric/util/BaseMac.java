package org.bouncycastle.jcajce.provider.symmetric.util;

import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.params.SkeinParameters.Builder;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.spec.AEADParameterSpec;
import org.bouncycastle.jcajce.spec.SkeinParameterSpec;

public class BaseMac
  extends MacSpi
  implements PBE
{
  private static final Class gcmSpecClass = lookup("javax.crypto.spec.GCMParameterSpec");
  private int keySize = 160;
  private Mac macEngine;
  private int pbeHash = 1;
  private int scheme = 2;
  
  protected BaseMac(Mac paramMac)
  {
    this.macEngine = paramMac;
  }
  
  protected BaseMac(Mac paramMac, int paramInt1, int paramInt2, int paramInt3)
  {
    this.macEngine = paramMac;
    this.scheme = paramInt1;
    this.pbeHash = paramInt2;
    this.keySize = paramInt3;
  }
  
  private static Hashtable copyMap(Map paramMap)
  {
    Hashtable localHashtable = new Hashtable();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      localHashtable.put(localObject, paramMap.get(localObject));
    }
    return localHashtable;
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
  
  protected byte[] engineDoFinal()
  {
    byte[] arrayOfByte = new byte[engineGetMacLength()];
    this.macEngine.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  protected int engineGetMacLength()
  {
    return this.macEngine.getMacSize();
  }
  
  protected void engineInit(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramKey == null) || ((paramKey instanceof PKCS12Key))) {}
    for (;;)
    {
      try
      {
        localSecretKey = (SecretKey)paramKey;
      }
      catch (Exception paramKey)
      {
        SecretKey localSecretKey;
        Object localObject2;
        Object localObject1;
        int k;
        boolean bool;
        int j;
        int i;
        continue;
      }
      try
      {
        localObject2 = (PBEParameterSpec)paramAlgorithmParameterSpec;
        localObject1 = localObject2;
        if ((localSecretKey instanceof PBEKey))
        {
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = (PBEKey)localSecretKey;
            localObject1 = new PBEParameterSpec(((PBEKey)localObject1).getSalt(), ((PBEKey)localObject1).getIterationCount());
          }
        }
        k = 1;
        bool = this.macEngine.getAlgorithmName().startsWith("GOST");
        j = 256;
        if (bool)
        {
          i = 6;
        }
        else
        {
          localObject2 = this.macEngine;
          i = k;
          if ((localObject2 instanceof HMac))
          {
            i = k;
            if (!((Mac)localObject2).getAlgorithmName().startsWith("SHA-1"))
            {
              if (this.macEngine.getAlgorithmName().startsWith("SHA-224"))
              {
                i = 7;
                j = 224;
                continue;
              }
              if (this.macEngine.getAlgorithmName().startsWith("SHA-256"))
              {
                i = 4;
                continue;
              }
              if (this.macEngine.getAlgorithmName().startsWith("SHA-384"))
              {
                i = 8;
                j = 384;
                continue;
              }
              if (this.macEngine.getAlgorithmName().startsWith("SHA-512"))
              {
                i = 9;
                j = 512;
                continue;
              }
              if (this.macEngine.getAlgorithmName().startsWith("RIPEMD160"))
              {
                i = 2;
              }
              else
              {
                paramKey = new StringBuilder();
                paramKey.append("no PKCS12 mapping for HMAC: ");
                paramKey.append(this.macEngine.getAlgorithmName());
                throw new InvalidAlgorithmParameterException(paramKey.toString());
              }
            }
          }
          j = 160;
        }
        localObject1 = PBE.Util.makePBEMacParameters(localSecretKey, 2, i, j, (PBEParameterSpec)localObject1);
      }
      catch (Exception paramKey) {}
    }
    throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
    if ((paramKey instanceof BCPBEKey))
    {
      localObject1 = (BCPBEKey)paramKey;
      if (((BCPBEKey)localObject1).getParam() != null) {
        localObject1 = ((BCPBEKey)localObject1).getParam();
      } else if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
        localObject1 = PBE.Util.makePBEMacParameters((BCPBEKey)localObject1, paramAlgorithmParameterSpec);
      } else {
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
      }
    }
    else
    {
      if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec)) {
        break label837;
      }
      localObject1 = new KeyParameter(paramKey.getEncoded());
    }
    if ((localObject1 instanceof ParametersWithIV)) {
      localObject2 = (KeyParameter)((ParametersWithIV)localObject1).getParameters();
    } else {
      localObject2 = (KeyParameter)localObject1;
    }
    if ((paramAlgorithmParameterSpec instanceof AEADParameterSpec))
    {
      paramKey = (AEADParameterSpec)paramAlgorithmParameterSpec;
      paramKey = new AEADParameters((KeyParameter)localObject2, paramKey.getMacSizeInBits(), paramKey.getNonce(), paramKey.getAssociatedData());
    }
    else if ((paramAlgorithmParameterSpec instanceof IvParameterSpec))
    {
      paramKey = new ParametersWithIV((CipherParameters)localObject2, ((IvParameterSpec)paramAlgorithmParameterSpec).getIV());
    }
    else if ((paramAlgorithmParameterSpec instanceof RC2ParameterSpec))
    {
      paramKey = ((KeyParameter)localObject2).getKey();
      paramAlgorithmParameterSpec = (RC2ParameterSpec)paramAlgorithmParameterSpec;
      paramKey = new ParametersWithIV(new RC2Parameters(paramKey, paramAlgorithmParameterSpec.getEffectiveKeyBits()), paramAlgorithmParameterSpec.getIV());
    }
    else if ((paramAlgorithmParameterSpec instanceof SkeinParameterSpec))
    {
      paramKey = new SkeinParameters.Builder(copyMap(((SkeinParameterSpec)paramAlgorithmParameterSpec).getParameters())).setKey(((KeyParameter)localObject2).getKey()).build();
    }
    else if (paramAlgorithmParameterSpec == null)
    {
      paramKey = new KeyParameter(paramKey.getEncoded());
    }
    else
    {
      paramKey = gcmSpecClass;
      if ((paramKey == null) || (!paramKey.isAssignableFrom(paramAlgorithmParameterSpec.getClass()))) {}
    }
    try
    {
      paramKey = gcmSpecClass.getDeclaredMethod("getTLen", new Class[0]);
      localObject1 = gcmSpecClass.getDeclaredMethod("getIV", new Class[0]);
      paramKey = new AEADParameters((KeyParameter)localObject2, ((Integer)paramKey.invoke(paramAlgorithmParameterSpec, new Object[0])).intValue(), (byte[])((Method)localObject1).invoke(paramAlgorithmParameterSpec, new Object[0]));
    }
    catch (Exception paramKey)
    {
      for (;;) {}
    }
    throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
    if ((paramAlgorithmParameterSpec instanceof PBEParameterSpec))
    {
      paramKey = (Key)localObject1;
      try
      {
        this.macEngine.init(paramKey);
        return;
      }
      catch (Exception paramKey)
      {
        paramAlgorithmParameterSpec = new StringBuilder();
        paramAlgorithmParameterSpec.append("cannot initialize MAC: ");
        paramAlgorithmParameterSpec.append(paramKey.getMessage());
        throw new InvalidAlgorithmParameterException(paramAlgorithmParameterSpec.toString());
      }
    }
    paramKey = new StringBuilder();
    paramKey.append("unknown parameter type: ");
    paramKey.append(paramAlgorithmParameterSpec.getClass().getName());
    throw new InvalidAlgorithmParameterException(paramKey.toString());
    label837:
    paramKey = new StringBuilder();
    paramKey.append("inappropriate parameter type: ");
    paramKey.append(paramAlgorithmParameterSpec.getClass().getName());
    throw new InvalidAlgorithmParameterException(paramKey.toString());
    throw new InvalidKeyException("key is null");
  }
  
  protected void engineReset()
  {
    this.macEngine.reset();
  }
  
  protected void engineUpdate(byte paramByte)
  {
    this.macEngine.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.macEngine.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BaseMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */