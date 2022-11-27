package com.zhy.adapter.recyclerview.base;

import androidx.collection.SparseArrayCompat;

public class ItemViewDelegateManager<T>
{
  SparseArrayCompat<ItemViewDelegate<T>> delegates = new SparseArrayCompat();
  
  public ItemViewDelegateManager<T> addDelegate(int paramInt, ItemViewDelegate<T> paramItemViewDelegate)
  {
    return null;
  }
  
  public ItemViewDelegateManager<T> addDelegate(ItemViewDelegate<T> paramItemViewDelegate)
  {
    return null;
  }
  
  /* Error */
  public void convert(ViewHolder arg1, T arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ItemViewDelegate getItemViewDelegate(int paramInt)
  {
    return null;
  }
  
  public int getItemViewDelegateCount()
  {
    return this.delegates.size();
  }
  
  public int getItemViewLayoutId(int paramInt)
  {
    return getItemViewDelegate(paramInt).getItemViewLayoutId();
  }
  
  public int getItemViewType(ItemViewDelegate paramItemViewDelegate)
  {
    return this.delegates.indexOfValue(paramItemViewDelegate);
  }
  
  public int getItemViewType(T paramT, int paramInt)
  {
    return 0;
  }
  
  public ItemViewDelegateManager<T> removeDelegate(int paramInt)
  {
    return null;
  }
  
  public ItemViewDelegateManager<T> removeDelegate(ItemViewDelegate<T> paramItemViewDelegate)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\base\ItemViewDelegateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */