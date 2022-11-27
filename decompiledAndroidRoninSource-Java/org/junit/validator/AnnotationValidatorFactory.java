package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

public class AnnotationValidatorFactory
{
  private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES = new ConcurrentHashMap();
  
  public AnnotationValidator createAnnotationValidator(ValidateWith paramValidateWith)
  {
    Object localObject1 = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
    if (localObject1 != null) {
      return (AnnotationValidator)localObject1;
    }
    localObject1 = paramValidateWith.value();
    if (localObject1 != null) {
      try
      {
        localObject2 = (AnnotationValidator)((Class)localObject1).newInstance();
        VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(paramValidateWith, localObject2);
        paramValidateWith = (AnnotationValidator)VALIDATORS_FOR_ANNOTATION_TYPES.get(paramValidateWith);
        return paramValidateWith;
      }
      catch (Exception paramValidateWith)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Exception received when creating AnnotationValidator class ");
        ((StringBuilder)localObject2).append(((Class)localObject1).getName());
        throw new RuntimeException(((StringBuilder)localObject2).toString(), paramValidateWith);
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Can't create validator, value is null in annotation ");
    ((StringBuilder)localObject1).append(paramValidateWith.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\validator\AnnotationValidatorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */