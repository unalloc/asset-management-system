# Asset-Centric Navigation Map

## Overview

This document describes how all functional modules are connected through the Asset Detail page, creating a unified asset management experience.

---

## Entry Point: Asset Central Hub

**File:** `mockup/modules/asset-central/Asset-Central-Hub.html`

The Asset Central Hub is the primary entry point for all asset operations:

```
┌─────────────────────────────────────────────────────────────────┐
│  Asset Central Hub                                              │
│  ├── Global Search (by ID, name, serial, location)             │
│  ├── Statistics Dashboard (Total, Active, Idle, Value)           │
│  ├── Filters (Type, Status, Plant, Department)                  │
│  └── Asset List Table ────────→ Click row → Asset Detail        │
└─────────────────────────────────────────────────────────────────┘
```

---

## Asset Detail Page - The Hub

**File:** `mockup/modules/asset-central/Asset-Detail.html`

The Asset Detail page is the central navigation hub with 7 tabs:

### Tab 1: Overview
Quick summary and actions for the selected asset.

**Quick Actions → Linked Modules:**
| Action | Target Module | File |
|--------|--------------|------|
| Create Work Order | Maintenance Planning | `4-maintenance/F-2.3.1-Scheduled Maintenance Planning.html` |
| Record Inspection | Check-in/Check-out | `3-asset-tracking/F-2.2.2-Check-in-Check-out System.html` |
| Borrow / Return | Borrowing-Return System | `7-lifecycle/F-2.6.5-Borrowing-Return System.html` |
| Reserve Asset | Reservation System | `8-utilization/F-2.7.3-Asset Reservation System.html` |
| View Contracts | Service Contracts | `4-maintenance/F-2.3.4-Service Contract Management.html` |
| Dispose Asset | Disposal Workflow | `7-lifecycle/F-2.6.9-Asset Disposal Workflow.html` |
| View IoT Data | IoT Integration | `3-asset-tracking/F-2.2.6-IoT Sensor Integration.html` |
| Calibration | Calibration Mgmt | `3-asset-tracking/F-2.2.12-Calibration Management.html` |
| Print Label | Barcode/QR | `2-asset-registration/F-2.1.4-Barcode-QR Code Generation.html` |

**Header Actions:**
| Action | Target Module | File |
|--------|--------------|------|
| Edit Asset | Register New Asset | `2-asset-registration/F-2.1.0-Register New Asset.html` |
| Transfer | Cross-Factory Transfer | `6-multi-plant/F-2.5.5-Cross-Factory Asset Transfer.html` |

---

### Tab 2: Maintenance

**Sub-tabs:**
- Work Orders (5)
- Preventive Schedule → `4-maintenance/F-2.3.2-Preventive Maintenance Workflow.html`
- Predictive Data → `4-maintenance/F-2.3.7-Predictive Maintenance (IoT).html`
- Spare Parts → `4-maintenance/F-2.3.5-Spare Parts Inventory Linkage.html`

**Linked Modules:**
| Info | Linked Module | File |
|------|--------------|------|
| Work Order List | Scheduled Maintenance Planning | `4-maintenance/F-2.3.1-Scheduled Maintenance Planning.html` |
| Maintenance History | Maintenance History Tracking | `4-maintenance/F-2.3.3-Maintenance History Tracking.html` |
| Spare Parts | Spare Parts Inventory | `4-maintenance/F-2.3.5-Spare Parts Inventory Linkage.html` |
| Service Contracts | Service Contract Mgmt | `4-maintenance/F-2.3.4-Service Contract Management.html` |
| Vendor Management | Vendor Management | `4-maintenance/F-2.3.6-Vendor Management.html` |
| RCM Strategies | RCM Strategies | `4-maintenance/F-2.3.8-RCM Strategies.html` |
| Maintenance KPIs | Maintenance KPIs | `4-maintenance/F-2.3.9-Maintenance KPIs.html` |
| Root Cause Analysis | Root Cause Analysis | `4-maintenance/F-2.3.17-Root Cause Analysis.html` |
| Maintenance Calendar | Calendar View | `4-maintenance/F-2.3.18-Maintenance Calendar View.html` |

---

### Tab 3: Financial

**Info Cards:**
- Original Cost, Book Value, Depreciation, Residual Value

**Linked Modules:**
| Info | Linked Module | File |
|------|--------------|------|
| Depreciation Schedule | Automated Depreciation | `5-financial/F-2.4.2-Automated Depreciation.html` |
| Insurance Info | Insurance Tracking | `5-financial/F-2.4.3-Insurance Tracking.html` |
| TCO Analysis | TCO Analysis | `5-financial/F-2.4.4-TCO Analysis.html` |
| Budget vs Actual | Budget vs Actual | `5-financial/F-2.4.5-Budget vs Actual.html` |
| Tax Compliance | Tax Compliance Reporting | `5-financial/F-2.4.6-Tax Compliance Reporting.html` |
| Lease Accounting | Lease Accounting | `5-financial/F-2.4.10-Lease Accounting.html` |
| Replacement Planning | Replacement Planning | `5-financial/F-2.4.12-Replacement Planning.html` |
| Asset Reclassification | Asset Reclassification | `5-financial/F-2.4.9-Asset Reclassification.html` |

---

### Tab 4: Documents

**Info:** Certificate of Origin, Warranty Certificate

**Linked Modules:**
| Action | Linked Module | File |
|--------|--------------|------|
| Upload Document | Document Attachment | `2-asset-registration/F-2.1.7-Document Attachment.html` |
| View All Documents | Document Attachment | `2-asset-registration/F-2.1.7-Document Attachment.html` |

---

### Tab 5: History

**Info:** Complete audit trail of all changes

**Linked Modules:**
| Info | Linked Module | File |
|------|--------------|------|
| Audit Trail | Audit Trail | `3-asset-tracking/F-2.2.4-Audit Trail.html` |
| Asset Lifecycle | Lifecycle Cost Tracking | `7-lifecycle/F-2.6.16-Lifecycle Cost Tracking.html` |

---

### Tab 6: Hierarchy

**Info:** Parent-child relationships

**Linked Modules:**
| Info | Linked Module | File |
|------|--------------|------|
| View Components | Asset Componentization | `2-asset-registration/F-2.1.12-Asset Componentization.html` |
| Edit Hierarchy | Asset Hierarchy | `2-asset-registration/F-2.1.6-Asset Hierarchy.html` |
| Parent Asset | Equipment Hierarchy | `2-asset-registration/F-2.1.9-Equipment Hierarchy.html` |

---

### Tab 7: Tracking

**Sub-tabs:**
- Location & Status
- RFID & Barcode → `2-asset-registration/F-2.1.5-RFID Tag Integration.html`
- IoT Sensors → `3-asset-tracking/F-2.2.6-IoT Sensor Integration.html`
- Transfer History

**Linked Modules:**
| Info | Linked Module | File |
|------|--------------|------|
| Real-time Location | Real-time Location Tracking | `3-asset-tracking/F-2.2.1-Real-time Location Tracking.html` |
| Check-in/out | Check-in-Check-out System | `3-asset-tracking/F-2.2.2-Check-in-Check-out System.html` |
| Transfer | Transfer Management | `3-asset-tracking/F-2.2.3-Transfer Management.html` |
| RFID Tags | RFID Tag Integration | `2-asset-registration/F-2.1.5-RFID Tag Integration.html` |
| Barcode/QR | Barcode-QR Code Generation | `2-asset-registration/F-2.1.4-Barcode-QR Code Generation.html` |
| IoT Sensors | IoT Sensor Integration | `3-asset-tracking/F-2.2.6-IoT Sensor Integration.html` |
| Mobile Verification | Mobile Asset Verification | `3-asset-tracking/F-2.2.5-Mobile Asset Verification.html` |
| GIS Mapping | GIS Geographic Integration | `3-asset-tracking/F-2.2.15-GIS Geographic Integration.html` |
| Calibration | Calibration Management | `3-asset-tracking/F-2.2.12-Calibration Management.html` |
| Safety Compliance | Safety Compliance | `3-asset-tracking/F-2.2.13-Safety Compliance.html` |
| Physical Inventory | Physical Inventory Counting | `7-lifecycle/F-2.6.7-Physical Inventory Counting.html` |
| Cycle Counting | Cycle Counting Plan | `7-lifecycle/F-2.6.8-Cycle Counting Plan.html` |

---

## Module-to-Asset Linkage Summary

### Module 2: Asset Registration
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.1.0 Register New Asset | Edit button |
| F-2.1.1 Multiple Asset Types | Basic Info section |
| F-2.1.4 Barcode/QR Code | Tracking tab → RFID & Barcode sub-tab |
| F-2.1.5 RFID Tag Integration | Tracking tab → RFID & Barcode sub-tab |
| F-2.1.6 Asset Hierarchy | Hierarchy tab |
| F-2.1.7 Document Attachment | Documents tab |
| F-2.1.12 Asset Componentization | Hierarchy tab |

### Module 3: Asset Tracking
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.2.1 Real-time Location | Tracking tab |
| F-2.2.2 Check-in-Check-out | Quick Actions + Tracking tab |
| F-2.2.3 Transfer Management | Tracking tab |
| F-2.2.4 Audit Trail | History tab |
| F-2.2.5 Mobile Verification | Tracking tab |
| F-2.2.6 IoT Integration | Tracking tab → IoT sub-tab |
| F-2.2.12 Calibration Mgmt | Quick Actions + Tracking tab |
| F-2.2.13 Safety Compliance | Tracking tab |
| F-2.2.15 GIS Integration | Tracking tab |

### Module 4: Maintenance
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.3.1 Scheduled Maintenance | Quick Actions + Maintenance tab |
| F-2.3.2 Preventive Workflow | Maintenance tab → Preventive sub-tab |
| F-2.3.3 Maintenance History | Maintenance tab |
| F-2.3.4 Service Contracts | Quick Actions + Maintenance tab |
| F-2.3.5 Spare Parts | Maintenance tab → Spare Parts sub-tab |
| F-2.3.6 Vendor Management | Maintenance tab |
| F-2.3.7 Predictive Maintenance | Maintenance tab → Predictive sub-tab |
| F-2.3.8 RCM Strategies | Maintenance tab |
| F-2.3.9 Maintenance KPIs | Maintenance tab |
| F-2.3.17 Root Cause Analysis | Maintenance tab |
| F-2.3.18 Calendar View | Maintenance tab |

### Module 5: Financial
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.4.2 Automated Depreciation | Financial tab |
| F-2.4.3 Insurance Tracking | Financial tab |
| F-2.4.4 TCO Analysis | Financial tab |
| F-2.4.5 Budget vs Actual | Financial tab |
| F-2.4.6 Tax Compliance | Financial tab |
| F-2.4.7 Capital Projects | Financial tab |
| F-2.4.9 Asset Reclassification | Financial tab |
| F-2.4.10 Lease Accounting | Financial tab |
| F-2.4.12 Replacement Planning | Financial tab |
| F-2.4.13 Residual Value Tracking | Financial tab |
| F-2.4.14 Insurance Valuation | Financial tab |

### Module 6: Multi-Plant
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.5.5 Cross-Factory Transfer | Transfer button |
| F-2.5.6 Centralized Contracts | Maintenance tab |
| F-2.5.7 Manufacturing Standards | Compliance section |

### Module 7: Lifecycle
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.6.5 Borrowing-Return | Quick Actions + Tracking tab |
| F-2.6.7 Physical Inventory | Tracking tab |
| F-2.6.8 Cycle Counting | Tracking tab |
| F-2.6.9 Disposal Workflow | Quick Actions |
| F-2.6.16 Lifecycle Cost Tracking | History tab |
| F-2.6.17 Environmental Disposal | Disposal section |

### Module 8: Utilization
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.7.3 Asset Reservation | Quick Actions |
| F-2.7.4 Real-time Availability | Tracking tab |
| F-2.7.8 Idle Asset Identification | Overview section |
| F-2.7.9 Usage Cost Allocation | Financial tab |
| F-2.7.11 Usage Performance | Overview section |
| F-2.7.14 Usage History | Overview section |
| F-2.7.17 Critical Asset Emergency | Quick Actions |

### Module 9: Multi-Company
| Requirement | Asset Detail Link |
|-------------|------------------|
| F-2.8.20 Data Hierarchy | All tabs (access control) |
| F-2.8.21 Audit Compliance | History tab |
| F-2.8.22 Data Security | All tabs |

---

## Navigation Flow Diagram

```
Asset Central Hub
    │
    ├── [Search/Filter] → Filtered Asset List
    │
    └── [Click Asset Row] → Asset Detail Page
                              │
                              ├── Tab: Overview
                              │     └── [Quick Actions] ──→ All Modules
                              │
                              ├── Tab: Maintenance
                              │     ├── Work Orders ──→ F-2.3.1
                              │     ├── Preventive ────→ F-2.3.2
                              │     ├── Predictive ────→ F-2.3.7
                              │     └── Spare Parts ───→ F-2.3.5
                              │
                              ├── Tab: Financial
                              │     ├── Depreciation ──→ F-2.4.2
                              │     ├── Insurance ──────→ F-2.4.3
                              │     └── TCO ───────────→ F-2.4.4
                              │
                              ├── Tab: Documents
                              │     └── [Documents] ────→ F-2.1.7
                              │
                              ├── Tab: History
                              │     └── [Audit Trail] ──→ F-2.2.4
                              │
                              ├── Tab: Hierarchy
                              │     ├── Components ─────→ F-2.1.12
                              │     └── Parent ─────────→ F-2.1.6
                              │
                              └── Tab: Tracking
                                    ├── RFID ────────────→ F-2.1.5
                                    ├── Barcode ──────────→ F-2.1.4
                                    ├── IoT ──────────────→ F-2.2.6
                                    └── Transfer ─────────→ F-2.2.3
```

---

## How to Use This Map

1. **Starting Point:** Open `Asset-Central-Hub.html`
2. **Search for Asset:** Use global search or filters
3. **View Asset Detail:** Click any asset row
4. **Navigate to Function:** Use tabs and quick actions to access any module
5. **Return to Hub:** Use breadcrumb or sidebar navigation

---

## File Locations

| File | Path |
|------|------|
| Asset Central Hub | `mockup/modules/asset-central/Asset-Central-Hub.html` |
| Asset Detail | `mockup/modules/asset-central/Asset-Detail.html` |
| CSS | `mockup/css/styles.css` |
| Navigation JS | `mockup/js/navigation.js` |
