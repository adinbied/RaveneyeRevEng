package org.bouncycastle.util;

public abstract interface StringList
  extends Iterable<String>
{
  public abstract boolean add(String paramString);
  
  public abstract String get(int paramInt);
  
  public abstract int size();
  
  public abstract String[] toStringArray();
  
  public abstract String[] toStringArray(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\StringList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */