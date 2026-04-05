# Requirements Evaluation Template

## Enterprise Asset Management Requirements Analysis

**Document Version:** 1.0  
**Target Markets:** United States, European Union  
**Applicable Standards:** ISO 55000, GAMP 5, GDPR, SOX, OSHA, EPA  
**EAM Systems Reference:** IBM Maximo, SAP PM, Oracle EAM  

---

## Purpose

This template provides a standardized framework for evaluating all 115 asset management requirements against Western/US-EU market standards. Each requirement must be assessed across regulatory compliance, business rules, data model integrity, multi-company data hierarchy, validation logic, and integration touchpoints.

---

## Evaluation Instructions

1. Copy this template for each requirement under evaluation
2. Complete all sections with specific, detailed assessments
3. Use "N/A" only when a section is genuinely not applicable
4. Flag any requirement that cannot meet Western market standards for review
5. Document all gaps, risks, and recommended enhancements

---

## 1. Requirement Metadata

```markdown
| Field | Value |
|-------|-------|
| **Requirement ID** | [e.g., REQ-FAM-001] |
| **Current Title** | [Exact title from requirements document] |
| **Module** | [e.g., Asset Master Data, Work Order Management, Depreciation] |
| **Original Priority** | [High / Medium / Low] |
| **File Location** | [Path to original requirement specification] |
| **Date Added** | [YYYY-MM-DD] |
| **Last Updated** | [YYYY-MM-DD] |
| **Evaluator** | [Name/Role] |
```

### 1.1 Requirement Description

[Copy the full requirement text here]

### 1.2 Requirement Source

- [ ] Customer Requirement Document
- [ ] Regulatory Requirement
- [ ] Internal Stakeholder Request
- [ ] Industry Best Practice
- [ ] Competitive Differentiator

---

## 2. Western Market Alignment Assessment

### 2.1 ISO 55000 Alignment

| Criterion | Assessment | Notes |
|-----------|------------|-------|
| **ISO 55000 Asset Management System** | ☐ Yes  ☐ Partial  ☐ No | |
| **ISO 55001 Physical Asset Management** | ☐ Yes  ☐ Partial  ☐ No | |
| **ISO 55002 Asset Management Systems - Guidelines** | ☐ Yes  ☐ Partial  ☐ No | |

**ISO 55000 Alignment Explanation:**

[Explain how this requirement aligns with or deviates from ISO 55000 principles:
- Asset management policy and objectives
- Asset management planning
- Support and operation
- Performance evaluation
- Continual improvement]

**Alignment Gaps:**
- [List specific gaps between this requirement and ISO 55000]

### 2.2 US/EU Regulatory Compliance

| Regulation | Applies | Compliance Status | Evidence/Mapping |
|------------|---------|-------------------|------------------|
| **GDPR** (EU) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **SOX** (US) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **OSHA** (US) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **EPA** (US) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **WEEE Directive** (EU) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **IFRS 16** (EU/US) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **US GAAP** (US) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |
| **GAMP 5** (Pharma) | ☐ Yes  ☐ No | ☐ Compliant  ☐ Gap  ☐ N/A | |

**Regulatory Compliance Details:**

[For each applicable regulation, document:
- Specific articles/sections that apply
- How this requirement addresses the regulation
- Any compliance gaps or risks]

### 2.3 Gap Analysis

**Current State vs. Western Market Requirements:**

| Gap Category | Gap Description | Severity | Remediation Effort |
|--------------|-----------------|----------|-------------------|
| [e.g., Data Privacy] | [Description of gap] | [High/Med/Low] | [Small/Med/Large] |
| | | | |

**Critical Gaps Requiring Immediate Attention:**
- [List gaps that prevent market readiness]

### 2.4 Industry Best Practice Alignment

| EAM System | Feature Comparison | Gap Analysis | Comparable Implementation |
|------------|-------------------|--------------|--------------------------|
| **IBM Maximo** | [How Maximo handles this] | [Gap analysis] | [Reference implementation] |
| **SAP PM** | [How SAP PM handles this] | [Gap analysis] | [Reference implementation] |
| **Oracle EAM** | [How Oracle EAM handles this] | [Gap analysis] | [Reference implementation] |

**Best Practice Recommendations:**
- [Document recommended approach based on industry best practices]

---

## 3. Business Rules Enhancement

### 3.1 Pre-conditions

| Pre-condition ID | Description | Validation Logic | Error Code | Error Message |
|------------------|-------------|------------------|------------|---------------|
| PRE-001 | [Condition that must be true before this requirement executes] | [Validation logic - e.g., field NOT NULL AND > 0] | [ERR-XXX] | [Standardized error message] |
| PRE-002 | | | | |
| PRE-003 | | | | |

**Pre-condition Validation Matrix:**

```
[If multiple pre-conditions exist, document the validation order and dependency logic]

Example:
IF (Asset.Status = 'Active') 
   AND (Asset.AcquisitionDate IS NOT NULL)
   AND (Asset.AcquisitionCost > 0)
THEN proceed to depreciation calculation
ELSE throw PRE-001 Error
```

### 3.2 Post-conditions

| Post-condition ID | Description | Success Criteria | Verification Method |
|-------------------|-------------|-------------------|---------------------|
| POST-001 | [Expected state after requirement execution] | [Specific measurable outcome] | [How to verify] |
| POST-002 | | | |

**Post-condition Verification:**

[Document the expected system state after successful execution:
- Data created/modified
- State transitions completed
- Side effects triggered]

### 3.3 Business Logic

**Decision Tree:**

```
[Document the complete decision tree for this requirement]

START
  │
  ▼
[Decision Point 1]
  ├─► Condition A ─► [Action 1] ─► END
  └─► Condition B ─► [Action 2] ─► END
       │
       ▼
  [Decision Point 2]
       ├─► Condition B1 ─► [Action 3] ─► END
       └─► Condition B2 ─► [Action 4] ─► END
```

**Business Rules Specification:**

| Rule ID | Rule Name | Condition | Action | Priority |
|---------|-----------|-----------|--------|----------|
| BR-001 | [e.g., Depreciation Start Date Rule] | [IF asset acquisition date exists] | [THEN set depreciation start date = acquisition date + 1 month] | [1] |
| BR-002 | | | | |

**Calculation Logic (if applicable):**

```
[Document any formulas, calculations, or algorithmic logic]

Example:
Depreciation = (AcquisitionCost - SalvageValue) / UsefulLife
AnnualDepreciation = Depreciation / 12
MonthlyDepreciation = AnnualDepreciation
```

### 3.4 Edge Cases

| Edge Case ID | Scenario | Expected Behavior | Handling Approach |
|--------------|----------|-------------------|-------------------|
| EC-001 | [e.g., Asset with 0 useful life] | [Expected outcome] | [How system should handle] |
| EC-002 | [e.g., Negative acquisition cost - data entry error] | [Expected outcome] | [How system should handle] |
| EC-003 | [e.g., Mid-year asset acquisition] | [Expected outcome] | [How system should handle] |

**Edge Case Decision Matrix:**

| Condition | Condition | Condition | Outcome |
|-----------|-----------|-----------|---------|
| [A=Value] | [B=Value] | [C=Value] | [Result] |
| | | | |

### 3.5 State Transitions

**State Diagram:**

```
[Document all possible states and valid transitions]

States: [List all states e.g., Draft, Active, Under Maintenance, Disposed]

Transitions:
┌─────────────┐       ┌─────────────┐       ┌─────────────┐
│   DRAFT     │──────►│   ACTIVE    │──────►│   DISPOSED  │
└─────────────┘       └─────────────┘       └─────────────┘
       │                     │                     │
       │                     ▼                     │
       │              ┌─────────────┐              │
       └─────────────►│  ON REPAIR  │◄─────────────┘
                      └─────────────┘
```

**Transition Rules:**

| Current State | Event | Next State | Guard Conditions | Side Effects |
|---------------|-------|------------|------------------|---------------|
| DRAFT | Submit for Approval | PENDING_APPROVAL | All required fields complete | Notification sent |
| ACTIVE | Initiate Repair | ON_REPAIR | Asset not already under repair | Work Order created |

---

## 4. Data Model Elements

### 4.1 Input Entities

| Entity Name | Entity Type | Primary Key | Attributes | Data Type | Required | Source System |
|-------------|-------------|-------------|------------|-----------|----------|---------------|
| [e.g., Asset] | [Master/Transaction] | [AssetID] | AssetCode | VARCHAR(50) | YES | User Entry |
| | | | AssetName | VARCHAR(200) | YES | User Entry |
| | | | AcquisitionDate | DATE | YES | User Entry |
| | | | AcquisitionCost | DECIMAL(18,4) | YES | User Entry |

### 4.2 Output Entities

| Entity Name | Entity Type | Primary Key | Attributes | Generated By |
|-------------|-------------|-------------|------------|--------------|
| [e.g., AssetDepreciation] | [Master/Transaction] | [DepreciationID] | [List attributes] | [Process/Rule that generates] |

### 4.3 Relationships

**Entity Relationship Diagram (ERD):**

```
[Document relationships using standard ERD notation]

Asset ──────────< AssetDepreciation
  │                    │
  │                    │
  └──────< AssetLocation >─────── Location
                │
                ▼
         WorkOrderAsset
                │
                ▼
           WorkOrder
```

**Relationship Specifications:**

| Relationship | Type | Cardinality | Parent Entity | Child Entity | Foreign Key | On Delete |
|--------------|------|-------------|---------------|--------------|-------------|-----------|
| Asset_Has_Depreciation | 1:N | One asset has many depreciation records | Asset | AssetDepreciation | AssetID | CASCADE |
| | | | | | | |

### 4.4 Master Data vs Transaction Data

| Entity | Classification | Justification | Retention Period |
|--------|---------------|----------------|------------------|
| Asset | Master Data | Core business object, defines asset lifecycle | Permanent (7 years after disposal) |
| AssetDepreciation | Transaction Data | Financial calculations, subject to audit | 7 years |
| WorkOrder | Transaction Data | Operational records | 5 years |

### 4.5 Multi-Company Data Scope

| Data Scope Level | Entity | Scope Attribute | Default Value | Override Allowed |
|------------------|--------|-----------------|---------------|------------------|
| Company | [Entity] | CompanyCode | [Default] | ☐ Yes  ☐ No |
| Division | [Entity] | DivisionCode | Inherited from Company | ☐ Yes  ☐ No |
| Plant | [Entity] | PlantCode | Inherited from Division | ☐ Yes  ☐ No |
| Department | [Entity] | DepartmentCode | Inherited from Plant | ☐ Yes  ☐ No |

---

## 5. Multi-Company Data Hierarchy

### 5.1 Data Scope Level

| Dimension | Level | Creates Data | Views Data | Modifies Data |
|-----------|-------|--------------|------------|---------------|
| **Geographic** | Country | ☐ | ☐ | ☐ |
| **Legal Entity** | Company | ☐ | ☐ | ☐ |
| **Business Unit** | Division | ☐ | ☐ | ☐ |
| **Operations** | Plant | ☐ | ☐ | ☐ |
| **Cost Center** | Department | ☐ | ☐ | ☐ |

**Data Creation Authority Matrix:**

```
[Define which organizational levels can create data for this requirement]

                        │ Company │ Division │ Plant │ Department │
────────────────────────┼─────────┼──────────┼───────┼────────────┤
Create Asset            │    X    │    X     │   X   │            │
Create Work Order       │         │          │   X   │     X      │
Post Depreciation       │    X    │          │       │            │
```

### 5.2 Access Control Rules

**Role × Company Scope Matrix:**

| Role | Same Company | Same Division | Same Plant | Same Department | All Companies |
|------|--------------|---------------|------------|-----------------|----------------|
| System Admin | ✓ | ✓ | ✓ | ✓ | ✓ |
| Company Admin | ✓ | ✓ | ✓ | ✓ | Read Only |
| Division Manager | ✓ | ✓ | ✓ | Read Only | None |
| Plant Manager | ✓ | ✓ | ✓ | Read Only | None |
| Department User | ✓ | Read Only | Read Only | Read Only | None |

**Access Control Implementation Rules:**

[Document specific access control rules, e.g.:]
- Users can only view assets within their organizational hierarchy
- Modification rights require explicit permission at the data's scope level
- Cross-company data access requires Company Admin role

### 5.3 Data Isolation

| Isolation Requirement | Implementation | Verification Method |
|----------------------|----------------|-------------------|
| [e.g., Company A cannot view Company B assets] | [Foreign key constraints + application-level filtering] | [Automated test: attempt cross-company access] |
| [Financial data per company] | [Database schema with CompanyCode] | [Query verification] |

**Data Segregation Strategy:**

[Document how data is isolated between companies:
- Database-level: Separate schemas or CompanyCode filtering
- Application-level: Session-based company context
- API-level: Company scope validation]

### 5.4 Consolidation

| Consolidation Type | Supported | Method | Aggregation Logic |
|-------------------|-----------|--------|-------------------|
| Financial Reporting | ☐ Yes  ☐ No | [Method] | [How data rolls up] |
| Asset Count by Category | ☐ Yes  ☐ No | [Method] | [How data rolls up] |
| Depreciation Summary | ☐ Yes  ☐ No | [Method] | [How data rolls up] |

**Consolidation Hierarchy:**

```
Company (Legal Entity)
  │
  ├── Division A
  │     ├── Plant 1
  │     │     ├── Department 1.1
  │     │     └── Department 1.2
  │     └── Plant 2
  │           └── Department 2.1
  └── Division B
        └── Plant 3
```

### 5.5 Data Sovereignty

| Country | Data Residency Requirement | Storage Location | Transfer Restrictions | Compliance |
|---------|---------------------------|-----------------|---------------------|------------|
| Germany | EU data must remain in EU | EU West | No transfer outside EU without adequacy decision | GDPR Art. 44-49 |
| France | EU data localization | EU West | Same as Germany | GDPR |
| United States | No federal localization | US East/US West | State-specific laws (CCPA) | SOX, State privacy laws |
| United Kingdom | Adequacy decision for EU data | UK/US | UK GDPR applies post-Brexit | UK GDPR |

---

## 6. Enhanced Validation Rules

### 6.1 Field-Level Validation

| Field Name | Data Type | Format | Range | Required | Validation Rule | Error Code | Error Message |
|------------|-----------|--------|-------|----------|-----------------|------------|---------------|
| AssetCode | VARCHAR | [A-Z]{2}[0-9]{6} | N/A | YES | Pattern match: `^[A-Z]{2}[0-9]{6}$` | VAL-001 | "Asset code must be 2 letters followed by 6 digits" |
| AcquisitionCost | DECIMAL | N/A | > 0 AND <= 999999999.9999 | YES | Range check | VAL-002 | "Acquisition cost must be between 0 and 999,999,999.9999" |

### 6.2 Business Rule Validation

| Validation Rule | Description | Condition | Action on Failure | Error Code |
|-----------------|-------------|-----------|------------------|------------|
| BRV-001 | Asset code uniqueness per company | CompanyCode + AssetCode must be unique | Reject duplicate | VAL-003 |
| BRV-002 | Depreciation cannot exceed acquisition cost | SUM(Depreciation) <= AcquisitionCost | Warn user, allow override with reason | VAL-004 |
| BRV-003 | Asset disposal date must be after acquisition date | DisposalDate > AcquisitionDate | Reject | VAL-005 |

**Cross-Field Validation Logic:**

```
IF (Asset.Category = 'VEHICLE')
   AND (Asset.AcquisitionCost > 100000)
THEN require (Asset.InsurancePolicyNumber IS NOT NULL)
     AND require (Asset.InsuranceExpirationDate > CURRENT_DATE)
```

### 6.3 Error Codes

| Error Code | Severity | Category | Short Description | Long Description | User Guidance |
|------------|----------|----------|-------------------|------------------|---------------|
| VAL-001 | Error | Validation | Invalid asset code format | The provided asset code does not match the required format | Enter asset code as 2 letters followed by 6 digits (e.g., AS000123) |
| VAL-002 | Error | Validation | Invalid acquisition cost | Acquisition cost must be a positive number | Enter a value greater than 0 |
| VAL-003 | Error | Business Rule | Duplicate asset code | An asset with this code already exists in the company | Enter a unique asset code or update the existing asset |
| VAL-004 | Warning | Business Rule | Depreciation exceeds cost | Total depreciation would exceed acquisition cost | Review depreciation parameters or provide override reason |
| VAL-005 | Error | Business Rule | Invalid disposal date | Disposal date cannot precede acquisition date | Enter a disposal date after the acquisition date |

### 6.4 Warning Conditions

| Warning ID | Condition | Warning Message | Allow Proceed | Override Reason Required |
|------------|-----------|-----------------|---------------|--------------------------|
| WRN-001 | Useful life exceeds typical range | "Useful life of {value} years exceeds typical range for this asset category" | ☐ Yes  ☐ No | ☐ Yes  ☐ No |
| WRN-002 | Depreciation start date in future | "Depreciation start date is in the future" | ☐ Yes  ☐ No | ☐ Yes  ☐ No |
| WRN-003 | High-value asset without insurance | "Asset valued over $50,000 has no insurance policy" | ☐ Yes  ☐ No | ☐ Yes  ☐ No |

---

## 7. EU/US Compliance Notes

### 7.1 GDPR Compliance

| GDPR Article | Requirement | Implementation | Evidence |
|-------------|-------------|----------------|----------|
| Art. 5 | Data minimization | Only collect data necessary for asset management | Field-level review |
| Art. 6 | Lawful basis | Contract performance for employee asset tracking | Legal basis documentation |
| Art. 15 | Right of access | Provide data export for personal data in asset records | API endpoint for data export |
| Art. 17 | Right to erasure | Support deletion of personal data with audit trail | Soft delete with anonymization |

**Personal Data Handling:**

| Data Element | Personal Data | Legal Basis | Retention | Special Category |
|--------------|---------------|-------------|-----------|------------------|
| Asset.AssignedTo | YES | Contract performance | Asset lifecycle + 7 years | NO |
| Asset.LastMaintainedBy | YES | Legitimate interest | 7 years after maintenance | NO |

### 7.2 SOX/IFRS Compliance

| Requirement | Standard | Implementation | Evidence |
|-------------|----------|----------------|----------|
| Fixed asset capitalization | IFRS 16 / ASC 842 | Assets > $5,000 capitalized | Depreciation schedule |
| Useful life documentation | IFRS 16.57 | Mandatory field with approval workflow | Audit trail |
| Impairment testing | IAS 36 | Annual review trigger | Impairment assessment report |
| Disclosure requirements | IFRS 16.59 | Financial statement extracts | Report generation |

**Financial Controls:**

| Control ID | Control Description | Frequency | Owner | Evidence |
|------------|---------------------|-----------|-------|----------|
| FC-001 | All asset acquisitions approved by budget owner | Per transaction | Controller | Approval record in system |
| FC-002 | Monthly depreciation recalculation review | Monthly | Accounting Manager | Reconciliation report |

### 7.3 OSHA Compliance

| OSHA Requirement | Application | Implementation | Record Keeping |
|-----------------|-------------|----------------|----------------|
| 29 CFR 1910.1200 | Hazmat tracking for assets | Material Safety Data Sheet linkage | 30 years |
| 29 CFR 1910.178 | Powered industrial trucks | Inspection tracking for forklifts | 5 years |
| 29 CFR 1910.303 | Electrical equipment | Inspection certification dates | Until replaced + 3 years |

### 7.4 EPA Compliance

| EPA Regulation | Requirement | Asset Type | Implementation |
|----------------|-------------|-----------|----------------|
| RCRA | Hazardous waste tracking | Tanks, Containers | Waste manifest integration |
| CAA | Air emission tracking | HVAC, Compressors | Emission monitoring records |
| TSCA | Chemical substance tracking | Manufacturing equipment | Chemical inventory linkage |
| WEEE Directive | Electronic waste | IT assets, Electronics | End-of-life tracking |

### 7.5 ISO Standards

| ISO Standard | Requirement Area | Implementation | Audit Evidence |
|--------------|------------------|----------------|----------------|
| ISO 55000 | Asset Management System | Policy, objectives, planning | Certification audit |
| ISO 55001:2014 | Asset management requirements | Clause-by-clause compliance | Internal audit |
| ISO 55002 | Guidelines for ISO 55001 | Documentation standards | Gap analysis |
| ISO 14001 | Environmental management | Environmental aspect tracking | EMS integration |

### 7.6 Audit Trail Requirements

| Event Type | Fields to Log | Retention | Access |
|------------|--------------|-----------|--------|
| CREATE | All fields, user, timestamp, IP | 7 years | Auditors only |
| UPDATE | Old value, new value, user, timestamp, reason | 7 years | Auditors only |
| DELETE | Soft delete with reason, user, timestamp | 7 years | Auditors only |
| READ | User, timestamp, data accessed (sensitive fields) | 3 years | Security team |

**Audit Log Schema:**

```
AuditLog {
    AuditLogID: UUID (PK)
    EntityType: VARCHAR(50)
    EntityID: UUID
    Action: ENUM('CREATE', 'UPDATE', 'DELETE', 'READ')
    OldValue: JSON
    NewValue: JSON
    ChangedFields: ARRAY[VARCHAR]
    UserID: UUID
    Username: VARCHAR(100)
    Timestamp: DATETIME
    IPAddress: VARCHAR(45)
    Reason: TEXT
    SessionID: VARCHAR(100)
}
```

---

## 8. Integration Touchpoints

### 8.1 Upstream Systems

| System | Integration Type | Data Received | Frequency | Data Quality Checks |
|--------|-----------------|---------------|-----------|---------------------|
| ERP (SAP/Oracle) | API/Message | GL account assignments, cost centers | Real-time/Batch | Validation against master data |
| Procurement | API | Purchase orders, receipt confirmations | Real-time | PO validation |
| HR System | API | Employee assignments, department transfers | Daily batch | Employee ID validation |

**Upstream Data Flow:**

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│  ERP System │────►│   Asset     │────►│  Financial  │
│  (SAP/Oracle)│     │  Management │     │  Reporting  │
└─────────────┘     └─────────────┘     └─────────────┘
       │                   ▲
       │                   │
       ▼                   │
┌─────────────┐     ┌─────────────┐
│ Procurement │────►│   Asset     │
│   System    │     │  Creation   │
└─────────────┘     └─────────────┘
```

### 8.2 Downstream Systems

| System | Integration Type | Data Sent | Frequency | Data Contract |
|--------|-----------------|-----------|-----------|---------------|
| ERP | API | Asset transactions, depreciation journals | Real-time | Published schema |
| BI/Analytics | Data Lake | Asset data, depreciation, maintenance | Daily | Data lake schema |
| GIS | API | Location data for spatial assets | On-change | Location schema |
| ERP (Procurement) | IDOC/API | Asset disposal notifications | On-change | Disposal notification |

### 8.3 API Endpoints

| Endpoint | Method | Purpose | Request Schema | Response Schema |
|----------|--------|---------|----------------|-----------------|
| /api/v1/assets | POST | Create asset | AssetCreateRequest | AssetResponse |
| /api/v1/assets/{id} | GET | Get asset | - | AssetResponse |
| /api/v1/assets/{id} | PATCH | Update asset | AssetUpdateRequest | AssetResponse |
| /api/v1/assets/{id}/depreciation | GET | Get depreciation schedule | - | DepreciationResponse |
| /api/v1/assets/{id}/dispose | POST | Dispose asset | DisposalRequest | DisposalResponse |

**API Error Response Schema:**

```json
{
  "error": {
    "code": "VAL-001",
    "message": "Invalid asset code format",
    "details": [
      {
        "field": "assetCode",
        "rejectedValue": "INVALID123",
        "reason": "Must match pattern ^[A-Z]{2}[0-9]{6}$"
      }
    ],
    "traceId": "abc123-def456"
  }
}
```

### 8.4 Event Messages

| Event | Producer | Consumers | Payload | Schema |
|-------|----------|-----------|---------|--------|
| Asset.Created | Asset Service | ERP, Notification | Asset details | AssetCreatedEvent |
| Asset.Depreciated | Depreciation Service | Finance, Reporting | Depreciation details | DepreciationPostedEvent |
| Asset.Disposed | Disposal Service | ERP, Compliance | Disposal details | AssetDisposedEvent |

**Event Schema Example:**

```json
{
  "eventId": "uuid",
  "eventType": "Asset.Created",
  "timestamp": "2024-01-15T10:30:00Z",
  "source": "asset-management-service",
  "data": {
    "assetId": "uuid",
    "assetCode": "AS000123",
    "companyCode": "US01",
    "divisionCode": "MFG",
    "plantCode": "PL01"
  }
}
```

---

## 9. Priority Adjustment

### 9.1 Priority Analysis

| Criterion | Weight | Original Priority | Score | Adjusted Priority |
|-----------|--------|------------------|-------|-------------------|
| Regulatory compliance | 30% | [H/M/L] | [1-5] | [H/M/L] |
| Business criticality | 25% | [H/M/L] | [1-5] | [H/M/L] |
| Customer impact | 20% | [H/M/L] | [1-5] | [H/M/L] |
| Implementation effort | 15% | [H/M/L] | [1-5] | [H/M/L] |
| Risk mitigation | 10% | [H/M/L] | [1-5] | [H/M/L] |

### 9.2 Final Recommendation

| Field | Value |
|-------|-------|
| **Original Priority** | [High / Medium / Low] |
| **Recommended Priority** | [High / Medium / Low] |
| **Priority Change Rationale** | [Detailed justification] |
| **Effort Estimate** | [Small / Medium / Large] |
| **Target Sprint/Milestone** | [e.g., Sprint 3, M2] |
| **Dependencies** | [List dependent requirements] |
| **Blocking Issues** | [List any blockers] |

---

## 10. Enhancement Recommendations

### 10.1 Required Additions

| Enhancement | Description | Rationale | Implementation Notes |
|------------|-------------|-----------|---------------------|
| [Title] | [What must be added] | [Why required for compliance] | [How to implement] |
| | | | |

**Mandated for Market Entry:**
- [ ] [Requirement/Capability] - [Regulation/Standard that requires it]

### 10.2 Recommended Additions

| Enhancement | Description | Benefit | Implementation Effort |
|------------|-------------|---------|---------------------|
| [Title] | [What should be added] | [Business value] | [Small/Medium/Large] |
| | | | |

**Recommended for Best Practice:**
- [ ] [Enhancement] - [Rationale]

### 10.3 Optional Enhancements

| Enhancement | Description | Nice-to-Have Benefit | Competitive Advantage |
|------------|-------------|----------------------|----------------------|
| [Title] | [What could be added] | [Future value] | [Market differentiator] |
| | | | |

### 10.4 Items to Remove

| Item | Current Behavior | Rationale for Removal | Risk Assessment |
|------|------------------|----------------------|-----------------|
| [Title] | [What it does currently] | [Why it should be removed] | [Migration risk] |

---

## 11. Evaluator Notes

### 11.1 Open Questions

| Question | Impact | Owner | Resolution Status |
|----------|--------|-------|-------------------|
| [Question text] | [High/Med/Low] | [Role] | [Open/Resolved] |

### 11.2 Risk Register

| Risk ID | Description | Likelihood | Impact | Mitigation |
|---------|-------------|-------------|--------|------------|
| [RISK-XXX] | [Risk description] | [High/Med/Low] | [High/Med/Low] | [Mitigation strategy] |

### 11.3 Sign-off

| Role | Name | Date | Signature |
|------|------|------|----------|
| Business Analyst | | | |
| Technical Architect | | | |
| Compliance Officer | | | |
| Product Owner | | | |

---

## Appendix A: Reference Standards

- ISO 55000:2014 - Asset management - Overview, principles and terminology
- ISO 55001:2014 - Asset management - Management systems - Requirements
- ISO 55002:2014 - Asset management - Guidelines for the application of ISO 55001
- GAMP 5 - Good Automated Manufacturing Practice
- GDPR (EU) 2016/679 - General Data Protection Regulation
- SOX (US) - Sarbanes-Oxley Act of 2002
- OSHA 29 CFR 1910 - Occupational Safety and Health Standards
- EPA Regulations - Environmental Protection Agency requirements
- IFRS 16 - Leases
- ASC 842 - Leases (US GAAP)

## Appendix B: EAM System Comparison Methodology

| Capability Area | Weight | IBM Maximo | SAP PM | Oracle EAM |
|-----------------|--------|------------|--------|------------|
| Asset Master | 20% | [Rating 1-5] | [Rating 1-5] | [Rating 1-5] |
| Work Management | 20% | [Rating 1-5] | [Rating 1-5] | [Rating 1-5] |
| Depreciation | 15% | [Rating 1-5] | [Rating 1-5] | [Rating 1-5] |
| Regulatory Compliance | 25% | [Rating 1-5] | [Rating 1-5] | [Rating 1-5] |
| Integration | 20% | [Rating 1-5] | [Rating 1-5] | [Rating 1-5] |

---

**Document End**

*This template is designed for enterprise asset management requirements analysis. For questions or updates, contact the requirements analysis team.*
