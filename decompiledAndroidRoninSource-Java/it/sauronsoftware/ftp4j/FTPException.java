package it.sauronsoftware.ftp4j;

public class FTPException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  private int code;
  private String message;
  
  public FTPException(int paramInt)
  {
    this.code = paramInt;
  }
  
  public FTPException(int paramInt, String paramString)
  {
    this.code = paramInt;
    this.message = paramString;
  }
  
  public FTPException(FTPReply paramFTPReply)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String[] arrayOfString = paramFTPReply.getMessages();
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (i > 0) {
        localStringBuffer.append(System.getProperty("line.separator"));
      }
      localStringBuffer.append(arrayOfString[i]);
      i += 1;
    }
    this.code = paramFTPReply.getCode();
    this.message = localStringBuffer.toString();
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */