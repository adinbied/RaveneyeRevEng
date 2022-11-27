package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.F2m;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Integers;

public class TlsECCUtils
{
  private static final String[] CURVE_NAMES = { "sect163k1", "sect163r1", "sect163r2", "sect193r1", "sect193r2", "sect233k1", "sect233r1", "sect239k1", "sect283k1", "sect283r1", "sect409k1", "sect409r1", "sect571k1", "sect571r1", "secp160k1", "secp160r1", "secp160r2", "secp192k1", "secp192r1", "secp224k1", "secp224r1", "secp256k1", "secp256r1", "secp384r1", "secp521r1", "brainpoolP256r1", "brainpoolP384r1", "brainpoolP512r1" };
  public static final Integer EXT_ec_point_formats;
  public static final Integer EXT_elliptic_curves = Integers.valueOf(10);
  
  static
  {
    EXT_ec_point_formats = Integers.valueOf(11);
  }
  
  public static void addSupportedEllipticCurvesExtension(Hashtable paramHashtable, int[] paramArrayOfInt)
    throws IOException
  {
    paramHashtable.put(EXT_elliptic_curves, createSupportedEllipticCurvesExtension(paramArrayOfInt));
  }
  
  public static void addSupportedPointFormatsExtension(Hashtable paramHashtable, short[] paramArrayOfShort)
    throws IOException
  {
    paramHashtable.put(EXT_ec_point_formats, createSupportedPointFormatsExtension(paramArrayOfShort));
  }
  
  public static boolean areOnSameCurve(ECDomainParameters paramECDomainParameters1, ECDomainParameters paramECDomainParameters2)
  {
    return (paramECDomainParameters1 != null) && (paramECDomainParameters1.equals(paramECDomainParameters2));
  }
  
  public static byte[] calculateECDHBasicAgreement(ECPublicKeyParameters paramECPublicKeyParameters, ECPrivateKeyParameters paramECPrivateKeyParameters)
  {
    ECDHBasicAgreement localECDHBasicAgreement = new ECDHBasicAgreement();
    localECDHBasicAgreement.init(paramECPrivateKeyParameters);
    paramECPublicKeyParameters = localECDHBasicAgreement.calculateAgreement(paramECPublicKeyParameters);
    return BigIntegers.asUnsignedByteArray(localECDHBasicAgreement.getFieldSize(), paramECPublicKeyParameters);
  }
  
  private static void checkNamedCurve(int[] paramArrayOfInt, int paramInt)
    throws IOException
  {
    if (paramArrayOfInt != null)
    {
      if (Arrays.contains(paramArrayOfInt, paramInt)) {
        return;
      }
      throw new TlsFatalAlert((short)47);
    }
  }
  
  public static boolean containsECCCipherSuites(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (isECCCipherSuite(paramArrayOfInt[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static byte[] createSupportedEllipticCurvesExtension(int[] paramArrayOfInt)
    throws IOException
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 1)) {
      return TlsUtils.encodeUint16ArrayWithUint16Length(paramArrayOfInt);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static byte[] createSupportedPointFormatsExtension(short[] paramArrayOfShort)
    throws IOException
  {
    short[] arrayOfShort;
    if (paramArrayOfShort != null)
    {
      arrayOfShort = paramArrayOfShort;
      if (Arrays.contains(paramArrayOfShort, (short)0)) {}
    }
    else
    {
      arrayOfShort = Arrays.append(paramArrayOfShort, (short)0);
    }
    return TlsUtils.encodeUint8ArrayWithUint8Length(arrayOfShort);
  }
  
  public static BigInteger deserializeECFieldElement(int paramInt, byte[] paramArrayOfByte)
    throws IOException
  {
    paramInt = (paramInt + 7) / 8;
    if (paramArrayOfByte.length == paramInt) {
      return new BigInteger(1, paramArrayOfByte);
    }
    throw new TlsFatalAlert((short)50);
  }
  
  public static ECPoint deserializeECPoint(short[] paramArrayOfShort, ECCurve paramECCurve, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      short s = 1;
      if (i >= 1)
      {
        i = paramArrayOfByte[0];
        if ((i != 2) && (i != 3))
        {
          if (i == 4) {
            s = 0;
          } else {
            throw new TlsFatalAlert((short)47);
          }
        }
        else if (ECAlgorithms.isF2mCurve(paramECCurve)) {
          s = 2;
        } else {
          if (!ECAlgorithms.isFpCurve(paramECCurve)) {
            break label108;
          }
        }
        if ((s != 0) && ((paramArrayOfShort == null) || (!Arrays.contains(paramArrayOfShort, s)))) {
          throw new TlsFatalAlert((short)47);
        }
        return paramECCurve.decodePoint(paramArrayOfByte);
        label108:
        throw new TlsFatalAlert((short)47);
      }
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public static ECPublicKeyParameters deserializeECPublicKey(short[] paramArrayOfShort, ECDomainParameters paramECDomainParameters, byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfShort = new ECPublicKeyParameters(deserializeECPoint(paramArrayOfShort, paramECDomainParameters.getCurve(), paramArrayOfByte), paramECDomainParameters);
      return paramArrayOfShort;
    }
    catch (RuntimeException paramArrayOfShort)
    {
      throw new TlsFatalAlert((short)47, paramArrayOfShort);
    }
  }
  
  public static AsymmetricCipherKeyPair generateECKeyPair(SecureRandom paramSecureRandom, ECDomainParameters paramECDomainParameters)
  {
    ECKeyPairGenerator localECKeyPairGenerator = new ECKeyPairGenerator();
    localECKeyPairGenerator.init(new ECKeyGenerationParameters(paramECDomainParameters, paramSecureRandom));
    return localECKeyPairGenerator.generateKeyPair();
  }
  
  public static ECPrivateKeyParameters generateEphemeralClientKeyExchange(SecureRandom paramSecureRandom, short[] paramArrayOfShort, ECDomainParameters paramECDomainParameters, OutputStream paramOutputStream)
    throws IOException
  {
    paramSecureRandom = generateECKeyPair(paramSecureRandom, paramECDomainParameters);
    writeECPoint(paramArrayOfShort, ((ECPublicKeyParameters)paramSecureRandom.getPublic()).getQ(), paramOutputStream);
    return (ECPrivateKeyParameters)paramSecureRandom.getPrivate();
  }
  
  static ECPrivateKeyParameters generateEphemeralServerKeyExchange(SecureRandom paramSecureRandom, int[] paramArrayOfInt, short[] paramArrayOfShort, OutputStream paramOutputStream)
    throws IOException
  {
    int i;
    if (paramArrayOfInt == null)
    {
      i = 23;
    }
    else
    {
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if ((NamedCurve.isValid(j)) && (isSupportedNamedCurve(j)))
        {
          i = j;
          break label62;
        }
        i += 1;
      }
      i = -1;
    }
    label62:
    ECDomainParameters localECDomainParameters = null;
    if (i >= 0) {
      localECDomainParameters = getParametersForNamedCurve(i);
    } else if (Arrays.contains(paramArrayOfInt, 65281)) {
      localECDomainParameters = getParametersForNamedCurve(23);
    } else if (Arrays.contains(paramArrayOfInt, 65282)) {
      localECDomainParameters = getParametersForNamedCurve(10);
    }
    if (localECDomainParameters != null)
    {
      if (i < 0) {
        writeExplicitECParameters(paramArrayOfShort, localECDomainParameters, paramOutputStream);
      } else {
        writeNamedECParameters(i, paramOutputStream);
      }
      return generateEphemeralClientKeyExchange(paramSecureRandom, paramArrayOfShort, localECDomainParameters, paramOutputStream);
    }
    throw new TlsFatalAlert((short)80);
  }
  
  public static String getNameOfNamedCurve(int paramInt)
  {
    if (isSupportedNamedCurve(paramInt)) {
      return CURVE_NAMES[(paramInt - 1)];
    }
    return null;
  }
  
  public static ECDomainParameters getParametersForNamedCurve(int paramInt)
  {
    String str = getNameOfNamedCurve(paramInt);
    if (str == null) {
      return null;
    }
    X9ECParameters localX9ECParameters2 = CustomNamedCurves.getByName(str);
    X9ECParameters localX9ECParameters1 = localX9ECParameters2;
    if (localX9ECParameters2 == null)
    {
      localX9ECParameters2 = ECNamedCurveTable.getByName(str);
      localX9ECParameters1 = localX9ECParameters2;
      if (localX9ECParameters2 == null) {
        return null;
      }
    }
    return new ECDomainParameters(localX9ECParameters1.getCurve(), localX9ECParameters1.getG(), localX9ECParameters1.getN(), localX9ECParameters1.getH(), localX9ECParameters1.getSeed());
  }
  
  public static int[] getSupportedEllipticCurvesExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_elliptic_curves);
    if (paramHashtable == null) {
      return null;
    }
    return readSupportedEllipticCurvesExtension(paramHashtable);
  }
  
  public static short[] getSupportedPointFormatsExtension(Hashtable paramHashtable)
    throws IOException
  {
    paramHashtable = TlsUtils.getExtensionData(paramHashtable, EXT_ec_point_formats);
    if (paramHashtable == null) {
      return null;
    }
    return readSupportedPointFormatsExtension(paramHashtable);
  }
  
  public static boolean hasAnySupportedNamedCurves()
  {
    return CURVE_NAMES.length > 0;
  }
  
  public static boolean isCompressionPreferred(short[] paramArrayOfShort, short paramShort)
  {
    if (paramArrayOfShort == null) {
      return false;
    }
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      short s = paramArrayOfShort[i];
      if (s == 0) {
        return false;
      }
      if (s == paramShort) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean isECCCipherSuite(int paramInt)
  {
    if (paramInt != 52396) {
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
                        return false;
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
    }
    return true;
  }
  
  public static boolean isSupportedNamedCurve(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= CURVE_NAMES.length);
  }
  
  public static int readECExponent(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = readECParameter(paramInputStream);
    if (paramInputStream.bitLength() < 32)
    {
      int i = paramInputStream.intValue();
      if ((i > 0) && (i < paramInt)) {
        return i;
      }
    }
    throw new TlsFatalAlert((short)47);
  }
  
  public static BigInteger readECFieldElement(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    return deserializeECFieldElement(paramInt, TlsUtils.readOpaque8(paramInputStream));
  }
  
  public static BigInteger readECParameter(InputStream paramInputStream)
    throws IOException
  {
    return new BigInteger(1, TlsUtils.readOpaque8(paramInputStream));
  }
  
  public static ECDomainParameters readECParameters(int[] paramArrayOfInt, short[] paramArrayOfShort, InputStream paramInputStream)
    throws IOException
  {
    for (;;)
    {
      try
      {
        i = TlsUtils.readUint8(paramInputStream);
        BigInteger localBigInteger1;
        Object localObject1;
        Object localObject2;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              i = TlsUtils.readUint16(paramInputStream);
              if (NamedCurve.refersToASpecificNamedCurve(i))
              {
                checkNamedCurve(paramArrayOfInt, i);
                return getParametersForNamedCurve(i);
              }
              throw new TlsFatalAlert((short)47);
            }
            throw new TlsFatalAlert((short)47);
          }
          checkNamedCurve(paramArrayOfInt, 65282);
          int k = TlsUtils.readUint16(paramInputStream);
          short s = TlsUtils.readUint8(paramInputStream);
          if (ECBasisType.isValid(s))
          {
            int m = readECExponent(k, paramInputStream);
            if (s == 2)
            {
              i = readECExponent(k, paramInputStream);
              j = readECExponent(k, paramInputStream);
              paramArrayOfInt = readECFieldElement(k, paramInputStream);
              localBigInteger1 = readECFieldElement(k, paramInputStream);
              localObject1 = TlsUtils.readOpaque8(paramInputStream);
              localObject2 = readECParameter(paramInputStream);
              paramInputStream = readECParameter(paramInputStream);
              if (s == 2) {
                paramArrayOfInt = new ECCurve.F2m(k, m, i, j, paramArrayOfInt, localBigInteger1, (BigInteger)localObject2, paramInputStream);
              } else {
                paramArrayOfInt = new ECCurve.F2m(k, m, paramArrayOfInt, localBigInteger1, (BigInteger)localObject2, paramInputStream);
              }
              return new ECDomainParameters(paramArrayOfInt, deserializeECPoint(paramArrayOfShort, paramArrayOfInt, (byte[])localObject1), (BigInteger)localObject2, paramInputStream);
            }
          }
          else
          {
            throw new TlsFatalAlert((short)47);
          }
        }
        else
        {
          checkNamedCurve(paramArrayOfInt, 65281);
          localObject2 = readECParameter(paramInputStream);
          localBigInteger1 = readECFieldElement(((BigInteger)localObject2).bitLength(), paramInputStream);
          BigInteger localBigInteger2 = readECFieldElement(((BigInteger)localObject2).bitLength(), paramInputStream);
          paramArrayOfInt = TlsUtils.readOpaque8(paramInputStream);
          localObject1 = readECParameter(paramInputStream);
          paramInputStream = readECParameter(paramInputStream);
          localObject2 = new ECCurve.Fp((BigInteger)localObject2, localBigInteger1, localBigInteger2, (BigInteger)localObject1, paramInputStream);
          paramArrayOfInt = new ECDomainParameters((ECCurve)localObject2, deserializeECPoint(paramArrayOfShort, (ECCurve)localObject2, paramArrayOfInt), (BigInteger)localObject1, paramInputStream);
          return paramArrayOfInt;
        }
      }
      catch (RuntimeException paramArrayOfInt)
      {
        throw new TlsFatalAlert((short)47, paramArrayOfInt);
      }
      int i = -1;
      int j = -1;
    }
  }
  
  public static int[] readSupportedEllipticCurvesExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      int i = TlsUtils.readUint16(paramArrayOfByte);
      if ((i >= 2) && ((i & 0x1) == 0))
      {
        int[] arrayOfInt = TlsUtils.readUint16Array(i / 2, paramArrayOfByte);
        TlsProtocol.assertEmpty(paramArrayOfByte);
        return arrayOfInt;
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static short[] readSupportedPointFormatsExtension(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      int i = TlsUtils.readUint8(paramArrayOfByte);
      if (i >= 1)
      {
        short[] arrayOfShort = TlsUtils.readUint8Array(i, paramArrayOfByte);
        TlsProtocol.assertEmpty(paramArrayOfByte);
        if (Arrays.contains(arrayOfShort, (short)0)) {
          return arrayOfShort;
        }
        throw new TlsFatalAlert((short)47);
      }
      throw new TlsFatalAlert((short)50);
    }
    throw new IllegalArgumentException("'extensionData' cannot be null");
  }
  
  public static byte[] serializeECFieldElement(int paramInt, BigInteger paramBigInteger)
    throws IOException
  {
    return BigIntegers.asUnsignedByteArray((paramInt + 7) / 8, paramBigInteger);
  }
  
  public static byte[] serializeECPoint(short[] paramArrayOfShort, ECPoint paramECPoint)
    throws IOException
  {
    ECCurve localECCurve = paramECPoint.getCurve();
    if (ECAlgorithms.isFpCurve(localECCurve)) {}
    for (short s = 1;; s = 2)
    {
      bool = isCompressionPreferred(paramArrayOfShort, s);
      break label40;
      if (!ECAlgorithms.isF2mCurve(localECCurve)) {
        break;
      }
    }
    boolean bool = false;
    label40:
    return paramECPoint.getEncoded(bool);
  }
  
  public static byte[] serializeECPublicKey(short[] paramArrayOfShort, ECPublicKeyParameters paramECPublicKeyParameters)
    throws IOException
  {
    return serializeECPoint(paramArrayOfShort, paramECPublicKeyParameters.getQ());
  }
  
  public static ECPublicKeyParameters validateECPublicKey(ECPublicKeyParameters paramECPublicKeyParameters)
    throws IOException
  {
    return paramECPublicKeyParameters;
  }
  
  public static void writeECExponent(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    writeECParameter(BigInteger.valueOf(paramInt), paramOutputStream);
  }
  
  public static void writeECFieldElement(int paramInt, BigInteger paramBigInteger, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque8(serializeECFieldElement(paramInt, paramBigInteger), paramOutputStream);
  }
  
  public static void writeECFieldElement(ECFieldElement paramECFieldElement, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque8(paramECFieldElement.getEncoded(), paramOutputStream);
  }
  
  public static void writeECParameter(BigInteger paramBigInteger, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque8(BigIntegers.asUnsignedByteArray(paramBigInteger), paramOutputStream);
  }
  
  public static void writeECPoint(short[] paramArrayOfShort, ECPoint paramECPoint, OutputStream paramOutputStream)
    throws IOException
  {
    TlsUtils.writeOpaque8(serializeECPoint(paramArrayOfShort, paramECPoint), paramOutputStream);
  }
  
  public static void writeExplicitECParameters(short[] paramArrayOfShort, ECDomainParameters paramECDomainParameters, OutputStream paramOutputStream)
    throws IOException
  {
    ECCurve localECCurve = paramECDomainParameters.getCurve();
    if (ECAlgorithms.isFpCurve(localECCurve))
    {
      TlsUtils.writeUint8((short)1, paramOutputStream);
      writeECParameter(localECCurve.getField().getCharacteristic(), paramOutputStream);
    }
    else
    {
      if (!ECAlgorithms.isF2mCurve(localECCurve)) {
        break label206;
      }
      int[] arrayOfInt = ((PolynomialExtensionField)localECCurve.getField()).getMinimalPolynomial().getExponentsPresent();
      TlsUtils.writeUint8((short)2, paramOutputStream);
      int i = arrayOfInt[(arrayOfInt.length - 1)];
      TlsUtils.checkUint16(i);
      TlsUtils.writeUint16(i, paramOutputStream);
      if (arrayOfInt.length == 3) {
        TlsUtils.writeUint8((short)1, paramOutputStream);
      }
      for (i = arrayOfInt[1];; i = arrayOfInt[3])
      {
        writeECExponent(i, paramOutputStream);
        break;
        if (arrayOfInt.length != 5) {
          break label195;
        }
        TlsUtils.writeUint8((short)2, paramOutputStream);
        writeECExponent(arrayOfInt[1], paramOutputStream);
        writeECExponent(arrayOfInt[2], paramOutputStream);
      }
    }
    writeECFieldElement(localECCurve.getA(), paramOutputStream);
    writeECFieldElement(localECCurve.getB(), paramOutputStream);
    TlsUtils.writeOpaque8(serializeECPoint(paramArrayOfShort, paramECDomainParameters.getG()), paramOutputStream);
    writeECParameter(paramECDomainParameters.getN(), paramOutputStream);
    writeECParameter(paramECDomainParameters.getH(), paramOutputStream);
    return;
    label195:
    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
    label206:
    throw new IllegalArgumentException("'ecParameters' not a known curve type");
  }
  
  public static void writeNamedECParameters(int paramInt, OutputStream paramOutputStream)
    throws IOException
  {
    if (NamedCurve.refersToASpecificNamedCurve(paramInt))
    {
      TlsUtils.writeUint8((short)3, paramOutputStream);
      TlsUtils.checkUint16(paramInt);
      TlsUtils.writeUint16(paramInt, paramOutputStream);
      return;
    }
    throw new TlsFatalAlert((short)80);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsECCUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */