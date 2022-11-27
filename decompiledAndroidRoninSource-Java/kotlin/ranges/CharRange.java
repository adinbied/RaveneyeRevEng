package kotlin.ranges;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\020\f\n\002\b\007\n\002\020\013\n\002\b\003\n\002\020\000\n\000\n\002\020\b\n\002\b\002\n\002\020\016\n\002\b\002\030\000 \0252\0020\0012\b\022\004\022\0020\0030\002:\001\025B\025\022\006\020\004\032\0020\003\022\006\020\005\032\0020\003¢\006\002\020\006J\021\020\n\032\0020\0132\006\020\f\032\0020\003H\002J\023\020\r\032\0020\0132\b\020\016\032\004\030\0010\017H\002J\b\020\020\032\0020\021H\026J\b\020\022\032\0020\013H\026J\b\020\023\032\0020\024H\026R\024\020\005\032\0020\0038VX\004¢\006\006\032\004\b\007\020\bR\024\020\004\032\0020\0038VX\004¢\006\006\032\004\b\t\020\b¨\006\026"}, d2={"Lkotlin/ranges/CharRange;", "Lkotlin/ranges/CharProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(CC)V", "getEndInclusive", "()Ljava/lang/Character;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public final class CharRange
  extends CharProgression
  implements ClosedRange<Character>
{
  public static final Companion Companion = new Companion(null);
  private static final CharRange EMPTY = new CharRange((char)1, (char)0);
  
  public CharRange(char paramChar1, char paramChar2)
  {
    super(paramChar1, paramChar2, 1);
  }
  
  public boolean contains(char paramChar)
  {
    return (getFirst() <= paramChar) && (paramChar <= getLast());
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof CharRange)) {
      if ((!isEmpty()) || (!((CharRange)paramObject).isEmpty()))
      {
        int i = getFirst();
        paramObject = (CharRange)paramObject;
        if ((i != ((CharRange)paramObject).getFirst()) || (getLast() != ((CharRange)paramObject).getLast())) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public Character getEndInclusive()
  {
    return Character.valueOf(getLast());
  }
  
  public Character getStart()
  {
    return Character.valueOf(getFirst());
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return getFirst() * '\037' + getLast();
  }
  
  public boolean isEmpty()
  {
    return getFirst() > getLast();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getFirst());
    localStringBuilder.append("..");
    localStringBuilder.append(getLast());
    return localStringBuilder.toString();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2={"Lkotlin/ranges/CharRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/CharRange;", "getEMPTY", "()Lkotlin/ranges/CharRange;", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final CharRange getEMPTY()
    {
      return CharRange.access$getEMPTY$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\ranges\CharRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */