package dji.midware.ar.min3d.parser;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LittleEndianDataInputStream
  extends InputStream
  implements DataInput
{
  private DataInputStream d;
  private InputStream in;
  private byte[] w;
  
  public LittleEndianDataInputStream(InputStream paramInputStream)
  {
    this.in = paramInputStream;
    this.d = new DataInputStream(paramInputStream);
    this.w = new byte[8];
  }
  
  public int available()
    throws IOException
  {
    return this.d.available();
  }
  
  public final void close()
    throws IOException
  {
    this.d.close();
  }
  
  public int read()
    throws IOException
  {
    return this.in.read();
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.in.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final boolean readBoolean()
    throws IOException
  {
    return this.d.readBoolean();
  }
  
  public final byte readByte()
    throws IOException
  {
    return this.d.readByte();
  }
  
  public final char readChar()
    throws IOException
  {
    return '\000';
  }
  
  public final double readDouble()
    throws IOException
  {
    return 1.043670145E-315D;
  }
  
  public final float readFloat()
    throws IOException
  {
    return 0.0F;
  }
  
  public final void readFully(byte[] paramArrayOfByte)
    throws IOException
  {
    this.d.readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.d.readFully(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final int readInt()
    throws IOException
  {
    return 0;
  }
  
  @Deprecated
  public final String readLine()
    throws IOException
  {
    return this.d.readLine();
  }
  
  public final long readLong()
    throws IOException
  {
    return 211241219L;
  }
  
  public final short readShort()
    throws IOException
  {
    return 0;
  }
  
  public String readString(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public final String readUTF()
    throws IOException
  {
    return this.d.readUTF();
  }
  
  public final int readUnsignedByte()
    throws IOException
  {
    return this.d.readUnsignedByte();
  }
  
  public final int readUnsignedShort()
    throws IOException
  {
    return 0;
  }
  
  public final int skipBytes(int paramInt)
    throws IOException
  {
    return this.d.skipBytes(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\LittleEndianDataInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */