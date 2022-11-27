package org.hamcrest.internal;

import org.hamcrest.Description;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValue<T>
  implements SelfDescribing
{
  private T value;
  
  public SelfDescribingValue(T paramT)
  {
    this.value = paramT;
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendValue(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\internal\SelfDescribingValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */