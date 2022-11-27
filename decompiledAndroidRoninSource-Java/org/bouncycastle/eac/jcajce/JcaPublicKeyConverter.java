package org.bouncycastle.eac.jcajce;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.asn1.eac.ECDSAPublicKey;
import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.bouncycastle.eac.EACException;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint.Fp;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class JcaPublicKeyConverter
{
  private EACHelper helper = new DefaultEACHelper();
  
  private static EllipticCurve convertCurve(ECCurve paramECCurve)
  {
    return new EllipticCurve(convertField(paramECCurve.getField()), paramECCurve.getA().toBigInteger(), paramECCurve.getB().toBigInteger(), null);
  }
  
  private static ECCurve convertCurve(EllipticCurve paramEllipticCurve, BigInteger paramBigInteger, int paramInt)
  {
    ECField localECField = paramEllipticCurve.getField();
    BigInteger localBigInteger = paramEllipticCurve.getA();
    paramEllipticCurve = paramEllipticCurve.getB();
    if ((localECField instanceof ECFieldFp)) {
      return new ECCurve.Fp(((ECFieldFp)localECField).getP(), localBigInteger, paramEllipticCurve, paramBigInteger, BigInteger.valueOf(paramInt));
    }
    throw new IllegalStateException("not implemented yet!!!");
  }
  
  private static ECField convertField(FiniteField paramFiniteField)
  {
    if (ECAlgorithms.isFpField(paramFiniteField)) {
      return new ECFieldFp(paramFiniteField.getCharacteristic());
    }
    paramFiniteField = ((PolynomialExtensionField)paramFiniteField).getMinimalPolynomial();
    int[] arrayOfInt = paramFiniteField.getExponentsPresent();
    arrayOfInt = Arrays.reverse(Arrays.copyOfRange(arrayOfInt, 1, arrayOfInt.length - 1));
    return new ECFieldF2m(paramFiniteField.getDegree(), arrayOfInt);
  }
  
  private static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve paramECCurve, java.security.spec.ECPoint paramECPoint)
  {
    return paramECCurve.createPoint(paramECPoint.getAffineX(), paramECPoint.getAffineY());
  }
  
  private PublicKey getECPublicKeyPublicKey(ECDSAPublicKey paramECDSAPublicKey)
    throws EACException, InvalidKeySpecException
  {
    Object localObject = getParams(paramECDSAPublicKey);
    paramECDSAPublicKey = new ECPublicKeySpec(getPublicPoint(paramECDSAPublicKey), (ECParameterSpec)localObject);
    try
    {
      localObject = this.helper.createKeyFactory("ECDSA");
      return ((KeyFactory)localObject).generatePublic(paramECDSAPublicKey);
    }
    catch (NoSuchAlgorithmException paramECDSAPublicKey)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find algorithm ECDSA: ");
      ((StringBuilder)localObject).append(paramECDSAPublicKey.getMessage());
      throw new EACException(((StringBuilder)localObject).toString(), paramECDSAPublicKey);
    }
    catch (NoSuchProviderException paramECDSAPublicKey)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find provider: ");
      ((StringBuilder)localObject).append(paramECDSAPublicKey.getMessage());
      throw new EACException(((StringBuilder)localObject).toString(), paramECDSAPublicKey);
    }
  }
  
  private ECParameterSpec getParams(ECDSAPublicKey paramECDSAPublicKey)
  {
    if (paramECDSAPublicKey.hasParameters())
    {
      ECCurve.Fp localFp = new ECCurve.Fp(paramECDSAPublicKey.getPrimeModulusP(), paramECDSAPublicKey.getFirstCoefA(), paramECDSAPublicKey.getSecondCoefB(), paramECDSAPublicKey.getOrderOfBasePointR(), paramECDSAPublicKey.getCofactorF());
      org.bouncycastle.math.ec.ECPoint localECPoint = localFp.decodePoint(paramECDSAPublicKey.getBasePointG());
      BigInteger localBigInteger = paramECDSAPublicKey.getOrderOfBasePointR();
      paramECDSAPublicKey = paramECDSAPublicKey.getCofactorF();
      return new ECParameterSpec(convertCurve(localFp), new java.security.spec.ECPoint(localECPoint.getAffineXCoord().toBigInteger(), localECPoint.getAffineYCoord().toBigInteger()), localBigInteger, paramECDSAPublicKey.intValue());
    }
    throw new IllegalArgumentException("Public key does not contains EC Params");
  }
  
  private java.security.spec.ECPoint getPublicPoint(ECDSAPublicKey paramECDSAPublicKey)
  {
    if (paramECDSAPublicKey.hasParameters())
    {
      paramECDSAPublicKey = (ECPoint.Fp)new ECCurve.Fp(paramECDSAPublicKey.getPrimeModulusP(), paramECDSAPublicKey.getFirstCoefA(), paramECDSAPublicKey.getSecondCoefB(), paramECDSAPublicKey.getOrderOfBasePointR(), paramECDSAPublicKey.getCofactorF()).decodePoint(paramECDSAPublicKey.getPublicPointY());
      return new java.security.spec.ECPoint(paramECDSAPublicKey.getAffineXCoord().toBigInteger(), paramECDSAPublicKey.getAffineYCoord().toBigInteger());
    }
    throw new IllegalArgumentException("Public key does not contains EC Params");
  }
  
  public PublicKey getKey(PublicKeyDataObject paramPublicKeyDataObject)
    throws EACException, InvalidKeySpecException
  {
    if (paramPublicKeyDataObject.getUsage().on(EACObjectIdentifiers.id_TA_ECDSA)) {
      return getECPublicKeyPublicKey((ECDSAPublicKey)paramPublicKeyDataObject);
    }
    paramPublicKeyDataObject = (org.bouncycastle.asn1.eac.RSAPublicKey)paramPublicKeyDataObject;
    paramPublicKeyDataObject = new RSAPublicKeySpec(paramPublicKeyDataObject.getModulus(), paramPublicKeyDataObject.getPublicExponent());
    try
    {
      paramPublicKeyDataObject = this.helper.createKeyFactory("RSA").generatePublic(paramPublicKeyDataObject);
      return paramPublicKeyDataObject;
    }
    catch (NoSuchAlgorithmException paramPublicKeyDataObject)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find algorithm ECDSA: ");
      localStringBuilder.append(paramPublicKeyDataObject.getMessage());
      throw new EACException(localStringBuilder.toString(), paramPublicKeyDataObject);
    }
    catch (NoSuchProviderException paramPublicKeyDataObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot find provider: ");
      localStringBuilder.append(paramPublicKeyDataObject.getMessage());
      throw new EACException(localStringBuilder.toString(), paramPublicKeyDataObject);
    }
  }
  
  public PublicKeyDataObject getPublicKeyDataObject(ASN1ObjectIdentifier paramASN1ObjectIdentifier, PublicKey paramPublicKey)
  {
    if ((paramPublicKey instanceof java.security.interfaces.RSAPublicKey))
    {
      paramPublicKey = (java.security.interfaces.RSAPublicKey)paramPublicKey;
      return new org.bouncycastle.asn1.eac.RSAPublicKey(paramASN1ObjectIdentifier, paramPublicKey.getModulus(), paramPublicKey.getPublicExponent());
    }
    paramPublicKey = (ECPublicKey)paramPublicKey;
    ECParameterSpec localECParameterSpec = paramPublicKey.getParams();
    return new ECDSAPublicKey(paramASN1ObjectIdentifier, ((ECFieldFp)localECParameterSpec.getCurve().getField()).getP(), localECParameterSpec.getCurve().getA(), localECParameterSpec.getCurve().getB(), convertPoint(convertCurve(localECParameterSpec.getCurve(), localECParameterSpec.getOrder(), localECParameterSpec.getCofactor()), localECParameterSpec.getGenerator()).getEncoded(), localECParameterSpec.getOrder(), convertPoint(convertCurve(localECParameterSpec.getCurve(), localECParameterSpec.getOrder(), localECParameterSpec.getCofactor()), paramPublicKey.getW()).getEncoded(), localECParameterSpec.getCofactor());
  }
  
  public JcaPublicKeyConverter setProvider(String paramString)
  {
    this.helper = new NamedEACHelper(paramString);
    return this;
  }
  
  public JcaPublicKeyConverter setProvider(Provider paramProvider)
  {
    this.helper = new ProviderEACHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\jcajce\JcaPublicKeyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */