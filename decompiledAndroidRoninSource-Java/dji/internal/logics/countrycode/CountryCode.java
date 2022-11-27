package dji.internal.logics.countrycode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CountryCode
  implements Serializable
{
  @SerializedName("contry_name")
  String contryName;
  @SerializedName("country_code")
  String country_code;
  
  public CountryCode(String paramString1, String paramString2)
  {
    this.country_code = paramString1;
    this.contryName = paramString2;
  }
  
  public String getContryName()
  {
    return this.contryName;
  }
  
  public String getCountry_code()
  {
    return this.country_code;
  }
  
  public void setContryName(String paramString)
  {
    this.contryName = paramString;
  }
  
  public void setCountry_code(String paramString)
  {
    this.country_code = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\CountryCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */