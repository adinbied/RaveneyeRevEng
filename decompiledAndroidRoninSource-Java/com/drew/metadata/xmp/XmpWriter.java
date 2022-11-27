package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.options.SerializeOptions;
import com.drew.metadata.Metadata;
import java.io.OutputStream;

public class XmpWriter
{
  public static boolean write(OutputStream paramOutputStream, Metadata paramMetadata)
  {
    paramMetadata = (XmpDirectory)paramMetadata.getFirstDirectoryOfType(XmpDirectory.class);
    if (paramMetadata == null) {
      return false;
    }
    paramMetadata = paramMetadata.getXMPMeta();
    try
    {
      XMPMetaFactory.serialize(paramMetadata, paramOutputStream, new SerializeOptions().setOmitPacketWrapper(true));
      return true;
    }
    catch (XMPException paramOutputStream)
    {
      paramOutputStream.printStackTrace();
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\xmp\XmpWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */