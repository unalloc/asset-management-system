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
