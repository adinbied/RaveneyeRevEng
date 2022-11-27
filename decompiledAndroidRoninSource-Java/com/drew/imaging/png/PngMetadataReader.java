package com.drew.imaging.png;

import com.drew.lang.ByteConvert;
import com.drew.lang.Charsets;
import com.drew.lang.DateUtil;
import com.drew.lang.KeyValuePair;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.lang.StreamReader;
import com.drew.lang.StreamUtil;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.file.FileMetadataReader;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.png.PngChromaticitiesDirectory;
import com.drew.metadata.png.PngDirectory;
import com.drew.metadata.xmp.XmpReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public class PngMetadataReader
{
  private static Set<PngChunkType> _desiredChunkTypes;
  private static Charset _latin1Encoding = Charsets.ISO_8859_1;
  
  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(PngChunkType.IHDR);
    localHashSet.add(PngChunkType.PLTE);
    localHashSet.add(PngChunkType.tRNS);
    localHashSet.add(PngChunkType.cHRM);
    localHashSet.add(PngChunkType.sRGB);
    localHashSet.add(PngChunkType.gAMA);
    localHashSet.add(PngChunkType.iCCP);
    localHashSet.add(PngChunkType.bKGD);
    localHashSet.add(PngChunkType.tEXt);
    localHashSet.add(PngChunkType.zTXt);
    localHashSet.add(PngChunkType.iTXt);
    localHashSet.add(PngChunkType.tIME);
    localHashSet.add(PngChunkType.pHYs);
    localHashSet.add(PngChunkType.sBIT);
    _desiredChunkTypes = Collections.unmodifiableSet(localHashSet);
  }
  
  private static void processChunk(Metadata paramMetadata, PngChunk paramPngChunk)
    throws PngProcessingException, IOException
  {
    Object localObject1 = paramPngChunk.getType();
    paramPngChunk = paramPngChunk.getBytes();
    if (((PngChunkType)localObject1).equals(PngChunkType.IHDR))
    {
      paramPngChunk = new PngHeader(paramPngChunk);
      localObject1 = new PngDirectory(PngChunkType.IHDR);
      ((PngDirectory)localObject1).setInt(1, paramPngChunk.getImageWidth());
      ((PngDirectory)localObject1).setInt(2, paramPngChunk.getImageHeight());
      ((PngDirectory)localObject1).setInt(3, paramPngChunk.getBitsPerSample());
      ((PngDirectory)localObject1).setInt(4, paramPngChunk.getColorType().getNumericValue());
      ((PngDirectory)localObject1).setInt(5, paramPngChunk.getCompressionType() & 0xFF);
      ((PngDirectory)localObject1).setInt(6, paramPngChunk.getFilterMethod());
      ((PngDirectory)localObject1).setInt(7, paramPngChunk.getInterlaceMethod());
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.PLTE))
    {
      localObject1 = new PngDirectory(PngChunkType.PLTE);
      ((PngDirectory)localObject1).setInt(8, paramPngChunk.length / 3);
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.tRNS))
    {
      paramPngChunk = new PngDirectory(PngChunkType.tRNS);
      paramPngChunk.setInt(9, 1);
      paramMetadata.addDirectory(paramPngChunk);
      return;
    }
    int i;
    if (((PngChunkType)localObject1).equals(PngChunkType.sRGB))
    {
      i = paramPngChunk[0];
      paramPngChunk = new PngDirectory(PngChunkType.sRGB);
      paramPngChunk.setInt(10, i);
      paramMetadata.addDirectory(paramPngChunk);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.cHRM))
    {
      paramPngChunk = new PngChromaticities(paramPngChunk);
      localObject1 = new PngChromaticitiesDirectory();
      ((PngChromaticitiesDirectory)localObject1).setInt(1, paramPngChunk.getWhitePointX());
      ((PngChromaticitiesDirectory)localObject1).setInt(2, paramPngChunk.getWhitePointY());
      ((PngChromaticitiesDirectory)localObject1).setInt(3, paramPngChunk.getRedX());
      ((PngChromaticitiesDirectory)localObject1).setInt(4, paramPngChunk.getRedY());
      ((PngChromaticitiesDirectory)localObject1).setInt(5, paramPngChunk.getGreenX());
      ((PngChromaticitiesDirectory)localObject1).setInt(6, paramPngChunk.getGreenY());
      ((PngChromaticitiesDirectory)localObject1).setInt(7, paramPngChunk.getBlueX());
      ((PngChromaticitiesDirectory)localObject1).setInt(8, paramPngChunk.getBlueY());
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.gAMA))
    {
      i = ByteConvert.toInt32BigEndian(paramPngChunk);
      new SequentialByteArrayReader(paramPngChunk).getInt32();
      paramPngChunk = new PngDirectory(PngChunkType.gAMA);
      paramPngChunk.setDouble(11, i / 100000.0D);
      paramMetadata.addDirectory(paramPngChunk);
      return;
    }
    Object localObject2;
    Object localObject3;
    if (((PngChunkType)localObject1).equals(PngChunkType.iCCP))
    {
      localObject2 = new SequentialByteArrayReader(paramPngChunk);
      localObject3 = ((SequentialReader)localObject2).getNullTerminatedBytes(80);
      localObject1 = new PngDirectory(PngChunkType.iCCP);
      ((PngDirectory)localObject1).setStringValue(12, new StringValue((byte[])localObject3, _latin1Encoding));
      if (((SequentialReader)localObject2).getInt8() == 0)
      {
        paramPngChunk = ((SequentialReader)localObject2).getBytes(paramPngChunk.length - (localObject3.length + 1 + 1));
        try
        {
          paramPngChunk = new InflaterInputStream(new ByteArrayInputStream(paramPngChunk));
          new IccReader().extract(new RandomAccessStreamReader(paramPngChunk), paramMetadata, (Directory)localObject1);
          paramPngChunk.close();
        }
        catch (ZipException paramPngChunk)
        {
          ((PngDirectory)localObject1).addError(String.format("Exception decompressing PNG iCCP chunk : %s", new Object[] { paramPngChunk.getMessage() }));
          paramMetadata.addDirectory((Directory)localObject1);
        }
      }
      else
      {
        ((PngDirectory)localObject1).addError("Invalid compression method value");
      }
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.bKGD))
    {
      localObject1 = new PngDirectory(PngChunkType.bKGD);
      ((PngDirectory)localObject1).setByteArray(15, paramPngChunk);
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    if (((PngChunkType)localObject1).equals(PngChunkType.tEXt))
    {
      localObject2 = new SequentialByteArrayReader(paramPngChunk);
      localObject3 = ((SequentialReader)localObject2).getNullTerminatedStringValue(80, _latin1Encoding);
      localObject1 = ((StringValue)localObject3).toString();
      localObject2 = ((SequentialReader)localObject2).getNullTerminatedStringValue(paramPngChunk.length - (((StringValue)localObject3).getBytes().length + 1), _latin1Encoding);
      paramPngChunk = new ArrayList();
      paramPngChunk.add(new KeyValuePair((String)localObject1, (StringValue)localObject2));
      localObject1 = new PngDirectory(PngChunkType.tEXt);
      ((PngDirectory)localObject1).setObject(13, paramPngChunk);
      paramMetadata.addDirectory((Directory)localObject1);
      return;
    }
    int j;
    if (((PngChunkType)localObject1).equals(PngChunkType.zTXt))
    {
      localObject2 = new SequentialByteArrayReader(paramPngChunk);
      localObject3 = ((SequentialReader)localObject2).getNullTerminatedStringValue(80, _latin1Encoding);
      localObject1 = ((StringValue)localObject3).toString();
      i = ((SequentialReader)localObject2).getInt8();
      j = paramPngChunk.length - (((StringValue)localObject3).getBytes().length + 1 + 1);
      if (i == 0)
      {
        try
        {
          paramPngChunk = StreamUtil.readAllBytes(new InflaterInputStream(new ByteArrayInputStream(paramPngChunk, paramPngChunk.length - j, j)));
        }
        catch (ZipException paramPngChunk)
        {
          localObject2 = new PngDirectory(PngChunkType.zTXt);
          ((PngDirectory)localObject2).addError(String.format("Exception decompressing PNG zTXt chunk with keyword \"%s\": %s", new Object[] { localObject1, paramPngChunk.getMessage() }));
          paramMetadata.addDirectory((Directory)localObject2);
          break label910;
        }
      }
      else
      {
        paramPngChunk = new PngDirectory(PngChunkType.zTXt);
        paramPngChunk.addError("Invalid compression method value");
        paramMetadata.addDirectory(paramPngChunk);
      }
      label910:
      paramPngChunk = null;
      if (paramPngChunk != null)
      {
        if (((String)localObject1).equals("XML:com.adobe.xmp"))
        {
          new XmpReader().extract(paramPngChunk, paramMetadata);
          return;
        }
        localObject2 = new ArrayList();
        ((List)localObject2).add(new KeyValuePair((String)localObject1, new StringValue(paramPngChunk, _latin1Encoding)));
        paramPngChunk = new PngDirectory(PngChunkType.zTXt);
        paramPngChunk.setObject(13, localObject2);
        paramMetadata.addDirectory(paramPngChunk);
      }
    }
    else
    {
      int k;
      if (((PngChunkType)localObject1).equals(PngChunkType.iTXt))
      {
        localObject2 = new SequentialByteArrayReader(paramPngChunk);
        localObject3 = ((SequentialReader)localObject2).getNullTerminatedStringValue(80, _latin1Encoding);
        localObject1 = ((StringValue)localObject3).toString();
        i = ((SequentialReader)localObject2).getInt8();
        j = ((SequentialReader)localObject2).getInt8();
        byte[] arrayOfByte1 = ((SequentialReader)localObject2).getNullTerminatedBytes(paramPngChunk.length);
        byte[] arrayOfByte2 = ((SequentialReader)localObject2).getNullTerminatedBytes(paramPngChunk.length);
        k = paramPngChunk.length - (((StringValue)localObject3).getBytes().length + 1 + 1 + 1 + arrayOfByte1.length + 1 + arrayOfByte2.length + 1);
        if (i == 0)
        {
          paramPngChunk = ((SequentialReader)localObject2).getNullTerminatedBytes(k);
        }
        else
        {
          if (i == 1)
          {
            if (j == 0)
            {
              try
              {
                paramPngChunk = StreamUtil.readAllBytes(new InflaterInputStream(new ByteArrayInputStream(paramPngChunk, paramPngChunk.length - k, k)));
              }
              catch (ZipException paramPngChunk)
              {
                localObject2 = new PngDirectory(PngChunkType.iTXt);
                ((PngDirectory)localObject2).addError(String.format("Exception decompressing PNG iTXt chunk with keyword \"%s\": %s", new Object[] { localObject1, paramPngChunk.getMessage() }));
                paramMetadata.addDirectory((Directory)localObject2);
                break label1252;
              }
            }
            else
            {
              paramPngChunk = new PngDirectory(PngChunkType.iTXt);
              paramPngChunk.addError("Invalid compression method value");
              paramMetadata.addDirectory(paramPngChunk);
            }
          }
          else
          {
            paramPngChunk = new PngDirectory(PngChunkType.iTXt);
            paramPngChunk.addError("Invalid compression flag value");
            paramMetadata.addDirectory(paramPngChunk);
          }
          label1252:
          paramPngChunk = null;
        }
        if (paramPngChunk != null)
        {
          if (((String)localObject1).equals("XML:com.adobe.xmp"))
          {
            new XmpReader().extract(paramPngChunk, paramMetadata);
            return;
          }
          localObject2 = new ArrayList();
          ((List)localObject2).add(new KeyValuePair((String)localObject1, new StringValue(paramPngChunk, _latin1Encoding)));
          paramPngChunk = new PngDirectory(PngChunkType.iTXt);
          paramPngChunk.setObject(13, localObject2);
          paramMetadata.addDirectory(paramPngChunk);
        }
      }
      else
      {
        if (((PngChunkType)localObject1).equals(PngChunkType.tIME))
        {
          paramPngChunk = new SequentialByteArrayReader(paramPngChunk);
          i = paramPngChunk.getUInt16();
          j = paramPngChunk.getUInt8();
          k = paramPngChunk.getUInt8();
          int m = paramPngChunk.getUInt8();
          int n = paramPngChunk.getUInt8();
          int i1 = paramPngChunk.getUInt8();
          paramPngChunk = new PngDirectory(PngChunkType.tIME);
          if ((DateUtil.isValidDate(i, j - 1, k)) && (DateUtil.isValidTime(m, n, i1))) {
            paramPngChunk.setString(14, String.format("%04d:%02d:%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
          } else {
            paramPngChunk.addError(String.format("PNG tIME data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) }));
          }
          paramMetadata.addDirectory(paramPngChunk);
          return;
        }
        if (((PngChunkType)localObject1).equals(PngChunkType.pHYs))
        {
          paramPngChunk = new SequentialByteArrayReader(paramPngChunk);
          i = paramPngChunk.getInt32();
          j = paramPngChunk.getInt32();
          k = paramPngChunk.getInt8();
          paramPngChunk = new PngDirectory(PngChunkType.pHYs);
          paramPngChunk.setInt(16, i);
          paramPngChunk.setInt(17, j);
          paramPngChunk.setInt(18, k);
          paramMetadata.addDirectory(paramPngChunk);
          return;
        }
        if (((PngChunkType)localObject1).equals(PngChunkType.sBIT))
        {
          localObject1 = new PngDirectory(PngChunkType.sBIT);
          ((PngDirectory)localObject1).setByteArray(19, paramPngChunk);
          paramMetadata.addDirectory((Directory)localObject1);
        }
      }
    }
  }
  
  public static Metadata readMetadata(File paramFile)
    throws PngProcessingException, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Metadata localMetadata = readMetadata(localFileInputStream);
      localFileInputStream.close();
      new FileMetadataReader().read(paramFile, localMetadata);
      return localMetadata;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
    throws PngProcessingException, IOException
  {
    Object localObject = new PngChunkReader().extract(new StreamReader(paramInputStream), _desiredChunkTypes);
    paramInputStream = new Metadata();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PngChunk localPngChunk = (PngChunk)((Iterator)localObject).next();
      try
      {
        processChunk(paramInputStream, localPngChunk);
      }
      catch (Exception localException)
      {
        localException.printStackTrace(System.err);
      }
    }
    return paramInputStream;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\png\PngMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */