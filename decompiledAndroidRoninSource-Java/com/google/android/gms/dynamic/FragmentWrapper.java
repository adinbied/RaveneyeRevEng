package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class FragmentWrapper
  extends IFragmentWrapper.Stub
{
  private Fragment zzia;
  
  private FragmentWrapper(Fragment paramFragment)
  {
    this.zzia = paramFragment;
  }
  
  public static FragmentWrapper wrap(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new FragmentWrapper(paramFragment);
    }
    return null;
  }
  
  public final Bundle getArguments()
  {
    return this.zzia.getArguments();
  }
  
  public final int getId()
  {
    return this.zzia.getId();
  }
  
  public final boolean getRetainInstance()
  {
    return this.zzia.getRetainInstance();
  }
  
  public final String getTag()
  {
    return this.zzia.getTag();
  }
  
  public final int getTargetRequestCode()
  {
    return this.zzia.getTargetRequestCode();
  }
  
  public final boolean getUserVisibleHint()
  {
    return this.zzia.getUserVisibleHint();
  }
  
  public final boolean isAdded()
  {
    return this.zzia.isAdded();
  }
  
  public final boolean isDetached()
  {
    return this.zzia.isDetached();
  }
  
  public final boolean isHidden()
  {
    return this.zzia.isHidden();
  }
  
  public final boolean isInLayout()
  {
    return this.zzia.isInLayout();
  }
  
  public final boolean isRemoving()
  {
    return this.zzia.isRemoving();
  }
  
  public final boolean isResumed()
  {
    return this.zzia.isResumed();
  }
  
  public final boolean isVisible()
  {
    return this.zzia.isVisible();
  }
  
  public final void setHasOptionsMenu(boolean paramBoolean)
  {
    this.zzia.setHasOptionsMenu(paramBoolean);
  }
  
  public final void setMenuVisibility(boolean paramBoolean)
  {
    this.zzia.setMenuVisibility(paramBoolean);
  }
  
  public final void setRetainInstance(boolean paramBoolean)
  {
    this.zzia.setRetainInstance(paramBoolean);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    this.zzia.setUserVisibleHint(paramBoolean);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    this.zzia.startActivity(paramIntent);
  }
  
  public final void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.zzia.startActivityForResult(paramIntent, paramInt);
  }
  
  public final void zza(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzia.registerForContextMenu(paramIObjectWrapper);
  }
  
  public final IObjectWrapper zzae()
  {
    return ObjectWrapper.wrap(this.zzia.getActivity());
  }
  
  public final IFragmentWrapper zzaf()
  {
    return wrap(this.zzia.getParentFragment());
  }
  
  public final IObjectWrapper zzag()
  {
    return ObjectWrapper.wrap(this.zzia.getResources());
  }
  
  public final IFragmentWrapper zzah()
  {
    return wrap(this.zzia.getTargetFragment());
  }
  
  public final IObjectWrapper zzai()
  {
    return ObjectWrapper.wrap(this.zzia.getView());
  }
  
  public final void zzb(IObjectWrapper paramIObjectWrapper)
  {
    paramIObjectWrapper = (View)ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzia.unregisterForContextMenu(paramIObjectWrapper);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\FragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */