package dji.thirdparty.sanselan;

import java.util.ArrayList;

public class FormatCompliance
{
  private final ArrayList comments = new ArrayList();
  private final String description;
  private final boolean failOnError;
  
  public FormatCompliance(String paramString)
  {
    this.description = paramString;
    this.failOnError = false;
  }
  
  public FormatCompliance(String paramString, boolean paramBoolean)
  {
    this.description = paramString;
    this.failOnError = paramBoolean;
  }
  
  public static final FormatCompliance getDefault()
  {
    return new FormatCompliance("ignore", false);
  }
  
  private String getValueDescription(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void addComment(String arg1)
    throws ImageReadException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addComment(String arg1, int arg2)
    throws ImageReadException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean checkBounds(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws ImageReadException
  {
    return false;
  }
  
  public boolean compare(String paramString, int paramInt1, int paramInt2)
    throws ImageReadException
  {
    return false;
  }
  
  public boolean compare(String paramString, int[] paramArrayOfInt, int paramInt)
    throws ImageReadException
  {
    return false;
  }
  
  public boolean compare_bytes(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws ImageReadException
  {
    return false;
  }
  
  /* Error */
  public void dump()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dump(java.io.PrintWriter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sanselan\FormatCompliance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */