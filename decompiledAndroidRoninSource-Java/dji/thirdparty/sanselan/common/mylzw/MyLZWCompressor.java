package dji.thirdparty.sanselan.common.mylzw;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyLZWCompressor
{
  private final int byteOrder;
  private final int clearCode;
  private int codeSize;
  private int codes = -1;
  private final boolean earlyLimit;
  private final int eoiCode;
  private final int initialCodeSize;
  private final Listener listener;
  private final Map map = new HashMap();
  
  public MyLZWCompressor(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramInt1, paramInt2, paramBoolean, null);
  }
  
  public MyLZWCompressor(int paramInt1, int paramInt2, boolean paramBoolean, Listener paramListener)
  {
    this.listener = paramListener;
    this.byteOrder = paramInt2;
    this.earlyLimit = paramBoolean;
    this.initialCodeSize = paramInt1;
    paramInt1 = 1 << paramInt1;
    this.clearCode = paramInt1;
    paramInt2 = paramInt1 + 1;
    this.eoiCode = paramInt2;
    if (paramListener != null) {
      paramListener.init(paramInt1, paramInt2);
    }
    InitializeStringTable();
  }
  
  /* Error */
  private final void InitializeStringTable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final boolean addTableEntry(MyBitOutputStream paramMyBitOutputStream, Object paramObject)
    throws IOException
  {
    return false;
  }
  
  private final boolean addTableEntry(MyBitOutputStream paramMyBitOutputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return addTableEntry(paramMyBitOutputStream, arrayToKey(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  private final Object arrayToKey(byte paramByte)
  {
    return null;
  }
  
  private final Object arrayToKey(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new ByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private final void clearTable()
  {
    InitializeStringTable();
    incrementCodeSize();
  }
  
  private final int codeFromString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramArrayOfByte = arrayToKey(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.map.get(paramArrayOfByte);
    if (paramArrayOfByte != null) {
      return ((Integer)paramArrayOfByte).intValue();
    }
    throw new IOException("CodeFromString");
  }
  
  /* Error */
  private final void incrementCodeSize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final boolean isInTable(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = arrayToKey(paramArrayOfByte, paramInt1, paramInt2);
    return this.map.containsKey(paramArrayOfByte);
  }
  
  /* Error */
  private final void writeClearCode(MyBitOutputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final void writeCode(MyBitOutputStream paramMyBitOutputStream, int paramInt)
    throws IOException
  {
    paramMyBitOutputStream.writeBits(paramInt, this.codeSize);
  }
  
  /* Error */
  private final void writeDataCode(MyBitOutputStream arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private final void writeEoiCode(MyBitOutputStream arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] compress(byte[] paramArrayOfByte)
    throws IOException
  {
    return null;
  }
  
  private static final class ByteArray
  {
    private final byte[] bytes;
    private final int hash;
    private final int length;
    private final int start;
    
    public ByteArray(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public ByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.bytes = paramArrayOfByte;
      this.start = paramInt1;
      this.length = paramInt2;
      int i = 0;
      int j = paramInt2;
      while (i < paramInt2)
      {
        j = j + (j << 8) ^ paramArrayOfByte[(i + paramInt1)] & 0xFF ^ i;
        i += 1;
      }
      this.hash = j;
    }
    
    public final boolean equals(Object paramObject)
    {
      return false;
    }
    
    public final int hashCode()
    {
      return this.hash;
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void clearCode(int paramInt);
    
    public abstract void dataCode(int paramInt);
    
    public abstract void eoiCode(int paramInt);
    
    public abstract void init(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\mylzw\MyLZWCompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */