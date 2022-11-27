package com.drew.metadata.jpeg;

import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HuffmanTablesDirectory
  extends Directory
{
  public static final int TAG_NUMBER_OF_TABLES = 1;
  protected static final byte[] TYPICAL_CHROMINANCE_AC_LENGTHS;
  protected static final byte[] TYPICAL_CHROMINANCE_AC_VALUES;
  protected static final byte[] TYPICAL_CHROMINANCE_DC_LENGTHS;
  protected static final byte[] TYPICAL_CHROMINANCE_DC_VALUES;
  protected static final byte[] TYPICAL_LUMINANCE_AC_LENGTHS;
  protected static final byte[] TYPICAL_LUMINANCE_AC_VALUES;
  protected static final byte[] TYPICAL_LUMINANCE_DC_LENGTHS = { 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
  protected static final byte[] TYPICAL_LUMINANCE_DC_VALUES = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
  protected static final HashMap<Integer, String> _tagNameMap;
  protected final List<HuffmanTable> tables = new ArrayList(4);
  
  static
  {
    TYPICAL_CHROMINANCE_DC_LENGTHS = new byte[] { 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
    TYPICAL_CHROMINANCE_DC_VALUES = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
    TYPICAL_LUMINANCE_AC_LENGTHS = new byte[] { 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125 };
    TYPICAL_LUMINANCE_AC_VALUES = new byte[] { 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6 };
    TYPICAL_CHROMINANCE_AC_LENGTHS = new byte[] { 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119 };
    TYPICAL_CHROMINANCE_AC_VALUES = new byte[] { 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6 };
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Number of Tables");
  }
  
  public HuffmanTablesDirectory()
  {
    setDescriptor(new HuffmanTablesDescriptor(this));
  }
  
  public String getName()
  {
    return "Huffman";
  }
  
  public int getNumberOfTables()
    throws MetadataException
  {
    return getInt(1);
  }
  
  public HuffmanTable getTable(int paramInt)
  {
    return null;
  }
  
  protected List<HuffmanTable> getTables()
  {
    return this.tables;
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  public boolean isOptimized()
  {
    return isTypical() ^ true;
  }
  
  public boolean isTypical()
  {
    return false;
  }
  
  public static class HuffmanTable
  {
    private final byte[] lengthBytes;
    private final HuffmanTableClass tableClass;
    private final int tableDestinationId;
    private final int tableLength;
    private final byte[] valueBytes;
    
    public HuffmanTable(HuffmanTableClass paramHuffmanTableClass, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.tableClass = paramHuffmanTableClass;
      this.tableDestinationId = paramInt;
      this.lengthBytes = paramArrayOfByte1;
      this.valueBytes = paramArrayOfByte2;
      this.tableLength = (paramArrayOfByte2.length + 17);
    }
    
    public byte[] getLengthBytes()
    {
      return null;
    }
    
    public HuffmanTableClass getTableClass()
    {
      return this.tableClass;
    }
    
    public int getTableDestinationId()
    {
      return this.tableDestinationId;
    }
    
    public int getTableLength()
    {
      return this.tableLength;
    }
    
    public byte[] getValueBytes()
    {
      return null;
    }
    
    public boolean isOptimized()
    {
      return isTypical() ^ true;
    }
    
    public boolean isTypical()
    {
      return false;
    }
    
    public static enum HuffmanTableClass
    {
      static
      {
        AC = new HuffmanTableClass("AC", 1);
        HuffmanTableClass localHuffmanTableClass = new HuffmanTableClass("UNKNOWN", 2);
        UNKNOWN = localHuffmanTableClass;
        $VALUES = new HuffmanTableClass[] { DC, AC, localHuffmanTableClass };
      }
      
      private HuffmanTableClass() {}
      
      public static HuffmanTableClass typeOf(int paramInt)
      {
        if (paramInt != 0)
        {
          if (paramInt != 1) {
            return UNKNOWN;
          }
          return AC;
        }
        return DC;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\jpeg\HuffmanTablesDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */