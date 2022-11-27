package org.bouncycastle.openssl.jcajce;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.jcajce.util.JcaJceHelper;
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
  
  static byte[] crypt(boolean paramBoolean, JcaJceHelper paramJcaJceHelper, byte[] paramArrayOfByte1, char[] paramArrayOfChar, String paramString, byte[] paramArrayOfByte2)
    throws PEMException
  {
    Object localObject3 = new IvParameterSpec(paramArrayOfByte2);
    Object localObject2;
    Object localObject1;
    if (paramString.endsWith("-CFB"))
    {
      localObject2 = "CFB";
      localObject1 = "NoPadding";
    }
    else
    {
      localObject2 = "CBC";
      localObject1 = "PKCS5Padding";
    }
    if ((paramString.endsWith("-ECB")) || ("DES-EDE".equals(paramString)) || ("DES-EDE3".equals(paramString)))
    {
      localObject3 = null;
      localObject2 = "ECB";
    }
    if (paramString.endsWith("-OFB"))
    {
      localObject1 = "OFB";
      localObject2 = "NoPadding";
    }
    else
    {
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    boolean bool = paramString.startsWith("DES-EDE");
    Object localObject4 = "AES";
    int j = 1;
    int i;
    if (bool)
    {
      paramArrayOfChar = getKey(paramJcaJceHelper, paramArrayOfChar, "DESede", 24, paramArrayOfByte2, paramString.startsWith("DES-EDE3") ^ true);
      paramString = "DESede";
    }
    else if (paramString.startsWith("DES-"))
    {
      paramString = "DES";
      paramArrayOfChar = getKey(paramJcaJceHelper, paramArrayOfChar, "DES", 8, paramArrayOfByte2);
    }
    else if (paramString.startsWith("BF-"))
    {
      paramString = "Blowfish";
      paramArrayOfChar = getKey(paramJcaJceHelper, paramArrayOfChar, "Blowfish", 16, paramArrayOfByte2);
    }
    else
    {
      bool = paramString.startsWith("RC2-");
      i = 128;
      if (bool)
      {
        localObject4 = "RC2";
        if (paramString.startsWith("RC2-40-")) {
          i = 40;
        } else if (paramString.startsWith("RC2-64-")) {
          i = 64;
        }
        paramArrayOfChar = getKey(paramJcaJceHelper, paramArrayOfChar, "RC2", i / 8, paramArrayOfByte2);
        if (localObject3 == null) {
          localObject3 = new RC2ParameterSpec(i);
        } else {
          localObject3 = new RC2ParameterSpec(i, paramArrayOfByte2);
        }
        paramString = (String)localObject4;
      }
      else
      {
        if (!paramString.startsWith("AES-")) {
          break label562;
        }
        if (paramArrayOfByte2.length > 8)
        {
          byte[] arrayOfByte = new byte[8];
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, 0, 8);
          paramArrayOfByte2 = arrayOfByte;
        }
        if (!paramString.startsWith("AES-128-")) {
          if (paramString.startsWith("AES-192-"))
          {
            i = 192;
          }
          else
          {
            if (!paramString.startsWith("AES-256-")) {
              break label552;
            }
            i = 256;
          }
        }
        paramArrayOfChar = getKey(paramJcaJceHelper, paramArrayOfChar, "AES", i / 8, paramArrayOfByte2);
        paramString = (String)localObject4;
      }
    }
    paramArrayOfByte2 = new StringBuilder();
    paramArrayOfByte2.append(paramString);
    paramArrayOfByte2.append("/");
    paramArrayOfByte2.append((String)localObject1);
    paramArrayOfByte2.append("/");
    paramArrayOfByte2.append((String)localObject2);
    paramString = paramArrayOfByte2.toString();
    for (;;)
    {
      try
      {
        paramJcaJceHelper = paramJcaJceHelper.createCipher(paramString);
        if (!paramBoolean) {
          break label572;
        }
        i = j;
        if (localObject3 == null) {
          paramJcaJceHelper.init(i, paramArrayOfChar);
        } else {
          paramJcaJceHelper.init(i, paramArrayOfChar, (AlgorithmParameterSpec)localObject3);
        }
        paramJcaJceHelper = paramJcaJceHelper.doFinal(paramArrayOfByte1);
        return paramJcaJceHelper;
      }
      catch (Exception paramJcaJceHelper)
      {
        throw new EncryptionException("exception using cipher - please check password and data.", paramJcaJceHelper);
      }
      label552:
      throw new EncryptionException("unknown AES encryption with private key");
      label562:
      throw new EncryptionException("unknown encryption with private key");
      label572:
      i = 2;
    }
  }
  
  public static SecretKey generateSecretKeyForPKCS5Scheme2(JcaJceHelper paramJcaJceHelper, String paramString, char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt)
    throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException
  {
    return new SecretKeySpec(paramJcaJceHelper.createSecretKeyFactory("PBKDF2with8BIT").generateSecret(new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, paramInt, getKeySize(paramString))).getEncoded(), paramString);
  }
  
  private static SecretKey getKey(JcaJceHelper paramJcaJceHelper, char[] paramArrayOfChar, String paramString, int paramInt, byte[] paramArrayOfByte)
    throws PEMException
  {
    return getKey(paramJcaJceHelper, paramArrayOfChar, paramString, paramInt, paramArrayOfByte, false);
  }
  
  private static SecretKey getKey(JcaJceHelper paramJcaJceHelper, char[] paramArrayOfChar, String paramString, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
    throws PEMException
  {
    try
    {
      paramArrayOfChar = new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, 1, paramInt * 8);
      paramJcaJceHelper = paramJcaJceHelper.createSecretKeyFactory("PBKDF-OpenSSL").generateSecret(paramArrayOfChar).getEncoded();
      if ((paramBoolean) && (paramJcaJceHelper.length >= 24)) {
        System.arraycopy(paramJcaJceHelper, 0, paramJcaJceHelper, 16, 8);
      }
      paramJcaJceHelper = new SecretKeySpec(paramJcaJceHelper, paramString);
      return paramJcaJceHelper;
    }
    catch (GeneralSecurityException paramJcaJceHelper)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("Unable to create OpenSSL PBDKF: ");
      paramArrayOfChar.append(paramJcaJceHelper.getMessage());
      throw new PEMException(paramArrayOfChar.toString(), paramJcaJceHelper);
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\PEMUtilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */