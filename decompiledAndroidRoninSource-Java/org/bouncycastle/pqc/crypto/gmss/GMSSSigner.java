package org.bouncycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.bouncycastle.pqc.crypto.gmss.util.GMSSUtil;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.bouncycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.bouncycastle.util.Arrays;

public class GMSSSigner
  implements MessageSigner
{
  private byte[][][] currentAuthPaths;
  private GMSSDigestProvider digestProvider;
  private GMSSParameters gmssPS;
  private GMSSRandom gmssRandom;
  private GMSSUtil gmssUtil = new GMSSUtil();
  private int[] index;
  GMSSKeyParameters key;
  private int mdLength;
  private Digest messDigestOTS;
  private Digest messDigestTrees;
  private int numLayer;
  private WinternitzOTSignature ots;
  private byte[] pubKeyBytes;
  private SecureRandom random;
  private byte[][] subtreeRootSig;
  
  public GMSSSigner(GMSSDigestProvider paramGMSSDigestProvider)
  {
    this.digestProvider = paramGMSSDigestProvider;
    paramGMSSDigestProvider = paramGMSSDigestProvider.get();
    this.messDigestTrees = paramGMSSDigestProvider;
    this.messDigestOTS = paramGMSSDigestProvider;
    this.mdLength = paramGMSSDigestProvider.getDigestSize();
    this.gmssRandom = new GMSSRandom(this.messDigestTrees);
  }
  
  private void initSign()
  {
    this.messDigestTrees.reset();
    GMSSPrivateKeyParameters localGMSSPrivateKeyParameters = (GMSSPrivateKeyParameters)this.key;
    if (!localGMSSPrivateKeyParameters.isUsed())
    {
      if (localGMSSPrivateKeyParameters.getIndex(0) < localGMSSPrivateKeyParameters.getNumLeafs(0))
      {
        Object localObject1 = localGMSSPrivateKeyParameters.getParameters();
        this.gmssPS = ((GMSSParameters)localObject1);
        this.numLayer = ((GMSSParameters)localObject1).getNumOfLayers();
        localObject1 = localGMSSPrivateKeyParameters.getCurrentSeeds()[(this.numLayer - 1)];
        int i = this.mdLength;
        Object localObject2 = new byte[i];
        localObject2 = new byte[i];
        System.arraycopy(localObject1, 0, localObject2, 0, i);
        this.ots = new WinternitzOTSignature(this.gmssRandom.nextSeed((byte[])localObject2), this.digestProvider.get(), this.gmssPS.getWinternitzParameter()[(this.numLayer - 1)]);
        localObject1 = localGMSSPrivateKeyParameters.getCurrentAuthPaths();
        this.currentAuthPaths = new byte[this.numLayer][][];
        i = 0;
        int j;
        for (;;)
        {
          j = this.numLayer;
          if (i >= j) {
            break;
          }
          this.currentAuthPaths[i] = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { localObject1[i].length, this.mdLength }));
          j = 0;
          while (j < localObject1[i].length)
          {
            System.arraycopy(localObject1[i][j], 0, this.currentAuthPaths[i][j], 0, this.mdLength);
            j += 1;
          }
          i += 1;
        }
        this.index = new int[j];
        System.arraycopy(localGMSSPrivateKeyParameters.getIndex(), 0, this.index, 0, this.numLayer);
        this.subtreeRootSig = new byte[this.numLayer - 1][];
        i = 0;
        while (i < this.numLayer - 1)
        {
          localObject1 = localGMSSPrivateKeyParameters.getSubtreeRootSig(i);
          localObject2 = this.subtreeRootSig;
          localObject2[i] = new byte[localObject1.length];
          System.arraycopy(localObject1, 0, localObject2[i], 0, localObject1.length);
          i += 1;
        }
        localGMSSPrivateKeyParameters.markUsed();
        return;
      }
      throw new IllegalStateException("No more signatures can be generated");
    }
    throw new IllegalStateException("Private key already used");
  }
  
  private void initVerify()
  {
    this.messDigestTrees.reset();
    Object localObject = (GMSSPublicKeyParameters)this.key;
    this.pubKeyBytes = ((GMSSPublicKeyParameters)localObject).getPublicKey();
    localObject = ((GMSSPublicKeyParameters)localObject).getParameters();
    this.gmssPS = ((GMSSParameters)localObject);
    this.numLayer = ((GMSSParameters)localObject).getNumOfLayers();
  }
  
  public byte[] generateSignature(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[this.mdLength];
    paramArrayOfByte = this.ots.getSignature(paramArrayOfByte);
    byte[] arrayOfByte2 = this.gmssUtil.concatenateArray(this.currentAuthPaths[(this.numLayer - 1)]);
    byte[] arrayOfByte3 = this.gmssUtil.intToBytesLittleEndian(this.index[(this.numLayer - 1)]);
    int j = arrayOfByte3.length + paramArrayOfByte.length + arrayOfByte2.length;
    arrayOfByte1 = new byte[j];
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 0, arrayOfByte3.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, arrayOfByte3.length, paramArrayOfByte.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, arrayOfByte3.length + paramArrayOfByte.length, arrayOfByte2.length);
    paramArrayOfByte = new byte[0];
    int i = this.numLayer - 1 - 1;
    while (i >= 0)
    {
      arrayOfByte2 = this.gmssUtil.concatenateArray(this.currentAuthPaths[i]);
      arrayOfByte3 = this.gmssUtil.intToBytesLittleEndian(this.index[i]);
      int k = paramArrayOfByte.length;
      Object localObject = new byte[k];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
      paramArrayOfByte = new byte[arrayOfByte3.length + k + this.subtreeRootSig[i].length + arrayOfByte2.length];
      System.arraycopy(localObject, 0, paramArrayOfByte, 0, k);
      System.arraycopy(arrayOfByte3, 0, paramArrayOfByte, k, arrayOfByte3.length);
      localObject = this.subtreeRootSig;
      System.arraycopy(localObject[i], 0, paramArrayOfByte, arrayOfByte3.length + k, localObject[i].length);
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, k + arrayOfByte3.length + this.subtreeRootSig[i].length, arrayOfByte2.length);
      i -= 1;
    }
    arrayOfByte2 = new byte[paramArrayOfByte.length + j];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, j);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, j, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.random = paramCipherParameters.getRandom();
        this.key = ((GMSSPrivateKeyParameters)paramCipherParameters.getParameters());
      }
      else
      {
        this.random = new SecureRandom();
        this.key = ((GMSSPrivateKeyParameters)paramCipherParameters);
      }
      initSign();
      return;
    }
    this.key = ((GMSSPublicKeyParameters)paramCipherParameters);
    initVerify();
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.messDigestOTS.reset();
    int k = this.numLayer - 1;
    int i = 0;
    while (k >= 0)
    {
      Object localObject = new WinternitzOTSVerify(this.digestProvider.get(), this.gmssPS.getWinternitzParameter()[k]);
      int j = ((WinternitzOTSVerify)localObject).getSignatureLength();
      int m = this.gmssUtil.bytesToIntLittleEndian(paramArrayOfByte2, i);
      i += 4;
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramArrayOfByte2, i, arrayOfByte, 0, j);
      i += j;
      paramArrayOfByte1 = ((WinternitzOTSVerify)localObject).Verify(paramArrayOfByte1, arrayOfByte);
      if (paramArrayOfByte1 == null)
      {
        System.err.println("OTS Public Key is null in GMSSSignature.verify");
        return false;
      }
      localObject = (byte[][])Array.newInstance(Byte.TYPE, new int[] { this.gmssPS.getHeightOfTrees()[k], this.mdLength });
      j = 0;
      while (j < localObject.length)
      {
        System.arraycopy(paramArrayOfByte2, i, localObject[j], 0, this.mdLength);
        i += this.mdLength;
        j += 1;
      }
      arrayOfByte = new byte[this.mdLength];
      j = (1 << localObject.length) + m;
      m = 0;
      while (m < localObject.length)
      {
        int i1 = this.mdLength;
        int n = i1 << 1;
        arrayOfByte = new byte[n];
        if (j % 2 == 0)
        {
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, i1);
          paramArrayOfByte1 = localObject[m];
          i1 = this.mdLength;
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, i1, i1);
          j /= 2;
        }
        else
        {
          System.arraycopy(localObject[m], 0, arrayOfByte, 0, i1);
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, this.mdLength, paramArrayOfByte1.length);
          j = (j - 1) / 2;
        }
        this.messDigestTrees.update(arrayOfByte, 0, n);
        paramArrayOfByte1 = new byte[this.messDigestTrees.getDigestSize()];
        this.messDigestTrees.doFinal(paramArrayOfByte1, 0);
        m += 1;
      }
      k -= 1;
    }
    return Arrays.areEqual(this.pubKeyBytes, paramArrayOfByte1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */