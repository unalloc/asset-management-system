# Asset Management System - Product Requirements Document

## Document Overview

This repository contains the complete product requirements for an Asset Management System designed for multinational manufacturing corporations with multiple factories.

## Document Structure

```
spec/
├── README.md                          # This file - main index
├── 1-overview/                        # Project overview and objectives
├── 2-asset-registration/              # Asset Registration & Cataloging (13 requirements)
├── 3-asset-tracking/                  # Asset Tracking & Monitoring (14 requirements)
├── 4-maintenance/                     # Maintenance Management (14 requirements)
├── 5-financial/                       # Financial Management (14 requirements)
├── 6-multi-plant/                     # Multi-Plant & Manufacturing Compliance (10 requirements)
├── 7-lifecycle/                       # Asset Lifecycle Management (18 requirements)
├── 8-utilization/                     # Asset Utilization & Allocation (18 requirements)
├── 9-multi-company/                   # Multi-Company Group Management (18 requirements)
├── 10-domestic-compliance/            # Domestic Compliance & Localization (15 requirements)
├── 11-user-stories/                   # User Stories (74 stories)
└── supplementary/                     # Reference materials
```

## Module Summary

| Module | Name | Requirements |
|--------|------|-------------|
| 1 | Overview | Project background, objectives, target users |
| 2 | Asset Registration & Cataloging | 13 functional requirements |
| 3 | Asset Tracking & Monitoring | 14 functional requirements |
| 4 | Maintenance Management | 14 functional requirements |
| 5 | Financial Management | 14 functional requirements |
| 6 | Multi-Plant & Manufacturing Compliance | 10 functional requirements |
| 7 | Asset Lifecycle Management | 18 functional requirements |
| 8 | Asset Utilization & Allocation | 18 functional requirements |
| 9 | Multi-Company Group Management | 18 functional requirements |
| 10 | Domestic Compliance & Localization | 15 functional requirements |
| **Total** | | **134 functional requirements** |

## How to Navigate

1. **For high-level understanding**: Start with `1-overview/` to understand project context
2. **For functional requirements**: Navigate to the relevant module directory
3. **For detailed specifications**: Each requirement is documented in its own file (e.g., `F-2.1.1.md`)
4. **For user perspectives**: See `11-user-stories/` for use case documentation

## Document Version

- **Version**: 5.0
- **Date**: 2025-04-02
- **Status**: Draft
- **Total Requirements**: 134 functional requirements across 9 modules

## Key Features

### Core Capabilities
- Multi-plant asset registry with hierarchical structure
- Full asset lifecycle management from procurement to disposal
- Real-time asset tracking with IoT integration
- Preventive and predictive maintenance scheduling
- Multi-currency financial management with depreciation calculation
- Comprehensive audit trail and compliance reporting

### Manufacturing Focus
- Equipment hierarchy management (plant → production line → work center → machine)
- OEE (Overall Equipment Effectiveness) calculation
- Downtime tracking with categorization
- Shift-based equipment scheduling
- Production metrics tracking

### Multi-Company Support
- Multi-level organizational hierarchy
- Data isolation by company/entity
- Consolidated group reporting
- Cross-company asset transfers
- Inter-company leasing and cost allocation

### Domestic Compliance (China)
- Fixed asset card format compliant with Ministry of Finance
- Chinese accounting depreciation methods
- Tax accounting differences management
- Integration with domestic tax and banking systems
- WeChat mini-program for mobile inventory counting

---

*This is a pure product definition document focused on business requirements only. No technical implementation details (database schemas, API specifications, or architectural designs) are included.*