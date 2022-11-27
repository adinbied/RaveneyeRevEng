package com.facebook.common.file;

import java.io.File;

public abstract interface FileTreeVisitor
{
  public abstract void postVisitDirectory(File paramFile);
  
  public abstract void preVisitDirectory(File paramFile);
  
  public abstract void visitFile(File paramFile);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\file\FileTreeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */