<div id="header">
  <img src="https://github.com/Javac-g/Spring_Lectures_University/blob/master/SL.png?raw=true"/>
</div>

# 🌱 Java Spring Lectures Repository

This repository is a curated collection of lecture-based examples and notes exploring the **Java Spring Framework**. It covers key concepts like dependency injection, Spring's bean lifecycle, scopes, Spring Data, transactions, and common pitfalls.

Whether you're a beginner diving into Spring or an experienced developer brushing up on internals, this repository offers hands-on examples and explanations.

---

## 📖 Topics Covered

### 🧩 Spring Core Concepts

| Topic                     | Description                                                                                              |
|--------------------------|----------------------------------------------------------------------------------------------------------|
| **Spring Ecosystem**     | Overview of Spring Framework modules: Core, Web, Boot, Data, Security, etc.                             |
| **Dependency Injection** | Central feature for wiring objects together through constructors, setters, or field injection.          |
| **@Component / @Bean**   | Ways to declare managed beans in Spring's IoC container.                                                  |
| **Injection Pitfalls**   | Cyclic dependencies, missing beans, misused scopes.                                                       |
| **Bean Scopes**          | `singleton`, `prototype`, `request`, `session`, etc. define bean lifecycle and reuse.                     |
| **@Primary**             | Marks a bean as default when multiple candidates exist.                                                   |
| **@Qualifier**           | Specifies which exact bean to inject when multiple implementations are available.                        |
| **@Configuration / FactoryBean** | Custom bean factories, dynamic bean registration, advanced config patterns.                        |
| **ProxyMode**            | Controls the behavior of scoped beans and how Spring proxies them (`NO`, `INTERFACES`, `TARGET_CLASS`). |

---

### 🗃️ Spring Data JPA

| Topic                  | Description                                                                                  |
|-----------------------|----------------------------------------------------------------------------------------------|
| **CrudRepository**    | Out-of-the-box basic CRUD functionality.                                                    |
| **JpaRepository**     | Adds paging and sorting capabilities, query derivation.                                      |
| **@Query**            | Define custom JPQL or native queries.                                                        |
| **Entity Lifecycle**  | `@PrePersist`, `@PostLoad`, etc. for hook-based logic.                                       |
| **Projections & DTOs**| Interface-based or class-based projections for optimized data transfer.                      |
| **Specification API** | Advanced dynamic query creation using criteria specifications.                               |
| **Transaction Handling** | Isolation levels, rollback rules, propagation types.                                   |

---

### 🧵 @Transactional Deep Dive

| Aspect                 | Description                                                                                           |
|------------------------|-------------------------------------------------------------------------------------------------------|
| **@Transactional**     | Declarative transaction management.                                                                 |
| **Propagation**        | Defines how transactions behave when called within other transactions.                              |
| **Isolation**          | Manages data visibility and concurrency control (READ_COMMITTED, REPEATABLE_READ, etc.).             |
| **RollbackFor**        | Specifies which exceptions should trigger rollback.                                                  |
| **Pitfalls**           | Calling transactional methods internally, using final methods, not caught by Spring proxying.         |

---

## 🔄 Project Structure Example

```
src
├── main
│   ├── java
│   │   └── com.example.springlectures
│   │       ├── config         # Manual configuration and bean factories
│   │       ├── controller     # Web controllers (if used)
│   │       ├── data           # Spring Data repositories and entities
│   │       ├── service        # Business logic
│   │       ├── aspect         # Custom transaction aspects (optional)
│   │       └── demo           # Lecture examples and test cases
│   └── resources
│       └── application.yml    # Profile and environment settings
```

---

## 🚀 Getting Started

1. Clone the repo:
```bash
git clone https://github.com/your-username/spring-lectures.git
cd spring-lectures
```
2. Import into IntelliJ or Eclipse as a Maven or Gradle project.
3. Run lecture-specific `Main` classes or integration tests to experiment.

---

## ✅ Best Practices

- Prefer constructor injection over field injection.
- Avoid business logic in entities.
- Use `@Transactional(readOnly = true)` for read operations.
- Keep Spring config in separate `@Configuration` classes.
- Use `@Qualifier` instead of relying solely on `@Primary`.
- Avoid putting complex logic in `@PostConstruct`.

---

## 📚 References

- [Spring Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Baeldung – Spring Tutorials](https://www.baeldung.com/)
- [Spring Core Guide](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html)

---

## 🤝 Contributing

Feel free to fork this repo, suggest new topics, or contribute your own examples. Every contribution helps the Spring community grow!

---

## 📬 Contact

Questions, suggestions, or feedback? Feel free to open an issue or reach out!
