package dji.thirdparty.sanselan.common;

import dji.thirdparty.sanselan.ImageWriteException;
import java.io.IOException;
import java.io.OutputStream;

public class BinaryOutputStream
  extends OutputStream
  implements BinaryConstants
{
  private int byteOrder = 77;
  private int count = 0;
  protected boolean debug = false;
  private final OutputStream os;
  
  public BinaryOutputStream(OutputStream paramOutputStream)
  {
    this.os = paramOutputStream;
  }
  
  public BinaryOutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this.byteOrder = paramInt;
    this.os = paramOutputStream;
  }
  
  private byte[] convertValueToByteArray(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  private final void writeNBytes(int paramInt1, int paramInt2)
    throws ImageWriteException, IOException
  {
    write(convertValueToByteArray(paramInt1, paramInt2));
  }
  
  public int getByteCount()
  {
    return this.count;
  }
  
  public int getByteOrder()
  {
    return this.byteOrder;
  }
  
  public final boolean getDebug()
  {
    return this.debug;
  }
  
  protected void setByteOrder(int paramInt)
  {
    this.byteOrder = paramInt;
  }
  
  /* Error */
  protected void setByteOrder(int arg1, int arg2)
    throws ImageWriteException, IOException
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
  
  /* Error */
  public void write(int arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void write2ByteInteger(int arg1)
    throws ImageWriteException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public final void write2Bytes(int paramInt)
    throws ImageWriteException, IOException
  {
    writeNBytes(paramInt, 2);
  }
  
  public final void write3Bytes(int paramInt)
    throws ImageWriteException, IOException
  {
    writeNBytes(paramInt, 3);
  }
  
  /* Error */
  public final void write4ByteInteger(int arg1)
    throws ImageWriteException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public final void write4Bytes(int paramInt)
    throws ImageWriteException, IOException
  {
    writeNBytes(paramInt, 4);
  }
  
  /* Error */
  public final void writeByteArray(byte[] arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\BinaryOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */