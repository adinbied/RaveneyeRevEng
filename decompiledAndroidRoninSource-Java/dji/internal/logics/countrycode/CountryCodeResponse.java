package dji.internal.logics.countrycode;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CountryCodeResponse
  implements Serializable
{
  @SerializedName("extra_msg")
  private String extraMsg;
  private String msg;
  private CountryCode result;
  private int status;
  
  public CountryCode getCountryCode()
  {
    return this.result;
  }
  
  public String getExtraMsg()
  {
    return this.extraMsg;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public int getStatus()
  {
    return this.status;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\CountryCodeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */