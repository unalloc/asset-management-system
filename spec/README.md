# Asset Management System - Product Requirements Document

## Document Overview

This repository contains the complete product requirements for an Asset Management System designed for multinational manufacturing corporations with multiple factories. The system is designed for Western markets (US/EU) and focuses on fixed asset management.

> **Note:** This is a pure business requirements document. All technical design content has been removed. No database schemas, API specifications, or implementation details are included.

## Document Structure

```
spec/
├── README.md                          # This file - main index
├── 0-asset-central/                   # Asset Central Hub & Entity Model
├── 1-overview/                       # Project overview and objectives
├── 2-asset-registration/             # Asset Registration & Cataloging (15 requirements)
├── 3-asset-tracking/                  # Asset Tracking & Monitoring (10 requirements)
├── 4-maintenance/                    # Maintenance Management (17 requirements)
├── 5-financial/                      # Financial Management (14 requirements)
├── 6-multi-plant/                    # Multi-Plant & Manufacturing Compliance (8 requirements)
├── 7-lifecycle/                      # Asset Lifecycle Management (18 requirements)
├── 8-utilization/                    # Asset Utilization & Allocation (17 requirements)
├── 9-multi-company/                  # Multi-Company Group Management (19 requirements)
└── 10-user-stories/                  # User Stories
```

## Entity Model

The system contains **44 core business entities** organized across 9 modules. The **Asset** entity is the central hub connecting all modules.

See [`0-asset-central/ENTITY-MODEL.md`](./0-asset-central/ENTITY-MODEL.md) for:
- Complete entity list with attributes
- Entity relationship diagrams
- Module-entity matrix
- Organizational hierarchy structure

### Key Entities

| Category | Primary Entities |
|----------|-----------------|
| **Core** | Asset, AssetType, AssetCategory, AssetHierarchy |
| **Tracking** | Location, LoanTicket, TransferTicket, AuditLog, IoTSensor |
| **Maintenance** | MaintenancePlan, WorkOrder, MaintenanceHistory, Vendor, SparePart |
| **Financial** | DepreciationSchedule, InsurancePolicy, CapitalProject, Budget |
| **Lifecycle** | PurchaseOrder, DisposalRecord, CommissioningRecord |
| **Utilization** | AllocationPlan, UsageContract, AssetReservation |
| **Organization** | Organization, LegalEntity, CostCenter |

## Module Summary

| Module | Name | Requirements |
|--------|------|-------------|
| 0 | Asset Central | 2 (Hub + Detail) |
| 2 | Asset Registration & Cataloging | 15 |
| 3 | Asset Tracking & Monitoring | 10 |
| 4 | Maintenance Management | 17 |
| 5 | Financial Management | 14 |
| 6 | Multi-Plant & Manufacturing Compliance | 8 |
| 7 | Asset Lifecycle Management | 18 |
| 8 | Asset Utilization & Allocation | 17 |
| 9 | Multi-Company Group Management | 19 |
| **Total** | | **120** |

## How to Navigate

1. **For entity understanding**: Start with [`0-asset-central/ENTITY-MODEL.md`](./0-asset-central/ENTITY-MODEL.md)
2. **For high-level understanding**: Then review `1-overview/`
3. **For functional requirements**: Navigate to the relevant module directory
4. **For detailed specifications**: Each requirement is in its own file

## Cross-Cutting Requirements (Module 9)

| ID | Title | Purpose |
|----|-------|---------|
| F-2.8.20 | Data Hierarchy and Access Control | 6-level hierarchy, RBAC, data isolation |
| F-2.8.21 | Audit and Compliance Framework | SOX, GDPR, ISO 55000 compliance |
| F-2.8.22 | Data Security and Privacy | Encryption, access control, privacy |

## Compliance Alignment

| Regulation | Scope | Key Requirements |
|------------|-------|-----------------|
| ISO 55000 | Global | Asset management system standards |
| US GAAP / IFRS | Accounting | Depreciation, impairment, leases |
| SOX | US Public Companies | Audit trail, internal controls |
| GDPR | EU/EER | Data protection, privacy |
| OSHA | US | Safety equipment tracking |
| EPA | US | Environmental compliance (WEEE, RCRA) |

## Organizational Hierarchy

The system supports a 6-level organizational structure:
- **Group** → **Company** → **Division** → **Plant** → **Department** → **Cost Center**

Data scoping and access control follow this hierarchy.

---

*Document Version: 10.0*  
*Last Updated: 2026-04-06*  
*Status: Pure Business Requirements (No Technical Design)*
