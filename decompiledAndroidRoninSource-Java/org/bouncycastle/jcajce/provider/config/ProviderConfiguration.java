package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;

public abstract interface ProviderConfiguration
{
  public abstract Set getAcceptableNamedCurves();
  
  public abstract Map getAdditionalECParameters();
  
  public abstract DHParameterSpec getDHDefaultParameters(int paramInt);
  
  public abstract ECParameterSpec getEcImplicitlyCa();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\config\ProviderConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */