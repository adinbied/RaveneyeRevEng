package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.x9.ECNamedCurveTable;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;

public class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  private String curveName;
  private java.security.spec.ECParameterSpec ecParameterSpec;
  
  protected byte[] engineGetEncoded()
    throws IOException
  {
    return engineGetEncoded("ASN.1");
  }
  
  protected byte[] engineGetEncoded(String paramString)
    throws IOException
  {
    if (isASN1FormatString(paramString))
    {
      paramString = this.ecParameterSpec;
      if (paramString == null)
      {
        paramString = new X962Parameters(DERNull.INSTANCE);
      }
      else
      {
        localObject = this.curveName;
        if (localObject != null)
        {
          paramString = new X962Parameters(ECUtil.getNamedCurveOid((String)localObject));
        }
        else
        {
          paramString = EC5Util.convertSpec(paramString, false);
          paramString = new X962Parameters(new X9ECParameters(paramString.getCurve(), paramString.getG(), paramString.getN(), paramString.getH(), paramString.getSeed()));
        }
      }
      return paramString.getEncoded();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown parameters format in AlgorithmParameters object: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> paramClass)
    throws InvalidParameterSpecException
  {
    if ((!java.security.spec.ECParameterSpec.class.isAssignableFrom(paramClass)) && (paramClass != AlgorithmParameterSpec.class))
    {
      if (ECGenParameterSpec.class.isAssignableFrom(paramClass))
      {
        localObject = this.curveName;
        if (localObject != null)
        {
          paramClass = ECUtil.getNamedCurveOid((String)localObject);
          if (paramClass != null) {
            return new ECGenParameterSpec(paramClass.getId());
          }
          return new ECGenParameterSpec(this.curveName);
        }
        localObject = ECUtil.getNamedCurveOid(EC5Util.convertSpec(this.ecParameterSpec, false));
        if (localObject != null) {
          return new ECGenParameterSpec(((ASN1ObjectIdentifier)localObject).getId());
        }
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EC AlgorithmParameters cannot convert to ");
      ((StringBuilder)localObject).append(paramClass.getName());
      throw new InvalidParameterSpecException(((StringBuilder)localObject).toString());
    }
    return this.ecParameterSpec;
  }
  
  protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidParameterSpecException
  {
    if ((paramAlgorithmParameterSpec instanceof ECGenParameterSpec))
    {
      paramAlgorithmParameterSpec = (ECGenParameterSpec)paramAlgorithmParameterSpec;
      localObject = ECUtils.getDomainParametersFromGenSpec(paramAlgorithmParameterSpec);
      if (localObject != null) {
        this.curveName = paramAlgorithmParameterSpec.getName();
      }
    }
    for (paramAlgorithmParameterSpec = EC5Util.convertToSpec((X9ECParameters)localObject);; paramAlgorithmParameterSpec = (java.security.spec.ECParameterSpec)paramAlgorithmParameterSpec)
    {
      this.ecParameterSpec = paramAlgorithmParameterSpec;
      return;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EC curve name not recognized: ");
      ((StringBuilder)localObject).append(paramAlgorithmParameterSpec.getName());
      throw new InvalidParameterSpecException(((StringBuilder)localObject).toString());
      if (!(paramAlgorithmParameterSpec instanceof java.security.spec.ECParameterSpec)) {
        break;
      }
      if ((paramAlgorithmParameterSpec instanceof ECNamedCurveSpec)) {
        localObject = ((ECNamedCurveSpec)paramAlgorithmParameterSpec).getName();
      } else {
        localObject = null;
      }
      this.curveName = ((String)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AlgorithmParameterSpec class not recognized: ");
    ((StringBuilder)localObject).append(paramAlgorithmParameterSpec.getClass().getName());
    throw new InvalidParameterSpecException(((StringBuilder)localObject).toString());
  }
  
  protected void engineInit(byte[] paramArrayOfByte)
    throws IOException
  {
    engineInit(paramArrayOfByte, "ASN.1");
  }
  
  protected void engineInit(byte[] paramArrayOfByte, String paramString)
    throws IOException
  {
    if (isASN1FormatString(paramString))
    {
      paramArrayOfByte = X962Parameters.getInstance(paramArrayOfByte);
      paramString = EC5Util.getCurve(BouncyCastleProvider.CONFIGURATION, paramArrayOfByte);
      if (paramArrayOfByte.isNamedCurve())
      {
        ASN1ObjectIdentifier localASN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(paramArrayOfByte.getParameters());
        String str = ECNamedCurveTable.getName(localASN1ObjectIdentifier);
        this.curveName = str;
        if (str == null) {
          this.curveName = localASN1ObjectIdentifier.getId();
        }
      }
      this.ecParameterSpec = EC5Util.convertToSpec(paramArrayOfByte, paramString);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("Unknown encoded parameters format in AlgorithmParameters object: ");
    paramArrayOfByte.append(paramString);
    throw new IOException(paramArrayOfByte.toString());
  }
  
  protected String engineToString()
  {
    return "EC AlgorithmParameters ";
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */