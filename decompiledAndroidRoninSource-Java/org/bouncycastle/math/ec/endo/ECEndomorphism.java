package org.bouncycastle.math.ec.endo;

import org.bouncycastle.math.ec.ECPointMap;

public abstract interface ECEndomorphism
{
  public abstract ECPointMap getPointMap();
  
  public abstract boolean hasEfficientPointMap();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\endo\ECEndomorphism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */