# Requirements Traceability Matrix

**Project:** Multinational Fixed Asset Management System  
**Version:** 2.0  
**Date:** 2026-04-08  
**Total Requirements:** 127 (118 functional + 9 Asset Central foundation items)

---

## 1. Module Summary Table

| Module | Name | Overview Page | Requirement IDs | Count |
|--------|------|--------------|----------------|-------|
| 1 | Asset Central (Foundation) | `Asset-Central-Hub.html` | F-0.0.1 – F-0.0.9 | 9 |
| 2 | Asset Registration & Cataloging | `Asset-Registration-Overview.html` | F-2.1.1 – F-2.1.15 | 15 |
| 3 | Asset Tracking & Monitoring | `Asset-Tracking-Overview.html` | F-2.2.1, F-2.2.2, F-2.2.3, F-2.2.4, F-2.2.5, F-2.2.6, F-2.2.11, F-2.2.12, F-2.2.13, F-2.2.15 | 10 |
| 4 | Maintenance Management | `Maintenance-Overview.html` | F-2.3.1 – F-2.3.18 | 17 |
| 5 | Financial Management | `Financial-Overview.html` | F-2.4.1 – F-2.4.14 | 14 |
| 6 | Multi-Plant & Manufacturing | `Multi-Plant-Overview.html` | F-2.5.1 – F-2.5.10 | 8 |
| 7 | Asset Lifecycle Management | `Lifecycle-Overview.html` | F-2.6.1 – F-2.6.18 | 18 |
| 8 | Asset Utilization and Allocation | `Utilization-Overview.html` | F-2.7.1 – F-2.7.18 | 18 |
| 9 | Multi-Company Group Management | `Multi-Company-Overview.html` | F-2.8.1 – F-2.8.22 | 22 |
| **Total** | | | | **127** |

---

## 2. Module 1: Asset Central (Foundation)

Asset Central serves as the main hub connecting all functional modules. It provides centralized access to asset management, work orders, vendors, spare parts, organizations, contracts, insurance, and disposal records.

| ID | Name | File | Priority |
|----|------|------|----------|
| F-0.0.1 | Asset Central Hub | `modules/asset-central/Asset-Central-Hub.html` | Critical |
| F-0.0.2 | Asset Detail View | `modules/asset-central/Asset-Detail.html` | Critical |
| F-0.0.3 | Work Order Hub | `modules/asset-central/Work-Order-Hub.html` | Critical |
| F-0.0.4 | Vendor Hub | `modules/asset-central/Vendor-Hub.html` | High |
| F-0.0.5 | Spare Parts Hub | `modules/asset-central/Spare-Part-Hub.html` | High |
| F-0.0.6 | Organization Hub | `modules/asset-central/Organization-Hub.html` | High |
| F-0.0.7 | Service Contract Hub | `modules/asset-central/Service-Contract-Hub.html` | High |
| F-0.0.8 | Insurance Hub | `modules/asset-central/Insurance-Hub.html` | Medium |
| F-0.0.9 | Disposal Hub | `modules/asset-central/Disposal-Hub.html` | Medium |

**Count:** 9

---

## 3. Module 2: Asset Registration & Cataloging

**Overview Page:** `modules/2-asset-registration/Asset-Registration-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.1.1 | Multiple Asset Types Support | `F-2.1.1-Multiple Asset Types Support.html` | High |
| F-2.1.2 | Custom Asset Categories | `F-2.1.2-Custom Asset Categories.html` | Medium |
| F-2.1.3 | Bulk Import-Export | `F-2.1.3-Bulk Import-Export.html` | High |
| F-2.1.4 | Barcode/QR Code Generation | `F-2.1.4-Barcode-QR Code Generation.html` | High |
| F-2.1.5 | RFID Tag Integration | `F-2.1.5-RFID Tag Integration.html` | Medium |
| F-2.1.6 | Asset Hierarchy | `F-2.1.6-Asset Hierarchy.html` | Medium |
| F-2.1.7 | Document Attachment | `F-2.1.7-Document Attachment.html` | Medium |
| F-2.1.8 | Manufacturing Asset Types | `F-2.1.8-Manufacturing Asset Types.html` | High |
| F-2.1.9 | Equipment Hierarchy | `F-2.1.9-Equipment Hierarchy.html` | High |
| F-2.1.10 | Tooling and Fixtures | `F-2.1.10-Tooling and Fixtures.html` | Medium |
| F-2.1.11 | Multi-Plant Asset Registry | `F-2.1.11-Multi-Plant Asset Registry.html` | High |
| F-2.1.12 | Asset Componentization | `F-2.1.12-Asset Componentization.html` | Medium |
| F-2.1.13 | Criticality Classification | `F-2.1.13-Criticality Classification.html` | High |
| F-2.1.14 | Integration API Framework | `F-2.1.14-Integration API Framework.html` | High |
| F-2.1.15 | HR Employee Integration | `F-2.1.15-HR Employee Integration.html` | Medium |

**Count:** 15

---

## 4. Module 3: Asset Tracking & Monitoring

**Overview Page:** `modules/3-asset-tracking/Asset-Tracking-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.2.1 | Real-time Location Tracking | `F-2.2.1-Real-time Location Tracking.html` | High |
| F-2.2.2 | Check-in-Check-out System | `F-2.2.2-Check-in-Check-out System.html` | High |
| F-2.2.3 | Transfer Management | `F-2.2.3-Transfer Management.html` | High |
| F-2.2.4 | Audit Trail | `F-2.2.4-Audit Trail.html` | High |
| F-2.2.5 | Mobile Asset Verification | `F-2.2.5-Mobile Asset Verification.html` | High |
| F-2.2.6 | IoT Sensor Integration | `F-2.2.6-IoT Sensor Integration.html` | Medium |
| F-2.2.11 | Inter-Plant Transfer | `F-2.2.11-Inter-Plant Transfer.html` | High |
| F-2.2.12 | Calibration Management | `F-2.2.12-Calibration Management.html` | Medium |
| F-2.2.13 | Safety Compliance | `F-2.2.13-Safety Compliance.html` | Medium |
| F-2.2.15 | GIS Geographic Integration | `F-2.2.15-GIS Geographic Integration.html` | Medium |

**Count:** 10

---

## 5. Module 4: Maintenance Management

**Overview Page:** `modules/4-maintenance/Maintenance-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.3.1 | Scheduled Maintenance Planning | `F-2.3.1-Scheduled Maintenance Planning.html` | High |
| F-2.3.2 | Preventive Maintenance Workflow | `F-2.3.2-Preventive Maintenance Workflow.html` | High |
| F-2.3.3 | Maintenance History Tracking | `F-2.3.3-Maintenance History Tracking.html` | High |
| F-2.3.4 | Service Contract Management | `F-2.3.4-Service Contract Management.html` | Medium |
| F-2.3.5 | Spare Parts Inventory Linkage | `F-2.3.5-Spare Parts Inventory Linkage.html` | Medium |
| F-2.3.6 | Vendor Management | `F-2.3.6-Vendor Management.html` | Medium |
| F-2.3.7 | Predictive Maintenance (IoT) | `F-2.3.7-Predictive Maintenance (IoT).html` | Medium |
| F-2.3.8 | RCM Strategies | `F-2.3.8-RCM Strategies.html` | Medium |
| F-2.3.9 | Maintenance KPIs | `F-2.3.9-Maintenance KPIs.html` | Medium |
| F-2.3.10 | Spare Parts Criticality | `F-2.3.10-Spare Parts Criticality.html` | Medium |
| F-2.3.11 | Work Order Prioritization | `F-2.3.11-Work Order Prioritization.html` | High |
| F-2.3.12 | Maintenance Backlog | `F-2.3.12-Maintenance Backlog.html` | Medium |
| F-2.3.13 | Calibration Schedules | `F-2.3.13-Calibration Schedules.html` | High |
| F-2.3.15 | Mobile Workforce Management | `F-2.3.15-Mobile Workforce Management.html` | High |
| F-2.3.16 | Centralized Notification System | `F-2.3.16-Centralized Notification System.html` | High |
| F-2.3.17 | Root Cause Analysis | `F-2.3.17-Root Cause Analysis.html` | Medium |
| F-2.3.18 | Maintenance Calendar View | `F-2.3.18-Maintenance Calendar View.html` | Medium |

**Count:** 17

---

## 6. Module 5: Financial Management

**Overview Page:** `modules/5-financial/Financial-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.4.1 | Multi-Currency Support | `F-2.4.1-Multi-Currency Support.html` | High |
| F-2.4.2 | Automated Depreciation | `F-2.4.2-Automated Depreciation.html` | High |
| F-2.4.3 | Insurance Tracking | `F-2.4.3-Insurance Tracking.html` | Medium |
| F-2.4.4 | TCO Analysis | `F-2.4.4-TCO Analysis.html` | Medium |
| F-2.4.5 | Budget vs Actual | `F-2.4.5-Budget vs Actual.html` | Medium |
| F-2.4.6 | Tax Compliance Reporting | `F-2.4.6-Tax Compliance Reporting.html` | High |
| F-2.4.7 | Capital Projects | `F-2.4.7-Capital Projects.html` | Medium |
| F-2.4.8 | Component-Level Financial | `F-2.4.8-Component-Level Financial.html` | Medium |
| F-2.4.9 | Asset Reclassification | `F-2.4.9-Asset Reclassification.html` | Medium |
| F-2.4.10 | Lease Accounting | `F-2.4.10-Lease Accounting.html` | High |
| F-2.4.11 | Country-Specific Tax Depreciation | `F-2.4.11-Country-Specific Tax Depreciation.html` | Medium |
| F-2.4.12 | Replacement Planning | `F-2.4.12-Replacement Planning.html` | Medium |
| F-2.4.13 | Residual Value Tracking | `F-2.4.13-Residual Value Tracking.html` | Low |
| F-2.4.14 | Insurance Valuation | `F-2.4.14-Insurance Valuation.html` | Low |

**Count:** 14

---

## 7. Module 6: Multi-Plant & Manufacturing

**Overview Page:** `modules/6-multi-plant/Multi-Plant-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.5.1 | Hierarchical Factory Structure | `F-2.5.1-Hierarchical Factory Structure.html` | High |
| F-2.5.2 | Factory-Specific Configuration | `F-2.5.2-Factory-Specific Configuration.html` | High |
| F-2.5.3 | Cross-Factory Consolidated Reporting | `F-2.5.3-Cross-Factory Consolidated Reporting.html` | High |
| F-2.5.4 | Standardized Asset Classification | `F-2.5.4-Standardized Asset Classification.html` | Medium |
| F-2.5.5 | Cross-Factory Asset Transfer | `F-2.5.5-Cross-Factory Asset Transfer.html` | High |
| F-2.5.6 | Centralized Contract Management | `F-2.5.6-Centralized Contract Management.html` | Medium |
| F-2.5.7 | Manufacturing Standards Compliance | `F-2.5.7-Manufacturing Standards Compliance.html` | High |
| F-2.5.10 | Regulatory Compliance Audit | `F-2.5.10-Regulatory Compliance Audit.html` | High |

**Count:** 8

---

## 8. Module 7: Asset Lifecycle Management

**Overview Page:** `modules/7-lifecycle/Lifecycle-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.6.1 | Procurement Workflow Integration | `F-2.6.1-Procurement Workflow Integration.html` | High |
| F-2.6.2 | Asset Receiving and Inspection | `F-2.6.2-Asset Receiving and Inspection.html` | High |
| F-2.6.3 | Capitalization Process | `F-2.6.3-Capitalization Process.html` | High |
| F-2.6.4 | Asset Deployment and Commissioning | `F-2.6.4-Asset Deployment and Commissioning.html` | High |
| F-2.6.5 | Borrowing-Return System | `F-2.6.5-Borrowing-Return System.html` | High |
| F-2.6.6 | Temporary Asset Borrowing | `F-2.6.6-Temporary Asset Borrowing.html` | Medium |
| F-2.6.7 | Physical Inventory Counting | `F-2.6.7-Physical Inventory Counting.html` | High |
| F-2.6.8 | Cycle Counting Plan | `F-2.6.8-Cycle Counting Plan.html` | Medium |
| F-2.6.9 | Asset Disposal Workflow | `F-2.6.9-Asset Disposal Workflow.html` | High |
| F-2.6.10 | Disposal Approval Workflow | `F-2.6.10-Disposal Approval Workflow.html` | High |
| F-2.6.11 | Asset Disassembly Tracking | `F-2.6.11-Asset Disassembly Tracking.html` | Medium |
| F-2.6.12 | Retirement Planning | `F-2.6.12-Retirement Planning.html` | High |
| F-2.6.13 | Asset Refurbishment | `F-2.6.13-Asset Refurbishment.html` | Medium |
| F-2.6.14 | Warranty Claim Processing | `F-2.6.14-Warranty Claim Processing.html` | High |
| F-2.6.15 | Lease Return and Purchase | `F-2.6.15-Lease Return and Purchase.html` | Medium |
| F-2.6.16 | Lifecycle Cost Tracking | `F-2.6.16-Lifecycle Cost Tracking.html` | High |
| F-2.6.17 | Environmental Disposal Compliance | `F-2.6.17-Environmental Disposal Compliance.html` | High |
| F-2.6.18 | Residual Value Realization | `F-2.6.18-Residual Value Realization.html` | Medium |

**Count:** 18

---

## 9. Module 8: Asset Utilization and Allocation

**Overview Page:** `modules/8-utilization/Utilization-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.7.1 | Asset Allocation Planning | `F-2.7.1-Asset Allocation Planning.html` | High |
| F-2.7.2 | Usage Request and Approval | `F-2.7.2-Usage Request and Approval.html` | High |
| F-2.7.3 | Asset Reservation System | `F-2.7.3-Asset Reservation System.html` | High |
| F-2.7.4 | Real-time Availability Tracking | `F-2.7.4-Real-time Availability Tracking.html` | High |
| F-2.7.5 | Usage Contract Management | `F-2.7.5-Usage Contract Management.html` | Medium |
| F-2.7.6 | Asset Utilization Calculation | `F-2.7.6-Asset Utilization Calculation.html` | High |
| F-2.7.8 | Idle Asset Identification | `F-2.7.8-Idle Asset Identification.html` | Medium |
| F-2.7.9 | Usage Cost Allocation | `F-2.7.9-Usage Cost Allocation.html` | High |
| F-2.7.10 | Department-Project Cost Tracking | `F-2.7.10-Department-Project Cost Tracking.html` | High |
| F-2.7.11 | Usage Performance Evaluation | `F-2.7.11-Usage Performance Evaluation.html` | Medium |
| F-2.7.12 | Shift-based Equipment Scheduling | `F-2.7.12-Shift-based Equipment Scheduling.html` | High |
| F-2.7.13 | Asset Sharing and Pool | `F-2.7.13-Asset Sharing and Pool.html` | Medium |
| F-2.7.14 | Usage History and Trend | `F-2.7.14-Usage History and Trend.html` | Medium |
| F-2.7.15 | Utilization Prediction | `F-2.7.15-Utilization Prediction.html` | High |
| F-2.7.16 | Cross-department Load Balancing | `F-2.7.16-Cross-department Load Balancing.html` | Medium |
| F-2.7.17 | Critical Asset Emergency | `F-2.7.17-Critical Asset Emergency.html` | High |
| F-2.7.18 | Usage Compliance Monitoring | `F-2.7.18-Usage Compliance Monitoring.html` | High |

**Count:** 18

---

## 10. Module 9: Multi-Company Group Management

**Overview Page:** `modules/9-multi-company/Multi-Company-Overview.html`

### Requirements

| ID | Name | File | Priority |
|----|------|------|----------|
| F-2.8.1 | Multi-level Org Hierarchy | `F-2.8.1-Multi-level Org Hierarchy.html` | High |
| F-2.8.2 | Legal Entity Management | `F-2.8.2-Legal Entity Management.html` | High |
| F-2.8.3 | Company Data Isolation | `F-2.8.3-Company Data Isolation.html` | High |
| F-2.8.4 | Group Consolidated Reporting | `F-2.8.4-Group Consolidated Reporting.html` | High |
| F-2.8.5 | Cross-company Asset Transfer | `F-2.8.5-Cross-company Asset Transfer.html` | High |
| F-2.8.6 | Inter-company Asset Leasing | `F-2.8.6-Inter-company Asset Leasing.html` | Medium |
| F-2.8.7 | Group-level Policy Templates | `F-2.8.7-Group-level Policy Templates.html` | High |
| F-2.8.8 | Centralized Procurement | `F-2.8.8-Centralized Procurement.html` | High |
| F-2.8.9 | Group-level Standardization | `F-2.8.9-Group-level Standardization.html` | Medium |
| F-2.8.10 | Company-specific Configuration | `F-2.8.10-Company-specific Configuration.html` | Medium |
| F-2.8.11 | Inter-company Cost Allocation | `F-2.8.11-Inter-company Cost Allocation.html` | High |
| F-2.8.12 | Group Audit Tracking | `F-2.8.12-Group Audit Tracking.html` | High |
| F-2.8.13 | Support Different Company Types | `F-2.8.13-Support Different Company Types.html` | Medium |
| F-2.8.14 | Multi-company Benchmarking | `F-2.8.14-Multi-company Benchmarking.html` | Medium |
| F-2.8.15 | Group Asset Optimization | `F-2.8.15-Group Asset Optimization.html` | High |
| F-2.8.19 | Reporting Dashboard Module | `F-2.8.19-Reporting Dashboard Module.html` | High |
| F-2.8.20 | Data Hierarchy Access Control | `F-2.8.20-Data Hierarchy Access Control.html` | Critical |
| F-2.8.21 | Audit Compliance Framework | `F-2.8.21-Audit Compliance Framework.html` | Critical |
| F-2.8.22 | Data Security Privacy | `F-2.8.22-Data Security Privacy.html` | Critical |

**Count:** 19

---

## 11. Requirements by Priority

### Critical Priority (6)

| Module | Requirements |
|--------|--------------|
| 1 | F-0.0.1, F-0.0.2, F-0.0.3 |
| 9 | F-2.8.20, F-2.8.21, F-2.8.22 |

### High Priority (78)

| Module | Requirements |
|--------|--------------|
| 1 | F-0.0.4, F-0.0.5, F-0.0.6 |
| 2 | F-2.1.1, F-2.1.3, F-2.1.4, F-2.1.8, F-2.1.9, F-2.1.11, F-2.1.13, F-2.1.14 |
| 3 | F-2.2.1, F-2.2.2, F-2.2.3, F-2.2.4, F-2.2.5, F-2.2.11 |
| 4 | F-2.3.1, F-2.3.2, F-2.3.3, F-2.3.11, F-2.3.13, F-2.3.15, F-2.3.16 |
| 5 | F-2.4.1, F-2.4.2, F-2.4.6, F-2.4.10 |
| 6 | F-2.5.1, F-2.5.2, F-2.5.3, F-2.5.5, F-2.5.7, F-2.5.10 |
| 7 | F-2.6.1, F-2.6.2, F-2.6.3, F-2.6.4, F-2.6.5, F-2.6.7, F-2.6.9, F-2.6.10, F-2.6.12, F-2.6.14, F-2.6.16, F-2.6.17 |
| 8 | F-2.7.1, F-2.7.2, F-2.7.3, F-2.7.4, F-2.7.6, F-2.7.9, F-2.7.10, F-2.7.12, F-2.7.15, F-2.7.17, F-2.7.18 |
| 9 | F-2.8.1, F-2.8.2, F-2.8.3, F-2.8.4, F-2.8.5, F-2.8.7, F-2.8.8, F-2.8.11, F-2.8.12, F-2.8.15, F-2.8.19 |

### Medium Priority (39)

| Module | Requirements |
|--------|--------------|
| 2 | F-2.1.2, F-2.1.5, F-2.1.6, F-2.1.7, F-2.1.10, F-2.1.12, F-2.1.15 |
| 3 | F-2.2.6, F-2.2.12, F-2.2.13, F-2.2.15 |
| 4 | F-2.3.4, F-2.3.5, F-2.3.6, F-2.3.7, F-2.3.8, F-2.3.9, F-2.3.10, F-2.3.12, F-2.3.17, F-2.3.18 |
| 5 | F-2.4.3, F-2.4.4, F-2.4.5, F-2.4.7, F-2.4.8, F-2.4.9, F-2.4.11, F-2.4.12 |
| 6 | F-2.5.4, F-2.5.6 |
| 7 | F-2.6.6, F-2.6.8, F-2.6.11, F-2.6.13, F-2.6.15, F-2.6.18 |
| 8 | F-2.7.5, F-2.7.8, F-2.7.11, F-2.7.13, F-2.7.14, F-2.7.16 |
| 9 | F-2.8.6, F-2.8.9, F-2.8.10, F-2.8.13, F-2.8.14 |

### Low Priority (4)

| Module | Requirements |
|--------|--------------|
| 5 | F-2.4.13, F-2.4.14 |

---

## 12. UI Mockup File Structure

```
mockup/
├── index.html                                    # Main Dashboard (Entry Point)
├── css/
│   └── styles.css                               # Global Styles
├── js/
│   └── navigation.js                            # Navigation Configuration
├── modules/
│   ├── asset-central/                           # Module 1: Asset Central (Foundation)
│   │   ├── Asset-Central-Hub.html               # Main Hub with tabs
│   │   ├── Asset-Detail.html                    # Asset Detail View
│   │   ├── Work-Order-Hub.html                 # Work Order Listing
│   │   ├── Vendor-Hub.html                      # Vendor Management
│   │   ├── Spare-Part-Hub.html                 # Spare Parts Inventory
│   │   ├── Organization-Hub.html               # Organization Hierarchy
│   │   ├── Service-Contract-Hub.html            # Service Contracts
│   │   ├── Insurance-Hub.html                  # Insurance Policies
│   │   └── Disposal-Hub.html                    # Disposal Records
│   ├── 2-asset-registration/
│   │   ├── Asset-Registration-Overview.html     # Module Overview (NEW)
│   │   └── F-2.1.*.html                         # Feature Pages (15)
│   ├── 3-asset-tracking/
│   │   ├── Asset-Tracking-Overview.html         # Module Overview (NEW)
│   │   └── F-2.2.*.html                         # Feature Pages (10)
│   ├── 4-maintenance/
│   │   ├── Maintenance-Overview.html            # Module Overview (NEW)
│   │   └── F-2.3.*.html                         # Feature Pages (17)
│   ├── 5-financial/
│   │   ├── Financial-Overview.html              # Module Overview (NEW)
│   │   └── F-2.4.*.html                         # Feature Pages (14)
│   ├── 6-multi-plant/
│   │   ├── Multi-Plant-Overview.html            # Module Overview (NEW)
│   │   └── F-2.5.*.html                         # Feature Pages (8)
│   ├── 7-lifecycle/
│   │   ├── Lifecycle-Overview.html              # Module Overview (NEW)
│   │   └── F-2.6.*.html                         # Feature Pages (18)
│   ├── 8-utilization/
│   │   ├── Utilization-Overview.html            # Module Overview (NEW)
│   │   └── F-2.7.*.html                         # Feature Pages (18)
│   └── 9-multi-company/
│       ├── Multi-Company-Overview.html         # Module Overview (NEW)
│       └── F-2.8.*.html                         # Feature Pages (22)
```

**Total UI Mockup Files:** 136 (1 index + 1 styles + 1 nav + 133 module pages)

---

## 13. Compliance Framework Mapping

### ISO 55000 (Asset Management)

All 127 requirements align with ISO 55000 principles for asset management.

### US GAAP / IFRS (Financial Reporting)

| Module | Requirements | Compliance Aspect |
|--------|-------------|-------------------|
| 5 | F-2.4.1, F-2.4.2, F-2.4.6, F-2.4.10, F-2.4.11 | Multi-currency, depreciation, tax compliance, lease accounting |
| 7 | F-2.6.15 | Lease Return and Purchase Options |
| 9 | F-2.8.4, F-2.8.6 | Consolidated reporting, inter-company leasing |

### SOX (Sarbanes-Oxley)

| Module | Requirements |
|--------|--------------|
| 8 | F-2.7.2, F-2.7.9, F-2.7.10, F-2.7.17 |
| 9 | F-2.8.1, F-2.8.3, F-2.8.4, F-2.8.11, F-2.8.12, F-2.8.19, F-2.8.20, F-2.8.21, F-2.8.22 |

### GDPR (Data Privacy)

| Module | Requirements |
|--------|--------------|
| 7 | F-2.6.14 |
| 8 | F-2.7.1, F-2.7.2, F-2.7.3, F-2.7.4, F-2.7.5 |
| 9 | F-2.8.1, F-2.8.2, F-2.8.3, F-2.8.4, F-2.8.12, F-2.8.14, F-2.8.19, F-2.8.20, F-2.8.22 |

### EPA / WEEE (Environmental)

| Module | Requirements | Compliance Aspect |
|--------|-------------|-------------------|
| 7 | F-2.6.11, F-2.6.17 | EPA/RCRA, WEEE compliance |
| 8 | F-2.7.2, F-2.7.8, F-2.7.18 | EPA compliance |

---

## 14. Module Overview Page Template

Each Module Overview page (e.g., `Asset-Registration-Overview.html`) follows a consistent tabbed dashboard design:

### Tab Structure
- **Overview** - Key stats, progress indicators, module capabilities summary
- **Quick Actions** - Common tasks with direct links to feature pages
- **Core Features** - Primary functional requirements (first 6-8)
- **Advanced** - Secondary/advanced features (remaining requirements)

### Common Elements
- Module hero section with key metrics
- Stats cards (Total, Active, Pending, etc.)
- Feature cards with icons, descriptions, and links
- Quick action buttons

---

## 15. Verification Status

| Module | Overview Page | Requirements Count | Status |
|--------|--------------|-------------------|--------|
| 1 | `Asset-Central-Hub.html` | 9 | ✓ Complete |
| 2 | `Asset-Registration-Overview.html` | 15 | ✓ Complete |
| 3 | `Asset-Tracking-Overview.html` | 10 | ✓ Complete |
| 4 | `Maintenance-Overview.html` | 17 | ✓ Complete |
| 5 | `Financial-Overview.html` | 14 | ✓ Complete |
| 6 | `Multi-Plant-Overview.html` | 8 | ✓ Complete |
| 7 | `Lifecycle-Overview.html` | 18 | ✓ Complete |
| 8 | `Utilization-Overview.html` | 18 | ✓ Complete |
| 9 | `Multi-Company-Overview.html` | 19 | ✓ Complete |

---

*Document updated: 2026-04-08*
*Mockup version: 2.0*
*Total pages: 136 files*
