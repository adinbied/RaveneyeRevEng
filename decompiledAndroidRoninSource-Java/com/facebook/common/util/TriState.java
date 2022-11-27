package com.facebook.common.util;

import javax.annotation.Nullable;

public enum TriState
{
  static
  {
    NO = new TriState("NO", 1);
    TriState localTriState = new TriState("UNSET", 2);
    UNSET = localTriState;
    $VALUES = new TriState[] { YES, NO, localTriState };
  }
  
  private TriState() {}
  
  public static TriState fromDbValue(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return UNSET;
      }
      return NO;
    }
    return YES;
  }
  
  public static TriState valueOf(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      return valueOf(paramBoolean.booleanValue());
    }
    return UNSET;
  }
  
  public static TriState valueOf(boolean paramBoolean)
  {
    if (paramBoolean) {
      return YES;
    }
    return NO;
  }
  
  public boolean asBoolean()
  {
    int i = 1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unrecognized TriState value: ");
          localStringBuilder.append(this);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        throw new IllegalStateException("No boolean equivalent for UNSET");
      }
      return false;
    }
    return true;
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    int i = 1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return paramBoolean;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unrecognized TriState value: ");
        localStringBuilder.append(this);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      return false;
    }
    return true;
  }
  
  @Nullable
  public Boolean asBooleanObject()
  {
    int i = 1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return null;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unrecognized TriState value: ");
        localStringBuilder.append(this);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public int getDbValue()
  {
    int j = 1.$SwitchMap$com$facebook$common$util$TriState[ordinal()];
    int i = 1;
    if (j != 1)
    {
      i = 2;
      if (j != 2) {
        return 3;
      }
    }
    return i;
  }
  
  public boolean isSet()
  {
    return this != UNSET;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\commo\\util\TriState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */