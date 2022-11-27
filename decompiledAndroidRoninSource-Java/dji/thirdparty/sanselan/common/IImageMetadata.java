package dji.thirdparty.sanselan.common;

import java.util.ArrayList;

public abstract interface IImageMetadata
{
  public abstract ArrayList getItems();
  
  public abstract String toString(String paramString);
  
  public static abstract interface IImageMetadataItem
  {
    public abstract String toString();
    
    public abstract String toString(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\IImageMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */