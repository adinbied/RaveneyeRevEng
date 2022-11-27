package com.drew.imaging;

public enum FileType
{
  static
  {
    Jpeg = new FileType("Jpeg", 1);
    Tiff = new FileType("Tiff", 2);
    Psd = new FileType("Psd", 3);
    Png = new FileType("Png", 4);
    Bmp = new FileType("Bmp", 5);
    Gif = new FileType("Gif", 6);
    Ico = new FileType("Ico", 7);
    Pcx = new FileType("Pcx", 8);
    Riff = new FileType("Riff", 9);
    Arw = new FileType("Arw", 10);
    Crw = new FileType("Crw", 11);
    Cr2 = new FileType("Cr2", 12);
    Nef = new FileType("Nef", 13);
    Orf = new FileType("Orf", 14);
    Raf = new FileType("Raf", 15);
    FileType localFileType = new FileType("Rw2", 16);
    Rw2 = localFileType;
    $VALUES = new FileType[] { Unknown, Jpeg, Tiff, Psd, Png, Bmp, Gif, Ico, Pcx, Riff, Arw, Crw, Cr2, Nef, Orf, Raf, localFileType };
  }
  
  private FileType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\FileType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */