package it.sauronsoftware.ftp4j.listparsers;

import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPListParseException;
import it.sauronsoftware.ftp4j.FTPListParser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class DOSListParser
  implements FTPListParser
{
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yy hh:mm a");
  private static final Pattern PATTERN = Pattern.compile("^(\\d{2})-(\\d{2})-(\\d{2})\\s+(\\d{2}):(\\d{2})(AM|PM)\\s+(<DIR>|\\d+)\\s+([^\\\\/*?\"<>|]+)$");
  
  public FTPFile[] parse(String[] paramArrayOfString)
    throws FTPListParseException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\listparsers\DOSListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */