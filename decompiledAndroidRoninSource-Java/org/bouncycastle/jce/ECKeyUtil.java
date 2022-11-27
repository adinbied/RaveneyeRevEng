package org.bouncycastle.jce;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

public class ECKeyUtil
{
  public static PrivateKey privateToExplicitParameters(PrivateKey paramPrivateKey, String paramString)
    throws IllegalArgumentException, NoSuchAlgorithmException, NoSuchProviderException
  {
    Provider localProvider = Security.getProvider(paramString);
    if (localProvider != null) {
      return privateToExplicitParameters(paramPrivateKey, localProvider);
    }
    paramPrivateKey = new StringBuilder();
    paramPrivateKey.append("cannot find provider: ");
    paramPrivateKey.append(paramString);
    throw new NoSuchProviderException(paramPrivateKey.toString());
  }
  
  public static PrivateKey privateToExplicitParameters(PrivateKey paramPrivateKey, Provider paramProvider)
    throws IllegalArgumentException, NoSuchAlgorithmException
  {
    try
    {
      PrivateKeyInfo localPrivateKeyInfo = PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramPrivateKey.getEncoded()));
      if (!localPrivateKeyInfo.getAlgorithmId().getAlgorithm().equals(CryptoProObjectIdentifiers.gostR3410_2001))
      {
        Object localObject = X962Parameters.getInstance(localPrivateKeyInfo.getAlgorithmId().getParameters());
        if (((X962Parameters)localObject).isNamedCurve())
        {
          localObject = ECUtil.getNamedCurveByOid(ASN1ObjectIdentifier.getInstance(((X962Parameters)localObject).getParameters()));
          localObject = new X9ECParameters(((X9ECParameters)localObject).getCurve(), ((X9ECParameters)localObject).getG(), ((X9ECParameters)localObject).getN(), ((X9ECParameters)localObject).getH());
        }
        else
        {
          if (!((X962Parameters)localObject).isImplicitlyCA()) {
            return paramPrivateKey;
          }
          localObject = new X9ECParameters(BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getG(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getN(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getH());
        }
        localObject = new X962Parameters((X9ECParameters)localObject);
        localObject = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable)localObject), localPrivateKeyInfo.parsePrivateKey());
        return KeyFactory.getInstance(paramPrivateKey.getAlgorithm(), paramProvider).generatePrivate(new PKCS8EncodedKeySpec(((PrivateKeyInfo)localObject).getEncoded()));
      }
      else
      {
        throw new UnsupportedEncodingException("cannot convert GOST key to explicit parameters.");
      }
    }
    catch (Exception paramPrivateKey)
    {
      throw new UnexpectedException(paramPrivateKey);
    }
    catch (NoSuchAlgorithmException paramPrivateKey)
    {
      throw paramPrivateKey;
    }
    catch (IllegalArgumentException paramPrivateKey)
    {
      throw paramPrivateKey;
    }
    return paramPrivateKey;
  }
  
  public static PublicKey publicToExplicitParameters(PublicKey paramPublicKey, String paramString)
    throws IllegalArgumentException, NoSuchAlgorithmException, NoSuchProviderException
  {
    Provider localProvider = Security.getProvider(paramString);
    if (localProvider != null) {
      return publicToExplicitParameters(paramPublicKey, localProvider);
    }
    paramPublicKey = new StringBuilder();
    paramPublicKey.append("cannot find provider: ");
    paramPublicKey.append(paramString);
    throw new NoSuchProviderException(paramPublicKey.toString());
  }
  
  public static PublicKey publicToExplicitParameters(PublicKey paramPublicKey, Provider paramProvider)
    throws IllegalArgumentException, NoSuchAlgorithmException
  {
    try
    {
      SubjectPublicKeyInfo localSubjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(paramPublicKey.getEncoded()));
      if (!localSubjectPublicKeyInfo.getAlgorithmId().getAlgorithm().equals(CryptoProObjectIdentifiers.gostR3410_2001))
      {
        Object localObject = X962Parameters.getInstance(localSubjectPublicKeyInfo.getAlgorithmId().getParameters());
        if (((X962Parameters)localObject).isNamedCurve())
        {
          localObject = ECUtil.getNamedCurveByOid(ASN1ObjectIdentifier.getInstance(((X962Parameters)localObject).getParameters()));
          localObject = new X9ECParameters(((X9ECParameters)localObject).getCurve(), ((X9ECParameters)localObject).getG(), ((X9ECParameters)localObject).getN(), ((X9ECParameters)localObject).getH());
        }
        else
        {
          if (!((X962Parameters)localObject).isImplicitlyCA()) {
            return paramPublicKey;
          }
          localObject = new X9ECParameters(BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getCurve(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getG(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getN(), BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa().getH());
        }
        localObject = new X962Parameters((X9ECParameters)localObject);
        localObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, (ASN1Encodable)localObject), localSubjectPublicKeyInfo.getPublicKeyData().getBytes());
        return KeyFactory.getInstance(paramPublicKey.getAlgorithm(), paramProvider).generatePublic(new X509EncodedKeySpec(((SubjectPublicKeyInfo)localObject).getEncoded()));
      }
      else
      {
        throw new IllegalArgumentException("cannot convert GOST key to explicit parameters.");
      }
    }
    catch (Exception paramPublicKey)
    {
      throw new UnexpectedException(paramPublicKey);
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      throw paramPublicKey;
    }
    catch (IllegalArgumentException paramPublicKey)
    {
      throw paramPublicKey;
    }
    return paramPublicKey;
  }
  
  private static class UnexpectedException
    extends RuntimeException
  {
    private Throwable cause;
    
    UnexpectedException(Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\ECKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */