package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.asn1.x509.TBSCertificate;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA384Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Shorts;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class TlsUtils
{
  public static final byte[] EMPTY_BYTES = new byte[0];
  public static final int[] EMPTY_INTS;
  public static final long[] EMPTY_LONGS;
  public static final short[] EMPTY_SHORTS = new short[0];
  public static final Integer EXT_signature_algorithms;
  static final byte[][] SSL3_CONST = genSSL3Const();
  static final byte[] SSL_CLIENT;
  static final byte[] SSL_SERVER;
  
  static
  {
    EMPTY_INTS = new int[0];
    EMPTY_LONGS = new long[0];
    EXT_signature_algorithms = Integers.valueOf(13);
    SSL_CLIENT = new byte[] { 67, 76, 78, 84 };
    SSL_SERVER = new byte[] { 83, 82, 86, 82 };
  }
  
  public static byte[] PRF(TlsContext paramTlsContext, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    if (!paramTlsContext.getServerVersion().isSSL())
    {
      byte[] arrayOfByte = Strings.toByteArray(paramString);
      paramString = concat(arrayOfByte, paramArrayOfByte2);
      int i = paramTlsContext.getSecurityParameters().getPrfAlgorithm();
      if (i == 0) {
        return PRF_legacy(paramArrayOfByte1, arrayOfByte, paramString, paramInt);
      }
      paramTlsContext = createPRFHash(i);
      paramArrayOfByte2 = new byte[paramInt];
      hmac_hash(paramTlsContext, paramArrayOfByte1, paramString, paramArrayOfByte2);
      return paramArrayOfByte2;
    }
    throw new IllegalStateException("No PRF available for SSLv3 session");
  }
  
  public static byte[] PRF_legacy(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    paramString = Strings.toByteArray(paramString);
    return PRF_legacy(paramArrayOfByte1, paramString, concat(paramString, paramArrayOfByte2), paramInt);
  }
  
  static byte[] PRF_legacy(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    int j = (paramArrayOfByte1.length + 1) / 2;
    paramArrayOfByte2 = new byte[j];
    byte[] arrayOfByte1 = new byte[j];
    int i = 0;
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 0, j);
    System.arraycopy(paramArrayOfByte1, paramArrayOfByte1.length - j, arrayOfByte1, 0, j);
    paramArrayOfByte1 = new byte[paramInt];
    byte[] arrayOfByte2 = new byte[paramInt];
    hmac_hash(createHash((short)1), paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte1);
    hmac_hash(createHash((short)2), arrayOfByte1, paramArrayOfByte3, arrayOfByte2);
    while (i < paramInt)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ arrayOfByte2[i]));
      i += 1;
    }
    return paramArrayOfByte1;
  }
  
  public static void addSignatureAlgorithmsExtension(Hashtable paramHashtable, Vector paramVector)
    throws IOException
  {
    paramHashtable.put(EXT_signature_algorithms, createSignatureAlgorithmsExtension(paramVector));
  }
  
  static byte[] calculateKeyBlock(TlsContext paramTlsContext, int paramInt)
  {
    Object localObject = paramTlsContext.getSecurityParameters();
    byte[] arrayOfByte = ((SecurityParameters)localObject).getMasterSecret();
    localObject = concat(((SecurityParameters)localObject).getServerRandom(), ((SecurityParameters)localObject).getClientRandom());
    if (isSSL(paramTlsContext)) {
      return calculateKeyBlock_SSL(arrayOfByte, (byte[])localObject, paramInt);
    }
    return PRF(paramTlsContext, arrayOfByte, "key expansion", (byte[])localObject, paramInt);
  }
  
  static byte[] calculateKeyBlock_SSL(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    Digest localDigest1 = createHash();
    Digest localDigest2 = createHash((short)2);
    int k = localDigest1.getDigestSize();
    int m = localDigest2.getDigestSize();
    byte[] arrayOfByte1 = new byte[m];
    byte[] arrayOfByte2 = new byte[paramInt + k];
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      byte[] arrayOfByte3 = SSL3_CONST[i];
      localDigest2.update(arrayOfByte3, 0, arrayOfByte3.length);
      localDigest2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localDigest2.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localDigest2.doFinal(arrayOfByte1, 0);
      localDigest1.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localDigest1.update(arrayOfByte1, 0, m);
      localDigest1.doFinal(arrayOfByte2, j);
      j += k;
      i += 1;
    }
    return Arrays.copyOfRange(arrayOfByte2, 0, paramInt);
  }
  
  static byte[] calculateMasterSecret(TlsContext paramTlsContext, byte[] paramArrayOfByte)
  {
    Object localObject = paramTlsContext.getSecurityParameters();
    byte[] arrayOfByte;
    if (((SecurityParameters)localObject).extendedMasterSecret) {
      arrayOfByte = ((SecurityParameters)localObject).getSessionHash();
    } else {
      arrayOfByte = concat(((SecurityParameters)localObject).getClientRandom(), ((SecurityParameters)localObject).getServerRandom());
    }
    if (isSSL(paramTlsContext)) {
      return calculateMasterSecret_SSL(paramArrayOfByte, arrayOfByte);
    }
    if (((SecurityParameters)localObject).extendedMasterSecret) {
      localObject = "extended master secret";
    } else {
      localObject = "master secret";
    }
    return PRF(paramTlsContext, paramArrayOfByte, (String)localObject, arrayOfByte, 48);
  }
  
  static byte[] calculateMasterSecret_SSL(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Digest localDigest1 = createHash();
    Digest localDigest2 = createHash((short)2);
    int k = localDigest1.getDigestSize();
    int m = localDigest2.getDigestSize();
    byte[] arrayOfByte1 = new byte[m];
    byte[] arrayOfByte2 = new byte[k * 3];
    int i = 0;
    int j = 0;
    while (i < 3)
    {
      byte[] arrayOfByte3 = SSL3_CONST[i];
      localDigest2.update(arrayOfByte3, 0, arrayOfByte3.length);
      localDigest2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localDigest2.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localDigest2.doFinal(arrayOfByte1, 0);
      localDigest1.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      localDigest1.update(arrayOfByte1, 0, m);
      localDigest1.doFinal(arrayOfByte2, j);
      j += k;
      i += 1;
    }
    return arrayOfByte2;
  }
  
  static byte[] calculateVerifyData(TlsContext paramTlsContext, String paramString, byte[] paramArrayOfByte)
  {
    if (isSSL(paramTlsContext)) {
      return paramArrayOfByte;
    }
    SecurityParameters localSecurityParameters = paramTlsContext.getSecurityParameters();
    return PRF(paramTlsContext, localSecurityParameters.getMasterSecret(), paramString, paramArrayOfByte, localSecurityParameters.getVerifyDataLength());
  }
  
  public static void checkUint16(int paramInt)
    throws IOException
  {
    if (isValidUint16(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint16(long paramLong)
    throws IOException
  {
    if (isValidUint16(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint24(int paramInt)
    throws IOException
  {
    if (isValidUint24(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint24(long paramLong)
    throws IOException
  {
    if (isValidUint24(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint32(long paramLong)
    throws IOException
  {
    if (isValidUint32(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint48(long paramLong)
    throws IOException
  {
    if (isValidUint48(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint64(long paramLong)
    throws IOException
  {
    if (isValidUint64(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint8(int paramInt)
    throws IOException
  {
    if (isValidUint8(paramInt)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint8(long paramLong)
    throws IOException
  {
    if (isValidUint8(paramLong)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static void checkUint8(short paramShort)
    throws IOException
  {
    if (isValidUint8(paramShort)) {
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static Digest cloneHash(short paramShort, Digest paramDigest)
  {
    switch (paramShort)
    {
    default: 
      throw new IllegalArgumentException("unknown HashAlgorithm");
    case 6: 
      return new SHA512Digest((SHA512Digest)paramDigest);
    case 5: 
      return new SHA384Digest((SHA384Digest)paramDigest);
    case 4: 
      return new SHA256Digest((SHA256Digest)paramDigest);
    case 3: 
      return new SHA224Digest((SHA224Digest)paramDigest);
    case 2: 
      return new SHA1Digest((SHA1Digest)paramDigest);
    }
    return new MD5Digest((MD5Digest)paramDigest);
  }
  
  public static Digest clonePRFHash(int paramInt, Digest paramDigest)
  {
    if (paramInt != 0) {
      return cloneHash(getHashAlgorithmForPRFAlgorithm(paramInt), paramDigest);
    }
    return new CombinedHash((CombinedHash)paramDigest);
  }
  
  static byte[] concat(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  public static Digest createHash(SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm)
  {
    if (paramSignatureAndHashAlgorithm == null) {
      return new CombinedHash();
    }
    return createHash(paramSignatureAndHashAlgorithm.getHash());
  }
  
  public static Digest createHash(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      throw new IllegalArgumentException("unknown HashAlgorithm");
    case 6: 
      return new SHA512Digest();
    case 5: 
      return new SHA384Digest();
    case 4: 
      return new SHA256Digest();
    case 3: 
      return new SHA224Digest();
    case 2: 
      return new SHA1Digest();
    }
    return new MD5Digest();
  }
  
  public static Digest createPRFHash(int paramInt)
  {
    if (paramInt != 0) {
      return createHash(getHashAlgorithmForPRFAlgorithm(paramInt));
    }
    return new CombinedHash();
  }
  
  public static byte[] createSignatureAlgorithmsExtension(Vector paramVector)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    encodeSupportedSignatureAlgorithms(paramVector, false, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static TlsSigner createTlsSigner(short paramShort)
  {
    if (paramShort != 1)
    {
      if (paramShort != 2)
      {
        if (paramShort == 64) {
          return new TlsECDSASigner();
        }
        throw new IllegalArgumentException("'clientCertificateType' is not a type with signing capability");
      }
      return new TlsDSSSigner();
    }
    return new TlsRSASigner();
  }
  
  public static byte[] encodeOpaque8(byte[] paramArrayOfByte)
    throws IOException
  {
    checkUint8(paramArrayOfByte.length);
    return Arrays.prepend(paramArrayOfByte, (byte)paramArrayOfByte.length);
  }
  
  public static void encodeSupportedSignatureAlgorithms(Vector paramVector, boolean paramBoolean, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramVector != null) && (paramVector.size() >= 1) && (paramVector.size() < 32768))
    {
      int i = paramVector.size() * 2;
      checkUint16(i);
      writeUint16(i, paramOutputStream);
      i = 0;
      while (i < paramVector.size())
      {
        SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = (SignatureAndHashAlgorithm)paramVector.elementAt(i);
        if ((!paramBoolean) && (localSignatureAndHashAlgorithm.getSignature() == 0)) {
          throw new IllegalArgumentException("SignatureAlgorithm.anonymous MUST NOT appear in the signature_algorithms extension");
        }
        localSignatureAndHashAlgorithm.encode(paramOutputStream);
        i += 1;
      }
      return;
    }
    throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
  }
  
  public static byte[] encodeUint16ArrayWithUint16Length(int[] paramArrayOfInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramArrayOfInt.length * 2 + 2];
    writeUint16ArrayWithUint16Length(paramArrayOfInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] encodeUint8ArrayWithUint8Length(short[] paramArrayOfShort)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length + 1];
    writeUint8ArrayWithUint8Length(paramArrayOfShort, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private static byte[][] genSSL3Const()
  {
    byte[][] arrayOfByte = new byte[10][];
    int j;
    for (int i = 0; i < 10; i = j)
    {
      j = i + 1;
      byte[] arrayOfByte1 = new byte[j];
      Arrays.fill(arrayOfByte1, (byte)(i + 65));
      arrayOfByte[i] = arrayOfByte1;
    }
    return arrayOfByte;
  }
  
  public static Vector getAllSignatureAlgorithms()
  {
    Vector localVector = new Vector(4);
    localVector.addElement(Shorts.valueOf((short)0));
    localVector.addElement(Shorts.valueOf((short)1));
    localVector.addElement(Shorts.valueOf((short)2));
    localVector.addElement(Shorts.valueOf((short)3));
    return localVector;
  }
  
  public static int getCipherType(int paramInt)
    throws IOException
  {
    paramInt = getEncryptionAlgorithm(paramInt);
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        throw new TlsFatalAlert((short)80);
      }
    case 10: 
    case 11: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
      return 2;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 12: 
    case 13: 
    case 14: 
      return 1;
    }
    return 0;
  }
  
  static short getClientCertificateType(Certificate paramCertificate1, Certificate paramCertificate2)
    throws IOException
  {
    if (paramCertificate1.isEmpty()) {
      return -1;
    }
    paramCertificate1 = paramCertificate1.getCertificateAt(0);
    paramCertificate2 = paramCertificate1.getSubjectPublicKeyInfo();
    try
    {
      paramCertificate2 = PublicKeyFactory.createKey(paramCertificate2);
      if (!paramCertificate2.isPrivate())
      {
        if ((paramCertificate2 instanceof RSAKeyParameters))
        {
          validateKeyUsage(paramCertificate1, 128);
          return 1;
        }
        if ((paramCertificate2 instanceof DSAPublicKeyParameters))
        {
          validateKeyUsage(paramCertificate1, 128);
          return 2;
        }
        if ((paramCertificate2 instanceof ECPublicKeyParameters))
        {
          validateKeyUsage(paramCertificate1, 128);
          return 64;
        }
        throw new TlsFatalAlert((short)43);
      }
      throw new TlsFatalAlert((short)80);
    }
    catch (Exception paramCertificate1)
    {
      throw new TlsFatalAlert((short)43, paramCertificate1);
    }
  }
  
  public static Vector getDefaultDSSSignatureAlgorithms()
  {
    return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)2));
  }
  
  public static Vector getDefaultECDSASignatureAlgorithms()
  {
    return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)3));
  }
  
  public static Vector getDefaultRSASignatureAlgorithms()
  {
    return vectorOfOne(new SignatureAndHashAlgorithm((short)2, (short)1));
  }
  
  public static Vector getDefaultSupportedSignatureAlgorithms()
  {
    Vector localVector = new Vector();
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 5)
      {
        localVector.addElement(new SignatureAndHashAlgorithm(new short[] { 2, 3, 4, 5, 6 }[j], new short[] { 1, 2, 3 }[i]));
        j += 1;
      }
      i += 1;
    }
    return localVector;
  }
  
  public static int getEncryptionAlgorithm(int paramInt)
    throws IOException
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 4) && (paramInt != 5)) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        throw new TlsFatalAlert((short)80);
                      }
                    case 65281: 
                    case 65283: 
                    case 65285: 
                      return 104;
                    }
                    return 103;
                  }
                  return 102;
                case 49313: 
                case 49315: 
                case 49321: 
                case 49323: 
                case 49327: 
                  return 18;
                case 49312: 
                case 49314: 
                case 49320: 
                case 49322: 
                case 49326: 
                  return 16;
                case 49309: 
                case 49311: 
                case 49317: 
                case 49319: 
                case 49325: 
                  return 17;
                case 49308: 
                case 49310: 
                case 49316: 
                case 49318: 
                case 49324: 
                  return 15;
                case 49275: 
                case 49277: 
                case 49279: 
                case 49281: 
                case 49283: 
                case 49285: 
                case 49287: 
                case 49289: 
                case 49291: 
                case 49293: 
                case 49295: 
                case 49297: 
                case 49299: 
                  return 20;
                case 49274: 
                case 49276: 
                case 49278: 
                case 49280: 
                case 49282: 
                case 49284: 
                case 49286: 
                case 49288: 
                case 49290: 
                case 49292: 
                case 49294: 
                case 49296: 
                case 49298: 
                  return 19;
                }
                break;
              }
              break;
            }
            break;
          }
        case 186: 
        case 187: 
        case 188: 
        case 189: 
        case 190: 
        case 191: 
          return 12;
        case 176: 
        case 177: 
        case 180: 
        case 181: 
        case 184: 
        case 185: 
          return 0;
        case 157: 
        case 159: 
        case 161: 
        case 163: 
        case 165: 
        case 167: 
        case 169: 
        case 171: 
        case 173: 
          return 11;
        case 156: 
        case 158: 
        case 160: 
        case 162: 
        case 164: 
        case 166: 
        case 168: 
        case 170: 
        case 172: 
          return 10;
        case 150: 
        case 151: 
        case 152: 
        case 153: 
        case 154: 
        case 155: 
          return 14;
        case 141: 
        case 145: 
        case 149: 
        case 175: 
        case 179: 
        case 183: 
          return 9;
        case 140: 
        case 144: 
        case 148: 
        case 174: 
        case 178: 
        case 182: 
          return 8;
        case 132: 
        case 133: 
        case 134: 
        case 135: 
        case 136: 
        case 137: 
        case 192: 
        case 193: 
        case 194: 
        case 195: 
        case 196: 
        case 197: 
          return 13;
        case 10: 
        case 13: 
        case 16: 
        case 19: 
        case 22: 
        case 27: 
        case 139: 
        case 143: 
        case 147: 
          return 7;
        }
      }
      return 2;
    }
    return 0;
  }
  
  public static byte[] getExtensionData(Hashtable paramHashtable, Integer paramInteger)
  {
    if (paramHashtable == null) {
      return null;
    }
    return (byte[])paramHashtable.get(paramInteger);
  }
  
  public static short getHashAlgorithmForPRFAlgorithm(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return 5;
        }
        throw new IllegalArgumentException("unknown PRFAlgorithm");
      }
      return 4;
    }
    throw new IllegalArgumentException("legacy PRF not a valid algorithm");
  }
  
  public static int getKeyExchangeAlgorithm(int paramInt)
    throws IOException
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4) && (paramInt != 5)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      throw new TlsFatalAlert((short)80);
                    }
                    break;
                  }
                  break;
                }
                break;
              }
            case 49203: 
            case 49204: 
            case 49205: 
            case 49206: 
            case 49207: 
            case 49208: 
            case 49209: 
            case 49210: 
            case 49211: 
              return 24;
            case 49180: 
            case 49183: 
            case 49186: 
              return 22;
            case 49179: 
            case 49182: 
            case 49185: 
              return 23;
            case 49178: 
            case 49181: 
            case 49184: 
              return 21;
            case 49173: 
            case 49174: 
            case 49175: 
            case 49176: 
            case 49177: 
              return 20;
            case 49168: 
            case 49169: 
            case 49170: 
            case 49171: 
            case 49172: 
            case 49191: 
            case 49192: 
            case 49199: 
            case 49200: 
              return 19;
            case 49163: 
            case 49164: 
            case 49165: 
            case 49166: 
            case 49167: 
            case 49193: 
            case 49194: 
            case 49201: 
            case 49202: 
              return 18;
            case 49158: 
            case 49159: 
            case 49160: 
            case 49161: 
            case 49162: 
            case 49187: 
            case 49188: 
            case 49195: 
            case 49196: 
              return 17;
            }
            return 16;
          }
          break;
        }
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 172: 
      case 173: 
      case 182: 
      case 183: 
      case 184: 
      case 185: 
        return 15;
      case 142: 
      case 143: 
      case 144: 
      case 145: 
      case 170: 
      case 171: 
      case 178: 
      case 179: 
      case 180: 
      case 181: 
        return 14;
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 168: 
      case 169: 
      case 174: 
      case 175: 
      case 176: 
      case 177: 
        return 13;
      case 24: 
      case 27: 
      case 137: 
      case 155: 
      case 166: 
      case 167: 
      case 191: 
      case 197: 
        return 11;
      case 22: 
      case 136: 
      case 154: 
      case 158: 
      case 159: 
      case 190: 
      case 196: 
        return 5;
      case 19: 
      case 135: 
      case 153: 
      case 162: 
      case 163: 
      case 189: 
      case 195: 
        return 3;
      case 16: 
      case 134: 
      case 152: 
      case 160: 
      case 161: 
      case 188: 
      case 194: 
        return 9;
      case 13: 
      case 133: 
      case 151: 
      case 164: 
      case 165: 
      case 187: 
      case 193: 
        return 7;
      }
    }
    return 1;
  }
  
  public static int getMACAlgorithm(int paramInt)
    throws IOException
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 4) {
          break label1442;
        }
        if (paramInt == 5) {}
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      throw new TlsFatalAlert((short)80);
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
      case 175: 
      case 177: 
      case 179: 
      case 181: 
      case 183: 
      case 185: 
        return 4;
      case 174: 
      case 176: 
      case 178: 
      case 180: 
      case 182: 
      case 184: 
      case 186: 
      case 187: 
      case 188: 
      case 189: 
      case 190: 
      case 191: 
      case 192: 
      case 193: 
      case 194: 
      case 195: 
      case 196: 
      case 197: 
        return 3;
      case 156: 
      case 157: 
      case 158: 
      case 159: 
      case 160: 
      case 161: 
      case 162: 
      case 163: 
      case 164: 
      case 165: 
      case 166: 
      case 167: 
      case 168: 
      case 169: 
      case 170: 
      case 171: 
      case 172: 
      case 173: 
        return 0;
      case 10: 
      case 13: 
      case 16: 
      case 19: 
      case 22: 
      case 27: 
      case 132: 
      case 133: 
      case 134: 
      case 135: 
      case 136: 
      case 137: 
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 142: 
      case 143: 
      case 144: 
      case 145: 
      case 146: 
      case 147: 
      case 148: 
      case 149: 
      case 150: 
      case 151: 
      case 152: 
      case 153: 
      case 154: 
      case 155: 
        return 2;
      }
    }
    label1442:
    return 1;
  }
  
  public static ProtocolVersion getMinimumVersion(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      switch (paramInt)
                      {
                      default: 
                        return ProtocolVersion.SSLv3;
                      }
                      break;
                    }
                    break;
                  }
                  break;
                }
                break;
              }
              break;
            }
            break;
          }
          break;
        }
        break;
      }
      break;
    }
    return ProtocolVersion.TLSv12;
  }
  
  public static ASN1ObjectIdentifier getOIDForHashAlgorithm(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      throw new IllegalArgumentException("unknown HashAlgorithm");
    case 6: 
      return NISTObjectIdentifiers.id_sha512;
    case 5: 
      return NISTObjectIdentifiers.id_sha384;
    case 4: 
      return NISTObjectIdentifiers.id_sha256;
    case 3: 
      return NISTObjectIdentifiers.id_sha224;
    case 2: 
      return X509ObjectIdentifiers.id_SHA1;
    }
    return PKCSObjectIdentifiers.md5;
  }
  
  public static Vector getSignatureAlgorithmsExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = getExtensionData(paramHashtable, EXT_signature_algorithms);
    if (paramHashtable == null) {
      return null;
    }
    return readSignatureAlgorithmsExtension(paramHashtable);
  }
  
  public static SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(TlsContext paramTlsContext, TlsSignerCredentials paramTlsSignerCredentials)
    throws IOException
  {
    if (isTLSv12(paramTlsContext))
    {
      paramTlsContext = paramTlsSignerCredentials.getSignatureAndHashAlgorithm();
      if (paramTlsContext != null) {
        return paramTlsContext;
      }
      throw new TlsFatalAlert((short)80);
    }
    return null;
  }
  
  public static Vector getUsableSignatureAlgorithms(Vector paramVector)
  {
    if (paramVector == null) {
      return getAllSignatureAlgorithms();
    }
    Vector localVector = new Vector(4);
    int i = 0;
    localVector.addElement(Shorts.valueOf((short)0));
    while (i < paramVector.size())
    {
      Short localShort = Shorts.valueOf(((SignatureAndHashAlgorithm)paramVector.elementAt(i)).getSignature());
      if (!localVector.contains(localShort)) {
        localVector.addElement(localShort);
      }
      i += 1;
    }
    return localVector;
  }
  
  public static boolean hasExpectedEmptyExtensionData(Hashtable paramHashtable, Integer paramInteger, short paramShort)
    throws IOException
  {
    paramHashtable = getExtensionData(paramHashtable, paramInteger);
    if (paramHashtable == null) {
      return false;
    }
    if (paramHashtable.length == 0) {
      return true;
    }
    throw new TlsFatalAlert(paramShort);
  }
  
  public static boolean hasSigningCapability(short paramShort)
  {
    return (paramShort == 1) || (paramShort == 2) || (paramShort == 64);
  }
  
  static void hmac_hash(Digest paramDigest, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    HMac localHMac = new HMac(paramDigest);
    localHMac.init(new KeyParameter(paramArrayOfByte1));
    int j = paramDigest.getDigestSize();
    int k = (paramArrayOfByte3.length + j - 1) / j;
    int m = localHMac.getMacSize();
    paramArrayOfByte1 = new byte[m];
    byte[] arrayOfByte = new byte[localHMac.getMacSize()];
    paramDigest = paramArrayOfByte2;
    int i = 0;
    while (i < k)
    {
      localHMac.update(paramDigest, 0, paramDigest.length);
      localHMac.doFinal(paramArrayOfByte1, 0);
      localHMac.update(paramArrayOfByte1, 0, m);
      localHMac.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
      localHMac.doFinal(arrayOfByte, 0);
      int n = j * i;
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte3, n, Math.min(j, paramArrayOfByte3.length - n));
      i += 1;
      paramDigest = paramArrayOfByte1;
    }
  }
  
  public static TlsSession importSession(byte[] paramArrayOfByte, SessionParameters paramSessionParameters)
  {
    return new TlsSessionImpl(paramArrayOfByte, paramSessionParameters);
  }
  
  public static boolean isAEADCipherSuite(int paramInt)
    throws IOException
  {
    return 2 == getCipherType(paramInt);
  }
  
  public static boolean isBlockCipherSuite(int paramInt)
    throws IOException
  {
    return 1 == getCipherType(paramInt);
  }
  
  public static boolean isSSL(TlsContext paramTlsContext)
  {
    return paramTlsContext.getServerVersion().isSSL();
  }
  
  public static boolean isSignatureAlgorithmsExtensionAllowed(ProtocolVersion paramProtocolVersion)
  {
    return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(paramProtocolVersion.getEquivalentTLSVersion());
  }
  
  public static boolean isStreamCipherSuite(int paramInt)
    throws IOException
  {
    return getCipherType(paramInt) == 0;
  }
  
  public static boolean isTLSv11(ProtocolVersion paramProtocolVersion)
  {
    return ProtocolVersion.TLSv11.isEqualOrEarlierVersionOf(paramProtocolVersion.getEquivalentTLSVersion());
  }
  
  public static boolean isTLSv11(TlsContext paramTlsContext)
  {
    return isTLSv11(paramTlsContext.getServerVersion());
  }
  
  public static boolean isTLSv12(ProtocolVersion paramProtocolVersion)
  {
    return ProtocolVersion.TLSv12.isEqualOrEarlierVersionOf(paramProtocolVersion.getEquivalentTLSVersion());
  }
  
  public static boolean isTLSv12(TlsContext paramTlsContext)
  {
    return isTLSv12(paramTlsContext.getServerVersion());
  }
  
  public static boolean isValidCipherSuiteForSignatureAlgorithms(int paramInt, Vector paramVector)
  {
    try
    {
      paramInt = getKeyExchangeAlgorithm(paramInt);
      Short localShort;
      if ((paramInt != 3) && (paramInt != 4)) {
        if ((paramInt != 5) && (paramInt != 6)) {
          if ((paramInt != 11) && (paramInt != 12)) {
            if (paramInt != 17)
            {
              if (paramInt == 19) {
                break label91;
              }
              if (paramInt != 20)
              {
                if (paramInt == 22) {
                  break label99;
                }
                if (paramInt == 23) {
                  break label91;
                }
                return true;
              }
            }
            else
            {
              localShort = Shorts.valueOf((short)3);
              return paramVector.contains(localShort);
            }
          }
        }
      }
      label91:
      label99:
      for (short s = 0;; s = 2)
      {
        localShort = Shorts.valueOf(s);
        break;
        localShort = Shorts.valueOf((short)1);
        break;
      }
      return true;
    }
    catch (IOException paramVector) {}
  }
  
  public static boolean isValidCipherSuiteForVersion(int paramInt, ProtocolVersion paramProtocolVersion)
  {
    return getMinimumVersion(paramInt).isEqualOrEarlierVersionOf(paramProtocolVersion.getEquivalentTLSVersion());
  }
  
  public static boolean isValidUint16(int paramInt)
  {
    return (0xFFFF & paramInt) == paramInt;
  }
  
  public static boolean isValidUint16(long paramLong)
  {
    return (0xFFFF & paramLong) == paramLong;
  }
  
  public static boolean isValidUint24(int paramInt)
  {
    return (0xFFFFFF & paramInt) == paramInt;
  }
  
  public static boolean isValidUint24(long paramLong)
  {
    return (0xFFFFFF & paramLong) == paramLong;
  }
  
  public static boolean isValidUint32(long paramLong)
  {
    return (0xFFFFFFFF & paramLong) == paramLong;
  }
  
  public static boolean isValidUint48(long paramLong)
  {
    return (0xFFFFFFFFFFFF & paramLong) == paramLong;
  }
  
  public static boolean isValidUint64(long paramLong)
  {
    return true;
  }
  
  public static boolean isValidUint8(int paramInt)
  {
    return (paramInt & 0xFF) == paramInt;
  }
  
  public static boolean isValidUint8(long paramLong)
  {
    return (0xFF & paramLong) == paramLong;
  }
  
  public static boolean isValidUint8(short paramShort)
  {
    return (paramShort & 0xFF) == paramShort;
  }
  
  public static Vector parseSupportedSignatureAlgorithms(boolean paramBoolean, InputStream paramInputStream)
    throws IOException
  {
    int i = readUint16(paramInputStream);
    if ((i >= 2) && ((i & 0x1) == 0))
    {
      int j = i / 2;
      Vector localVector = new Vector(j);
      i = 0;
      while (i < j)
      {
        SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = SignatureAndHashAlgorithm.parse(paramInputStream);
        if ((!paramBoolean) && (localSignatureAndHashAlgorithm.getSignature() == 0)) {
          throw new TlsFatalAlert((short)47);
        }
        localVector.addElement(localSignatureAndHashAlgorithm);
        i += 1;
      }
      return localVector;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static ASN1Primitive readASN1Object(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new ASN1InputStream(paramArrayOfByte);
    ASN1Primitive localASN1Primitive = paramArrayOfByte.readObject();
    if (localASN1Primitive != null)
    {
      if (paramArrayOfByte.readObject() == null) {
        return localASN1Primitive;
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static byte[] readAllOrNothing(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt < 1) {
      return EMPTY_BYTES;
    }
    byte[] arrayOfByte = new byte[paramInt];
    int i = Streams.readFully(paramInputStream, arrayOfByte);
    if (i == 0) {
      return null;
    }
    if (i == paramInt) {
      return arrayOfByte;
    }
    throw new EOFException();
  }
  
  public static ASN1Primitive readDERObject(byte[] paramArrayOfByte)
    throws IOException
  {
    ASN1Primitive localASN1Primitive = readASN1Object(paramArrayOfByte);
    if (Arrays.areEqual(localASN1Primitive.getEncoded("DER"), paramArrayOfByte)) {
      return localASN1Primitive;
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static void readFully(byte[] paramArrayOfByte, InputStream paramInputStream)
    throws IOException
  {
    int i = paramArrayOfByte.length;
    if (i > 0)
    {
      if (i == Streams.readFully(paramInputStream, paramArrayOfByte)) {
        return;
      }
      throw new EOFException();
    }
  }
  
  public static byte[] readFully(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt < 1) {
      return EMPTY_BYTES;
    }
    byte[] arrayOfByte = new byte[paramInt];
    if (paramInt == Streams.readFully(paramInputStream, arrayOfByte)) {
      return arrayOfByte;
    }
    throw new EOFException();
  }
  
  public static byte[] readOpaque16(InputStream paramInputStream)
    throws IOException
  {
    return readFully(readUint16(paramInputStream), paramInputStream);
  }
  
  public static byte[] readOpaque24(InputStream paramInputStream)
    throws IOException
  {
    return readFully(readUint24(paramInputStream), paramInputStream);
  }
  
  public static byte[] readOpaque8(InputStream paramInputStream)
    throws IOException
  {
    return readFully(readUint8(paramInputStream), paramInputStream);
  }
  
  public static Vector readSignatureAlgorithmsExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      Vector localVector = parseSupportedSignatureAlgorithms(false, paramArrayOfByte);
      TlsProtocol.assertEmpty(paramArrayOfByte);
      return localVector;
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static int readUint16(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (j >= 0) {
      return j | i << 8;
    }
    throw new EOFException();
  }
  
  public static int readUint16(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 8;
  }
  
  public static int[] readUint16Array(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = readUint16(paramInputStream);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static int readUint24(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    if (k >= 0) {
      return k | i << 16 | j << 8;
    }
    throw new EOFException();
  }
  
  public static int readUint24(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    paramInt += 1;
    int j = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] & 0xFF | (i & 0xFF) << 16 | (j & 0xFF) << 8;
  }
  
  public static long readUint32(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    int k = paramInputStream.read();
    int m = paramInputStream.read();
    if (m >= 0) {
      return (m | i << 24 | j << 16 | k << 8) & 0xFFFFFFFF;
    }
    throw new EOFException();
  }
  
  public static long readUint32(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramInt + 1;
    paramInt = paramArrayOfByte[j];
    j += 1;
    int k = paramArrayOfByte[j];
    return (paramArrayOfByte[(j + 1)] & 0xFF | (i & 0xFF) << 24 | (paramInt & 0xFF) << 16 | (k & 0xFF) << 8) & 0xFFFFFFFF;
  }
  
  public static long readUint48(InputStream paramInputStream)
    throws IOException
  {
    int i = readUint24(paramInputStream);
    int j = readUint24(paramInputStream);
    return (i & 0xFFFFFFFF) << 24 | 0xFFFFFFFF & j;
  }
  
  public static long readUint48(byte[] paramArrayOfByte, int paramInt)
  {
    int i = readUint24(paramArrayOfByte, paramInt);
    paramInt = readUint24(paramArrayOfByte, paramInt + 3);
    long l = i;
    return paramInt & 0xFFFFFFFF | (l & 0xFFFFFFFF) << 24;
  }
  
  public static short readUint8(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i >= 0) {
      return (short)i;
    }
    throw new EOFException();
  }
  
  public static short readUint8(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(paramArrayOfByte[paramInt] & 0xFF);
  }
  
  public static short[] readUint8Array(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    short[] arrayOfShort = new short[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfShort[i] = readUint8(paramInputStream);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static ProtocolVersion readVersion(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (j >= 0) {
      return ProtocolVersion.get(i, j);
    }
    throw new EOFException();
  }
  
  public static ProtocolVersion readVersion(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    return ProtocolVersion.get(paramArrayOfByte[paramInt] & 0xFF, paramArrayOfByte[(paramInt + 1)] & 0xFF);
  }
  
  public static int readVersionRaw(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    int j = paramInputStream.read();
    if (j >= 0) {
      return j | i << 8;
    }
    throw new EOFException();
  }
  
  public static int readVersionRaw(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramArrayOfByte[paramInt];
    return paramArrayOfByte[(paramInt + 1)] | i << 8;
  }
  
  static void trackHashAlgorithms(TlsHandshakeHash paramTlsHandshakeHash, Vector paramVector)
  {
    if (paramVector != null)
    {
      int i = 0;
      while (i < paramVector.size())
      {
        short s = ((SignatureAndHashAlgorithm)paramVector.elementAt(i)).getHash();
        if (!HashAlgorithm.isPrivate(s)) {
          paramTlsHandshakeHash.trackHashAlgorithm(s);
        }
        i += 1;
      }
    }
  }
  
  static void validateKeyUsage(org.bouncycastle.asn1.x509.Certificate paramCertificate, int paramInt)
    throws IOException
  {
    paramCertificate = paramCertificate.getTBSCertificate().getExtensions();
    if (paramCertificate != null)
    {
      paramCertificate = KeyUsage.fromExtensions(paramCertificate);
      if (paramCertificate != null)
      {
        if ((paramCertificate.getBytes()[0] & 0xFF & paramInt) == paramInt) {
          return;
        }
        throw new TlsFatalAlert((short)46);
      }
    }
  }
  
  private static Vector vectorOfOne(Object paramObject)
  {
    Vector localVector = new Vector(1);
    localVector.addElement(paramObject);
    return localVector;
  }
  
  public static void verifySupportedSignatureAlgorithm(Vector paramVector, SignatureAndHashAlgorithm paramSignatureAndHashAlgorithm)
    throws IOException
  {
    if ((paramVector != null) && (paramVector.size() >= 1) && (paramVector.size() < 32768))
    {
      if (paramSignatureAndHashAlgorithm != null)
      {
        if (paramSignatureAndHashAlgorithm.getSignature() != 0)
        {
          int i = 0;
          while (i < paramVector.size())
          {
            SignatureAndHashAlgorithm localSignatureAndHashAlgorithm = (SignatureAndHashAlgorithm)paramVector.elementAt(i);
            if ((localSignatureAndHashAlgorithm.getHash() == paramSignatureAndHashAlgorithm.getHash()) && (localSignatureAndHashAlgorithm.getSignature() == paramSignatureAndHashAlgorithm.getSignature())) {
              return;
            }
            i += 1;
          }
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new IllegalArgumentException("'signatureAlgorithm' cannot be null");
    }
    throw new IllegalArgumentException("'supportedSignatureAlgorithms' must have length from 1 to (2^15 - 1)");
  }
  
  public static void writeGMTUnixTime(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    paramArrayOfByte[paramInt] = ((byte)(i >>> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(i >>> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(i >>> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)i);
  }
  
  public static void writeOpaque16(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    checkUint16(paramArrayOfByte.length);
    writeUint16(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static void writeOpaque24(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    checkUint24(paramArrayOfByte.length);
    writeUint24(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static void writeOpaque8(byte[] paramArrayOfByte, OutputStream paramOutputStream)
    throws IOException
  {
    checkUint8(paramArrayOfByte.length);
    writeUint8(paramArrayOfByte.length, paramOutputStream);
    paramOutputStream.write(paramArrayOfByte);
  }
  
  public static void writeUint16(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt >>> 8);
    paramOutputStream.write(paramInt);
  }
  
  public static void writeUint16(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)paramInt1);
  }
  
  public static void writeUint16Array(int[] paramArrayOfInt, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      writeUint16(paramArrayOfInt[i], paramOutputStream);
      i += 1;
    }
  }
  
  public static void writeUint16Array(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfInt.length)
    {
      writeUint16(paramArrayOfInt[paramInt], paramArrayOfByte, i);
      i += 2;
      paramInt += 1;
    }
  }
  
  public static void writeUint16ArrayWithUint16Length(int[] paramArrayOfInt, OutputStream paramOutputStream)
    throws IOException
  {
    int i = paramArrayOfInt.length * 2;
    checkUint16(i);
    writeUint16(i, paramOutputStream);
    writeUint16Array(paramArrayOfInt, paramOutputStream);
  }
  
  public static void writeUint16ArrayWithUint16Length(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int i = paramArrayOfInt.length * 2;
    checkUint16(i);
    writeUint16(i, paramArrayOfByte, paramInt);
    writeUint16Array(paramArrayOfInt, paramArrayOfByte, paramInt + 2);
  }
  
  public static void writeUint24(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write((byte)(paramInt >>> 16));
    paramOutputStream.write((byte)(paramInt >>> 8));
    paramOutputStream.write((byte)paramInt);
  }
  
  public static void writeUint24(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 >>> 16));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >>> 8));
    paramArrayOfByte[(paramInt2 + 2)] = ((byte)paramInt1);
  }
  
  public static void writeUint32(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)paramLong);
  }
  
  public static void writeUint32(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void writeUint48(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)paramLong);
  }
  
  public static void writeUint48(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)paramLong);
  }
  
  public static void writeUint64(long paramLong, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)paramLong);
  }
  
  public static void writeUint64(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >>> 56));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >>> 48));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >>> 40));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >>> 32));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >>> 24));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >>> 16));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >>> 8));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)paramLong);
  }
  
  public static void writeUint8(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramInt);
  }
  
  public static void writeUint8(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)paramInt1);
  }
  
  public static void writeUint8(short paramShort, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramShort);
  }
  
  public static void writeUint8(short paramShort, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)paramShort);
  }
  
  public static void writeUint8Array(short[] paramArrayOfShort, OutputStream paramOutputStream)
    throws IOException
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      writeUint8(paramArrayOfShort[i], paramOutputStream);
      i += 1;
    }
  }
  
  public static void writeUint8Array(short[] paramArrayOfShort, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < paramArrayOfShort.length)
    {
      writeUint8(paramArrayOfShort[paramInt], paramArrayOfByte, i);
      i += 1;
      paramInt += 1;
    }
  }
  
  public static void writeUint8ArrayWithUint8Length(short[] paramArrayOfShort, OutputStream paramOutputStream)
    throws IOException
  {
    checkUint8(paramArrayOfShort.length);
    writeUint8(paramArrayOfShort.length, paramOutputStream);
    writeUint8Array(paramArrayOfShort, paramOutputStream);
  }
  
  public static void writeUint8ArrayWithUint8Length(short[] paramArrayOfShort, byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    checkUint8(paramArrayOfShort.length);
    writeUint8(paramArrayOfShort.length, paramArrayOfByte, paramInt);
    writeUint8Array(paramArrayOfShort, paramArrayOfByte, paramInt + 1);
  }
  
  public static void writeVersion(ProtocolVersion paramProtocolVersion, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramProtocolVersion.getMajorVersion());
    paramOutputStream.write(paramProtocolVersion.getMinorVersion());
  }
  
  public static void writeVersion(ProtocolVersion paramProtocolVersion, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = ((byte)paramProtocolVersion.getMajorVersion());
    paramArrayOfByte[(paramInt + 1)] = ((byte)paramProtocolVersion.getMinorVersion());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */