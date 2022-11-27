package dji.publics.DJIUI;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RadioButton;
import dji.frame.widget.R.styleable;

public class DJIRadioButton
  extends RadioButton
{
  public static final int TYPEFACE_BOLD = 3;
  public static final int TYPEFACE_DEMI = 0;
  public static final int TYPEFACE_NBOLD = 2;
  public static final int TYPEFACE_NLIGHT = 1;
  public static final int TYPEFACE_NONE = -1;
  
  public DJIRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DJITextView);
    int i = paramContext.getInt(R.styleable.DJITextView_djiTextFace, -1);
    paramContext.recycle();
    paramContext = getTypeface();
    if (i == 0) {
      return;
    }
    if (1 == i)
    {
      paramContext = Typeface.create("sans-serif-light", 0);
      if (paramContext != null) {
        setTypeface(paramContext);
      }
    }
    else if (2 == i)
    {
      if ((paramContext != null) && (!paramContext.isBold())) {
        setTypeface(paramContext, 1);
      }
    }
    else if ((3 == i) && (paramContext != null) && (!paramContext.isBold()))
    {
      setTypeface(paramContext, 1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIRadioButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */