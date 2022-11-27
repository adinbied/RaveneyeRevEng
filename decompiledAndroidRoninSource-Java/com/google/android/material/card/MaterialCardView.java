package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;

public class MaterialCardView
  extends CardView
{
  private final MaterialCardViewHelper cardViewHelper;
  
  public MaterialCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.MaterialCardView, paramInt, R.style.Widget_MaterialComponents_CardView, new int[0]);
    paramAttributeSet = new MaterialCardViewHelper(this);
    this.cardViewHelper = paramAttributeSet;
    paramAttributeSet.loadFromAttributes(paramContext);
    paramContext.recycle();
  }
  
  public int getStrokeColor()
  {
    return this.cardViewHelper.getStrokeColor();
  }
  
  public int getStrokeWidth()
  {
    return this.cardViewHelper.getStrokeWidth();
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.cardViewHelper.updateForeground();
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.cardViewHelper.setStrokeColor(paramInt);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.cardViewHelper.setStrokeWidth(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\card\MaterialCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */