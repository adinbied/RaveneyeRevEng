package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECCurve.F2m;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.util.Arrays;

public class EC5Util
{
  private static Map customCurves = new HashMap();
  
  static
  {
    Object localObject = CustomNamedCurves.getNames();
    while (((Enumeration)localObject).hasMoreElements())
    {
      String str = (String)((Enumeration)localObject).nextElement();
      X9ECParameters localX9ECParameters = ECNamedCurveTable.getByName(str);
      if (localX9ECParameters != null) {
        customCurves.put(localX9ECParameters.getCurve(), CustomNamedCurves.getByName(str).getCurve());
      }
    }
    localObject = CustomNamedCurves.getByName("Curve25519");
    customCurves.put(new ECCurve.Fp(((X9ECParameters)localObject).getCurve().getField().getCharacteristic(), ((X9ECParameters)localObject).getCurve().getA().toBigInteger(), ((X9ECParameters)localObject).getCurve().getB().toBigInteger()), ((X9ECParameters)localObject).getCurve());
  }
  
  public static EllipticCurve convertCurve(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    return new EllipticCurve(convertField(paramECCurve.getField()), paramECCurve.getA().toBigInteger(), paramECCurve.getB().toBigInteger(), null);
  }
  
  public static ECCurve convertCurve(EllipticCurve paramEllipticCurve)
  {
    Object localObject2 = paramEllipticCurve.getField();
    Object localObject1 = paramEllipticCurve.getA();
    paramEllipticCurve = paramEllipticCurve.getB();
    if ((localObject2 instanceof ECFieldFp))
    {
      localObject1 = new ECCurve.Fp(((ECFieldFp)localObject2).getP(), (BigInteger)localObject1, paramEllipticCurve);
      paramEllipticCurve = (EllipticCurve)localObject1;
      if (customCurves.containsKey(localObject1)) {
        paramEllipticCurve = (ECCurve)customCurves.get(localObject1);
      }
      return paramEllipticCurve;
    }
    localObject2 = (ECFieldF2m)localObject2;
    int i = ((ECFieldF2m)localObject2).getM();
    localObject2 = ECUtil.convertMidTerms(((ECFieldF2m)localObject2).getMidTermsOfReductionPolynomial());
    return new ECCurve.F2m(i, localObject2[0], localObject2[1], localObject2[2], (BigInteger)localObject1, paramEllipticCurve);
  }
  
  public static ECField convertField(FiniteField paramFiniteField)
  {
    if (ECAlgorithms.isFpField(paramFiniteField)) {
      return new ECFieldFp(paramFiniteField.getCharacteristic());
    }
    paramFiniteField = ((PolynomialExtensionField)paramFiniteField).getMinimalPolynomial();
    int[] arrayOfInt = paramFiniteField.getExponentsPresent();
    arrayOfInt = Arrays.reverse(Arrays.copyOfRange(arrayOfInt, 1, arrayOfInt.length - 1));
    return new ECFieldF2m(paramFiniteField.getDegree(), arrayOfInt);
  }
  
  public static org.bouncycastle.math.ec.ECPoint convertPoint(java.security.spec.ECParameterSpec paramECParameterSpec, java.security.spec.ECPoint paramECPoint, boolean paramBoolean)
  {
    return convertPoint(convertCurve(paramECParameterSpec.getCurve()), paramECPoint, paramBoolean);
  }
  
  public static org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve paramECCurve, java.security.spec.ECPoint paramECPoint, boolean paramBoolean)
  {
    return paramECCurve.createPoint(paramECPoint.getAffineX(), paramECPoint.getAffineY());
  }
  
  public static java.security.spec.ECParameterSpec convertSpec(EllipticCurve paramEllipticCurve, org.bouncycastle.jce.spec.ECParameterSpec paramECParameterSpec)
  {
    if ((paramECParameterSpec instanceof ECNamedCurveParameterSpec)) {
      return new ECNamedCurveSpec(((ECNamedCurveParameterSpec)paramECParameterSpec).getName(), paramEllipticCurve, new java.security.spec.ECPoint(paramECParameterSpec.getG().getAffineXCoord().toBigInteger(), paramECParameterSpec.getG().getAffineYCoord().toBigInteger()), paramECParameterSpec.getN(), paramECParameterSpec.getH());
    }
    return new java.security.spec.ECParameterSpec(paramEllipticCurve, new java.security.spec.ECPoint(paramECParameterSpec.getG().getAffineXCoord().toBigInteger(), paramECParameterSpec.getG().getAffineYCoord().toBigInteger()), paramECParameterSpec.getN(), paramECParameterSpec.getH().intValue());
  }
  
  public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(java.security.spec.ECParameterSpec paramECParameterSpec, boolean paramBoolean)
  {
    ECCurve localECCurve = convertCurve(paramECParameterSpec.getCurve());
    return new org.bouncycastle.jce.spec.ECParameterSpec(localECCurve, convertPoint(localECCurve, paramECParameterSpec.getGenerator(), paramBoolean), paramECParameterSpec.getOrder(), BigInteger.valueOf(paramECParameterSpec.getCofactor()), paramECParameterSpec.getCurve().getSeed());
  }
  
  public static java.security.spec.ECParameterSpec convertToSpec(X962Parameters paramX962Parameters, ECCurve paramECCurve)
  {
    if (paramX962Parameters.isNamedCurve())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)paramX962Parameters.getParameters();
      X9ECParameters localX9ECParameters = ECUtil.getNamedCurveByOid(localASN1ObjectIdentifier);
      paramX962Parameters = localX9ECParameters;
      if (localX9ECParameters == null)
      {
        Map localMap = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
        paramX962Parameters = localX9ECParameters;
        if (!localMap.isEmpty()) {
          paramX962Parameters = (X9ECParameters)localMap.get(localASN1ObjectIdentifier);
        }
      }
      paramECCurve = convertCurve(paramECCurve, paramX962Parameters.getSeed());
      return new ECNamedCurveSpec(ECUtil.getCurveName(localASN1ObjectIdentifier), paramECCurve, new java.security.spec.ECPoint(paramX962Parameters.getG().getAffineXCoord().toBigInteger(), paramX962Parameters.getG().getAffineYCoord().toBigInteger()), paramX962Parameters.getN(), paramX962Parameters.getH());
    }
    if (paramX962Parameters.isImplicitlyCA()) {
      return null;
    }
    paramX962Parameters = X9ECParameters.getInstance(paramX962Parameters.getParameters());
    paramECCurve = convertCurve(paramECCurve, paramX962Parameters.getSeed());
    if (paramX962Parameters.getH() != null) {
      paramX962Parameters = new java.security.spec.ECParameterSpec(paramECCurve, new java.security.spec.ECPoint(paramX962Parameters.getG().getAffineXCoord().toBigInteger(), paramX962Parameters.getG().getAffineYCoord().toBigInteger()), paramX962Parameters.getN(), paramX962Parameters.getH().intValue());
    } else {
      paramX962Parameters = new java.security.spec.ECParameterSpec(paramECCurve, new java.security.spec.ECPoint(paramX962Parameters.getG().getAffineXCoord().toBigInteger(), paramX962Parameters.getG().getAffineYCoord().toBigInteger()), paramX962Parameters.getN(), 1);
    }
    return paramX962Parameters;
  }
  
  public static java.security.spec.ECParameterSpec convertToSpec(X9ECParameters paramX9ECParameters)
  {
    return new java.security.spec.ECParameterSpec(convertCurve(paramX9ECParameters.getCurve(), null), new java.security.spec.ECPoint(paramX9ECParameters.getG().getAffineXCoord().toBigInteger(), paramX9ECParameters.getG().getAffineYCoord().toBigInteger()), paramX9ECParameters.getN(), paramX9ECParameters.getH().intValue());
  }
  
  public static ECCurve getCurve(ProviderConfiguration paramProviderConfiguration, X962Parameters paramX962Parameters)
  {
    Object localObject = paramProviderConfiguration.getAcceptableNamedCurves();
    if (paramX962Parameters.isNamedCurve())
    {
      ASN1ObjectIdentifier localASN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(paramX962Parameters.getParameters());
      if ((!((Set)localObject).isEmpty()) && (!((Set)localObject).contains(localASN1ObjectIdentifier))) {
        throw new IllegalStateException("named curve not acceptable");
      }
      localObject = ECUtil.getNamedCurveByOid(localASN1ObjectIdentifier);
      paramX962Parameters = (X962Parameters)localObject;
      if (localObject == null) {
        paramX962Parameters = (X9ECParameters)paramProviderConfiguration.getAdditionalECParameters().get(localASN1ObjectIdentifier);
      }
      return paramX962Parameters.getCurve();
    }
    if (paramX962Parameters.isImplicitlyCA()) {
      return paramProviderConfiguration.getEcImplicitlyCa().getCurve();
    }
    if (((Set)localObject).isEmpty()) {
      return X9ECParameters.getInstance(paramX962Parameters.getParameters()).getCurve();
    }
    throw new IllegalStateException("encoded parameters not acceptable");
  }
  
  public static ECDomainParameters getDomainParameters(ProviderConfiguration paramProviderConfiguration, java.security.spec.ECParameterSpec paramECParameterSpec)
  {
    if (paramECParameterSpec == null)
    {
      paramProviderConfiguration = paramProviderConfiguration.getEcImplicitlyCa();
      return new ECDomainParameters(paramProviderConfiguration.getCurve(), paramProviderConfiguration.getG(), paramProviderConfiguration.getN(), paramProviderConfiguration.getH(), paramProviderConfiguration.getSeed());
    }
    return ECUtil.getDomainParameters(paramProviderConfiguration, convertSpec(paramECParameterSpec, false));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetri\\util\EC5Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */