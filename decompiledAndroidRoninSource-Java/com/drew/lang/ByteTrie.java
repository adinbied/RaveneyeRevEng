package com.drew.lang;

import java.util.HashMap;
import java.util.Map;

public class ByteTrie<T>
{
  private int _maxDepth;
  private final ByteTrieNode<T> _root = new ByteTrieNode();
  
  /* Error */
  public void addPath(T arg1, byte[]... arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public T find(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public int getMaxDepth()
  {
    return this._maxDepth;
  }
  
  public void setDefaultValue(T paramT)
  {
    this._root.setValue(paramT);
  }
  
  static class ByteTrieNode<T>
  {
    private final Map<Byte, ByteTrieNode<T>> _children = new HashMap();
    private T _value = null;
    
    /* Error */
    public void setValue(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\ByteTrie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */