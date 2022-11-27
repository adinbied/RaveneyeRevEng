package dji.thirdparty.afinal;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public abstract class FinalActivity
  extends Activity
{
  public final String TAG = getClass().getSimpleName();
  
  /* Error */
  private void initView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void setListener(java.lang.reflect.Field arg1, String arg2, Method arg3)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setViewSelectListener(java.lang.reflect.Field arg1, String arg2, String arg3)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void finish()
  {
    super.finish();
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    initView();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    initView();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    initView();
  }
  
  private static enum Method
  {
    static
    {
      ItemClick = new Method("ItemClick", 2);
      Method localMethod = new Method("itemLongClick", 3);
      itemLongClick = localMethod;
      $VALUES = new Method[] { Click, LongClick, ItemClick, localMethod };
    }
    
    private Method() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\FinalActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */