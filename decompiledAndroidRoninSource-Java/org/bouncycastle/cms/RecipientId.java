package org.bouncycastle.cms;

import org.bouncycastle.util.Selector;

public abstract class RecipientId
  implements Selector
{
  public static final int kek = 1;
  public static final int keyAgree = 2;
  public static final int keyTrans = 0;
  public static final int password = 3;
  private final int type;
  
  protected RecipientId(int paramInt)
  {
    this.type = paramInt;
  }
  
  public abstract Object clone();
  
  public int getType()
  {
    return this.type;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\RecipientId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */