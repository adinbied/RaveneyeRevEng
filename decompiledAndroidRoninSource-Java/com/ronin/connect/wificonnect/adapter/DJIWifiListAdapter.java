package com.ronin.connect.wificonnect.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.airbnb.lottie.LottieAnimationView;
import com.ronin.connect.R.id;
import com.ronin.connect.wificonnect.bean.DJIWifiBean;
import java.util.List;

public class DJIWifiListAdapter
  extends RecyclerView.Adapter<MyViewHolder>
{
  private Context mContext;
  private List<DJIWifiBean> mDataList;
  private OnItemClickListener mOnItemClickListener;
  
  public DJIWifiListAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  /* Error */
  private void setWifiConnected(MyViewHolder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setWifiDisconnect(MyViewHolder arg1)
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
  
  /* Error */
  public void onBindViewHolder(MyViewHolder arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public MyViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return null;
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    this.mOnItemClickListener = paramOnItemClickListener;
  }
  
  public void updateData(List<DJIWifiBean> paramList)
  {
    this.mDataList = paramList;
    notifyDataSetChanged();
  }
  
  static class MyViewHolder
    extends RecyclerView.ViewHolder
  {
    private LottieAnimationView animationView;
    private TextView mTvItemWifiName;
    private TextView mTvItemWifiStatus;
    private View mView;
    
    public MyViewHolder(View paramView)
    {
      super();
      this.mView = paramView;
      this.mTvItemWifiName = ((TextView)paramView.findViewById(R.id.device_name));
      this.mTvItemWifiStatus = ((TextView)paramView.findViewById(R.id.device_connect));
      this.animationView = ((LottieAnimationView)paramView.findViewById(R.id.connect_anim_view));
    }
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(View paramView, DJIWifiBean paramDJIWifiBean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\adapter\DJIWifiListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */