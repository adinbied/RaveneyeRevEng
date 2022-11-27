package org.msgpack.value;

import java.util.Iterator;
import java.util.List;

public abstract interface ArrayValue
  extends Value, Iterable<Value>
{
  public abstract Value get(int paramInt);
  
  public abstract Value getOrNilValue(int paramInt);
  
  public abstract Iterator<Value> iterator();
  
  public abstract List<Value> list();
  
  public abstract int size();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\ArrayValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */