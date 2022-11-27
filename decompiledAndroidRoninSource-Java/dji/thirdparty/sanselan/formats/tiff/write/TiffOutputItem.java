package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.common.BinaryOutputStream;
import dji.thirdparty.sanselan.formats.tiff.constants.AllTagConstants;
import java.io.IOException;

abstract class TiffOutputItem
  implements AllTagConstants
{
  public static final int UNDEFINED_VALUE = -1;
  private int offset = -1;
  
  public abstract String getItemDescription();
  
  public abstract int getItemLength();
  
  protected int getOffset()
  {
    return this.offset;
  }
  
  protected void setOffset(int paramInt)
  {
    this.offset = paramInt;
  }
  
  public abstract void writeItem(BinaryOutputStream paramBinaryOutputStream)
    throws IOException, ImageWriteException;
  
  public static class Value
    extends TiffOutputItem
  {
    private final byte[] bytes;
    private final String name;
    
    public Value(String paramString, byte[] paramArrayOfByte)
    {
      this.name = paramString;
      this.bytes = paramArrayOfByte;
    }
    
    public String getItemDescription()
    {
      return this.name;
    }
    
    public int getItemLength()
    {
      return this.bytes.length;
    }
    
    /* Error */
    public void updateValue(byte[] arg1)
      throws ImageWriteException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void writeItem(BinaryOutputStream paramBinaryOutputStream)
      throws IOException, ImageWriteException
    {
      paramBinaryOutputStream.write(this.bytes);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffOutputItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */