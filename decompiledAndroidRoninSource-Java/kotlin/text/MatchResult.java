package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\003\n\002\020 \n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\b\bf\030\0002\0020\001:\001\027J\n\020\026\032\004\030\0010\000H&R\024\020\002\032\0020\0038VX\004¢\006\006\032\004\b\004\020\005R\030\020\006\032\b\022\004\022\0020\b0\007X¦\004¢\006\006\032\004\b\t\020\nR\022\020\013\032\0020\fX¦\004¢\006\006\032\004\b\r\020\016R\022\020\017\032\0020\020X¦\004¢\006\006\032\004\b\021\020\022R\022\020\023\032\0020\bX¦\004¢\006\006\032\004\b\024\020\025¨\006\030"}, d2={"Lkotlin/text/MatchResult;", "", "destructured", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "Destructured", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public abstract interface MatchResult
{
  public abstract Destructured getDestructured();
  
  public abstract List<String> getGroupValues();
  
  public abstract MatchGroupCollection getGroups();
  
  public abstract IntRange getRange();
  
  public abstract String getValue();
  
  public abstract MatchResult next();
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 15})
  public static final class DefaultImpls
  {
    public static MatchResult.Destructured getDestructured(MatchResult paramMatchResult)
    {
      return new MatchResult.Destructured(paramMatchResult);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\002\b\n\n\002\020 \n\000\030\0002\0020\001B\017\b\000\022\006\020\002\032\0020\003¢\006\002\020\004J\t\020\007\032\0020\bH\nJ\t\020\t\032\0020\bH\nJ\t\020\n\032\0020\bH\nJ\t\020\013\032\0020\bH\nJ\t\020\f\032\0020\bH\nJ\t\020\r\032\0020\bH\nJ\t\020\016\032\0020\bH\nJ\t\020\017\032\0020\bH\nJ\t\020\020\032\0020\bH\nJ\t\020\021\032\0020\bH\nJ\f\020\022\032\b\022\004\022\0020\b0\023R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\024"}, d2={"Lkotlin/text/MatchResult$Destructured;", "", "match", "Lkotlin/text/MatchResult;", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", "", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "toList", "", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
  public static final class Destructured
  {
    private final MatchResult match;
    
    public Destructured(MatchResult paramMatchResult)
    {
      this.match = paramMatchResult;
    }
    
    private final String component1()
    {
      return (String)getMatch().getGroupValues().get(1);
    }
    
    private final String component10()
    {
      return (String)getMatch().getGroupValues().get(10);
    }
    
    private final String component2()
    {
      return (String)getMatch().getGroupValues().get(2);
    }
    
    private final String component3()
    {
      return (String)getMatch().getGroupValues().get(3);
    }
    
    private final String component4()
    {
      return (String)getMatch().getGroupValues().get(4);
    }
    
    private final String component5()
    {
      return (String)getMatch().getGroupValues().get(5);
    }
    
    private final String component6()
    {
      return (String)getMatch().getGroupValues().get(6);
    }
    
    private final String component7()
    {
      return (String)getMatch().getGroupValues().get(7);
    }
    
    private final String component8()
    {
      return (String)getMatch().getGroupValues().get(8);
    }
    
    private final String component9()
    {
      return (String)getMatch().getGroupValues().get(9);
    }
    
    public final MatchResult getMatch()
    {
      return this.match;
    }
    
    public final List<String> toList()
    {
      return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\text\MatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */