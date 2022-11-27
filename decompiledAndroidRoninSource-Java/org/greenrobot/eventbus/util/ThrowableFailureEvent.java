package org.greenrobot.eventbus.util;

public class ThrowableFailureEvent
  implements HasExecutionScope
{
  private Object executionContext;
  protected final boolean suppressErrorUi;
  protected final Throwable throwable;
  
  public ThrowableFailureEvent(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
    this.suppressErrorUi = false;
  }
  
  public ThrowableFailureEvent(Throwable paramThrowable, boolean paramBoolean)
  {
    this.throwable = paramThrowable;
    this.suppressErrorUi = paramBoolean;
  }
  
  public Object getExecutionScope()
  {
    return this.executionContext;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public boolean isSuppressErrorUi()
  {
    return this.suppressErrorUi;
  }
  
  public void setExecutionScope(Object paramObject)
  {
    this.executionContext = paramObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\greenrobot\eventbu\\util\ThrowableFailureEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */