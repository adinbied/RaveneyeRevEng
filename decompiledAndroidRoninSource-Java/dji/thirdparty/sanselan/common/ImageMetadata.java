package dji.thirdparty.sanselan.common;

import java.util.ArrayList;

public class ImageMetadata
  implements IImageMetadata
{
  protected static final String newline = System.getProperty("line.separator");
  private final ArrayList items = new ArrayList();
  
  public void add(IImageMetadata.IImageMetadataItem paramIImageMetadataItem)
  {
    this.items.add(paramIImageMetadataItem);
  }
  
  /* Error */
  public void add(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ArrayList getItems()
  {
    return new ArrayList(this.items);
  }
  
  public String toString()
  {
    return toString(null);
  }
  
  public String toString(String paramString)
  {
    return null;
  }
  
  public static class Item
    implements IImageMetadata.IImageMetadataItem
  {
    private final String keyword;
    private final String text;
    
    public Item(String paramString1, String paramString2)
    {
      this.keyword = paramString1;
      this.text = paramString2;
    }
    
    public String getKeyword()
    {
      return this.keyword;
    }
    
    public String getText()
    {
      return this.text;
    }
    
    public String toString()
    {
      return toString(null);
    }
    
    public String toString(String paramString)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\common\ImageMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */