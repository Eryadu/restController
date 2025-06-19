## Difference Between @Component, @Repository, @Service, and @Controller Annotations in Spring

https://www.geeksforgeeks.org/difference-between-component-repository-service-and-controller-annotations-in-spring/

https://www.linkedin.com/pulse/controller-service-repository-pattern-comprehensive-guide-shikder-azicc/
(best)
Spring Annotations are a form of metadata that provides data about a program. Annotations are used to provide 
supplemental information about a program. It does not have a direct effect on the operation of the code they annotate. 
It does not change the action of the compiled program. Here, we are going to discuss the difference between the 4 most 
important annotations in Spring, @Component, @Repository, @Service, and @Controller.

@Component Annotation

@Component is a class-level annotation. It is used to denote a class as a Component. We can use @Component across
the application to mark the beans as Spring's managed components. A component is responsible for some operations. 
Spring framework provides three other specific annotations to be used when marking a class as a Component.

@Service
@Repository
@Controller

Types Of Component Annotation

A. @Service Annotation

In an application, the business logic resides within the service layer so we use the @Service Annotation to indicate 
that a class belongs to that layer. It is a specialization of @Component Annotation. One most important thing about 
the @Service Annotation is it can be applied only to classes. It is used to mark the class as a service provider. 
So overall @Service annotation is used with classes that provide some business functionalities. Spring context will 
autodetect these classes when annotation-based configuration and classpath scanning is used.

B. @Repository Annotation

@Repository Annotation is also a specialization of @Component annotation which is used to indicate that the class 
provides the mechanism for storage, retrieval, update, delete and search operation on objects. Though it is a 
specialization of @Component annotation, so Spring Repository classes are autodetected by the spring framework 
through classpath scanning. This annotation is a general-purpose stereotype annotation which very close to the 
DAO pattern where DAO classes are responsible for providing CRUD operations on database tables.

C. @Controller Annotation

Spring @Controller annotation is also a specialization of @Component annotation. The @Controller annotation indicates 
that a particular class serves the role of a controller. Spring Controller annotation is typically used in combination 
with annotated handler methods based on the @RequestMapping annotation. It can be applied to classes only. It’s used to 
mark a class as a web request handler. It’s mostly used with Spring MVC applications. This annotation acts as a 
stereotype for the annotated class, indicating its role. The dispatcher scans such annotated classes for mapped 
methods and detects @RequestMapping annotations.
