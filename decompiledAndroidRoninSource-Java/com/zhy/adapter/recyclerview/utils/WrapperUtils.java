package com.zhy.adapter.recyclerview.utils;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;

public class WrapperUtils
{
  public static void onAttachedToRecyclerView(final RecyclerView.Adapter paramAdapter, RecyclerView paramRecyclerView, SpanSizeCallback paramSpanSizeCallback)
  {
    paramAdapter.onAttachedToRecyclerView(paramRecyclerView);
    paramAdapter = paramRecyclerView.getLayoutManager();
    if ((paramAdapter instanceof GridLayoutManager))
    {
      paramAdapter = (GridLayoutManager)paramAdapter;
      paramAdapter.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup()
      {
        public int getSpanSize(int paramAnonymousInt)
        {
          return 0;
        }
      });
      paramAdapter.setSpanCount(paramAdapter.getSpanCount());
    }
  }
  
  public static void setFullSpan(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = paramViewHolder.itemView.getLayoutParams();
    if ((paramViewHolder != null) && ((paramViewHolder instanceof StaggeredGridLayoutManager.LayoutParams))) {
      ((StaggeredGridLayoutManager.LayoutParams)paramViewHolder).setFullSpan(true);
    }
  }
  
  public static abstract interface SpanSizeCallback
  {
    public abstract int getSpanSize(GridLayoutManager paramGridLayoutManager, GridLayoutManager.SpanSizeLookup paramSpanSizeLookup, int paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclervie\\utils\WrapperUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */