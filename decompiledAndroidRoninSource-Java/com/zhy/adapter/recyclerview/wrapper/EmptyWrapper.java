package com.zhy.adapter.recyclerview.wrapper;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zhy.adapter.recyclerview.utils.WrapperUtils.SpanSizeCallback;

public class EmptyWrapper<T>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final int ITEM_TYPE_EMPTY = 2147483646;
  private int mEmptyLayoutId;
  private View mEmptyView;
  private RecyclerView.Adapter mInnerAdapter;
  
  public EmptyWrapper(RecyclerView.Adapter paramAdapter)
  {
    this.mInnerAdapter = paramAdapter;
  }
  
  private boolean isEmpty()
  {
    return false;
  }
  
  public int getItemCount()
  {
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBindViewHolder(RecyclerView.ViewHolder arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void onViewAttachedToWindow(RecyclerView.ViewHolder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setEmptyView(int paramInt)
  {
    this.mEmptyLayoutId = paramInt;
  }
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\wrapper\EmptyWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */