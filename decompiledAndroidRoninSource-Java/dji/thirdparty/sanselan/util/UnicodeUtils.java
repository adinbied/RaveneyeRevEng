package dji.thirdparty.sanselan.util;

import dji.thirdparty.sanselan.common.BinaryConstants;
import java.io.UnsupportedEncodingException;

public abstract class UnicodeUtils
  implements BinaryConstants
{
  public static final int CHAR_ENCODING_CODE_AMBIGUOUS = -1;
  public static final int CHAR_ENCODING_CODE_ISO_8859_1 = 0;
  public static final int CHAR_ENCODING_CODE_UTF_16_BIG_ENDIAN_NO_BOM = 3;
  public static final int CHAR_ENCODING_CODE_UTF_16_BIG_ENDIAN_WITH_BOM = 1;
  public static final int CHAR_ENCODING_CODE_UTF_16_LITTLE_ENDIAN_NO_BOM = 4;
  public static final int CHAR_ENCODING_CODE_UTF_16_LITTLE_ENDIAN_WITH_BOM = 2;
  public static final int CHAR_ENCODING_CODE_UTF_8 = 5;
  
  private static int findFirstDoubleByteTerminator(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    while (i < paramArrayOfByte.length - 1)
    {
      int j = paramArrayOfByte[paramInt];
      int k = paramArrayOfByte[(paramInt + 1)];
      if (((j & 0xFF) == 0) && ((k & 0xFF) == 0)) {
        return i;
      }
      i += 2;
    }
    return -1;
  }
  
  public static UnicodeUtils getInstance(int paramInt)
    throws UnicodeUtils.UnicodeException
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt == 5) {
              return new UnicodeMetricsUTF8(null);
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown char encoding code: ");
            localStringBuilder.append(paramInt);
            throw new UnicodeException(localStringBuilder.toString());
          }
          return new UnicodeMetricsUTF16NoBOM(73);
        }
        return new UnicodeMetricsUTF16NoBOM(77);
      }
      return new UnicodeMetricsUTF16WithBOM();
    }
    return new UnicodeMetricsASCII(null);
  }
  
  public static final boolean isValidISO_8859_1(String paramString)
  {
    try
    {
      boolean bool = paramString.equals(new String(paramString.getBytes("ISO-8859-1"), "ISO-8859-1"));
      return bool;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("Error parsing string.", paramString);
    }
  }
  
  protected abstract int findEnd(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws UnicodeUtils.UnicodeException;
  
  public final int findEndWithTerminator(byte[] paramArrayOfByte, int paramInt)
    throws UnicodeUtils.UnicodeException
  {
    return findEnd(paramArrayOfByte, paramInt, true);
  }
  
  public final int findEndWithoutTerminator(byte[] paramArrayOfByte, int paramInt)
    throws UnicodeUtils.UnicodeException
  {
    return findEnd(paramArrayOfByte, paramInt, false);
  }
  
  public static class UnicodeException
    extends Exception
  {
    public UnicodeException(String paramString)
    {
      super();
    }
  }
  
  private static class UnicodeMetricsASCII
    extends UnicodeUtils
  {
    private UnicodeMetricsASCII()
    {
      super();
    }
    
    public int findEnd(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
      throws UnicodeUtils.UnicodeException
    {
      return 0;
    }
  }
  
  private static abstract class UnicodeMetricsUTF16
    extends UnicodeUtils
  {
    protected static final int BYTE_ORDER_BIG_ENDIAN = 0;
    protected static final int BYTE_ORDER_LITTLE_ENDIAN = 1;
    protected int byteOrder = 0;
    
    public UnicodeMetricsUTF16(int paramInt)
    {
      super();
      this.byteOrder = paramInt;
    }
    
    public int findEnd(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
      throws UnicodeUtils.UnicodeException
    {
      return 0;
    }
    
    public boolean isValid(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
      throws UnicodeUtils.UnicodeException
    {
      return false;
    }
  }
  
  private static class UnicodeMetricsUTF16NoBOM
    extends UnicodeUtils.UnicodeMetricsUTF16
  {
    public UnicodeMetricsUTF16NoBOM(int paramInt)
    {
      super();
    }
  }
  
  private static class UnicodeMetricsUTF16WithBOM
    extends UnicodeUtils.UnicodeMetricsUTF16
  {
    public UnicodeMetricsUTF16WithBOM()
    {
      super();
    }
    
    public int findEnd(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
      throws UnicodeUtils.UnicodeException
    {
      return 0;
    }
  }
  
  private static class UnicodeMetricsUTF8
    extends UnicodeUtils
  {
    private UnicodeMetricsUTF8()
    {
      super();
    }
    
    public int findEnd(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
      throws UnicodeUtils.UnicodeException
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\UnicodeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */