package com.squareup.wire;

import java.io.IOException;
import java.net.ProtocolException;

public enum FieldEncoding
{
  final int value;
  
  static
  {
    FIXED64 = new FieldEncoding("FIXED64", 1, 1);
    LENGTH_DELIMITED = new FieldEncoding("LENGTH_DELIMITED", 2, 2);
    FieldEncoding localFieldEncoding = new FieldEncoding("FIXED32", 3, 5);
    FIXED32 = localFieldEncoding;
    $VALUES = new FieldEncoding[] { VARINT, FIXED64, LENGTH_DELIMITED, localFieldEncoding };
  }
  
  private FieldEncoding(int paramInt)
  {
    this.value = paramInt;
  }
  
  static FieldEncoding get(int paramInt)
    throws IOException
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 5) {
            return FIXED32;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected FieldEncoding: ");
          localStringBuilder.append(paramInt);
          throw new ProtocolException(localStringBuilder.toString());
        }
        return LENGTH_DELIMITED;
      }
      return FIXED64;
    }
    return VARINT;
  }
  
  public ProtoAdapter<?> rawProtoAdapter()
  {
    int i = 1.$SwitchMap$com$squareup$wire$FieldEncoding[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            return ProtoAdapter.BYTES;
          }
          throw new AssertionError();
        }
        return ProtoAdapter.FIXED64;
      }
      return ProtoAdapter.FIXED32;
    }
    return ProtoAdapter.UINT64;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\FieldEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */