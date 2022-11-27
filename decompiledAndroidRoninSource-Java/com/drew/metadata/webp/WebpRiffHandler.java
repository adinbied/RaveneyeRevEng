package com.drew.metadata.webp;

import com.drew.imaging.riff.RiffHandler;
import com.drew.metadata.Metadata;

public class WebpRiffHandler
  implements RiffHandler
{
  private final Metadata _metadata;
  
  public WebpRiffHandler(Metadata paramMetadata)
  {
    this._metadata = paramMetadata;
  }
  
  /* Error */
  public void processChunk(String arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean shouldAcceptChunk(String paramString)
  {
    return false;
  }
  
  public boolean shouldAcceptRiffIdentifier(String paramString)
  {
    return paramString.equals("WEBP");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\webp\WebpRiffHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */