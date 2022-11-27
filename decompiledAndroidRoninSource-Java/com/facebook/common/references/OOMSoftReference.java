package com.facebook.common.references;

import java.lang.ref.SoftReference;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class OOMSoftReference<T>
{
  SoftReference<T> softRef1 = null;
  SoftReference<T> softRef2 = null;
  SoftReference<T> softRef3 = null;
  
  public void clear()
  {
    SoftReference localSoftReference = this.softRef1;
    if (localSoftReference != null)
    {
      localSoftReference.clear();
      this.softRef1 = null;
    }
    localSoftReference = this.softRef2;
    if (localSoftReference != null)
    {
      localSoftReference.clear();
      this.softRef2 = null;
    }
    localSoftReference = this.softRef3;
    if (localSoftReference != null)
    {
      localSoftReference.clear();
      this.softRef3 = null;
    }
  }
  
  @Nullable
  public T get()
  {
    SoftReference localSoftReference = this.softRef1;
    if (localSoftReference == null) {
      return null;
    }
    return (T)localSoftReference.get();
  }
  
  public void set(@Nonnull T paramT)
  {
    this.softRef1 = new SoftReference(paramT);
    this.softRef2 = new SoftReference(paramT);
    this.softRef3 = new SoftReference(paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\OOMSoftReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */