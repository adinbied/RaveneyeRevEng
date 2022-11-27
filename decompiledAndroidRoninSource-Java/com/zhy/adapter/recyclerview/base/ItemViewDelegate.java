package com.zhy.adapter.recyclerview.base;

public abstract interface ItemViewDelegate<T>
{
  public abstract void convert(ViewHolder paramViewHolder, T paramT, int paramInt);
  
  public abstract int getItemViewLayoutId();
  
  public abstract boolean isForViewType(T paramT, int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\base\ItemViewDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */