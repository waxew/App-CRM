# W-CRM Architecture

## Core Principle

The CRM Core remains independent from business profiles.

## Modules

### Core
- common
- model
- domain
- database
- repository

### Business Profile
Provides dynamic business capabilities using:

- BusinessProfile
- AttributeDefinition
- ProfileRegistry

### Runtime
Responsible for application initialization:

- RuntimeBootstrap
- RuntimeInitializer
- RuntimeContext

### Features

Customer, Product, Inventory, Sales, Invoice, Warranty, Repair and Accounting are isolated feature modules.
