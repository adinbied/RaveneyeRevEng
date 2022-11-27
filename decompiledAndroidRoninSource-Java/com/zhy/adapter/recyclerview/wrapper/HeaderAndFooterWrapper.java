package com.zhy.adapter.recyclerview.wrapper;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zhy.adapter.recyclerview.utils.WrapperUtils.SpanSizeCallback;

public class HeaderAndFooterWrapper<T>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private static final int BASE_ITEM_TYPE_FOOTER = 200000;
  private static final int BASE_ITEM_TYPE_HEADER = 100000;
  private SparseArrayCompat<View> mFootViews = new SparseArrayCompat();
  private SparseArrayCompat<View> mHeaderViews = new SparseArrayCompat();
  private RecyclerView.Adapter mInnerAdapter;
  
  public HeaderAndFooterWrapper(RecyclerView.Adapter paramAdapter)
  {
    this.mInnerAdapter = paramAdapter;
  }
  
  private int getRealItemCount()
  {
    return this.mInnerAdapter.getItemCount();
  }
  
  private boolean isFooterViewPos(int paramInt)
  {
    return false;
  }
  
  private boolean isHeaderViewPos(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void addFootView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addHeaderView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getFootersCount()
  {
    return this.mFootViews.size();
  }
  
  public int getHeadersCount()
  {
    return this.mHeaderViews.size();
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\wrapper\HeaderAndFooterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */