## KEY DECISIONS

### 1. Hexagonal Architecture

Application was built with Hexagonal Architecture.

![](https://miro.medium.com/max/700/1*LF3qzk0dgk9kfnplYYKv4Q.png)

#### Why?

The pattern allows us to isolate the core logic of our application from outside concerns. Business logic should not
depend on whether we expose an API, and it should not depend on where we get data from. Having our core logic isolated
means we can easily change any details (DB, API, frameworks, etc.) without a significant code rewrites, or we can start
implementing business rules without some decisions made (what BD, what frameworks, etc).

### 2. Assumptions

Assume that the customer can only have one order and that order can only contain one product.

## SWAGGER

<http://localhost:8080/swagger-ui.html>