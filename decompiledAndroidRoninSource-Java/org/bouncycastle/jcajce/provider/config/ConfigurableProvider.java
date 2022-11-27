package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public abstract interface ConfigurableProvider
{
  public static final String ACCEPTABLE_EC_CURVES = "acceptableEcCurves";
  public static final String ADDITIONAL_EC_PARAMETERS = "additionalEcParameters";
  public static final String DH_DEFAULT_PARAMS = "DhDefaultParams";
  public static final String EC_IMPLICITLY_CA = "ecImplicitlyCa";
  public static final String THREAD_LOCAL_DH_DEFAULT_PARAMS = "threadLocalDhDefaultParams";
  public static final String THREAD_LOCAL_EC_IMPLICITLY_CA = "threadLocalEcImplicitlyCa";
  
  public abstract void addAlgorithm(String paramString1, String paramString2);
  
  public abstract void addAlgorithm(String paramString1, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString2);
  
  public abstract void addAttributes(String paramString, Map<String, String> paramMap);
  
  public abstract void addKeyInfoConverter(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AsymmetricKeyInfoConverter paramAsymmetricKeyInfoConverter);
  
  public abstract boolean hasAlgorithm(String paramString1, String paramString2);
  
  public abstract void setParameter(String paramString, Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\config\ConfigurableProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */