package dji.log;

import java.io.File;

class DJIFileUtil
{
  public static boolean delAllFiles(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isFile()) {
        return paramFile.delete();
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile != null) && (arrayOfFile.length > 0))
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            delAllFiles(arrayOfFile[i]);
            i += 1;
          }
        }
        return paramFile.delete();
      }
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJIFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */