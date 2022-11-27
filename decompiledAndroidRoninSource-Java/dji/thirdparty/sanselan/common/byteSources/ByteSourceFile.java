package dji.thirdparty.sanselan.common.byteSources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ByteSourceFile
  extends ByteSource
{
  private final File file;
  
  public ByteSourceFile(File paramFile)
  {
    super(paramFile.getName());
    this.file = paramFile;
  }
  
  public byte[] getAll()
    throws IOException
  {
    return null;
  }
  
  public byte[] getBlock(int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return null;
  }
  
  public long getLength()
  {
    return this.file.length();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\byteSources\ByteSourceFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */