package com.zhy.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ItemViewDelegateManager;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.List;

public class MultiItemTypeAdapter<T>
  extends RecyclerView.Adapter<ViewHolder>
{
  protected Context mContext;
  protected List<T> mDatas;
  protected ItemViewDelegateManager mItemViewDelegateManager;
  protected OnItemClickListener mOnItemClickListener;
  
  public MultiItemTypeAdapter(Context paramContext, List<T> paramList)
  {
    this.mContext = paramContext;
    this.mDatas = paramList;
    this.mItemViewDelegateManager = new ItemViewDelegateManager();
  }
  
  public MultiItemTypeAdapter addItemViewDelegate(int paramInt, ItemViewDelegate<T> paramItemViewDelegate)
  {
    this.mItemViewDelegateManager.addDelegate(paramInt, paramItemViewDelegate);
    return this;
  }
  
  public MultiItemTypeAdapter addItemViewDelegate(ItemViewDelegate<T> paramItemViewDelegate)
  {
    this.mItemViewDelegateManager.addDelegate(paramItemViewDelegate);
    return this;
  }
  
  /* Error */
  public void convert(ViewHolder arg1, T arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public List<T> getDatas()
  {
    return this.mDatas;
  }
  
  public int getItemCount()
  {
    return this.mDatas.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  protected boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  /* Error */
  public void onBindViewHolder(ViewHolder arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void onViewHolderCreated(ViewHolder paramViewHolder, View paramView) {}
  
  protected void setListener(ViewGroup paramViewGroup, final ViewHolder paramViewHolder, int paramInt)
  {
    if (!isEnabled(paramInt)) {
      return;
    }
    paramViewHolder.getConvertView().setOnClickListener(new View.OnClickListener()
    {
      /* Error */
      public void onClick(View arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    paramViewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        return false;
      }
    });
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  protected boolean useItemViewDelegateManager()
  {
    return false;
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt);
    
    public abstract boolean onItemLongClick(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\MultiItemTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */