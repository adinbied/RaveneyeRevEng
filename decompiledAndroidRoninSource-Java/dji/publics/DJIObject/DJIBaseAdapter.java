package dji.publics.DJIObject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class DJIBaseAdapter
  extends BaseAdapter
{
  private int count;
  
  public abstract View createItemView(int paramInt, ViewGroup paramViewGroup);
  
  public abstract void freshItemView(int paramInt, View paramView);
  
  public int getCount()
  {
    return this.count;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = createItemView(paramInt, paramViewGroup);
    }
    freshItemView(paramInt, localView);
    return localView;
  }
  
  protected void setCount(int paramInt)
  {
    this.count = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIObject\DJIBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */