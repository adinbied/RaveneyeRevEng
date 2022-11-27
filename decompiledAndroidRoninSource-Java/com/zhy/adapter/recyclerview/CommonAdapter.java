package com.zhy.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.List;

public abstract class CommonAdapter<T>
  extends MultiItemTypeAdapter<T>
{
  protected Context mContext;
  protected List<T> mDatas;
  protected LayoutInflater mInflater;
  protected int mLayoutId;
  
  public CommonAdapter(Context paramContext, final int paramInt, List<T> paramList)
  {
    super(paramContext, paramList);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mLayoutId = paramInt;
    this.mDatas = paramList;
    addItemViewDelegate(new ItemViewDelegate()
    {
      public void convert(ViewHolder paramAnonymousViewHolder, T paramAnonymousT, int paramAnonymousInt)
      {
        CommonAdapter.this.convert(paramAnonymousViewHolder, paramAnonymousT, paramAnonymousInt);
      }
      
      public int getItemViewLayoutId()
      {
        return paramInt;
      }
      
      public boolean isForViewType(T paramAnonymousT, int paramAnonymousInt)
      {
        return true;
      }
    });
  }
  
  protected abstract void convert(ViewHolder paramViewHolder, T paramT, int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\CommonAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */