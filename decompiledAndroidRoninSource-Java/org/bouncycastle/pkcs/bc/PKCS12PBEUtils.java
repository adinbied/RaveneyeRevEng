package org.bouncycastle.pkcs.bc;

import java.io.OutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.engines.RC2Engine;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.MacOutputStream;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.DESedeParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.util.Integers;

class PKCS12PBEUtils
{
  private static Set desAlgs;
  private static Map keySizes = new HashMap();
  private static Set noIvAlgs = new HashSet();
  
  static
  {
    desAlgs = new HashSet();
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4, Integers.valueOf(128));
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, Integers.valueOf(40));
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, Integers.valueOf(192));
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, Integers.valueOf(128));
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.valueOf(128));
    keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.valueOf(40));
    noIvAlgs.add(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4);
    noIvAlgs.add(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4);
    desAlgs.add(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC);
    desAlgs.add(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC);
  }
  
  static CipherParameters createCipherParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ExtendedDigest paramExtendedDigest, int paramInt, PKCS12PBEParams paramPKCS12PBEParams, char[] paramArrayOfChar)
  {
    paramExtendedDigest = new PKCS12ParametersGenerator(paramExtendedDigest);
    paramExtendedDigest.init(PKCS12ParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar), paramPKCS12PBEParams.getIV(), paramPKCS12PBEParams.getIterations().intValue());
    if (hasNoIv(paramASN1ObjectIdentifier)) {
      return paramExtendedDigest.generateDerivedParameters(getKeySize(paramASN1ObjectIdentifier));
    }
    paramExtendedDigest = paramExtendedDigest.generateDerivedParameters(getKeySize(paramASN1ObjectIdentifier), paramInt * 8);
    if (isDesAlg(paramASN1ObjectIdentifier)) {
      DESedeParameters.setOddParity(((KeyParameter)((ParametersWithIV)paramExtendedDigest).getParameters()).getKey());
    }
    return paramExtendedDigest;
  }
  
  static MacCalculator createMacCalculator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, final ExtendedDigest paramExtendedDigest, final PKCS12PBEParams paramPKCS12PBEParams, final char[] paramArrayOfChar)
  {
    Object localObject = new PKCS12ParametersGenerator(paramExtendedDigest);
    ((PKCS12ParametersGenerator)localObject).init(PKCS12ParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar), paramPKCS12PBEParams.getIV(), paramPKCS12PBEParams.getIterations().intValue());
    localObject = (KeyParameter)((PKCS12ParametersGenerator)localObject).generateDerivedMacParameters(paramExtendedDigest.getDigestSize() * 8);
    paramExtendedDigest = new HMac(paramExtendedDigest);
    paramExtendedDigest.init((CipherParameters)localObject);
    new MacCalculator()
    {
      public AlgorithmIdentifier getAlgorithmIdentifier()
      {
        return new AlgorithmIdentifier(this.val$digestAlgorithm, paramPKCS12PBEParams);
      }
      
      public GenericKey getKey()
      {
        return new GenericKey(getAlgorithmIdentifier(), PKCS12ParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar));
      }
      
      public byte[] getMac()
      {
        byte[] arrayOfByte = new byte[paramExtendedDigest.getMacSize()];
        paramExtendedDigest.doFinal(arrayOfByte, 0);
        return arrayOfByte;
      }
      
      public OutputStream getOutputStream()
      {
        return new MacOutputStream(paramExtendedDigest);
      }
    };
  }
  
  static PaddedBufferedBlockCipher getEngine(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if ((!paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC)) && (!paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC)))
    {
      if ((!paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC)) && (!paramASN1ObjectIdentifier.equals(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC))) {
        throw new IllegalStateException("unknown algorithm");
      }
      paramASN1ObjectIdentifier = new RC2Engine();
    }
    else
    {
      paramASN1ObjectIdentifier = new DESedeEngine();
    }
    return new PaddedBufferedBlockCipher(new CBCBlockCipher(paramASN1ObjectIdentifier), new PKCS7Padding());
  }
  
  static int getKeySize(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return ((Integer)keySizes.get(paramASN1ObjectIdentifier)).intValue();
  }
  
  static boolean hasNoIv(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return noIvAlgs.contains(paramASN1ObjectIdentifier);
  }
  
  static boolean isDesAlg(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return desAlgs.contains(paramASN1ObjectIdentifier);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\bc\PKCS12PBEUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */