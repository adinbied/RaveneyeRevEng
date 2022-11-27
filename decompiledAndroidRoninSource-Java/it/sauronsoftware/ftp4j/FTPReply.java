package it.sauronsoftware.ftp4j;

public class FTPReply
{
  private int code = 0;
  private String[] messages;
  
  FTPReply(int paramInt, String[] paramArrayOfString)
  {
    this.code = paramInt;
    this.messages = paramArrayOfString;
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String[] getMessages()
  {
    return this.messages;
  }
  
  public boolean isSuccessCode()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPReply.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */