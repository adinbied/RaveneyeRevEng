package org.junit.internal;

import java.io.PrintStream;

public class RealSystem
  implements JUnitSystem
{
  @Deprecated
  public void exit(int paramInt)
  {
    System.exit(paramInt);
  }
  
  public PrintStream out()
  {
    return System.out;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\RealSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */