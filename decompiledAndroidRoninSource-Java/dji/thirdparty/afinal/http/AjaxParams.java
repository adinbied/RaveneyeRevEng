package dji.thirdparty.afinal.http;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;

public class AjaxParams
{
  private static String ENCODING = "UTF-8";
  protected ConcurrentHashMap<String, FileWrapper> fileParams;
  protected ConcurrentHashMap<String, String> urlParams;
  
  public AjaxParams()
  {
    init();
  }
  
  public AjaxParams(String paramString1, String paramString2)
  {
    init();
    put(paramString1, paramString2);
  }
  
  public AjaxParams(Map<String, String> paramMap)
  {
    init();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }
  
  public AjaxParams(Object... paramVarArgs)
  {
    init();
    int j = paramVarArgs.length;
    if (j % 2 == 0)
    {
      int i = 0;
      while (i < j)
      {
        put(String.valueOf(paramVarArgs[i]), String.valueOf(paramVarArgs[(i + 1)]));
        i += 2;
      }
      return;
    }
    throw new IllegalArgumentException("Supplied arguments must be even");
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpEntity getEntity()
  {
    return null;
  }
  
  public HttpEntity getFormDataEntity()
  {
    return null;
  }
  
  public String getParamString()
  {
    return null;
  }
  
  protected List<BasicNameValuePair> getParamsList()
  {
    return null;
  }
  
  /* Error */
  public void put(String arg1, java.io.File arg2)
    throws java.io.FileNotFoundException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void put(String paramString, InputStream paramInputStream)
  {
    put(paramString, paramInputStream, null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2)
  {
    put(paramString1, paramInputStream, paramString2, null);
  }
  
  /* Error */
  public void put(String arg1, InputStream arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void put(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void remove(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
  
  private static class FileWrapper
  {
    public String contentType;
    public String fileName;
    public InputStream inputStream;
    
    public FileWrapper(InputStream paramInputStream, String paramString1, String paramString2)
    {
      this.inputStream = paramInputStream;
      this.fileName = paramString1;
      this.contentType = paramString2;
    }
    
    public String getFileName()
    {
      String str = this.fileName;
      if (str != null) {
        return str;
      }
      return "nofilename";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\AjaxParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */