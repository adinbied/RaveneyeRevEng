package dji.thirdparty.sanselan.common.byteSources;

import dji.thirdparty.sanselan.common.BinaryFileFunctions;
import java.io.IOException;
import java.io.InputStream;

public abstract class ByteSource
  extends BinaryFileFunctions
{
  protected final String filename;
  
  public ByteSource(String paramString)
  {
    this.filename = paramString;
  }
  
  public abstract byte[] getAll()
    throws IOException;
  
  public abstract byte[] getBlock(int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract String getDescription();
  
  public final String getFilename()
  {
    return this.filename;
  }
  
  public abstract InputStream getInputStream()
    throws IOException;
  
  public final InputStream getInputStream(int paramInt)
    throws IOException
  {
    InputStream localInputStream = getInputStream();
    skipBytes(localInputStream, paramInt);
    return localInputStream;
  }
  
  public abstract long getLength()
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\byteSources\ByteSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */