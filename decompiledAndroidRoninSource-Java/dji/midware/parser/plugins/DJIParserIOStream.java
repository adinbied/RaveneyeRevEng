package dji.midware.parser.plugins;

import java.io.IOException;
import java.io.OutputStream;

public class DJIParserIOStream
  extends OutputStream
{
  protected byte[] buf;
  protected int count;
  private byte[] mCopybuffer;
  private byte[] mTempbuffer;
  private byte[] mZerobuffer;
  private String name = "default";
  protected int offset;
  
  public DJIParserIOStream()
  {
    this.buf = new byte['Ѐ'];
    this.mTempbuffer = new byte['Ѐ'];
    this.mZerobuffer = new byte['Ѐ'];
  }
  
  public DJIParserIOStream(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.buf = new byte[paramInt];
      this.mTempbuffer = new byte[paramInt];
      this.mZerobuffer = new byte[paramInt];
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.name);
    localStringBuilder.append(" size < 0");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int available()
  {
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void checkOffsetAndCount(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int read()
  {
    return 0;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return 0;
  }
  
  /* Error */
  protected void resetOffset(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  /* Error */
  public void skip(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public void write(int paramInt)
    throws IOException
  {}
  
  /* Error */
  public void write(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\parser\plugins\DJIParserIOStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */