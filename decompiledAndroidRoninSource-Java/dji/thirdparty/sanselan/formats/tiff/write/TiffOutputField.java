package dji.thirdparty.sanselan.formats.tiff.write;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldType;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeASCII;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldTypeLong;

public class TiffOutputField
  implements TiffConstants
{
  private static final String newline = System.getProperty("line.separator");
  private byte[] bytes;
  public final int count;
  public final FieldType fieldType;
  private final TiffOutputItem.Value separateValueItem;
  private int sortHint = -1;
  public final int tag;
  public final TagInfo tagInfo;
  
  public TiffOutputField(int paramInt1, TagInfo paramTagInfo, FieldType paramFieldType, int paramInt2, byte[] paramArrayOfByte)
  {
    this.tag = paramInt1;
    this.tagInfo = paramTagInfo;
    this.fieldType = paramFieldType;
    this.count = paramInt2;
    this.bytes = paramArrayOfByte;
    if (isLocalValue())
    {
      this.separateValueItem = null;
      return;
    }
    paramFieldType = new StringBuilder();
    paramFieldType.append("Field Seperate value (");
    paramFieldType.append(paramTagInfo.getDescription());
    paramFieldType.append(")");
    this.separateValueItem = new TiffOutputItem.Value(paramFieldType.toString(), paramArrayOfByte);
  }
  
  public TiffOutputField(TagInfo paramTagInfo, FieldType paramFieldType, int paramInt, byte[] paramArrayOfByte)
  {
    this(paramTagInfo.tag, paramTagInfo, paramFieldType, paramInt, paramArrayOfByte);
  }
  
  public static TiffOutputField create(TagInfo paramTagInfo, int paramInt, Number paramNumber)
    throws ImageWriteException
  {
    if ((paramTagInfo.dataTypes != null) && (paramTagInfo.dataTypes.length >= 1))
    {
      FieldType localFieldType = paramTagInfo.dataTypes[0];
      if (paramTagInfo.length == 1)
      {
        paramNumber = localFieldType.writeData(paramNumber, paramInt);
        return new TiffOutputField(paramTagInfo.tag, paramTagInfo, localFieldType, 1, paramNumber);
      }
      throw new ImageWriteException("Tag does not expect a single value.");
    }
    throw new ImageWriteException("Tag has no default data type.");
  }
  
  public static TiffOutputField create(TagInfo paramTagInfo, int paramInt, String paramString)
    throws ImageWriteException
  {
    FieldTypeASCII localFieldTypeASCII;
    if (paramTagInfo.dataTypes == null) {
      localFieldTypeASCII = FIELD_TYPE_ASCII;
    }
    for (;;)
    {
      break;
      if (paramTagInfo.dataTypes == FIELD_TYPE_DESCRIPTION_ASCII)
      {
        localFieldTypeASCII = FIELD_TYPE_ASCII;
      }
      else
      {
        if (paramTagInfo.dataTypes[0] != FIELD_TYPE_ASCII) {
          break label74;
        }
        localFieldTypeASCII = FIELD_TYPE_ASCII;
      }
    }
    paramString = localFieldTypeASCII.writeData(paramString, paramInt);
    return new TiffOutputField(paramTagInfo.tag, paramTagInfo, localFieldTypeASCII, paramString.length, paramString);
    label74:
    throw new ImageWriteException("Tag has unexpected data type.");
  }
  
  public static TiffOutputField create(TagInfo paramTagInfo, int paramInt, Number[] paramArrayOfNumber)
    throws ImageWriteException
  {
    if ((paramTagInfo.dataTypes != null) && (paramTagInfo.dataTypes.length >= 1))
    {
      FieldType localFieldType = paramTagInfo.dataTypes[0];
      if (paramTagInfo.length == paramArrayOfNumber.length)
      {
        byte[] arrayOfByte = localFieldType.writeData(paramArrayOfNumber, paramInt);
        return new TiffOutputField(paramTagInfo.tag, paramTagInfo, localFieldType, paramArrayOfNumber.length, arrayOfByte);
      }
      throw new ImageWriteException("Tag does not expect a single value.");
    }
    throw new ImageWriteException("Tag has no default data type.");
  }
  
  protected static final TiffOutputField createOffsetField(TagInfo paramTagInfo, int paramInt)
    throws ImageWriteException
  {
    return new TiffOutputField(paramTagInfo, FIELD_TYPE_LONG, 1, FIELD_TYPE_LONG.writeData(new int[] { 0 }, paramInt));
  }
  
  protected TiffOutputItem getSeperateValue()
  {
    return this.separateValueItem;
  }
  
  public int getSortHint()
  {
    return this.sortHint;
  }
  
  protected boolean isLocalValue()
  {
    return false;
  }
  
  /* Error */
  protected void setData(byte[] arg1)
    throws ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setSortHint(int paramInt)
  {
    this.sortHint = paramInt;
  }
  
  public String toString()
  {
    return toString(null);
  }
  
  public String toString(String paramString)
  {
    return null;
  }
  
  /* Error */
  protected void writeField(dji.thirdparty.sanselan.common.BinaryOutputStream arg1)
    throws java.io.IOException, ImageWriteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\write\TiffOutputField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */