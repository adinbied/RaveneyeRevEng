package dji.thirdparty.sanselan.formats.tiff.fieldtypes;

import dji.thirdparty.sanselan.ImageWriteException;
import dji.thirdparty.sanselan.formats.tiff.TiffField;

public class FieldTypeRational
  extends FieldType
{
  public FieldTypeRational(int paramInt, String paramString)
  {
    super(paramInt, 8, paramString);
  }
  
  public Object getSimpleValue(TiffField paramTiffField)
  {
    return null;
  }
  
  public byte[] writeData(int paramInt1, int paramInt2, int paramInt3)
    throws ImageWriteException
  {
    return null;
  }
  
  public byte[] writeData(Object paramObject, int paramInt)
    throws ImageWriteException
  {
    return null;
  }
  
  public byte[] writeData(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
    throws ImageWriteException
  {
    return convertIntArrayToRationalArray(paramArrayOfInt1, paramArrayOfInt2, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\fieldtypes\FieldTypeRational.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */