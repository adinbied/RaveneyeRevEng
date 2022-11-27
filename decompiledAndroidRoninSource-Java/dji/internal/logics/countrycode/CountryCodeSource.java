package dji.internal.logics.countrycode;

public enum CountryCodeSource
{
  private int priorityValue;
  
  static
  {
    IP = new CountryCodeSource("IP", 2, 1);
    CountryCodeSource localCountryCodeSource = new CountryCodeSource("UNDEFINED", 3, -1);
    UNDEFINED = localCountryCodeSource;
    $VALUES = new CountryCodeSource[] { GPS, MCC, IP, localCountryCodeSource };
  }
  
  private CountryCodeSource(int paramInt)
  {
    this.priorityValue = paramInt;
  }
  
  public int getPriority()
  {
    return this.priorityValue;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\CountryCodeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */