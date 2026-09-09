# W-CRM

Enterprise Multi-Business CRM Android Application.

## Technology

- Kotlin
- Jetpack Compose
- Clean Architecture
- Multi Module Architecture
- Hilt Dependency Injection
- Room Database
- Kotlin Coroutines + Flow
- Navigation Compose
- Gradle Kotlin DSL

## Architecture

```
app
core
  common
  database
  domain
  model
  repository
business_profile
  schema
  profiles
  registry
  validator
runtime
feature
  customer
  product
  inventory
  sales
  invoice
  warranty
  repair
  accounting
```

## Version

v1.0.0
versionCode: 1

## Development Rules

- Core architecture is preserved.
- Modules are not removed for build purposes.
- Changes are committed incrementally.
