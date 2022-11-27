package org.bouncycastle.jcajce.provider.util;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

public abstract class AsymmetricAlgorithmProvider
  extends AlgorithmProvider
{
  protected void addSignatureAlgorithm(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("WITH");
    ((StringBuilder)localObject1).append(paramString2);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("with");
    ((StringBuilder)localObject2).append(paramString2);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramString1);
    ((StringBuilder)localObject3).append("With");
    ((StringBuilder)localObject3).append(paramString2);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = new StringBuilder();
    paramString2.append("Signature.");
    paramString2.append((String)localObject1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Signature.");
    paramString2.append((String)localObject2);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Signature.");
    paramString2.append((String)localObject3);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Signature.");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject1);
    paramString1 = new StringBuilder();
    paramString1.append("Alg.Alias.Signature.");
    paramString1.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(paramString1.toString(), (String)localObject1);
    paramString1 = new StringBuilder();
    paramString1.append("Alg.Alias.Signature.OID.");
    paramString1.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(paramString1.toString(), (String)localObject1);
  }
  
  protected void registerOid(ConfigurableProvider paramConfigurableProvider, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString, AsymmetricKeyInfoConverter paramAsymmetricKeyInfoConverter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.KeyFactory.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.KeyPairGenerator.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
    paramConfigurableProvider.addKeyInfoConverter(paramASN1ObjectIdentifier, paramAsymmetricKeyInfoConverter);
  }
  
  protected void registerOidAlgorithmParameterGenerator(ConfigurableProvider paramConfigurableProvider, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.AlgorithmParameterGenerator.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.AlgorithmParameters.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
  }
  
  protected void registerOidAlgorithmParameters(ConfigurableProvider paramConfigurableProvider, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.AlgorithmParameters.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provide\\util\AsymmetricAlgorithmProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */