# Asset Management System - Technical Design

**Project:** Multinational Fixed Asset Management System  
**Version:** 1.0  
**Date:** 2026-04-08  
**Status:** Approved

---

## 1. Technical Stack

| Component | Technology |
|-----------|------------|
| Framework | Spring Boot 3.2.4 |
| Language | Java 17 |
| Database | MySQL (MariaDB) |
| API Style | RESTful |
| Build Tool | Maven |
| ORM | Spring Data JPA / Hibernate |

---

## 2. Project Structure

```
code/
├── pom.xml
├── src/main/java/com/ams/
│   ├── AssetManagementApplication.java
│   ├── modules/
│   │   ├── assetcentral/           # Module 1: Asset Central (Foundation)
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   ├── service/impl/
│   │   │   ├── controller/
│   │   │   └── dto/
│   │   ├── assetregistration/     # Module 2: Asset Registration
│   │   ├── assettracking/         # Module 3: Asset Tracking
│   │   ├── maintenance/           # Module 4: Maintenance
│   │   ├── financial/              # Module 5: Financial
│   │   ├── multiplant/            # Module 6: Multi-Plant
│   │   ├── lifecycle/              # Module 7: Lifecycle
│   │   ├── utilization/            # Module 8: Utilization
│   │   └── multicompany/          # Module 9: Multi-Company
│   ├── common/
│   │   ├── BaseEntity.java
│   │   ├── BaseRepository.java
│   │   ├── BaseService.java
│   │   ├── BaseServiceImpl.java
│   │   ├── GlobalExceptionHandler.java
│   │   └── dto/ErrorResponse.java
│   ├── config/
│   │   └── WebConfig.java
│   └── exception/
│       ├── ResourceNotFoundException.java
│       └── ValidationException.java
├── src/main/resources/
│   └── application.yml
└── src/test/java/com/ams/
    └── modules/assetcentral/
```

---

## 3. Database Schema Design

### Design Principle: Normalized Multi-Table Design

Each business domain has its own table(s), connected via foreign keys.

### Phase 1 Tables (Module 1 - Asset Central Core)

#### 3.1 Asset Table
```sql
CREATE TABLE asset (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    serial_number VARCHAR(100),
    asset_type VARCHAR(50),
    category VARCHAR(100),
    manufacturer VARCHAR(255),
    model VARCHAR(100),
    manufacture_date DATE,
    purchase_date DATE,
    purchase_cost DECIMAL(15,2),
    book_value DECIMAL(15,2),
    residual_value DECIMAL(15,2),
    useful_life_years INT,
    depreciation_method VARCHAR(50),
    status VARCHAR(50) DEFAULT 'ACTIVE',
    location VARCHAR(255),
    plant_id BIGINT,
    department_id BIGINT,
    custodian_id BIGINT,
    parent_asset_id BIGINT,
    criticality VARCHAR(20),
    barcode VARCHAR(100),
    qr_code VARCHAR(255),
    rfid_tag VARCHAR(100),
    warranty_expiry DATE,
    insurance_policy_id BIGINT,
    supplier_vendor_id BIGINT,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0,
    FOREIGN KEY (plant_id) REFERENCES plant(id),
    FOREIGN KEY (department_id) REFERENCES department(id),
    FOREIGN KEY (parent_asset_id) REFERENCES asset(id),
    FOREIGN KEY (supplier_vendor_id) REFERENCES vendor(id)
);
```

#### 3.2 Work Order Table
```sql
CREATE TABLE work_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    work_order_number VARCHAR(50) UNIQUE NOT NULL,
    asset_id BIGINT NOT NULL,
    description TEXT NOT NULL,
    work_order_type VARCHAR(50),
    priority VARCHAR(20),
    status VARCHAR(50) DEFAULT 'PENDING',
    assigned_technician_id BIGINT,
    scheduled_start_date DATE,
    scheduled_end_date DATE,
    actual_start_date DATE,
    actual_end_date DATE,
    estimated_hours DECIMAL(10,2),
    actual_hours DECIMAL(10,2),
    labor_cost DECIMAL(15,2),
    parts_cost DECIMAL(15,2),
    total_cost DECIMAL(15,2),
    work_order_source VARCHAR(50),
    failure_code VARCHAR(50),
    root_cause VARCHAR(255),
    resolution_notes TEXT,
    asset_downtime_hours DECIMAL(10,2),
    plant_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0,
    FOREIGN KEY (asset_id) REFERENCES asset(id),
    FOREIGN KEY (plant_id) REFERENCES plant(id)
);
```

#### 3.3 Supporting Tables (Phase 2+)
- `vendor` - Supplier/vendor information
- `spare_part` - Spare parts inventory
- `organization` - Organization hierarchy (plant, division, department)
- `service_contract` - Service contract management
- `insurance` - Insurance policy tracking
- `disposal` - Asset disposal records

---

## 4. API Specification

### Base URL: `/api/v1`

### 4.1 Asset Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/assets` | List all assets (paginated) |
| GET | `/assets/{id}` | Get asset by ID |
| POST | `/assets` | Create new asset |
| PUT | `/assets/{id}` | Update asset |
| DELETE | `/assets/{id}` | Delete asset |
| GET | `/assets/search` | Search assets by criteria |
| GET | `/assets/{id}/work-orders` | Get work orders for asset |

### 4.2 Work Order Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/work-orders` | List all work orders (paginated) |
| GET | `/work-orders/{id}` | Get work order by ID |
| POST | `/work-orders` | Create new work order |
| PUT | `/work-orders/{id}` | Update work order |
| DELETE | `/work-orders/{id}` | Delete work order |
| PATCH | `/work-orders/{id}/status` | Update work order status |
| PATCH | `/work-orders/{id}/complete` | Complete work order |

### 4.3 Response Format

```json
{
    "success": true,
    "data": { ... },
    "message": null,
    "timestamp": "2026-04-08T10:30:00Z"
}
```

### 4.4 Error Response Format

```json
{
    "success": false,
    "data": null,
    "message": "Error description",
    "errors": ["Field-specific error 1", "Field-specific error 2"],
    "timestamp": "2026-04-08T10:30:00Z"
}
```

---

## 5. Implementation Phases

### Phase 1: Technical Infrastructure + Module 1 Core (Current)
- [ ] Project setup with Maven
- [ ] Base entity classes
- [ ] Base repository/service/controller
- [ ] Global exception handling
- [ ] Asset entity + CRUD
- [ ] Work Order entity + CRUD
- [ ] Asset Central Hub API
- [ ] Work Order Hub API

### Phase 2: Module 1 Remaining Hubs
- [ ] Vendor Hub
- [ ] Spare Part Hub
- [ ] Organization Hub
- [ ] Service Contract Hub
- [ ] Insurance Hub
- [ ] Disposal Hub

### Phase 3: Module 2 - Asset Registration
- [ ] Asset Type/Category management
- [ ] Bulk Import/Export
- [ ] Barcode/QR generation
- [ ] RFID integration

### Phase 4-9: Remaining Modules
- Module 3: Asset Tracking
- Module 4: Maintenance
- Module 5: Financial
- Module 6: Multi-Plant
- Module 7: Lifecycle
- Module 8: Utilization
- Module 9: Multi-Company

---

## 6. Code Standards

### 6.1 Naming Conventions
- Entity: `PascalCase` (e.g., `WorkOrder`)
- Repository: `EntityRepository` (e.g., `WorkOrderRepository`)
- Service: `EntityService` (e.g., `WorkOrderService`)
- Controller: `EntityController` (e.g., `WorkOrderController`)
- DTO: `EntityDto`, `CreateEntityRequest`, `UpdateEntityRequest`

### 6.2 Package Structure Per Module
```
modules/{modulename}/
├── entity/           # JPA entities
├── repository/       # Spring Data repositories
├── service/          # Service interfaces
│   └── impl/         # Service implementations
├── controller/       # REST controllers
└── dto/              # Request/Response DTOs
```

### 6.3 Base Classes
- `BaseEntity` - Provides `id`, `createdAt`, `updatedAt`, `createdBy`, `updatedBy`, `version`
- `BaseRepository` - Provides common query methods
- `BaseService` - Provides CRUD template methods
- `BaseServiceImpl` - Common service implementation

---

## 7. Configuration

### application.yml
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ams
    username: root
    password: root
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

server:
  port: 8080
  servlet:
    context-path: /api
```

---

## 8. Acceptance Criteria

### Phase 1 Complete When:
1. Application starts without errors
2. Asset CRUD operations work via REST API
3. Work Order CRUD operations work via REST API
4. Pagination and filtering work for list endpoints
5. Proper error handling returns consistent response format
6. Unit tests pass for core services

---

*Document approved: 2026-04-08*
*Next step: Create implementation plan*
