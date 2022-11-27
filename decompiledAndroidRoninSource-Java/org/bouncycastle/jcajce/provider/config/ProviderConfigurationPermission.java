package org.bouncycastle.jcajce.provider.config;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

public class ProviderConfigurationPermission
  extends BasicPermission
{
  private static final int ACCEPTABLE_EC_CURVES = 16;
  private static final String ACCEPTABLE_EC_CURVES_STR = "acceptableeccurves";
  private static final int ADDITIONAL_EC_PARAMETERS = 32;
  private static final String ADDITIONAL_EC_PARAMETERS_STR = "additionalecparameters";
  private static final int ALL = 63;
  private static final String ALL_STR = "all";
  private static final int DH_DEFAULT_PARAMS = 8;
  private static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
  private static final int EC_IMPLICITLY_CA = 2;
  private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
  private static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
  private static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
  private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
  private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
  private final String actions;
  private final int permissionMask;
  
  public ProviderConfigurationPermission(String paramString)
  {
    super(paramString);
    this.actions = "all";
    this.permissionMask = 63;
  }
  
  public ProviderConfigurationPermission(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.actions = paramString2;
    this.permissionMask = calculateMask(paramString2);
  }
  
  private int calculateMask(String paramString)
  {
    paramString = new StringTokenizer(Strings.toLowerCase(paramString), " ,");
    int i = 0;
    while (paramString.hasMoreTokens())
    {
      String str = paramString.nextToken();
      if (str.equals("threadlocalecimplicitlyca")) {
        i |= 0x1;
      } else if (str.equals("ecimplicitlyca")) {
        i |= 0x2;
      } else if (str.equals("threadlocaldhdefaultparams")) {
        i |= 0x4;
      } else if (str.equals("dhdefaultparams")) {
        i |= 0x8;
      } else if (str.equals("acceptableeccurves")) {
        i |= 0x10;
      } else if (str.equals("additionalecparameters")) {
        i |= 0x20;
      } else if (str.equals("all")) {
        i |= 0x3F;
      }
    }
    if (i != 0) {
      return i;
    }
    throw new IllegalArgumentException("unknown permissions passed to mask");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ProviderConfigurationPermission))
    {
      paramObject = (ProviderConfigurationPermission)paramObject;
      return (this.permissionMask == ((ProviderConfigurationPermission)paramObject).permissionMask) && (getName().equals(((ProviderConfigurationPermission)paramObject).getName()));
    }
    return false;
  }
  
  public String getActions()
  {
    return this.actions;
  }
  
  public int hashCode()
  {
    return getName().hashCode() + this.permissionMask;
  }
  
  public boolean implies(Permission paramPermission)
  {
    boolean bool2 = paramPermission instanceof ProviderConfigurationPermission;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (!getName().equals(paramPermission.getName())) {
      return false;
    }
    paramPermission = (ProviderConfigurationPermission)paramPermission;
    int i = this.permissionMask;
    int j = paramPermission.permissionMask;
    if ((i & j) == j) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\config\ProviderConfigurationPermission.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */