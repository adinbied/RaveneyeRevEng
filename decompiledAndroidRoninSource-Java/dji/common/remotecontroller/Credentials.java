package dji.common.remotecontroller;

public class Credentials
{
  private int ID;
  private String name;
  private String password;
  
  public Credentials(int paramInt, String paramString1, String paramString2)
  {
    this.ID = paramInt;
    this.name = paramString1;
    this.password = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getID()
  {
    return this.ID;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public int hashCode()
  {
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\remotecontroller\Credentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */