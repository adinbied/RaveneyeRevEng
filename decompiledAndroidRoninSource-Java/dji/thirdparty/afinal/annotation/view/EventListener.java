package dji.thirdparty.afinal.annotation.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import dji.thirdparty.afinal.exception.ViewException;
import java.lang.reflect.Method;

public class EventListener
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener
{
  private String clickMethod;
  private Object handler;
  private String itemClickMethod;
  private String itemLongClickMehtod;
  private String itemSelectMethod;
  private String longClickMethod;
  private String nothingSelectedMethod;
  
  public EventListener(Object paramObject)
  {
    this.handler = paramObject;
  }
  
  private static Object invokeClickMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { View.class });
      if (localMethod != null) {
        return localMethod.invoke(paramObject, paramVarArgs);
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("no such method:");
      ((StringBuilder)paramObject).append(paramString);
      throw new ViewException(((StringBuilder)paramObject).toString());
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
  
  private static Object invokeItemClickMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { AdapterView.class, View.class, Integer.TYPE, Long.TYPE });
      if (localMethod != null) {
        return localMethod.invoke(paramObject, paramVarArgs);
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("no such method:");
      ((StringBuilder)paramObject).append(paramString);
      throw new ViewException(((StringBuilder)paramObject).toString());
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
  
  private static boolean invokeItemLongClickMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject != null) {
      try
      {
        Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { AdapterView.class, View.class, Integer.TYPE, Long.TYPE });
        if (localMethod != null)
        {
          paramObject = localMethod.invoke(paramObject, paramVarArgs);
          boolean bool;
          if (paramObject == null) {
            bool = false;
          } else {
            bool = Boolean.valueOf(paramObject.toString()).booleanValue();
          }
          return Boolean.valueOf(bool).booleanValue();
        }
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("no such method:");
        ((StringBuilder)paramObject).append(paramString);
        throw new ViewException(((StringBuilder)paramObject).toString());
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
        return false;
      }
    }
    throw new ViewException("invokeItemLongClickMethod: handler is null :");
  }
  
  private static Object invokeItemSelectMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { AdapterView.class, View.class, Integer.TYPE, Long.TYPE });
      if (localMethod != null) {
        return localMethod.invoke(paramObject, paramVarArgs);
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("no such method:");
      ((StringBuilder)paramObject).append(paramString);
      throw new ViewException(((StringBuilder)paramObject).toString());
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
  
  private static boolean invokeLongClickMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { View.class });
      if (localMethod != null)
      {
        paramObject = localMethod.invoke(paramObject, paramVarArgs);
        if (paramObject == null) {
          return false;
        }
        return Boolean.valueOf(paramObject.toString()).booleanValue();
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("no such method:");
      ((StringBuilder)paramObject).append(paramString);
      throw new ViewException(((StringBuilder)paramObject).toString());
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return false;
  }
  
  private static Object invokeNoSelectMethod(Object paramObject, String paramString, Object... paramVarArgs)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { AdapterView.class });
      if (localMethod != null) {
        return localMethod.invoke(paramObject, paramVarArgs);
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("no such method:");
      ((StringBuilder)paramObject).append(paramString);
      throw new ViewException(((StringBuilder)paramObject).toString());
    }
    catch (Exception paramObject)
    {
      ((Exception)paramObject).printStackTrace();
    }
    return null;
  }
  
  public EventListener click(String paramString)
  {
    this.clickMethod = paramString;
    return this;
  }
  
  public EventListener itemClick(String paramString)
  {
    this.itemClickMethod = paramString;
    return this;
  }
  
  public EventListener itemLongClick(String paramString)
  {
    this.itemLongClickMehtod = paramString;
    return this;
  }
  
  public EventListener longClick(String paramString)
  {
    this.longClickMethod = paramString;
    return this;
  }
  
  public EventListener noSelect(String paramString)
  {
    this.nothingSelectedMethod = paramString;
    return this;
  }
  
  /* Error */
  public void onClick(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onItemClick(AdapterView<?> arg1, View arg2, int arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  /* Error */
  public void onItemSelected(AdapterView<?> arg1, View arg2, int arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  /* Error */
  public void onNothingSelected(AdapterView<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public EventListener select(String paramString)
  {
    this.itemSelectMethod = paramString;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\annotation\view\EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */