# Module Pages Asset Linkage Guide

## Overview

Each module page should be traceable to the asset it serves. This guide describes the patterns to follow when updating mockup pages.

---

## Pattern 1: Asset Context in Breadcrumb

Add this element to the breadcrumbs section to show when a page is opened with `?asset=XXX`:

```html
<span id="asset-context" style="display:none;"> / <a href="#" id="asset-context-link">AST-001</a></span>
```

**Example:**
```html
<div class="breadcrumbs">
    <a href="../../asset-central/Asset-Central-Hub.html">Asset Central</a>
    <span id="asset-context" style="display:none;"> / <a href="#" id="asset-context-link">AST-001</a></span>
    <span> / F-2.3.1</span>
</div>
```

**JavaScript:** The `initAssetContext()` function in navigation.js automatically handles showing this when `?asset=XXX` is present.

---

## Pattern 2: Asset Context Banner

For pages that work heavily with a specific asset, add an asset context banner at the top:

```html
<div id="asset-context-banner" class="asset-context-banner" style="display:none;">
    <div class="asset-info">
        <div class="asset-icon">🏭</div>
        <div>
            <h3>CNC Machine Model-X</h3>
            <p>Asset ID: <span id="banner-asset-id">AST-001</span> | Active | Plant A</p>
        </div>
    </div>
    <a href="../../asset-central/Asset-Detail.html?asset=AST-001" 
       id="banner-asset-link" class="btn">View Full Asset Details →</a>
</div>
```

---

## Pattern 3: Asset Links in Tables

When showing assets in tables, make the asset name/ID clickable:

**Before:**
```html
<td>CNC Machine #1 (AST-2024-001)</td>
```

**After:**
```html
<td>
    <a href="../../asset-central/Asset-Detail.html?asset=AST-2024-001" class="asset-link">CNC Machine #1</a>
    <span class="text-muted">(AST-2024-001)</span>
</td>
```

**CSS Class:** Use `.asset-link` class for styling.

---

## Pattern 4: View Asset Button

In table action columns, add a "View Asset" button:

```html
<td class="table-actions">
    <a href="../../asset-central/Asset-Detail.html?asset=AST-001" class="btn btn-sm btn-outline">View Asset</a>
    <button class="btn btn-sm btn-outline">Edit</button>
</td>
```

---

## Pattern 5: Sidebar Navigation

Add "Asset Central" link to the Foundation section:

```html
<li class="nav-section">
    <span class="nav-section-title">Foundation</span>
    <ul>
        <li><a href="../../index.html">Overview</a></li>
        <li><a href="../../asset-central/Asset-Central-Hub.html">Asset Central</a></li>
    </ul>
</li>
```

---

## Module-by-Module Update Checklist

### Module 2: Asset Registration
| File | Asset Links Needed |
|------|-------------------|
| F-2.1.0 | Already Asset-centric |
| F-2.1.1 | Table: Asset Types |
| F-2.1.2 | Table: Custom Categories |
| F-2.1.3 | Table: Import/Export Jobs |
| F-2.1.4 | Table: Barcode Assignments |
| F-2.1.5 | Table: RFID Tag Assignments |
| F-2.1.6 | Tree: Asset Hierarchy |
| F-2.1.7 | Table: Document Attachments |
| F-2.1.8 | Table: Manufacturing Types |
| F-2.1.9 | Tree: Equipment Hierarchy |
| F-2.1.10 | Table: Tooling Items |
| F-2.1.11 | Table: Multi-Plant Registry |
| F-2.1.12 | Table: Components, Parent Link |
| F-2.1.13 | Table: Criticality Classifications |
| F-2.1.14 | Table: API Integrations |
| F-2.1.15 | Table: Employee Assignments |

### Module 3: Asset Tracking
| File | Asset Links Needed |
|------|-------------------|
| F-2.2.1 | Table: Location Updates |
| F-2.2.2 | Table: Check-in/out Records |
| F-2.2.3 | Table: Transfer Records |
| F-2.2.4 | Table: Audit Log Entries |
| F-2.2.5 | Table: Verification Records |
| F-2.2.6 | Table: IoT Sensors |
| F-2.2.11 | Table: Inter-Plant Transfers |
| F-2.2.12 | Table: Calibration Records |
| F-2.2.13 | Table: Safety Checks |
| F-2.2.15 | Table: GIS Locations |

### Module 4: Maintenance
| File | Asset Links Needed |
|------|-------------------|
| F-2.3.1 | Table: Maintenance Schedules |
| F-2.3.2 | Table: PM Workflows |
| F-2.3.3 | Table: Maintenance History |
| F-2.3.4 | Table: Service Contracts |
| F-2.3.5 | Table: Spare Parts Linkage |
| F-2.3.6 | Table: Vendors |
| F-2.3.7 | Table: Predictive Data |
| F-2.3.8 | Table: RCM Strategies |
| F-2.3.9 | Table: Maintenance KPIs |
| F-2.3.10 | Table: Spare Parts Criticality |
| F-2.3.11 | Table: Work Order Prioritization |
| F-2.3.12 | Table: Maintenance Backlog |
| F-2.3.13 | Table: Calibration Schedules |
| F-2.3.15 | Table: Workforce Assignments |
| F-2.3.16 | Table: Notifications |
| F-2.3.17 | Table: RCA Records |
| F-2.3.18 | Table: Calendar Events |

### Module 5: Financial
| File | Asset Links Needed |
|------|-------------------|
| F-2.4.1 | Already Asset-centric |
| F-2.4.2 | Already Asset-centric |
| F-2.4.3 | Table: Insurance Policies |
| F-2.4.4 | Already Asset-centric |
| F-2.4.5 | Table: Budget Items |
| F-2.4.6 | Table: Tax Reports |
| F-2.4.7 | Table: Capital Projects |
| F-2.4.8 | Table: Component Financials |
| F-2.4.9 | Table: Reclassification Records |
| F-2.4.10 | Table: Lease Agreements |
| F-2.4.11 | Table: Tax Depreciation |
| F-2.4.12 | Table: Replacement Plans |
| F-2.4.13 | Table: Residual Values |
| F-2.4.14 | Table: Insurance Valuations |

### Module 6: Multi-Plant
| File | Asset Links Needed |
|------|-------------------|
| F-2.5.1 | Tree: Factory Structure |
| F-2.5.2 | Table: Plant Configs |
| F-2.5.3 | Table: Consolidated Reports |
| F-2.5.4 | Table: Classifications |
| F-2.5.5 | Table: Cross-Factory Transfers |
| F-2.5.6 | Table: Contracts |
| F-2.5.7 | Table: Compliance Records |
| F-2.5.10 | Table: Audit Records |

### Module 7: Lifecycle
| File | Asset Links Needed |
|------|-------------------|
| F-2.6.1 | Table: Procurement Records |
| F-2.6.2 | Table: Receiving Records |
| F-2.6.3 | Table: Capitalization Records |
| F-2.6.4 | Table: Deployment Records |
| F-2.6.5 | Table: Borrowing Records |
| F-2.6.6 | Table: Temporary Borrowing |
| F-2.6.7 | Table: Inventory Counts |
| F-2.6.8 | Table: Cycle Counts |
| F-2.6.9 | Table: Disposal Records |
| F-2.6.10 | Table: Disposal Approvals |
| F-2.6.11 | Table: Disassembly Records |
| F-2.6.12 | Table: Retirement Plans |
| F-2.6.13 | Table: Refurbishment Records |
| F-2.6.14 | Table: Warranty Claims |
| F-2.6.15 | Table: Lease Returns |
| F-2.6.16 | Table: Lifecycle Costs |
| F-2.6.17 | Table: Environmental Compliance |
| F-2.6.18 | Table: Residual Realization |

### Module 8: Utilization
| File | Asset Links Needed |
|------|-------------------|
| F-2.7.1 | Table: Allocation Plans |
| F-2.7.2 | Table: Usage Requests |
| F-2.7.3 | Table: Reservations |
| F-2.7.4 | Table: Availability |
| F-2.7.5 | Table: Usage Contracts |
| F-2.7.6 | Table: Utilization Calc |
| F-2.7.8 | Table: Idle Assets |
| F-2.7.9 | Table: Cost Allocation |
| F-2.7.10 | Table: Dept/Project Costs |
| F-2.7.11 | Table: Performance Eval |
| F-2.7.12 | Table: Shift Schedules |
| F-2.7.13 | Table: Asset Pool |
| F-2.7.14 | Table: Usage History |
| F-2.7.15 | Table: Utilization Predictions |
| F-2.7.16 | Table: Load Balancing |
| F-2.7.17 | Table: Emergency Events |
| F-2.7.18 | Table: Compliance Monitoring |

### Module 9: Multi-Company
| File | Asset Links Needed |
|------|-------------------|
| F-2.8.1 | Tree: Org Hierarchy |
| F-2.8.2 | Table: Legal Entities |
| F-2.8.3 | Table: Data Isolation |
| F-2.8.4 | Table: Consolidated Reports |
| F-2.8.5 | Table: Cross-Company Transfers |
| F-2.8.6 | Table: Inter-Company Leases |
| F-2.8.7 | Table: Policy Templates |
| F-2.8.8 | Table: Procurement |
| F-2.8.9 | Table: Standardization |
| F-2.8.10 | Table: Company Configs |
| F-2.8.11 | Table: Cost Allocation |
| F-2.8.12 | Table: Audit Tracking |
| F-2.8.13 | Table: Company Types |
| F-2.8.14 | Table: Benchmarking |
| F-2.8.15 | Table: Asset Optimization |
| F-2.8.19 | Table: Dashboard Widgets |
| F-2.8.20 | Table: Access Control |
| F-2.8.21 | Table: Compliance Framework |
| F-2.8.22 | Table: Security Settings |

---

## Summary

For each module page, ensure:

1. ✅ Sidebar has "Asset Central" link
2. ✅ Breadcrumb has asset context element
3. ✅ Tables have clickable asset names/IDs
4. ✅ Action columns have "View Asset" buttons
5. ✅ When opened with `?asset=XXX`, context is shown
