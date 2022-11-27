package com.drew.metadata;

public class Tag
{
  private final Directory _directory;
  private final int _tagType;
  
  public Tag(int paramInt, Directory paramDirectory)
  {
    this._tagType = paramInt;
    this._directory = paramDirectory;
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public String getDirectoryName()
  {
    return this._directory.getName();
  }
  
  public String getTagName()
  {
    return null;
  }
  
  public int getTagType()
  {
    return this._tagType;
  }
  
  public String getTagTypeHex()
  {
    return null;
  }
  
  public boolean hasTagName()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */