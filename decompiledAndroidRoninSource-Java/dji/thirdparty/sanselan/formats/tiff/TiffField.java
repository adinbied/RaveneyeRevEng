package dji.thirdparty.sanselan.formats.tiff;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.formats.tiff.constants.TagInfo;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffDirectoryConstants.ExifDirectoryType;
import dji.thirdparty.sanselan.formats.tiff.fieldtypes.FieldType;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class TiffField
  implements TiffConstants
{
  private static final Map ALL_TAG_MAP = makeTagMap(ALL_TAGS, true, "All");
  public static final String Attribute_Tag = "Tag";
  private static final Map EXIF_TAG_MAP;
  private static final Map GPS_TAG_MAP = makeTagMap(ALL_GPS_TAGS, false, "GPS");
  private static final Map TIFF_TAG_MAP = makeTagMap(ALL_TIFF_TAGS, false, "TIFF");
  public final int byteOrder;
  public final int directoryType;
  public final FieldType fieldType;
  public final int length;
  public byte[] oversizeValue = null;
  private int sortHint = -1;
  public final int tag;
  public final TagInfo tagInfo;
  public final int type;
  public final int valueOffset;
  public final byte[] valueOffsetBytes;
  
  static
  {
    EXIF_TAG_MAP = makeTagMap(ALL_EXIF_TAGS, true, "EXIF");
  }
  
  public TiffField(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte, int paramInt6)
  {
    this.tag = paramInt1;
    this.directoryType = paramInt2;
    this.type = paramInt3;
    this.length = paramInt4;
    this.valueOffset = paramInt5;
    this.valueOffsetBytes = paramArrayOfByte;
    this.byteOrder = paramInt6;
    this.fieldType = getFieldType(paramInt3);
    this.tagInfo = getTag(paramInt2, paramInt1);
  }
  
  private static FieldType getFieldType(int paramInt)
  {
    int i = 0;
    while (i < FIELD_TYPES.length)
    {
      FieldType localFieldType = FIELD_TYPES[i];
      if (localFieldType.type == paramInt) {
        return localFieldType;
      }
      i += 1;
    }
    return FIELD_TYPE_UNKNOWN;
  }
  
  private static TagInfo getTag(int paramInt1, int paramInt2)
  {
    Object localObject = new Integer(paramInt2);
    localObject = (List)EXIF_TAG_MAP.get(localObject);
    if (localObject == null) {
      return TIFF_TAG_UNKNOWN;
    }
    return getTag(paramInt1, paramInt2, (List)localObject);
  }
  
  private static TagInfo getTag(int paramInt1, int paramInt2, List paramList)
  {
    if (paramList.size() < 1) {
      return null;
    }
    int j = 0;
    paramInt2 = 0;
    TagInfo localTagInfo;
    while (paramInt2 < paramList.size())
    {
      localTagInfo = (TagInfo)paramList.get(paramInt2);
      if (localTagInfo.directoryType != EXIF_DIRECTORY_UNKNOWN)
      {
        if ((paramInt1 == -2) && (localTagInfo.directoryType == EXIF_DIRECTORY_EXIF_IFD)) {
          return localTagInfo;
        }
        if ((paramInt1 == -4) && (localTagInfo.directoryType == EXIF_DIRECTORY_INTEROP_IFD)) {
          return localTagInfo;
        }
        if ((paramInt1 == -3) && (localTagInfo.directoryType == EXIF_DIRECTORY_GPS)) {
          return localTagInfo;
        }
        if ((paramInt1 == -5) && (localTagInfo.directoryType == EXIF_DIRECTORY_MAKER_NOTES)) {
          return localTagInfo;
        }
        if ((paramInt1 == 0) && (localTagInfo.directoryType == TIFF_DIRECTORY_IFD0)) {
          return localTagInfo;
        }
        if ((paramInt1 == 1) && (localTagInfo.directoryType == TIFF_DIRECTORY_IFD1)) {
          return localTagInfo;
        }
        if ((paramInt1 == 2) && (localTagInfo.directoryType == TIFF_DIRECTORY_IFD2)) {
          return localTagInfo;
        }
        if ((paramInt1 == 3) && (localTagInfo.directoryType == TIFF_DIRECTORY_IFD3)) {
          return localTagInfo;
        }
      }
      paramInt2 += 1;
    }
    paramInt2 = 0;
    int i;
    for (;;)
    {
      i = j;
      if (paramInt2 >= paramList.size()) {
        break;
      }
      localTagInfo = (TagInfo)paramList.get(paramInt2);
      if (localTagInfo.directoryType != EXIF_DIRECTORY_UNKNOWN)
      {
        if ((paramInt1 >= 0) && (localTagInfo.directoryType.isImageDirectory())) {
          return localTagInfo;
        }
        if ((paramInt1 < 0) && (!localTagInfo.directoryType.isImageDirectory())) {
          return localTagInfo;
        }
      }
      paramInt2 += 1;
    }
    while (i < paramList.size())
    {
      localTagInfo = (TagInfo)paramList.get(i);
      if (localTagInfo.directoryType == EXIF_DIRECTORY_UNKNOWN) {
        return localTagInfo;
      }
      i += 1;
    }
    return TIFF_TAG_UNKNOWN;
  }
  
  private String getValueDescription(Object paramObject)
  {
    return null;
  }
  
  private int getValueLengthInBytes()
  {
    return 0;
  }
  
  private static final Map makeTagMap(TagInfo[] paramArrayOfTagInfo, boolean paramBoolean, String paramString)
  {
    Hashtable localHashtable = new Hashtable();
    int i = 0;
    while (i < paramArrayOfTagInfo.length)
    {
      TagInfo localTagInfo = paramArrayOfTagInfo[i];
      Integer localInteger = new Integer(localTagInfo.tag);
      List localList = (List)localHashtable.get(localInteger);
      paramString = localList;
      if (localList == null)
      {
        paramString = new ArrayList();
        localHashtable.put(localInteger, paramString);
      }
      paramString.add(localTagInfo);
      i += 1;
    }
    return localHashtable;
  }
  
  /* Error */
  public void dump()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void dump(PrintWriter paramPrintWriter)
  {
    dump(paramPrintWriter, null);
  }
  
  /* Error */
  public void dump(PrintWriter arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void fillInValue(dji.thirdparty.sanselan.common.byteSources.ByteSource arg1)
    throws ImageReadException, java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getByteArrayValue()
    throws ImageReadException
  {
    return this.fieldType.getRawBytes(this);
  }
  
  public int getBytesLength()
    throws ImageReadException
  {
    return this.fieldType.getBytesLength(this);
  }
  
  public String getDescriptionWithoutValue()
  {
    return null;
  }
  
  public double[] getDoubleArrayValue()
    throws ImageReadException
  {
    return null;
  }
  
  public double getDoubleValue()
    throws ImageReadException
  {
    return 1.373713244E-315D;
  }
  
  public String getFieldTypeName()
  {
    return this.fieldType.name;
  }
  
  public int[] getIntArrayValue()
    throws ImageReadException
  {
    return null;
  }
  
  public int getIntValue()
    throws ImageReadException
  {
    return 0;
  }
  
  public int getIntValueOrArraySum()
    throws ImageReadException
  {
    return 0;
  }
  
  public TiffElement getOversizeValueElement()
  {
    return null;
  }
  
  public int getSortHint()
  {
    return this.sortHint;
  }
  
  public String getStringValue()
    throws ImageReadException
  {
    return null;
  }
  
  public String getTagName()
  {
    return null;
  }
  
  public Object getValue()
    throws ImageReadException
  {
    return this.tagInfo.getValue(this);
  }
  
  public String getValueDescription()
  {
    return null;
  }
  
  public boolean isLocalValue()
  {
    return this.fieldType.isLocalValue(this);
  }
  
  public void setOversizeValue(byte[] paramArrayOfByte)
  {
    this.oversizeValue = paramArrayOfByte;
  }
  
  public void setSortHint(int paramInt)
  {
    this.sortHint = paramInt;
  }
  
  public String toString()
  {
    return null;
  }
  
  public final class OversizeValueElement
    extends TiffElement
  {
    public OversizeValueElement(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public String getElementDescription(boolean paramBoolean)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */