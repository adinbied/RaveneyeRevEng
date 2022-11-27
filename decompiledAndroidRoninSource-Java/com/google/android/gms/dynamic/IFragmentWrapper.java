package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract interface IFragmentWrapper
  extends IInterface
{
  public abstract Bundle getArguments()
    throws RemoteException;
  
  public abstract int getId()
    throws RemoteException;
  
  public abstract boolean getRetainInstance()
    throws RemoteException;
  
  public abstract String getTag()
    throws RemoteException;
  
  public abstract int getTargetRequestCode()
    throws RemoteException;
  
  public abstract boolean getUserVisibleHint()
    throws RemoteException;
  
  public abstract boolean isAdded()
    throws RemoteException;
  
  public abstract boolean isDetached()
    throws RemoteException;
  
  public abstract boolean isHidden()
    throws RemoteException;
  
  public abstract boolean isInLayout()
    throws RemoteException;
  
  public abstract boolean isRemoving()
    throws RemoteException;
  
  public abstract boolean isResumed()
    throws RemoteException;
  
  public abstract boolean isVisible()
    throws RemoteException;
  
  public abstract void setHasOptionsMenu(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setMenuVisibility(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setRetainInstance(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setUserVisibleHint(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void startActivity(Intent paramIntent)
    throws RemoteException;
  
  public abstract void startActivityForResult(Intent paramIntent, int paramInt)
    throws RemoteException;
  
  public abstract void zza(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public abstract IObjectWrapper zzae()
    throws RemoteException;
  
  public abstract IFragmentWrapper zzaf()
    throws RemoteException;
  
  public abstract IObjectWrapper zzag()
    throws RemoteException;
  
  public abstract IFragmentWrapper zzah()
    throws RemoteException;
  
  public abstract IObjectWrapper zzai()
    throws RemoteException;
  
  public abstract void zzb(IObjectWrapper paramIObjectWrapper)
    throws RemoteException;
  
  public static abstract class Stub
    extends zzb
    implements IFragmentWrapper
  {
    public Stub()
    {
      super();
    }
    
    public static IFragmentWrapper asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      if ((localIInterface instanceof IFragmentWrapper)) {
        return (IFragmentWrapper)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return false;
      case 27: 
        zzb(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 26: 
        startActivityForResult((Intent)zzc.zza(paramParcel1, Intent.CREATOR), paramParcel1.readInt());
        paramParcel2.writeNoException();
        break;
      case 25: 
        startActivity((Intent)zzc.zza(paramParcel1, Intent.CREATOR));
        paramParcel2.writeNoException();
        break;
      case 24: 
        setUserVisibleHint(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        break;
      case 23: 
        setRetainInstance(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        break;
      case 22: 
        setMenuVisibility(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        break;
      case 21: 
        setHasOptionsMenu(zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        break;
      case 20: 
        zza(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        break;
      case 19: 
        bool = isVisible();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 18: 
        bool = isResumed();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 17: 
        bool = isRemoving();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 16: 
        bool = isInLayout();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 15: 
        bool = isHidden();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 14: 
        bool = isDetached();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 13: 
        bool = isAdded();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 12: 
        paramParcel1 = zzai();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        break;
      case 11: 
        bool = getUserVisibleHint();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 10: 
        paramInt1 = getTargetRequestCode();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        break;
      case 9: 
        paramParcel1 = zzah();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        break;
      case 8: 
        paramParcel1 = getTag();
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        break;
      case 7: 
        bool = getRetainInstance();
        paramParcel2.writeNoException();
        zzc.writeBoolean(paramParcel2, bool);
        break;
      case 6: 
        paramParcel1 = zzag();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        break;
      case 5: 
        paramParcel1 = zzaf();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        break;
      case 4: 
        paramInt1 = getId();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        break;
      case 3: 
        paramParcel1 = getArguments();
        paramParcel2.writeNoException();
        zzc.zzb(paramParcel2, paramParcel1);
        break;
      case 2: 
        paramParcel1 = zzae();
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
      return true;
    }
    
    public static final class zza
      extends zza
      implements IFragmentWrapper
    {
      zza(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamic.IFragmentWrapper");
      }
      
      public final Bundle getArguments()
        throws RemoteException
      {
        Parcel localParcel = zza(3, zza());
        Bundle localBundle = (Bundle)zzc.zza(localParcel, Bundle.CREATOR);
        localParcel.recycle();
        return localBundle;
      }
      
      public final int getId()
        throws RemoteException
      {
        Parcel localParcel = zza(4, zza());
        int i = localParcel.readInt();
        localParcel.recycle();
        return i;
      }
      
      public final boolean getRetainInstance()
        throws RemoteException
      {
        Parcel localParcel = zza(7, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final String getTag()
        throws RemoteException
      {
        Parcel localParcel = zza(8, zza());
        String str = localParcel.readString();
        localParcel.recycle();
        return str;
      }
      
      public final int getTargetRequestCode()
        throws RemoteException
      {
        Parcel localParcel = zza(10, zza());
        int i = localParcel.readInt();
        localParcel.recycle();
        return i;
      }
      
      public final boolean getUserVisibleHint()
        throws RemoteException
      {
        Parcel localParcel = zza(11, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isAdded()
        throws RemoteException
      {
        Parcel localParcel = zza(13, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isDetached()
        throws RemoteException
      {
        Parcel localParcel = zza(14, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isHidden()
        throws RemoteException
      {
        Parcel localParcel = zza(15, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isInLayout()
        throws RemoteException
      {
        Parcel localParcel = zza(16, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isRemoving()
        throws RemoteException
      {
        Parcel localParcel = zza(17, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isResumed()
        throws RemoteException
      {
        Parcel localParcel = zza(18, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final boolean isVisible()
        throws RemoteException
      {
        Parcel localParcel = zza(19, zza());
        boolean bool = zzc.zza(localParcel);
        localParcel.recycle();
        return bool;
      }
      
      public final void setHasOptionsMenu(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(21, localParcel);
      }
      
      public final void setMenuVisibility(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(22, localParcel);
      }
      
      public final void setRetainInstance(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(23, localParcel);
      }
      
      public final void setUserVisibleHint(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.writeBoolean(localParcel, paramBoolean);
        zzb(24, localParcel);
      }
      
      public final void startActivity(Intent paramIntent)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIntent);
        zzb(25, localParcel);
      }
      
      public final void startActivityForResult(Intent paramIntent, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIntent);
        localParcel.writeInt(paramInt);
        zzb(26, localParcel);
      }
      
      public final void zza(IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIObjectWrapper);
        zzb(20, localParcel);
      }
      
      public final IObjectWrapper zzae()
        throws RemoteException
      {
        Parcel localParcel = zza(2, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }
      
      public final IFragmentWrapper zzaf()
        throws RemoteException
      {
        Parcel localParcel = zza(5, zza());
        IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIFragmentWrapper;
      }
      
      public final IObjectWrapper zzag()
        throws RemoteException
      {
        Parcel localParcel = zza(6, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }
      
      public final IFragmentWrapper zzah()
        throws RemoteException
      {
        Parcel localParcel = zza(9, zza());
        IFragmentWrapper localIFragmentWrapper = IFragmentWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIFragmentWrapper;
      }
      
      public final IObjectWrapper zzai()
        throws RemoteException
      {
        Parcel localParcel = zza(12, zza());
        IObjectWrapper localIObjectWrapper = IObjectWrapper.Stub.asInterface(localParcel.readStrongBinder());
        localParcel.recycle();
        return localIObjectWrapper;
      }
      
      public final void zzb(IObjectWrapper paramIObjectWrapper)
        throws RemoteException
      {
        Parcel localParcel = zza();
        zzc.zza(localParcel, paramIObjectWrapper);
        zzb(27, localParcel);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamic\IFragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */