package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import java.util.Queue;

class OOMSoftReferenceBucket<V>
  extends Bucket<V>
{
  private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList();
  
  public OOMSoftReferenceBucket(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3, false);
  }
  
  void addToFreeList(V paramV)
  {
    OOMSoftReference localOOMSoftReference2 = (OOMSoftReference)this.mSpareReferences.poll();
    OOMSoftReference localOOMSoftReference1 = localOOMSoftReference2;
    if (localOOMSoftReference2 == null) {
      localOOMSoftReference1 = new OOMSoftReference();
    }
    localOOMSoftReference1.set(paramV);
    this.mFreeList.add(localOOMSoftReference1);
  }
  
  public V pop()
  {
    OOMSoftReference localOOMSoftReference = (OOMSoftReference)this.mFreeList.poll();
    Object localObject = localOOMSoftReference.get();
    localOOMSoftReference.clear();
    this.mSpareReferences.add(localOOMSoftReference);
    return (V)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\OOMSoftReferenceBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */