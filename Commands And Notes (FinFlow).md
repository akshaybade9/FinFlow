
For run jar project on terminal 
mvn spring-boot:run

jr chukun run zala jar tr kontya id vr run zala pahaych asel tr
ps -ef | grep platform-service

aani tyala kill kraych asel tr 
kill -9 12345




com.finflow.platform
│
├── config
│   ├── KafkaConfig.java
│   ├── CacheConfig.java
│   ├── LiquibaseConfig.java
│   └── PlatformAutoConfiguration.java
│
├── constants
│   └── PlatformConstants.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── PlatformException.java
│   └── ErrorCode.java
│
├── interceptor
│   └── RequestInterceptor.java
│
├── filter
│   └── CorrelationIdFilter.java
│
├── kafka
│   ├── producer
│   │     └── BaseKafkaProducer.java
│   │
│   └── consumer
│         └── BaseKafkaConsumer.java
│
├── cache
│   ├── CacheService.java
│   └── RedisCacheService.java
│
├── saga
│   ├── SagaOrchestrator.java
│   └── SagaStep.java
│
├── audit
│   └── AuditPublisher.java
│
├── util
│   ├── JsonUtil.java
│   ├── DateUtil.java
│   └── ValidationUtil.java
│
├── web
│   ├── response
│   │     ├── ApiResponse.java
│   │     └── ErrorResponse.java
│   │
│   └── advice
│         └── ControllerAdvice.java
│
└── FinflowPlatformApplication.java






finflow
│
├── finflow-platform                (foundation shared jar)
│
├── finflow-common-models           (DTOs / shared contracts)
│
├── finflow-customer-service        (Customer microservice)
│
├── finflow-expense-service         (Expense tracking)
│
├── finflow-budget-service          (Monthly budget / alerts)
│
├── finflow-report-service          (weekly / monthly reports)
│
├── finflow-notification-service    (alerts / emails)
│
└── finflow-api-gateway             (entry point)






com.finflow.customer
│
├── controller
│   └── CustomerController.java
│
├── service
│   ├── CustomerService.java
│   └── impl
│        └── CustomerServiceImpl.java
│
├── repository
│   └── CustomerRepository.java
│
├── entity
│   └── CustomerEntity.java
│
├── mapper
│   └── CustomerMapper.java
│
├── dto
│   ├── request
│   │     └── CustomerCreateRequest.java
│   │
│   └── response
│         └── CustomerResponse.java
│
├── event
│   └── CustomerCreatedEvent.java
│
└── config
     └── CustomerServiceConfig.java



     Client
   │
   ▼
API Gateway
   │
   ▼
Customer Controller
   │
   ▼
Customer Service
   │
   ▼
Repository
   │
   ▼
Database


FinFlow/
└── finflow-parent-pom/
    ├── pom.xml  <-- parent pom
    ├── finflow-api-gateway/   <-- jar/service modules
    ├── finflow-customer-service/
    ├── finflow-eureka-server/
    ├── finflow-liquibase/
    ├── finflow-platform-service/
    └── ...

