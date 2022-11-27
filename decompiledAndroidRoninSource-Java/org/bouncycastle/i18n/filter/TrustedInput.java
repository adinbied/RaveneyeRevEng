package org.bouncycastle.i18n.filter;

public class TrustedInput
{
  protected Object input;
  
  public TrustedInput(Object paramObject)
  {
    this.input = paramObject;
  }
  
  public Object getInput()
  {
    return this.input;
  }
  
  public String toString()
  {
    return this.input.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\filter\TrustedInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */