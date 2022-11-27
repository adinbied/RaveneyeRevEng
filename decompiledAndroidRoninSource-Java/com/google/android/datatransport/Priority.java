package com.google.android.datatransport;

public enum Priority
{
  static
  {
    Priority localPriority = new Priority("HIGHEST", 2);
    HIGHEST = localPriority;
    $VALUES = new Priority[] { DEFAULT, VERY_LOW, localPriority };
  }
  
  private Priority() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\Priority.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */