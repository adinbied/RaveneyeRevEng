package com.google.android.material.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.google.android.material.R.styleable;

class MaterialCardViewHelper
{
  private static final int DEFAULT_STROKE_VALUE = -1;
  private final MaterialCardView materialCardView;
  private int strokeColor;
  private int strokeWidth;
  
  public MaterialCardViewHelper(MaterialCardView paramMaterialCardView)
  {
    this.materialCardView = paramMaterialCardView;
  }
  
  private void adjustContentPadding()
  {
    int i = this.materialCardView.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.materialCardView.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.materialCardView.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.materialCardView.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.materialCardView.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
  
  private Drawable createForegroundDrawable()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.materialCardView.getRadius());
    int i = this.strokeColor;
    if (i != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, i);
    }
    return localGradientDrawable;
  }
  
  int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public void loadFromAttributes(TypedArray paramTypedArray)
  {
    this.strokeColor = paramTypedArray.getColor(R.styleable.MaterialCardView_strokeColor, -1);
    this.strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
    updateForeground();
    adjustContentPadding();
  }
  
  void setStrokeColor(int paramInt)
  {
    this.strokeColor = paramInt;
    updateForeground();
  }
  
  void setStrokeWidth(int paramInt)
  {
    this.strokeWidth = paramInt;
    updateForeground();
    adjustContentPadding();
  }
  
  void updateForeground()
  {
    this.materialCardView.setForeground(createForegroundDrawable());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\card\MaterialCardViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */