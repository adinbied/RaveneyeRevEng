package dji.log;

public class Controller
{
  public static final int WARN_CONSOLE = 1;
  public static final int WARN_NONE = 0;
  public static final int WARN_TOAST = 2;
  boolean encrypt = false;
  boolean print = true;
  int priority = 3;
  boolean save = true;
  int warn = 0;
  
  public Controller encrypt(boolean paramBoolean)
  {
    this.encrypt = paramBoolean;
    return this;
  }
  
  public Controller print(boolean paramBoolean)
  {
    this.print = paramBoolean;
    return this;
  }
  
  public Controller priority(int paramInt)
  {
    this.priority = paramInt;
    return this;
  }
  
  public Controller save(boolean paramBoolean)
  {
    this.save = paramBoolean;
    return this;
  }
  
  public Controller warn(int paramInt)
  {
    this.warn = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */