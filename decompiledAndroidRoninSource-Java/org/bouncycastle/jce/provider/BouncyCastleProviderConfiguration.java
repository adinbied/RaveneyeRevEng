package org.bouncycastle.jce.provider;

import java.math.BigInteger;
import java.security.Permission;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;

class BouncyCastleProviderConfiguration
  implements ProviderConfiguration
{
  private static Permission BC_ADDITIONAL_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", "additionalEcParameters");
  private static Permission BC_DH_LOCAL_PERMISSION;
  private static Permission BC_DH_PERMISSION;
  private static Permission BC_EC_CURVE_PERMISSION;
  private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", "threadLocalEcImplicitlyCa");
  private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission("BC", "ecImplicitlyCa");
  private volatile Set acceptableNamedCurves = new HashSet();
  private volatile Map additionalECParameters = new HashMap();
  private volatile Object dhDefaultParams;
  private ThreadLocal dhThreadSpec = new ThreadLocal();
  private volatile org.bouncycastle.jce.spec.ECParameterSpec ecImplicitCaParams;
  private ThreadLocal ecThreadSpec = new ThreadLocal();
  
  static
  {
    BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission("BC", "threadLocalDhDefaultParams");
    BC_DH_PERMISSION = new ProviderConfigurationPermission("BC", "DhDefaultParams");
    BC_EC_CURVE_PERMISSION = new ProviderConfigurationPermission("BC", "acceptableEcCurves");
  }
  
  public Set getAcceptableNamedCurves()
  {
    return Collections.unmodifiableSet(this.acceptableNamedCurves);
  }
  
  public Map getAdditionalECParameters()
  {
    return Collections.unmodifiableMap(this.additionalECParameters);
  }
  
  public DHParameterSpec getDHDefaultParameters(int paramInt)
  {
    Object localObject2 = this.dhThreadSpec.get();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.dhDefaultParams;
    }
    if ((localObject1 instanceof DHParameterSpec))
    {
      localObject1 = (DHParameterSpec)localObject1;
      if (((DHParameterSpec)localObject1).getP().bitLength() == paramInt) {
        return (DHParameterSpec)localObject1;
      }
    }
    else if ((localObject1 instanceof DHParameterSpec[]))
    {
      localObject1 = (DHParameterSpec[])localObject1;
      int i = 0;
      while (i != localObject1.length)
      {
        if (localObject1[i].getP().bitLength() == paramInt) {
          return localObject1[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public org.bouncycastle.jce.spec.ECParameterSpec getEcImplicitlyCa()
  {
    org.bouncycastle.jce.spec.ECParameterSpec localECParameterSpec = (org.bouncycastle.jce.spec.ECParameterSpec)this.ecThreadSpec.get();
    if (localECParameterSpec != null) {
      return localECParameterSpec;
    }
    return this.ecImplicitCaParams;
  }
  
  void setParameter(String paramString, Object paramObject)
  {
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (paramString.equals("threadLocalEcImplicitlyCa"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
      }
      if ((!(paramObject instanceof org.bouncycastle.jce.spec.ECParameterSpec)) && (paramObject != null)) {
        paramString = EC5Util.convertSpec((java.security.spec.ECParameterSpec)paramObject, false);
      } else {
        paramString = (org.bouncycastle.jce.spec.ECParameterSpec)paramObject;
      }
      if (paramString == null) {
        paramString = this.ecThreadSpec;
      }
    }
    do
    {
      paramString.remove();
      return;
      this.ecThreadSpec.set(paramString);
      return;
      if (paramString.equals("ecImplicitlyCa"))
      {
        if (localSecurityManager != null) {
          localSecurityManager.checkPermission(BC_EC_PERMISSION);
        }
        if ((!(paramObject instanceof org.bouncycastle.jce.spec.ECParameterSpec)) && (paramObject != null))
        {
          this.ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec)paramObject, false);
          return;
        }
        this.ecImplicitCaParams = ((org.bouncycastle.jce.spec.ECParameterSpec)paramObject);
        return;
      }
      if (!paramString.equals("threadLocalDhDefaultParams")) {
        break;
      }
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(BC_DH_LOCAL_PERMISSION);
      }
      if ((!(paramObject instanceof DHParameterSpec)) && (!(paramObject instanceof DHParameterSpec[])) && (paramObject != null)) {
        throw new IllegalArgumentException("not a valid DHParameterSpec");
      }
      paramString = this.dhThreadSpec;
    } while (paramObject == null);
    paramString.set(paramObject);
    return;
    if (paramString.equals("DhDefaultParams"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(BC_DH_PERMISSION);
      }
      if ((!(paramObject instanceof DHParameterSpec)) && (!(paramObject instanceof DHParameterSpec[])) && (paramObject != null)) {
        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
      }
      this.dhDefaultParams = paramObject;
      return;
    }
    if (paramString.equals("acceptableEcCurves"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(BC_EC_CURVE_PERMISSION);
      }
      this.acceptableNamedCurves = ((Set)paramObject);
      return;
    }
    if (paramString.equals("additionalEcParameters"))
    {
      if (localSecurityManager != null) {
        localSecurityManager.checkPermission(BC_ADDITIONAL_EC_CURVE_PERMISSION);
      }
      this.additionalECParameters = ((Map)paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\BouncyCastleProviderConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */