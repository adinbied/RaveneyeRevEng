package it.sauronsoftware.ftp4j.extrecognizers;

import it.sauronsoftware.ftp4j.FTPTextualExtensionRecognizer;
import java.util.ArrayList;

public class ParametricTextualExtensionRecognizer
  implements FTPTextualExtensionRecognizer
{
  private ArrayList exts = new ArrayList();
  
  public ParametricTextualExtensionRecognizer() {}
  
  public ParametricTextualExtensionRecognizer(ArrayList paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      if ((localObject instanceof String)) {
        addExtension((String)localObject);
      }
      i += 1;
    }
  }
  
  public ParametricTextualExtensionRecognizer(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      addExtension(paramArrayOfString[i]);
      i += 1;
    }
  }
  
  /* Error */
  public void addExtension(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String[] getExtensions()
  {
    return null;
  }
  
  public boolean isTextualExt(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void removeExtension(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\extrecognizers\ParametricTextualExtensionRecognizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */