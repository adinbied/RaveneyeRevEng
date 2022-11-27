package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import org.bouncycastle.crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.crypto.agreement.ECMQVBasicAgreement;
import org.bouncycastle.crypto.agreement.kdf.ConcatenationKDFGenerator;
import org.bouncycastle.crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.MQVParameterSpec;
import org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;
import org.bouncycastle.jce.interfaces.MQVPublicKey;

public class KeyAgreementSpi
  extends BaseAgreementSpi
{
  private static final X9IntegerConverter converter = new X9IntegerConverter();
  private BasicAgreement agreement;
  private String kaAlgorithm;
  private MQVParameterSpec mqvParameters;
  private ECDomainParameters parameters;
  private BigInteger result;
  
  protected KeyAgreementSpi(String paramString, BasicAgreement paramBasicAgreement, DerivationFunction paramDerivationFunction)
  {
    super(paramString, paramDerivationFunction);
    this.kaAlgorithm = paramString;
    this.agreement = paramBasicAgreement;
  }
  
  private static String getSimpleName(Class paramClass)
  {
    paramClass = paramClass.getName();
    return paramClass.substring(paramClass.lastIndexOf('.') + 1);
  }
  
  private void initFromKey(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidKeyException
  {
    boolean bool = this.agreement instanceof ECMQVBasicAgreement;
    Object localObject2 = null;
    Object localObject1 = null;
    ECPrivateKeyParameters localECPrivateKeyParameters1 = null;
    if (bool)
    {
      this.mqvParameters = null;
      bool = paramKey instanceof MQVPrivateKey;
      if ((!bool) && (!(paramAlgorithmParameterSpec instanceof MQVParameterSpec)))
      {
        paramKey = new StringBuilder();
        paramKey.append(this.kaAlgorithm);
        paramKey.append(" key agreement requires ");
        paramKey.append(getSimpleName(MQVParameterSpec.class));
        paramKey.append(" for initialisation");
        throw new InvalidKeyException(paramKey.toString());
      }
      if (bool)
      {
        MQVPrivateKey localMQVPrivateKey = (MQVPrivateKey)paramKey;
        localECPrivateKeyParameters1 = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter(localMQVPrivateKey.getStaticPrivateKey());
        ECPrivateKeyParameters localECPrivateKeyParameters2 = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter(localMQVPrivateKey.getEphemeralPrivateKey());
        localObject1 = localECPrivateKeyParameters2;
        paramKey = (Key)localObject2;
        paramAlgorithmParameterSpec = localECPrivateKeyParameters1;
        if (localMQVPrivateKey.getEphemeralPublicKey() != null)
        {
          paramKey = (ECPublicKeyParameters)ECUtils.generatePublicKeyParameter(localMQVPrivateKey.getEphemeralPublicKey());
          localObject1 = localECPrivateKeyParameters2;
          paramAlgorithmParameterSpec = localECPrivateKeyParameters1;
        }
      }
      else
      {
        localObject2 = (MQVParameterSpec)paramAlgorithmParameterSpec;
        paramAlgorithmParameterSpec = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter((PrivateKey)paramKey);
        localObject1 = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter(((MQVParameterSpec)localObject2).getEphemeralPrivateKey());
        paramKey = localECPrivateKeyParameters1;
        if (((MQVParameterSpec)localObject2).getEphemeralPublicKey() != null) {
          paramKey = (ECPublicKeyParameters)ECUtils.generatePublicKeyParameter(((MQVParameterSpec)localObject2).getEphemeralPublicKey());
        }
        this.mqvParameters = ((MQVParameterSpec)localObject2);
        this.ukmParameters = ((MQVParameterSpec)localObject2).getUserKeyingMaterial();
      }
      paramKey = new MQVPrivateParameters(paramAlgorithmParameterSpec, (ECPrivateKeyParameters)localObject1, paramKey);
      this.parameters = paramAlgorithmParameterSpec.getParameters();
    }
    else
    {
      if (!(paramKey instanceof PrivateKey)) {
        break label338;
      }
      localObject2 = (ECPrivateKeyParameters)ECUtil.generatePrivateKeyParameter((PrivateKey)paramKey);
      this.parameters = ((ECPrivateKeyParameters)localObject2).getParameters();
      paramKey = (Key)localObject1;
      if ((paramAlgorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
        paramKey = ((UserKeyingMaterialSpec)paramAlgorithmParameterSpec).getUserKeyingMaterial();
      }
      this.ukmParameters = paramKey;
      paramKey = (Key)localObject2;
    }
    this.agreement.init(paramKey);
    return;
    label338:
    paramKey = new StringBuilder();
    paramKey.append(this.kaAlgorithm);
    paramKey.append(" key agreement requires ");
    paramKey.append(getSimpleName(ECPrivateKey.class));
    paramKey.append(" for initialisation");
    throw new InvalidKeyException(paramKey.toString());
  }
  
  protected byte[] bigIntToBytes(BigInteger paramBigInteger)
  {
    X9IntegerConverter localX9IntegerConverter = converter;
    return localX9IntegerConverter.integerToBytes(paramBigInteger, localX9IntegerConverter.getByteLength(this.parameters.getCurve()));
  }
  
  protected byte[] calcSecret()
  {
    return bigIntToBytes(this.result);
  }
  
  protected Key engineDoPhase(final Key paramKey, boolean paramBoolean)
    throws InvalidKeyException, IllegalStateException
  {
    if (this.parameters != null)
    {
      if (paramBoolean)
      {
        if ((this.agreement instanceof ECMQVBasicAgreement))
        {
          if (!(paramKey instanceof MQVPublicKey))
          {
            paramKey = new MQVPublicParameters((ECPublicKeyParameters)ECUtils.generatePublicKeyParameter((PublicKey)paramKey), (ECPublicKeyParameters)ECUtils.generatePublicKeyParameter(this.mqvParameters.getOtherPartyEphemeralKey()));
          }
          else
          {
            paramKey = (MQVPublicKey)paramKey;
            paramKey = new MQVPublicParameters((ECPublicKeyParameters)ECUtils.generatePublicKeyParameter(paramKey.getStaticKey()), (ECPublicKeyParameters)ECUtils.generatePublicKeyParameter(paramKey.getEphemeralKey()));
          }
        }
        else
        {
          if (!(paramKey instanceof PublicKey)) {
            break label173;
          }
          paramKey = ECUtils.generatePublicKeyParameter((PublicKey)paramKey);
        }
        try
        {
          this.result = this.agreement.calculateAgreement(paramKey);
          return null;
        }
        catch (Exception paramKey)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("calculation failed: ");
          localStringBuilder.append(paramKey.getMessage());
          throw new InvalidKeyException(localStringBuilder.toString())
          {
            public Throwable getCause()
            {
              return paramKey;
            }
          };
        }
        label173:
        paramKey = new StringBuilder();
        paramKey.append(this.kaAlgorithm);
        paramKey.append(" key agreement requires ");
        paramKey.append(getSimpleName(ECPublicKey.class));
        paramKey.append(" for doPhase");
        throw new InvalidKeyException(paramKey.toString());
      }
      paramKey = new StringBuilder();
      paramKey.append(this.kaAlgorithm);
      paramKey.append(" can only be between two parties.");
      throw new IllegalStateException(paramKey.toString());
    }
    paramKey = new StringBuilder();
    paramKey.append(this.kaAlgorithm);
    paramKey.append(" not initialised.");
    throw new IllegalStateException(paramKey.toString());
  }
  
  protected void engineInit(Key paramKey, SecureRandom paramSecureRandom)
    throws InvalidKeyException
  {
    initFromKey(paramKey, null);
  }
  
  protected void engineInit(Key paramKey, AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidKeyException, InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec != null) && (!(paramAlgorithmParameterSpec instanceof MQVParameterSpec)) && (!(paramAlgorithmParameterSpec instanceof UserKeyingMaterialSpec))) {
      throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }
    initFromKey(paramKey, paramAlgorithmParameterSpec);
  }
  
  public static class CDHwithSHA1KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public CDHwithSHA1KDFAndSharedInfo()
    {
      super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class CDHwithSHA224KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public CDHwithSHA224KDFAndSharedInfo()
    {
      super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
    }
  }
  
  public static class CDHwithSHA256KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public CDHwithSHA256KDFAndSharedInfo()
    {
      super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
    }
  }
  
  public static class CDHwithSHA384KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public CDHwithSHA384KDFAndSharedInfo()
    {
      super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
    }
  }
  
  public static class CDHwithSHA512KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public CDHwithSHA512KDFAndSharedInfo()
    {
      super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
    }
  }
  
  public static class DH
    extends KeyAgreementSpi
  {
    public DH()
    {
      super(new ECDHBasicAgreement(), null);
    }
  }
  
  public static class DHC
    extends KeyAgreementSpi
  {
    public DHC()
    {
      super(new ECDHCBasicAgreement(), null);
    }
  }
  
  public static class DHwithSHA1CKDF
    extends KeyAgreementSpi
  {
    public DHwithSHA1CKDF()
    {
      super(new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class DHwithSHA1KDF
    extends KeyAgreementSpi
  {
    public DHwithSHA1KDF()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class DHwithSHA1KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public DHwithSHA1KDFAndSharedInfo()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class DHwithSHA224KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public DHwithSHA224KDFAndSharedInfo()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
    }
  }
  
  public static class DHwithSHA256CKDF
    extends KeyAgreementSpi
  {
    public DHwithSHA256CKDF()
    {
      super(new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
    }
  }
  
  public static class DHwithSHA256KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public DHwithSHA256KDFAndSharedInfo()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
    }
  }
  
  public static class DHwithSHA384CKDF
    extends KeyAgreementSpi
  {
    public DHwithSHA384CKDF()
    {
      super(new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
    }
  }
  
  public static class DHwithSHA384KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public DHwithSHA384KDFAndSharedInfo()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
    }
  }
  
  public static class DHwithSHA512CKDF
    extends KeyAgreementSpi
  {
    public DHwithSHA512CKDF()
    {
      super(new ECDHCBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
    }
  }
  
  public static class DHwithSHA512KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public DHwithSHA512KDFAndSharedInfo()
    {
      super(new ECDHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
    }
  }
  
  public static class MQV
    extends KeyAgreementSpi
  {
    public MQV()
    {
      super(new ECMQVBasicAgreement(), null);
    }
  }
  
  public static class MQVwithSHA1CKDF
    extends KeyAgreementSpi
  {
    public MQVwithSHA1CKDF()
    {
      super(new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class MQVwithSHA1KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public MQVwithSHA1KDFAndSharedInfo()
    {
      super(new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()));
    }
  }
  
  public static class MQVwithSHA224CKDF
    extends KeyAgreementSpi
  {
    public MQVwithSHA224CKDF()
    {
      super(new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA224()));
    }
  }
  
  public static class MQVwithSHA224KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public MQVwithSHA224KDFAndSharedInfo()
    {
      super(new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA224()));
    }
  }
  
  public static class MQVwithSHA256CKDF
    extends KeyAgreementSpi
  {
    public MQVwithSHA256CKDF()
    {
      super(new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
    }
  }
  
  public static class MQVwithSHA256KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public MQVwithSHA256KDFAndSharedInfo()
    {
      super(new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA256()));
    }
  }
  
  public static class MQVwithSHA384CKDF
    extends KeyAgreementSpi
  {
    public MQVwithSHA384CKDF()
    {
      super(new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
    }
  }
  
  public static class MQVwithSHA384KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public MQVwithSHA384KDFAndSharedInfo()
    {
      super(new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA384()));
    }
  }
  
  public static class MQVwithSHA512CKDF
    extends KeyAgreementSpi
  {
    public MQVwithSHA512CKDF()
    {
      super(new ECMQVBasicAgreement(), new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
    }
  }
  
  public static class MQVwithSHA512KDFAndSharedInfo
    extends KeyAgreementSpi
  {
    public MQVwithSHA512KDFAndSharedInfo()
    {
      super(new ECMQVBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA512()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\KeyAgreementSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */