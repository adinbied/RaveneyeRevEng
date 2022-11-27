package org.bouncycastle.crypto.tls;

import java.util.Vector;

class DTLSReassembler
{
  private byte[] body;
  private Vector missing;
  private short msg_type;
  
  DTLSReassembler(short paramShort, int paramInt)
  {
    Vector localVector = new Vector();
    this.missing = localVector;
    this.msg_type = paramShort;
    this.body = new byte[paramInt];
    localVector.addElement(new Range(0, paramInt));
  }
  
  void contributeFragment(short paramShort, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 + paramInt4;
    if ((this.msg_type == paramShort) && (this.body.length == paramInt1))
    {
      if (i > paramInt1) {
        return;
      }
      paramShort = 0;
      if (paramInt4 == 0)
      {
        if ((paramInt3 == 0) && (!this.missing.isEmpty()) && (((Range)this.missing.firstElement()).getEnd() == 0)) {
          this.missing.removeElementAt(0);
        }
        return;
      }
      while (paramShort < this.missing.size())
      {
        Range localRange1 = (Range)this.missing.elementAt(paramShort);
        if (localRange1.getStart() >= i) {
          return;
        }
        paramInt1 = paramShort;
        if (localRange1.getEnd() > paramInt3)
        {
          paramInt4 = Math.max(localRange1.getStart(), paramInt3);
          int j = Math.min(localRange1.getEnd(), i);
          System.arraycopy(paramArrayOfByte, paramInt2 + paramInt4 - paramInt3, this.body, paramInt4, j - paramInt4);
          if (paramInt4 == localRange1.getStart())
          {
            if (j == localRange1.getEnd())
            {
              this.missing.removeElementAt(paramShort);
              paramInt1 = paramShort - 1;
            }
            else
            {
              localRange1.setStart(j);
              paramInt1 = paramShort;
            }
          }
          else
          {
            paramInt1 = paramShort;
            if (j != localRange1.getEnd())
            {
              Vector localVector = this.missing;
              Range localRange2 = new Range(j, localRange1.getEnd());
              paramInt1 = paramShort + 1;
              localVector.insertElementAt(localRange2, paramInt1);
            }
            localRange1.setEnd(paramInt4);
          }
        }
        paramShort = paramInt1 + 1;
      }
    }
  }
  
  byte[] getBodyIfComplete()
  {
    if (this.missing.isEmpty()) {
      return this.body;
    }
    return null;
  }
  
  short getMsgType()
  {
    return this.msg_type;
  }
  
  void reset()
  {
    this.missing.removeAllElements();
    this.missing.addElement(new Range(0, this.body.length));
  }
  
  private static class Range
  {
    private int end;
    private int start;
    
    Range(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public int getEnd()
    {
      return this.end;
    }
    
    public int getStart()
    {
      return this.start;
    }
    
    public void setEnd(int paramInt)
    {
      this.end = paramInt;
    }
    
    public void setStart(int paramInt)
    {
      this.start = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSReassembler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */