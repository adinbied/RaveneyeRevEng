package dji.thirdparty.sanselan.common;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class BinaryFileFunctions
  implements BinaryConstants
{
  protected boolean debug = false;
  
  public static final int CharsToQuad(char paramChar1, char paramChar2, char paramChar3, char paramChar4)
  {
    return (paramChar1 & 0xFF) << '\030' | (paramChar2 & 0xFF) << '\020' | (paramChar3 & 0xFF) << '\b' | (paramChar4 & 0xFF) << '\000';
  }
  
  public static final boolean compareBytes(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if (paramArrayOfByte1.length < paramInt1 + paramInt3) {
      return false;
    }
    if (paramArrayOfByte2.length < paramInt2 + paramInt3) {
      return false;
    }
    int i = 0;
    while (i < paramInt3)
    {
      if (paramArrayOfByte1[(paramInt1 + i)] != paramArrayOfByte2[(paramInt2 + i)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static final boolean compareBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    return compareBytes(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
  }
  
  public static final byte[] head(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    return slice(paramArrayOfByte, 0, i);
  }
  
  protected static final byte[] int2ToByteArray(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 77) {
      return new byte[] { (byte)(paramInt1 >> 8), (byte)(paramInt1 >> 0) };
    }
    return new byte[] { (byte)(paramInt1 >> 0), (byte)(paramInt1 >> 8) };
  }
  
  public static final byte[] slice(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length < paramInt1 + paramInt2) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static final byte[] tail(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    return slice(paramArrayOfByte, paramArrayOfByte.length - i, i);
  }
  
  public final boolean compareByteArrays(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public final boolean compareByteArrays(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return false;
  }
  
  protected final double convertByteArrayToDouble(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return convertByteArrayToDouble(paramString, paramArrayOfByte, 0, paramInt);
  }
  
  protected final double convertByteArrayToDouble(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 1.372900037E-315D;
  }
  
  protected final double[] convertByteArrayToDoubleArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  protected final float convertByteArrayToFloat(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return convertByteArrayToFloat(paramString, paramArrayOfByte, 0, paramInt);
  }
  
  protected final float convertByteArrayToFloat(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0.0F;
  }
  
  protected final float[] convertByteArrayToFloatArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    return convertByteArrayToInt(paramString, paramArrayOfByte, 0, paramInt);
  }
  
  protected final int convertByteArrayToInt(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
  
  protected final int convertByteArrayToShort(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
    throws ImageReadException
  {
    return 0;
  }
  
  protected final int convertByteArrayToShort(String paramString, byte[] paramArrayOfByte, int paramInt)
    throws ImageReadException
  {
    return convertByteArrayToShort(paramString, 0, paramArrayOfByte, paramInt);
  }
  
  protected final int[] convertByteArrayToShortArray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws ImageReadException
  {
    return null;
  }
  
  protected final byte[] convertDoubleArrayToByteArray(double[] paramArrayOfDouble, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertDoubleToByteArray(double paramDouble, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertFloatArrayToByteArray(float[] paramArrayOfFloat, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertFloatToByteArray(float paramFloat, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertIntArrayToByteArray(int[] paramArrayOfInt, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertIntArrayToRationalArray(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    throws ImageWriteException
  {
    return null;
  }
  
  protected final byte[] convertRationalArrayToByteArray(RationalNumber[] paramArrayOfRationalNumber, int paramInt)
    throws ImageWriteException
  {
    return null;
  }
  
  protected final byte[] convertRationalToByteArray(RationalNumber paramRationalNumber, int paramInt)
    throws ImageWriteException
  {
    return null;
  }
  
  protected final byte[] convertShortArrayToByteArray(int[] paramArrayOfInt, int paramInt)
  {
    return null;
  }
  
  protected final byte[] convertShortToByteArray(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  /* Error */
  public final void copyStreamToStream(InputStream arg1, java.io.OutputStream arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void debugByteArray(String arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void debugNumber(PrintWriter paramPrintWriter, String paramString, int paramInt)
  {
    debugNumber(paramPrintWriter, paramString, paramInt, 1);
  }
  
  /* Error */
  public final void debugNumber(PrintWriter arg1, String arg2, int arg3, int arg4)
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
  
  protected final byte[] getByteArrayTail(String paramString, byte[] paramArrayOfByte, int paramInt)
    throws ImageReadException
  {
    return readBytearray(paramString, paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
  }
  
  protected final byte[] getBytearrayHead(String paramString, byte[] paramArrayOfByte, int paramInt)
    throws ImageReadException
  {
    return readBytearray(paramString, paramArrayOfByte, 0, paramArrayOfByte.length - paramInt);
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
  
  public final byte[] getStreamBytes(InputStream paramInputStream)
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
  protected final void printCharQuad(PrintWriter arg1, String arg2, int arg3)
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
  
  protected final int read2Bytes(String paramString1, InputStream paramInputStream, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  protected final int read3Bytes(String paramString1, InputStream paramInputStream, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  protected final int read4Bytes(String paramString1, InputStream paramInputStream, String paramString2, int paramInt)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  /* Error */
  public final void readAndVerifyBytes(InputStream arg1, byte[] arg2, String arg3)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void readAndVerifyBytes(String arg1, InputStream arg2, byte[] arg3, String arg4)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final byte readByte(String paramString1, InputStream paramInputStream, String paramString2)
    throws ImageReadException, IOException
  {
    return 0;
  }
  
  public final byte[] readByteArray(String paramString, int paramInt, InputStream paramInputStream)
    throws IOException
  {
    return null;
  }
  
  public final byte[] readByteArray(String paramString1, int paramInt, InputStream paramInputStream, String paramString2)
    throws IOException
  {
    return null;
  }
  
  public final byte[] readBytearray(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ImageReadException
  {
    return null;
  }
  
  public final byte[] readBytes(InputStream paramInputStream, int paramInt)
    throws ImageReadException, IOException
  {
    return null;
  }
  
  /* Error */
  protected final void readRandomBytes(InputStream arg1)
    throws ImageReadException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void scanForByte(InputStream arg1, byte arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void setDebug(boolean paramBoolean)
  {
    this.debug = paramBoolean;
  }
  
  protected void skipBytes(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    skipBytes(paramInputStream, paramInt, "Couldn't skip bytes");
  }
  
  /* Error */
  public final void skipBytes(InputStream arg1, int arg2, String arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final boolean startsWith(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return false;
  }
  
  /* Error */
  protected final void writeIntInToByteArray(int arg1, byte[] arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\BinaryFileFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */