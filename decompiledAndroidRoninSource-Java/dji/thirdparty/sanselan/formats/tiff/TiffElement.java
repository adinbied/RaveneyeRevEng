package dji.thirdparty.sanselan.formats.tiff;

import java.util.Comparator;

public abstract class TiffElement
{
  public static final Comparator COMPARATOR = new Comparator()
  {
    public int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
    {
      paramAnonymousObject1 = (TiffElement)paramAnonymousObject1;
      paramAnonymousObject2 = (TiffElement)paramAnonymousObject2;
      return ((TiffElement)paramAnonymousObject1).offset - ((TiffElement)paramAnonymousObject2).offset;
    }
  };
  public final int length;
  public final int offset;
  
  public TiffElement(int paramInt1, int paramInt2)
  {
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  public String getElementDescription()
  {
    return getElementDescription(false);
  }
  
  public abstract String getElementDescription(boolean paramBoolean);
  
  public static abstract class DataElement
    extends TiffElement
  {
    public final byte[] data;
    
    public DataElement(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      super(paramInt2);
      this.data = paramArrayOfByte;
    }
  }
  
  public static final class Stub
    extends TiffElement
  {
    public Stub(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public String getElementDescription(boolean paramBoolean)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */