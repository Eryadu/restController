
// https://www.geeksforgeeks.org/how-to-use-spring-responseentity-to-manipulate-the-http-response/

// ResponseEntity is designed based on builder Method.
// Its same as Optional Class, hold one value or not .
## ResponseEntity is a powerful class in the Spring Framework that provides a flexible way to handle HTTP responses. 
   It allows us to customize the HTTP response, including the status code, headers, and body, giving you complete 
   control over what is sent back to the client. This class is particularly useful in RESTful APIs where fine-grained 
   control over HTTP responses is often required.

## ResponseEntity
   ResponseEntity is the class in the Spring Framework that represents the entire HTTP response, including the status 
   code, headers, and body. It is a part of the org.springframework.http package and is a powerful tool for controlling 
   the output of the RESTful services. When you return the ResponseEntity from a controller method, we can fully 
   customize the HTTP response sent to the client. It includes:

-- Status Code: The HTTP status code indicating the result of the request. (e.g., 200 OK, 404 Not Found, 500 
   Internal Server Error).
-- Headers: It is a Key-value pair containing the metadata about the responses. (e.g., content type, cache-control).
-- Body: The actual content of the response typically in the JSON, XML, or plain text format.

## Components of ResponseEntity

ResponseEntity is composed of the three main parts:

1. HTTP Status Code: This is the standard HTTP response code that indicates the result of the HTTP request. 
   Examples include:
200 OK: The request was successful and the server is returning the request data.
201 Created: The new resource has been created as the result of the request.
204 No Content: The request was successful but there is no content to send in the response as a result of the request.
400 Bad Request: The server cannot be process the request due to the client error.
404 Not Found: The requested resource is not available on the server.
500 Internal Server Error: The generic error message when the server fails to fulfill the request.

2. HTTP Headers: It can provide the metadata about the response. Some of the common header include:

Content-Type: It can specified the media type of the response (e.g., application/json, text/html).
Authorization: It can be used for passing the crediential in the APIs that require the authentication.
Custom Headers: We can define the own headers to pass the additional information, like X-Custom-Header.

3. Response Body: The body contains the actual content of the response. It can be:

The JSON object can representing the data requested.
The plain text message indicating the result of the operation.
HTML content if returning the web page.
No Content if the operation does not require the response body.
