package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public final class SupportFragmentWrapper
  extends IFragmentWrapper.Stub
{
  private Fragment zzie;
  
  private SupportFragmentWrapper(Fragment paramFragment)
  {
    this.zzie = paramFragment;
  }
  
  public static SupportFragmentWrapper wrap(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new SupportFragmentWrapper(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return this.zzie.getArguments();
  }
  
  public final int getId()
  {
    return this.zzie.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return this.zzie.getRetainInstance();
  }
  
  public final String getTag()
  {
    return this.zzie.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return this.zzie.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return this.zzie.getUserVisibleHint();
  }
  
  public final boolean isAdded()
  {
    return this.zzie.isAdded();
  }
  
  public final boolean isDetached()
  {
    return this.zzie.isDetached();
  }
  
  public final boolean isHidden()
  {
    return this.zzie.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return this.zzie.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return this.zzie.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return this.zzie.isResumed();
  }
  
  public final boolean isVisible()
  {
    return this.zzie.isVisible();
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzie.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    this.zzie.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    this.zzie.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzie.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.zzie.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzie.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void zza(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzie.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final IObjectWrapper zzae()
  {
    return ObjectWrapper.wrap(this.zzie.getActivity());
  }
  
  public final IFragmentWrapper zzaf()
  {
    return wrap(this.zzie.getParentFragment());
  }
  
  public final IObjectWrapper zzag()
  {
    return ObjectWrapper.wrap(this.zzie.getResources());
  }
  
  public final IFragmentWrapper zzah()
  {
    return wrap(this.zzie.getTargetFragment());
  }
  
  public final IObjectWrapper zzai()
  {
    return ObjectWrapper.wrap(this.zzie.getView());
  }
  
  public final void zzb(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzie.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\SupportFragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */