package dji.thirdparty.sanselan.formats.tiff;

public class TiffHeader
  extends TiffElement
{
  public final int byteOrder;
  public final int offsetToFirstIFD;
  public final int tiffVersion;
  
  public TiffHeader(int paramInt1, int paramInt2, int paramInt3)
  {
    super(0, 8);
    this.byteOrder = paramInt1;
    this.tiffVersion = paramInt2;
    this.offsetToFirstIFD = paramInt3;
  }
  
  public String getElementDescription(boolean paramBoolean)
  {
    if (paramBoolean) {
      return null;
    }
    return "TIFF Header";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\formats\tiff\TiffHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */