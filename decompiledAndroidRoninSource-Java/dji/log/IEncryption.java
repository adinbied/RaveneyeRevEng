package dji.log;

public abstract interface IEncryption
{
  public abstract String decrypt(String paramString)
    throws Exception;
  
  public abstract String encrypt(String paramString)
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\IEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */