package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialButton
  extends AppCompatButton
{
  public static final int ICON_GRAVITY_START = 1;
  public static final int ICON_GRAVITY_TEXT_START = 2;
  private static final String LOG_TAG = "MaterialButton";
  private Drawable icon;
  private int iconGravity;
  private int iconLeft;
  private int iconPadding;
  private int iconSize;
  private ColorStateList iconTint;
  private PorterDuff.Mode iconTintMode;
  private final MaterialButtonHelper materialButtonHelper;
  
  public MaterialButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.MaterialButton, paramInt, R.style.Widget_MaterialComponents_Button, new int[0]);
    this.iconPadding = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    this.iconTintMode = ViewUtils.parseTintMode(paramContext.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.iconTint = MaterialResources.getColorStateList(getContext(), paramContext, R.styleable.MaterialButton_iconTint);
    this.icon = MaterialResources.getDrawable(getContext(), paramContext, R.styleable.MaterialButton_icon);
    this.iconGravity = paramContext.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    this.iconSize = paramContext.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    paramAttributeSet = new MaterialButtonHelper(this);
    this.materialButtonHelper = paramAttributeSet;
    paramAttributeSet.loadFromAttributes(paramContext);
    paramContext.recycle();
    setCompoundDrawablePadding(this.iconPadding);
    updateIcon();
  }
  
  private boolean isLayoutRTL()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }
  
  private boolean isUsingOriginalBackground()
  {
    MaterialButtonHelper localMaterialButtonHelper = this.materialButtonHelper;
    return (localMaterialButtonHelper != null) && (!localMaterialButtonHelper.isBackgroundOverwritten());
  }
  
  private void updateIcon()
  {
    Object localObject = this.icon;
    if (localObject != null)
    {
      localObject = ((Drawable)localObject).mutate();
      this.icon = ((Drawable)localObject);
      DrawableCompat.setTintList((Drawable)localObject, this.iconTint);
      localObject = this.iconTintMode;
      if (localObject != null) {
        DrawableCompat.setTintMode(this.icon, (PorterDuff.Mode)localObject);
      }
      int i = this.iconSize;
      if (i == 0) {
        i = this.icon.getIntrinsicWidth();
      }
      int j = this.iconSize;
      if (j == 0) {
        j = this.icon.getIntrinsicHeight();
      }
      localObject = this.icon;
      int k = this.iconLeft;
      ((Drawable)localObject).setBounds(k, 0, i + k, j);
    }
    TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getCornerRadius();
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getIconGravity()
  {
    return this.iconGravity;
  }
  
  public int getIconPadding()
  {
    return this.iconPadding;
  }
  
  public int getIconSize()
  {
    return this.iconSize;
  }
  
  public ColorStateList getIconTint()
  {
    return this.iconTint;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.iconTintMode;
  }
  
  public ColorStateList getRippleColor()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getRippleColor();
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getStrokeColor();
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getStrokeWidth();
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getSupportBackgroundTintList();
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (isUsingOriginalBackground()) {
      return this.materialButtonHelper.getSupportBackgroundTintMode();
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (isUsingOriginalBackground())) {
      this.materialButtonHelper.drawStroke(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      MaterialButtonHelper localMaterialButtonHelper = this.materialButtonHelper;
      if (localMaterialButtonHelper != null) {
        localMaterialButtonHelper.updateMaskBounds(paramInt4 - paramInt2, paramInt3 - paramInt1);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.icon != null)
    {
      if (this.iconGravity != 2) {
        return;
      }
      int i = (int)getPaint().measureText(getText().toString());
      paramInt2 = this.iconSize;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = this.icon.getIntrinsicWidth();
      }
      paramInt2 = (getMeasuredWidth() - i - ViewCompat.getPaddingEnd(this) - paramInt1 - this.iconPadding - ViewCompat.getPaddingStart(this)) / 2;
      paramInt1 = paramInt2;
      if (isLayoutRTL()) {
        paramInt1 = -paramInt2;
      }
      if (this.iconLeft != paramInt1)
      {
        this.iconLeft = paramInt1;
        updateIcon();
      }
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (isUsingOriginalBackground())
    {
      this.materialButtonHelper.setBackgroundColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (isUsingOriginalBackground())
    {
      if (paramDrawable != getBackground())
      {
        Log.i("MaterialButton", "Setting a custom background is not supported.");
        this.materialButtonHelper.setBackgroundOverwritten();
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCornerRadius(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      this.materialButtonHelper.setCornerRadius(paramInt);
    }
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.icon != paramDrawable)
    {
      this.icon = paramDrawable;
      updateIcon();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    this.iconGravity = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.iconPadding != paramInt)
    {
      this.iconPadding = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = AppCompatResources.getDrawable(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (this.iconSize != paramInt)
      {
        this.iconSize = paramInt;
        updateIcon();
      }
      return;
    }
    throw new IllegalArgumentException("iconSize cannot be less than 0");
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.iconTint != paramColorStateList)
    {
      this.iconTint = paramColorStateList;
      updateIcon();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.iconTintMode != paramMode)
    {
      this.iconTintMode = paramMode;
      updateIcon();
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground()) {
      this.materialButtonHelper.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground()) {
      this.materialButtonHelper.setStrokeColor(paramColorStateList);
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setStrokeColor(AppCompatResources.getColorStateList(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      this.materialButtonHelper.setStrokeWidth(paramInt);
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (isUsingOriginalBackground()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (isUsingOriginalBackground())
    {
      this.materialButtonHelper.setSupportBackgroundTintList(paramColorStateList);
      return;
    }
    if (this.materialButtonHelper != null) {
      super.setSupportBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (isUsingOriginalBackground())
    {
      this.materialButtonHelper.setSupportBackgroundTintMode(paramMode);
      return;
    }
    if (this.materialButtonHelper != null) {
      super.setSupportBackgroundTintMode(paramMode);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IconGravity {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\button\MaterialButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */