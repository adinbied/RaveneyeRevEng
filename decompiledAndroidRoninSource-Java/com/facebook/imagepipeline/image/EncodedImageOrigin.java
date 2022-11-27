package com.facebook.imagepipeline.image;

public enum EncodedImageOrigin
{
  private final String mOrigin;
  
  static
  {
    NETWORK = new EncodedImageOrigin("NETWORK", 1, "network");
    DISK = new EncodedImageOrigin("DISK", 2, "disk");
    EncodedImageOrigin localEncodedImageOrigin = new EncodedImageOrigin("ENCODED_MEM_CACHE", 3, "encoded_mem_cache");
    ENCODED_MEM_CACHE = localEncodedImageOrigin;
    $VALUES = new EncodedImageOrigin[] { NOT_SET, NETWORK, DISK, localEncodedImageOrigin };
  }
  
  private EncodedImageOrigin(String paramString)
  {
    this.mOrigin = paramString;
  }
  
  public String toString()
  {
    return this.mOrigin;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\EncodedImageOrigin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */