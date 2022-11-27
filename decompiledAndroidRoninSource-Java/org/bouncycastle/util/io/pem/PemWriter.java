package org.bouncycastle.util.io.pem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;

public class PemWriter
  extends BufferedWriter
{
  private static final int LINE_LENGTH = 64;
  private char[] buf = new char[64];
  private final int nlLength;
  
  public PemWriter(Writer paramWriter)
  {
    super(paramWriter);
    paramWriter = Strings.lineSeparator();
    int i;
    if (paramWriter != null) {
      i = paramWriter.length();
    } else {
      i = 2;
    }
    this.nlLength = i;
  }
  
  private void writeEncoded(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = Base64.encode(paramArrayOfByte);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = 0;
      for (;;)
      {
        char[] arrayOfChar = this.buf;
        if (j == arrayOfChar.length) {
          break;
        }
        int k = i + j;
        if (k >= paramArrayOfByte.length) {
          break;
        }
        arrayOfChar[j] = ((char)paramArrayOfByte[k]);
        j += 1;
      }
      write(this.buf, 0, j);
      newLine();
      i += this.buf.length;
    }
  }
  
  private void writePostEncapsulationBoundary(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----END ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    write(localStringBuilder.toString());
    newLine();
  }
  
  private void writePreEncapsulationBoundary(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----BEGIN ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    write(localStringBuilder.toString());
    newLine();
  }
  
  public int getOutputSize(PemObject paramPemObject)
  {
    int j = (paramPemObject.getType().length() + 10 + this.nlLength) * 2 + 6 + 4;
    int i = j;
    if (!paramPemObject.getHeaders().isEmpty())
    {
      Iterator localIterator = paramPemObject.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        PemHeader localPemHeader = (PemHeader)localIterator.next();
        j += localPemHeader.getName().length() + 2 + localPemHeader.getValue().length() + this.nlLength;
      }
      i = j + this.nlLength;
    }
    j = (paramPemObject.getContent().length + 2) / 3 * 4;
    return i + (j + (j + 64 - 1) / 64 * this.nlLength);
  }
  
  public void writeObject(PemObjectGenerator paramPemObjectGenerator)
    throws IOException
  {
    paramPemObjectGenerator = paramPemObjectGenerator.generate();
    writePreEncapsulationBoundary(paramPemObjectGenerator.getType());
    if (!paramPemObjectGenerator.getHeaders().isEmpty())
    {
      Iterator localIterator = paramPemObjectGenerator.getHeaders().iterator();
      while (localIterator.hasNext())
      {
        PemHeader localPemHeader = (PemHeader)localIterator.next();
        write(localPemHeader.getName());
        write(": ");
        write(localPemHeader.getValue());
        newLine();
      }
      newLine();
    }
    writeEncoded(paramPemObjectGenerator.getContent());
    writePostEncapsulationBoundary(paramPemObjectGenerator.getType());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\pem\PemWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */