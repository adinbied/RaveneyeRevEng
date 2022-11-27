package org.junit.rules;

import org.junit.runner.Description;

public class TestName
  extends TestWatcher
{
  private String name;
  
  public String getMethodName()
  {
    return this.name;
  }
  
  protected void starting(Description paramDescription)
  {
    this.name = paramDescription.getMethodName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\rules\TestName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */