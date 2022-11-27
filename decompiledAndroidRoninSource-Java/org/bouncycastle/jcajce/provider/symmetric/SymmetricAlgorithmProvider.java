package org.bouncycastle.jcajce.provider.symmetric;

import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

abstract class SymmetricAlgorithmProvider
  extends AlgorithmProvider
{
  protected void addCMacAlgorithm(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mac.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-CMAC");
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Mac.");
    paramString2.append(paramString1);
    paramString2.append("CMAC");
    paramString2 = paramString2.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-CMAC");
    paramConfigurableProvider.addAlgorithm(paramString2, localStringBuilder.toString());
    paramString2 = new StringBuilder();
    paramString2.append("KeyGenerator.");
    paramString2.append(paramString1);
    paramString2.append("-CMAC");
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.KeyGenerator.");
    paramString2.append(paramString1);
    paramString2.append("CMAC");
    paramString2 = paramString2.toString();
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("-CMAC");
    paramConfigurableProvider.addAlgorithm(paramString2, paramString3.toString());
  }
  
  protected void addGMacAlgorithm(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mac.");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-GMAC");
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Mac.");
    paramString2.append(paramString1);
    paramString2.append("GMAC");
    paramString2 = paramString2.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("-GMAC");
    paramConfigurableProvider.addAlgorithm(paramString2, localStringBuilder.toString());
    paramString2 = new StringBuilder();
    paramString2.append("KeyGenerator.");
    paramString2.append(paramString1);
    paramString2.append("-GMAC");
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.KeyGenerator.");
    paramString2.append(paramString1);
    paramString2.append("GMAC");
    paramString2 = paramString2.toString();
    paramString3 = new StringBuilder();
    paramString3.append(paramString1);
    paramString3.append("-GMAC");
    paramConfigurableProvider.addAlgorithm(paramString2, paramString3.toString());
  }
  
  protected void addPoly1305Algorithm(ConfigurableProvider paramConfigurableProvider, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Mac.POLY1305-");
    localStringBuilder.append(paramString1);
    paramConfigurableProvider.addAlgorithm(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.Mac.POLY1305");
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("POLY1305-");
    localStringBuilder.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2, localStringBuilder.toString());
    paramString2 = new StringBuilder();
    paramString2.append("KeyGenerator.POLY1305-");
    paramString2.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append("Alg.Alias.KeyGenerator.POLY1305");
    paramString2.append(paramString1);
    paramString2 = paramString2.toString();
    paramString3 = new StringBuilder();
    paramString3.append("POLY1305-");
    paramString3.append(paramString1);
    paramConfigurableProvider.addAlgorithm(paramString2, paramString3.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetric\SymmetricAlgorithmProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */