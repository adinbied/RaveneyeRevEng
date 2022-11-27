package org.bouncycastle.openssl.bc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.BlowfishEngine;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.openssl.EncryptionException;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.util.Integers;

class PEMUtilities
{
  private static final Map KEYSIZES = new HashMap();
  private static final Set PKCS5_SCHEME_1 = new HashSet();
  private static final Set PKCS5_SCHEME_2 = new HashSet();
  
  static
  {
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC);
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC);
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
    PKCS5_SCHEME_1.add(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
    PKCS5_SCHEME_2.add(PKCSObjectIdentifiers.id_PBES2);
    PKCS5_SCHEME_2.add(PKCSObjectIdentifiers.des_EDE3_CBC);
    PKCS5_SCHEME_2.add(NISTObjectIdentifiers.id_aes128_CBC);
    PKCS5_SCHEME_2.add(NISTObjectIdentifiers.id_aes192_CBC);
    PKCS5_SCHEME_2.add(NISTObjectIdentifiers.id_aes256_CBC);
    KEYSIZES.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), Integers.valueOf(192));
    KEYSIZES.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), Integers.valueOf(128));
    KEYSIZES.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), Integers.valueOf(192));
    KEYSIZES.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), Integers.valueOf(256));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.getId(), Integers.valueOf(128));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, Integers.valueOf(40));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, Integers.valueOf(128));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, Integers.valueOf(192));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.valueOf(128));
    KEYSIZES.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.valueOf(40));
  }
  
  static byte[] crypt(boolean paramBoolean, byte[] paramArrayOfByte1, char[] paramArrayOfChar, String paramString, byte[] paramArrayOfByte2)
    throws PEMException
  {
    Object localObject = new PKCS7Padding();
    boolean bool = paramString.endsWith("-CFB");
    byte[] arrayOfByte2 = null;
    String str;
    if (bool)
    {
      str = "CFB";
      localObject = null;
    }
    else
    {
      str = "CBC";
    }
    byte[] arrayOfByte1;
    if ((!paramString.endsWith("-ECB")) && (!"DES-EDE".equals(paramString)) && (!"DES-EDE3".equals(paramString)))
    {
      arrayOfByte1 = paramArrayOfByte2;
    }
    else
    {
      str = "ECB";
      arrayOfByte1 = null;
    }
    if (paramString.endsWith("-OFB"))
    {
      str = "OFB";
      localObject = arrayOfByte2;
    }
    int i;
    if (paramString.startsWith("DES-EDE"))
    {
      paramString = getKey(paramArrayOfChar, 24, paramArrayOfByte2, paramString.startsWith("DES-EDE3") ^ true);
      paramArrayOfChar = new DESedeEngine();
    }
    else if (paramString.startsWith("DES-"))
    {
      paramString = getKey(paramArrayOfChar, 8, paramArrayOfByte2);
      paramArrayOfChar = new DESEngine();
    }
    else if (paramString.startsWith("BF-"))
    {
      paramString = getKey(paramArrayOfChar, 16, paramArrayOfByte2);
      paramArrayOfChar = new BlowfishEngine();
    }
    else
    {
      bool = paramString.startsWith("RC2-");
      i = 128;
      if (bool)
      {
        if (paramString.startsWith("RC2-40-")) {
          i = 40;
        } else if (paramString.startsWith("RC2-64-")) {
          i = 64;
        }
        paramString = new RC2Parameters(getKey(paramArrayOfChar, i / 8, paramArrayOfByte2).getKey(), i);
        paramArrayOfChar = new RC2Engine();
      }
      else
      {
        if (!paramString.startsWith("AES-")) {
          break label638;
        }
        arrayOfByte2 = paramArrayOfByte2;
        if (paramArrayOfByte2.length > 8)
        {
          arrayOfByte2 = new byte[8];
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 0, 8);
        }
        if (!paramString.startsWith("AES-128-")) {
          if (paramString.startsWith("AES-192-"))
          {
            i = 192;
          }
          else
          {
            if (!paramString.startsWith("AES-256-")) {
              break label604;
            }
            i = 256;
          }
        }
        paramString = getKey(paramArrayOfChar, i / 8, arrayOfByte2);
        paramArrayOfChar = new AESEngine();
      }
    }
    if (str.equals("CBC")) {
      paramArrayOfChar = new CBCBlockCipher(paramArrayOfChar);
    }
    for (;;)
    {
      paramArrayOfByte2 = paramArrayOfChar;
      break;
      if (str.equals("CFB"))
      {
        paramArrayOfChar = new CFBBlockCipher(paramArrayOfChar, paramArrayOfChar.getBlockSize() * 8);
      }
      else
      {
        paramArrayOfByte2 = paramArrayOfChar;
        if (!str.equals("OFB")) {
          break;
        }
        paramArrayOfChar = new OFBBlockCipher(paramArrayOfChar, paramArrayOfChar.getBlockSize() * 8);
      }
    }
    if (localObject == null) {}
    try
    {
      paramArrayOfChar = new BufferedBlockCipher(paramArrayOfByte2);
      break label501;
      paramArrayOfChar = new PaddedBufferedBlockCipher(paramArrayOfByte2, (BlockCipherPadding)localObject);
      label501:
      if (arrayOfByte1 == null) {
        paramArrayOfChar.init(paramBoolean, paramString);
      } else {
        paramArrayOfChar.init(paramBoolean, new ParametersWithIV(paramString, arrayOfByte1));
      }
      i = paramArrayOfChar.getOutputSize(paramArrayOfByte1.length);
      paramString = new byte[i];
      int j = paramArrayOfChar.processBytes(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramString, 0);
      j += paramArrayOfChar.doFinal(paramString, j);
      if (j == i) {
        return paramString;
      }
      paramArrayOfByte1 = new byte[j];
      System.arraycopy(paramString, 0, paramArrayOfByte1, 0, j);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      throw new EncryptionException("exception using cipher - please check password and data.", paramArrayOfByte1);
    }
    label604:
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("unknown AES encryption with private key: ");
    paramArrayOfByte1.append(paramString);
    throw new EncryptionException(paramArrayOfByte1.toString());
    label638:
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("unknown encryption with private key: ");
    paramArrayOfByte1.append(paramString);
    throw new EncryptionException(paramArrayOfByte1.toString());
  }
  
  public static KeyParameter generateSecretKeyForPKCS5Scheme2(String paramString, char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
  {
    PKCS5S2ParametersGenerator localPKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA1Digest());
    localPKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(paramArrayOfChar), paramArrayOfByte, paramInt);
    return (KeyParameter)localPKCS5S2ParametersGenerator.generateDerivedParameters(getKeySize(paramString));
  }
  
  private static KeyParameter getKey(char[] paramArrayOfChar, int paramInt, byte[] paramArrayOfByte)
    throws PEMException
  {
    return getKey(paramArrayOfChar, paramInt, paramArrayOfByte, false);
  }
  
  private static KeyParameter getKey(char[] paramArrayOfChar, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
    throws PEMException
  {
    OpenSSLPBEParametersGenerator localOpenSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
    localOpenSSLPBEParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes(paramArrayOfChar), paramArrayOfByte, 1);
    paramArrayOfChar = (KeyParameter)localOpenSSLPBEParametersGenerator.generateDerivedParameters(paramInt * 8);
    if ((paramBoolean) && (paramArrayOfChar.getKey().length == 24))
    {
      paramArrayOfChar = paramArrayOfChar.getKey();
      System.arraycopy(paramArrayOfChar, 0, paramArrayOfChar, 16, 8);
      return new KeyParameter(paramArrayOfChar);
    }
    return paramArrayOfChar;
  }
  
  static int getKeySize(String paramString)
  {
    if (KEYSIZES.containsKey(paramString)) {
      return ((Integer)KEYSIZES.get(paramString)).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("no key size for algorithm: ");
    localStringBuilder.append(paramString);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static boolean isPKCS12(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return paramASN1ObjectIdentifier.getId().startsWith(PKCSObjectIdentifiers.pkcs_12PbeIds.getId());
  }
  
  static boolean isPKCS5Scheme1(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return PKCS5_SCHEME_1.contains(paramASN1ObjectIdentifier);
  }
  
  static boolean isPKCS5Scheme2(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return PKCS5_SCHEME_2.contains(paramASN1ObjectIdentifier);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\bc\PEMUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */