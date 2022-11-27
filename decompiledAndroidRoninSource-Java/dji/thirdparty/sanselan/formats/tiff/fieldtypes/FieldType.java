package dji.thirdparty.sanselan.formats.tiff.fieldtypes;

import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.common.BinaryFileFunctions;
import dji.thirdparty.sanselan.formats.tiff.TiffField;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;

public abstract class FieldType
  extends BinaryFileFunctions
  implements TiffConstants
{
  public final int length;
  public final String name;
  public final int type;
  
  public FieldType(int paramInt1, int paramInt2, String paramString)
  {
    this.type = paramInt1;
    this.length = paramInt2;
    this.name = paramString;
  }
  
  public static final byte[] getStubLocalValue()
  {
    return new byte[4];
  }
  
  public int getBytesLength(TiffField paramTiffField)
    throws ImageReadException
  {
    return 0;
  }
  
  public String getDisplayValue(TiffField paramTiffField)
    throws ImageReadException
  {
    paramTiffField = getSimpleValue(paramTiffField);
    if (paramTiffField == null) {
      return "NULL";
    }
    return paramTiffField.toString();
  }
  
  public final byte[] getRawBytes(TiffField paramTiffField)
  {
    return null;
  }
  
  public abstract Object getSimpleValue(TiffField paramTiffField)
    throws ImageReadException;
  
  public final byte[] getStubValue(int paramInt)
  {
    return new byte[paramInt * this.length];
  }
  
  public boolean isLocalValue(TiffField paramTiffField)
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
  
  public abstract byte[] writeData(Object paramObject, int paramInt)
    throws ImageWriteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\fieldtypes\FieldType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */