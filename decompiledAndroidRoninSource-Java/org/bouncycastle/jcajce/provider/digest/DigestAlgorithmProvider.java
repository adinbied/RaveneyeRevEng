package org.bouncycastle.jcajce.provider.digest;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

abstract class DigestAlgorithmProvider
  extends AlgorithmProvider
{
  protected void addHMACAlgorithm(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HMAC");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mac.");
    localStringBuilder.append((String)localObject);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Mac.HMAC-");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Mac.HMAC/");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject);
    paramString2 = new StringBuilder();
    paramString2.append("KeyGenerator.");
    paramString2.append((String)localObject);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.KeyGenerator.HMAC-");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.KeyGenerator.HMAC/");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), (String)localObject);
  }
  
  protected void addHMACAlias(ConfigurableProvider paramConfigurableProvider, String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HMAC");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.Mac.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Alg.Alias.KeyGenerator.");
    localStringBuilder.append(paramASN1ObjectIdentifier);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\digest\DigestAlgorithmProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */