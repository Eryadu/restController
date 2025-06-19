

## When using only @Controller in a Spring Boot application, instead of @RestController, the primary difference lies in 
   how the response is handled.

## @Controller indicates that the class will handle incoming web requests and typically returns a view name, which is then
   resolved by a view resolver to render a web page. If you intend to return data directly (like JSON or XML) from a method
   within a @Controller, you must explicitly annotate that method with @ResponseBody.

## In contrast, @RestController is a specialized controller that combines @Controller and @ResponseBody. This means that 
   any method within a @RestController automatically serializes its return value into the HTTP response body (e.g., as 
   JSON or XML), without the need for @ResponseBody annotation on each method.

## Therefore, if you use @Controller without @ResponseBody, the output will be a view rendered by the view resolver. 
   If you intend to return data directly, you must add @ResponseBody to each relevant method.