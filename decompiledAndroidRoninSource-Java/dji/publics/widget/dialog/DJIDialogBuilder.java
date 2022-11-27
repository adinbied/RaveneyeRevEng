package dji.publics.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;

public class DJIDialogBuilder
{
  public static DJICustomDialog createDJICustomDialog(Context paramContext)
  {
    return createDJICustomDialog(paramContext, DJIDialogType.MEDIUM, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJICustomDialog createDJICustomDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJICustomDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIDialog createDJIDialog(Context paramContext)
  {
    return new DJIDialog(paramContext, DJIDialogType.SMALL, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJIDialog createDJIDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJIDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIEditDialog createDJIEditDialog(Context paramContext)
  {
    return new DJIEditDialog(paramContext, DJIDialogType.MEDIUM, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJIEditDialog createDJIEditDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJIEditDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJILargeCustomDialog createDJILargeCustomDialog(Context paramContext)
  {
    return createDJILargeCustomDialog(paramContext, DJIDialogType.LARGE, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJILargeCustomDialog createDJILargeCustomDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJILargeCustomDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIListDialog createDJIListDialog(Context paramContext)
  {
    return new DJIListDialog(paramContext, DJIDialogType.MEDIUM, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJIListDialog createDJIListDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJIListDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIListExtDialog createDJIListExtDialog(Context paramContext)
  {
    return new DJIListExtDialog(paramContext, DJIDialogType.MEDIUM, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJIListExtDialog createDJIListExtDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJIListExtDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIProgressDialog createDJIProgressDialog(Context paramContext)
  {
    return new DJIProgressDialog(paramContext, DJIDialogType.SMALL, DJIDialog.DJIDialogTheme.BLACK);
  }
  
  public static DJIProgressDialog createDJIProgressDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJIProgressDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJITopImageDialog createDJITopImageDialog(Context paramContext)
  {
    return new DJITopImageDialog(paramContext, DJIDialogType.MEDIUM, DJIDialog.DJIDialogTheme.WHITE);
  }
  
  public static DJITopImageDialog createDJITopImageDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme)
  {
    return new DJITopImageDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
  }
  
  public static DJIDialog createDJIViewDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, View paramView1, View paramView2)
  {
    paramContext = new DJIDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    if (paramView1 != null) {
      paramContext.setCustomView(paramView1);
    }
    if (paramView2 != null) {
      paramContext.addTopView(paramView2);
    }
    return paramContext;
  }
  
  public static DJIDialog showNormalCancelDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt1 == 0) {
      str1 = "";
    } else {
      str1 = paramContext.getString(paramInt1);
    }
    if (paramInt2 != 0) {
      str2 = paramContext.getString(paramInt2);
    }
    return showNormalCancelDialog(paramContext, str1, str2);
  }
  
  public static DJIDialog showNormalCancelDialog(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    String str2 = "";
    String str1;
    if (paramInt1 == 0) {
      str1 = "";
    } else {
      str1 = paramContext.getString(paramInt1);
    }
    if (paramInt2 != 0) {
      str2 = paramContext.getString(paramInt2);
    }
    return showNormalCancelDialog(paramContext, str1, str2, paramOnClickListener);
  }
  
  public static DJIDialog showNormalCancelDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return showNormalDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme, paramString1, paramString2, paramContext.getResources().getString(17039360), "", paramOnClickListener, null);
  }
  
  public static DJIDialog showNormalCancelDialog(Context paramContext, String paramString1, String paramString2)
  {
    showNormalCancelDialog(paramContext, paramString1, paramString2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
  }
  
  public static DJIDialog showNormalCancelDialog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return showNormalCancelDialog(paramContext, DJIDialogType.SMALL, DJIDialog.DJIDialogTheme.BLACK, paramString1, paramString2, paramOnClickListener);
  }
  
  public static DJIDialog showNormalConfirmDialog(Context paramContext, int paramInt1, int paramInt2)
  {
    String str2 = "";
    String str1;
    if (paramInt1 == 0) {
      str1 = "";
    } else {
      str1 = paramContext.getString(paramInt1);
    }
    if (paramInt2 != 0) {
      str2 = paramContext.getString(paramInt2);
    }
    return showNormalConfirmDialog(paramContext, str1, str2);
  }
  
  public static DJIDialog showNormalConfirmDialog(Context paramContext, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    String str2 = "";
    String str1;
    if (paramInt1 == 0) {
      str1 = "";
    } else {
      str1 = paramContext.getString(paramInt1);
    }
    if (paramInt2 != 0) {
      str2 = paramContext.getString(paramInt2);
    }
    return showNormalConfirmDialog(paramContext, str1, str2, paramOnClickListener);
  }
  
  public static DJIDialog showNormalConfirmDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return showNormalDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme, paramString1, paramString2, paramContext.getResources().getString(17039370), "", paramOnClickListener, null);
  }
  
  public static DJIDialog showNormalConfirmDialog(Context paramContext, String paramString1, String paramString2)
  {
    showNormalConfirmDialog(paramContext, paramString1, paramString2, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
  }
  
  public static DJIDialog showNormalConfirmDialog(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    return showNormalConfirmDialog(paramContext, DJIDialogType.SMALL, DJIDialog.DJIDialogTheme.BLACK, paramString1, paramString2, paramOnClickListener);
  }
  
  public static DJIDialog showNormalDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DJIDialogType localDJIDialogType = DJIDialogType.SMALL;
    DJIDialog.DJIDialogTheme localDJIDialogTheme = DJIDialog.DJIDialogTheme.BLACK;
    String str1;
    if (paramInt1 == 0) {
      str1 = "";
    } else {
      str1 = paramContext.getString(paramInt1);
    }
    String str2;
    if (paramInt2 == 0) {
      str2 = "";
    } else {
      str2 = paramContext.getString(paramInt2);
    }
    String str3;
    if (paramInt3 == 0) {
      str3 = paramContext.getResources().getString(17039360);
    } else {
      str3 = paramContext.getString(paramInt3);
    }
    String str4;
    if (paramInt4 == 0) {
      str4 = paramContext.getResources().getString(17039370);
    } else {
      str4 = paramContext.getString(paramInt4);
    }
    return showNormalDialog(paramContext, localDJIDialogType, localDJIDialogTheme, str1, str2, str3, str4, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static DJIDialog showNormalDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = new DJIDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    paramContext.setCloseVisibility(paramBoolean1);
    paramContext.setTitle(paramString1);
    if ((paramInt > 0) && (paramInt < 10)) {
      paramContext.setIconType(paramInt);
    } else if (paramInt != 0) {
      paramContext.setTitleIcon(paramInt);
    }
    paramContext.setContent(paramString2);
    if (paramOnClickListener1 != null) {
      paramContext.setLeftBtn(paramString3, paramOnClickListener1, paramBoolean2);
    }
    if (paramOnClickListener2 != null) {
      paramContext.setRightBtn(paramString4, paramOnClickListener2, paramBoolean3);
    }
    paramContext.show();
    return paramContext;
  }
  
  public static DJIDialog showNormalDialog(Context paramContext, DJIDialogType paramDJIDialogType, DJIDialog.DJIDialogTheme paramDJIDialogTheme, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new DJIDialog(paramContext, paramDJIDialogType, paramDJIDialogTheme);
    paramContext.setTitle(paramString1);
    paramContext.setContent(paramString2);
    if (paramOnClickListener1 != null) {
      paramContext.setLeftBtn(paramString3, paramOnClickListener1);
    }
    if (paramOnClickListener2 != null) {
      paramContext.setRightBtn(paramString4, paramOnClickListener2);
    }
    paramContext.show();
    return paramContext;
  }
  
  public static DJIDialog showNormalDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DJIDialogType localDJIDialogType = DJIDialogType.SMALL;
    DJIDialog.DJIDialogTheme localDJIDialogTheme = DJIDialog.DJIDialogTheme.BLACK;
    String str = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      str = paramContext.getResources().getString(17039360);
    }
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString3 = paramContext.getResources().getString(17039370);
    }
    return showNormalDialog(paramContext, localDJIDialogType, localDJIDialogTheme, paramString1, paramString2, str, paramString3, paramOnClickListener1, paramOnClickListener2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIDialogBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */