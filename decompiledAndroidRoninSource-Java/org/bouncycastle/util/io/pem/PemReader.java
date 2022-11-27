package org.bouncycastle.util.io.pem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.util.encoders.Base64;

public class PemReader
  extends BufferedReader
{
  private static final String BEGIN = "-----BEGIN ";
  private static final String END = "-----END ";
  
  public PemReader(Reader paramReader)
  {
    super(paramReader);
  }
  
  private PemObject loadObject(String paramString)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("-----END ");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    String str;
    for (;;)
    {
      str = readLine();
      if (str == null) {
        break;
      }
      if (str.indexOf(":") >= 0)
      {
        int i = str.indexOf(':');
        localArrayList.add(new PemHeader(str.substring(0, i), str.substring(i + 1).trim()));
      }
      else
      {
        if (str.indexOf((String)localObject) != -1) {
          break;
        }
        localStringBuffer.append(str.trim());
      }
    }
    if (str != null) {
      return new PemObject(paramString, localArrayList, Base64.decode(localStringBuffer.toString()));
    }
    paramString = new StringBuilder();
    paramString.append((String)localObject);
    paramString.append(" not found");
    throw new IOException(paramString.toString());
  }
  
  public PemObject readPemObject()
    throws IOException
  {
    String str;
    do
    {
      str = readLine();
    } while ((str != null) && (!str.startsWith("-----BEGIN ")));
    if (str != null)
    {
      str = str.substring(11);
      int i = str.indexOf('-');
      str = str.substring(0, i);
      if (i > 0) {
        return loadObject(str);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\pem\PemReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */