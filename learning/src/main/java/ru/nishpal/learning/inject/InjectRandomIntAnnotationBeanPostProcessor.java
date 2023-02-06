package ru.nishpal.learning.inject;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field : bean.getClass().getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int max = annotation.max();
                int min = annotation.min();
                Random random = new Random();
                int result = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, result);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
