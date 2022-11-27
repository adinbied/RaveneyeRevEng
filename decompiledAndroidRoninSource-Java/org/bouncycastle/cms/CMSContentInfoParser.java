package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.cms.ContentInfoParser;

public class CMSContentInfoParser
{
  protected ContentInfoParser _contentInfo;
  protected InputStream _data;
  
  protected CMSContentInfoParser(InputStream paramInputStream)
    throws CMSException
  {
    this._data = paramInputStream;
    try
    {
      paramInputStream = (ASN1SequenceParser)new ASN1StreamParser(paramInputStream).readObject();
      if (paramInputStream != null)
      {
        this._contentInfo = new ContentInfoParser(paramInputStream);
        return;
      }
      throw new CMSException("No content found.");
    }
    catch (ClassCastException paramInputStream)
    {
      throw new CMSException("Unexpected object reading content.", paramInputStream);
    }
    catch (IOException paramInputStream)
    {
      throw new CMSException("IOException reading content.", paramInputStream);
    }
  }
  
  public void close()
    throws IOException
  {
    this._data.close();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSContentInfoParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */