package it.sauronsoftware.ftp4j.listparsers;

import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPListParseException;
import it.sauronsoftware.ftp4j.FTPListParser;
import java.io.PrintStream;

public class EPLFListParser
  implements FTPListParser
{
  public static void main(String[] paramArrayOfString)
    throws Throwable
  {
    paramArrayOfString = new EPLFListParser().parse(new String[] { "+i8388621.29609,m824255902,/,\tdev", "+i8388621.44468,m839956783,r,s10376,\tRFCEPLF" });
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      System.out.println(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  public FTPFile[] parse(String[] paramArrayOfString)
    throws FTPListParseException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\listparsers\EPLFListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */