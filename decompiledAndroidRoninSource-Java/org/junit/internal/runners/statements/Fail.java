package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class Fail
  extends Statement
{
  private final Throwable error;
  
  public Fail(Throwable paramThrowable)
  {
    this.error = paramThrowable;
  }
  
  public void evaluate()
    throws Throwable
  {
    throw this.error;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\statements\Fail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */