package com.dc.commons.autoconfigure.scan;

import com.dc.commons.scan.ComponentScanPackage;
import com.dc.utils.CommonUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PackageScanBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        if(beanDefinitionRegistry instanceof DefaultListableBeanFactory){
            DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) beanDefinitionRegistry;
            List<String> packages = Stream.of(beanFactory.getBeanNamesForType(ComponentScanPackage.class))
                    .map(beanName -> beanFactory.getBean(beanName,ComponentScanPackage.class))
                    .map(ComponentScanPackage::scanPackages)
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
            if(CommonUtils.nonNullOrEmpty(packages)){
                ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry,true);
                scanner.scan(packages.toArray(new String[packages.size()]));
            }
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
