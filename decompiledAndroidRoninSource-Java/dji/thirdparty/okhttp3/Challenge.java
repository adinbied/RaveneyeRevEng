package dji.thirdparty.okhttp3;

public final class Challenge
{
  private final String realm;
  private final String scheme;
  
  public Challenge(String paramString1, String paramString2)
  {
    this.scheme = paramString1;
    this.realm = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String realm()
  {
    return this.realm;
  }
  
  public String scheme()
  {
    return this.scheme;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Challenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */