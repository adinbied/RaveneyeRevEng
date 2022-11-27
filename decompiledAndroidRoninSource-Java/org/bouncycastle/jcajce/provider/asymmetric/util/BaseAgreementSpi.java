package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

public abstract class BaseAgreementSpi
  extends KeyAgreementSpi
{
  private static final Map<String, ASN1ObjectIdentifier> defaultOids = new HashMap();
  private static final Hashtable des;
  private static final Map<String, Integer> keySizes = new HashMap();
  private static final Map<String, String> nameTable = new HashMap();
  private static final Hashtable oids = new Hashtable();
  private final String kaAlgorithm;
  private final DerivationFunction kdf;
  protected byte[] ukmParameters;
  
  static
  {
    des = new Hashtable();
    Integer localInteger1 = Integers.valueOf(64);
    Integer localInteger2 = Integers.valueOf(128);
    Integer localInteger3 = Integers.valueOf(192);
    Integer localInteger4 = Integers.valueOf(256);
    keySizes.put("DES", localInteger1);
    keySizes.put("DESEDE", localInteger3);
    keySizes.put("BLOWFISH", localInteger2);
    keySizes.put("AES", localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_CBC.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), localInteger4);
    keySizes.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), localInteger2);
    keySizes.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), localInteger3);
    keySizes.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), localInteger4);
    keySizes.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), localInteger2);
    keySizes.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), localInteger3);
    keySizes.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), localInteger4);
    keySizes.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), localInteger2);
    keySizes.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), localInteger3);
    keySizes.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), localInteger3);
    keySizes.put(OIWObjectIdentifiers.desCBC.getId(), localInteger1);
    keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), Integers.valueOf(160));
    keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), localInteger4);
    keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), Integers.valueOf(384));
    keySizes.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), Integers.valueOf(512));
    defaultOids.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
    defaultOids.put("AES", NISTObjectIdentifiers.id_aes256_CBC);
    defaultOids.put("CAMELLIA", NTTObjectIdentifiers.id_camellia256_cbc);
    defaultOids.put("SEED", KISAObjectIdentifiers.id_seedCBC);
    defaultOids.put("DES", OIWObjectIdentifiers.desCBC);
    nameTable.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
    nameTable.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
    nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
    nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
    nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
    nameTable.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
    nameTable.put(OIWObjectIdentifiers.desECB.getId(), "DES");
    nameTable.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
    nameTable.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
    nameTable.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
    nameTable.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
    nameTable.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DESede");
    nameTable.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DESede");
    nameTable.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
    nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA1.getId(), "HmacSHA1");
    nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
    nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA256.getId(), "HmacSHA256");
    nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA384.getId(), "HmacSHA384");
    nameTable.put(PKCSObjectIdentifiers.id_hmacWithSHA512.getId(), "HmacSHA512");
    nameTable.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
    nameTable.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
    nameTable.put(NTTObjectIdentifiers.id_camellia256_cbc.getId(), "Camellia");
    nameTable.put(NTTObjectIdentifiers.id_camellia128_wrap.getId(), "Camellia");
    nameTable.put(NTTObjectIdentifiers.id_camellia192_wrap.getId(), "Camellia");
    nameTable.put(NTTObjectIdentifiers.id_camellia256_wrap.getId(), "Camellia");
    nameTable.put(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.getId(), "SEED");
    nameTable.put(KISAObjectIdentifiers.id_seedCBC.getId(), "SEED");
    nameTable.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
    nameTable.put(CryptoProObjectIdentifiers.gostR28147_gcfb.getId(), "GOST28147");
    nameTable.put(NISTObjectIdentifiers.id_aes128_wrap.getId(), "AES");
    nameTable.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), "AES");
    nameTable.put(NISTObjectIdentifiers.id_aes128_CCM.getId(), "AES");
    oids.put("DESEDE", PKCSObjectIdentifiers.des_EDE3_CBC);
    oids.put("AES", NISTObjectIdentifiers.id_aes256_CBC);
    oids.put("DES", OIWObjectIdentifiers.desCBC);
    des.put("DES", "DES");
    des.put("DESEDE", "DES");
    des.put(OIWObjectIdentifiers.desCBC.getId(), "DES");
    des.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), "DES");
    des.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId(), "DES");
  }
  
  public BaseAgreementSpi(String paramString, DerivationFunction paramDerivationFunction)
  {
    this.kaAlgorithm = paramString;
    this.kdf = paramDerivationFunction;
  }
  
  protected static String getAlgorithm(String paramString)
  {
    if (paramString.indexOf('[') > 0) {
      return paramString.substring(0, paramString.indexOf('['));
    }
    if (paramString.startsWith(NISTObjectIdentifiers.aes.getId())) {
      return "AES";
    }
    if (paramString.startsWith(GNUObjectIdentifiers.Serpent.getId())) {
      return "Serpent";
    }
    String str = (String)nameTable.get(Strings.toUpperCase(paramString));
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  protected static int getKeySize(String paramString)
  {
    if (paramString.indexOf('[') > 0) {
      return Integer.parseInt(paramString.substring(paramString.indexOf('[') + 1, paramString.indexOf(']')));
    }
    paramString = Strings.toUpperCase(paramString);
    if (!keySizes.containsKey(paramString)) {
      return -1;
    }
    return ((Integer)keySizes.get(paramString)).intValue();
  }
  
  protected static byte[] trimZeroes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] != 0) {
      return paramArrayOfByte;
    }
    int i = 0;
    while ((i < paramArrayOfByte.length) && (paramArrayOfByte[i] == 0)) {
      i += 1;
    }
    int j = paramArrayOfByte.length - i;
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, j);
    return arrayOfByte;
  }
  
  protected abstract byte[] calcSecret();
  
  protected int engineGenerateSecret(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, ShortBufferException
  {
    byte[] arrayOfByte = engineGenerateSecret();
    if (paramArrayOfByte.length - paramInt >= arrayOfByte.length)
    {
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
      return arrayOfByte.length;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(this.kaAlgorithm);
    paramArrayOfByte.append(" key agreement: need ");
    paramArrayOfByte.append(arrayOfByte.length);
    paramArrayOfByte.append(" bytes");
    throw new ShortBufferException(paramArrayOfByte.toString());
  }
  
  protected SecretKey engineGenerateSecret(String paramString)
    throws NoSuchAlgorithmException
  {
    byte[] arrayOfByte1 = calcSecret();
    Object localObject1 = Strings.toUpperCase(paramString);
    if (oids.containsKey(localObject1)) {
      localObject1 = ((ASN1ObjectIdentifier)oids.get(localObject1)).getId();
    } else {
      localObject1 = paramString;
    }
    int i = getKeySize((String)localObject1);
    Object localObject2 = this.kdf;
    int j;
    byte[] arrayOfByte2;
    if (localObject2 != null) {
      if (i >= 0)
      {
        j = i / 8;
        arrayOfByte2 = new byte[j];
        if (!(localObject2 instanceof DHKEKGenerator)) {}
      }
    }
    try
    {
      localObject2 = new ASN1ObjectIdentifier((String)localObject1);
      localObject1 = new DHKDFParameters((ASN1ObjectIdentifier)localObject2, i, arrayOfByte1, this.ukmParameters);
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    paramString = new StringBuilder();
    paramString.append("no OID for algorithm: ");
    paramString.append((String)localObject1);
    throw new NoSuchAlgorithmException(paramString.toString());
    localObject1 = new KDFParameters(arrayOfByte1, this.ukmParameters);
    this.kdf.init((DerivationParameters)localObject1);
    this.kdf.generateBytes(arrayOfByte2, 0, j);
    localObject1 = arrayOfByte2;
    break label261;
    paramString = new StringBuilder();
    paramString.append("unknown algorithm encountered: ");
    paramString.append((String)localObject1);
    throw new NoSuchAlgorithmException(paramString.toString());
    localObject1 = arrayOfByte1;
    if (i > 0)
    {
      i /= 8;
      localObject1 = new byte[i];
      System.arraycopy(arrayOfByte1, 0, localObject1, 0, i);
    }
    label261:
    paramString = getAlgorithm(paramString);
    if (des.containsKey(paramString)) {
      DESParameters.setOddParity((byte[])localObject1);
    }
    return new SecretKeySpec((byte[])localObject1, paramString);
  }
  
  protected byte[] engineGenerateSecret()
    throws IllegalStateException
  {
    if (this.kdf == null) {
      return calcSecret();
    }
    throw new UnsupportedOperationException("KDF can only be used when algorithm is known");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\BaseAgreementSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */