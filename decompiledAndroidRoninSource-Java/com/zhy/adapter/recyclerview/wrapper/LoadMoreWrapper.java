package com.zhy.adapter.recyclerview.wrapper;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zhy.adapter.recyclerview.utils.WrapperUtils.SpanSizeCallback;

public class LoadMoreWrapper<T>
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public static final int ITEM_TYPE_LOAD_MORE = 2147483645;
  private RecyclerView.Adapter mInnerAdapter;
  private int mLoadMoreLayoutId;
  private View mLoadMoreView;
  private OnLoadMoreListener mOnLoadMoreListener;
  
  public LoadMoreWrapper(RecyclerView.Adapter paramAdapter)
  {
    this.mInnerAdapter = paramAdapter;
  }
  
  private boolean hasLoadMore()
  {
    return false;
  }
  
  private boolean isShowLoadMore(int paramInt)
  {
    return false;
  }
  
  /* Error */
  private void setFullSpan(RecyclerView.ViewHolder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public LoadMoreWrapper setLoadMoreView(int paramInt)
  {
    this.mLoadMoreLayoutId = paramInt;
    return this;
  }
  
  public LoadMoreWrapper setLoadMoreView(View paramView)
  {
    this.mLoadMoreView = paramView;
    return this;
  }
  
  public LoadMoreWrapper setOnLoadMoreListener(OnLoadMoreListener paramOnLoadMoreListener)
  {
    if (paramOnLoadMoreListener != null) {
      this.mOnLoadMoreListener = paramOnLoadMoreListener;
    }
    return this;
  }
  
  public static abstract interface OnLoadMoreListener
  {
    public abstract void onLoadMoreRequested();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\wrapper\LoadMoreWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */