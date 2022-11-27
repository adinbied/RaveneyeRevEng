package dji.thirdparty.sanselan.common.mylzw;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class MyLZWDecompressor
{
  private static final int MAX_TABLE_SIZE = 4096;
  private final int byteOrder;
  private final int clearCode;
  private int codeSize;
  private int codes = -1;
  private final int eoiCode;
  private final int initialCodeSize;
  private final Listener listener;
  private final byte[][] table;
  private boolean tiffLZWMode = false;
  private int written = 0;
  
  public MyLZWDecompressor(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
  }
  
  public MyLZWDecompressor(int paramInt1, int paramInt2, Listener paramListener)
  {
    this.listener = paramListener;
    this.byteOrder = paramInt2;
    this.initialCodeSize = paramInt1;
    this.table = new byte['က'][];
    paramInt1 = 1 << paramInt1;
    this.clearCode = paramInt1;
    paramInt2 = paramInt1 + 1;
    this.eoiCode = paramInt2;
    if (paramListener != null) {
      paramListener.init(paramInt1, paramInt2);
    }
    InitializeTable();
  }
  
  /* Error */
  private final void InitializeTable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private final void addStringToTable(byte[] arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final byte[] appendBytes(byte[] paramArrayOfByte, byte paramByte)
  {
    return null;
  }
  
  /* Error */
  private final void checkCodeSize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private final void clearTable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final byte firstChar(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0];
  }
  
  private final int getNextCode(MyBitInputStream paramMyBitInputStream)
    throws IOException
  {
    return 0;
  }
  
  /* Error */
  private final void incrementCodeSize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final boolean isInTable(int paramInt)
  {
    return paramInt < this.codes;
  }
  
  private final byte[] stringFromCode(int paramInt)
    throws IOException
  {
    return null;
  }
  
  private final void writeToResult(OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    paramOutputStream.write(paramArrayOfByte);
    this.written += paramArrayOfByte.length;
  }
  
  public byte[] decompress(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return null;
  }
  
  public void setTiffLZWMode()
  {
    this.tiffLZWMode = true;
  }
  
  public static abstract interface Listener
  {
    public abstract void code(int paramInt);
    
    public abstract void init(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\mylzw\MyLZWDecompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */