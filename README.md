# SpringBootJpaModelGenIssue

Simple Spring Boot 2 application used to demonstrate issue involving the use of `hibernate-jpamodelgen`:

```html
<dependency>
  <groupId>org.hibernate</groupId>
  <artifactId>hibernate-jpamodelgen</artifactId>
</dependency>
```   

Along with `javax.validation.constraints` annotations:

```html
@NotNull
private String name;
```

when modifying an entity having the above annotated property (because `spring-boot-devtools`

```html
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <optional>true</optional>
</dependency>
```

is enabled and listening for code changes), when the application redeploys the following error occurs:

```html
2018-05-17 14:29:39.277 ERROR 13092 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.cfg.beanvalidation.IntegrationException: Error activating Bean Validation integration
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1706) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:579) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:501) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:317) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:228) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:315) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1089) ~[spring-context-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:859) ~[spring-context-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:550) ~[spring-context-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:140) ~[spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:759) [spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:395) [spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:327) [spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1255) [spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1243) [spring-boot-2.0.2.RELEASE.jar:2.0.2.RELEASE]
	at gov.idaho.isp.bootvalidation.Application.main(Application.java:20) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_152]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_152]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_152]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_152]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.0.2.RELEASE.jar:2.0.2.RELEASE]
Caused by: javax.persistence.PersistenceException: [PersistenceUnit: default] Unable to build Hibernate SessionFactory; nested exception is org.hibernate.cfg.beanvalidation.IntegrationException: Error activating Bean Validation integration
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:402) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:377) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1765) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1702) ~[spring-beans-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	... 21 common frames omitted
Caused by: org.hibernate.cfg.beanvalidation.IntegrationException: Error activating Bean Validation integration
	at org.hibernate.cfg.beanvalidation.BeanValidationIntegrator.integrate(BeanValidationIntegrator.java:138) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.internal.SessionFactoryImpl.<init>(SessionFactoryImpl.java:281) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:462) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:892) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:390) ~[spring-orm-5.0.6.RELEASE.jar:5.0.6.RELEASE]
	... 25 common frames omitted
Caused by: java.lang.annotation.AnnotationFormatError: Duplicate annotation for class: interface javax.validation.constraints.NotNull: @javax.validation.constraints.NotNull(message={javax.validation.constraints.NotNull.message}, groups=[], payload=[])
	at sun.reflect.annotation.TypeAnnotationParser.mapTypeAnnotations(TypeAnnotationParser.java:360) ~[na:1.8.0_152]
	at sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl.<init>(AnnotatedTypeFactory.java:139) ~[na:1.8.0_152]
	at sun.reflect.annotation.AnnotatedTypeFactory.buildAnnotatedType(AnnotatedTypeFactory.java:65) ~[na:1.8.0_152]
	at sun.reflect.annotation.TypeAnnotationParser.buildAnnotatedType(TypeAnnotationParser.java:79) ~[na:1.8.0_152]
	at java.lang.reflect.Field.getAnnotatedType(Field.java:1170) ~[na:1.8.0_152]
	at org.hibernate.validator.internal.metadata.provider.AnnotationMetaDataProvider.findCascadingMetaData(AnnotationMetaDataProvider.java:614) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.provider.AnnotationMetaDataProvider.findPropertyMetaData(AnnotationMetaDataProvider.java:236) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.provider.AnnotationMetaDataProvider.getFieldMetaData(AnnotationMetaDataProvider.java:225) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.provider.AnnotationMetaDataProvider.retrieveBeanConfiguration(AnnotationMetaDataProvider.java:133) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.provider.AnnotationMetaDataProvider.getBeanConfiguration(AnnotationMetaDataProvider.java:124) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.BeanMetaDataManager.getBeanConfigurationForHierarchy(BeanMetaDataManager.java:220) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.BeanMetaDataManager.createBeanMetaData(BeanMetaDataManager.java:187) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.metadata.BeanMetaDataManager.lambda$getBeanMetaData$0(BeanMetaDataManager.java:160) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at java.util.concurrent.ConcurrentMap.computeIfAbsent(ConcurrentMap.java:324) ~[na:1.8.0_152]
	at org.hibernate.validator.internal.metadata.BeanMetaDataManager.getBeanMetaData(BeanMetaDataManager.java:159) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.validator.internal.engine.ValidatorImpl.getConstraintsForClass(ValidatorImpl.java:294) ~[hibernate-validator-6.0.9.Final.jar:6.0.9.Final]
	at org.hibernate.cfg.beanvalidation.TypeSafeActivator.applyDDL(TypeSafeActivator.java:207) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.cfg.beanvalidation.TypeSafeActivator.applyRelationalConstraints(TypeSafeActivator.java:191) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.cfg.beanvalidation.TypeSafeActivator.applyRelationalConstraints(TypeSafeActivator.java:150) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at org.hibernate.cfg.beanvalidation.TypeSafeActivator.activate(TypeSafeActivator.java:98) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_152]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_152]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_152]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_152]
	at org.hibernate.cfg.beanvalidation.BeanValidationIntegrator.integrate(BeanValidationIntegrator.java:132) ~[hibernate-core-5.2.17.Final.jar:5.2.17.Final]
	... 31 common frames omitted
```
