package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValueIterator<T>
  implements Iterator<SelfDescribing>
{
  private Iterator<T> values;
  
  public SelfDescribingValueIterator(Iterator<T> paramIterator)
  {
    this.values = paramIterator;
  }
  
  public boolean hasNext()
  {
    return this.values.hasNext();
  }
  
  public SelfDescribing next()
  {
    return new SelfDescribingValue(this.values.next());
  }
  
  public void remove()
  {
    this.values.remove();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\hamcrest\internal\SelfDescribingValueIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */