package it.sauronsoftware.ftp4j.listparsers;

import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPListParseException;
import it.sauronsoftware.ftp4j.FTPListParser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MLSDListParser
  implements FTPListParser
{
  private static final DateFormat MLSD_DATE_FORMAT_1 = new SimpleDateFormat("yyyyMMddhhmmss.SSS Z");
  private static final DateFormat MLSD_DATE_FORMAT_2 = new SimpleDateFormat("yyyyMMddhhmmss Z");
  
  private FTPFile parseLine(String paramString)
    throws FTPListParseException
  {
    return null;
  }
  
  public FTPFile[] parse(String[] paramArrayOfString)
    throws FTPListParseException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\listparsers\MLSDListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */