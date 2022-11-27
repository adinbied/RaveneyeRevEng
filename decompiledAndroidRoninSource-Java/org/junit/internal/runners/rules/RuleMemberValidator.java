package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

public class RuleMemberValidator
{
  public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR = classRuleValidatorBuilder().forMethods().withValidator(new DeclaringClassMustBePublic(null)).withValidator(new MemberMustBeStatic(null)).withValidator(new MemberMustBePublic(null)).withValidator(new MethodMustBeATestRule(null)).build();
  public static final RuleMemberValidator CLASS_RULE_VALIDATOR = classRuleValidatorBuilder().withValidator(new DeclaringClassMustBePublic(null)).withValidator(new MemberMustBeStatic(null)).withValidator(new MemberMustBePublic(null)).withValidator(new FieldMustBeATestRule(null)).build();
  public static final RuleMemberValidator RULE_METHOD_VALIDATOR = testRuleValidatorBuilder().forMethods().withValidator(new MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new MemberMustBePublic(null)).withValidator(new MethodMustBeARule(null)).build();
  public static final RuleMemberValidator RULE_VALIDATOR = testRuleValidatorBuilder().withValidator(new MemberMustBeNonStaticOrAlsoClassRule(null)).withValidator(new MemberMustBePublic(null)).withValidator(new FieldMustBeARule(null)).build();
  private final Class<? extends Annotation> annotation;
  private final boolean methods;
  private final List<RuleValidator> validatorStrategies;
  
  RuleMemberValidator(Builder paramBuilder)
  {
    this.annotation = paramBuilder.annotation;
    this.methods = paramBuilder.methods;
    this.validatorStrategies = paramBuilder.validators;
  }
  
  private static Builder classRuleValidatorBuilder()
  {
    return new Builder(ClassRule.class, null);
  }
  
  private static boolean isMethodRule(FrameworkMember<?> paramFrameworkMember)
  {
    return MethodRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static boolean isRuleType(FrameworkMember<?> paramFrameworkMember)
  {
    return (isMethodRule(paramFrameworkMember)) || (isTestRule(paramFrameworkMember));
  }
  
  private static boolean isTestRule(FrameworkMember<?> paramFrameworkMember)
  {
    return TestRule.class.isAssignableFrom(paramFrameworkMember.getType());
  }
  
  private static Builder testRuleValidatorBuilder()
  {
    return new Builder(Rule.class, null);
  }
  
  private void validateMember(FrameworkMember<?> paramFrameworkMember, List<Throwable> paramList)
  {
    Iterator localIterator = this.validatorStrategies.iterator();
    while (localIterator.hasNext()) {
      ((RuleValidator)localIterator.next()).validate(paramFrameworkMember, this.annotation, paramList);
    }
  }
  
  public void validate(TestClass paramTestClass, List<Throwable> paramList)
  {
    if (this.methods) {
      paramTestClass = paramTestClass.getAnnotatedMethods(this.annotation);
    } else {
      paramTestClass = paramTestClass.getAnnotatedFields(this.annotation);
    }
    paramTestClass = paramTestClass.iterator();
    while (paramTestClass.hasNext()) {
      validateMember((FrameworkMember)paramTestClass.next(), paramList);
    }
  }
  
  private static class Builder
  {
    private final Class<? extends Annotation> annotation;
    private boolean methods;
    private final List<RuleMemberValidator.RuleValidator> validators;
    
    private Builder(Class<? extends Annotation> paramClass)
    {
      this.annotation = paramClass;
      this.methods = false;
      this.validators = new ArrayList();
    }
    
    RuleMemberValidator build()
    {
      return new RuleMemberValidator(this);
    }
    
    Builder forMethods()
    {
      this.methods = true;
      return this;
    }
    
    Builder withValidator(RuleMemberValidator.RuleValidator paramRuleValidator)
    {
      this.validators.add(paramRuleValidator);
      return this;
    }
  }
  
  private static final class DeclaringClassMustBePublic
    implements RuleMemberValidator.RuleValidator
  {
    private boolean isDeclaringClassPublic(FrameworkMember<?> paramFrameworkMember)
    {
      return Modifier.isPublic(paramFrameworkMember.getDeclaringClass().getModifiers());
    }
    
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!isDeclaringClassPublic(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be declared in a public class."));
      }
    }
  }
  
  private static final class FieldMustBeARule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isRuleType(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must implement MethodRule or TestRule."));
      }
    }
  }
  
  private static final class FieldMustBeATestRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isTestRule(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must implement TestRule."));
      }
    }
  }
  
  private static final class MemberMustBeNonStaticOrAlsoClassRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      boolean bool = RuleMemberValidator.isMethodRule(paramFrameworkMember);
      int i;
      if (paramFrameworkMember.getAnnotation(ClassRule.class) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramFrameworkMember.isStatic()) && ((bool) || (i == 0)))
      {
        String str;
        if (RuleMemberValidator.isMethodRule(paramFrameworkMember)) {
          str = "must not be static.";
        } else {
          str = "must not be static or it must be annotated with @ClassRule.";
        }
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, str));
      }
    }
  }
  
  private static final class MemberMustBePublic
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!paramFrameworkMember.isPublic()) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be public."));
      }
    }
  }
  
  private static final class MemberMustBeStatic
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!paramFrameworkMember.isStatic()) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must be static."));
      }
    }
  }
  
  private static final class MethodMustBeARule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isRuleType(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of MethodRule or TestRule."));
      }
    }
  }
  
  private static final class MethodMustBeATestRule
    implements RuleMemberValidator.RuleValidator
  {
    public void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList)
    {
      if (!RuleMemberValidator.isTestRule(paramFrameworkMember)) {
        paramList.add(new ValidationError(paramFrameworkMember, paramClass, "must return an implementation of TestRule."));
      }
    }
  }
  
  static abstract interface RuleValidator
  {
    public abstract void validate(FrameworkMember<?> paramFrameworkMember, Class<? extends Annotation> paramClass, List<Throwable> paramList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\rules\RuleMemberValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */