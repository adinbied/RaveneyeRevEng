package org.msgpack.value;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract interface MapValue
  extends Value
{
  public abstract Set<Map.Entry<Value, Value>> entrySet();
  
  public abstract Value[] getKeyValueArray();
  
  public abstract Set<Value> keySet();
  
  public abstract Map<Value, Value> map();
  
  public abstract int size();
  
  public abstract Collection<Value> values();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\MapValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */