const REQUIREMENTS = {
    'overview': {
        title: 'Overview',
        items: [
            { id: '', title: 'Overview', file: 'index.html' }
        ]
    },
    '1-asset-central': {
        title: 'Module 1: Asset Central',
        items: [
            { id: 'F-0.0.1', title: 'Asset Central Hub', file: 'modules/asset-central/Asset-Central-Hub.html' },
            { id: 'F-0.0.2', title: 'Asset Detail View', file: 'modules/asset-central/Asset-Detail.html' },
            { id: 'F-0.0.3', title: 'Work Order Hub', file: 'modules/asset-central/Work-Order-Hub.html' },
            { id: 'F-0.0.4', title: 'Vendor Hub', file: 'modules/asset-central/Vendor-Hub.html' },
            { id: 'F-0.0.5', title: 'Spare Parts Hub', file: 'modules/asset-central/Spare-Part-Hub.html' },
            { id: 'F-0.0.6', title: 'Organization Hub', file: 'modules/asset-central/Organization-Hub.html' },
            { id: 'F-0.0.7', title: 'Service Contract Hub', file: 'modules/asset-central/Service-Contract-Hub.html' },
            { id: 'F-0.0.8', title: 'Insurance Hub', file: 'modules/asset-central/Insurance-Hub.html' },
            { id: 'F-0.0.9', title: 'Disposal Hub', file: 'modules/asset-central/Disposal-Hub.html' }
        ]
    },
    '2-asset-registration': {
        title: 'Module 2: Asset Registration',
        items: [
            { id: 'M2-HUB', title: 'Asset Registration Overview', file: 'modules/2-asset-registration/Asset-Registration-Overview.html' },
            { id: 'F-2.1.1', title: 'Multiple Asset Types Support', file: 'modules/2-asset-registration/F-2.1.1-Multiple Asset Types Support.html' },
            { id: 'F-2.1.2', title: 'Custom Asset Categories', file: 'modules/2-asset-registration/F-2.1.2-Custom Asset Categories.html' },
            { id: 'F-2.1.3', title: 'Bulk Import-Export', file: 'modules/2-asset-registration/F-2.1.3-Bulk Import-Export.html' },
            { id: 'F-2.1.4', title: 'Barcode/QR Code Generation', file: 'modules/2-asset-registration/F-2.1.4-Barcode-QR Code Generation.html' },
            { id: 'F-2.1.5', title: 'RFID Tag Integration', file: 'modules/2-asset-registration/F-2.1.5-RFID Tag Integration.html' },
            { id: 'F-2.1.6', title: 'Asset Hierarchy', file: 'modules/2-asset-registration/F-2.1.6-Asset Hierarchy.html' },
            { id: 'F-2.1.7', title: 'Document Attachment', file: 'modules/2-asset-registration/F-2.1.7-Document Attachment.html' },
            { id: 'F-2.1.8', title: 'Manufacturing Asset Types', file: 'modules/2-asset-registration/F-2.1.8-Manufacturing Asset Types.html' },
            { id: 'F-2.1.9', title: 'Equipment Hierarchy', file: 'modules/2-asset-registration/F-2.1.9-Equipment Hierarchy.html' },
            { id: 'F-2.1.10', title: 'Tooling and Fixtures', file: 'modules/2-asset-registration/F-2.1.10-Tooling and Fixtures.html' },
            { id: 'F-2.1.11', title: 'Multi-Plant Asset Registry', file: 'modules/2-asset-registration/F-2.1.11-Multi-Plant Asset Registry.html' },
            { id: 'F-2.1.12', title: 'Asset Componentization', file: 'modules/2-asset-registration/F-2.1.12-Asset Componentization.html' },
            { id: 'F-2.1.13', title: 'Criticality Classification', file: 'modules/2-asset-registration/F-2.1.13-Criticality Classification.html' },
            { id: 'F-2.1.14', title: 'Integration API Framework', file: 'modules/2-asset-registration/F-2.1.14-Integration API Framework.html' },
            { id: 'F-2.1.15', title: 'HR Employee Integration', file: 'modules/2-asset-registration/F-2.1.15-HR Employee Integration.html' }
        ]
    },
    '3-asset-tracking': {
        title: 'Module 3: Asset Tracking',
        items: [
            { id: 'M3-HUB', title: 'Asset Tracking Overview', file: 'modules/3-asset-tracking/Asset-Tracking-Overview.html' },
            { id: 'F-2.2.1', title: 'Real-time Location Tracking', file: 'modules/3-asset-tracking/F-2.2.1-Real-time Location Tracking.html' },
            { id: 'F-2.2.2', title: 'Check-in-Check-out System', file: 'modules/3-asset-tracking/F-2.2.2-Check-in-Check-out System.html' },
            { id: 'F-2.2.3', title: 'Transfer Management', file: 'modules/3-asset-tracking/F-2.2.3-Transfer Management.html' },
            { id: 'F-2.2.4', title: 'Audit Trail', file: 'modules/3-asset-tracking/F-2.2.4-Audit Trail.html' },
            { id: 'F-2.2.5', title: 'Mobile Asset Verification', file: 'modules/3-asset-tracking/F-2.2.5-Mobile Asset Verification.html' },
            { id: 'F-2.2.6', title: 'IoT Sensor Integration', file: 'modules/3-asset-tracking/F-2.2.6-IoT Sensor Integration.html' },
            { id: 'F-2.2.11', title: 'Inter-Plant Transfer', file: 'modules/3-asset-tracking/F-2.2.11-Inter-Plant Transfer.html' },
            { id: 'F-2.2.12', title: 'Calibration Management', file: 'modules/3-asset-tracking/F-2.2.12-Calibration Management.html' },
            { id: 'F-2.2.13', title: 'Safety Compliance', file: 'modules/3-asset-tracking/F-2.2.13-Safety Compliance.html' },
            { id: 'F-2.2.15', title: 'GIS Geographic Integration', file: 'modules/3-asset-tracking/F-2.2.15-GIS Geographic Integration.html' }
        ]
    },
    '4-maintenance': {
        title: 'Module 4: Maintenance',
        items: [
            { id: 'M4-HUB', title: 'Maintenance Overview', file: 'modules/4-maintenance/Maintenance-Overview.html' },
            { id: 'F-2.3.1', title: 'Scheduled Maintenance Planning', file: 'modules/4-maintenance/F-2.3.1-Scheduled Maintenance Planning.html' },
            { id: 'F-2.3.2', title: 'Preventive Maintenance Workflow', file: 'modules/4-maintenance/F-2.3.2-Preventive Maintenance Workflow.html' },
            { id: 'F-2.3.3', title: 'Maintenance History Tracking', file: 'modules/4-maintenance/F-2.3.3-Maintenance History Tracking.html' },
            { id: 'F-2.3.4', title: 'Service Contract Management', file: 'modules/4-maintenance/F-2.3.4-Service Contract Management.html' },
            { id: 'F-2.3.5', title: 'Spare Parts Inventory Linkage', file: 'modules/4-maintenance/F-2.3.5-Spare Parts Inventory Linkage.html' },
            { id: 'F-2.3.6', title: 'Vendor Management', file: 'modules/4-maintenance/F-2.3.6-Vendor Management.html' },
            { id: 'F-2.3.7', title: 'Predictive Maintenance (IoT)', file: 'modules/4-maintenance/F-2.3.7-Predictive Maintenance (IoT).html' },
            { id: 'F-2.3.8', title: 'RCM Strategies', file: 'modules/4-maintenance/F-2.3.8-RCM Strategies.html' },
            { id: 'F-2.3.9', title: 'Maintenance KPIs', file: 'modules/4-maintenance/F-2.3.9-Maintenance KPIs.html' },
            { id: 'F-2.3.10', title: 'Spare Parts Criticality', file: 'modules/4-maintenance/F-2.3.10-Spare Parts Criticality.html' },
            { id: 'F-2.3.11', title: 'Work Order Prioritization', file: 'modules/4-maintenance/F-2.3.11-Work Order Prioritization.html' },
            { id: 'F-2.3.12', title: 'Maintenance Backlog', file: 'modules/4-maintenance/F-2.3.12-Maintenance Backlog.html' },
            { id: 'F-2.3.13', title: 'Calibration Schedules', file: 'modules/4-maintenance/F-2.3.13-Calibration Schedules.html' },
            { id: 'F-2.3.15', title: 'Mobile Workforce Management', file: 'modules/4-maintenance/F-2.3.15-Mobile Workforce Management.html' },
            { id: 'F-2.3.16', title: 'Centralized Notification System', file: 'modules/4-maintenance/F-2.3.16-Centralized Notification System.html' },
            { id: 'F-2.3.17', title: 'Root Cause Analysis', file: 'modules/4-maintenance/F-2.3.17-Root Cause Analysis.html' },
            { id: 'F-2.3.18', title: 'Maintenance Calendar View', file: 'modules/4-maintenance/F-2.3.18-Maintenance Calendar View.html' }
        ]
    },
    '5-financial': {
        title: 'Module 5: Financial',
        items: [
            { id: 'M5-HUB', title: 'Financial Overview', file: 'modules/5-financial/Financial-Overview.html' },
            { id: 'F-2.4.1', title: 'Multi-Currency Support', file: 'modules/5-financial/F-2.4.1-Multi-Currency Support.html' },
            { id: 'F-2.4.2', title: 'Automated Depreciation', file: 'modules/5-financial/F-2.4.2-Automated Depreciation.html' },
            { id: 'F-2.4.3', title: 'Insurance Tracking', file: 'modules/5-financial/F-2.4.3-Insurance Tracking.html' },
            { id: 'F-2.4.4', title: 'TCO Analysis', file: 'modules/5-financial/F-2.4.4-TCO Analysis.html' },
            { id: 'F-2.4.5', title: 'Budget vs Actual', file: 'modules/5-financial/F-2.4.5-Budget vs Actual.html' },
            { id: 'F-2.4.6', title: 'Tax Compliance Reporting', file: 'modules/5-financial/F-2.4.6-Tax Compliance Reporting.html' },
            { id: 'F-2.4.7', title: 'Capital Projects', file: 'modules/5-financial/F-2.4.7-Capital Projects.html' },
            { id: 'F-2.4.8', title: 'Component-Level Financial', file: 'modules/5-financial/F-2.4.8-Component-Level Financial.html' },
            { id: 'F-2.4.9', title: 'Asset Reclassification', file: 'modules/5-financial/F-2.4.9-Asset Reclassification.html' },
            { id: 'F-2.4.10', title: 'Lease Accounting', file: 'modules/5-financial/F-2.4.10-Lease Accounting.html' },
            { id: 'F-2.4.11', title: 'Country-Specific Tax Depreciation', file: 'modules/5-financial/F-2.4.11-Country-Specific Tax Depreciation.html' },
            { id: 'F-2.4.12', title: 'Replacement Planning', file: 'modules/5-financial/F-2.4.12-Replacement Planning.html' },
            { id: 'F-2.4.13', title: 'Residual Value Tracking', file: 'modules/5-financial/F-2.4.13-Residual Value Tracking.html' },
            { id: 'F-2.4.14', title: 'Insurance Valuation', file: 'modules/5-financial/F-2.4.14-Insurance Valuation.html' }
        ]
    },
    '6-multi-plant': {
        title: 'Module 6: Multi-Plant',
        items: [
            { id: 'M6-HUB', title: 'Multi-Plant Overview', file: 'modules/6-multi-plant/Multi-Plant-Overview.html' },
            { id: 'F-2.5.1', title: 'Hierarchical Factory Structure', file: 'modules/6-multi-plant/F-2.5.1-Hierarchical Factory Structure.html' },
            { id: 'F-2.5.2', title: 'Factory-Specific Configuration', file: 'modules/6-multi-plant/F-2.5.2-Factory-Specific Configuration.html' },
            { id: 'F-2.5.3', title: 'Cross-Factory Consolidated Reporting', file: 'modules/6-multi-plant/F-2.5.3-Cross-Factory Consolidated Reporting.html' },
            { id: 'F-2.5.4', title: 'Standardized Asset Classification', file: 'modules/6-multi-plant/F-2.5.4-Standardized Asset Classification.html' },
            { id: 'F-2.5.5', title: 'Cross-Factory Asset Transfer', file: 'modules/6-multi-plant/F-2.5.5-Cross-Factory Asset Transfer.html' },
            { id: 'F-2.5.6', title: 'Centralized Contract Management', file: 'modules/6-multi-plant/F-2.5.6-Centralized Contract Management.html' },
            { id: 'F-2.5.7', title: 'Manufacturing Standards Compliance', file: 'modules/6-multi-plant/F-2.5.7-Manufacturing Standards Compliance.html' },
            { id: 'F-2.5.10', title: 'Regulatory Compliance Audit', file: 'modules/6-multi-plant/F-2.5.10-Regulatory Compliance Audit.html' }
        ]
    },
    '7-lifecycle': {
        title: 'Module 7: Lifecycle',
        items: [
            { id: 'M7-HUB', title: 'Lifecycle Overview', file: 'modules/7-lifecycle/Lifecycle-Overview.html' },
            { id: 'F-2.6.1', title: 'Procurement Workflow Integration', file: 'modules/7-lifecycle/F-2.6.1-Procurement Workflow Integration.html' },
            { id: 'F-2.6.2', title: 'Asset Receiving and Inspection', file: 'modules/7-lifecycle/F-2.6.2-Asset Receiving and Inspection.html' },
            { id: 'F-2.6.3', title: 'Capitalization Process', file: 'modules/7-lifecycle/F-2.6.3-Capitalization Process.html' },
            { id: 'F-2.6.4', title: 'Asset Deployment and Commissioning', file: 'modules/7-lifecycle/F-2.6.4-Asset Deployment and Commissioning.html' },
            { id: 'F-2.6.5', title: 'Borrowing-Return System', file: 'modules/7-lifecycle/F-2.6.5-Borrowing-Return System.html' },
            { id: 'F-2.6.6', title: 'Temporary Asset Borrowing', file: 'modules/7-lifecycle/F-2.6.6-Temporary Asset Borrowing.html' },
            { id: 'F-2.6.7', title: 'Physical Inventory Counting', file: 'modules/7-lifecycle/F-2.6.7-Physical Inventory Counting.html' },
            { id: 'F-2.6.8', title: 'Cycle Counting Plan', file: 'modules/7-lifecycle/F-2.6.8-Cycle Counting Plan.html' },
            { id: 'F-2.6.9', title: 'Asset Disposal Workflow', file: 'modules/7-lifecycle/F-2.6.9-Asset Disposal Workflow.html' },
            { id: 'F-2.6.10', title: 'Disposal Approval Workflow', file: 'modules/7-lifecycle/F-2.6.10-Disposal Approval Workflow.html' },
            { id: 'F-2.6.11', title: 'Asset Disassembly Tracking', file: 'modules/7-lifecycle/F-2.6.11-Asset Disassembly Tracking.html' },
            { id: 'F-2.6.12', title: 'Retirement Planning', file: 'modules/7-lifecycle/F-2.6.12-Retirement Planning.html' },
            { id: 'F-2.6.13', title: 'Asset Refurbishment', file: 'modules/7-lifecycle/F-2.6.13-Asset Refurbishment.html' },
            { id: 'F-2.6.14', title: 'Warranty Claim Processing', file: 'modules/7-lifecycle/F-2.6.14-Warranty Claim Processing.html' },
            { id: 'F-2.6.15', title: 'Lease Return and Purchase', file: 'modules/7-lifecycle/F-2.6.15-Lease Return and Purchase.html' },
            { id: 'F-2.6.16', title: 'Lifecycle Cost Tracking', file: 'modules/7-lifecycle/F-2.6.16-Lifecycle Cost Tracking.html' },
            { id: 'F-2.6.17', title: 'Environmental Disposal Compliance', file: 'modules/7-lifecycle/F-2.6.17-Environmental Disposal Compliance.html' },
            { id: 'F-2.6.18', title: 'Residual Value Realization', file: 'modules/7-lifecycle/F-2.6.18-Residual Value Realization.html' }
        ]
    },
    '8-utilization': {
        title: 'Module 8: Utilization',
        items: [
            { id: 'M8-HUB', title: 'Utilization Overview', file: 'modules/8-utilization/Utilization-Overview.html' },
            { id: 'F-2.7.1', title: 'Asset Allocation Planning', file: 'modules/8-utilization/F-2.7.1-Asset Allocation Planning.html' },
            { id: 'F-2.7.2', title: 'Usage Request and Approval', file: 'modules/8-utilization/F-2.7.2-Usage Request and Approval.html' },
            { id: 'F-2.7.3', title: 'Asset Reservation System', file: 'modules/8-utilization/F-2.7.3-Asset Reservation System.html' },
            { id: 'F-2.7.4', title: 'Real-time Availability Tracking', file: 'modules/8-utilization/F-2.7.4-Real-time Availability Tracking.html' },
            { id: 'F-2.7.5', title: 'Usage Contract Management', file: 'modules/8-utilization/F-2.7.5-Usage Contract Management.html' },
            { id: 'F-2.7.6', title: 'Asset Utilization Calculation', file: 'modules/8-utilization/F-2.7.6-Asset Utilization Calculation.html' },
            { id: 'F-2.7.8', title: 'Idle Asset Identification', file: 'modules/8-utilization/F-2.7.8-Idle Asset Identification.html' },
            { id: 'F-2.7.9', title: 'Usage Cost Allocation', file: 'modules/8-utilization/F-2.7.9-Usage Cost Allocation.html' },
            { id: 'F-2.7.10', title: 'Department-Project Cost Tracking', file: 'modules/8-utilization/F-2.7.10-Department-Project Cost Tracking.html' },
            { id: 'F-2.7.11', title: 'Usage Performance Evaluation', file: 'modules/8-utilization/F-2.7.11-Usage Performance Evaluation.html' },
            { id: 'F-2.7.12', title: 'Shift-based Equipment Scheduling', file: 'modules/8-utilization/F-2.7.12-Shift-based Equipment Scheduling.html' },
            { id: 'F-2.7.13', title: 'Asset Sharing and Pool', file: 'modules/8-utilization/F-2.7.13-Asset Sharing and Pool.html' },
            { id: 'F-2.7.14', title: 'Usage History and Trend', file: 'modules/8-utilization/F-2.7.14-Usage History and Trend.html' },
            { id: 'F-2.7.15', title: 'Utilization Prediction', file: 'modules/8-utilization/F-2.7.15-Utilization Prediction.html' },
            { id: 'F-2.7.16', title: 'Cross-department Load Balancing', file: 'modules/8-utilization/F-2.7.16-Cross-department Load Balancing.html' },
            { id: 'F-2.7.17', title: 'Critical Asset Emergency', file: 'modules/8-utilization/F-2.7.17-Critical Asset Emergency.html' },
            { id: 'F-2.7.18', title: 'Usage Compliance Monitoring', file: 'modules/8-utilization/F-2.7.18-Usage Compliance Monitoring.html' }
        ]
    },
    '9-multi-company': {
        title: 'Module 9: Multi-Company',
        items: [
            { id: 'M9-HUB', title: 'Multi-Company Overview', file: 'modules/9-multi-company/Multi-Company-Overview.html' },
            { id: 'F-2.8.1', title: 'Multi-level Org Hierarchy', file: 'modules/9-multi-company/F-2.8.1-Multi-level Org Hierarchy.html' },
            { id: 'F-2.8.2', title: 'Legal Entity Management', file: 'modules/9-multi-company/F-2.8.2-Legal Entity Management.html' },
            { id: 'F-2.8.3', title: 'Company Data Isolation', file: 'modules/9-multi-company/F-2.8.3-Company Data Isolation.html' },
            { id: 'F-2.8.4', title: 'Group Consolidated Reporting', file: 'modules/9-multi-company/F-2.8.4-Group Consolidated Reporting.html' },
            { id: 'F-2.8.5', title: 'Cross-company Asset Transfer', file: 'modules/9-multi-company/F-2.8.5-Cross-company Asset Transfer.html' },
            { id: 'F-2.8.6', title: 'Inter-company Asset Leasing', file: 'modules/9-multi-company/F-2.8.6-Inter-company Asset Leasing.html' },
            { id: 'F-2.8.7', title: 'Group-level Policy Templates', file: 'modules/9-multi-company/F-2.8.7-Group-level Policy Templates.html' },
            { id: 'F-2.8.8', title: 'Centralized Procurement', file: 'modules/9-multi-company/F-2.8.8-Centralized Procurement.html' },
            { id: 'F-2.8.9', title: 'Group-level Standardization', file: 'modules/9-multi-company/F-2.8.9-Group-level Standardization.html' },
            { id: 'F-2.8.10', title: 'Company-specific Configuration', file: 'modules/9-multi-company/F-2.8.10-Company-specific Configuration.html' },
            { id: 'F-2.8.11', title: 'Inter-company Cost Allocation', file: 'modules/9-multi-company/F-2.8.11-Inter-company Cost Allocation.html' },
            { id: 'F-2.8.12', title: 'Group Audit Tracking', file: 'modules/9-multi-company/F-2.8.12-Group Audit Tracking.html' },
            { id: 'F-2.8.13', title: 'Support Different Company Types', file: 'modules/9-multi-company/F-2.8.13-Support Different Company Types.html' },
            { id: 'F-2.8.14', title: 'Multi-company Benchmarking', file: 'modules/9-multi-company/F-2.8.14-Multi-company Benchmarking.html' },
            { id: 'F-2.8.15', title: 'Group Asset Optimization', file: 'modules/9-multi-company/F-2.8.15-Group Asset Optimization.html' },
            { id: 'F-2.8.19', title: 'Reporting Dashboard Module', file: 'modules/9-multi-company/F-2.8.19-Reporting Dashboard Module.html' },
            { id: 'F-2.8.20', title: 'Data Hierarchy Access Control', file: 'modules/9-multi-company/F-2.8.20-Data Hierarchy Access Control.html' },
            { id: 'F-2.8.21', title: 'Audit Compliance Framework', file: 'modules/9-multi-company/F-2.8.21-Audit Compliance Framework.html' },
            { id: 'F-2.8.22', title: 'Data Security Privacy', file: 'modules/9-multi-company/F-2.8.22-Data Security Privacy.html' }
        ]
    }
};

function getBasePath() {
    const currentPath = decodeURIComponent(window.location.pathname);
    if (currentPath.includes('/modules/')) {
        return '../../';
    }
    return '';
}

function getCurrentModuleKey() {
    const currentPath = decodeURIComponent(window.location.pathname);
    
    for (const [moduleKey, moduleData] of Object.entries(REQUIREMENTS)) {
        for (const item of moduleData.items) {
            const fileName = item.file.split('/').pop();
            if (currentPath.endsWith(fileName)) {
                return moduleKey;
            }
        }
    }
    return null;
}

function renderSidebar() {
    const container = document.getElementById('sidebar-container');
    if (!container) return;
    
    const basePath = getBasePath();
    const currentPath = decodeURIComponent(window.location.pathname);
    const currentModuleKey = getCurrentModuleKey();
    
    let html = `
        <nav class="sidebar">
            <div class="sidebar-header">
                <div class="logo">
                    <h1>AMS</h1>
                    <span>Asset Management</span>
                </div>
            </div>
            <ul class="nav-menu">
    `;
    
    for (const [moduleKey, moduleData] of Object.entries(REQUIREMENTS)) {
        const isOverview = moduleKey === 'overview';
        const isCurrentModule = moduleKey === currentModuleKey;
        
        const userExpanded = localStorage.getItem('sidebar_expanded_' + moduleKey) === 'true';
        let shouldBeCollapsed;
        
        if (isOverview) {
            shouldBeCollapsed = false;
        } else if (isCurrentModule) {
            shouldBeCollapsed = false;
        } else if (userExpanded) {
            shouldBeCollapsed = false;
        } else {
            shouldBeCollapsed = true;
        }
        
        html += `
            <li class="nav-section ${isCurrentModule ? 'active' : ''}">
                <div class="nav-section-header" data-module="${moduleKey}">
                    <span class="nav-section-title">${moduleData.title}</span>
                    ${isOverview ? '' : `<span class="nav-section-toggle">${shouldBeCollapsed ? '▶' : '▼'}</span>`}
                </div>
                <ul class="nav-section-items ${shouldBeCollapsed ? 'collapsed' : ''}">
        `;
        
        for (const item of moduleData.items) {
            const itemFullPath = basePath + item.file;
            const fileName = item.file.split('/').pop();
            const isCurrentPage = currentPath.endsWith(fileName);
            
            html += `
                <li>
                    <a href="${itemFullPath}" 
                       data-module="${moduleKey}"
                       class="${isCurrentPage ? 'active' : ''}">
                        <span class="req-id">${item.id}</span>
                        <span class="req-title">${item.title}</span>
                    </a>
                </li>
            `;
        }
        
        html += `
                </ul>
            </li>
        `;
    }
    
    html += `
            </ul>
        </nav>
    `;
    
    container.innerHTML = html;
    
    document.querySelectorAll('.nav-section-header').forEach(header => {
        header.addEventListener('click', () => {
            const moduleKey = header.dataset.module;
            if (moduleKey === 'overview') return;
            
            const items = header.nextElementSibling;
            const toggle = header.querySelector('.nav-section-toggle');
            const isCurrentlyCollapsed = items.classList.contains('collapsed');
            
            if (isCurrentlyCollapsed) {
                items.classList.remove('collapsed');
                toggle.textContent = '▼';
                localStorage.setItem('sidebar_expanded_' + moduleKey, 'true');
            } else {
                items.classList.add('collapsed');
                toggle.textContent = '▶';
                localStorage.removeItem('sidebar_expanded_' + moduleKey);
            }
        });
    });
}

function initAssetContext() {
    const basePath = getBasePath();
    const params = new URLSearchParams(window.location.search);
    const assetId = params.get('asset');
    
    if (assetId) {
        const assetContextEl = document.getElementById('asset-context');
        const assetContextLink = document.getElementById('asset-context-link');
        
        if (assetContextEl && assetContextLink) {
            assetContextEl.style.display = 'inline';
            assetContextLink.textContent = assetId;
            assetContextLink.href = basePath + 'modules/asset-central/Asset-Detail.html?asset=' + assetId;
        }
        
        const assetBanner = document.getElementById('asset-context-banner');
        if (assetBanner) {
            assetBanner.style.display = 'flex';
            const bannerLink = document.getElementById('banner-asset-link');
            if (bannerLink) {
                bannerLink.href = basePath + 'modules/asset-central/Asset-Detail.html?asset=' + assetId;
            }
            const bannerAssetId = document.getElementById('banner-asset-id');
            if (bannerAssetId) {
                bannerAssetId.textContent = assetId;
            }
        }
    }
}

function loadNavigation() {
    renderSidebar();
    initAssetContext();
}

function openModal(modalId) {
    document.getElementById(modalId).classList.add('active');
}

function closeModal(modalId) {
    document.getElementById(modalId).classList.remove('active');
}