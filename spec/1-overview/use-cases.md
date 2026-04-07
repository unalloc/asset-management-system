# Use Cases

## Overview

This document summarizes the key use cases for the Asset Management System, organized by user role and business process.

---

## Use Case Diagram

```
                              ┌─────────────────────────────────────────┐
                              │     ASSET MANAGEMENT SYSTEM              │
                              └─────────────────────────────────────────┘
                                              │
        ┌───────────────┬───────────────┬───────────────┬───────────────┐
        │               │               │               │               │
        ▼               ▼               ▼               ▼               ▼
┌───────────────┐ ┌───────────────┐ ┌───────────────┐ ┌───────────────┐ ┌───────────────┐
│  Asset        │ │  Finance      │ │ Maintenance   │ │  Operations   │ │  Compliance    │
│  Managers     │ │  Team         │ │  Team         │ │  Team         │ │  Officers      │
└───────┬───────┘ └───────┬───────┘ └───────┬───────┘ └───────┬───────┘ └───────┬───────┘
        │                 │                 │                 │                 │
        │                 │                 │                 │                 │
        ▼                 ▼                 ▼                 ▼                 ▼
   ┌─────────┐       ┌─────────┐       ┌─────────┐       ┌─────────┐       ┌─────────┐
   │ Register│       │ Track   │       │ Schedule│       │ Monitor │       │ Run     │
   │ Assets  │       │ Costs   │       │ Maint.  │       │ Assets  │       │ Reports  │
   └─────────┘       └─────────┘       └─────────┘       └─────────┘       └─────────┘
```

---

## 1. Asset Manager Use Cases

### UC-AM-001: Register New Asset
**Actor:** Asset Manager  
**Description:** Register a new asset into the system with all required information.

**Preconditions:**
- User is authenticated as Asset Manager
- Asset has been received and verified

**Flow:**
1. Select "Register New Asset"
2. Enter asset information (type, description, serial number)
3. Assign asset to location and custodian
4. Set financial information (cost, depreciation method)
5. Attach supporting documents
6. Generate barcode/QR code
7. Submit for approval

**Postconditions:**
- Asset is registered with unique ID
- Audit log entry created
- Notification sent to relevant parties

---

### UC-AM-002: Transfer Asset Between Locations
**Actor:** Asset Manager  
**Description:** Transfer an asset from one location to another.

**Preconditions:**
- Asset exists in system
- User has transfer permission

**Flow:**
1. Select asset to transfer
2. Request transfer with justification
3. Obtain approval from source and destination
4. Update asset location
5. Generate transfer document

**Postconditions:**
- Asset location updated
- Transfer history recorded
- Notifications sent

---

### UC-AM-003: Retire Asset
**Actor:** Asset Manager  
**Description:** Remove asset from active inventory through disposal process.

**Preconditions:**
- Asset is no longer in use
- Disposal approval obtained

**Flow:**
1. Identify asset for retirement
2. Submit disposal request with reason
3. Obtain required approvals
4. Execute disposal (sale, recycle, scrap)
5. Update financial records
6. Archive asset record

**Postconditions:**
- Asset marked as disposed
- Financial gain/loss calculated
- Disposal record created

---

### UC-AM-004: Manage Asset Hierarchy
**Actor:** Asset Manager  
**Description:** Create and maintain asset hierarchical structure.

**Preconditions:**
- User has hierarchy management permission

**Flow:**
1. View current hierarchy
2. Add new hierarchy levels
3. Reassign assets to new parent
4. Validate hierarchy integrity

**Postconditions:**
- Hierarchy updated
- Child-parent relationships maintained

---

## 2. Finance Team Use Cases

### UC-FN-001: Calculate Depreciation
**Actor:** Financial Analyst  
**Description:** Run depreciation calculation for all assets.

**Preconditions:**
- Depreciation parameters configured
- Period is open for depreciation

**Flow:**
1. Open depreciation calculation workspace
2. Select calculation period
3. Review affected assets
4. Execute depreciation calculation
5. Review calculated amounts
6. Post to financial system

**Postconditions:**
- Depreciation calculated for all eligible assets
- Journal entries generated
- Reports updated

---

### UC-FN-002: Track Asset Costs
**Actor:** Accountant  
**Description:** Monitor and track all costs associated with assets.

**Preconditions:**
- Assets are registered with financial data

**Flow:**
1. View asset cost summary
2. Analyze cost by category, location, type
3. Compare budget vs actual
4. Generate cost allocation charges
5. Export cost reports

**Postconditions:**
- Cost tracking reports available
- Allocations posted

---

### UC-FN-003: Manage Insurance Coverage
**Actor:** Insurance Specialist  
**Description:** Track insurance policies and coverage for assets.

**Preconditions:**
- Insurance module configured

**Flow:**
1. Add new insurance policy
2. Assign assets to policy
3. Track coverage limits
4. Record premium payments
5. Process claims when needed

**Postconditions:**
- Insurance records current
- Coverage gaps identified

---

## 3. Maintenance Team Use Cases

### UC-MT-001: Schedule Preventive Maintenance
**Actor:** Maintenance Manager  
**Description:** Create and manage preventive maintenance schedules.

**Preconditions:**
- Assets have maintenance plans defined

**Flow:**
1. View upcoming maintenance schedule
2. Select assets for scheduling
3. Assign technicians
4. Reserve required parts
5. Generate work orders
6. Send notifications

**Postconditions:**
- Work orders created
- Schedule updated
- Resources allocated

---

### UC-MT-002: Execute Work Order
**Actor:** Technician  
**Description:** Complete assigned maintenance work order.

**Preconditions:**
- Work order is assigned to technician

**Flow:**
1. Receive work order assignment
2. Review work order details
3. Gather tools and parts
4. Perform maintenance work
5. Record work performed
6. Document parts used
7. Close work order

**Postconditions:**
- Work completed and documented
- Asset history updated
- Parts inventory updated

---

### UC-MT-003: Handle Emergency Repair
**Actor:** Technician  
**Description:** Respond to emergency asset failure.

**Preconditions:**
- Emergency work order created

**Flow:**
1. Receive emergency notification
2. Diagnose issue
3. Perform temporary repair
4. Request parts if needed
5. Complete permanent repair
6. Document root cause
7. Close emergency work order

**Postconditions:**
- Asset restored to operational
- Emergency response documented
- Lessons learned captured

---

## 4. Operations Team Use Cases

### UC-OP-001: Track Asset Utilization
**Actor:** Operations Manager  
**Description:** Monitor how assets are being used across operations.

**Preconditions:**
- Assets are checked out or allocated

**Flow:**
1. View asset utilization dashboard
2. Identify underutilized assets
3. Analyze utilization trends
4. Generate utilization reports
5. Recommend reallocation

**Postconditions:**
- Utilization data available
- Optimization opportunities identified

---

### UC-OP-002: Manage Shift Scheduling
**Actor:** Plant Manager  
**Description:** Coordinate equipment scheduling across shifts.

**Preconditions:**
- Shift schedules configured
- Assets support shift scheduling

**Flow:**
1. View current schedule
2. Identify scheduling conflicts
3. Adjust equipment assignments
4. Balance workload across shifts
5. Confirm schedule changes

**Postconditions:**
- Schedule updated
- Conflicts resolved

---

## 5. Compliance Officer Use Cases

### UC-CO-001: Run Compliance Report
**Actor:** Compliance Officer  
**Description:** Generate compliance status reports for audits.

**Preconditions:**
- Compliance data is current

**Flow:**
1. Select compliance report type
2. Define report parameters (date range, scope)
3. Execute report generation
4. Review findings
5. Address compliance gaps
6. Export report for auditors

**Postconditions:**
- Compliance report available
- Audit trail created

---

### UC-CO-002: Manage Audit Trail
**Actor:** Compliance Officer  
**Description:** Review and export system audit logs.

**Preconditions:**
- User has audit view permission

**Flow:**
1. Access audit log viewer
2. Define search criteria
3. Review audit entries
4. Investigate anomalies
5. Export audit evidence

**Postconditions:**
- Audit review documented
- Findings addressed

---

## 6. Executive Use Cases

### UC-EX-001: View Executive Dashboard
**Actor:** Executive  
**Description:** Access consolidated view of asset performance.

**Preconditions:**
- User has executive dashboard access

**Flow:**
1. Open executive dashboard
2. View key performance indicators
3. Drill down into details
4. Compare across entities
5. Export reports

**Postconditions:**
- Performance visibility achieved

---

### UC-EX-002: Review Asset Portfolio
**Actor:** Executive  
**Description:** Review organization's complete asset portfolio.

**Preconditions:**
- User has read access to portfolio data

**Flow:**
1. Access portfolio summary
2. View asset distribution
3. Analyze asset value trends
4. Review key metrics
5. Generate strategic reports

**Postconditions:**
- Portfolio analysis available

---

## Use Case Summary Table

| ID | Use Case | Actor | Module | Priority |
|----|----------|-------|--------|----------|
| UC-AM-001 | Register New Asset | Asset Manager | Registration | High |
| UC-AM-002 | Transfer Asset | Asset Manager | Tracking | High |
| UC-AM-003 | Retire Asset | Asset Manager | Lifecycle | High |
| UC-AM-004 | Manage Hierarchy | Asset Manager | Registration | Medium |
| UC-FN-001 | Calculate Depreciation | Financial Analyst | Financial | High |
| UC-FN-002 | Track Costs | Accountant | Financial | High |
| UC-FN-003 | Manage Insurance | Insurance Specialist | Financial | Medium |
| UC-MT-001 | Schedule Preventive Maint. | Maintenance Manager | Maintenance | High |
| UC-MT-002 | Execute Work Order | Technician | Maintenance | High |
| UC-MT-003 | Handle Emergency | Technician | Maintenance | Critical |
| UC-OP-001 | Track Utilization | Operations Manager | Utilization | Medium |
| UC-OP-002 | Manage Scheduling | Plant Manager | Utilization | Medium |
| UC-CO-001 | Run Compliance Report | Compliance Officer | Multi-Company | High |
| UC-CO-002 | Manage Audit Trail | Compliance Officer | Multi-Company | High |
| UC-EX-001 | View Dashboard | Executive | Reporting | High |
| UC-EX-002 | Review Portfolio | Executive | Reporting | Medium |

---

## User Story Summary

| Module | User Stories | Description |
|--------|--------------|-------------|
| Registration | US-2.1.x | Asset registration and classification |
| Tracking | US-2.2.x | Asset tracking and location management |
| Maintenance | US-2.3.x | Maintenance planning and execution |
| Financial | US-2.4.x | Financial management and depreciation |
| Multi-Plant | US-2.5.x | Multi-plant operations |
| Lifecycle | US-2.6.x | Asset lifecycle from procurement to disposal |
| Utilization | US-2.7.x | Asset allocation and usage |
| Multi-Company | US-2.8.x | Multi-company group management |

---

*Next: [System Comparison](system-comparison.md)*
