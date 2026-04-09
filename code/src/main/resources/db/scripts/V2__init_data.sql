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
