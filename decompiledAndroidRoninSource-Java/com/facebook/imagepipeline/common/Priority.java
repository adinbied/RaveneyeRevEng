package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

public enum Priority
{
  static
  {
    Priority localPriority = new Priority("HIGH", 2);
    HIGH = localPriority;
    $VALUES = new Priority[] { LOW, MEDIUM, localPriority };
  }
  
  private Priority() {}
  
  public static Priority getHigherPriority(@Nullable Priority paramPriority1, @Nullable Priority paramPriority2)
  {
    if (paramPriority1 == null) {
      return paramPriority2;
    }
    if (paramPriority2 == null) {
      return paramPriority1;
    }
    if (paramPriority1.ordinal() > paramPriority2.ordinal()) {
      return paramPriority1;
    }
    return paramPriority2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\Priority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */