package dji.thirdparty.sanselan.common;

import dji.thirdparty.sanselan.ImageReadException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class BinaryInputStream
  extends InputStream
  implements BinaryConstants
{
  private int byteOrder = 77;
  protected boolean debug = false;
  private final InputStream is;
  
  public BinaryInputStream(InputStream paramInputStream)
  {
    this.is = paramInputStream;
  }
  
  public BinaryInputStream(InputStream paramInputStream, int paramInt)
  {
    this.byteOrder = paramInt;
    this.is = paramInputStream;
  }
  
  public BinaryInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.byteOrder = paramInt;
    this.is = new ByteArrayInputStream(paramArrayOfByte);
  }
  
  protected static final int CharsToQuad(char paramChar1, char paramChar2, char paramChar3, char paramChar4)
  {
    return (paramChar1 & 0xFF) << '\030' | (paramChar2 & 0xFF) << '\020' | (paramChar3 & 0xFF) << '\b' | (paramChar4 & 0xFF) << '\000';
  }
  
  public final boolean compareByteArrays(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte)
  {
    return convertByteArrayToInt(paramString, paramArrayOfByte, this.byteOrder);
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
  
  protected final int[] convertByteArrayToIntArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  protected final RationalNumber convertByteArrayToRational(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return convertByteArrayToRational(paramString, paramArrayOfByte, 0, paramInt);
  }
  
  protected final RationalNumber convertByteArrayToRational(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  protected final RationalNumber[] convertByteArrayToRationalArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  public final int convertByteArrayToShort(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    return convertByteArrayToShort(paramString, paramInt, paramArrayOfByte, this.byteOrder);
  }
  
  protected final int convertByteArrayToShort(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    return 0;
  }
  
  public final int convertByteArrayToShort(String paramString, byte[] paramArrayOfByte)
  {
    return convertByteArrayToShort(paramString, paramArrayOfByte, this.byteOrder);
  }
  
  protected final int convertByteArrayToShort(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return convertByteArrayToShort(paramString, 0, paramArrayOfByte, paramInt);
  }
  
  protected final int[] convertByteArrayToShortArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  /* Error */
  protected final void debugByteArray(String arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void debugNumber(String paramString, int paramInt)
  {
    debugNumber(paramString, paramInt, 1);
  }
  
  /* Error */
  public final void debugNumber(String arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void debugNumberArray(String arg1, int[] arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final int findNull(byte[] paramArrayOfByte)
  {
    return findNull(paramArrayOfByte, 0);
  }
  
  public final int findNull(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  protected int getByteOrder()
  {
    return this.byteOrder;
  }
  
  protected final byte[] getBytearrayHead(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return readBytearray(paramString, paramArrayOfByte, 0, paramArrayOfByte.length - paramInt);
  }
  
  protected final byte[] getBytearrayTail(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return readBytearray(paramString, paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
  }
  
  public final boolean getDebug()
  {
    return this.debug;
  }
  
  protected final byte[] getRAFBytes(RandomAccessFile paramRandomAccessFile, long paramLong, int paramInt, String paramString)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  protected final void printByteBits(String arg1, byte arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void printCharQuad(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int read()
    throws IOException
  {
    return this.is.read();
  }
  
  public final int read1ByteInteger(String paramString)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final int read2ByteInteger(String paramString)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final int read2Bytes(String paramString1, String paramString2)
    throws ImageReadException, IOException
  {
    return read2Bytes(paramString1, paramString2, this.byteOrder);
  }
  
  protected final int read2Bytes(String paramString1, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final int read3Bytes(String paramString1, String paramString2)
    throws ImageReadException, IOException
  {
    return read3Bytes(paramString1, paramString2, this.byteOrder);
  }
  
  protected final int read3Bytes(String paramString1, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final int read4ByteInteger(String paramString)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final int read4Bytes(String paramString1, String paramString2)
    throws ImageReadException, IOException
  {
    return read4Bytes(paramString1, paramString2, this.byteOrder);
  }
  
  protected final int read4Bytes(String paramString1, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  /* Error */
  protected final void readAndVerifyBytes(String arg1, byte[] arg2, String arg3)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void readAndVerifyBytes(byte[] arg1, String arg2)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final byte readByte(String paramString1, String paramString2)
    throws IOException
  {
    return 0;
  }
  
  public final byte[] readByteArray(int paramInt, String paramString)
    throws ImageReadException, IOException
  {
    return readByteArray(paramInt, paramString, false, true);
  }
  
  public final byte[] readByteArray(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final byte[] readByteArray(String paramString1, int paramInt, String paramString2)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  public final byte[] readBytearray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  protected final void readRandomBytes()
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void scanForByte(byte arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  protected void setByteOrder(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  /* Error */
  protected void setByteOrder(int arg1, int arg2)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.debug = paramBoolean;
  }
  
  protected void skipBytes(int paramInt)
    throws IOException
  {
    skipBytes(paramInt, "Couldn't skip bytes");
  }
  
  /* Error */
  public final void skipBytes(int arg1, String arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\BinaryInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */