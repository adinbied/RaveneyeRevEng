package org.junit.experimental.categories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class Categories
  extends Suite
{
  public Categories(Class<?> paramClass, RunnerBuilder paramRunnerBuilder)
    throws InitializationError
  {
    super(paramClass, paramRunnerBuilder);
    try
    {
      paramRunnerBuilder = getIncludedCategory(paramClass);
      Set localSet = getExcludedCategory(paramClass);
      filter(CategoryFilter.categoryFilter(isAnyIncluded(paramClass), paramRunnerBuilder, isAnyExcluded(paramClass), localSet));
      assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
      return;
    }
    catch (NoTestsRemainException paramClass)
    {
      throw new InitializationError(paramClass);
    }
  }
  
  private static void assertNoCategorizedDescendentsOfUncategorizeableParents(Description paramDescription)
    throws InitializationError
  {
    if (!canHaveCategorizedChildren(paramDescription)) {
      assertNoDescendantsHaveCategoryAnnotations(paramDescription);
    }
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      assertNoCategorizedDescendentsOfUncategorizeableParents((Description)paramDescription.next());
    }
  }
  
  private static void assertNoDescendantsHaveCategoryAnnotations(Description paramDescription)
    throws InitializationError
  {
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext())
    {
      Description localDescription = (Description)paramDescription.next();
      if (localDescription.getAnnotation(Category.class) == null) {
        assertNoDescendantsHaveCategoryAnnotations(localDescription);
      } else {
        throw new InitializationError("Category annotations on Parameterized classes are not supported on individual methods.");
      }
    }
  }
  
  private static boolean canHaveCategorizedChildren(Description paramDescription)
  {
    paramDescription = paramDescription.getChildren().iterator();
    while (paramDescription.hasNext()) {
      if (((Description)paramDescription.next()).getTestClass() == null) {
        return false;
      }
    }
    return true;
  }
  
  private static Set<Class<?>> createSet(Class<?>... paramVarArgs)
  {
    HashSet localHashSet = new HashSet();
    if (paramVarArgs != null) {
      Collections.addAll(localHashSet, paramVarArgs);
    }
    return localHashSet;
  }
  
  private static Set<Class<?>> getExcludedCategory(Class<?> paramClass)
  {
    paramClass = (ExcludeCategory)paramClass.getAnnotation(ExcludeCategory.class);
    if (paramClass == null) {
      paramClass = null;
    } else {
      paramClass = paramClass.value();
    }
    return createSet(paramClass);
  }
  
  private static Set<Class<?>> getIncludedCategory(Class<?> paramClass)
  {
    paramClass = (IncludeCategory)paramClass.getAnnotation(IncludeCategory.class);
    if (paramClass == null) {
      paramClass = null;
    } else {
      paramClass = paramClass.value();
    }
    return createSet(paramClass);
  }
  
  private static boolean hasAssignableTo(Set<Class<?>> paramSet, Class<?> paramClass)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      if (paramClass.isAssignableFrom((Class)paramSet.next())) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean isAnyExcluded(Class<?> paramClass)
  {
    paramClass = (ExcludeCategory)paramClass.getAnnotation(ExcludeCategory.class);
    return (paramClass == null) || (paramClass.matchAny());
  }
  
  private static boolean isAnyIncluded(Class<?> paramClass)
  {
    paramClass = (IncludeCategory)paramClass.getAnnotation(IncludeCategory.class);
    return (paramClass == null) || (paramClass.matchAny());
  }
  
  public static class CategoryFilter
    extends Filter
  {
    private final Set<Class<?>> excluded;
    private final boolean excludedAny;
    private final Set<Class<?>> included;
    private final boolean includedAny;
    
    protected CategoryFilter(boolean paramBoolean1, Set<Class<?>> paramSet1, boolean paramBoolean2, Set<Class<?>> paramSet2)
    {
      this.includedAny = paramBoolean1;
      this.excludedAny = paramBoolean2;
      this.included = copyAndRefine(paramSet1);
      this.excluded = copyAndRefine(paramSet2);
    }
    
    private static Set<Class<?>> categories(Description paramDescription)
    {
      HashSet localHashSet = new HashSet();
      Collections.addAll(localHashSet, directCategories(paramDescription));
      Collections.addAll(localHashSet, directCategories(parentDescription(paramDescription)));
      return localHashSet;
    }
    
    public static CategoryFilter categoryFilter(boolean paramBoolean1, Set<Class<?>> paramSet1, boolean paramBoolean2, Set<Class<?>> paramSet2)
    {
      return new CategoryFilter(paramBoolean1, paramSet1, paramBoolean2, paramSet2);
    }
    
    private static Set<Class<?>> copyAndRefine(Set<Class<?>> paramSet)
    {
      HashSet localHashSet = new HashSet();
      if (paramSet != null) {
        localHashSet.addAll(paramSet);
      }
      localHashSet.remove(null);
      return localHashSet;
    }
    
    private static Class<?>[] directCategories(Description paramDescription)
    {
      if (paramDescription == null) {
        return new Class[0];
      }
      paramDescription = (Category)paramDescription.getAnnotation(Category.class);
      if (paramDescription == null) {
        return new Class[0];
      }
      return paramDescription.value();
    }
    
    public static CategoryFilter exclude(Class<?> paramClass)
    {
      return exclude(true, new Class[] { paramClass });
    }
    
    public static CategoryFilter exclude(boolean paramBoolean, Class<?>... paramVarArgs)
    {
      if (!hasNull(paramVarArgs)) {
        return categoryFilter(true, null, paramBoolean, Categories.createSet(paramVarArgs));
      }
      throw new NullPointerException("has null category");
    }
    
    public static CategoryFilter exclude(Class<?>... paramVarArgs)
    {
      return exclude(true, paramVarArgs);
    }
    
    private boolean hasCorrectCategoryAnnotation(Description paramDescription)
    {
      paramDescription = categories(paramDescription);
      if (paramDescription.isEmpty()) {
        return this.included.isEmpty();
      }
      if (!this.excluded.isEmpty()) {
        if (this.excludedAny)
        {
          if (matchesAnyParentCategories(paramDescription, this.excluded)) {
            return false;
          }
        }
        else if (matchesAllParentCategories(paramDescription, this.excluded)) {
          return false;
        }
      }
      if (this.included.isEmpty()) {
        return true;
      }
      if (this.includedAny) {
        return matchesAnyParentCategories(paramDescription, this.included);
      }
      return matchesAllParentCategories(paramDescription, this.included);
    }
    
    private static boolean hasNull(Class<?>... paramVarArgs)
    {
      if (paramVarArgs == null) {
        return false;
      }
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        if (paramVarArgs[i] == null) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public static CategoryFilter include(Class<?> paramClass)
    {
      return include(true, new Class[] { paramClass });
    }
    
    public static CategoryFilter include(boolean paramBoolean, Class<?>... paramVarArgs)
    {
      if (!hasNull(paramVarArgs)) {
        return categoryFilter(paramBoolean, Categories.createSet(paramVarArgs), true, null);
      }
      throw new NullPointerException("has null category");
    }
    
    public static CategoryFilter include(Class<?>... paramVarArgs)
    {
      return include(true, paramVarArgs);
    }
    
    private boolean matchesAllParentCategories(Set<Class<?>> paramSet1, Set<Class<?>> paramSet2)
    {
      paramSet2 = paramSet2.iterator();
      while (paramSet2.hasNext()) {
        if (!Categories.hasAssignableTo(paramSet1, (Class)paramSet2.next())) {
          return false;
        }
      }
      return true;
    }
    
    private boolean matchesAnyParentCategories(Set<Class<?>> paramSet1, Set<Class<?>> paramSet2)
    {
      paramSet2 = paramSet2.iterator();
      while (paramSet2.hasNext()) {
        if (Categories.hasAssignableTo(paramSet1, (Class)paramSet2.next())) {
          return true;
        }
      }
      return false;
    }
    
    private static Description parentDescription(Description paramDescription)
    {
      paramDescription = paramDescription.getTestClass();
      if (paramDescription == null) {
        return null;
      }
      return Description.createSuiteDescription(paramDescription);
    }
    
    public String describe()
    {
      return toString();
    }
    
    public boolean shouldRun(Description paramDescription)
    {
      if (hasCorrectCategoryAnnotation(paramDescription)) {
        return true;
      }
      paramDescription = paramDescription.getChildren().iterator();
      while (paramDescription.hasNext()) {
        if (shouldRun((Description)paramDescription.next())) {
          return true;
        }
      }
      return false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("categories ");
      Object localObject;
      if (this.included.isEmpty()) {
        localObject = "[all]";
      } else {
        localObject = this.included;
      }
      localStringBuilder.append(localObject);
      if (!this.excluded.isEmpty())
      {
        localStringBuilder.append(" - ");
        localStringBuilder.append(this.excluded);
      }
      return localStringBuilder.toString();
    }
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface ExcludeCategory
  {
    boolean matchAny() default true;
    
    Class<?>[] value() default {};
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface IncludeCategory
  {
    boolean matchAny() default true;
    
    Class<?>[] value() default {};
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\categories\Categories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */