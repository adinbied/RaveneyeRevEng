package dji.common.camera;

import java.util.ArrayList;
import java.util.List;

public class FrameInfo
{
  public int mCurFrame;
  public List<Integer> mSupportedFrameList = new ArrayList();
  
  public int getCurFrame()
  {
    return this.mCurFrame;
  }
  
  public List<Integer> getSupportedFrameList()
  {
    return this.mSupportedFrameList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\FrameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */