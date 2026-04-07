# Asset Management System - Entity Model

## 1. Core Entities Overview

The Asset Management System is built around the following core entities:

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           CORE ENTITY: ASSET                                 │
│                                                                             │
│  The central business object that represents equipment, machinery, and items   │
│  tracked by the system across all modules.                                  │
└─────────────────────────────────────────────────────────────────────────────┘
```

### 1.1 Entity List by Module

| Module | Entity | Description |
|--------|--------|-------------|
| **0 - Asset Central** | Asset | Central entity - all modules reference |
| | Dashboard Statistics | Aggregated asset metrics |
| **2.1 - Asset Registration** | Asset | Core asset record |
| | AssetType | Asset classification hierarchy |
| | AssetCategory | Custom categorization |
| | AssetHierarchy | Parent-child relationships |
| | RFIDTag | Radio-frequency identification tags |
| | Barcode | Barcode/QR code identifiers |
| | Document | Asset attachments |
| | Employee | HR employee integration |
| **2.2 - Asset Tracking** | Location | Real-time asset position |
| | Geofence | Virtual boundaries |
| | LoanTicket | Check-in/check-out records |
| | TransferTicket | Asset movement records |
| | AuditLog | Immutable change records |
| | IoTSensor | Connected monitoring sensors |
| | SensorReading | Sensor data points |
| | CalibrationRecord | Equipment calibration |
| **2.3 - Maintenance** | MaintenancePlan | Scheduled maintenance |
| | WorkOrder | Maintenance tasks |
| | MaintenanceHistory | Completed maintenance |
| | ServiceContract | External service agreements |
| | SparePart | Maintenance parts inventory |
| | SparePartReservation | Parts reserved for work |
| | Vendor | Service providers |
| **2.4 - Financial** | DepreciationSchedule | Asset depreciation |
| | InsurancePolicy | Asset insurance |
| | InsuranceClaim | Insurance filed claims |
| | CapitalProject | Construction in progress |
| | ExchangeRate | Currency rates |
| | Budget | Financial planning |
| **2.5 - Multi-Plant** | Organization | Hierarchical structure |
| | CostCenter | Financial accounting unit |
| **2.6 - Lifecycle** | PurchaseOrder | Procurement orders |
| | Supplier | Asset suppliers |
| | CommissioningRecord | Asset installation |
| | DisposalRecord | Asset retirement |
| | BorrowingRecord | Temporary lending |
| | CycleCountPlan | Inventory verification |
| **2.7 - Utilization** | AllocationPlan | Asset allocation planning |
| | UsageContract | Internal usage agreements |
| | AssetReservation | Future bookings |
| | UsageRecord | Usage tracking |
| **2.8 - Multi-Company** | LegalEntity | Company definitions |
| | DataAccessGrant | Cross-company access |
| | Role | User permissions |

---

## 2. Entity Relationship Diagram

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              ORGANIZATIONAL HIERARCHY                            │
│                                                                                  │
│    ┌─────────────┐                                                               │
│    │  GROUP      │  (Top Level)                                                  │
│    └──────┬──────┘                                                               │
│           │ contains                                                             │
│    ┌──────▼──────┐                                                               │
│    │  COMPANY     │  (Legal Entity)                                               │
│    └──────┬──────┘                                                               │
│           │ contains                                                             │
│    ┌──────▼──────┐                                                               │
│    │  DIVISION    │                                                               │
│    └──────┬──────┘                                                               │
│           │ contains                                                             │
│    ┌──────▼──────┐                                                               │
│    │  PLANT       │                                                               │
│    └──────┬──────┘                                                               │
│           │ contains                                                             │
│    ┌──────▼──────┐     ┌─────────────────┐                                       │
│    │  DEPARTMENT  │────▶│  COST CENTER    │                                       │
│    └──────────────┘     └─────────────────┘                                       │
└─────────────────────────────────────────────────────────────────────────────────┘

                                    │
                                    │ owns
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────────┐
│                                    ASSET                                         │
│                                                                                  │
│  Primary Entity - Central to all modules                                         │
│                                                                                  │
│  Attributes:                                                                    │
│  - Asset ID (PK)                                                               │
│  - Asset Name                                                                   │
│  - Asset Type (FK)                                                             │
│  - Serial Number                                                                │
│  - Status (Active/Idle/Maintenance/Retired)                                    │
│  - Book Value                                                                  │
│  - Acquisition Date                                                              │
│  - Location (FK)                                                                │
│  - Organization (FK)                                                            │
│  - Parent Asset (FK, self-ref)                                                  │
└─────────────────────────────────────────────────────────────────────────────────┘
                                    │
        ┌────────────────────────────┼────────────────────────────┐
        │                            │                            │
        │ has                        │ has                        │ has
        ▼                            ▼                            ▼
┌───────────────────┐    ┌───────────────────┐    ┌───────────────────┐
│   RFID TAG         │    │   BARCODE         │    │   IoT SENSOR      │
│                   │    │                   │    │                   │
│ - Tag UID (PK)    │    │ - Code Value (PK)│    │ - Sensor ID (PK)  │
│ - Tag Type        │    │ - Code Type      │    │ - Sensor Type     │
│ - Asset (FK)       │    │ - Asset (FK)      │    │ - Threshold       │
│ - Status          │    │ - Generated Date  │    │ - Status         │
└───────────────────┘    └───────────────────┘    │ - Asset (FK)      │
                                                 └───────────────────┘
        │
        │ readings
        ▼
┌───────────────────┐
│   SENSOR READING   │
│                   │
│ - Reading ID (PK) │
│ - Sensor (FK)     │
│ - Value           │
│ - Quality         │
│ - Timestamp       │
└───────────────────┘

┌─────────────────────────────────────────────────────────────────────────────────┐
│                                ASSET RELATIONSHIPS                              │
│                                                                                  │
│    ┌──────────────┐         ┌──────────────┐         ┌──────────────┐        │
│    │ PARENT ASSET │◀────────│    ASSET     │────────▶│CHILD ASSETS  │        │
│    │              │ parent  │              │  child  │              │        │
│    └──────────────┘         └──────────────┘         └──────────────┘        │
│                                                                                  │
│    ┌──────────────┐         ┌──────────────┐         ┌──────────────┐        │
│    │ ASSET TYPE   │◀────────│    ASSET     │         │    DOCUMENT   │        │
│    │              │ type    │              │  has    │              │        │
│    └──────────────┘         └──────────────┘         └──────────────┘        │
│                                                                                  │
│    ┌──────────────┐         ┌──────────────┐         ┌──────────────┐        │
│    │ORGANIZATION   │◀────────│    ASSET     │         │   LOCATION   │        │
│    │ (Plant/Dept) │ belongs │              │ located │              │        │
│    └──────────────┘         └──────────────┘         └──────────────┘        │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## 3. Asset Lifecycle Relationships

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              ASSET LIFECYCLE                                     │
│                                                                                  │
│    ┌─────────────┐      ┌─────────────┐      ┌─────────────┐      ┌─────────┐│
│    │ PROCUREMENT │─────▶│  RECEIVING   │─────▶│COMMISSIONING│─────▶│ ACTIVE  ││
│    │             │      │             │      │             │      │  USE    ││
│    └─────────────┘      └─────────────┘      └─────────────┘      └────┬────┘│
│                                                                               │
│         │                      ▲                      │                        │
│         │ records              │ records              │                        │
│         ▼                      │                      ▼                        │
│    ┌─────────────┐      ┌─────────────┐      ┌─────────────┐               │
│    │PURCHASE ORDER│      │COMMISSIONING │      │MAINTENANCE  │               │
│    │             │      │   RECORD     │      │   PLAN      │               │
│    └─────────────┘      └─────────────┘      └──────┬──────┘               │
│                                                        │                       │
│                    ┌───────────────────────────────────┼───────────────────┐   │
│                    │                                   │                   │   │
│                    ▼                                   ▼                   │   │
│             ┌─────────────┐                    ┌─────────────┐           │   │
│             │  WORK ORDER │                    │  DISPOSAL  │           │   │
│             │             │                    │   RECORD   │           │   │
│             └──────┬─────┘                    └─────────────┘           │   │
│                    │                                                       │   │
│                    │ creates                                               │   │
│                    ▼                                                       │   │
│             ┌─────────────┐                                              │   │
│             │ MAINTENANCE │───────────────────────────────────────────────┘   │
│             │   HISTORY    │                                                   │
│             └─────────────┘                                                   │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## 4. Module-Specific Entity Relationships

### 4.1 Module 2.3 - Maintenance Module

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              MAINTENANCE MODULE                                  │
│                                                                                  │
│    ┌─────────────────┐                                                           │
│    │MAINTENANCE PLAN│                                                           │
│    │                │◀─────────── parent template                              │
│    └───────┬────────┘                                                           │
│            │ generates                                                            │
│            ▼                                                                     │
│    ┌─────────────────┐       ┌─────────────────┐       ┌─────────────────┐    │
│    │   WORK ORDER    │──────▶│    EMPLOYEE     │◀──────│     VENDOR      │    │
│    │                 │ perf. │   (Technician)  │       │                 │    │
│    └───────┬─────────┘       └─────────────────┘       └────────┬────────┘    │
│            │                                                    │              │
│            │ uses              ┌─────────────────┐               │ provides      │
│            ▼                   │   SPARE PART   │               ▼              │
│    ┌─────────────────┐         │                 │       ┌─────────────────┐    │
│    │MAINTENANCE     │────────│─────────────────│       │SERVICE CONTRACT│    │
│    │   HISTORY      │       │                 │       │                 │    │
│    └─────────────────┘       └─────────────────┘       └─────────────────┘    │
│                                                                                  │
│         │                                                                                       │
│         │ linked to calibration                                                                 │
│         ▼                                                                                       │
│    ┌─────────────────┐                                                                          │
│    │ CALIBRATION     │                                                                          │
│    │ RECORD          │                                                                          │
│    └─────────────────┘                                                                          │
└─────────────────────────────────────────────────────────────────────────────────┘
```

### 4.2 Module 2.4 - Financial Module

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              FINANCIAL MODULE                                     │
│                                                                                  │
│    ┌─────────────────┐       ┌─────────────────┐                                │
│    │     ASSET       │──────▶│   DEPRECIATION  │                                │
│    │                 │ has   │    SCHEDULE     │                                │
│    └─────────────────┘       └────────┬────────┘                                │
│                                        │                                           │
│    ┌─────────────────┐                 │ calculates                               │
│    │ INSURANCE       │◀────────────────┘                                           │
│    │    POLICY       │                                                           │
│    └────────┬────────┘                                                           │
│             │ linked                                                              │
│             ▼                                                                     │
│    ┌─────────────────┐       ┌─────────────────┐                                │
│    │INSURANCE CLAIM  │       │    CAPITAL       │                                │
│    │                 │       │    PROJECT       │                                │
│    └─────────────────┘       └────────┬────────┘                                │
│                                        │                                           │
│                                        │ budgets                                   │
│                                        ▼                                           │
│                               ┌─────────────────┐                                │
│                               │     BUDGET       │                                │
│                               └─────────────────┘                                │
│                                                                                  │
│         ┌────────────────────────────────────────────────────────────────┐       │
│         │                    EXCHANGE RATE                                  │       │
│         │         (used for multi-currency support)                       │       │
│         └────────────────────────────────────────────────────────────────┘       │
└─────────────────────────────────────────────────────────────────────────────────┘
```

### 4.3 Module 2.7 - Utilization Module

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                            UTILIZATION MODULE                                    │
│                                                                                  │
│    ┌─────────────────┐       ┌─────────────────┐       ┌─────────────────┐    │
│    │ALLOCATION PLAN  │──────▶│      ASSET      │◀──────│USAGE CONTRACT   │    │
│    │                 │alloc. │                 │       │                 │    │
│    └─────────────────┘       └────────┬────────┘       └─────────────────┘    │
│                                       │                                          │
│                                       │ reserved                                 │
│                                       ▼                                          │
│                               ┌─────────────────┐                                │
│                               │     ASSET       │                                │
│                               │  RESERVATION    │                                │
│                               └────────┬────────┘                                │
│                                        │                                         │
│                                        │ records                                 │
│                                        ▼                                         │
│                               ┌─────────────────┐                                │
│                               │   USAGE RECORD  │                                │
│                               └─────────────────┘                                │
│                                                                                  │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## 5. Complete Entity List with Attributes

### Core Entities

#### ASSET
| Attribute | Type | Description |
|-----------|------|-------------|
| asset_id | VARCHAR(50) | Primary key, unique identifier |
| asset_name | VARCHAR(200) | Display name |
| asset_type_id | VARCHAR(50) | Foreign key to AssetType |
| serial_number | VARCHAR(100) | Manufacturer serial |
| status | ENUM | Active, Idle, Maintenance, Retired |
| book_value | DECIMAL(15,2) | Current book value |
| acquisition_date | DATE | Date acquired |
| acquisition_cost | DECIMAL(15,2) | Original cost |
| location_id | VARCHAR(50) | Foreign key to Location |
| organization_id | VARCHAR(50) | Foreign key to Organization |
| parent_asset_id | VARCHAR(50) | Self-referential FK for hierarchy |
| manufacturer | VARCHAR(200) | Manufacturer name |
| model | VARCHAR(100) | Model number |
| warranty_expiry | DATE | Warranty expiration |
| criticality | ENUM | A, B, C classification |

#### ASSET_TYPE
| Attribute | Type | Description |
|-----------|------|-------------|
| asset_type_id | VARCHAR(50) | Primary key |
| type_code | VARCHAR(50) | Unique code within company |
| type_name | VARCHAR(200) | Display name |
| parent_type_id | VARCHAR(50) | Parent type for hierarchy |
| description | TEXT | Detailed description |
| status | ENUM | Draft, Active, Inactive, Deprecated |

#### ORGANIZATION
| Attribute | Type | Description |
|-----------|------|-------------|
| organization_id | VARCHAR(50) | Primary key |
| org_code | VARCHAR(50) | Unique code within parent |
| org_name | VARCHAR(200) | Display name |
| org_type | ENUM | GROUP, COMPANY, DIVISION, PLANT, DEPARTMENT |
| parent_org_id | VARCHAR(50) | Parent organization |
| materialized_path | VARCHAR(500) | /GROUP01/COMPANY01/... |
| level | INT | Depth in hierarchy |
| currency_code | VARCHAR(3) | ISO 4217 currency |
| timezone | VARCHAR(50) | Timezone |
| effective_date | DATE | Start date |
| expiration_date | DATE | End date (null = permanent) |

### Tracking Entities

#### LOCATION
| Attribute | Type | Description |
|-----------|------|-------------|
| location_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| latitude | DECIMAL(10,7) | GPS latitude |
| longitude | DECIMAL(10,7) | GPS longitude |
| altitude | DECIMAL(10,2) | GPS altitude |
| accuracy | DECIMAL(6,2) | Accuracy in meters |
| building | VARCHAR(100) | Building name |
| zone | VARCHAR(100) | Zone within building |
| line_station | VARCHAR(100) | Line/Station info |
| timestamp | DATETIME | Last update time |

#### LOAN_TICKET
| Attribute | Type | Description |
|-----------|------|-------------|
| loan_ticket_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| borrower_id | VARCHAR(50) | Employee borrowing |
| loan_type | ENUM | TEMPORARY, PERMANENT |
| checkout_time | DATETIME | When checked out |
| return_time | DATETIME | When returned |
| due_date | DATETIME | Expected return |
| status | ENUM | CHECKED_OUT, RETURNED, OVERDUE |
| purpose | TEXT | Reason for borrowing |

#### TRANSFER_TICKET
| Attribute | Type | Description |
|-----------|------|-------------|
| transfer_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| source_org_id | VARCHAR(50) | Source organization |
| target_org_id | VARCHAR(50) | Target organization |
| transfer_reason | VARCHAR(200) | Reason for transfer |
| requester_id | VARCHAR(50) | Who requested |
| approval_status | ENUM | PENDING, APPROVED, REJECTED |
| transfer_date | DATE | When transferred |

#### AUDIT_LOG
| Attribute | Type | Description |
|-----------|------|-------------|
| audit_id | VARCHAR(50) | Primary key |
| event_type | ENUM | CREATE, UPDATE, DELETE, READ |
| entity_type | VARCHAR(50) | Type of entity affected |
| entity_id | VARCHAR(50) | ID of affected entity |
| operator_id | VARCHAR(50) | User or "System" |
| timestamp | DATETIME | When event occurred |
| old_value | JSON | Previous state |
| new_value | JSON | New state |
| reason | TEXT | Reason for change |
| integrity_hash | VARCHAR(64) | Cryptographic hash |

#### IoT_SENSOR
| Attribute | Type | Description |
|-----------|------|-------------|
| sensor_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| sensor_type | ENUM | temperature, vibration, pressure, etc. |
| threshold_warning | DECIMAL | Warning threshold |
| threshold_critical | DECIMAL | Critical threshold |
| status | ENUM | REGISTERED, ACTIVE, INACTIVE, FAULT |
| health_score | INT | 0-100 health percentage |
| last_reading_time | DATETIME | Last data received |

### Maintenance Entities

#### MAINTENANCE_PLAN
| Attribute | Type | Description |
|-----------|------|-------------|
| plan_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| maintenance_type | ENUM | Preventive, Corrective, Predictive, Inspection |
| frequency_type | ENUM | Time-based, Usage-based, Hybrid |
| frequency_value | INT | Interval value |
| frequency_unit | ENUM | Day, Week, Month, Quarter, Year |
| usage_threshold | DECIMAL | Usage hours threshold |
| start_date | DATE | Plan start |
| advance_notice_days | INT | Days before due |
| estimated_hours | DECIMAL | Expected work hours |
| estimated_cost | DECIMAL | Expected cost |
| assigned_technician_id | VARCHAR(50) | Assigned employee |
| auto_generate_wo | BOOLEAN | Auto-create work orders |
| next_execution_date | DATE | Next scheduled date |
| status | ENUM | Active, Inactive, Completed |

#### WORK_ORDER
| Attribute | Type | Description |
|-----------|------|-------------|
| work_order_id | VARCHAR(50) | Primary key |
| wo_code | VARCHAR(50) | Unique work order code |
| plan_id | VARCHAR(50) | Source maintenance plan |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| priority | ENUM | Low, Medium, High, Emergency |
| scheduled_date | DATE | When scheduled |
| assigned_technician_id | VARCHAR(50) | Assigned employee |
| estimated_hours | DECIMAL | Expected hours |
| estimated_cost | DECIMAL | Expected cost |
| safety_notes | TEXT | Safety requirements |
| work_permit_required | BOOLEAN | Needs work permit |
| status | ENUM | Pending, Assigned, InProgress, Completed, Closed |
| actual_hours | DECIMAL | Actual work hours |
| actual_cost | DECIMAL | Actual cost |

#### MAINTENANCE_HISTORY
| Attribute | Type | Description |
|-----------|------|-------------|
| history_id | VARCHAR(50) | Primary key |
| work_order_id | VARCHAR(50) | Related work order |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| maintenance_type | ENUM | Type performed |
| result | ENUM | Success, PartialFailure, Failure |
| start_time | DATETIME | Start of work |
| end_time | DATETIME | End of work |
| actual_hours | DECIMAL | Duration |
| labor_cost | DECIMAL | Labor cost |
| parts_cost | DECIMAL | Parts cost |
| external_cost | DECIMAL | External vendor cost |
| performed_by_id | VARCHAR(50) | Employee who performed |
| failure_mode | VARCHAR(100) | Failure mode code |

#### VENDOR
| Attribute | Type | Description |
|-----------|------|-------------|
| vendor_id | VARCHAR(50) | Primary key |
| vendor_code | VARCHAR(50) | Unique code |
| vendor_name | VARCHAR(200) | Company name |
| vendor_type | ENUM | Manufacturer, ServiceProvider, Supplier |
| contact_email | VARCHAR(100) | Email address |
| contact_phone | VARCHAR(50) | Phone number |
| address | TEXT | Full address |
| qualifications | JSON | Certificate details |
| performance_score | DECIMAL | Rating score |
| active_status | BOOLEAN | Is active |

#### SPARE_PART
| Attribute | Type | Description |
|-----------|------|-------------|
| part_id | VARCHAR(50) | Primary key |
| part_number | VARCHAR(50) | Part number |
| part_name | VARCHAR(200) | Display name |
| description | TEXT | Description |
| unit_cost | DECIMAL | Cost per unit |
| quantity_on_hand | INT | Stock quantity |
| reorder_point | INT | Reorder threshold |
| bin_location | VARCHAR(50) | Storage location |
| status | ENUM | Available, Reserved, OutOfStock |

### Financial Entities

#### DEPRECIATION_SCHEDULE
| Attribute | Type | Description |
|-----------|------|-------------|
| schedule_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| depreciation_method | ENUM | StraightLine, DecliningBalance, etc. |
| acquisition_cost | DECIMAL | Original cost |
| useful_life_years | INT | Expected life in years |
| residual_value | DECIMAL | Salvage value |
| depreciation_start_date | DATE | When depreciation began |
| gaap_type | ENUM | US_GAAP, IFRS |
| accumulated_depreciation | DECIMAL | Total depreciated |
| net_book_value | DECIMAL | Current value |

#### INSURANCE_POLICY
| Attribute | Type | Description |
|-----------|------|-------------|
| policy_id | VARCHAR(50) | Primary key |
| policy_number | VARCHAR(50) | Insurance policy number |
| insurer_name | VARCHAR(200) | Insurance company |
| policy_type | ENUM | property, liability |
| coverage_amount | DECIMAL | Coverage limit |
| premium_amount | DECIMAL | Premium cost |
| deductible_amount | DECIMAL | Deductible |
| start_date | DATE | Coverage start |
| end_date | DATE | Coverage end |

#### CAPITAL_PROJECT
| Attribute | Type | Description |
|-----------|------|-------------|
| project_id | VARCHAR(50) | Primary key |
| project_code | VARCHAR(50) | Unique code |
| project_name | VARCHAR(200) | Project name |
| budget_amount | DECIMAL | Total budget |
| start_date | DATE | Project start |
| estimated_end_date | DATE | Expected completion |
| capitalization_threshold | DECIMAL | Min amount to capitalize |
| status | ENUM | Planning, Active, Completed, Closed |
| expenditure_total | DECIMAL | Total spent |

### Lifecycle Entities

#### PURCHASE_ORDER
| Attribute | Type | Description |
|-----------|------|-------------|
| po_id | VARCHAR(50) | Primary key |
| po_number | VARCHAR(50) | PO number |
| supplier_id | VARCHAR(50) | Foreign key to Supplier |
| total_amount | DECIMAL | Order total |
| unit_price | DECIMAL | Price per unit |
| quantity | INT | Quantity ordered |
| company_code | VARCHAR(50) | Ordering company |
| status | ENUM | PENDING, APPROVED, RECEIVED, CANCELLED |
| received_quantity | INT | Quantity received |

#### DISPOSAL_RECORD
| Attribute | Type | Description |
|-----------|------|-------------|
| disposal_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| disposal_method | ENUM | Retirement, Sale, Donation, Disassembly |
| reason | TEXT | Reason for disposal |
| assessed_value | DECIMAL | Value assessment |
| expected_proceeds | DECIMAL | Expected sale amount |
| gain_loss_amount | DECIMAL | Financial result |
| accounting_voucher_id | VARCHAR(50) | GL voucher reference |
| environmental_compliance | BOOLEAN | Env. compliance met |
| data_sanitization | BOOLEAN | Data wiped certificate |
| approval_status | ENUM | PENDING, APPROVED, REJECTED |

#### BORROWING_RECORD
| Attribute | Type | Description |
|-----------|------|-------------|
| record_id | VARCHAR(50) | Primary key |
| asset_id | VARCHAR(50) | Foreign key to Asset |
| borrower_id | VARCHAR(50) | Employee borrowing |
| borrow_date | DATE | When borrowed |
| expected_return_date | DATE | Expected return |
| actual_return_date | DATE | Actual return |
| purpose | TEXT | Reason |
| approval_status | ENUM | PENDING, APPROVED, REJECTED |

---

## 6. Entity Relationship Types

### One-to-Many (1:N)
```
Organization ──────▶ Asset           (1 org has N assets)
Organization ──────▶ Department       (1 org has N departments)
Department ───────▶ CostCenter      (1 dept has N cost centers)
AssetType ────────▶ Asset           (1 type has N assets)
Asset (parent) ────▶ Asset (child)  (1 asset has N child assets)
MaintenancePlan ──▶ WorkOrder       (1 plan generates N work orders)
WorkOrder ────────▶ MaintenanceHistory (1 WO creates 1 history)
Vendor ────────────▶ ServiceContract (1 vendor provides N contracts)
```

### Many-to-Many (N:M)
```
Asset ◀───────────▶ SparePart       (assets use parts)
Asset ◀───────────▶ InsurancePolicy (assets are covered by policies)
Asset ◀───────────▶ Organization    (assets allocated to orgs)
AllocationPlan ───▶ Asset           (plans allocate assets)
```

### One-to-One (1:1)
```
Asset ────────────▶ DepreciationSchedule (each asset has 1 schedule)
WorkOrder ────────▶ MaintenanceHistory  (each WO creates 1 history)
```

---

## 7. Data Hierarchy Structure

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              MULTI-COMPANY HIERARCHY                              │
│                                                                                  │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  GROUP (Global Parent)                                                 │    │
│    │  - Top level organization                                             │    │
│    │  - May contain multiple companies                                       │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
│                    │                                                            │
│                    ▼                                                            │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  COMPANY (Legal Entity)                                                │    │
│    │  - US Manufacturing Inc.                                                │    │
│    │  - EU Holdings GmbH                                                     │    │
│    │  - Has its own chart of accounts                                       │    │
│    │  - Subject to local regulations (SOX, GDPR, etc.)                        │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
│                    │                                                            │
│                    ▼                                                            │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  DIVISION (Business Unit)                                               │    │
│    │  - North America Division                                               │    │
│    │  - European Division                                                    │    │
│    │  - May cross legal entities                                             │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
│                    │                                                            │
│                    ▼                                                            │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  PLANT (Manufacturing Site)                                             │    │
│    │  - Plant A - Detroit                                                    │    │
│    │  - Plant B - Chicago                                                     │    │
│    │  - Plant C - Munich                                                      │    │
│    │  - Physical location with address                                        │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
│                    │                                                            │
│                    ▼                                                            │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  DEPARTMENT (Functional Unit)                                           │    │
│    │  - Assembly                                                            │    │
│    │  - Machining                                                           │    │
│    │  - Quality Control                                                      │    │
│    │  - Logistics                                                           │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
│                    │                                                            │
│                    ▼                                                            │
│    ┌─────────────────────────────────────────────────────────────────────────┐    │
│    │  COST CENTER (Financial Accounting)                                     │    │
│    │  - CC-1001: Assembly Direct                                            │    │
│    │  - CC-1002: Machining Overhead                                          │    │
│    │  - Used for cost allocation                                            │    │
│    └─────────────────────────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## 8. Access Control Entity Relationships

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              ACCESS CONTROL MODEL                                 │
│                                                                                  │
│    ┌─────────────┐                                                             │
│    │    USER     │                                                             │
│    │             │                                                             │
│    │ - User ID   │                                                             │
│    │ - Email     │                                                             │
│    │ - Role (FK) │                                                             │
│    │ - Company   │                                                             │
│    └──────┬──────┘                                                             │
│           │ assigned                                                            │
│           ▼                                                                    │
│    ┌─────────────┐       ┌─────────────┐       ┌─────────────┐                  │
│    │    ROLE     │──────▶│ PERMISSION │       │DATA_ACCESS │                  │
│    │             │ has   │             │       │   GRANT     │                  │
│    └─────────────┘       └─────────────┘       └──────┬──────┘                  │
│                                                        │                         │
│                                                        │ grants                  │
│                                                        ▼                         │
│                                              ┌─────────────────┐               │
│                                              │  FROM COMPANY   │               │
│                                              │      TO         │               │
│                                              │   TO COMPANY    │               │
│                                              └─────────────────┘               │
│                                                                                  │
└─────────────────────────────────────────────────────────────────────────────────┘
```

---

## 9. Module-Entity Matrix

| Module | Entity | Count |
|--------|--------|-------|
| 0 - Asset Central | Asset, Dashboard | 2 |
| 2.1 - Registration | Asset, AssetType, AssetCategory, RFIDTag, Barcode, Document, Employee | 7 |
| 2.2 - Tracking | Location, Geofence, LoanTicket, TransferTicket, AuditLog, IoTSensor, SensorReading | 7 |
| 2.3 - Maintenance | MaintenancePlan, WorkOrder, MaintenanceHistory, ServiceContract, SparePart, Vendor, CalibrationRecord | 7 |
| 2.4 - Financial | DepreciationSchedule, InsurancePolicy, InsuranceClaim, CapitalProject, ExchangeRate, Budget | 6 |
| 2.5 - Multi-Plant | Organization, CostCenter | 2 |
| 2.6 - Lifecycle | PurchaseOrder, Supplier, CommissioningRecord, DisposalRecord, BorrowingRecord, CycleCountPlan | 6 |
| 2.7 - Utilization | AllocationPlan, UsageContract, AssetReservation, UsageRecord | 4 |
| 2.8 - Multi-Company | LegalEntity, DataAccessGrant, Role | 3 |

**Total Core Entities: 44**

---

## 10. Asset as Central Hub

The following diagram shows how all entities connect back to the central Asset entity:

```
                              ┌──────────────────────────────────────────────────────┐
                              │                                                      │
                              │              OTHER MODULES                           │
                              │                                                      │
                              ▼                                                      │
┌─────────────┐      ┌─────────────┐      ┌─────────────┐      ┌─────────────┐    │
│ORGANIZATION  │      │  LOCATION   │      │ IoT SENSOR  │      │  DOCUMENT  │    │
│             │      │             │      │             │      │             │    │
└──────┬──────┘      └──────┬──────┘      └──────┬──────┘      └──────┬──────┘    │
       │                     │                     │                     │            │
       │                     │                     │                     │            │
       └─────────────────────┼─────────────────────┼─────────────────────┘            │
                             │                     │                                      │
                             ▼                     ▼                                      │
┌─────────────────────────────────────────────────────────────────────────────────────┐ │
│                                   ASSET                                            │ │
│                                                                                      │ │
│  The central hub that connects all business entities and modules                     │ │
│                                                                                      │ │
└─────────────────────────────────────────────────────────────────────────────────────┘ │
                             │                     │                                      │
                             │                     │                                      │
       ┌─────────────────────┼─────────────────────┼─────────────────────┐            │
       │                     │                     │                     │            │
       ▼                     ▼                     ▼                     ▼            │
┌─────────────┐      ┌─────────────┐      ┌─────────────┐      ┌─────────────┐         │
│  WORK ORDER │      │  LOAN TICKET│      │  RFID TAG   │      │  BARCODE    │         │
│             │      │             │      │             │      │             │         │
└──────┬──────┘      └──────┬──────┘      └─────────────┘      └─────────────┘         │
       │                     │                                                         │
       │ creates             │ creates                                                 │
       ▼                     ▼                                                         │
┌─────────────┐      ┌─────────────┐                                                   │
│MAINTENANCE │      │   BORROWING │                                                   │
│  HISTORY   │      │   RECORD   │                                                   │
└─────────────┘      └─────────────┘                                                   │
                                                                                        │
       │                                                                         │
       │ linked                                                                  │
       ▼                                                                         │
┌─────────────┐                                                                   │
│ DEPRECIA-  │                                                                   │
│   TION     │                                                                   │
│ SCHEDULE   │                                                                   │
└─────────────┘                                                                   │
                                                                                        │
       │                                                                         │
       │ belongs                                                                 │
       ▼                                                                         │
┌─────────────┐                                                                   │
│ INSURANCE   │                                                                   │
│  POLICY    │                                                                   │
└─────────────┘                                                                   │
                                                                                        │
       │                                                                         │
       │ part of                                                                 │
       ▼                                                                         │
┌─────────────────────────────────────────────────────────────────────────────────┐       │
│                          CAPITAL PROJECT                                       │       │
│                         (Construction in Progress)                             │       │
└─────────────────────────────────────────────────────────────────────────────────┘       │
                                                                                        │
       │                                                                         │
       │ in                                                                     │
       ▼                                                                         │
┌─────────────┐                                                                   │
│ALLOCATION   │                                                                   │
│   PLAN      │                                                                   │
└─────────────┘                                                                   │
                                                                                        │
```

---

## 11. Summary

The Asset Management System contains **44 core entities** organized across **9 modules**. The **Asset** entity serves as the central hub connecting all other entities.

**Key Relationships:**
- Organizational hierarchy: GROUP → COMPANY → DIVISION → PLANT → DEPARTMENT → COST_CENTER
- Asset hierarchy: Parent Asset → Child Assets (self-referential)
- Maintenance flow: MaintenancePlan → WorkOrder → MaintenanceHistory
- Financial tracking: Asset → DepreciationSchedule, InsurancePolicy, CapitalProject
- Lifecycle: Procurement → Receiving → Commissioning → ActiveUse → Disposal

**Access Control:**
- Users are assigned to Roles
- Roles have Permissions
- Data Access Grants enable cross-company data visibility
- Organizational hierarchy defines data scope boundaries
