package com.drew.metadata.gif;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class GifControlDirectory
  extends Directory
{
  public static final int TAG_DELAY = 1;
  public static final int TAG_DISPOSAL_METHOD = 2;
  public static final int TAG_TRANSPARENT_COLOR_FLAG = 4;
  public static final int TAG_TRANSPARENT_COLOR_INDEX = 5;
  public static final int TAG_USER_INPUT_FLAG = 3;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(1), "Delay");
    _tagNameMap.put(Integer.valueOf(2), "Disposal Method");
    _tagNameMap.put(Integer.valueOf(3), "User Input Flag");
    _tagNameMap.put(Integer.valueOf(4), "Transparent Color Flag");
    _tagNameMap.put(Integer.valueOf(5), "Transparent Color Index");
  }
  
  public GifControlDirectory()
  {
    setDescriptor(new GifControlDescriptor(this));
  }
  
  public DisposalMethod getDisposalMethod()
  {
    return (DisposalMethod)getObject(2);
  }
  
  public String getName()
  {
    return "GIF Control";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
  
  public boolean isTransparent()
  {
    return false;
  }
  
  public static enum DisposalMethod
  {
    static
    {
      DO_NOT_DISPOSE = new DisposalMethod("DO_NOT_DISPOSE", 1);
      RESTORE_TO_BACKGROUND_COLOR = new DisposalMethod("RESTORE_TO_BACKGROUND_COLOR", 2);
      RESTORE_TO_PREVIOUS = new DisposalMethod("RESTORE_TO_PREVIOUS", 3);
      TO_BE_DEFINED = new DisposalMethod("TO_BE_DEFINED", 4);
      DisposalMethod localDisposalMethod = new DisposalMethod("INVALID", 5);
      INVALID = localDisposalMethod;
      $VALUES = new DisposalMethod[] { NOT_SPECIFIED, DO_NOT_DISPOSE, RESTORE_TO_BACKGROUND_COLOR, RESTORE_TO_PREVIOUS, TO_BE_DEFINED, localDisposalMethod };
    }
    
    private DisposalMethod() {}
    
    public static DisposalMethod typeOf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return INVALID;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        return TO_BE_DEFINED;
      case 3: 
        return RESTORE_TO_PREVIOUS;
      case 2: 
        return RESTORE_TO_BACKGROUND_COLOR;
      case 1: 
        return DO_NOT_DISPOSE;
      }
      return NOT_SPECIFIED;
    }
    
    public String toString()
    {
      switch (GifControlDirectory.1.$SwitchMap$com$drew$metadata$gif$GifControlDirectory$DisposalMethod[ordinal()])
      {
      default: 
        return super.toString();
      case 6: 
        return "To Be Defined";
      case 5: 
        return "Restore to Previous";
      case 4: 
        return "Restore to Background Color";
      case 3: 
        return "Not Specified";
      case 2: 
        return "Invalid value";
      }
      return "Don't Dispose";
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\gif\GifControlDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */