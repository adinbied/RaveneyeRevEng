package org.msgpack.value;

public abstract interface ImmutableValue
  extends Value
{
  public abstract ImmutableArrayValue asArrayValue();
  
  public abstract ImmutableBinaryValue asBinaryValue();
  
  public abstract ImmutableBooleanValue asBooleanValue();
  
  public abstract ImmutableFloatValue asFloatValue();
  
  public abstract ImmutableIntegerValue asIntegerValue();
  
  public abstract ImmutableMapValue asMapValue();
  
  public abstract ImmutableNilValue asNilValue();
  
  public abstract ImmutableRawValue asRawValue();
  
  public abstract ImmutableStringValue asStringValue();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\ImmutableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */