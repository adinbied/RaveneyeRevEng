package it.sauronsoftware.ftp4j;

public abstract interface FTPListParser
{
  public abstract FTPFile[] parse(String[] paramArrayOfString)
    throws FTPListParseException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */