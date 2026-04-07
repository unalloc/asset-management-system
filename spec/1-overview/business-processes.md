# Business Processes

## Overview

This document describes the key business processes supported by the Asset Management System. Each process spans multiple modules and involves various user roles.

---

## 1. Asset Registration Process

### Process Description

New assets are registered into the system through a controlled workflow that ensures data quality and proper classification.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│   Request   │────►│    Verify    │────►│   Classify  │────►│   Register   │
│ New Asset   │     │   Details    │     │   Asset     │     │   Asset      │
└─────────────┘     └──────────────┘     └─────────────┘     └──────────────┘
                                                                      │
                                                                      ▼
                                                              ┌──────────────┐
                                                              │ Assign ID & │
                                                              │ Barcode     │
                                                              └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Submit asset registration request with details | Asset Manager |
| 2 | Verify asset information and documentation | Asset Manager |
| 3 | Classify asset by type, category, criticality | Asset Manager |
| 4 | Register asset in system with unique ID | Asset Manager |
| 5 | Generate barcode/QR code for tracking | System |

### Key Documents
- Purchase order
- Delivery receipt
- Asset specifications
- Warranty documentation

---

## 2. Asset Transfer Process

### Process Description

Assets are transferred between locations (plants, departments) with proper approval and tracking.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│   Request   │────►│   Approve    │────►│   Transfer  │────►│   Receive &  │
│   Transfer  │     │   Transfer   │     │   Physical  │     │   Verify     │
└─────────────┘     └──────────────┘     └─────────────┘     └──────────────┘
                           │
                           ▼
                   ┌──────────────┐
                   │ Update Asset │
                   │ Location      │
                   └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Request asset transfer with justification | Department User |
| 2 | Approve transfer based on policies | Plant Manager / Company Admin |
| 3 | Physically move asset to new location | Warehouse / Technician |
| 4 | Receive and verify asset at destination | Receiving Department |
| 5 | Update asset location in system | Asset Manager |

### Compliance Requirements
- Transfer pricing documentation for inter-company transfers
- Audit trail for all movements
- Asset valuation updates

---

## 3. Maintenance Workflow Process

### Process Description

Maintenance activities are planned, scheduled, executed, and documented through a complete workflow.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│  Schedule   │────►│  Generate    │────►│  Assign &   │────►│  Execute     │
│  Maintenance│     │  Work Order  │     │  Prepare    │     │  Work        │
└─────────────┘     └──────────────┘     └─────────────┘     └──────────────┘
                                                                      │
                                                                      ▼
                                                              ┌──────────────┐
                                                              │  Complete &  │
                                                              │  Document    │
                                                              └──────────────┘
```

### Types of Maintenance

| Type | Trigger | Description |
|------|---------|-------------|
| Preventive | Time-based | Scheduled at regular intervals |
| Predictive | Condition-based | Triggered by IoT sensor data |
| Corrective | Failure-based | Reactive to asset breakdown |
| Emergency | Urgent | Immediate response to critical failure |

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Create maintenance schedule based on plans | Maintenance Manager |
| 2 | Generate work order with tasks and resources | System |
| 3 | Assign technician and reserve parts | Maintenance Manager |
| 4 | Execute maintenance work | Technician |
| 5 | Complete work order with notes and parts used | Technician |
| 6 | Update asset history and close work order | Technician |

---

## 4. Asset Disposal Process

### Process Description

Assets are retired and disposed of through an approved workflow ensuring regulatory compliance.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│  Identify   │────►│   Request    │────►│   Approve   │────►│   Execute    │
│  for        │     │   Disposal   │     │   Disposal  │     │   Disposal   │
│  Retirement │     └──────────────┘     └─────────────┘     └──────────────┘
└─────────────┘                                                    │
                         ┌──────────────┐                         │
                         │   Update     │◄────────────────────────┘
                         │   Financials │
                         └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Identify asset for retirement based on age, condition, cost | Asset Manager |
| 2 | Submit disposal request with justification | Asset Manager |
| 3 | Obtain required approvals (Finance, Legal, Safety) | Approvers |
| 4 | Execute disposal (sale, recycle, scrap) | Procurement / EHS |
| 5 | Update financial records and generate gain/loss | Finance |
| 6 | Archive asset record with full history | Asset Manager |

### Compliance Requirements
- WEEE Directive compliance for electronic equipment
- EPA RCRA compliance for hazardous materials
- Audit trail for asset removal
- Gain/loss calculation for accounting

---

## 5. Asset Utilization Management Process

### Process Description

Assets are allocated to departments/projects with cost tracking and utilization optimization.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│   Request   │────►│   Approve    │────►│   Allocate  │────►│   Track &    │
│   Asset     │     │   Request   │     │   Asset     │     │   Charge     │
│   Usage     │     └──────────────┘     └─────────────┘     └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Submit asset usage request | Department User |
| 2 | Review availability and approve | Asset Manager |
| 3 | Allocate asset to department/project | Asset Manager |
| 4 | Track usage hours and costs | System |
| 5 | Generate cost allocation charges | System |

---

## 6. Physical Inventory Process

### Process Description

Physical asset verification through cycle counting and full inventory audits.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│   Create    │────►│   Assign     │────►│   Count &  │────►│   Reconcile  │
│   Count     │     │   Count      │     │   Scan      │     │   Results    │
│   Plan      │     │   Tasks      │     │   Assets    │     │   & Adjust   │
└─────────────┘     └──────────────┘     └─────────────┘     └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Create cycle count or full inventory plan | Asset Manager |
| 2 | Assign counting tasks to technicians | Asset Manager |
| 3 | Physically count and scan assets | Technicians |
| 4 | Reconcile counts with system records | Asset Manager |
| 5 | Investigate and resolve variances | Asset Manager |
| 6 | Update records and write-off losses | Asset Manager |

---

## 7. Financial Depreciation Process

### Process Description

Automated depreciation calculation and posting across multiple accounting standards.

### Process Flow

```
┌─────────────┐     ┌──────────────┐     ┌─────────────┐     ┌──────────────┐
│   Calculate │────►│   Review &   │────►│   Post to   │────►│   Generate   │
│   Depreci-  │     │   Validate   │     │   Finance   │     │   Reports    │
│   ation     │     └──────────────┘     └─────────────┘     └──────────────┘
```

### Steps

| Step | Description | Responsible Role |
|------|-------------|------------------|
| 1 | Calculate depreciation based on asset cost, life, method | System |
| 2 | Review depreciation schedule and validate | Accountant |
| 3 | Post journal entries to financial system | System |
| 4 | Generate asset registers and reports | System |

### Supported Methods
- Straight-line
- Declining balance
- Sum-of-years digits
- Units of production

---

## Cross-Functional Process Dependencies

```
                    ┌─────────────────────────────────────┐
                    │       PROCUREMENT WORKFLOW           │
                    └─────────────────────────────────────┘
                                        │
                                        ▼
┌───────────────────────────────────────────────────────────────────────┐
│                        ASSET LIFECYCLE                               │
│                                                                       │
│  ┌──────────┐   ┌──────────┐   ┌──────────┐   ┌──────────┐   ┌──────┐ │
│  │  Asset   │──►│  Asset   │──►│  Asset   │──►│  Asset   │──►│Asset │ │
│  │  Create  │   │ Deploy  │   │ Operate  │   │ Maintain │   │Dispse│ │
│  └──────────┘   └──────────┘   └──────────┘   └──────────┘   └──────┘ │
│       │                                                          │      │
│       │                                                          │      │
│       ▼                                                          ▼      │
│  ┌──────────┐                                             ┌──────────┐  │
│  │ Financial│                                             │Financial │  │
│  │ Tracking│                                             │ Closeout │  │
│  └──────────┘                                             └──────────┘  │
└───────────────────────────────────────────────────────────────────────┘
                                        │
                                        ▼
                    ┌─────────────────────────────────────┐
                    │       MAINTENANCE WORKFLOW            │
                    └─────────────────────────────────────┘
```

---

*Next: [Business Architecture](business-architecture.md)*
