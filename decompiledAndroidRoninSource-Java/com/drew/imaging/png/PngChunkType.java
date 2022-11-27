package com.drew.imaging.png;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PngChunkType
{
  public static final PngChunkType IDAT;
  public static final PngChunkType IEND;
  public static final PngChunkType IHDR;
  public static final PngChunkType PLTE;
  private static final Set<String> _identifiersAllowingMultiples = new HashSet(Arrays.asList(new String[] { "IDAT", "sPLT", "iTXt", "tEXt", "zTXt" }));
  public static final PngChunkType bKGD;
  public static final PngChunkType cHRM;
  public static final PngChunkType gAMA;
  public static final PngChunkType hIST;
  public static final PngChunkType iCCP;
  public static final PngChunkType iTXt;
  public static final PngChunkType pHYs;
  public static final PngChunkType sBIT;
  public static final PngChunkType sPLT;
  public static final PngChunkType sRGB;
  public static final PngChunkType tEXt;
  public static final PngChunkType tIME;
  public static final PngChunkType tRNS;
  public static final PngChunkType zTXt;
  private final byte[] _bytes;
  private final boolean _multipleAllowed;
  
  static
  {
    try
    {
      IHDR = new PngChunkType("IHDR");
      PLTE = new PngChunkType("PLTE");
      IDAT = new PngChunkType("IDAT", true);
      IEND = new PngChunkType("IEND");
      cHRM = new PngChunkType("cHRM");
      gAMA = new PngChunkType("gAMA");
      iCCP = new PngChunkType("iCCP");
      sBIT = new PngChunkType("sBIT");
      sRGB = new PngChunkType("sRGB");
      bKGD = new PngChunkType("bKGD");
      hIST = new PngChunkType("hIST");
      tRNS = new PngChunkType("tRNS");
      pHYs = new PngChunkType("pHYs");
      sPLT = new PngChunkType("sPLT", true);
      tIME = new PngChunkType("tIME");
      iTXt = new PngChunkType("iTXt", true);
      tEXt = new PngChunkType("tEXt", true);
      zTXt = new PngChunkType("zTXt", true);
      return;
    }
    catch (PngProcessingException localPngProcessingException)
    {
      throw new IllegalArgumentException(localPngProcessingException);
    }
  }
  
  public PngChunkType(String paramString)
    throws PngProcessingException
  {
    this(paramString, false);
  }
  
  public PngChunkType(String paramString, boolean paramBoolean)
    throws PngProcessingException
  {
    this._multipleAllowed = paramBoolean;
    try
    {
      paramString = paramString.getBytes("ASCII");
      validateBytes(paramString);
      this._bytes = paramString;
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Unable to convert string code to bytes.");
  }
  
  public PngChunkType(byte[] paramArrayOfByte)
    throws PngProcessingException
  {
    validateBytes(paramArrayOfByte);
    this._bytes = paramArrayOfByte;
    this._multipleAllowed = _identifiersAllowingMultiples.contains(getIdentifier());
  }
  
  private static boolean isLowerCase(byte paramByte)
  {
    return (paramByte & 0x20) != 0;
  }
  
  private static boolean isUpperCase(byte paramByte)
  {
    return (paramByte & 0x20) == 0;
  }
  
  private static boolean isValidByte(byte paramByte)
  {
    return ((paramByte >= 65) && (paramByte <= 90)) || ((paramByte >= 97) && (paramByte <= 122));
  }
  
  private static void validateBytes(byte[] paramArrayOfByte)
    throws PngProcessingException
  {
    if (paramArrayOfByte.length == 4)
    {
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j) {
        if (isValidByte(paramArrayOfByte[i])) {
          i += 1;
        } else {
          throw new PngProcessingException("PNG chunk type identifier may only contain alphabet characters");
        }
      }
      return;
    }
    throw new PngProcessingException("PNG chunk type identifier must be four bytes in length");
  }
  
  public boolean areMultipleAllowed()
  {
    return this._multipleAllowed;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getIdentifier()
  {
    return null;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this._bytes);
  }
  
  public boolean isAncillary()
  {
    return isCritical() ^ true;
  }
  
  public boolean isCritical()
  {
    return false;
  }
  
  public boolean isPrivate()
  {
    return false;
  }
  
  public boolean isSafeToCopy()
  {
    return false;
  }
  
  public String toString()
  {
    return getIdentifier();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngChunkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */