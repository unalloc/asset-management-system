# Business Architecture

## Overview

The Asset Management System is built on a modular architecture that supports multi-company operations, compliance requirements, and integration with enterprise systems.

---

## System Architecture

### High-Level Architecture

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                            USER INTERFACE LAYER                            │
│  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐  ┌─────────────┐        │
│  │    Web     │  │   Mobile    │  │   Portal    │  │  Reporting  │        │
│  │  Application│  │    App      │  │  (Self-Service)│ │   & BI      │        │
│  └─────────────┘  └─────────────┘  └─────────────┘  └─────────────┘        │
└─────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                           BUSINESS SERVICE LAYER                            │
│  ┌──────────────────────────────────────────────────────────────────────┐  │
│  │                    CORE ASSET MANAGEMENT SERVICES                     │  │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐    │  │
│  │  │   Asset     │ │ Maintenance │ │  Financial  │ │  Asset      │    │  │
│  │  │ Registration│ │ Management  │ │  Management │ │  Tracking   │    │  │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘    │  │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐    │  │
│  │  │  Lifecycle  │ │ Utilization │ │ Multi-Plant │ │Multi-Company│    │  │
│  │  │  Management │ │ Management  │ │  Management │ │  Management │    │  │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘    │  │
│  └──────────────────────────────────────────────────────────────────────┘  │
│                                                                              │
│  ┌──────────────────────────────────────────────────────────────────────┐  │
│  │                    CROSS-CUTTING SERVICES                             │  │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐    │  │
│  │  │   Audit     │ │ Security &  │ │ Notification│ │  Document   │    │  │
│  │  │   & Compli  │ │ Access Ctrl  │ │  Service    │ │  Management  │    │  │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘    │  │
│  └──────────────────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                              DATA LAYER                                      │
│  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐        │
│  │   Asset     │ │ Maintenance │ │  Financial  │ │  Document    │        │
│  │   Master    │ │   Data      │ │    Data     │ │    Store     │        │
│  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘        │
│                              │                                               │
│                              ▼                                               │
│                    ┌─────────────────────┐                                  │
│                    │   Data Warehouse    │                                  │
│                    │  (Consolidated)     │                                  │
│                    └─────────────────────┘                                  │
└─────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                         INTEGRATION LAYER                                    │
│  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐        │
│  │     ERP     │ │     HR      │ │     IoT     │ │   External   │        │
│  │  (SAP/Oracle│ │   Systems   │ │  Platform   │ │   Services   │        │
│  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘        │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## Module Structure

### Module Overview

| Module | Description | Key Components |
|--------|-------------|----------------|
| **2. Asset Registration** | Asset master data and classification | Asset types, categories, hierarchy, barcode/QR, RFID |
| **3. Asset Tracking** | Real-time location and status monitoring | Check-in/out, transfers, IoT integration, mobile verification |
| **4. Maintenance** | Maintenance planning and execution | Preventive/predictive maintenance, work orders, calibration |
| **5. Financial** | Asset financial management | Depreciation, valuation, insurance, tax, budget |
| **6. Multi-Plant** | Cross-facility operations | Plant hierarchy, consolidated reporting, standards compliance |
| **7. Lifecycle** | Asset lifecycle from procurement to disposal | Procurement, receiving, capitalization, disposal |
| **8. Utilization** | Asset allocation and usage tracking | Reservation, cost allocation, capacity planning |
| **9. Multi-Company** | Multi-entity group management | Data isolation, consolidation, inter-company transfers |

---

## Organizational Hierarchy

### Data Architecture

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                              GROUP LEVEL                                    │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Group Policies & Standards                                         │   │
│  │ • Consolidated Reporting                                            │   │
│  │ • Inter-company Agreement Templates                                  │   │
│  │ • Global Asset Registry View                                         │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Inherits & Aggregates
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                            COMPANY LEVEL                                     │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Legal Entity Management (separate books)                          │   │
│  │ • Entity-specific Depreciation Rules (US GAAP / IFRS)               │   │
│  │ • Tax Compliance & Reporting                                        │   │
│  │ • Inter-company Asset Transfers with Transfer Pricing               │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Inherits & Aggregates
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                            DIVISION LEVEL                                    │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Business Unit Management                                           │   │
│  │ • Division-level KPIs                                               │   │
│  │ • Cross-plant Resource Allocation                                    │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Inherits & Aggregates
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                             PLANT LEVEL                                      │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Physical Asset Records                                             │   │
│  │ • Plant-specific Maintenance Plans                                   │   │
│  │ • Location Management                                                │   │
│  │ • OSHA/EPA Compliance (local regulatory)                           │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Inherits & Aggregates
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                          DEPARTMENT LEVEL                                    │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Department Cost Centers                                           │   │
│  │ • Asset Assignment & Custodianship                                   │   │
│  │ • Shift & Resource Scheduling                                      │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    │ Inherits & Aggregates
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                          COST CENTER LEVEL                                  │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │ • Financial Accounting Unit                                         │   │
│  │ • Depreciation Tracking                                             │   │
│  │ • Budget Responsibility                                             │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## Data Isolation Architecture

### Multi-Company Data Security

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                         APPLICATION LAYER                                   │
│  ┌──────────────────────┐    ┌──────────────────────┐                      │
│  │   Company A Session  │    │   Company B Session  │                      │
│  │   CompanyCode = A    │    │   CompanyCode = B    │                      │
│  └──────────┬───────────┘    └──────────┬───────────┘                      │
│             │                              │                                 │
│             ▼                              ▼                                 │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                    SECURITY & ACCESS CONTROL                          │   │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐    │   │
│  │  │    Role     │ │   Company   │ │  Plant     │ │ Department  │    │   │
│  │  │  Based      │ │   Scope     │ │  Scope     │ │  Scope      │    │   │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘    │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                    │                                        │
│                                    ▼                                        │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                      DATA ACCESS FILTER                              │   │
│  │                                                                       │   │
│  │   ALL queries automatically include: WHERE CompanyCode = :session     │   │
│  │                                                                       │   │
│  │   Users can ONLY see data within their authorized scope              │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
                                    │
                                    ▼
┌─────────────────────────────────────────────────────────────────────────────┐
│                          DATA STORAGE LAYER                                 │
│  ┌──────────────────────┐    ┌──────────────────────┐                      │
│  │    Company A Data    │    │    Company B Data    │                      │
│  │    (Isolated)        │    │    (Isolated)        │                      │
│  └──────────────────────┘    └──────────────────────┘                      │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## Compliance Architecture

### Regulatory Compliance Framework

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                      COMPLIANCE FRAMEWORK                                   │
├─────────────────────────────────────────────────────────────────────────────┤
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                        ISO 55000 AMS                                 │   │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐    │   │
│  │  │   Asset     │ │  Management │ │   Asset     │ │  Continual  │    │   │
│  │  │  Register   │ │   Planning  │ │  Performance│ │ Improvement │    │   │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘    │   │
│  └─────────────────────────────────────────────────────────────────────┘   │
│                                    │                                        │
│         ┌──────────────────────────┼──────────────────────────┐             │
│         │                          │                          │             │
│         ▼                          ▼                          ▼             │
│  ┌─────────────────┐      ┌─────────────────┐      ┌─────────────────┐        │
│  │   FINANCIAL    │      │    DATA        │      │    SAFETY &    │        │
│  │   COMPLIANCE   │      │   PRIVACY      │      │ ENVIRONMENTAL  │        │
│  ├───────────────┤      ├─────────────────┤      ├─────────────────┤        │
│  │ • SOX         │      │ • GDPR          │      │ • OSHA          │        │
│  │ • US GAAP     │      │ • CCPA          │      │ • EPA           │        │
│  │ • IFRS        │      │ • Data Minimiz. │      │ • WEEE          │        │
│  │ • Tax Rules   │      │ • Consent Mgmt  │      │ • REACH         │        │
│  └─────────────────┘      └─────────────────┘      └─────────────────┘        │
│                                                                             │
└─────────────────────────────────────────────────────────────────────────────┘
```

---

## Integration Architecture

### External System Integration

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                    ASSET MANAGEMENT SYSTEM                                  │
│                                                                             │
│  ┌─────────────────────────────────────────────────────────────────────┐   │
│  │                      INTEGRATION SERVICES                             │   │
│  │  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐  │  │
│  │  │     API     │ │   Webhook   │ │    File     │ │    Event    │  │  │
│  │  │  Gateway    │ │   Service   │ │   Transfer  │ │   Bus       │  │  │
│  │  └─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘  │  │
│  └─────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────┘
           │                    │                    │                    │
           ▼                    ▼                    ▼                    ▼
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│      ERP       │    │       HR        │    │      IoT       │    │    GRC         │
│  ─────────────  │    │  ─────────────  │    │  ─────────────  │    │  ─────────────  │
│  SAP S/4HANA    │    │  Workday        │    │  Sensors       │    │  Audit Logs    │
│  Oracle ERP     │    │  SuccessFactors │    │  Gateways      │    │  Compliance    │
│  Microsoft Dyn. │    │  ADP            │    │  Edge Devices  │    │  SIEM          │
└─────────────────┘    └─────────────────┘    └─────────────────┘    └─────────────────┘
```

---

## Module Dependency Diagram

```
                    ┌─────────────────┐
                    │  Multi-Company  │
                    │    (F-2.8)       │
                    │   [Foundation]  │
                    └────────┬────────┘
                             │
              ┌──────────────┼──────────────┐
              │              │              │
              ▼              ▼              ▼
    ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
    │   Financial    │ │  Multi-Plant   │ │     Asset       │
    │   (F-2.4)      │ │   (F-2.5)       │ │  Registration  │
    └────────┬──────┘ └────────┬───────┘ │   (F-2.1)       │
             │                  │          └────────┬───────┘
             │                  │                   │
             ▼                  │                   ▼
    ┌─────────────────┐         │         ┌─────────────────┐
    │    Asset       │         │         │  Asset Tracking  │
    │   Lifecycle    │◄────────┤         │    (F-2.2)       │
    │   (F-2.6)      │         │         └────────┬────────┘
    └────────┬──────┘         │                  │
             │                 │                  ▼
             │                 │         ┌─────────────────┐
             │                 └────────►│   Maintenance   │
             │                           │    (F-2.3)       │
             │                           └────────┬────────┘
             │                                    │
             └────────────────────────────────────┘
                              │
                              ▼
                    ┌─────────────────┐
                    │   Utilization   │
                    │    (F-2.7)       │
                    └─────────────────┘
```

---

*Next: [Use Cases](use-cases.md)*
