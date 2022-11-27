package org.bouncycastle.pqc.jcajce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.util.AlgorithmProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;

public class BouncyCastlePQCProvider
  extends Provider
  implements ConfigurableProvider
{
  private static final String[] ALGORITHMS = { "Rainbow", "McEliece", "SPHINCS", "NH" };
  private static final String ALGORITHM_PACKAGE = "org.bouncycastle.pqc.jcajce.provider.";
  public static final ProviderConfiguration CONFIGURATION;
  public static String PROVIDER_NAME = "BCPQC";
  private static String info = "BouncyCastle Post-Quantum Security Provider v1.57";
  private static final Map keyInfoConverters = new HashMap();
  
  public BouncyCastlePQCProvider()
  {
    super(PROVIDER_NAME, 1.57D, info);
    AccessController.doPrivileged(new PrivilegedAction()
    {
      public Object run()
      {
        BouncyCastlePQCProvider.this.setup();
        return null;
      }
    });
  }
  
  private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    synchronized (keyInfoConverters)
    {
      paramASN1ObjectIdentifier = (AsymmetricKeyInfoConverter)keyInfoConverters.get(paramASN1ObjectIdentifier);
      return paramASN1ObjectIdentifier;
    }
  }
  
  public static PrivateKey getPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws IOException
  {
    AsymmetricKeyInfoConverter localAsymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(paramPrivateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm());
    if (localAsymmetricKeyInfoConverter == null) {
      return null;
    }
    return localAsymmetricKeyInfoConverter.generatePrivate(paramPrivateKeyInfo);
  }
  
  public static PublicKey getPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws IOException
  {
    AsymmetricKeyInfoConverter localAsymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(paramSubjectPublicKeyInfo.getAlgorithm().getAlgorithm());
    if (localAsymmetricKeyInfoConverter == null) {
      return null;
    }
    return localAsymmetricKeyInfoConverter.generatePublic(paramSubjectPublicKeyInfo);
  }
  
  private void loadAlgorithms(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    while (i != paramArrayOfString.length)
    {
      Object localObject1 = null;
      try
      {
        localObject2 = getClass().getClassLoader();
        if (localObject2 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(paramArrayOfString[i]);
          localStringBuilder.append("$Mappings");
          localObject2 = ((ClassLoader)localObject2).loadClass(localStringBuilder.toString());
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(paramArrayOfString[i]);
          ((StringBuilder)localObject2).append("$Mappings");
          localObject2 = Class.forName(((StringBuilder)localObject2).toString());
          localObject1 = localObject2;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject2;
        for (;;) {}
      }
      if (localObject1 != null) {
        try
        {
          ((AlgorithmProvider)((Class)localObject1).newInstance()).configure(this);
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("cannot create instance of ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(paramArrayOfString[i]);
          ((StringBuilder)localObject2).append("$Mappings : ");
          ((StringBuilder)localObject2).append(localException);
          throw new InternalError(((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
  }
  
  private void setup()
  {
    loadAlgorithms("org.bouncycastle.pqc.jcajce.provider.", ALGORITHMS);
  }
  
  public void addAlgorithm(String paramString1, String paramString2)
  {
    if (!containsKey(paramString1))
    {
      put(paramString1, paramString2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("duplicate provider key (");
    paramString2.append(paramString1);
    paramString2.append(") found");
    throw new IllegalStateException(paramString2.toString());
  }
  
  public void addAlgorithm(String paramString1, ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramASN1ObjectIdentifier);
      addAlgorithm(localStringBuilder.toString(), paramString2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".OID.");
      localStringBuilder.append(paramASN1ObjectIdentifier);
      addAlgorithm(localStringBuilder.toString(), paramString2);
      return;
    }
    paramASN1ObjectIdentifier = new StringBuilder();
    paramASN1ObjectIdentifier.append("primary key (");
    paramASN1ObjectIdentifier.append(paramString1);
    paramASN1ObjectIdentifier.append(".");
    paramASN1ObjectIdentifier.append(paramString2);
    paramASN1ObjectIdentifier.append(") not found");
    throw new IllegalStateException(paramASN1ObjectIdentifier.toString());
  }
  
  public void addAttributes(String paramString, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      if (!containsKey(localObject))
      {
        put(localObject, paramMap.get(str));
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("duplicate provider attribute key (");
        paramString.append((String)localObject);
        paramString.append(") found");
        throw new IllegalStateException(paramString.toString());
      }
    }
  }
  
  public void addKeyInfoConverter(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AsymmetricKeyInfoConverter paramAsymmetricKeyInfoConverter)
  {
    synchronized (keyInfoConverters)
    {
      keyInfoConverters.put(paramASN1ObjectIdentifier, paramAsymmetricKeyInfoConverter);
      return;
    }
  }
  
  public boolean hasAlgorithm(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    if (!containsKey(localStringBuilder.toString()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Alg.Alias.");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (!containsKey(localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
  }
  
  public void setParameter(String arg1, Object paramObject)
  {
    synchronized (CONFIGURATION) {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\BouncyCastlePQCProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */