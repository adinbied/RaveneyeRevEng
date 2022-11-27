package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public final class BDS
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<XMSSNode> authenticationPath;
  private int index;
  private int k;
  private Map<Integer, XMSSNode> keep;
  private Map<Integer, LinkedList<XMSSNode>> retain;
  private XMSSNode root;
  private Stack<XMSSNode> stack;
  private List<TreeHash> treeHashInstances;
  private final int treeHeight;
  private transient WOTSPlus wotsPlus;
  private transient XMSS xmss;
  
  protected BDS(XMSS paramXMSS)
  {
    if (paramXMSS != null)
    {
      this.xmss = paramXMSS;
      this.wotsPlus = paramXMSS.getWOTSPlus();
      this.treeHeight = paramXMSS.getParams().getHeight();
      int i = paramXMSS.getParams().getK();
      this.k = i;
      int j = this.treeHeight;
      if ((i <= j) && (i >= 2) && ((j - i) % 2 == 0))
      {
        this.authenticationPath = new ArrayList();
        this.retain = new TreeMap();
        this.stack = new Stack();
        initializeTreeHashInstances();
        this.keep = new TreeMap();
        this.index = 0;
        return;
      }
      throw new IllegalArgumentException("illegal value for BDS parameter k");
    }
    throw new NullPointerException("xmss == null");
  }
  
  private TreeHash getTreeHashInstanceForUpdate()
  {
    Iterator localIterator = this.treeHashInstances.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      TreeHash localTreeHash = (TreeHash)localIterator.next();
      if ((!localTreeHash.isFinished()) && (localTreeHash.isInitialized()))
      {
        if ((localObject == null) || (localTreeHash.getHeight() < ((TreeHash)localObject).getHeight())) {}
        for (;;)
        {
          localObject = localTreeHash;
          break;
          if ((localTreeHash.getHeight() != ((TreeHash)localObject).getHeight()) || (localTreeHash.getIndexLeaf() >= ((TreeHash)localObject).getIndexLeaf())) {
            break;
          }
        }
      }
    }
    return (TreeHash)localObject;
  }
  
  private void initializeTreeHashInstances()
  {
    this.treeHashInstances = new ArrayList();
    int i = 0;
    while (i < this.treeHeight - this.k)
    {
      this.treeHashInstances.add(new TreeHash(i, null));
      i += 1;
    }
  }
  
  protected List<XMSSNode> getAuthenticationPath()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.authenticationPath.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((XMSSNode)localIterator.next()).clone());
    }
    return localArrayList;
  }
  
  protected int getIndex()
  {
    return this.index;
  }
  
  protected XMSSNode getRoot()
  {
    return this.root.clone();
  }
  
  protected int getTreeHeight()
  {
    return this.treeHeight;
  }
  
  protected XMSSNode initialize(OTSHashAddress paramOTSHashAddress)
  {
    if (paramOTSHashAddress != null)
    {
      Object localObject1 = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).build();
      Object localObject2 = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).build();
      int i = 0;
      OTSHashAddress localOTSHashAddress = paramOTSHashAddress;
      paramOTSHashAddress = (OTSHashAddress)localObject2;
      while (i < 1 << this.treeHeight)
      {
        localOTSHashAddress = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(localOTSHashAddress.getLayerAddress())).withTreeAddress(localOTSHashAddress.getTreeAddress())).withOTSAddress(i).withChainAddress(localOTSHashAddress.getChainAddress()).withHashAddress(localOTSHashAddress.getHashAddress()).withKeyAndMask(localOTSHashAddress.getKeyAndMask())).build();
        this.wotsPlus.importKeys(this.xmss.getWOTSPlusSecretKey(localOTSHashAddress), this.xmss.getPublicSeed());
        Object localObject3 = this.wotsPlus.getPublicKey(localOTSHashAddress);
        localObject2 = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(((LTreeAddress)localObject1).getLayerAddress())).withTreeAddress(((LTreeAddress)localObject1).getTreeAddress())).withLTreeAddress(i).withTreeHeight(((LTreeAddress)localObject1).getTreeHeight()).withTreeIndex(((LTreeAddress)localObject1).getTreeIndex()).withKeyAndMask(((LTreeAddress)localObject1).getKeyAndMask())).build();
        localObject1 = this.xmss.lTree((WOTSPlusPublicKeyParameters)localObject3, (LTreeAddress)localObject2);
        for (paramOTSHashAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withTreeIndex(i).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build(); (!this.stack.isEmpty()) && (((XMSSNode)this.stack.peek()).getHeight() == ((XMSSNode)localObject1).getHeight()); paramOTSHashAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withTreeHeight(paramOTSHashAddress.getTreeHeight() + 1).withTreeIndex(paramOTSHashAddress.getTreeIndex()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build())
        {
          int j = (int)Math.floor(i / (1 << ((XMSSNode)localObject1).getHeight()));
          if (j == 1) {
            this.authenticationPath.add(((XMSSNode)localObject1).clone());
          }
          if ((j == 3) && (((XMSSNode)localObject1).getHeight() < this.treeHeight - this.k)) {
            ((TreeHash)this.treeHashInstances.get(((XMSSNode)localObject1).getHeight())).setNode(((XMSSNode)localObject1).clone());
          }
          if ((j >= 3) && ((j & 0x1) == 1) && (((XMSSNode)localObject1).getHeight() >= this.treeHeight - this.k) && (((XMSSNode)localObject1).getHeight() <= this.treeHeight - 2)) {
            if (this.retain.get(Integer.valueOf(((XMSSNode)localObject1).getHeight())) == null)
            {
              localObject3 = new LinkedList();
              ((LinkedList)localObject3).add(((XMSSNode)localObject1).clone());
              this.retain.put(Integer.valueOf(((XMSSNode)localObject1).getHeight()), localObject3);
            }
            else
            {
              ((LinkedList)this.retain.get(Integer.valueOf(((XMSSNode)localObject1).getHeight()))).add(((XMSSNode)localObject1).clone());
            }
          }
          paramOTSHashAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withTreeHeight(paramOTSHashAddress.getTreeHeight()).withTreeIndex((paramOTSHashAddress.getTreeIndex() - 1) / 2).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
          localObject1 = this.xmss.randomizeHash((XMSSNode)this.stack.pop(), (XMSSNode)localObject1, paramOTSHashAddress);
          localObject1 = new XMSSNode(((XMSSNode)localObject1).getHeight() + 1, ((XMSSNode)localObject1).getValue());
        }
        this.stack.push(localObject1);
        i += 1;
        localObject1 = localObject2;
      }
      paramOTSHashAddress = (XMSSNode)this.stack.pop();
      this.root = paramOTSHashAddress;
      return paramOTSHashAddress.clone();
    }
    throw new NullPointerException("otsHashAddress == null");
  }
  
  protected void nextAuthenticationPath(OTSHashAddress paramOTSHashAddress)
  {
    if (paramOTSHashAddress != null)
    {
      if (this.index <= (1 << this.treeHeight) - 2)
      {
        Object localObject2 = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).build();
        Object localObject1 = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).build();
        int j = XMSSUtil.calculateTau(this.index, this.treeHeight);
        if (((this.index >> j + 1 & 0x1) == 0) && (j < this.treeHeight - 1)) {
          this.keep.put(Integer.valueOf(j), ((XMSSNode)this.authenticationPath.get(j)).clone());
        }
        int m = 0;
        if (j == 0)
        {
          localObject1 = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(this.index).withChainAddress(paramOTSHashAddress.getChainAddress()).withHashAddress(paramOTSHashAddress.getHashAddress()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
          this.wotsPlus.importKeys(this.xmss.getWOTSPlusSecretKey((OTSHashAddress)localObject1), this.xmss.getPublicSeed());
          paramOTSHashAddress = this.wotsPlus.getPublicKey((OTSHashAddress)localObject1);
          localObject2 = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(((LTreeAddress)localObject2).getLayerAddress())).withTreeAddress(((LTreeAddress)localObject2).getTreeAddress())).withLTreeAddress(this.index).withTreeHeight(((LTreeAddress)localObject2).getTreeHeight()).withTreeIndex(((LTreeAddress)localObject2).getTreeIndex()).withKeyAndMask(((LTreeAddress)localObject2).getKeyAndMask())).build();
          paramOTSHashAddress = this.xmss.lTree(paramOTSHashAddress, (LTreeAddress)localObject2);
          this.authenticationPath.set(0, paramOTSHashAddress);
          j = m;
        }
        else
        {
          localObject2 = (HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(((HashTreeAddress)localObject1).getLayerAddress())).withTreeAddress(((HashTreeAddress)localObject1).getTreeAddress());
          int i = j - 1;
          localObject1 = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)localObject2).withTreeHeight(i).withTreeIndex(this.index >> j).withKeyAndMask(((HashTreeAddress)localObject1).getKeyAndMask())).build();
          localObject1 = this.xmss.randomizeHash((XMSSNode)this.authenticationPath.get(i), (XMSSNode)this.keep.get(Integer.valueOf(i)), (XMSSAddress)localObject1);
          localObject1 = new XMSSNode(((XMSSNode)localObject1).getHeight() + 1, ((XMSSNode)localObject1).getValue());
          this.authenticationPath.set(j, localObject1);
          this.keep.remove(Integer.valueOf(i));
          i = 0;
          while (i < j)
          {
            if (i < this.treeHeight - this.k)
            {
              localObject1 = this.authenticationPath;
              localObject2 = ((TreeHash)this.treeHashInstances.get(i)).tailNode.clone();
            }
            else
            {
              localObject1 = this.authenticationPath;
              localObject2 = ((LinkedList)this.retain.get(Integer.valueOf(i))).removeFirst();
            }
            ((List)localObject1).set(i, localObject2);
            i += 1;
          }
          int n = Math.min(j, this.treeHeight - this.k);
          i = 0;
          for (;;)
          {
            j = m;
            localObject1 = paramOTSHashAddress;
            if (i >= n) {
              break;
            }
            j = this.index + 1 + (1 << i) * 3;
            if (j < 1 << this.treeHeight) {
              ((TreeHash)this.treeHashInstances.get(i)).initialize(j);
            }
            i += 1;
          }
        }
        while (j < this.treeHeight - this.k >> 1)
        {
          paramOTSHashAddress = getTreeHashInstanceForUpdate();
          if (paramOTSHashAddress != null) {
            paramOTSHashAddress.update((OTSHashAddress)localObject1);
          }
          j += 1;
        }
        this.index += 1;
        return;
      }
      throw new IllegalStateException("index out of bounds");
    }
    throw new NullPointerException("otsHashAddress == null");
  }
  
  protected void setXMSS(XMSS paramXMSS)
  {
    this.xmss = paramXMSS;
    this.wotsPlus = paramXMSS.getWOTSPlus();
  }
  
  protected void validate()
  {
    if (this.treeHeight == this.xmss.getParams().getHeight())
    {
      if (this.authenticationPath != null)
      {
        if (this.retain != null)
        {
          if (this.stack != null)
          {
            if (this.treeHashInstances != null)
            {
              if (this.keep != null)
              {
                if (XMSSUtil.isIndexValid(this.treeHeight, this.index)) {
                  return;
                }
                throw new IllegalStateException("index in BDS state out of bounds");
              }
              throw new IllegalStateException("keep == null");
            }
            throw new IllegalStateException("treeHashInstances == null");
          }
          throw new IllegalStateException("stack == null");
        }
        throw new IllegalStateException("retain == null");
      }
      throw new IllegalStateException("authenticationPath == null");
    }
    throw new IllegalStateException("wrong height");
  }
  
  private final class TreeHash
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    private boolean finished;
    private int height;
    private final int initialHeight;
    private boolean initialized;
    private int nextIndex;
    private XMSSNode tailNode;
    
    private TreeHash(int paramInt)
    {
      this.initialHeight = paramInt;
      this.initialized = false;
      this.finished = false;
    }
    
    private int getHeight()
    {
      if ((this.initialized) && (!this.finished)) {
        return this.height;
      }
      return Integer.MAX_VALUE;
    }
    
    private int getIndexLeaf()
    {
      return this.nextIndex;
    }
    
    private void initialize(int paramInt)
    {
      this.tailNode = null;
      this.height = this.initialHeight;
      this.nextIndex = paramInt;
      this.initialized = true;
      this.finished = false;
    }
    
    private boolean isFinished()
    {
      return this.finished;
    }
    
    private boolean isInitialized()
    {
      return this.initialized;
    }
    
    private void setNode(XMSSNode paramXMSSNode)
    {
      this.tailNode = paramXMSSNode;
      int i = paramXMSSNode.getHeight();
      this.height = i;
      if (i == this.initialHeight) {
        this.finished = true;
      }
    }
    
    private void update(OTSHashAddress paramOTSHashAddress)
    {
      if (paramOTSHashAddress != null)
      {
        if ((!this.finished) && (this.initialized))
        {
          Object localObject = (OTSHashAddress)((OTSHashAddress.Builder)((OTSHashAddress.Builder)((OTSHashAddress.Builder)new OTSHashAddress.Builder().withLayerAddress(paramOTSHashAddress.getLayerAddress())).withTreeAddress(paramOTSHashAddress.getTreeAddress())).withOTSAddress(this.nextIndex).withChainAddress(paramOTSHashAddress.getChainAddress()).withHashAddress(paramOTSHashAddress.getHashAddress()).withKeyAndMask(paramOTSHashAddress.getKeyAndMask())).build();
          paramOTSHashAddress = (LTreeAddress)((LTreeAddress.Builder)((LTreeAddress.Builder)new LTreeAddress.Builder().withLayerAddress(((OTSHashAddress)localObject).getLayerAddress())).withTreeAddress(((OTSHashAddress)localObject).getTreeAddress())).withLTreeAddress(this.nextIndex).build();
          HashTreeAddress localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(((OTSHashAddress)localObject).getLayerAddress())).withTreeAddress(((OTSHashAddress)localObject).getTreeAddress())).withTreeIndex(this.nextIndex).build();
          BDS.this.wotsPlus.importKeys(BDS.this.xmss.getWOTSPlusSecretKey((OTSHashAddress)localObject), BDS.this.xmss.getPublicSeed());
          localObject = BDS.this.wotsPlus.getPublicKey((OTSHashAddress)localObject);
          paramOTSHashAddress = BDS.this.xmss.lTree((WOTSPlusPublicKeyParameters)localObject, paramOTSHashAddress);
          while ((!BDS.this.stack.isEmpty()) && (((XMSSNode)BDS.this.stack.peek()).getHeight() == paramOTSHashAddress.getHeight()) && (((XMSSNode)BDS.this.stack.peek()).getHeight() != this.initialHeight))
          {
            localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(localHashTreeAddress.getLayerAddress())).withTreeAddress(localHashTreeAddress.getTreeAddress())).withTreeHeight(localHashTreeAddress.getTreeHeight()).withTreeIndex((localHashTreeAddress.getTreeIndex() - 1) / 2).withKeyAndMask(localHashTreeAddress.getKeyAndMask())).build();
            paramOTSHashAddress = BDS.this.xmss.randomizeHash((XMSSNode)BDS.this.stack.pop(), paramOTSHashAddress, localHashTreeAddress);
            paramOTSHashAddress = new XMSSNode(paramOTSHashAddress.getHeight() + 1, paramOTSHashAddress.getValue());
            localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(localHashTreeAddress.getLayerAddress())).withTreeAddress(localHashTreeAddress.getTreeAddress())).withTreeHeight(localHashTreeAddress.getTreeHeight() + 1).withTreeIndex(localHashTreeAddress.getTreeIndex()).withKeyAndMask(localHashTreeAddress.getKeyAndMask())).build();
          }
          localObject = this.tailNode;
          if (localObject == null)
          {
            this.tailNode = paramOTSHashAddress;
          }
          else if (((XMSSNode)localObject).getHeight() == paramOTSHashAddress.getHeight())
          {
            localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(localHashTreeAddress.getLayerAddress())).withTreeAddress(localHashTreeAddress.getTreeAddress())).withTreeHeight(localHashTreeAddress.getTreeHeight()).withTreeIndex((localHashTreeAddress.getTreeIndex() - 1) / 2).withKeyAndMask(localHashTreeAddress.getKeyAndMask())).build();
            paramOTSHashAddress = BDS.this.xmss.randomizeHash(this.tailNode, paramOTSHashAddress, localHashTreeAddress);
            paramOTSHashAddress = new XMSSNode(this.tailNode.getHeight() + 1, paramOTSHashAddress.getValue());
            this.tailNode = paramOTSHashAddress;
            localHashTreeAddress = (HashTreeAddress)((HashTreeAddress.Builder)((HashTreeAddress.Builder)((HashTreeAddress.Builder)new HashTreeAddress.Builder().withLayerAddress(localHashTreeAddress.getLayerAddress())).withTreeAddress(localHashTreeAddress.getTreeAddress())).withTreeHeight(localHashTreeAddress.getTreeHeight() + 1).withTreeIndex(localHashTreeAddress.getTreeIndex()).withKeyAndMask(localHashTreeAddress.getKeyAndMask())).build();
          }
          else
          {
            BDS.this.stack.push(paramOTSHashAddress);
          }
          if (this.tailNode.getHeight() == this.initialHeight)
          {
            this.finished = true;
            return;
          }
          this.height = paramOTSHashAddress.getHeight();
          this.nextIndex += 1;
          return;
        }
        throw new IllegalStateException("finished or not initialized");
      }
      throw new NullPointerException("otsHashAddress == null");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\xmss\BDS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */