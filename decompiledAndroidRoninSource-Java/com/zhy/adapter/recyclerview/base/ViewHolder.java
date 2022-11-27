package com.zhy.adapter.recyclerview.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class ViewHolder
  extends RecyclerView.ViewHolder
{
  private Context mContext;
  private View mConvertView;
  private SparseArray<View> mViews;
  
  public ViewHolder(Context paramContext, View paramView)
  {
    super(paramView);
    this.mContext = paramContext;
    this.mConvertView = paramView;
    this.mViews = new SparseArray();
  }
  
  public static ViewHolder createViewHolder(Context paramContext, View paramView)
  {
    return new ViewHolder(paramContext, paramView);
  }
  
  public static ViewHolder createViewHolder(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return new ViewHolder(paramContext, LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup, false));
  }
  
  public View getConvertView()
  {
    return this.mConvertView;
  }
  
  public <T extends View> T getView(int paramInt)
  {
    return null;
  }
  
  public ViewHolder linkify(int paramInt)
  {
    return null;
  }
  
  public ViewHolder setAlpha(int paramInt, float paramFloat)
  {
    return null;
  }
  
  public ViewHolder setBackgroundColor(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundColor(paramInt2);
    return this;
  }
  
  public ViewHolder setBackgroundRes(int paramInt1, int paramInt2)
  {
    getView(paramInt1).setBackgroundResource(paramInt2);
    return this;
  }
  
  public ViewHolder setChecked(int paramInt, boolean paramBoolean)
  {
    ((Checkable)getView(paramInt)).setChecked(paramBoolean);
    return this;
  }
  
  public ViewHolder setImageBitmap(int paramInt, Bitmap paramBitmap)
  {
    ((ImageView)getView(paramInt)).setImageBitmap(paramBitmap);
    return this;
  }
  
  public ViewHolder setImageDrawable(int paramInt, Drawable paramDrawable)
  {
    ((ImageView)getView(paramInt)).setImageDrawable(paramDrawable);
    return this;
  }
  
  public ViewHolder setImageResource(int paramInt1, int paramInt2)
  {
    ((ImageView)getView(paramInt1)).setImageResource(paramInt2);
    return this;
  }
  
  public ViewHolder setMax(int paramInt1, int paramInt2)
  {
    ((ProgressBar)getView(paramInt1)).setMax(paramInt2);
    return this;
  }
  
  public ViewHolder setOnClickListener(int paramInt, View.OnClickListener paramOnClickListener)
  {
    getView(paramInt).setOnClickListener(paramOnClickListener);
    return this;
  }
  
  public ViewHolder setOnLongClickListener(int paramInt, View.OnLongClickListener paramOnLongClickListener)
  {
    getView(paramInt).setOnLongClickListener(paramOnLongClickListener);
    return this;
  }
  
  public ViewHolder setOnTouchListener(int paramInt, View.OnTouchListener paramOnTouchListener)
  {
    getView(paramInt).setOnTouchListener(paramOnTouchListener);
    return this;
  }
  
  public ViewHolder setProgress(int paramInt1, int paramInt2)
  {
    ((ProgressBar)getView(paramInt1)).setProgress(paramInt2);
    return this;
  }
  
  public ViewHolder setProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    ProgressBar localProgressBar = (ProgressBar)getView(paramInt1);
    localProgressBar.setMax(paramInt3);
    localProgressBar.setProgress(paramInt2);
    return this;
  }
  
  public ViewHolder setRating(int paramInt, float paramFloat)
  {
    ((RatingBar)getView(paramInt)).setRating(paramFloat);
    return this;
  }
  
  public ViewHolder setRating(int paramInt1, float paramFloat, int paramInt2)
  {
    RatingBar localRatingBar = (RatingBar)getView(paramInt1);
    localRatingBar.setMax(paramInt2);
    localRatingBar.setRating(paramFloat);
    return this;
  }
  
  public ViewHolder setTag(int paramInt1, int paramInt2, Object paramObject)
  {
    getView(paramInt1).setTag(paramInt2, paramObject);
    return this;
  }
  
  public ViewHolder setTag(int paramInt, Object paramObject)
  {
    getView(paramInt).setTag(paramObject);
    return this;
  }
  
  public ViewHolder setText(int paramInt, String paramString)
  {
    ((TextView)getView(paramInt)).setText(paramString);
    return this;
  }
  
  public ViewHolder setTextColor(int paramInt1, int paramInt2)
  {
    ((TextView)getView(paramInt1)).setTextColor(paramInt2);
    return this;
  }
  
  public ViewHolder setTextColorRes(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public ViewHolder setTypeface(Typeface paramTypeface, int... paramVarArgs)
  {
    return null;
  }
  
  public ViewHolder setVisible(int paramInt, boolean paramBoolean)
  {
    View localView = getView(paramInt);
    if (paramBoolean) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    localView.setVisibility(paramInt);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\zhy\adapter\recyclerview\base\ViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */