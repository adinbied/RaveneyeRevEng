package dji.tools.sm;

import android.os.Message;

public abstract interface IState
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  
  public abstract void enter();
  
  public abstract void exit();
  
  public abstract String getName();
  
  public abstract boolean processMessage(Message paramMessage);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\tools\sm\IState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */