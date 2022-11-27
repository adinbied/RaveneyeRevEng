package com.drew.metadata.file;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class FileMetadataDirectory
  extends Directory
{
  public static final int TAG_FILE_MODIFIED_DATE = 3;
  public static final int TAG_FILE_NAME = 1;
  public static final int TAG_FILE_SIZE = 2;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "File Name");
    _tagNameMap.put(Integer.valueOf(2), "File Size");
    _tagNameMap.put(Integer.valueOf(3), "File Modified Date");
  }
  
  public FileMetadataDirectory()
  {
    setDescriptor(new FileMetadataDescriptor(this));
  }
  
  public String getName()
  {
    return "File";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\file\FileMetadataDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */