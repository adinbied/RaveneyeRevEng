package com.facebook.common.references;

import android.graphics.Bitmap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.util.IdentityHashMap;
import java.util.Map;

public class SharedReference<T>
{
  private static final Map<Object, Integer> sLiveObjects = new IdentityHashMap();
  private int mRefCount;
  private final ResourceReleaser<T> mResourceReleaser;
  private T mValue;
  
  public SharedReference(T paramT, ResourceReleaser<T> paramResourceReleaser)
  {
    this.mValue = Preconditions.checkNotNull(paramT);
    this.mResourceReleaser = ((ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mRefCount = 1;
    addLiveReference(paramT);
  }
  
  private static void addLiveReference(Object paramObject)
  {
    if ((CloseableReference.useGc()) && (((paramObject instanceof Bitmap)) || ((paramObject instanceof HasBitmap)))) {
      return;
    }
    synchronized (sLiveObjects)
    {
      Integer localInteger = (Integer)sLiveObjects.get(paramObject);
      if (localInteger == null) {
        sLiveObjects.put(paramObject, Integer.valueOf(1));
      } else {
        sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() + 1));
      }
      return;
    }
  }
  
  private int decreaseRefCount()
  {
    for (;;)
    {
      try
      {
        ensureValid();
        if (this.mRefCount > 0)
        {
          bool = true;
          Preconditions.checkArgument(bool);
          int i = this.mRefCount - 1;
          this.mRefCount = i;
          return i;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private void ensureValid()
  {
    if (isValid(this)) {
      return;
    }
    throw new NullReferenceException();
  }
  
  public static boolean isValid(SharedReference<?> paramSharedReference)
  {
    return (paramSharedReference != null) && (paramSharedReference.isValid());
  }
  
  private static void removeLiveReference(Object paramObject)
  {
    synchronized (sLiveObjects)
    {
      Integer localInteger = (Integer)sLiveObjects.get(paramObject);
      if (localInteger == null) {
        FLog.wtf("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[] { paramObject.getClass() });
      } else if (localInteger.intValue() == 1) {
        sLiveObjects.remove(paramObject);
      } else {
        sLiveObjects.put(paramObject, Integer.valueOf(localInteger.intValue() - 1));
      }
      return;
    }
  }
  
  public static String reportData()
  {
    return Objects.toStringHelper("SharedReference").add("live_objects_count", sLiveObjects.size()).toString();
  }
  
  public void addReference()
  {
    try
    {
      ensureValid();
      this.mRefCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean addReferenceIfValid()
  {
    try
    {
      if (isValid())
      {
        addReference();
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void deleteReference()
  {
    if (decreaseRefCount() == 0) {
      try
      {
        Object localObject1 = this.mValue;
        this.mValue = null;
        this.mResourceReleaser.release(localObject1);
        removeLiveReference(localObject1);
        return;
      }
      finally {}
    }
  }
  
  public boolean deleteReferenceIfValid()
  {
    try
    {
      if (isValid())
      {
        deleteReference();
        return true;
      }
      return false;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public T get()
  {
    try
    {
      Object localObject1 = this.mValue;
      return (T)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public int getRefCountTestOnly()
  {
    try
    {
      int i = this.mRefCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isValid()
  {
    try
    {
      int i = this.mRefCount;
      boolean bool;
      if (i > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static class NullReferenceException
    extends RuntimeException
  {
    public NullReferenceException()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\references\SharedReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */