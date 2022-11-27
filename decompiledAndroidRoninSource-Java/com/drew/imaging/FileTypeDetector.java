package com.drew.imaging;

import com.drew.lang.ByteTrie;
import java.io.BufferedInputStream;
import java.io.IOException;

public class FileTypeDetector
{
  private static final ByteTrie<FileType> _root;
  
  static
  {
    ByteTrie localByteTrie = new ByteTrie();
    _root = localByteTrie;
    localByteTrie.setDefaultValue(FileType.Unknown);
    _root.addPath(FileType.Jpeg, new byte[][] { { -1, -40 } });
    _root.addPath(FileType.Tiff, new byte[][] { "II".getBytes(), { 42, 0 } });
    _root.addPath(FileType.Tiff, new byte[][] { "MM".getBytes(), { 0, 42 } });
    _root.addPath(FileType.Psd, new byte[][] { "8BPS".getBytes() });
    _root.addPath(FileType.Png, new byte[][] { { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82 } });
    _root.addPath(FileType.Bmp, new byte[][] { "BM".getBytes() });
    _root.addPath(FileType.Gif, new byte[][] { "GIF87a".getBytes() });
    _root.addPath(FileType.Gif, new byte[][] { "GIF89a".getBytes() });
    _root.addPath(FileType.Ico, new byte[][] { { 0, 0, 1, 0 } });
    _root.addPath(FileType.Pcx, new byte[][] { { 10, 0, 1 } });
    _root.addPath(FileType.Pcx, new byte[][] { { 10, 2, 1 } });
    _root.addPath(FileType.Pcx, new byte[][] { { 10, 3, 1 } });
    _root.addPath(FileType.Pcx, new byte[][] { { 10, 5, 1 } });
    _root.addPath(FileType.Riff, new byte[][] { "RIFF".getBytes() });
    _root.addPath(FileType.Arw, new byte[][] { "II".getBytes(), { 42, 0, 8, 0 } });
    _root.addPath(FileType.Crw, new byte[][] { "II".getBytes(), { 26, 0, 0, 0 }, "HEAPCCDR".getBytes() });
    _root.addPath(FileType.Cr2, new byte[][] { "II".getBytes(), { 42, 0, 16, 0, 0, 0, 67, 82 } });
    _root.addPath(FileType.Nef, new byte[][] { "MM".getBytes(), { 0, 42, 0, 0, 0, -128, 0 } });
    _root.addPath(FileType.Orf, new byte[][] { "IIRO".getBytes(), { 8, 0 } });
    _root.addPath(FileType.Orf, new byte[][] { "MMOR".getBytes(), { 0, 0 } });
    _root.addPath(FileType.Orf, new byte[][] { "IIRS".getBytes(), { 8, 0 } });
    _root.addPath(FileType.Raf, new byte[][] { "FUJIFILMCCD-RAW".getBytes() });
    _root.addPath(FileType.Rw2, new byte[][] { "II".getBytes(), { 85, 0 } });
  }
  
  private FileTypeDetector()
    throws Exception
  {
    throw new Exception("Not intended for instantiation");
  }
  
  public static FileType detectFileType(BufferedInputStream paramBufferedInputStream)
    throws IOException
  {
    if (paramBufferedInputStream.markSupported())
    {
      int i = _root.getMaxDepth();
      paramBufferedInputStream.mark(i);
      byte[] arrayOfByte = new byte[i];
      if (paramBufferedInputStream.read(arrayOfByte) != -1)
      {
        paramBufferedInputStream.reset();
        return (FileType)_root.find(arrayOfByte);
      }
      throw new IOException("Stream ended before file's magic number could be determined.");
    }
    throw new IOException("Stream must support mark/reset");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\FileTypeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */