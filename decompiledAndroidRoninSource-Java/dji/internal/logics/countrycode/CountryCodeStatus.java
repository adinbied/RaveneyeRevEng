package dji.internal.logics.countrycode;

public enum CountryCodeStatus
{
  static
  {
    CountryCodeStatus localCountryCodeStatus = new CountryCodeStatus("DONE", 2);
    DONE = localCountryCodeStatus;
    $VALUES = new CountryCodeStatus[] { INIT, VERIFIED, localCountryCodeStatus };
  }
  
  private CountryCodeStatus() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\CountryCodeStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */