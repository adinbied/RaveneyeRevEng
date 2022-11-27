package lecho.lib.hellocharts.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Viewport
  implements Parcelable
{
  public static final Parcelable.Creator<Viewport> CREATOR = new Parcelable.Creator()
  {
    public Viewport createFromParcel(Parcel paramAnonymousParcel)
    {
      return null;
    }
    
    public Viewport[] newArray(int paramAnonymousInt)
    {
      return new Viewport[paramAnonymousInt];
    }
  };
  public float bottom;
  public float left;
  public float right;
  public float top;
  
  public Viewport() {}
  
  public Viewport(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  public Viewport(Viewport paramViewport)
  {
    if (paramViewport == null)
    {
      this.bottom = 0.0F;
      this.right = 0.0F;
      this.top = 0.0F;
      this.left = 0.0F;
      return;
    }
    this.left = paramViewport.left;
    this.top = paramViewport.top;
    this.right = paramViewport.right;
    this.bottom = paramViewport.bottom;
  }
  
  public final float centerX()
  {
    return 0.0F;
  }
  
  public final float centerY()
  {
    return 0.0F;
  }
  
  public boolean contains(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean contains(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return false;
  }
  
  public boolean contains(Viewport paramViewport)
  {
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public final float height()
  {
    return this.top - this.bottom;
  }
  
  /* Error */
  public void inset(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public boolean intersect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return false;
  }
  
  public boolean intersect(Viewport paramViewport)
  {
    return false;
  }
  
  public final boolean isEmpty()
  {
    return false;
  }
  
  /* Error */
  public void offset(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void offsetTo(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void readFromParcel(Parcel arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }
  
  /* Error */
  public void set(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setEmpty()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
  
  /* Error */
  public void union(float arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void union(Viewport arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final float width()
  {
    return this.right - this.left;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.left);
    paramParcel.writeFloat(this.top);
    paramParcel.writeFloat(this.right);
    paramParcel.writeFloat(this.bottom);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\model\Viewport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */