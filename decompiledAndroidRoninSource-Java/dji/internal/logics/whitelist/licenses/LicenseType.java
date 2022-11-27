package dji.internal.logics.whitelist.licenses;

public enum LicenseType
{
  private Class<? extends WhiteListLicense> mMatchClass;
  private int value;
  
  static
  {
    CIRCLE_UNLOCK_AREA = new LicenseType("CIRCLE_UNLOCK_AREA", 1, 1, CircleUnlockAreaLicense.class);
    COUNTRY_UNLOCK = new LicenseType("COUNTRY_UNLOCK", 2, 2, CountryUnlockLicense.class);
    PARAMETER_CONFIGURATION = new LicenseType("PARAMETER_CONFIGURATION", 3, 3, ParameterConfigurationLicense.class);
    PENTAGON_UNLOCK_AREA = new LicenseType("PENTAGON_UNLOCK_AREA", 4, 4, PentagonUnlockAreaLicense.class);
    LicenseType localLicenseType = new LicenseType("UNKNOWN", 5, 255);
    UNKNOWN = localLicenseType;
    $VALUES = new LicenseType[] { GEO_UNLOCK, CIRCLE_UNLOCK_AREA, COUNTRY_UNLOCK, PARAMETER_CONFIGURATION, PENTAGON_UNLOCK_AREA, localLicenseType };
  }
  
  private LicenseType(int paramInt)
  {
    this.value = paramInt;
  }
  
  private LicenseType(int paramInt, Class<? extends WhiteListLicense> paramClass)
  {
    this.value = paramInt;
    this.mMatchClass = paramClass;
  }
  
  public static LicenseType find(int paramInt)
  {
    LicenseType localLicenseType = UNKNOWN;
    int i = 0;
    while (i < values().length)
    {
      if (values()[i]._equals(paramInt)) {
        return values()[i];
      }
      i += 1;
    }
    return localLicenseType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.value == paramInt;
  }
  
  public Class<? extends WhiteListLicense> getMatchClass()
  {
    return this.mMatchClass;
  }
  
  public int value()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\whitelist\licenses\LicenseType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */