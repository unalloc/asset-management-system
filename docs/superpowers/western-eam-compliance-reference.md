# Western EAM Compliance Reference Document

**Version:** 1.0  
**Date:** 2026-04-04  
**Scope:** US/EU Regulatory Requirements for Enterprise Asset Management Systems

---

## 1. ISO 55000 Asset Management Standards

### 1.1 Overview

ISO 55000 is the international standard for asset management, providing a systematic approach to managing assets throughout their lifecycle. It establishes a framework that enables organizations to achieve their objectives through effective and efficient asset management.

### 1.2 Key Standards

| Standard | Title | Focus |
|----------|-------|-------|
| ISO 55000 | Asset management — Overview, principles, and terminology | Conceptual foundation and vocabulary |
| ISO 55001 | Asset management — Management systems — Requirements | Certified management system requirements |
| ISO 55002 | Asset management — Management systems — Guidelines for ISO 55001 implementation | Implementation guidance |

### 1.3 ISO 55001 Requirements for EAM Systems

#### Asset Registry Completeness
- Unique asset identification across the organization
- Complete asset data attributes (technical, financial, operational)
- Asset location tracking with hierarchical structure
- Asset relationships (parent/child, dependencies)
- Document and record linkage

#### Asset Lifecycle Management
- Planning and acquisition processes
- Operation and maintenance optimization
- Asset performance monitoring
- Asset decommissioning and disposal
- Hand-over criteria between lifecycle stages

#### Maintenance Optimization
- Preventive maintenance scheduling
- Condition-based maintenance triggers
- Mean time between failures (MTBF) tracking
- Maintenance cost analysis and optimization
- Spare parts and materials management

#### Risk-Based Decision Making
- Asset criticality assessment
- RiskRegister and risk matrix integration
- Failure mode and effects analysis (FMEA)
- Critical spares determination
- Maintenance priority based on risk

#### Continuous Improvement
- Key Performance Indicator (KPI) tracking
- Management review processes
- Corrective and preventive action (CAPA) system
- Benchmarking and best practice sharing
- Lessons learned integration

---

## 2. US GAAP / IFRS Accounting Standards

### 2.1 US GAAP Requirements

#### ASC 360 - Property, Plant, and Equipment

| Requirement | Description | EAM System Implication |
|-------------|-------------|------------------------|
| Recognition | Assets held for use in operations, not for resale | Asset classification in system |
| Initial Measurement | Cost includes purchase price, directly attributable costs, estimated dismantling costs | Capitalization workflow |
| Depreciation | Systematic allocation over useful life | Multiple depreciation methods support |
| Impairment | Trigger events, measurement, reversal prohibition | Impairment testing integration |
| Retirement | Physical removal from service | Retirement workflow with gain/loss |

#### Depreciation Methods (US GAAP)
- **Straight-line**: Equal expense each period
- **Declining balance**: Accelerated, percentage of remaining value
- **Units of production**: Based on output metrics
- **Sum-of-years-digits**: Accelerated fractional method

#### Asset Impairment Testing
- **Trigger events**: Physical damage, obsolescence, regulatory action
- **Recoverability test**: Undiscounted cash flows vs. carrying value
- **Measurement**: Fair value using market or DCF approach
- **Documentation**: Formal impairment analysis records

#### Asset Retirement Obligations (ARO)
- Legal or contractual obligations for asset retirement
- Initial recognition at fair value
- Subsequent accretion of discount
- Annual remeasurement

### 2.2 IFRS Requirements

#### IAS 16 - Property, Plant and Equipment

| Requirement | Description | EAM System Implication |
|-------------|-------------|------------------------|
| Recognition | Probable future economic benefits, reliable cost measurement | Asset acceptance criteria |
| Cost Model | Carrying amount = cost minus accumulated depreciation | Cost model support |
| Revaluation Model | Fair value with regular revaluation | Revaluation workflow |
| Depreciation | Systematic basis over useful life | Same as GAAP but revaluation impacts |
| Component Depreciation | Significant parts depreciated separately | Bill of materials / asset breakdown |

#### IAS 36 - Impairment of Assets
- **Cash Generating Unit (CGU)**: Smallest identifiable group of assets generating independent cash flows
- **Recoverable amount**: Higher of fair value minus costs to sell, or value in use
- **Impairment loss**: When carrying amount exceeds recoverable amount
- **Reversal**: Cannot reverse impairment on goodwill; other assets may reverse

#### IFRS 16 - Leases
- **Right-of-use asset**: Recognized for all leases (except short-term < 12 months, low-value)
- **Lease liability**: Present value of lease payments
- **Depreciation**: Separate from interest expense
- **Disclosures**: Lease term, discount rate, sensitivity

### 2.3 Key Differences for Multi-Company Consolidation

| Aspect | US GAAP | IFRS | EAM System Requirement |
|--------|---------|------|------------------------|
| Currency Translation | FASB ASC 830 | IAS 21 | Multi-currency with temporal/current method |
| Consolidation | VIE model, voting interest | Single control model | Entity hierarchy support |
| Segment Reporting | ASC 280 | IFRS 8 | Organizational structure alignment |
| Goodwill | Impairment only | Impairment and amortization (optional) | Goodwill tracking separate from assets |
| Revaluation | Not permitted | Permitted for PPE | Revaluation model toggle |

---

## 3. EU Environmental Directives

### 3.1 WEEE Directive (2012/19/EU)

**Waste Electrical and Electronic Equipment Directive**

#### Core Requirements
- **Producer Responsibility**: Manufacturers must finance collection, treatment, recovery, disposal
- **Registration**: Producers must register in each EU member state where they place products
- **Marking**: Products must be marked with crossed-out wheelie bin symbol
- **Reporting**: Annual reporting of collected and recycled amounts

#### Asset Tracking Implications
- Serial number/lot tracking for products in field
- Installation date and location records
- End-of-life collection and recycling documentation
- Batch-level traceability for materials composition

### 3.2 RoHS Directive (2011/65/EU)

**Restriction of Hazardous Substances**

#### Scope
- Categories 1-11 (large/small household appliances, IT/ telecommunications, consumer equipment, lighting, tools, toys, medical devices, monitoring instruments, etc.)

#### Restricted Substances
| Substance | Maximum Concentration |
|-----------|----------------------|
| Lead (Pb) | 0.1% |
| Mercury (Hg) | 0.1% |
| Cadmium (Cd) | 0.01% |
| Hexavalent Chromium (Cr6+) | 0.1% |
| Polybrominated Biphenyls (PBB) | 0.1% |
| Polybrominated Diphenyl Ethers (PBDE) | 0.1% |

#### Asset Composition Tracking Requirements
- Bill of Materials (BOM) linkage per asset
- Substance declarations from suppliers
- RoHS compliance verification documentation
- Non-conforming material tracking and quarantine

### 3.3 REACH Regulation (EC 1907/2006)

**Registration, Evaluation, Authorisation and Restriction of Chemicals**

#### Key Obligations
- **Registration**: Substances manufactured/imported >1 tonne/year require registration with ECHA
- **Authorization**: Substances of Very High Concern (SVHC) require authorization for use
- **Restriction**: Certain substances restricted in specific applications
- **Communication**: Supply chain communication of chemical composition

#### Asset Material Documentation
- Material declaration records per asset
- Safety Data Sheet (SDS) linkage
- SVHC candidate list tracking
- Article-level notification requirements for SVHC >0.1%

### 3.4 EU Taxonomy Regulation (2020/852)

**Sustainable Finance Disclosure Regulation**

#### Classification Criteria
- Substantial contribution to at least one environmental objective
- Do no significant harm (DNSH) to other objectives
- Minimum social safeguards
- Technical screening criteria by sector

#### Six Environmental Objectives
1. Climate change mitigation
2. Climate change adaptation
3. Sustainable use of water
4. Transition to circular economy
5. Pollution prevention and control
6. Protection of biodiversity

#### ESG Reporting Requirements
- Taxonomy-aligned asset percentage
- CapEx/OpEx/Revenue alignment reporting
- EU Taxonomy-eligible vs. aligned distinction
- Mandatory disclosure templates

---

## 4. US Environmental Regulations

### 4.1 EPA Requirements

#### RCRA - Resource Conservation and Recovery Act

**Scope**: Regulates hazardous and non-hazardous solid waste from cradle to grave

| Requirement | Description | EAM Implication |
|-------------|-------------|-----------------|
| Generator Requirements | Proper labeling, storage, manifesting | Waste tracking from equipment |
| Transporter Requirements | EPA ID, recordkeeping | Disposal vendor management |
| Treatment/Storage/Disposal | Permitting, monitoring | Facility compliance tracking |
| Universal Waste | Batteries, lamps, electronics | Simplified handling procedures |

#### Asset Tracking for Regulated Materials
- Universal waste designation tracking
- Accumulation start dates
- Manifest documentation linking
- Handler certification records

#### End-of-Life Disposal Compliance
- EPA Form 8700-22 (Manifest)
- Exception reporting for non-receipt
- Biennial report preparation data
- Closure documentation requirements

### 4.2 TSCA - Toxic Substances Control Act

**Chemical Inventory and Risk Management**

#### Key Requirements
- **Inventory**: ~85,000 chemicals registered; new chemicals require pre-manufacture review
- **Significant New Use Rules (SNUR)**: Notification for new uses of existing chemicals
- **Risk Evaluation**: Systematic reviews of existing chemicals
- **Prior Notice**: Pre-import notification for certain chemicals

#### Asset Composition Documentation
- Chemical inventory per asset/component
- Supplier certification records
- TSCA section 8(a) Inventory Update Rule
- Import/export tracking for regulated substances

---

## 5. SOX Compliance (Sarbanes-Oxley Act)

### 5.1 Section 302 - Corporate Responsibility for Financial Reports

**CEO/CFO Certification Requirements**

| Requirement | Description | EAM System Control |
|-------------|-------------|-------------------|
| Financial Report Accuracy | Signed certification of financial statements | Audit trail of asset transactions |
| Internal Controls | Effectiveness of internal controls over financial reporting | Segregation of duties, access controls |
| Disclosure Controls | Effectiveness of disclosure controls | Workflow approvals |
| Material Weaknesses | Identification and timely disclosure | Issue escalation procedures |

### 5.2 Section 404 - Management Assessment of Internal Controls

**Internal Control Evaluation**

#### Key Requirements
- Annual assessment of internal controls
- External auditor attestation (for public companies)
- Documentation of control design and effectiveness
- Remediation of identified control deficiencies

#### SOX Control Objectives for EAM

| Control Area | Requirement | Implementation |
|--------------|-------------|-----------------|
| Asset Acquisition | All capital purchases properly authorized | Workflow with approval chains |
| Asset Valuation | Costs correctly capitalized | Integration with AP/ERP |
| Depreciation | Calculated correctly per policy | Automated calculation engine |
| Asset Disposal | Gain/loss properly calculated and approved | Disposal workflow with approval |
| Asset Impairment | Proper triggering and measurement | Impairment assessment workflow |
| Physical Safeguarding | Periodic physical inventory counts | Cycle count reconciliation |
| Access Controls | Logical/physical access segregation | Role-based security model |
| Audit Trail | Complete transaction history retained | Immutable audit logging |

### 5.3 Segregation of Duties Matrix

| Role | Create | Approve | Receive | Dispose | Reconcile |
|------|--------|---------|---------|---------|-----------|
| Requestor | ✓ | ✗ | ✗ | ✗ | ✗ |
| Approver | ✗ | ✓ | ✗ | ✓ | ✗ |
| Receiver | ✗ | ✗ | ✓ | ✗ | ✗ |
| Accountant | ✗ | ✗ | ✗ | ✓ | ✓ |
| Auditor | ✗ | ✗ | ✗ | ✗ | ✓ |

### 5.4 Audit Trail Requirements

- **Completeness**: Every asset transaction logged
- **Immutability**: No modification of historical records
- **Timeliness**: Real-time or near-real-time logging
- **Detail**: Before/after values, user, timestamp, reason
- **Retention**: Minimum 7 years (check specific regulation)
- **Accessibility**: Searchable and exportable for audit

---

## 6. OSHA Safety Requirements

### 6.1 29 CFR 1910 - General Industry Standards

#### Key Applicable Standards

| Standard | Subject | EAM Integration |
|----------|---------|-----------------|
| 1910.119 | Process Safety Management | High-risk equipment maintenance |
| 1910.134 | Respiratory Protection | Equipment certification tracking |
| 1910.147 | Lockout/Tagout (LOTO) | Equipment-specific LOTO procedures |
| 1910.157 | Portable Fire Extinguishers | Inspection/maintenance records |
| 1910.178 | Powered Industrial Trucks | Equipment certification |
| 1910.212 | Machine Guarding | Inspection records |
| 1910.303 | Electrical Equipment | Certification and testing |
| 1910.334 | Electrical Safety-Related Work Practices | Work permits |
| 1910.1001 | Asbestos | Building/materials surveys |
| 1910.1200 | Hazard Communication | SDS management |

### 6.2 EAM Safety Module Requirements

#### Safety Equipment Tracking
- Unique equipment ID and location
- Certification and inspection dates
- Next inspection due dates with alerts
- Certification document attachments
- Operator qualification records

#### Inspection and Maintenance Records
- Inspection frequency by equipment type
- Inspection checklist templates
- Deficiency tracking and correction
- Historical record retention
- Regulatory compliance verification

#### Training Certification Tracking
- Training curriculum by job function
- Training completion dates
- Certification expiration tracking
- Competency assessment records
- Recertification scheduling

#### Incident Reporting Integration
- Equipment linked to incidents
- Root cause analysis linkage
- Corrective action tracking
- Incident cost attribution
- Near-miss reporting integration

#### Lockout/Tagout Procedures
- Equipment-specific LOTO procedures
- Energy isolation point documentation
- Procedure revision tracking
- Training completion per equipment
- Annual LOTO procedure review

#### Personal Protective Equipment (PPE)
- PPE assigned per work area
- PPE inspection/replacement schedule
- PPE certification tracking
- Issuance and return records
- Contamination tracking

---

## 7. GDPR Data Privacy (EU)

### 7.1 Key Articles

| Article | Subject | EAM Impact |
|---------|---------|------------|
| Article 5 | Principles relating to processing | Lawful basis, purpose limitation |
| Article 6 | Lawfulness of processing | Contractual necessity, legitimate interest |
| Article 7 | Conditions for consent | Technician access consent |
| Article 12 | Transparent information | Privacy notice requirements |
| Article 15 | Right of access | Subject access request handling |
| Article 16 | Right to rectification | Data correction procedures |
| Article 17 | Right to erasure | Asset record anonymization |
| Article 20 | Right to data portability | Export functionality |
| Article 25 | Data protection by design | System architecture |
| Article 30 | Records of processing | Data inventory/dPIA |

### 7.2 EAM-Specific Data Privacy Issues

#### Employee Data in Asset Assignments
- Technician/maintenance personnel assignments
- Operator identification on work orders
- Employee asset custody records
- Time tracking integration

**Risk**: Asset records may reveal worker location patterns

#### Technician Maintenance Records
- Personal data in maintenance history
- Diagnostic notes containing personal information
- Performance evaluation data linkage
- Schedule flexibility information

**Risk**: Maintenance records could identify specific individuals and their work patterns

#### Data Minimization Requirements
| Data Category | Minimum Required | Extended Data (with justification) |
|---------------|------------------|------------------------------------|
| Employee ID | Employee number | Full name, contact info |
| Location | Asset location | Building/floor/room |
| Work Order | Asset, date, work type | Detailed notes, photos |

#### Right to Erasure Considerations
- **Challenge**: Asset history must be retained for regulatory compliance
- **Solution**: Anonymization of personal identifiers while maintaining operational history
- **Alternative**: Retention based on regulatory requirements overrides erasure

#### Data Retention Policies
| Data Type | Retention Period | Legal Basis |
|-----------|-----------------|-------------|
| Financial asset records | 7-10 years (SOX) | Regulatory requirement |
| Maintenance records | Life of asset + 7 years | Legal obligation |
| Employee work history | 2 years post-employment | Employment law |
| Incident reports | 5 years | OSHA requirements |

#### Cross-Border Transfer Restrictions
- **Standard Contractual Clauses (SCCs)**: Required for non-adequate countries
- **Binding Corporate Rules (BCRs)**: For intra-group transfers
- **Adequacy Decisions**: EU-approved countries (UK, Canada, Japan)
- **US Transfers**: Data Privacy Framework (DPF) certification

### 7.3 Data Protection Impact Assessment (DPIA)

**When Required**: Systematic monitoring of employees, processing special categories of data, large-scale processing

**DPIA Components**:
- Processing description and purpose
- Necessity and proportionality assessment
- Risk identification and evaluation
- Mitigation measures and residual risk
- Consultation record

---

## 8. GAMP 5 Guidelines (Manufacturing)

### 8.1 GAMP 5 Principles

| Principle | Description | Application |
|-----------|-------------|-------------|
| Risk-Based Approach | Scale validation effort to risk | Higher risk = more rigor |
| Scaled Validation | Proportionate to system complexity | Simple systems = minimal docs |
| Lifecycle Management | Phases from concept to retirement | IQ/OQ/PQ framework |
| Knowledge Management | Apply science and experience | Risk-based decision making |
| Quality Risk Management | ICH Q9 principles | Documented risk assessment |
| Leveraging Supplier Activities | Use supplier documentation | URS, FDS, supplier audits |

### 8.2 Computerized Systems Lifecycle

```
Concept Phase → Specification → Development → Verification → 
Operation → Retirement
     ↓            ↓              ↓            ↓           ↓
   URS          FRS/SRS        Coding     IQ/OQ/PQ    Data Migration
```

### 8.3 GAMP 5 Categories

| Category | Description | Examples | Validation Effort |
|----------|-------------|----------|-------------------|
| Category 1 | Infrastructure software | OS, DBMS, networks | Low |
| Category 2 | Non-configured infrastructure | Office software | Low |
| Category 3 | Configured off-the-shelf | COTS with standard config | Medium |
| Category 4 | Configured customized | COTS with custom config | Medium-High |
| Category 5 | Custom developed | Bespoke applications | High |

### 8.4 Key Requirements for EAM Systems

#### Equipment Qualification
| Phase | Activity | Deliverable |
|-------|----------|-------------|
| Design Qualification (DQ) | Verify system meets URS | DQ protocol and report |
| Installation Qualification (IQ) | Verify installed as specified | IQ protocol and report |
| Operational Qualification (OQ) | Verify functions as specified | OQ protocol and report |
| Performance Qualification (PQ) | Verify performs in normal use | PQ protocol and report |

#### Calibration Management
- Calibration schedules by instrument
- Calibration procedure references
- As-found/as-left data recording
- Out-of-tolerance handling
- Measurement uncertainty documentation
- Calibration certificate management

#### Change Control
- Change request documentation
- Impact assessment
- Testing and validation
- Approval workflow
- Implementation verification
- Change record closure

#### Deviation Management
- Deviation identification and documentation
- Immediate impact assessment
- Root cause investigation
- CAPA development
- Effectiveness verification
- Deviation closure and trending

#### Documentation Requirements
- User Requirements Specification (URS)
- Functional Specification (FS)
- System Design Specification (SDS)
- Test protocols and reports
- Validation reports
- SOPs for operation and maintenance

---

## 9. Multi-Company Data Hierarchy Requirements

### 9.1 Typical Organizational Structure

```
Group (Holding Company)
  └── Company (Legal Entity)
        └── Division (Business Unit)
              └── Plant (Manufacturing Site)
                    └── Department (Cost Center)
                          └── Work Center (Optional)
```

### 9.2 Data Isolation Requirements

#### Logical Data Segregation
| Level | Data Scope | Isolation Method |
|-------|-----------|------------------|
| Group | All entities | Master data, reporting |
| Company | Single legal entity | Database schema/partition |
| Division | Business unit | Data filters |
| Plant | Single site | Plant ID field |
| Department | Cost center | Department ID field |

#### Access Control Matrix Example

| Role | Group Data | Company Data | Division Data | Plant Data |
|------|-----------|--------------|---------------|------------|
| Group Admin | Full | Full | Full | Full |
| Company Controller | View | Full | Full | Full |
| Division Manager | View | View | Full | Full |
| Plant Manager | View | View | View | Full |
| Department Lead | View | View | View | Department only |

### 9.3 Data Sovereignty Considerations

| Region | Requirements | Implementation |
|--------|--------------|----------------|
| EU | GDPR, EU data residency | EU-based servers, local processing |
| US | State privacy laws (CCPA) | California/Colorado compliance |
| UK | UK GDPR | Post-Brexit adequacy |
| China | Personal Information Protection Law (PIPL) | Local data storage |

### 9.4 Consolidation Requirements

#### Entity-Level Reporting
- Separate financial statements per entity
- Regulatory reporting by jurisdiction
- Tax reporting (local and consolidated)
- Transfer pricing documentation

#### Group-Level Consolidation
- Elimination of inter-company transactions
- Currency translation at various rates
- Goodwill and minority interest
- Consolidated financial statements

#### Inter-Company Eliminations
| Transaction Type | Example | Elimination Entry |
|------------------|---------|-------------------|
| Asset transfer | Equipment moved between plants | Remove profit, adjust NBV |
| Services | Management fees | Eliminate revenue/expense |
| Loans | Inter-company borrowing | Remove interest income/expense |
| Investments | Subsidiary ownership | Remove investment, record equity |

---

## 10. Comparison with Industry EAM Systems

### 10.1 IBM Maximo

#### Strengths
- Industry-leading asset management functionality
- Comprehensive work order and maintenance management
- Strong inventory management (Item Master)
- Excellent reporting and analytics (BIRT)
- Extensive integration capabilities (REST, SOAP, MIF)
- Strong regulatory compliance features (FDA 21 CFR Part 11, NERC)
- Sophisticated scheduling and optimization

#### Compliance Features
- **ISO 55000**: Native alignment with asset management principles
- **SOX**: Complete audit trail, segregation of duties
- **GAMP 5**: Validation lifecycle support, GxP-ready
- **OSHA**: Safety plan integration, incident tracking
- **Environmental**: RCRA compliance tracking, waste management

#### Gaps/Limitations
- Complex implementation and customization
- High total cost of ownership
- Steep learning curve for users
- dated UI/UX compared to modern solutions
- Complex integration with non-IBM systems
- Limited out-of-box IFRS/GAAP depreciation engines

### 10.2 SAP EAM (Plant Maintenance)

#### Strengths
- Deep integration with SAP ERP (FI/CO, MM, PM)
- Strong financial integration for asset accounting
- Excellent for organizations already on SAP
- Comprehensive material management
- Powerful workflow engine (SAP Business Workflow)
- Global support and implementation partner network

#### Compliance Features
- **IFRS/GAAP**: Native integration with SAP Finance
- **SOX**: Integrated control framework
- **ISO 55000**: Aligned asset management processes
- **Environmental**: Integration with SAP EHS
- **GAMP 5**: Validation toolkit available

#### Gaps/Limitations
- Complex and expensive to implement
- Heavy customization required for best practices
- Slow development cycles
- Resource-intensive system
- Complex upgrade path
- Steep learning curve

### 10.3 Oracle EAM (Oracle Asset Management)

#### Strengths
- Integration with Oracle Cloud ERP
- Strong analytical capabilities (Oracle Analytics)
- Comprehensive asset lifecycle management
- Good mobile functionality
- Flexible deployment (cloud, on-premise, hybrid)
- Strong in manufacturing and utilities sectors

#### Compliance Features
- **IFRS/GAAP**: Integration with Oracle Financials
- **SOX**: Audit trail and controls framework
- **ISO 55000**: Asset management principles support
- **Environmental**: Oracle Environment Health Safety integration
- **GAMP 5**: Validation support documentation

#### Gaps/Limitations
- Complex licensing model
- Implementation complexity
- Performance at scale issues reported
- Less specialized than IBM Maximo
- Integration challenges with non-Oracle systems
- UI can be clunky

### 10.4 IFS Applications

#### Strengths
- Strong focus on asset management core
- Excellent for project-centric industries
- Flexible deployment options
- Good mobile and offline capabilities
- Lower TCO compared to SAP/Oracle
- Strong in Scandinavia and selected verticals

#### Compliance Features
- **ISO 55000**: Direct alignment and certification support
- **IFRS/GAAP**: Multi GAAP depreciation support
- **SOX**: Audit and control features
- **Environmental**: Tracking and reporting modules
- **GAMP 5**: Validation methodology support

#### Gaps/Limitations
- Smaller implementation partner network
- Less global presence than SAP/Oracle
- Limited third-party integration
- Smaller user community
- Financial consolidation less robust
- Some gaps in complex manufacturing

### 10.5 Competitive Gaps to Address

| Gap Area | IBM Maximo | SAP | Oracle | IFS | Our Opportunity |
|----------|-----------|-----|--------|-----|-----------------|
| Modern UI/UX | ✗ | ✗ | ✗ | ✗ | ✓ Priority |
| AI/ML-driven maintenance | △ | △ | △ | △ | ✓ Differentiation |
| IoT integration (native) | △ | △ | △ | △ | ✓ Modern approach |
| Real-time asset tracking | ✓ | △ | △ | △ | ✓ Modern approach |
| SaaS/multi-tenant | △ | △ | △ | △ | ✓ Cloud-native |
| User-friendly reporting | ✗ | △ | △ | △ | ✓ Low-code analytics |
| Mobile-first design | △ | △ | △ | △ | ✓ Mobile-first |
| GDPR consent management | △ | △ | △ | △ | ✓ Privacy by design |
| ESG/sustainability reporting | △ | △ | △ | △ | ✓ EU Taxonomy ready |
| Cost-effectiveness | △ | △ | △ | △ | ✓ Modern pricing |

### 10.6 Minimum Viable Compliance Feature Set

Based on regulatory analysis, the following are essential:

#### Must Have
- ISO 55000-aligned asset registry with unique IDs
- Multi-GAAP depreciation engine (US GAAP + IFRS)
- Complete audit trail with immutability
- Role-based access control with segregation of duties
- Asset lifecycle state machine
- Document management and attachment
- Workflow engine with approvals
- GDPR-compliant data architecture
- EU/US localization (languages, currencies, formats)
- Environmental compliance tracking (WEEE, RoHS, REACH)
- OSHA safety data integration
- SOX-compliant change management

#### Should Have
- IFRS 16 lease management
- EU Taxonomy reporting
- Management of change (MOC) procedures
- Calibration management
- Predictive maintenance integration points
- Mobile work order management
- Multi-entity consolidation
- Data portability (GDPR Article 20)
- Consent management
- Data retention automation

#### Nice to Have
- AI-driven failure prediction
- Digital twin integration
- IoT sensor management
- Augmented reality maintenance support
- Blockchain for audit trail
- ESG scorecard dashboard
- Supplier compliance portal

---

## Appendix A: Compliance Mapping Matrix

| Requirement | ISO 55000 | GAAP/IFRS | WEEE/RoHS | SOX | OSHA | GDPR | GAMP 5 |
|-------------|-----------|-----------|-----------|-----|------|------|--------|
| Unique Asset ID | ● | ● | ● | ● | ● | | |
| Depreciation | | ● | | ● | | | |
| Audit Trail | ● | ● | | ● | | ● | ● |
| Access Control | ● | ● | | ● | ● | ● | ● |
| Asset Registry | ● | ● | ● | | ● | | |
| Lifecycle Tracking | ● | | ● | | ● | | |
| Document Management | ● | | | | ● | | ● |
| Change Management | ● | | | ● | ● | | ● |
| Safety Equipment | | | | | ● | | |
| Environmental | | | ● | | | | |
| Data Privacy | | | | | | ● | |
| Validation | | | | | | | ● |

● = Primary regulation | ○ = Secondary relevance

---

## Appendix B: Key Standards and Regulations Reference

### Accounting Standards
- ASC 360 - Property, Plant, and Equipment (FASB)
- IAS 16 - Property, Plant and Equipment (IASB)
- IAS 36 - Impairment of Assets (IASB)
- IFRS 16 - Leases (IASB)
- ASC 842 - Leases (FASB)

### EU Environmental Directives
- Directive 2012/19/EU - WEEE
- Directive 2011/65/EU - RoHS
- Regulation (EC) 1907/2006 - REACH
- Regulation (EU) 2020/852 - EU Taxonomy

### US Environmental Regulations
- 40 CFR Parts 260-270 - RCRA
- 15 USC 2601-2692 - TSCA

### US Regulations
- Sarbanes-Oxley Act of 2002
- 29 CFR 1910 - OSHA General Industry

### EU Regulations
- Regulation (EU) 2016/679 - GDPR

### Industry Standards
- ISO 55000:2014 - Asset Management Overview
- ISO 55001:2014 - Asset Management System Requirements
- ISO 55002:2014 - Asset Management System Guidelines
- GAMP 5:2008 - Good Automated Manufacturing Practice

---

*This document is intended as a reference for compliance evaluation. Organizations should consult with legal and regulatory experts for specific compliance determinations.*
