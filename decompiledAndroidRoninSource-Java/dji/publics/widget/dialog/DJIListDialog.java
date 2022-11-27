package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import dji.publics.DJIUI.DJILinearLayout;
import dji.publics.DJIUI.DJIListView;
import dji.publics.DJIUI.DJITextView;
import java.util.Arrays;
import java.util.List;

public class DJIListDialog
  extends DJIDialog
{
  public static final int LIST_DOUBLE_TYPE = 1;
  public static final int LIST_LEFT_MULTI_TYPE = 4;
  public static final int LIST_LEFT_SINGLE_TYPE = 2;
  public static final int LIST_RIGHT_MULTI_TYPE = 5;
  public static final int LIST_RIGHT_SINGLE_TYPE = 3;
  public static final int LIST_SINGLE_TYPE = 0;
  private DJDialogListAdpter mAdapter;
  private List<Boolean> mCheckList;
  private DJIListView mListView;
  
  public DJIListDialog(Context paramContext)
  {
    super(paramContext);
    initView();
  }
  
  public DJIListDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    super(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    initView();
  }
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void measureListView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  /* Error */
  public void setItems(CharSequence[] arg1, CharSequence[] arg2, DialogInterface.OnClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMultiChoiceLeftItems(CharSequence[] arg1, Boolean[] arg2, DialogInterface.OnMultiChoiceClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMultiChoiceRightItems(CharSequence[] arg1, Boolean[] arg2, DialogInterface.OnMultiChoiceClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSingleChoiceLeftItems(CharSequence[] arg1, int arg2, DialogInterface.OnClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSingleChoiceRightItems(CharSequence[] arg1, int arg2, DialogInterface.OnClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSingleRowItems(CharSequence[] arg1, boolean arg2, DialogInterface.OnClickListener arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class DJDialogListAdpter
    extends BaseAdapter
  {
    private List<CharSequence> mData1;
    private List<CharSequence> mData2;
    private LayoutInflater mInflater;
    private DialogInterface.OnClickListener mItemClickListener;
    private int mListType = 0;
    private DialogInterface.OnMultiChoiceClickListener mOnMultiChoiceClickListener;
    private boolean mSingleRowCenter = false;
    
    public DJDialogListAdpter(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence1, CharSequence[] paramArrayOfCharSequence2)
    {
      this.mListType = paramInt;
      if (paramArrayOfCharSequence1 != null) {
        this.mData1 = Arrays.asList(paramArrayOfCharSequence1);
      }
      if (paramArrayOfCharSequence2 != null) {
        this.mData2 = Arrays.asList(paramArrayOfCharSequence2);
      }
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    /* Error */
    private void updateSingleBox(CheckBox arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void clear()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public int getCount()
    {
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return null;
    }
    
    public void setOnItemClickListener(DialogInterface.OnClickListener paramOnClickListener)
    {
      this.mItemClickListener = paramOnClickListener;
    }
    
    public void setOnMultiChoiceClickListener(DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.mOnMultiChoiceClickListener = paramOnMultiChoiceClickListener;
    }
    
    public void setSingleRowCenter(boolean paramBoolean)
    {
      this.mSingleRowCenter = paramBoolean;
    }
  }
  
  private static class ViewHolder
  {
    public DJILinearLayout mItemView;
    public CheckBox mLeftCheckBox;
    public DJITextView mLeftTv;
    public CheckBox mRightCheckBox;
    public DJITextView mRightTv;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIListDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */