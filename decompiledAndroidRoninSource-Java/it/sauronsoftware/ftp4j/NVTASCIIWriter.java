package it.sauronsoftware.ftp4j;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

class NVTASCIIWriter
  extends Writer
{
  private static final String LINE_SEPARATOR = "\r\n";
  private OutputStream stream;
  private Writer writer;
  
  public NVTASCIIWriter(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    this.stream = paramOutputStream;
    this.writer = new OutputStreamWriter(paramOutputStream, paramString);
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
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void write(char[] arg1, int arg2, int arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void writeLine(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\NVTASCIIWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */