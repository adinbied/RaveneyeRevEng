package dji.thirdparty.okhttp3;

import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okio.BufferedSink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FormBody
  extends RequestBody
{
  private static final MediaType CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded");
  private final List<String> encodedNames;
  private final List<String> encodedValues;
  
  private FormBody(List<String> paramList1, List<String> paramList2)
  {
    this.encodedNames = Util.immutableList(paramList1);
    this.encodedValues = Util.immutableList(paramList2);
  }
  
  private long writeOrCountBytes(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return 277865688L;
  }
  
  public long contentLength()
  {
    return writeOrCountBytes(null, true);
  }
  
  public MediaType contentType()
  {
    return CONTENT_TYPE;
  }
  
  public String encodedName(int paramInt)
  {
    return null;
  }
  
  public String encodedValue(int paramInt)
  {
    return null;
  }
  
  public String name(int paramInt)
  {
    return null;
  }
  
  public int size()
  {
    return this.encodedNames.size();
  }
  
  public String value(int paramInt)
  {
    return null;
  }
  
  public void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    writeOrCountBytes(paramBufferedSink, false);
  }
  
  public static final class Builder
  {
    private final List<String> names = new ArrayList();
    private final List<String> values = new ArrayList();
    
    public Builder add(String paramString1, String paramString2)
    {
      return null;
    }
    
    public Builder addEncoded(String paramString1, String paramString2)
    {
      return null;
    }
    
    public FormBody build()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\FormBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */