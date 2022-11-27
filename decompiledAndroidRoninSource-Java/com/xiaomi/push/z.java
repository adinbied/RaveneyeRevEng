package com.xiaomi.push;

import java.io.File;
import java.io.FileFilter;

final class z
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.isDirectory();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */