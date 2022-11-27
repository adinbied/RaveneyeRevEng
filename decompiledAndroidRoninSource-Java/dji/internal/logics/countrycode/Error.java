package dji.internal.logics.countrycode;

public enum Error
{
  private int errorCode;
  
  static
  {
    Error localError = new Error("PARAM_ERROR", 2, 101);
    PARAM_ERROR = localError;
    $VALUES = new Error[] { NO_ERROR, UNAVAILABLE, localError };
  }
  
  private Error(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public int getCode()
  {
    return this.errorCode;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\countrycode\Error.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */