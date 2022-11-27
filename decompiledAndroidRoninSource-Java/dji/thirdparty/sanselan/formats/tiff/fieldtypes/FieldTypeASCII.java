package dji.thirdparty.sanselan.formats.tiff.fieldtypes;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.TiffField;

public class FieldTypeASCII
  extends FieldType
{
  public FieldTypeASCII(int paramInt, String paramString)
  {
    super(paramInt, 1, paramString);
  }
  
  public Object getSimpleValue(TiffField paramTiffField)
  {
    return null;
  }
  
  public byte[] writeData(Object paramObject, int paramInt)
    throws ImageWriteException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\fieldtypes\FieldTypeASCII.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */