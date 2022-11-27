package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\000\n\002\020!\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\007\b'\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\0022\b\022\004\022\002H\0010\003B\007\b\004¢\006\002\020\004J\035\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0028\000H&¢\006\002\020\nJ\025\020\013\032\0028\0002\006\020\007\032\0020\bH&¢\006\002\020\fJ\036\020\r\032\0028\0002\006\020\007\032\0020\b2\006\020\t\032\0028\000H¦\002¢\006\002\020\016¨\006\017"}, d2={"Lkotlin/collections/AbstractMutableList;", "E", "", "Ljava/util/AbstractList;", "()V", "add", "", "index", "", "element", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract class AbstractMutableList<E>
  extends AbstractList<E>
  implements List<E>, KMutableList
{
  public abstract void add(int paramInt, E paramE);
  
  public abstract int getSize();
  
  public abstract E removeAt(int paramInt);
  
  public abstract E set(int paramInt, E paramE);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\AbstractMutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */