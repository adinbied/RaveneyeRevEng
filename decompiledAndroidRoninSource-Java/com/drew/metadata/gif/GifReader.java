package com.drew.metadata.gif;

import com.drew.lang.ByteArrayReader;
import com.drew.lang.Charsets;
import com.drew.lang.SequentialReader;
import com.drew.metadata.Directory;
import com.drew.metadata.ErrorDirectory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.xmp.XmpReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GifReader
{
  private static final String GIF_87A_VERSION_IDENTIFIER = "87a";
  private static final String GIF_89A_VERSION_IDENTIFIER = "89a";
  
  private static byte[] gatherBytes(SequentialReader paramSequentialReader)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['ā'];
    for (;;)
    {
      int i = paramSequentialReader.getByte();
      if (i == 0) {
        return localByteArrayOutputStream.toByteArray();
      }
      int j = i & 0xFF;
      arrayOfByte[0] = i;
      paramSequentialReader.getBytes(arrayOfByte, 1, j);
      localByteArrayOutputStream.write(arrayOfByte, 0, j + 1);
    }
  }
  
  private static byte[] gatherBytes(SequentialReader paramSequentialReader, int paramInt)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (paramInt > 0)
    {
      localByteArrayOutputStream.write(paramSequentialReader.getBytes(paramInt), 0, paramInt);
      paramInt = paramSequentialReader.getByte();
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static void readApplicationExtensionBlock(SequentialReader paramSequentialReader, int paramInt, Metadata paramMetadata)
    throws IOException
  {
    if (paramInt != 11)
    {
      paramMetadata.addDirectory(new ErrorDirectory(String.format("Invalid GIF application extension block size. Expected 11, got %d.", new Object[] { Integer.valueOf(paramInt) })));
      return;
    }
    String str = paramSequentialReader.getString(paramInt, Charsets.UTF_8);
    if (str.equals("XMP DataXMP"))
    {
      paramSequentialReader = gatherBytes(paramSequentialReader);
      new XmpReader().extract(paramSequentialReader, 0, paramSequentialReader.length - 257, paramMetadata, null);
      return;
    }
    if (str.equals("ICCRGBG1012"))
    {
      paramSequentialReader = gatherBytes(paramSequentialReader, paramSequentialReader.getByte());
      if (paramSequentialReader.length != 0) {
        new IccReader().extract(new ByteArrayReader(paramSequentialReader), paramMetadata);
      }
    }
    else
    {
      if (str.equals("NETSCAPE2.0"))
      {
        paramSequentialReader.skip(2L);
        paramInt = paramSequentialReader.getUInt16();
        paramSequentialReader.skip(1L);
        paramSequentialReader = new GifAnimationDirectory();
        paramSequentialReader.setInt(1, paramInt);
        paramMetadata.addDirectory(paramSequentialReader);
        return;
      }
      skipBlocks(paramSequentialReader);
    }
  }
  
  private static GifCommentDirectory readCommentBlock(SequentialReader paramSequentialReader, int paramInt)
    throws IOException
  {
    return new GifCommentDirectory(new StringValue(gatherBytes(paramSequentialReader, paramInt), Charsets.ASCII));
  }
  
  private static GifControlDirectory readControlBlock(SequentialReader paramSequentialReader, int paramInt)
    throws IOException
  {
    GifControlDirectory localGifControlDirectory = new GifControlDirectory();
    paramInt = paramSequentialReader.getUInt8();
    localGifControlDirectory.setObject(2, GifControlDirectory.DisposalMethod.typeOf(paramInt >> 2 & 0x7));
    boolean bool2 = false;
    if ((paramInt & 0x2) >> 1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGifControlDirectory.setBoolean(3, bool1);
    boolean bool1 = bool2;
    if ((paramInt & 0x1) == 1) {
      bool1 = true;
    }
    localGifControlDirectory.setBoolean(4, bool1);
    localGifControlDirectory.setInt(1, paramSequentialReader.getUInt16());
    localGifControlDirectory.setInt(5, paramSequentialReader.getUInt8());
    paramSequentialReader.skip(1L);
    return localGifControlDirectory;
  }
  
  private static void readGifExtensionBlock(SequentialReader paramSequentialReader, Metadata paramMetadata)
    throws IOException
  {
    byte b = paramSequentialReader.getInt8();
    int i = paramSequentialReader.getUInt8();
    long l = paramSequentialReader.getPosition();
    if (b != -7)
    {
      if (b != 1)
      {
        if (b != -2)
        {
          if (b != -1) {
            paramMetadata.addDirectory(new ErrorDirectory(String.format("Unsupported GIF extension block with type 0x%02X.", new Object[] { Byte.valueOf(b) })));
          } else {
            readApplicationExtensionBlock(paramSequentialReader, i, paramMetadata);
          }
        }
        else {
          paramMetadata.addDirectory(readCommentBlock(paramSequentialReader, i));
        }
      }
      else
      {
        Directory localDirectory = readPlainTextBlock(paramSequentialReader, i);
        if (localDirectory != null) {
          paramMetadata.addDirectory(localDirectory);
        }
      }
    }
    else {
      paramMetadata.addDirectory(readControlBlock(paramSequentialReader, i));
    }
    l = l + i - paramSequentialReader.getPosition();
    if (l > 0L) {
      paramSequentialReader.skip(l);
    }
  }
  
  private static GifHeaderDirectory readGifHeader(SequentialReader paramSequentialReader)
    throws IOException
  {
    GifHeaderDirectory localGifHeaderDirectory = new GifHeaderDirectory();
    if (!paramSequentialReader.getString(3).equals("GIF"))
    {
      localGifHeaderDirectory.addError("Invalid GIF file signature");
      return localGifHeaderDirectory;
    }
    String str = paramSequentialReader.getString(3);
    if ((!str.equals("87a")) && (!str.equals("89a")))
    {
      localGifHeaderDirectory.addError("Unexpected GIF version");
      return localGifHeaderDirectory;
    }
    boolean bool2 = true;
    localGifHeaderDirectory.setString(1, str);
    localGifHeaderDirectory.setInt(2, paramSequentialReader.getUInt16());
    localGifHeaderDirectory.setInt(3, paramSequentialReader.getUInt16());
    int i = paramSequentialReader.getUInt8();
    boolean bool1;
    if ((i & 0xF) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGifHeaderDirectory.setInt(4, 1 << (i & 0x7) + 1);
    if (str.equals("89a"))
    {
      if ((i & 0x8) == 0) {
        bool2 = false;
      }
      localGifHeaderDirectory.setBoolean(5, bool2);
    }
    localGifHeaderDirectory.setInt(6, ((i & 0x70) >> 4) + 1);
    localGifHeaderDirectory.setBoolean(7, bool1);
    localGifHeaderDirectory.setInt(8, paramSequentialReader.getUInt8());
    i = paramSequentialReader.getUInt8();
    if (i != 0) {
      localGifHeaderDirectory.setFloat(9, (float)((i + 15.0D) / 64.0D));
    }
    return localGifHeaderDirectory;
  }
  
  private static GifImageDirectory readImageBlock(SequentialReader paramSequentialReader)
    throws IOException
  {
    GifImageDirectory localGifImageDirectory = new GifImageDirectory();
    int i = paramSequentialReader.getUInt16();
    boolean bool3 = true;
    localGifImageDirectory.setInt(1, i);
    localGifImageDirectory.setInt(2, paramSequentialReader.getUInt16());
    localGifImageDirectory.setInt(3, paramSequentialReader.getUInt16());
    localGifImageDirectory.setInt(4, paramSequentialReader.getUInt16());
    i = paramSequentialReader.getByte();
    int j = i & 0x7;
    boolean bool1;
    if (j != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((i & 0x40) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((i & 0x20) == 0) {
      bool3 = false;
    }
    localGifImageDirectory.setBoolean(5, bool1);
    localGifImageDirectory.setBoolean(6, bool2);
    if (bool1)
    {
      localGifImageDirectory.setBoolean(7, bool3);
      localGifImageDirectory.setInt(8, j + 1);
      paramSequentialReader.skip((2 << j) * 3);
    }
    paramSequentialReader.getByte();
    return localGifImageDirectory;
  }
  
  private static Directory readPlainTextBlock(SequentialReader paramSequentialReader, int paramInt)
    throws IOException
  {
    if (paramInt != 12) {
      return new ErrorDirectory(String.format("Invalid GIF plain text block size. Expected 12, got %d.", new Object[] { Integer.valueOf(paramInt) }));
    }
    paramSequentialReader.skip(12L);
    skipBlocks(paramSequentialReader);
    return null;
  }
  
  private static void skipBlocks(SequentialReader paramSequentialReader)
    throws IOException
  {
    for (;;)
    {
      int i = paramSequentialReader.getUInt8();
      if (i == 0) {
        return;
      }
      paramSequentialReader.skip(i);
    }
  }
  
  /* Error */
  public void extract(SequentialReader arg1, Metadata arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\gif\GifReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */