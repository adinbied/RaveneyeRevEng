package org.bouncycastle.jce.provider;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PKIXPolicyNode
  implements PolicyNode
{
  protected List children;
  protected boolean critical;
  protected int depth;
  protected Set expectedPolicies;
  protected PolicyNode parent;
  protected Set policyQualifiers;
  protected String validPolicy;
  
  public PKIXPolicyNode(List paramList, int paramInt, Set paramSet1, PolicyNode paramPolicyNode, Set paramSet2, String paramString, boolean paramBoolean)
  {
    this.children = paramList;
    this.depth = paramInt;
    this.expectedPolicies = paramSet1;
    this.parent = paramPolicyNode;
    this.policyQualifiers = paramSet2;
    this.validPolicy = paramString;
    this.critical = paramBoolean;
  }
  
  public void addChild(PKIXPolicyNode paramPKIXPolicyNode)
  {
    this.children.add(paramPKIXPolicyNode);
    paramPKIXPolicyNode.setParent(this);
  }
  
  public Object clone()
  {
    return copy();
  }
  
  public PKIXPolicyNode copy()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.expectedPolicies.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Set)localObject1).add(new String((String)((Iterator)localObject2).next()));
    }
    localObject2 = new HashSet();
    Object localObject3 = this.policyQualifiers.iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Set)localObject2).add(new String((String)((Iterator)localObject3).next()));
    }
    localObject1 = new PKIXPolicyNode(new ArrayList(), this.depth, (Set)localObject1, null, (Set)localObject2, new String(this.validPolicy), this.critical);
    localObject2 = this.children.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((PKIXPolicyNode)((Iterator)localObject2).next()).copy();
      ((PKIXPolicyNode)localObject3).setParent((PKIXPolicyNode)localObject1);
      ((PKIXPolicyNode)localObject1).addChild((PKIXPolicyNode)localObject3);
    }
    return (PKIXPolicyNode)localObject1;
  }
  
  public Iterator getChildren()
  {
    return this.children.iterator();
  }
  
  public int getDepth()
  {
    return this.depth;
  }
  
  public Set getExpectedPolicies()
  {
    return this.expectedPolicies;
  }
  
  public PolicyNode getParent()
  {
    return this.parent;
  }
  
  public Set getPolicyQualifiers()
  {
    return this.policyQualifiers;
  }
  
  public String getValidPolicy()
  {
    return this.validPolicy;
  }
  
  public boolean hasChildren()
  {
    return this.children.isEmpty() ^ true;
  }
  
  public boolean isCritical()
  {
    return this.critical;
  }
  
  public void removeChild(PKIXPolicyNode paramPKIXPolicyNode)
  {
    this.children.remove(paramPKIXPolicyNode);
  }
  
  public void setCritical(boolean paramBoolean)
  {
    this.critical = paramBoolean;
  }
  
  public void setExpectedPolicies(Set paramSet)
  {
    this.expectedPolicies = paramSet;
  }
  
  public void setParent(PKIXPolicyNode paramPKIXPolicyNode)
  {
    this.parent = paramPKIXPolicyNode;
  }
  
  public String toString()
  {
    return toString("");
  }
  
  public String toString(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.validPolicy);
    localStringBuffer.append(" {\n");
    int i = 0;
    while (i < this.children.size())
    {
      PKIXPolicyNode localPKIXPolicyNode = (PKIXPolicyNode)this.children.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("    ");
      localStringBuffer.append(localPKIXPolicyNode.toString(localStringBuilder.toString()));
      i += 1;
    }
    localStringBuffer.append(paramString);
    localStringBuffer.append("}\n");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PKIXPolicyNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */