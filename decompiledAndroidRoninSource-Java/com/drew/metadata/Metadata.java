package com.drew.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Metadata
{
  private final List<Directory> _directories = new ArrayList();
  
  public <T extends Directory> void addDirectory(T paramT)
  {
    this._directories.add(paramT);
  }
  
  public boolean containsDirectoryOfType(Class<? extends Directory> paramClass)
  {
    return false;
  }
  
  public Iterable<Directory> getDirectories()
  {
    return this._directories;
  }
  
  public <T extends Directory> Collection<T> getDirectoriesOfType(Class<T> paramClass)
  {
    return null;
  }
  
  public int getDirectoryCount()
  {
    return this._directories.size();
  }
  
  public <T extends Directory> T getFirstDirectoryOfType(Class<T> paramClass)
  {
    return null;
  }
  
  public boolean hasErrors()
  {
    return false;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */