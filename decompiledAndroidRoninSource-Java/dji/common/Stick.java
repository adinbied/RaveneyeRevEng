package dji.common;

public class Stick
{
  private int horizontalPosition;
  private int verticalPosition;
  
  public Stick(int paramInt1, int paramInt2)
  {
    this.horizontalPosition = paramInt1;
    this.verticalPosition = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int getHorizontalPosition()
  {
    return this.horizontalPosition;
  }
  
  public int getVerticalPosition()
  {
    return this.verticalPosition;
  }
  
  public int hashCode()
  {
    return this.horizontalPosition * 31 + this.verticalPosition;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\Stick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */