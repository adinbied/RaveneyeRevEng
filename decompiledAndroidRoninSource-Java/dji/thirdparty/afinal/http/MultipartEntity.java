package dji.thirdparty.afinal.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

class MultipartEntity
  implements HttpEntity
{
  private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private String boundary = null;
  boolean isSetFirst;
  boolean isSetLast;
  ByteArrayOutputStream out = new ByteArrayOutputStream();
  
  public MultipartEntity()
  {
    int i = 0;
    this.isSetLast = false;
    this.isSetFirst = false;
    StringBuffer localStringBuffer = new StringBuffer();
    Random localRandom = new Random();
    while (i < 30)
    {
      char[] arrayOfChar = MULTIPART_CHARS;
      localStringBuffer.append(arrayOfChar[localRandom.nextInt(arrayOfChar.length)]);
      i += 1;
    }
    this.boundary = localStringBuffer.toString();
  }
  
  /* Error */
  public void addPart(String arg1, java.io.File arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addPart(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addPart(String arg1, String arg2, InputStream arg3, String arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addPart(String arg1, String arg2, InputStream arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addPart(String arg1, String arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void consumeContent()
    throws IOException, UnsupportedOperationException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public InputStream getContent()
    throws IOException, UnsupportedOperationException
  {
    return null;
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    return 277739076L;
  }
  
  public Header getContentType()
  {
    return null;
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  /* Error */
  public void writeFirstBoundaryIfNeeds()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void writeLastBoundaryIfNeeds()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void writeTo(java.io.OutputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\MultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */