package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class NVTASCIIReader
  extends Reader
{
  private static final String SYSTEM_LINE_SEPARATOR = System.getProperty("line.separator");
  private Reader reader;
  private InputStream stream;
  
  public NVTASCIIReader(InputStream paramInputStream, String paramString)
    throws IOException
  {
    this.stream = paramInputStream;
    this.reader = new InputStreamReader(paramInputStream, paramString);
  }
  
  /* Error */
  public void changeCharset(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    return 0;
  }
  
  public String readLine()
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\NVTASCIIReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */