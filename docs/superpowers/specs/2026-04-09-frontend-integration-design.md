# Frontend Integration with Ant Design React - Technical Design

**Project:** Multinational Fixed Asset Management System  
**Version:** 1.0  
**Date:** 2026-04-09  
**Status:** Approved

---

## 1. Technical Stack

| Component | Technology |
|-----------|------------|
| Frontend Framework | React 18 + Vite |
| UI Component Library | Ant Design 5.x |
| HTTP Client | Axios |
| Routing | React Router 6 |
| State Management | React Context |
| Backend | Spring Boot 3.2.4 (existing) |
| Database | MySQL (existing) |

---

## 2. Project Structure

### Backend (Existing)
```
code/src/main/
├── java/com/ams/
│   ├── config/
│   │   └── CorsConfig.java          # NEW - CORS configuration
│   └── modules/assetcentral/         # Existing: Asset, WorkOrder CRUD
├── resources/
│   ├── application.yml
│   ├── static/                      # NEW - React build output
│   └── db/scripts/                  # NEW - Database scripts
│       ├── V1__init_schema.sql
│       └── V2__init_data.sql
```

### Frontend (New)
```
frontend/                              # NEW - React application
├── src/
│   ├── api/
│   │   ├── axios.ts                # Axios instance with interceptors
│   │   ├── assetApi.ts            # Asset API calls
│   │   └── workOrderApi.ts         # WorkOrder API calls
│   ├── pages/
│   │   ├── Dashboard/
│   │   │   └── Dashboard.tsx       # Main dashboard
│   │   ├── Asset/
│   │   │   ├── AssetList.tsx      # Asset listing page
│   │   │   ├── AssetDetail.tsx     # Asset detail page
│   │   │   └── AssetForm.tsx       # Asset create/edit form
│   │   └── WorkOrder/
│   │       ├── WorkOrderList.tsx  # WorkOrder listing
│   │       ├── WorkOrderDetail.tsx # WorkOrder detail
│   │       └── WorkOrderForm.tsx  # WorkOrder create/edit
│   ├── components/
│   │   └── Layout/
│   │       ├── MainLayout.tsx      # Main layout with sidebar
│   │       └── Header.tsx          # Header component
│   ├── context/
│   │   └── AppContext.tsx          # Global app context
│   ├── types/
│   │   └── index.ts                # TypeScript interfaces
│   ├── App.tsx
│   └── main.tsx
├── package.json
├── vite.config.ts
└── tsconfig.json
```

---

## 3. API Integration

### CORS Configuration
```java
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5173", "http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
}
```

### Frontend API Layer
```typescript
// axios.ts
import axios from 'axios';

const api = axios.create({
  baseURL: '/api/v1',
  timeout: 30000,
});

api.interceptors.response.use(
  response => response.data,
  error => {
    const message = error.response?.data?.message || 'An error occurred';
    return Promise.reject(new Error(message));
  }
);

export default api;
```

---

## 4. Database Scripts

### V1__init_schema.sql
```sql
-- Asset Central Schema

CREATE TABLE IF NOT EXISTS asset (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    asset_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    serial_number VARCHAR(100),
    asset_type VARCHAR(50),
    category VARCHAR(100),
    manufacturer VARCHAR(255),
    model VARCHAR(100),
    manufacture_date DATE,
    purchase_date DATE,
    purchase_cost DECIMAL(15,2),
    book_value DECIMAL(15,2),
    residual_value DECIMAL(15,2),
    useful_life_years INT,
    depreciation_method VARCHAR(50),
    status VARCHAR(50) DEFAULT 'ACTIVE',
    location VARCHAR(255),
    criticality VARCHAR(20),
    barcode VARCHAR(100),
    qr_code VARCHAR(255),
    rfid_tag VARCHAR(100),
    warranty_expiry DATE,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS work_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    work_order_number VARCHAR(50) UNIQUE NOT NULL,
    asset_id BIGINT NOT NULL,
    description TEXT NOT NULL,
    work_order_type VARCHAR(50),
    priority VARCHAR(20) DEFAULT 'MEDIUM',
    status VARCHAR(50) DEFAULT 'PENDING',
    assigned_technician VARCHAR(100),
    scheduled_start_date DATE,
    scheduled_end_date DATE,
    actual_start_date DATE,
    actual_end_date DATE,
    estimated_hours DECIMAL(10,2),
    actual_hours DECIMAL(10,2),
    labor_cost DECIMAL(15,2),
    parts_cost DECIMAL(15,2),
    total_cost DECIMAL(15,2),
    work_order_source VARCHAR(50),
    failure_code VARCHAR(50),
    root_cause VARCHAR(255),
    resolution_notes TEXT,
    asset_downtime_hours DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100),
    version BIGINT DEFAULT 0,
    FOREIGN KEY (asset_id) REFERENCES asset(id)
);

-- Indexes
CREATE INDEX idx_asset_number ON asset(asset_number);
CREATE INDEX idx_asset_status ON asset(status);
CREATE INDEX idx_work_order_number ON work_order(work_order_number);
CREATE INDEX idx_work_order_status ON work_order(status);
CREATE INDEX idx_work_order_asset ON work_order(asset_id);
```

### V2__init_data.sql
```sql
-- Sample Data

INSERT INTO asset (asset_number, name, description, asset_type, category, status, location, purchase_cost, book_value) VALUES
('AST-001', 'CNC Machine #1', '5-axis CNC machining center', 'Equipment', 'Machinery', 'ACTIVE', 'Plant A - Building 1', 250000.00, 200000.00),
('AST-002', 'Overhead Crane 5T', '5-ton overhead crane for assembly', 'Equipment', 'Material Handling', 'ACTIVE', 'Plant A - Building 1', 85000.00, 68000.00),
('AST-003', 'Injection Molding Press', '500-ton injection molding machine', 'Equipment', 'Manufacturing', 'ACTIVE', 'Plant B - Production', 180000.00, 144000.00),
('AST-004', 'Forklift #1', 'Electric forklift for warehouse', 'Vehicles', 'Logistics', 'ACTIVE', 'Warehouse', 35000.00, 28000.00),
('AST-005', 'Coordinate Measuring Machine', 'CMM for quality inspection', 'Equipment', 'Quality Control', 'ACTIVE', 'Plant A - QC Lab', 120000.00, 96000.00);

INSERT INTO work_order (work_order_number, asset_id, description, work_order_type, priority, status, assigned_technician) VALUES
('WO-2026-001', 1, 'Quarterly preventive maintenance - lubrication and inspection', 'PREVENTIVE', 'MEDIUM', 'PENDING', 'John Smith'),
('WO-2026-002', 1, 'Spindle bearing replacement due to wear', 'CORRECTIVE', 'HIGH', 'IN_PROGRESS', 'Mike Johnson'),
('WO-2026-003', 2, 'Emergency brake inspection and certification', 'INSPECTION', 'EMERGENCY', 'PENDING', NULL),
('WO-2026-004', 3, 'Hydraulic system check and oil change', 'PREVENTIVE', 'MEDIUM', 'COMPLETED', 'Tom Wilson'),
('WO-2026-005', 5, 'Annual calibration certification', 'CALIBRATION', 'LOW', 'COMPLETED', 'John Smith');
```

---

## 5. Implementation Scope (Phase 1)

### Pages to Implement
1. **Dashboard** - Main entry with statistics cards, recent work orders
2. **Asset List** - Table with search, filter, pagination
3. **Asset Detail** - View asset information with work order history
4. **Asset Create/Edit** - Form for creating/updating assets
5. **WorkOrder List** - Table with search, filter, status badges
6. **WorkOrder Detail** - View work order with asset info
7. **WorkOrder Create/Edit** - Form for creating/updating work orders

### Components
1. **MainLayout** - Sidebar navigation + header
2. **AssetTable** - Reusable asset data table
3. **WorkOrderTable** - Reusable work order data table
4. **StatCard** - Dashboard statistics card
5. **StatusBadge** - Colored status indicators

---

## 6. Build & Deployment

### Development Mode
```bash
# Terminal 1: Backend
cd code && mvn spring-boot:run

# Terminal 2: Frontend
cd frontend && npm run dev
```

### Production Build
```bash
# Build frontend
cd frontend && npm run build

# Copy to Spring Boot static
cp -r frontend/dist/* code/src/main/resources/static/

# Package Spring Boot
cd code && mvn package -DskipTests
```

---

## 7. Acceptance Criteria

### Functional
- [ ] Dashboard displays asset and work order statistics
- [ ] Asset CRUD operations work via Ant Design forms and tables
- [ ] WorkOrder CRUD operations work via Ant Design forms and tables
- [ ] Navigation between pages works correctly
- [ ] API errors are displayed as Ant Design notifications

### Technical
- [ ] CORS is properly configured for development
- [ ] All API calls use proper error handling
- [ ] TypeScript types match backend DTOs
- [ ] Build produces production-ready static files

---

*Document approved: 2026-04-09*
*Next step: Create implementation plan*
