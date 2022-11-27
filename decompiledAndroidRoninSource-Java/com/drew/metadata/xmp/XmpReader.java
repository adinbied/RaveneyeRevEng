package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.properties.XMPPropertyInfo;
import com.drew.imaging.jpeg.JpegSegmentMetadataReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.SequentialReader;
import com.drew.metadata.Metadata;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class XmpReader
  implements JpegSegmentMetadataReader
{
  private static final String ATTRIBUTE_EXTENDED_XMP = "xmpNote:HasExtendedXMP";
  private static final int EXTENDED_XMP_GUID_LENGTH = 32;
  private static final int EXTENDED_XMP_INT_LENGTH = 4;
  private static final String SCHEMA_XMP_NOTES = "http://ns.adobe.com/xmp/note/";
  private static final String XMP_EXTENSION_JPEG_PREAMBLE = "http://ns.adobe.com/xmp/extension/\000";
  private static final String XMP_JPEG_PREAMBLE = "http://ns.adobe.com/xap/1.0/\000";
  
  private static String getExtendedXMPGUID(Metadata paramMetadata)
  {
    paramMetadata = paramMetadata.getDirectoriesOfType(XmpDirectory.class).iterator();
    while (paramMetadata.hasNext())
    {
      Object localObject = ((XmpDirectory)paramMetadata.next()).getXMPMeta();
      try
      {
        localObject = ((XMPMeta)localObject).iterator("http://ns.adobe.com/xmp/note/", null, null);
        if (localObject != null)
        {
          XMPPropertyInfo localXMPPropertyInfo;
          do
          {
            if (!((XMPIterator)localObject).hasNext()) {
              break;
            }
            localXMPPropertyInfo = (XMPPropertyInfo)((XMPIterator)localObject).next();
          } while (!"xmpNote:HasExtendedXMP".equals(localXMPPropertyInfo.getPath()));
          localObject = localXMPPropertyInfo.getValue();
          return (String)localObject;
        }
      }
      catch (XMPException localXMPException)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  private static byte[] processExtendedXMPChunk(Metadata paramMetadata, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    Object localObject2 = paramArrayOfByte2;
    if (i >= 75)
    {
      Object localObject1 = paramArrayOfByte2;
      try
      {
        SequentialByteArrayReader localSequentialByteArrayReader = new SequentialByteArrayReader(paramArrayOfByte1);
        localObject1 = paramArrayOfByte2;
        localSequentialByteArrayReader.skip(35);
        localObject1 = paramArrayOfByte2;
        localObject2 = paramArrayOfByte2;
        if (paramString.equals(localSequentialByteArrayReader.getString(32)))
        {
          localObject1 = paramArrayOfByte2;
          int j = (int)localSequentialByteArrayReader.getUInt32();
          localObject1 = paramArrayOfByte2;
          int k = (int)localSequentialByteArrayReader.getUInt32();
          paramString = paramArrayOfByte2;
          if (paramArrayOfByte2 == null)
          {
            localObject1 = paramArrayOfByte2;
            paramString = new byte[j];
          }
          localObject1 = paramString;
          if (paramString.length == j)
          {
            localObject1 = paramString;
            System.arraycopy(paramArrayOfByte1, 75, paramString, k, i - 75);
            return paramString;
          }
          localObject1 = paramString;
          paramArrayOfByte1 = new XmpDirectory();
          localObject1 = paramString;
          paramArrayOfByte1.addError(String.format("Inconsistent length for the Extended XMP buffer: %d instead of %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramString.length) }));
          localObject1 = paramString;
          paramMetadata.addDirectory(paramArrayOfByte1);
          return paramString;
        }
      }
      catch (IOException paramArrayOfByte1)
      {
        paramString = new XmpDirectory();
        paramString.addError(paramArrayOfByte1.getMessage());
        paramMetadata.addDirectory(paramString);
        localObject2 = localObject1;
      }
    }
    return (byte[])localObject2;
  }
  
  /* Error */
  public void extract(com.drew.metadata.StringValue arg1, Metadata arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void extract(String paramString, Metadata paramMetadata)
  {
    extract(paramString, paramMetadata, null);
  }
  
  /* Error */
  public void extract(String arg1, Metadata arg2, com.drew.metadata.Directory arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void extract(byte[] arg1, int arg2, int arg3, Metadata arg4, com.drew.metadata.Directory arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void extract(byte[] paramArrayOfByte, Metadata paramMetadata)
  {
    extract(paramArrayOfByte, paramMetadata, null);
  }
  
  /* Error */
  public void extract(byte[] arg1, Metadata arg2, com.drew.metadata.Directory arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Iterable<JpegSegmentType> getSegmentTypes()
  {
    return Collections.singletonList(JpegSegmentType.APP1);
  }
  
  /* Error */
  public void readJpegSegments(Iterable<byte[]> arg1, Metadata arg2, JpegSegmentType arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\xmp\XmpReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */