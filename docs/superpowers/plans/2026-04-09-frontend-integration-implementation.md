# Frontend Integration with Ant Design React - Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Create React frontend with Ant Design that connects to Spring Boot backend APIs for Module 1 (Asset Central) - Dashboard, Asset CRUD, and WorkOrder CRUD.

**Architecture:** React 18 + Vite frontend with Ant Design 5 components. Backend at `/api/v1` endpoints. Frontend will be built and served as static resources by Spring Boot.

**Tech Stack:** React 18, Vite, Ant Design 5, Axios, React Router 6, TypeScript

---

## File Structure

### Frontend Project
```
frontend/
├── package.json                      # Dependencies
├── vite.config.ts                   # Vite config
├── tsconfig.json                    # TypeScript config
├── index.html                       # Entry HTML
└── src/
    ├── main.tsx                     # React entry
    ├── App.tsx                      # Root component
    ├── api/
    │   ├── axios.ts                # Axios instance
    │   ├── assetApi.ts             # Asset API calls
    │   └── workOrderApi.ts        # WorkOrder API calls
    ├── pages/
    │   ├── Dashboard/
    │   │   └── Dashboard.tsx
    │   ├── Asset/
    │   │   ├── AssetList.tsx
    │   │   ├── AssetDetail.tsx
    │   │   └── AssetForm.tsx
    │   └── WorkOrder/
    │       ├── WorkOrderList.tsx
    │       ├── WorkOrderDetail.tsx
    │       └── WorkOrderForm.tsx
    ├── components/
    │   └── Layout/
    │       ├── MainLayout.tsx
    │       └── Header.tsx
    ├── context/
    │   └── AppContext.tsx
    └── types/
        └── index.ts
```

### Backend Modifications
```
code/src/main/java/com/ams/
├── config/
│   └── CorsConfig.java            # NEW - CORS configuration
└── resources/
    └── db/scripts/                # NEW - Database scripts
        ├── V1__init_schema.sql
        └── V2__init_data.sql
```

---

## Task 1: Initialize React Project with Vite

**Files:**
- Create: `frontend/package.json`
- Create: `frontend/vite.config.ts`
- Create: `frontend/tsconfig.json`
- Create: `frontend/index.html`

---

### Task 1.1: Create package.json

- [ ] **Step 1: Create frontend directory and package.json**

```json
{
  "name": "ams-frontend",
  "private": true,
  "version": "1.0.0",
  "type": "module",
  "scripts": {
    "dev": "vite",
    "build": "tsc && vite build",
    "preview": "vite preview"
  },
  "dependencies": {
    "react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-router-dom": "^6.22.0",
    "antd": "^5.14.0",
    "@ant-design/icons": "^5.3.0",
    "axios": "^1.6.7"
  },
  "devDependencies": {
    "@types/react": "^18.2.55",
    "@types/react-dom": "^18.2.19",
    "@vitejs/plugin-react": "^4.2.1",
    "typescript": "^5.3.3",
    "vite": "^5.1.0"
  }
}
```

- [ ] **Step 2: Create vite.config.ts**

```typescript
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
      },
    },
  },
  build: {
    outDir: '../code/src/main/resources/static',
    emptyOutDir: true,
  },
})
```

- [ ] **Step 3: Create tsconfig.json**

```json
{
  "compilerOptions": {
    "target": "ES2020",
    "useDefineForClassFields": true,
    "lib": ["ES2020", "DOM", "DOM.Iterable"],
    "module": "ESNext",
    "skipLibCheck": true,
    "moduleResolution": "bundler",
    "allowImportingTsExtensions": true,
    "resolveJsonModule": true,
    "isolatedModules": true,
    "noEmit": true,
    "jsx": "react-jsx",
    "strict": true,
    "noUnusedLocals": true,
    "noUnusedParameters": true,
    "noFallthroughCasesInSwitch": true
  },
  "include": ["src"],
  "references": [{ "path": "./tsconfig.node.json" }]
}
```

- [ ] **Step 4: Create index.html**

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Asset Management System</title>
  </head>
  <body>
    <div id="root"></div>
    <script type="module" src="/src/main.tsx"></script>
  </body>
</html>
```

- [ ] **Step 5: Install dependencies**

```bash
cd frontend && npm install
```

- [ ] **Step 6: Commit**
```bash
cd frontend && git init && git add package.json vite.config.ts tsconfig.json index.html && git commit -m "feat: initialize React project with Vite and Ant Design"
```

---

## Task 2: Create Backend CORS Configuration

**Files:**
- Create: `code/src/main/java/com/ams/config/CorsConfig.java`
- Create: `code/src/main/java/com/ams/config/WebConfig.java`

---

### Task 2.1: Create CorsConfig

- [ ] **Step 1: Create config directory**
```bash
mkdir -p code/src/main/java/com/ams/config
```

- [ ] **Step 2: Create CorsConfig.java**

```java
package com.ams.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        
        source.registerCorsConfiguration("/api/**", config);
        return new CorsFilter(source);
    }
}
```

- [ ] **Step 3: Commit**
```bash
cd code && git add src/main/java/com/ams/config/CorsConfig.java && git commit -m "feat: add CORS configuration for frontend integration"
```

---

## Task 3: Create TypeScript Types

**Files:**
- Create: `frontend/src/types/index.ts`

---

### Task 3.1: Create TypeScript Types

- [ ] **Step 1: Create types directory**
```bash
mkdir -p frontend/src/types
```

- [ ] **Step 2: Create index.ts**

```typescript
export interface Asset {
  id?: number;
  assetNumber: string;
  name: string;
  description?: string;
  serialNumber?: string;
  assetType?: string;
  category?: string;
  manufacturer?: string;
  model?: string;
  manufactureDate?: string;
  purchaseDate?: string;
  purchaseCost?: number;
  bookValue?: number;
  residualValue?: number;
  usefulLifeYears?: number;
  depreciationMethod?: string;
  status?: string;
  location?: string;
  criticality?: string;
  barcode?: string;
  qrCode?: string;
  rfidTag?: string;
  warrantyExpiry?: string;
  notes?: string;
  createdAt?: string;
  updatedAt?: string;
}

export interface WorkOrder {
  id?: number;
  workOrderNumber: string;
  assetId: number;
  assetName?: string;
  description: string;
  workOrderType?: string;
  priority?: string;
  status?: string;
  assignedTechnician?: string;
  scheduledStartDate?: string;
  scheduledEndDate?: string;
  actualStartDate?: string;
  actualEndDate?: string;
  estimatedHours?: number;
  actualHours?: number;
  laborCost?: number;
  partsCost?: number;
  totalCost?: number;
  workOrderSource?: string;
  failureCode?: string;
  rootCause?: string;
  resolutionNotes?: string;
  assetDowntimeHours?: number;
  createdAt?: string;
  updatedAt?: string;
}

export interface ApiResponse<T> {
  success: boolean;
  data: T;
  message?: string;
  timestamp: string;
}

export interface CreateAssetRequest {
  assetNumber: string;
  name: string;
  description?: string;
  serialNumber?: string;
  assetType?: string;
  category?: string;
  manufacturer?: string;
  model?: string;
  manufactureDate?: string;
  purchaseDate?: string;
  purchaseCost?: number;
  residualValue?: number;
  usefulLifeYears?: number;
  depreciationMethod?: string;
  status?: string;
  location?: string;
  criticality?: string;
  barcode?: string;
  qrCode?: string;
  rfidTag?: string;
  warrantyExpiry?: string;
  notes?: string;
}

export interface UpdateAssetRequest {
  name?: string;
  description?: string;
  serialNumber?: string;
  assetType?: string;
  category?: string;
  manufacturer?: string;
  model?: string;
  manufactureDate?: string;
  purchaseDate?: string;
  purchaseCost?: number;
  bookValue?: number;
  residualValue?: number;
  usefulLifeYears?: number;
  depreciationMethod?: string;
  status?: string;
  location?: string;
  criticality?: string;
  barcode?: string;
  qrCode?: string;
  rfidTag?: string;
  warrantyExpiry?: string;
  notes?: string;
}

export interface CreateWorkOrderRequest {
  workOrderNumber: string;
  assetId: number;
  description: string;
  workOrderType?: string;
  priority?: string;
  assignedTechnician?: string;
  scheduledStartDate?: string;
  scheduledEndDate?: string;
  estimatedHours?: number;
  workOrderSource?: string;
  failureCode?: string;
}

export interface UpdateWorkOrderRequest {
  description?: string;
  workOrderType?: string;
  priority?: string;
  status?: string;
  assignedTechnician?: string;
  scheduledStartDate?: string;
  scheduledEndDate?: string;
  actualStartDate?: string;
  actualEndDate?: string;
  estimatedHours?: number;
  actualHours?: number;
  laborCost?: number;
  partsCost?: number;
  totalCost?: number;
  workOrderSource?: string;
  failureCode?: string;
  rootCause?: string;
  resolutionNotes?: string;
  assetDowntimeHours?: number;
}
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/types/index.ts && git commit -m "feat: add TypeScript types for Asset and WorkOrder"
```

---

## Task 4: Create API Layer

**Files:**
- Create: `frontend/src/api/axios.ts`
- Create: `frontend/src/api/assetApi.ts`
- Create: `frontend/src/api/workOrderApi.ts`

---

### Task 4.1: Create axios Instance

- [ ] **Step 1: Create api directory**
```bash
mkdir -p frontend/src/api
```

- [ ] **Step 2: Create axios.ts**

```typescript
import axios from 'axios';
import { message } from 'antd';

const api = axios.create({
  baseURL: '/api/v1',
  timeout: 30000,
});

api.interceptors.response.use(
  (response) => response.data,
  (error) => {
    const errorMessage = error.response?.data?.message || error.message || 'An error occurred';
    message.error(errorMessage);
    return Promise.reject(error);
  }
);

export default api;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/api/axios.ts && git commit -m "feat: add axios instance with error handling"
```

---

### Task 4.2: Create Asset API

- [ ] **Step 1: Create assetApi.ts**

```typescript
import api from './axios';
import { Asset, CreateAssetRequest, UpdateAssetRequest, ApiResponse } from '../types';

export const assetApi = {
  getAll: async (): Promise<Asset[]> => {
    const response = await api.get<ApiResponse<Asset[]>>('/assets');
    return response.data || [];
  },

  getById: async (id: number): Promise<Asset> => {
    return api.get<Asset>(`/assets/${id}`);
  },

  getByNumber: async (assetNumber: string): Promise<Asset> => {
    return api.get<Asset>(`/assets/number/${assetNumber}`);
  },

  getByStatus: async (status: string): Promise<Asset[]> => {
    return api.get<Asset[]>(`/assets/status/${status}`);
  },

  search: async (keyword: string): Promise<Asset[]> => {
    return api.get<Asset[]>('/assets/search', { params: { keyword } });
  },

  create: async (data: CreateAssetRequest): Promise<Asset> => {
    return api.post<Asset>('/assets', data);
  },

  update: async (id: number, data: UpdateAssetRequest): Promise<Asset> => {
    return api.put<Asset>(`/assets/${id}`, data);
  },

  delete: async (id: number): Promise<void> => {
    return api.delete(`/assets/${id}`);
  },
};
```

- [ ] **Step 4: Commit**
```bash
cd frontend && git add src/api/assetApi.ts && git commit -m "feat: add Asset API functions"
```

---

### Task 4.3: Create WorkOrder API

- [ ] **Step 1: Create workOrderApi.ts**

```typescript
import api from './axios';
import { WorkOrder, CreateWorkOrderRequest, UpdateWorkOrderRequest, ApiResponse } from '../types';

export const workOrderApi = {
  getAll: async (): Promise<WorkOrder[]> => {
    const response = await api.get<ApiResponse<WorkOrder[]>>('/work-orders');
    return response.data || [];
  },

  getById: async (id: number): Promise<WorkOrder> => {
    return api.get<WorkOrder>(`/work-orders/${id}`);
  },

  getByNumber: async (workOrderNumber: string): Promise<WorkOrder> => {
    return api.get<WorkOrder>(`/work-orders/number/${workOrderNumber}`);
  },

  getByAssetId: async (assetId: number): Promise<WorkOrder[]> => {
    return api.get<WorkOrder[]>(`/work-orders/asset/${assetId}`);
  },

  getByStatus: async (status: string): Promise<WorkOrder[]> => {
    return api.get<WorkOrder[]>(`/work-orders/status/${status}`);
  },

  create: async (data: CreateWorkOrderRequest): Promise<WorkOrder> => {
    return api.post<WorkOrder>('/work-orders', data);
  },

  update: async (id: number, data: UpdateWorkOrderRequest): Promise<WorkOrder> => {
    return api.put<WorkOrder>(`/work-orders/${id}`, data);
  },

  updateStatus: async (id: number, status: string): Promise<WorkOrder> => {
    return api.patch<WorkOrder>(`/work-orders/${id}/status`, null, { params: { status } });
  },

  complete: async (id: number): Promise<WorkOrder> => {
    return api.patch<WorkOrder>(`/work-orders/${id}/complete`);
  },

  delete: async (id: number): Promise<void> => {
    return api.delete(`/work-orders/${id}`);
  },
};
```

- [ ] **Step 5: Commit**
```bash
cd frontend && git add src/api/workOrderApi.ts && git commit -m "feat: add WorkOrder API functions"
```

---

## Task 5: Create Layout Components

**Files:**
- Create: `frontend/src/components/Layout/MainLayout.tsx`
- Create: `frontend/src/components/Layout/Header.tsx`

---

### Task 5.1: Create MainLayout

- [ ] **Step 1: Create components directory**
```bash
mkdir -p frontend/src/components/Layout
```

- [ ] **Step 2: Create MainLayout.tsx**

```tsx
import React from 'react';
import { Layout, Menu } from 'antd';
import { useNavigate, useLocation } from 'react-router-dom';
import {
  DashboardOutlined,
  AppstoreOutlined,
  ToolOutlined,
  SettingOutlined,
} from '@ant-design/icons';

const { Sider, Content } = Layout;

const MainLayout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const navigate = useNavigate();
  const location = useLocation();

  const menuItems = [
    {
      key: '/dashboard',
      icon: <DashboardOutlined />,
      label: 'Dashboard',
    },
    {
      key: '/assets',
      icon: <AppstoreOutlined />,
      label: 'Assets',
    },
    {
      key: '/work-orders',
      icon: <ToolOutlined />,
      label: 'Work Orders',
    },
  ];

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sider theme="light" width={220}>
        <div style={{ height: 64, display: 'flex', alignItems: 'center', justifyContent: 'center', borderBottom: '1px solid #f0f0f0' }}>
          <h2 style={{ margin: 0 }}>AMS</h2>
        </div>
        <Menu
          mode="inline"
          selectedKeys={[location.pathname]}
          items={menuItems}
          onClick={({ key }) => navigate(key)}
        />
      </Sider>
      <Layout>
        <Content style={{ padding: 24 }}>
          {children}
        </Content>
      </Layout>
    </Layout>
  );
};

export default MainLayout;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/components/Layout/MainLayout.tsx && git commit -m "feat: add MainLayout component with sidebar navigation"
```

---

## Task 6: Create Dashboard Page

**Files:**
- Create: `frontend/src/pages/Dashboard/Dashboard.tsx`

---

### Task 6.1: Create Dashboard

- [ ] **Step 1: Create pages directory**
```bash
mkdir -p frontend/src/pages/Dashboard frontend/src/pages/Asset frontend/src/pages/WorkOrder
```

- [ ] **Step 2: Create Dashboard.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Row, Col, Card, Statistic, Table, Tag } from 'antd';
import { assetApi } from '../../api/assetApi';
import { workOrderApi } from '../../api/workOrderApi';
import { Asset, WorkOrder } from '../../types';
import { useNavigate } from 'react-router-dom';

const Dashboard: React.FC = () => {
  const navigate = useNavigate();
  const [assets, setAssets] = useState<Asset[]>([]);
  const [workOrders, setWorkOrders] = useState<WorkOrder[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [assetData, woData] = await Promise.all([
          assetApi.getAll(),
          workOrderApi.getAll(),
        ]);
        setAssets(assetData);
        setWorkOrders(woData);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, []);

  const activeAssets = assets.filter(a => a.status === 'ACTIVE').length;
  const pendingWorkOrders = workOrders.filter(wo => wo.status === 'PENDING').length;
  const inProgressWorkOrders = workOrders.filter(wo => wo.status === 'IN_PROGRESS').length;
  const completedWorkOrders = workOrders.filter(wo => wo.status === 'COMPLETED').length;

  const workOrderColumns = [
    {
      title: 'WO Number',
      dataIndex: 'workOrderNumber',
      key: 'workOrderNumber',
      render: (text: string, record: WorkOrder) => (
        <a onClick={() => navigate(`/work-orders/${record.id}`)}>{text}</a>
      ),
    },
    {
      title: 'Asset ID',
      dataIndex: 'assetId',
      key: 'assetId',
    },
    {
      title: 'Description',
      dataIndex: 'description',
      key: 'description',
      ellipsis: true,
    },
    {
      title: 'Priority',
      dataIndex: 'priority',
      key: 'priority',
      render: (priority: string) => {
        const colors: Record<string, string> = {
          EMERGENCY: 'red',
          HIGH: 'orange',
          MEDIUM: 'blue',
          LOW: 'green',
        };
        return <Tag color={colors[priority] || 'default'}>{priority}</Tag>;
      },
    },
    {
      title: 'Status',
      dataIndex: 'status',
      key: 'status',
      render: (status: string) => {
        const colors: Record<string, string> = {
          PENDING: 'default',
          IN_PROGRESS: 'processing',
          COMPLETED: 'success',
        };
        return <Tag color={colors[status] || 'default'}>{status}</Tag>;
      },
    },
  ];

  return (
    <div>
      <h1 style={{ marginBottom: 24 }}>Dashboard</h1>
      
      <Row gutter={16} style={{ marginBottom: 24 }}>
        <Col span={6}>
          <Card>
            <Statistic title="Total Assets" value={assets.length} loading={loading} />
          </Card>
        </Col>
        <Col span={6}>
          <Card>
            <Statistic title="Active Assets" value={activeAssets} loading={loading} />
          </Card>
        </Col>
        <Col span={6}>
          <Card>
            <Statistic title="Pending Work Orders" value={pendingWorkOrders} loading={loading} />
          </Card>
        </Col>
        <Col span={6}>
          <Card>
            <Statistic title="In Progress" value={inProgressWorkOrders} loading={loading} />
          </Card>
        </Col>
      </Row>

      <Card title="Recent Work Orders" extra={<a onClick={() => navigate('/work-orders')}>View All</a>}>
        <Table
          columns={workOrderColumns}
          dataSource={workOrders.slice(0, 5)}
          rowKey="id"
          loading={loading}
          pagination={false}
        />
      </Card>
    </div>
  );
};

export default Dashboard;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/pages/Dashboard/Dashboard.tsx && git commit -m "feat: add Dashboard page with statistics and recent work orders"
```

---

## Task 7: Create Asset Pages

**Files:**
- Create: `frontend/src/pages/Asset/AssetList.tsx`
- Create: `frontend/src/pages/Asset/AssetDetail.tsx`
- Create: `frontend/src/pages/Asset/AssetForm.tsx`

---

### Task 7.1: Create AssetList

- [ ] **Step 1: Create AssetList.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Table, Button, Input, Space, Tag } from 'antd';
import { useNavigate } from 'react-router-dom';
import { assetApi } from '../../api/assetApi';
import { Asset } from '../../types';
import { PlusOutlined, SearchOutlined } from '@ant-design/icons';

const AssetList: React.FC = () => {
  const navigate = useNavigate();
  const [assets, setAssets] = useState<Asset[]>([]);
  const [loading, setLoading] = useState(true);
  const [searchText, setSearchText] = useState('');

  useEffect(() => {
    fetchAssets();
  }, []);

  const fetchAssets = async () => {
    try {
      const data = await assetApi.getAll();
      setAssets(data);
    } finally {
      setLoading(false);
    }
  };

  const filteredAssets = searchText
    ? assets.filter(a => 
        a.name?.toLowerCase().includes(searchText.toLowerCase()) ||
        a.assetNumber?.toLowerCase().includes(searchText.toLowerCase()) ||
        a.serialNumber?.toLowerCase().includes(searchText.toLowerCase()))
    : assets;

  const columns = [
    {
      title: 'Asset Number',
      dataIndex: 'assetNumber',
      key: 'assetNumber',
      render: (text: string, record: Asset) => (
        <a onClick={() => navigate(`/assets/${record.id}`)}>{text}</a>
      ),
    },
    {
      title: 'Name',
      dataIndex: 'name',
      key: 'name',
    },
    {
      title: 'Type',
      dataIndex: 'assetType',
      key: 'assetType',
    },
    {
      title: 'Status',
      dataIndex: 'status',
      key: 'status',
      render: (status: string) => {
        const colors: Record<string, string> = {
          ACTIVE: 'success',
          INACTIVE: 'default',
          MAINTENANCE: 'warning',
          RETIRED: 'error',
        };
        return <Tag color={colors[status] || 'default'}>{status}</Tag>;
      },
    },
    {
      title: 'Location',
      dataIndex: 'location',
      key: 'location',
    },
  ];

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16 }}>
        <h1>Assets</h1>
        <Button type="primary" icon={<PlusOutlined />} onClick={() => navigate('/assets/new')}>
          New Asset
        </Button>
      </div>

      <Space style={{ marginBottom: 16 }}>
        <Input
          placeholder="Search assets..."
          prefix={<SearchOutlined />}
          value={searchText}
          onChange={e => setSearchText(e.target.value)}
          style={{ width: 300 }}
        />
      </Space>

      <Table
        columns={columns}
        dataSource={filteredAssets}
        rowKey="id"
        loading={loading}
      />
    </div>
  );
};

export default AssetList;
```

- [ ] **Step 2: Commit**
```bash
cd frontend && git add src/pages/Asset/AssetList.tsx && git commit -m "feat: add AssetList page with search and table"
```

---

### Task 7.2: Create AssetDetail

- [ ] **Step 1: Create AssetDetail.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Card, Descriptions, Button, Space, Spin, Table, Tag } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import { assetApi } from '../../api/assetApi';
import { workOrderApi } from '../../api/workOrderApi';
import { Asset, WorkOrder } from '../../types';
import { EditOutlined, ArrowLeftOutlined } from '@ant-design/icons';

const AssetDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [asset, setAsset] = useState<Asset | null>(null);
  const [workOrders, setWorkOrders] = useState<WorkOrder[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        if (id && id !== 'new') {
          const [assetData, woData] = await Promise.all([
            assetApi.getById(Number(id)),
            workOrderApi.getByAssetId(Number(id)),
          ]);
          setAsset(assetData);
          setWorkOrders(woData);
        }
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [id]);

  if (loading) return <Spin />;
  if (!asset) return <div>Asset not found</div>;

  const statusColors: Record<string, string> = {
    ACTIVE: 'success',
    INACTIVE: 'default',
    MAINTENANCE: 'warning',
    RETIRED: 'error',
  };

  const woColumns = [
    { title: 'WO Number', dataIndex: 'workOrderNumber', key: 'workOrderNumber' },
    { title: 'Description', dataIndex: 'description', key: 'description', ellipsis: true },
    { title: 'Status', dataIndex: 'status', key: 'status',
      render: (status: string) => <Tag>{status}</Tag> },
    { title: 'Priority', dataIndex: 'priority', key: 'priority' },
  ];

  return (
    <div>
      <Space style={{ marginBottom: 16 }}>
        <Button icon={<ArrowLeftOutlined />} onClick={() => navigate('/assets')}>Back</Button>
        <Button icon={<EditOutlined />} onClick={() => navigate(`/assets/${id}/edit`)}>Edit</Button>
      </Space>

      <Card title="Asset Information">
        <Descriptions column={2}>
          <Descriptions.Item label="Asset Number">{asset.assetNumber}</Descriptions.Item>
          <Descriptions.Item label="Name">{asset.name}</Descriptions.Item>
          <Descriptions.Item label="Type">{asset.assetType}</Descriptions.Item>
          <Descriptions.Item label="Category">{asset.category}</Descriptions.Item>
          <Descriptions.Item label="Status">
            <Tag color={statusColors[asset.status || '']}>{asset.status}</Tag>
          </Descriptions.Item>
          <Descriptions.Item label="Location">{asset.location}</Descriptions.Item>
          <Descriptions.Item label="Manufacturer">{asset.manufacturer}</Descriptions.Item>
          <Descriptions.Item label="Model">{asset.model}</Descriptions.Item>
          <Descriptions.Item label="Serial Number">{asset.serialNumber}</Descriptions.Item>
          <Descriptions.Item label="Purchase Cost">${asset.purchaseCost?.toLocaleString()}</Descriptions.Item>
          <Descriptions.Item label="Book Value">${asset.bookValue?.toLocaleString()}</Descriptions.Item>
        </Descriptions>
      </Card>

      <Card title="Work Orders" style={{ marginTop: 16 }}>
        <Table
          columns={woColumns}
          dataSource={workOrders}
          rowKey="id"
          pagination={false}
        />
      </Card>
    </div>
  );
};

export default AssetDetail;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/pages/Asset/AssetDetail.tsx && git commit -m "feat: add AssetDetail page with information and work orders"
```

---

### Task 7.3: Create AssetForm

- [ ] **Step 1: Create AssetForm.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Form, Input, Select, DatePicker, InputNumber, Button, Card, Row, Col, message } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import { assetApi } from '../../api/assetApi';
import { Asset, CreateAssetRequest, UpdateAssetRequest } from '../../types';
import dayjs from 'dayjs';

const { Option } = Select;

const AssetForm: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const [initialLoading, setInitialLoading] = useState(id !== 'new');

  const isEdit = id && id !== 'new';

  useEffect(() => {
    if (isEdit) {
      const fetchAsset = async () => {
        try {
          const data = await assetApi.getById(Number(id));
          form.setFieldsValue({
            ...data,
            manufactureDate: data.manufactureDate ? dayjs(data.manufactureDate) : undefined,
            purchaseDate: data.purchaseDate ? dayjs(data.purchaseDate) : undefined,
            warrantyExpiry: data.warrantyExpiry ? dayjs(data.warrantyExpiry) : undefined,
          });
        } catch {
          message.error('Failed to load asset');
        } finally {
          setInitialLoading(false);
        }
      };
      fetchAsset();
    } else {
      setInitialLoading(false);
    }
  }, [id, isEdit, form]);

  const onFinish = async (values: any) => {
    setLoading(true);
    try {
      const data: CreateAssetRequest | UpdateAssetRequest = {
        ...values,
        manufactureDate: values.manufactureDate?.format('YYYY-MM-DD'),
        purchaseDate: values.purchaseDate?.format('YYYY-MM-DD'),
        warrantyExpiry: values.warrantyExpiry?.format('YYYY-MM-DD'),
        purchaseCost: values.purchaseCost ? Number(values.purchaseCost) : undefined,
        bookValue: values.bookValue ? Number(values.bookValue) : undefined,
        residualValue: values.residualValue ? Number(values.residualValue) : undefined,
        usefulLifeYears: values.usefulLifeYears ? Number(values.usefulLifeYears) : undefined,
      };

      if (isEdit) {
        await assetApi.update(Number(id), data as UpdateAssetRequest);
        message.success('Asset updated successfully');
      } else {
        await assetApi.create(data as CreateAssetRequest);
        message.success('Asset created successfully');
      }
      navigate('/assets');
    } catch {
      message.error('Failed to save asset');
    } finally {
      setLoading(false);
    }
  };

  if (initialLoading) return <div>Loading...</div>;

  return (
    <Card title={isEdit ? 'Edit Asset' : 'New Asset'}>
      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="assetNumber" label="Asset Number" rules={[{ required: true }]}>
              <Input />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="name" label="Name" rules={[{ required: true }]}>
              <Input />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="assetType" label="Asset Type">
              <Select allowClear>
                <Option value="Equipment">Equipment</Option>
                <Option value="Vehicle">Vehicle</Option>
                <Option value="IT">IT</Option>
                <Option value="Furniture">Furniture</Option>
                <Option value="Building">Building</Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="category" label="Category">
              <Input />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="status" label="Status">
              <Select allowClear>
                <Option value="ACTIVE">Active</Option>
                <Option value="INACTIVE">Inactive</Option>
                <Option value="MAINTENANCE">Maintenance</Option>
                <Option value="RETIRED">Retired</Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="location" label="Location">
              <Input />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="manufacturer" label="Manufacturer">
              <Input />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="model" label="Model">
              <Input />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="serialNumber" label="Serial Number">
              <Input />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="purchaseCost" label="Purchase Cost">
              <InputNumber style={{ width: '100%' }} prefix="$" />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="purchaseDate" label="Purchase Date">
              <DatePicker style={{ width: '100%' }} />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="warrantyExpiry" label="Warranty Expiry">
              <DatePicker style={{ width: '100%' }} />
            </Form.Item>
          </Col>
        </Row>

        <Form.Item name="description" label="Description">
          <Input.TextArea rows={3} />
        </Form.Item>

        <Form.Item name="notes" label="Notes">
          <Input.TextArea rows={2} />
        </Form.Item>

        <Form.Item>
          <Space>
            <Button type="primary" htmlType="submit" loading={loading}>
              {isEdit ? 'Update' : 'Create'}
            </Button>
            <Button onClick={() => navigate('/assets')}>Cancel</Button>
          </Space>
        </Form.Item>
      </Form>
    </Card>
  );
};

export default AssetForm;
```

- [ ] **Step 4: Commit**
```bash
cd frontend && git add src/pages/Asset/AssetForm.tsx && git commit -m "feat: add AssetForm page for create and edit"
```

---

## Task 8: Create WorkOrder Pages

**Files:**
- Create: `frontend/src/pages/WorkOrder/WorkOrderList.tsx`
- Create: `frontend/src/pages/WorkOrder/WorkOrderDetail.tsx`
- Create: `frontend/src/pages/WorkOrder/WorkOrderForm.tsx`

---

### Task 8.1: Create WorkOrderList

- [ ] **Step 1: Create WorkOrderList.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Table, Button, Input, Space, Tag, Select } from 'antd';
import { useNavigate } from 'react-router-dom';
import { workOrderApi } from '../../api/workOrderApi';
import { WorkOrder } from '../../types';
import { PlusOutlined, SearchOutlined } from '@ant-design/icons';

const { Option } = Select;

const WorkOrderList: React.FC = () => {
  const navigate = useNavigate();
  const [workOrders, setWorkOrders] = useState<WorkOrder[]>([]);
  const [loading, setLoading] = useState(true);
  const [searchText, setSearchText] = useState('');
  const [statusFilter, setStatusFilter] = useState<string>('');

  useEffect(() => {
    fetchWorkOrders();
  }, []);

  const fetchWorkOrders = async () => {
    try {
      const data = await workOrderApi.getAll();
      setWorkOrders(data);
    } finally {
      setLoading(false);
    }
  };

  const filteredWorkOrders = workOrders.filter(wo => {
    const matchesSearch = !searchText || 
      wo.workOrderNumber?.toLowerCase().includes(searchText.toLowerCase()) ||
      wo.description?.toLowerCase().includes(searchText.toLowerCase());
    const matchesStatus = !statusFilter || wo.status === statusFilter;
    return matchesSearch && matchesStatus;
  });

  const priorityColors: Record<string, string> = {
    EMERGENCY: 'red',
    HIGH: 'orange',
    MEDIUM: 'blue',
    LOW: 'green',
  };

  const statusColors: Record<string, string> = {
    PENDING: 'default',
    IN_PROGRESS: 'processing',
    COMPLETED: 'success',
  };

  const columns = [
    {
      title: 'WO Number',
      dataIndex: 'workOrderNumber',
      key: 'workOrderNumber',
      render: (text: string, record: WorkOrder) => (
        <a onClick={() => navigate(`/work-orders/${record.id}`)}>{text}</a>
      ),
    },
    {
      title: 'Asset ID',
      dataIndex: 'assetId',
      key: 'assetId',
    },
    {
      title: 'Description',
      dataIndex: 'description',
      key: 'description',
      ellipsis: true,
    },
    {
      title: 'Priority',
      dataIndex: 'priority',
      key: 'priority',
      render: (priority: string) => (
        <Tag color={priorityColors[priority] || 'default'}>{priority}</Tag>
      ),
    },
    {
      title: 'Status',
      dataIndex: 'status',
      key: 'status',
      render: (status: string) => (
        <Tag color={statusColors[status] || 'default'}>{status}</Tag>
      ),
    },
    {
      title: 'Assigned To',
      dataIndex: 'assignedTechnician',
      key: 'assignedTechnician',
    },
  ];

  return (
    <div>
      <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 16 }}>
        <h1>Work Orders</h1>
        <Button type="primary" icon={<PlusOutlined />} onClick={() => navigate('/work-orders/new')}>
          New Work Order
        </Button>
      </div>

      <Space style={{ marginBottom: 16 }}>
        <Input
          placeholder="Search work orders..."
          prefix={<SearchOutlined />}
          value={searchText}
          onChange={e => setSearchText(e.target.value)}
          style={{ width: 250 }}
        />
        <Select
          placeholder="Filter by status"
          value={statusFilter}
          onChange={setStatusFilter}
          allowClear
          style={{ width: 150 }}
        >
          <Option value="PENDING">Pending</Option>
          <Option value="IN_PROGRESS">In Progress</Option>
          <Option value="COMPLETED">Completed</Option>
        </Select>
      </Space>

      <Table
        columns={columns}
        dataSource={filteredWorkOrders}
        rowKey="id"
        loading={loading}
      />
    </div>
  );
};

export default WorkOrderList;
```

- [ ] **Step 2: Commit**
```bash
cd frontend && git add src/pages/WorkOrder/WorkOrderList.tsx && git commit -m "feat: add WorkOrderList page with search and filters"
```

---

### Task 8.2: Create WorkOrderDetail

- [ ] **Step 1: Create WorkOrderDetail.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Card, Descriptions, Button, Space, Spin, Tag, message } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import { workOrderApi } from '../../api/workOrderApi';
import { WorkOrder } from '../../types';
import { EditOutlined, ArrowLeftOutlined, CheckCircleOutlined } from '@ant-design/icons';

const WorkOrderDetail: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [workOrder, setWorkOrder] = useState<WorkOrder | null>(null);
  const [loading, setLoading] = useState(true);
  const [actionLoading, setActionLoading] = useState(false);

  useEffect(() => {
    const fetchWorkOrder = async () => {
      try {
        if (id && id !== 'new') {
          const data = await workOrderApi.getById(Number(id));
          setWorkOrder(data);
        }
      } catch {
        message.error('Failed to load work order');
      } finally {
        setLoading(false);
      }
    };
    fetchWorkOrder();
  }, [id]);

  const handleComplete = async () => {
    setActionLoading(true);
    try {
      await workOrderApi.complete(Number(id));
      message.success('Work order completed');
      navigate('/work-orders');
    } catch {
      message.error('Failed to complete work order');
    } finally {
      setActionLoading(false);
    }
  };

  if (loading) return <Spin />;
  if (!workOrder) return <div>Work order not found</div>;

  const priorityColors: Record<string, string> = {
    EMERGENCY: 'red',
    HIGH: 'orange',
    MEDIUM: 'blue',
    LOW: 'green',
  };

  const statusColors: Record<string, string> = {
    PENDING: 'default',
    IN_PROGRESS: 'processing',
    COMPLETED: 'success',
  };

  return (
    <div>
      <Space style={{ marginBottom: 16 }}>
        <Button icon={<ArrowLeftOutlined />} onClick={() => navigate('/work-orders')}>Back</Button>
        <Button icon={<EditOutlined />} onClick={() => navigate(`/work-orders/${id}/edit`)}>Edit</Button>
        {workOrder.status !== 'COMPLETED' && (
          <Button 
            type="primary" 
            icon={<CheckCircleOutlined />} 
            onClick={handleComplete}
            loading={actionLoading}
          >
            Complete
          </Button>
        )}
      </Space>

      <Card title="Work Order Information">
        <Descriptions column={2}>
          <Descriptions.Item label="Work Order Number">{workOrder.workOrderNumber}</Descriptions.Item>
          <Descriptions.Item label="Asset ID">{workOrder.assetId}</Descriptions.Item>
          <Descriptions.Item label="Description" span={2}>{workOrder.description}</Descriptions.Item>
          <Descriptions.Item label="Type">{workOrder.workOrderType}</Descriptions.Item>
          <Descriptions.Item label="Priority">
            <Tag color={priorityColors[workOrder.priority || '']}>{workOrder.priority}</Tag>
          </Descriptions.Item>
          <Descriptions.Item label="Status">
            <Tag color={statusColors[workOrder.status || '']}>{workOrder.status}</Tag>
          </Descriptions.Item>
          <Descriptions.Item label="Assigned To">{workOrder.assignedTechnician || 'Unassigned'}</Descriptions.Item>
          <Descriptions.Item label="Scheduled Start">{workOrder.scheduledStartDate}</Descriptions.Item>
          <Descriptions.Item label="Scheduled End">{workOrder.scheduledEndDate}</Descriptions.Item>
          <Descriptions.Item label="Actual Start">{workOrder.actualStartDate || '-'}</Descriptions.Item>
          <Descriptions.Item label="Actual End">{workOrder.actualEndDate || '-'}</Descriptions.Item>
          <Descriptions.Item label="Estimated Hours">{workOrder.estimatedHours}</Descriptions.Item>
          <Descriptions.Item label="Actual Hours">{workOrder.actualHours || '-'}</Descriptions.Item>
          <Descriptions.Item label="Labor Cost">${workOrder.laborCost?.toLocaleString() || '0'}</Descriptions.Item>
          <Descriptions.Item label="Parts Cost">${workOrder.partsCost?.toLocaleString() || '0'}</Descriptions.Item>
          <Descriptions.Item label="Total Cost">${workOrder.totalCost?.toLocaleString() || '0'}</Descriptions.Item>
        </Descriptions>
      </Card>
    </div>
  );
};

export default WorkOrderDetail;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/pages/WorkOrder/WorkOrderDetail.tsx && git commit -m "feat: add WorkOrderDetail page with complete action"
```

---

### Task 8.3: Create WorkOrderForm

- [ ] **Step 1: Create WorkOrderForm.tsx**

```tsx
import React, { useEffect, useState } from 'react';
import { Form, Input, Select, DatePicker, InputNumber, Button, Card, Row, Col, message } from 'antd';
import { useParams, useNavigate } from 'react-router-dom';
import { workOrderApi } from '../../api/workOrderApi';
import { assetApi } from '../../api/assetApi';
import { Asset, CreateWorkOrderRequest, UpdateWorkOrderRequest } from '../../types';
import dayjs from 'dayjs';

const { Option } = Select;
const { TextArea } = Input;

const WorkOrderForm: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const [initialLoading, setInitialLoading] = useState(true);
  const [assets, setAssets] = useState<Asset[]>([]);

  const isEdit = id && id !== 'new';

  useEffect(() => {
    const fetchData = async () => {
      try {
        const assetData = await assetApi.getAll();
        setAssets(assetData);
        
        if (isEdit) {
          const data = await workOrderApi.getById(Number(id));
          form.setFieldsValue({
            ...data,
            scheduledStartDate: data.scheduledStartDate ? dayjs(data.scheduledStartDate) : undefined,
            scheduledEndDate: data.scheduledEndDate ? dayjs(data.scheduledEndDate) : undefined,
          });
        }
      } catch {
        message.error('Failed to load data');
      } finally {
        setInitialLoading(false);
      }
    };
    fetchData();
  }, [id, isEdit, form]);

  const onFinish = async (values: any) => {
    setLoading(true);
    try {
      const data: CreateWorkOrderRequest | UpdateWorkOrderRequest = {
        ...values,
        scheduledStartDate: values.scheduledStartDate?.format('YYYY-MM-DD'),
        scheduledEndDate: values.scheduledEndDate?.format('YYYY-MM-DD'),
        estimatedHours: values.estimatedHours ? Number(values.estimatedHours) : undefined,
      };

      if (isEdit) {
        await workOrderApi.update(Number(id), data as UpdateWorkOrderRequest);
        message.success('Work order updated successfully');
      } else {
        await workOrderApi.create(data as CreateWorkOrderRequest);
        message.success('Work order created successfully');
      }
      navigate('/work-orders');
    } catch {
      message.error('Failed to save work order');
    } finally {
      setLoading(false);
    }
  };

  if (initialLoading) return <div>Loading...</div>;

  return (
    <Card title={isEdit ? 'Edit Work Order' : 'New Work Order'}>
      <Form form={form} layout="vertical" onFinish={onFinish}>
        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="workOrderNumber" label="Work Order Number" rules={[{ required: true }]}>
              <Input />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="assetId" label="Asset" rules={[{ required: true }]}>
              <Select showSearch optionFilterProp="children">
                {assets.map(asset => (
                  <Option key={asset.id} value={asset.id}>{asset.assetNumber} - {asset.name}</Option>
                ))}
              </Select>
            </Form.Item>
          </Col>
        </Row>

        <Form.Item name="description" label="Description" rules={[{ required: true }]}>
          <TextArea rows={3} />
        </Form.Item>

        <Row gutter={16}>
          <Col span={8}>
            <Form.Item name="workOrderType" label="Type">
              <Select allowClear>
                <Option value="PREVENTIVE">Preventive</Option>
                <Option value="CORRECTIVE">Corrective</Option>
                <Option value="PREDICTIVE">Predictive</Option>
                <Option value="INSPECTION">Inspection</Option>
                <Option value="CALIBRATION">Calibration</Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="priority" label="Priority">
              <Select allowClear>
                <Option value="EMERGENCY">Emergency</Option>
                <Option value="HIGH">High</Option>
                <Option value="MEDIUM">Medium</Option>
                <Option value="LOW">Low</Option>
              </Select>
            </Form.Item>
          </Col>
          <Col span={8}>
            <Form.Item name="status" label="Status">
              <Select allowClear>
                <Option value="PENDING">Pending</Option>
                <Option value="IN_PROGRESS">In Progress</Option>
                <Option value="COMPLETED">Completed</Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="assignedTechnician" label="Assigned Technician">
              <Input />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="estimatedHours" label="Estimated Hours">
              <InputNumber style={{ width: '100%' }} />
            </Form.Item>
          </Col>
        </Row>

        <Row gutter={16}>
          <Col span={12}>
            <Form.Item name="scheduledStartDate" label="Scheduled Start Date">
              <DatePicker style={{ width: '100%' }} />
            </Form.Item>
          </Col>
          <Col span={12}>
            <Form.Item name="scheduledEndDate" label="Scheduled End Date">
              <DatePicker style={{ width: '100%' }} />
            </Form.Item>
          </Col>
        </Row>

        <Form.Item>
          <Space>
            <Button type="primary" htmlType="submit" loading={loading}>
              {isEdit ? 'Update' : 'Create'}
            </Button>
            <Button onClick={() => navigate('/work-orders')}>Cancel</Button>
          </Space>
        </Form.Item>
      </Form>
    </Card>
  );
};

export default WorkOrderForm;
```

- [ ] **Step 4: Commit**
```bash
cd frontend && git add src/pages/WorkOrder/WorkOrderForm.tsx && git commit -m "feat: add WorkOrderForm page for create and edit"
```

---

## Task 9: Create App Entry and Routing

**Files:**
- Create: `frontend/src/main.tsx`
- Create: `frontend/src/App.tsx`

---

### Task 9.1: Create main.tsx

- [ ] **Step 1: Create main.tsx**

```tsx
import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom';
import { ConfigProvider } from 'antd';
import zhCN from 'antd/locale/zh_CN';
import App from './App';

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <BrowserRouter>
      <ConfigProvider locale={zhCN}>
        <App />
      </ConfigProvider>
    </BrowserRouter>
  </React.StrictMode>
);
```

- [ ] **Step 2: Commit**
```bash
cd frontend && git add src/main.tsx && git commit -m "feat: add React entry point with routing"
```

---

### Task 9.2: Create App.tsx

- [ ] **Step 1: Create App.tsx**

```tsx
import React from 'react';
import { Routes, Route } from 'react-router-dom';
import MainLayout from './components/Layout/MainLayout';
import Dashboard from './pages/Dashboard/Dashboard';
import AssetList from './pages/Asset/AssetList';
import AssetDetail from './pages/Asset/AssetDetail';
import AssetForm from './pages/Asset/AssetForm';
import WorkOrderList from './pages/WorkOrder/WorkOrderList';
import WorkOrderDetail from './pages/WorkOrder/WorkOrderDetail';
import WorkOrderForm from './pages/WorkOrder/WorkOrderForm';

const App: React.FC = () => {
  return (
    <MainLayout>
      <Routes>
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/assets" element={<AssetList />} />
        <Route path="/assets/new" element={<AssetForm />} />
        <Route path="/assets/:id" element={<AssetDetail />} />
        <Route path="/assets/:id/edit" element={<AssetForm />} />
        <Route path="/work-orders" element={<WorkOrderList />} />
        <Route path="/work-orders/new" element={<WorkOrderForm />} />
        <Route path="/work-orders/:id" element={<WorkOrderDetail />} />
        <Route path="/work-orders/:id/edit" element={<WorkOrderForm />} />
        <Route path="/" element={<Dashboard />} />
      </Routes>
    </MainLayout>
  );
};

export default App;
```

- [ ] **Step 3: Commit**
```bash
cd frontend && git add src/App.tsx && git commit -m "feat: add App component with routing configuration"
```

---

## Task 10: Create Database Scripts

**Files:**
- Create: `code/src/main/resources/db/scripts/V1__init_schema.sql`
- Create: `code/src/main/resources/db/scripts/V2__init_data.sql`

---

### Task 10.1: Create Schema Script

- [ ] **Step 1: Create db/scripts directory**
```bash
mkdir -p code/src/main/resources/db/scripts
```

- [ ] **Step 2: Create V1__init_schema.sql**

```sql
-- Asset Management System - Database Schema
-- Version: 1.0
-- Date: 2026-04-09

-- Asset Table
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

-- Work Order Table
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
CREATE INDEX idx_asset_type ON asset(asset_type);
CREATE INDEX idx_work_order_number ON work_order(work_order_number);
CREATE INDEX idx_work_order_status ON work_order(status);
CREATE INDEX idx_work_order_asset ON work_order(asset_id);
CREATE INDEX idx_work_order_priority ON work_order(priority);
```

- [ ] **Step 3: Commit**
```bash
cd code && git add src/main/resources/db/scripts/V1__init_schema.sql && git commit -m "feat: add database schema script"
```

---

### Task 10.2: Create Data Script

- [ ] **Step 1: Create V2__init_data.sql**

```sql
-- Asset Management System - Sample Data
-- Version: 1.0
-- Date: 2026-04-09

-- Insert sample assets
INSERT INTO asset (asset_number, name, description, asset_type, category, status, location, manufacturer, model, serial_number, purchase_cost, book_value, purchase_date) VALUES
('AST-001', 'CNC Machine #1', '5-axis CNC machining center for precision parts', 'Equipment', 'Machinery', 'ACTIVE', 'Plant A - Building 1 - Line 1', 'Haas', 'VL-5030', 'HAAS-001', 250000.00, 200000.00, '2023-01-15'),
('AST-002', 'Overhead Crane 5T', '5-ton overhead crane for assembly line', 'Equipment', 'Material Handling', 'ACTIVE', 'Plant A - Building 1', 'Konecranes', 'S-series', 'KC-S001', 85000.00, 68000.00, '2023-03-20'),
('AST-003', 'Injection Molding Press', '500-ton injection molding machine', 'Equipment', 'Manufacturing', 'ACTIVE', 'Plant B - Production Hall', 'Engel', 'Victory 500', 'ENG-V500-002', 180000.00, 144000.00, '2022-11-10'),
('AST-004', 'Electric Forklift #1', 'Electric forklift for warehouse operations', 'Vehicle', 'Logistics', 'ACTIVE', 'Warehouse A', 'Toyota', '8FGU25', 'TOY-FG25-003', 35000.00, 28000.00, '2024-02-28'),
('AST-005', 'Coordinate Measuring Machine', 'CMM for quality inspection', 'Equipment', 'Quality Control', 'ACTIVE', 'Plant A - QC Lab', 'Zeiss', 'Contura', 'ZEISS-CMM-005', 120000.00, 96000.00, '2023-06-15'),
('AST-006', 'Laser Cutting Machine', 'Fiber laser cutter for sheet metal', 'Equipment', 'Fabrication', 'ACTIVE', 'Plant A - Building 2', 'Trumpf', 'TruLaser 3030', 'TRU-LAS-006', 200000.00, 160000.00, '2023-09-01'),
('AST-007', 'Air Compressor', 'Industrial air compressor system', 'Equipment', 'Utilities', 'ACTIVE', 'Plant A - Utility Room', 'Atlas Copco', 'GA 37', 'AC-GA37-007', 25000.00, 20000.00, '2022-05-20'),
('AST-008', 'Assembly Robot Arm', '6-axis industrial robot for assembly', 'Equipment', 'Automation', 'ACTIVE', 'Plant B - Assembly Line', 'FANUC', 'M-20iD/25', 'FAN-M20-008', 95000.00, 76000.00, '2024-01-10');

-- Insert sample work orders
INSERT INTO work_order (work_order_number, asset_id, description, work_order_type, priority, status, assigned_technician, scheduled_start_date, scheduled_end_date, estimated_hours) VALUES
('WO-2026-001', 1, 'Quarterly preventive maintenance - lubrication and inspection', 'PREVENTIVE', 'MEDIUM', 'PENDING', 'John Smith', '2026-04-15', '2026-04-16', 4.0),
('WO-2026-002', 1, 'Spindle bearing replacement due to wear detected in vibration analysis', 'CORRECTIVE', 'HIGH', 'IN_PROGRESS', 'Mike Johnson', '2026-04-10', '2026-04-12', 8.0),
('WO-2026-003', 2, 'Emergency brake inspection and certification renewal', 'INSPECTION', 'EMERGENCY', 'PENDING', NULL, '2026-04-11', '2026-04-11', 2.0),
('WO-2026-004', 3, 'Hydraulic system check and oil change', 'PREVENTIVE', 'MEDIUM', 'COMPLETED', 'Tom Wilson', '2026-04-05', '2026-04-06', 3.0),
('WO-2026-005', 5, 'Annual calibration certification', 'CALIBRATION', 'LOW', 'COMPLETED', 'John Smith', '2026-04-01', '2026-04-02', 4.0),
('WO-2026-006', 6, 'Laser resonator alignment and calibration', 'PREVENTIVE', 'HIGH', 'IN_PROGRESS', 'Mike Johnson', '2026-04-08', '2026-04-09', 6.0),
('WO-2026-007', 4, 'Battery replacement and system check', 'PREVENTIVE', 'MEDIUM', 'PENDING', 'Tom Wilson', '2026-04-18', '2026-04-18', 2.0),
('WO-2026-008', 8, 'Controller software update to latest version', 'CORRECTIVE', 'LOW', 'PENDING', 'John Smith', '2026-04-20', '2026-04-20', 2.0);

-- Update completed work orders with actual data
UPDATE work_order SET actual_start_date = '2026-04-05', actual_end_date = '2026-04-06', actual_hours = 3.5, labor_cost = 175.00, parts_cost = 50.00, total_cost = 225.00, resolution_notes = 'Hydraulic oil changed, system pressure checked and adjusted' WHERE work_order_number = 'WO-2026-004';

UPDATE work_order SET actual_start_date = '2026-04-01', actual_end_date = '2026-04-02', actual_hours = 4.5, labor_cost = 225.00, parts_cost = 0.00, total_cost = 225.00, resolution_notes = 'Calibration certificate issued, all axes within tolerance' WHERE work_order_number = 'WO-2026-005';
```

- [ ] **Step 4: Commit**
```bash
cd code && git add src/main/resources/db/scripts/V2__init_data.sql && git commit -m "feat: add sample data script"
```

---

## Task 11: Verify Build

- [ ] **Step 1: Build frontend**
```bash
cd frontend && npm run build
```
Expected: Build completes successfully

- [ ] **Step 2: Verify static files copied to backend**
```bash
ls -la code/src/main/resources/static/
```

- [ ] **Step 3: Run backend with tests**
```bash
cd code && mvn clean test -q
```

- [ ] **Step 4: Commit all changes**
```bash
cd code && git add -A && git commit -m "feat: complete frontend integration with Ant Design React"
```

---

## Summary

**Phase 1 creates:**
- React 18 + Vite + Ant Design frontend
- Asset CRUD (List, Detail, Form)
- WorkOrder CRUD (List, Detail, Form)
- Dashboard with statistics
- CORS configuration
- Database schema and sample data scripts
- Full TypeScript types
- Axios API layer with error handling

**API Endpoints (existing backend):**
```
GET/POST/PUT/DELETE /api/v1/assets
GET/POST/PUT/DELETE /api/v1/work-orders
PATCH /api/v1/work-orders/{id}/status
PATCH /api/v1/work-orders/{id}/complete
```

**To run:**
```bash
# Terminal 1: Backend
cd code && mvn spring-boot:run

# Terminal 2: Frontend (dev mode)
cd frontend && npm run dev
```

---

*Plan complete. Total files: 24 new files*
