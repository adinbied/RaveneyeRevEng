package org.bouncycastle;

import java.io.PrintStream;
import org.bouncycastle.util.Strings;

public class LICENSE
{
  public static String licenseText;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Copyright (c) 2000-2016 The Legion of the Bouncy Castle Inc. (http://www.bouncycastle.org) ");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("Permission is hereby granted, free of charge, to any person obtaining a copy of this software ");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("and associated documentation files (the \"Software\"), to deal in the Software without restriction, ");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, ");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("subject to the following conditions:");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("The above copyright notice and this permission notice shall be included in all copies or substantial");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("portions of the Software.");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER");
    localStringBuilder.append(Strings.lineSeparator());
    localStringBuilder.append("DEALINGS IN THE SOFTWARE.");
    licenseText = localStringBuilder.toString();
  }
  
  public static void main(String[] paramArrayOfString)
  {
    System.out.println(licenseText);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\LICENSE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */