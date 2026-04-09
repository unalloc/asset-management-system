# Asset Management System - Phase 1 Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Create Spring Boot project structure with technical infrastructure (base classes, config, exception handling) and implement Module 1 core: Asset and Work Order CRUD APIs.

**Architecture:** Spring Boot 3.2.4 with layered architecture (Controller → Service → Repository → Entity). RESTful API at `/api/v1/assets` and `/api/v1/work-orders`. Normalized database schema with foreign key relationships.

**Tech Stack:** Spring Boot 3.2.4, Spring Data JPA, MySQL, Lombok, MapStruct

---

## File Structure

```
code/
├── pom.xml                                          # Already exists
├── src/main/java/com/ams/
│   ├── AssetManagementApplication.java              # Already exists
│   ├── common/
│   │   ├── BaseEntity.java                          # NEW - Abstract base for all entities
│   │   ├── BaseRepository.java                      # NEW - Generic repository interface
│   │   ├── BaseService.java                         # NEW - Generic service interface
│   │   ├── BaseServiceImpl.java                     # NEW - Generic service implementation
│   │   ├── GlobalExceptionHandler.java              # NEW - REST exception handling
│   │   └── dto/
│   │       ├── ApiResponse.java                     # NEW - Standard API response wrapper
│   │       └── ErrorResponse.java                   # NEW - Error response DTO
│   ├── config/
│   │   └── WebConfig.java                          # NEW - Web MVC config
│   └── exception/
│       ├── ResourceNotFoundException.java           # NEW - 404 exception
│       └── ValidationException.java                 # NEW - 400 exception
├── modules/assetcentral/
│   ├── entity/
│   │   ├── Asset.java                               # NEW - Asset JPA entity
│   │   └── WorkOrder.java                          # NEW - WorkOrder JPA entity
│   ├── repository/
│   │   ├── AssetRepository.java                     # NEW - Asset repository
│   │   └── WorkOrderRepository.java                 # NEW - WorkOrder repository
│   ├── service/
│   │   ├── AssetService.java                        # NEW - Asset service interface
│   │   ├── AssetServiceImpl.java                   # NEW - Asset service implementation
│   │   ├── WorkOrderService.java                    # NEW - WorkOrder service interface
│   │   └── WorkOrderServiceImpl.java                # NEW - WorkOrder service implementation
│   ├── controller/
│   │   ├── AssetController.java                     # NEW - Asset REST controller
│   │   └── WorkOrderController.java                  # NEW - WorkOrder REST controller
│   └── dto/
│       ├── AssetDto.java                             # NEW - Asset response DTO
│       ├── CreateAssetRequest.java                   # NEW - Asset create request
│       ├── UpdateAssetRequest.java                   # NEW - Asset update request
│       ├── WorkOrderDto.java                         # NEW - WorkOrder response DTO
│       ├── CreateWorkOrderRequest.java               # NEW - WorkOrder create request
│       └── UpdateWorkOrderRequest.java               # NEW - WorkOrder update request
└── src/test/java/com/ams/
    └── modules/assetcentral/
        ├── service/
        │   ├── AssetServiceTest.java                # NEW - Asset service unit tests
        │   └── WorkOrderServiceTest.java             # NEW - WorkOrder service unit tests
        └── controller/
            ├── AssetControllerTest.java              # NEW - Asset controller tests
            └── WorkOrderControllerTest.java         # NEW - WorkOrder controller tests
```

---

## Task 1: Create Base Classes

**Files:**
- Create: `code/src/main/java/com/ams/common/BaseEntity.java`
- Create: `code/src/main/java/com/ams/common/BaseRepository.java`
- Create: `code/src/main/java/com/ams/common/BaseService.java`
- Create: `code/src/main/java/com/ams/common/BaseServiceImpl.java`
- Create: `code/src/main/java/com/ams/common/dto/ApiResponse.java`
- Create: `code/src/main/java/com/ams/common/dto/ErrorResponse.java`

---

### Task 1.1: Create BaseEntity

- [ ] **Step 1: Create BaseEntity.java**

```java
package com.ams.common;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Version
    private Long version;
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/common/BaseEntity.java
git commit -m "feat: add BaseEntity with common fields (id, createdAt, updatedAt, createdBy, updatedBy, version)"
```

---

### Task 1.2: Create ApiResponse DTO

- [ ] **Step 1: Create ApiResponse.java**

```java
package com.ams.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String message;
    private LocalDateTime timestamp;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static <T> ApiResponse<T> error(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/common/dto/ApiResponse.java
git commit -m "feat: add ApiResponse DTO for standard REST responses"
```

---

### Task 1.3: Create BaseRepository

- [ ] **Step 1: Create BaseRepository.java**

```java
package com.ams.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    Optional<T> findById(Long id);
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/common/BaseRepository.java
git commit -m "feat: add BaseRepository with common query methods"
```

---

### Task 1.4: Create BaseService

- [ ] **Step 1: Create BaseService.java**

```java
package com.ams.common;

import java.util.List;
import java.util.Optional;

public interface BaseService<T> {

    T create(T entity);

    Optional<T> findById(Long id);

    List<T> findAll();

    T update(Long id, T entity);

    void delete(Long id);

    boolean exists(Long id);
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/common/BaseService.java
git commit -m "feat: add BaseService interface with CRUD template methods"
```

---

### Task 1.5: Create BaseServiceImpl

- [ ] **Step 1: Create BaseServiceImpl.java**

```java
package com.ams.common;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected final BaseRepository<T> repository;

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T update(Long id, T entity) {
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/common/BaseServiceImpl.java
git commit -m "feat: add BaseServiceImpl with CRUD implementation"
```

---

### Task 1.6: Create Exception Classes

- [ ] **Step 1: Create ResourceNotFoundException.java**

```java
package com.ams.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, Long id) {
        super(String.format("%s not found with id: %d", resourceName, id));
    }
}
```

- [ ] **Step 2: Create ValidationException.java**

```java
package com.ams.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
```

- [ ] **Step 3: Create GlobalExceptionHandler.java**

```java
package com.ams.common;

import com.ams.common.dto.ErrorResponse;
import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ValidationException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .success(false)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception ex) {
        ErrorResponse error = ErrorResponse.builder()
                .success(false)
                .message("An unexpected error occurred: " + ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
```

- [ ] **Step 4: Create ErrorResponse.java**

```java
package com.ams.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private boolean success;
    private String message;
    private List<String> errors;
    private LocalDateTime timestamp;
}
```

- [ ] **Step 5: Commit**
```bash
git add code/src/main/java/com/ams/exception/ResourceNotFoundException.java
git add code/src/main/java/com/ams/exception/ValidationException.java
git add code/src/main/java/com/ams/common/GlobalExceptionHandler.java
git add code/src/main/java/com/ams/common/dto/ErrorResponse.java
git commit -m "feat: add exception handling classes"
```

---

## Task 2: Create Asset Entity and CRUD

**Files:**
- Create: `code/src/main/java/com/ams/modules/assetcentral/entity/Asset.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/repository/AssetRepository.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/service/AssetService.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/service/impl/AssetServiceImpl.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/AssetDto.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/CreateAssetRequest.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/UpdateAssetRequest.java`

---

### Task 2.1: Create Asset Entity

- [ ] **Step 1: Create directory for implementations**
```bash
mkdir -p code/src/main/java/com/ams/modules/assetcentral/service/impl
```

- [ ] **Step 2: Create Asset.java**

```java
package com.ams.modules.assetcentral.entity;

import com.ams.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "asset")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asset extends BaseEntity {

    @Column(name = "asset_number", unique = true, nullable = false, length = 50)
    private String assetNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "serial_number", length = 100)
    private String serialNumber;

    @Column(name = "asset_type", length = 50)
    private String assetType;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model", length = 100)
    private String model;

    @Column(name = "manufacture_date")
    private LocalDate manufactureDate;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "purchase_cost", precision = 15, scale = 2)
    private BigDecimal purchaseCost;

    @Column(name = "book_value", precision = 15, scale = 2)
    private BigDecimal bookValue;

    @Column(name = "residual_value", precision = 15, scale = 2)
    private BigDecimal residualValue;

    @Column(name = "useful_life_years")
    private Integer usefulLifeYears;

    @Column(name = "depreciation_method", length = 50)
    private String depreciationMethod;

    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "ACTIVE";

    @Column(name = "location")
    private String location;

    @Column(name = "criticality", length = 20)
    private String criticality;

    @Column(name = "barcode", length = 100)
    private String barcode;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "rfid_tag", length = 100)
    private String rfidTag;

    @Column(name = "warranty_expiry")
    private LocalDate warrantyExpiry;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;
}
```

- [ ] **Step 3: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/entity/Asset.java
git commit -m "feat: add Asset entity with all fields"
```

---

### Task 2.2: Create Asset DTOs

- [ ] **Step 1: Create AssetDto.java**

```java
package com.ams.modules.assetcentral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {

    private Long id;
    private String assetNumber;
    private String name;
    private String description;
    private String serialNumber;
    private String assetType;
    private String category;
    private String manufacturer;
    private String model;
    private LocalDate manufactureDate;
    private LocalDate purchaseDate;
    private BigDecimal purchaseCost;
    private BigDecimal bookValue;
    private BigDecimal residualValue;
    private Integer usefulLifeYears;
    private String depreciationMethod;
    private String status;
    private String location;
    private String criticality;
    private String barcode;
    private String qrCode;
    private String rfidTag;
    private LocalDate warrantyExpiry;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
```

- [ ] **Step 2: Create CreateAssetRequest.java**

```java
package com.ams.modules.assetcentral.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAssetRequest {

    @NotBlank(message = "Asset number is required")
    private String assetNumber;

    @NotBlank(message = "Asset name is required")
    private String name;

    private String description;
    private String serialNumber;
    private String assetType;
    private String category;
    private String manufacturer;
    private String model;
    private LocalDate manufactureDate;
    private LocalDate purchaseDate;
    private BigDecimal purchaseCost;
    private BigDecimal residualValue;
    private Integer usefulLifeYears;
    private String depreciationMethod;
    private String status;
    private String location;
    private String criticality;
    private String barcode;
    private String qrCode;
    private String rfidTag;
    private LocalDate warrantyExpiry;
    private String notes;
}
```

- [ ] **Step 3: Create UpdateAssetRequest.java**

```java
package com.ams.modules.assetcentral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAssetRequest {

    private String name;
    private String description;
    private String serialNumber;
    private String assetType;
    private String category;
    private String manufacturer;
    private String model;
    private LocalDate manufactureDate;
    private LocalDate purchaseDate;
    private BigDecimal purchaseCost;
    private BigDecimal bookValue;
    private BigDecimal residualValue;
    private Integer usefulLifeYears;
    private String depreciationMethod;
    private String status;
    private String location;
    private String criticality;
    private String barcode;
    private String qrCode;
    private String rfidTag;
    private LocalDate warrantyExpiry;
    private String notes;
}
```

- [ ] **Step 4: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/dto/AssetDto.java
git add code/src/main/java/com/ams/modules/assetcentral/dto/CreateAssetRequest.java
git add code/src/main/java/com/ams/modules/assetcentral/dto/UpdateAssetRequest.java
git commit -m "feat: add Asset DTOs (AssetDto, CreateAssetRequest, UpdateAssetRequest)"
```

---

### Task 2.3: Create Asset Repository

- [ ] **Step 1: Create AssetRepository.java**

```java
package com.ams.modules.assetcentral.repository;

import com.ams.common.BaseRepository;
import com.ams.modules.assetcentral.entity.Asset;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssetRepository extends BaseRepository<Asset> {

    Optional<Asset> findByAssetNumber(String assetNumber);

    boolean existsByAssetNumber(String assetNumber);
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/repository/AssetRepository.java
git commit -m "feat: add AssetRepository"
```

---

### Task 2.4: Create Asset Service

- [ ] **Step 1: Create AssetService.java**

```java
package com.ams.modules.assetcentral.service;

import com.ams.common.BaseService;
import com.ams.modules.assetcentral.dto.AssetDto;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;

import java.util.List;

public interface AssetService extends BaseService<Asset> {

    AssetDto create(CreateAssetRequest request);

    AssetDto update(Long id, UpdateAssetRequest request);

    AssetDto findByAssetNumber(String assetNumber);

    List<AssetDto> findByStatus(String status);

    List<AssetDto> search(String keyword);
}
```

- [ ] **Step 2: Create AssetServiceImpl.java**

```java
package com.ams.modules.assetcentral.service.impl;

import com.ams.common.BaseServiceImpl;
import com.ams.common.BaseRepository;
import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.AssetDto;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import com.ams.modules.assetcentral.repository.AssetRepository;
import com.ams.modules.assetcentral.service.AssetService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl extends BaseServiceImpl<Asset> implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        super(assetRepository);
        this.assetRepository = assetRepository;
    }

    @Override
    public AssetDto create(CreateAssetRequest request) {
        if (assetRepository.existsByAssetNumber(request.getAssetNumber())) {
            throw new ValidationException("Asset number already exists: " + request.getAssetNumber());
        }

        Asset asset = Asset.builder()
                .assetNumber(request.getAssetNumber())
                .name(request.getName())
                .description(request.getDescription())
                .serialNumber(request.getSerialNumber())
                .assetType(request.getAssetType())
                .category(request.getCategory())
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .manufactureDate(request.getManufactureDate())
                .purchaseDate(request.getPurchaseDate())
                .purchaseCost(request.getPurchaseCost())
                .residualValue(request.getResidualValue())
                .usefulLifeYears(request.getUsefulLifeYears())
                .depreciationMethod(request.getDepreciationMethod())
                .status(request.getStatus() != null ? request.getStatus() : "ACTIVE")
                .location(request.getLocation())
                .criticality(request.getCriticality())
                .barcode(request.getBarcode())
                .qrCode(request.getQrCode())
                .rfidTag(request.getRfidTag())
                .warrantyExpiry(request.getWarrantyExpiry())
                .notes(request.getNotes())
                .bookValue(request.getPurchaseCost())
                .build();

        Asset saved = assetRepository.save(asset);
        return toDto(saved);
    }

    @Override
    public AssetDto update(Long id, UpdateAssetRequest request) {
        Asset existing = assetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asset", id));

        if (request.getName() != null) {
            existing.setName(request.getName());
        }
        if (request.getDescription() != null) {
            existing.setDescription(request.getDescription());
        }
        if (request.getSerialNumber() != null) {
            existing.setSerialNumber(request.getSerialNumber());
        }
        if (request.getAssetType() != null) {
            existing.setAssetType(request.getAssetType());
        }
        if (request.getCategory() != null) {
            existing.setCategory(request.getCategory());
        }
        if (request.getManufacturer() != null) {
            existing.setManufacturer(request.getManufacturer());
        }
        if (request.getModel() != null) {
            existing.setModel(request.getModel());
        }
        if (request.getManufactureDate() != null) {
            existing.setManufactureDate(request.getManufactureDate());
        }
        if (request.getPurchaseDate() != null) {
            existing.setPurchaseDate(request.getPurchaseDate());
        }
        if (request.getPurchaseCost() != null) {
            existing.setPurchaseCost(request.getPurchaseCost());
        }
        if (request.getBookValue() != null) {
            existing.setBookValue(request.getBookValue());
        }
        if (request.getResidualValue() != null) {
            existing.setResidualValue(request.getResidualValue());
        }
        if (request.getUsefulLifeYears() != null) {
            existing.setUsefulLifeYears(request.getUsefulLifeYears());
        }
        if (request.getDepreciationMethod() != null) {
            existing.setDepreciationMethod(request.getDepreciationMethod());
        }
        if (request.getStatus() != null) {
            existing.setStatus(request.getStatus());
        }
        if (request.getLocation() != null) {
            existing.setLocation(request.getLocation());
        }
        if (request.getCriticality() != null) {
            existing.setCriticality(request.getCriticality());
        }
        if (request.getBarcode() != null) {
            existing.setBarcode(request.getBarcode());
        }
        if (request.getQrCode() != null) {
            existing.setQrCode(request.getQrCode());
        }
        if (request.getRfidTag() != null) {
            existing.setRfidTag(request.getRfidTag());
        }
        if (request.getWarrantyExpiry() != null) {
            existing.setWarrantyExpiry(request.getWarrantyExpiry());
        }
        if (request.getNotes() != null) {
            existing.setNotes(request.getNotes());
        }

        Asset updated = assetRepository.save(existing);
        return toDto(updated);
    }

    @Override
    public AssetDto findByAssetNumber(String assetNumber) {
        Asset asset = assetRepository.findByAssetNumber(assetNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Asset not found with number: " + assetNumber));
        return toDto(asset);
    }

    @Override
    public List<AssetDto> findByStatus(String status) {
        return assetRepository.findAll().stream()
                .filter(a -> a.getStatus().equalsIgnoreCase(status))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssetDto> search(String keyword) {
        String lowerKeyword = keyword.toLowerCase();
        return assetRepository.findAll().stream()
                .filter(a -> 
                    a.getName().toLowerCase().contains(lowerKeyword) ||
                    (a.getAssetNumber() != null && a.getAssetNumber().toLowerCase().contains(lowerKeyword)) ||
                    (a.getSerialNumber() != null && a.getSerialNumber().toLowerCase().contains(lowerKeyword)) ||
                    (a.getLocation() != null && a.getLocation().toLowerCase().contains(lowerKeyword)))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private AssetDto toDto(Asset asset) {
        return AssetDto.builder()
                .id(asset.getId())
                .assetNumber(asset.getAssetNumber())
                .name(asset.getName())
                .description(asset.getDescription())
                .serialNumber(asset.getSerialNumber())
                .assetType(asset.getAssetType())
                .category(asset.getCategory())
                .manufacturer(asset.getManufacturer())
                .model(asset.getModel())
                .manufactureDate(asset.getManufactureDate())
                .purchaseDate(asset.getPurchaseDate())
                .purchaseCost(asset.getPurchaseCost())
                .bookValue(asset.getBookValue())
                .residualValue(asset.getResidualValue())
                .usefulLifeYears(asset.getUsefulLifeYears())
                .depreciationMethod(asset.getDepreciationMethod())
                .status(asset.getStatus())
                .location(asset.getLocation())
                .criticality(asset.getCriticality())
                .barcode(asset.getBarcode())
                .qrCode(asset.getQrCode())
                .rfidTag(asset.getRfidTag())
                .warrantyExpiry(asset.getWarrantyExpiry())
                .notes(asset.getNotes())
                .createdAt(asset.getCreatedAt())
                .updatedAt(asset.getUpdatedAt())
                .build();
    }
}
```

- [ ] **Step 3: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/service/AssetService.java
git add code/src/main/java/com/ams/modules/assetcentral/service/impl/AssetServiceImpl.java
git commit -m "feat: add AssetService with full CRUD and search functionality"
```

---

### Task 2.5: Create Asset Controller

- [ ] **Step 1: Create AssetController.java**

```java
package com.ams.modules.assetcentral.controller;

import com.ams.common.dto.ApiResponse;
import com.ams.modules.assetcentral.dto.AssetDto;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.service.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/assets")
@RequiredArgsConstructor
public class AssetController {

    private final AssetService assetService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AssetDto>>> getAllAssets() {
        List<AssetDto> assets = assetService.findAll();
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetDto>> getAssetById(@PathVariable Long id) {
        AssetDto asset = assetService.findById(id)
                .orElseThrow(() -> new com.ams.exception.ResourceNotFoundException("Asset", id));
        return ResponseEntity.ok(ApiResponse.success(asset));
    }

    @GetMapping("/number/{assetNumber}")
    public ResponseEntity<ApiResponse<AssetDto>> getAssetByNumber(@PathVariable String assetNumber) {
        AssetDto asset = assetService.findByAssetNumber(assetNumber);
        return ResponseEntity.ok(ApiResponse.success(asset));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<AssetDto>>> getAssetsByStatus(@PathVariable String status) {
        List<AssetDto> assets = assetService.findByStatus(status);
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<AssetDto>>> searchAssets(@RequestParam String keyword) {
        List<AssetDto> assets = assetService.search(keyword);
        return ResponseEntity.ok(ApiResponse.success(assets));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AssetDto>> createAsset(@Valid @RequestBody CreateAssetRequest request) {
        AssetDto created = assetService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(created, "Asset created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AssetDto>> updateAsset(@PathVariable Long id,
                                                            @Valid @RequestBody UpdateAssetRequest request) {
        AssetDto updated = assetService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(updated, "Asset updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAsset(@PathVariable Long id) {
        assetService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Asset deleted successfully"));
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/controller/AssetController.java
git commit -m "feat: add AssetController with REST endpoints"
```

---

## Task 3: Create WorkOrder Entity and CRUD

**Files:**
- Create: `code/src/main/java/com/ams/modules/assetcentral/entity/WorkOrder.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/repository/WorkOrderRepository.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/service/WorkOrderService.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/service/impl/WorkOrderServiceImpl.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/WorkOrderDto.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/CreateWorkOrderRequest.java`
- Create: `code/src/main/java/com/ams/modules/assetcentral/dto/UpdateWorkOrderRequest.java`

---

### Task 3.1: Create WorkOrder Entity

- [ ] **Step 1: Create WorkOrder.java**

```java
package com.ams.modules.assetcentral.entity;

import com.ams.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "work_order")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrder extends BaseEntity {

    @Column(name = "work_order_number", unique = true, nullable = false, length = 50)
    private String workOrderNumber;

    @Column(name = "asset_id", nullable = false)
    private Long assetId;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "work_order_type", length = 50)
    private String workOrderType;

    @Column(name = "priority", length = 20)
    @Builder.Default
    private String priority = "MEDIUM";

    @Column(name = "status", length = 50)
    @Builder.Default
    private String status = "PENDING";

    @Column(name = "assigned_technician")
    private String assignedTechnician;

    @Column(name = "scheduled_start_date")
    private LocalDate scheduledStartDate;

    @Column(name = "scheduled_end_date")
    private LocalDate scheduledEndDate;

    @Column(name = "actual_start_date")
    private LocalDate actualStartDate;

    @Column(name = "actual_end_date")
    private LocalDate actualEndDate;

    @Column(name = "estimated_hours", precision = 10, scale = 2)
    private BigDecimal estimatedHours;

    @Column(name = "actual_hours", precision = 10, scale = 2)
    private BigDecimal actualHours;

    @Column(name = "labor_cost", precision = 15, scale = 2)
    private BigDecimal laborCost;

    @Column(name = "parts_cost", precision = 15, scale = 2)
    private BigDecimal partsCost;

    @Column(name = "total_cost", precision = 15, scale = 2)
    private BigDecimal totalCost;

    @Column(name = "work_order_source", length = 50)
    private String workOrderSource;

    @Column(name = "failure_code", length = 50)
    private String failureCode;

    @Column(name = "root_cause")
    private String rootCause;

    @Column(name = "resolution_notes", columnDefinition = "TEXT")
    private String resolutionNotes;

    @Column(name = "asset_downtime_hours", precision = 10, scale = 2)
    private BigDecimal assetDowntimeHours;
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/entity/WorkOrder.java
git commit -m "feat: add WorkOrder entity"
```

---

### Task 3.2: Create WorkOrder DTOs

- [ ] **Step 1: Create WorkOrderDto.java**

```java
package com.ams.modules.assetcentral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderDto {

    private Long id;
    private String workOrderNumber;
    private Long assetId;
    private String assetName;
    private String description;
    private String workOrderType;
    private String priority;
    private String status;
    private String assignedTechnician;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;
    private BigDecimal estimatedHours;
    private BigDecimal actualHours;
    private BigDecimal laborCost;
    private BigDecimal partsCost;
    private BigDecimal totalCost;
    private String workOrderSource;
    private String failureCode;
    private String rootCause;
    private String resolutionNotes;
    private BigDecimal assetDowntimeHours;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
```

- [ ] **Step 2: Create CreateWorkOrderRequest.java**

```java
package com.ams.modules.assetcentral.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkOrderRequest {

    @NotBlank(message = "Work order number is required")
    private String workOrderNumber;

    @NotNull(message = "Asset ID is required")
    private Long assetId;

    @NotBlank(message = "Description is required")
    private String description;

    private String workOrderType;
    private String priority;
    private String assignedTechnician;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
    private BigDecimal estimatedHours;
    private String workOrderSource;
    private String failureCode;
}
```

- [ ] **Step 3: Create UpdateWorkOrderRequest.java**

```java
package com.ams.modules.assetcentral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWorkOrderRequest {

    private String description;
    private String workOrderType;
    private String priority;
    private String status;
    private String assignedTechnician;
    private LocalDate scheduledStartDate;
    private LocalDate scheduledEndDate;
    private LocalDate actualStartDate;
    private LocalDate actualEndDate;
    private BigDecimal estimatedHours;
    private BigDecimal actualHours;
    private BigDecimal laborCost;
    private BigDecimal partsCost;
    private BigDecimal totalCost;
    private String workOrderSource;
    private String failureCode;
    private String rootCause;
    private String resolutionNotes;
    private BigDecimal assetDowntimeHours;
}
```

- [ ] **Step 4: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/dto/WorkOrderDto.java
git add code/src/main/java/com/ams/modules/assetcentral/dto/CreateWorkOrderRequest.java
git add code/src/main/java/com/ams/modules/assetcentral/dto/UpdateWorkOrderRequest.java
git commit -m "feat: add WorkOrder DTOs"
```

---

### Task 3.3: Create WorkOrder Repository

- [ ] **Step 1: Create WorkOrderRepository.java**

```java
package com.ams.modules.assetcentral.repository;

import com.ams.common.BaseRepository;
import com.ams.modules.assetcentral.entity.WorkOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkOrderRepository extends BaseRepository<WorkOrder> {

    Optional<WorkOrder> findByWorkOrderNumber(String workOrderNumber);

    List<WorkOrder> findByAssetId(Long assetId);

    List<WorkOrder> findByStatus(String status);

    boolean existsByWorkOrderNumber(String workOrderNumber);
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/repository/WorkOrderRepository.java
git commit -m "feat: add WorkOrderRepository"
```

---

### Task 3.4: Create WorkOrder Service

- [ ] **Step 1: Create WorkOrderService.java**

```java
package com.ams.modules.assetcentral.service;

import com.ams.common.BaseService;
import com.ams.modules.assetcentral.dto.WorkOrderDto;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;

import java.util.List;

public interface WorkOrderService extends BaseService<WorkOrder> {

    WorkOrderDto create(CreateWorkOrderRequest request);

    WorkOrderDto update(Long id, UpdateWorkOrderRequest request);

    WorkOrderDto findByWorkOrderNumber(String workOrderNumber);

    List<WorkOrderDto> findByAssetId(Long assetId);

    List<WorkOrderDto> findByStatus(String status);

    WorkOrderDto updateStatus(Long id, String status);

    WorkOrderDto complete(Long id);
}
```

- [ ] **Step 2: Create WorkOrderServiceImpl.java**

```java
package com.ams.modules.assetcentral.service.impl;

import com.ams.common.BaseServiceImpl;
import com.ams.common.BaseRepository;
import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.WorkOrderDto;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import com.ams.modules.assetcentral.repository.WorkOrderRepository;
import com.ams.modules.assetcentral.service.WorkOrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkOrderServiceImpl extends BaseServiceImpl<WorkOrder> implements WorkOrderService {

    private final WorkOrderRepository workOrderRepository;

    public WorkOrderServiceImpl(WorkOrderRepository workOrderRepository) {
        super(workOrderRepository);
        this.workOrderRepository = workOrderRepository;
    }

    @Override
    public WorkOrderDto create(CreateWorkOrderRequest request) {
        if (workOrderRepository.existsByWorkOrderNumber(request.getWorkOrderNumber())) {
            throw new ValidationException("Work order number already exists: " + request.getWorkOrderNumber());
        }

        WorkOrder workOrder = WorkOrder.builder()
                .workOrderNumber(request.getWorkOrderNumber())
                .assetId(request.getAssetId())
                .description(request.getDescription())
                .workOrderType(request.getWorkOrderType())
                .priority(request.getPriority() != null ? request.getPriority() : "MEDIUM")
                .status("PENDING")
                .assignedTechnician(request.getAssignedTechnician())
                .scheduledStartDate(request.getScheduledStartDate())
                .scheduledEndDate(request.getScheduledEndDate())
                .estimatedHours(request.getEstimatedHours())
                .workOrderSource(request.getWorkOrderSource())
                .failureCode(request.getFailureCode())
                .build();

        WorkOrder saved = workOrderRepository.save(workOrder);
        return toDto(saved);
    }

    @Override
    public WorkOrderDto update(Long id, UpdateWorkOrderRequest request) {
        WorkOrder existing = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));

        if (request.getDescription() != null) {
            existing.setDescription(request.getDescription());
        }
        if (request.getWorkOrderType() != null) {
            existing.setWorkOrderType(request.getWorkOrderType());
        }
        if (request.getPriority() != null) {
            existing.setPriority(request.getPriority());
        }
        if (request.getStatus() != null) {
            existing.setStatus(request.getStatus());
        }
        if (request.getAssignedTechnician() != null) {
            existing.setAssignedTechnician(request.getAssignedTechnician());
        }
        if (request.getScheduledStartDate() != null) {
            existing.setScheduledStartDate(request.getScheduledStartDate());
        }
        if (request.getScheduledEndDate() != null) {
            existing.setScheduledEndDate(request.getScheduledEndDate());
        }
        if (request.getActualStartDate() != null) {
            existing.setActualStartDate(request.getActualStartDate());
        }
        if (request.getActualEndDate() != null) {
            existing.setActualEndDate(request.getActualEndDate());
        }
        if (request.getEstimatedHours() != null) {
            existing.setEstimatedHours(request.getEstimatedHours());
        }
        if (request.getActualHours() != null) {
            existing.setActualHours(request.getActualHours());
        }
        if (request.getLaborCost() != null) {
            existing.setLaborCost(request.getLaborCost());
        }
        if (request.getPartsCost() != null) {
            existing.setPartsCost(request.getPartsCost());
        }
        if (request.getTotalCost() != null) {
            existing.setTotalCost(request.getTotalCost());
        }
        if (request.getWorkOrderSource() != null) {
            existing.setWorkOrderSource(request.getWorkOrderSource());
        }
        if (request.getFailureCode() != null) {
            existing.setFailureCode(request.getFailureCode());
        }
        if (request.getRootCause() != null) {
            existing.setRootCause(request.getRootCause());
        }
        if (request.getResolutionNotes() != null) {
            existing.setResolutionNotes(request.getResolutionNotes());
        }
        if (request.getAssetDowntimeHours() != null) {
            existing.setAssetDowntimeHours(request.getAssetDowntimeHours());
        }

        WorkOrder updated = workOrderRepository.save(existing);
        return toDto(updated);
    }

    @Override
    public WorkOrderDto findByWorkOrderNumber(String workOrderNumber) {
        WorkOrder workOrder = workOrderRepository.findByWorkOrderNumber(workOrderNumber)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder not found with number: " + workOrderNumber));
        return toDto(workOrder);
    }

    @Override
    public List<WorkOrderDto> findByAssetId(Long assetId) {
        return workOrderRepository.findByAssetId(assetId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkOrderDto> findByStatus(String status) {
        return workOrderRepository.findByStatus(status).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WorkOrderDto updateStatus(Long id, String status) {
        WorkOrder existing = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));
        existing.setStatus(status);
        WorkOrder updated = workOrderRepository.save(existing);
        return toDto(updated);
    }

    @Override
    public WorkOrderDto complete(Long id) {
        WorkOrder existing = workOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WorkOrder", id));
        
        existing.setStatus("COMPLETED");
        existing.setActualEndDate(LocalDate.now());
        
        // Calculate total cost
        BigDecimal labor = existing.getLaborCost() != null ? existing.getLaborCost() : BigDecimal.ZERO;
        BigDecimal parts = existing.getPartsCost() != null ? existing.getPartsCost() : BigDecimal.ZERO;
        existing.setTotalCost(labor.add(parts));
        
        WorkOrder completed = workOrderRepository.save(existing);
        return toDto(completed);
    }

    private WorkOrderDto toDto(WorkOrder workOrder) {
        return WorkOrderDto.builder()
                .id(workOrder.getId())
                .workOrderNumber(workOrder.getWorkOrderNumber())
                .assetId(workOrder.getAssetId())
                .description(workOrder.getDescription())
                .workOrderType(workOrder.getWorkOrderType())
                .priority(workOrder.getPriority())
                .status(workOrder.getStatus())
                .assignedTechnician(workOrder.getAssignedTechnician())
                .scheduledStartDate(workOrder.getScheduledStartDate())
                .scheduledEndDate(workOrder.getScheduledEndDate())
                .actualStartDate(workOrder.getActualStartDate())
                .actualEndDate(workOrder.getActualEndDate())
                .estimatedHours(workOrder.getEstimatedHours())
                .actualHours(workOrder.getActualHours())
                .laborCost(workOrder.getLaborCost())
                .partsCost(workOrder.getPartsCost())
                .totalCost(workOrder.getTotalCost())
                .workOrderSource(workOrder.getWorkOrderSource())
                .failureCode(workOrder.getFailureCode())
                .rootCause(workOrder.getRootCause())
                .resolutionNotes(workOrder.getResolutionNotes())
                .assetDowntimeHours(workOrder.getAssetDowntimeHours())
                .createdAt(workOrder.getCreatedAt())
                .updatedAt(workOrder.getUpdatedAt())
                .build();
    }
}
```

- [ ] **Step 3: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/service/WorkOrderService.java
git add code/src/main/java/com/ams/modules/assetcentral/service/impl/WorkOrderServiceImpl.java
git commit -m "feat: add WorkOrderService with full CRUD and status management"
```

---

### Task 3.5: Create WorkOrder Controller

- [ ] **Step 1: Create WorkOrderController.java**

```java
package com.ams.modules.assetcentral.controller;

import com.ams.common.dto.ApiResponse;
import com.ams.modules.assetcentral.dto.WorkOrderDto;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.service.WorkOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/work-orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getAllWorkOrders() {
        List<WorkOrderDto> workOrders = workOrderService.findAll();
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> getWorkOrderById(@PathVariable Long id) {
        WorkOrderDto workOrder = workOrderService.findById(id)
                .orElseThrow(() -> new com.ams.exception.ResourceNotFoundException("WorkOrder", id));
        return ResponseEntity.ok(ApiResponse.success(workOrder));
    }

    @GetMapping("/number/{workOrderNumber}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> getWorkOrderByNumber(@PathVariable String workOrderNumber) {
        WorkOrderDto workOrder = workOrderService.findByWorkOrderNumber(workOrderNumber);
        return ResponseEntity.ok(ApiResponse.success(workOrder));
    }

    @GetMapping("/asset/{assetId}")
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getWorkOrdersByAsset(@PathVariable Long assetId) {
        List<WorkOrderDto> workOrders = workOrderService.findByAssetId(assetId);
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ApiResponse<List<WorkOrderDto>>> getWorkOrdersByStatus(@PathVariable String status) {
        List<WorkOrderDto> workOrders = workOrderService.findByStatus(status);
        return ResponseEntity.ok(ApiResponse.success(workOrders));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<WorkOrderDto>> createWorkOrder(@Valid @RequestBody CreateWorkOrderRequest request) {
        WorkOrderDto created = workOrderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(created, "Work order created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<WorkOrderDto>> updateWorkOrder(@PathVariable Long id,
                                                                     @Valid @RequestBody UpdateWorkOrderRequest request) {
        WorkOrderDto updated = workOrderService.update(id, request);
        return ResponseEntity.ok(ApiResponse.success(updated, "Work order updated successfully"));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<WorkOrderDto>> updateStatus(@PathVariable Long id,
                                                                    @RequestParam String status) {
        WorkOrderDto updated = workOrderService.updateStatus(id, status);
        return ResponseEntity.ok(ApiResponse.success(updated, "Work order status updated"));
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<ApiResponse<WorkOrderDto>> completeWorkOrder(@PathVariable Long id) {
        WorkOrderDto completed = workOrderService.complete(id);
        return ResponseEntity.ok(ApiResponse.success(completed, "Work order completed"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteWorkOrder(@PathVariable Long id) {
        workOrderService.delete(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Work order deleted successfully"));
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/main/java/com/ams/modules/assetcentral/controller/WorkOrderController.java
git commit -m "feat: add WorkOrderController with REST endpoints"
```

---

## Task 4: Create Unit Tests

**Files:**
- Create: `code/src/test/java/com/ams/modules/assetcentral/service/AssetServiceTest.java`
- Create: `code/src/test/java/com/ams/modules/assetcentral/service/WorkOrderServiceTest.java`

---

### Task 4.1: Create AssetServiceTest

- [ ] **Step 1: Create AssetServiceTest.java**

```java
package com.ams.modules.assetcentral.service;

import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.AssetDto;
import com.ams.modules.assetcentral.dto.CreateAssetRequest;
import com.ams.modules.assetcentral.dto.UpdateAssetRequest;
import com.ams.modules.assetcentral.entity.Asset;
import com.ams.modules.assetcentral.repository.AssetRepository;
import com.ams.modules.assetcentral.service.impl.AssetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AssetServiceTest {

    @Mock
    private AssetRepository assetRepository;

    @InjectMocks
    private AssetServiceImpl assetService;

    private Asset testAsset;
    private CreateAssetRequest createRequest;

    @BeforeEach
    void setUp() {
        testAsset = Asset.builder()
                .id(1L)
                .assetNumber("AST-001")
                .name("Test Asset")
                .description("Test Description")
                .assetType("Equipment")
                .category("Machinery")
                .status("ACTIVE")
                .purchaseCost(new BigDecimal("10000.00"))
                .bookValue(new BigDecimal("10000.00"))
                .build();

        createRequest = CreateAssetRequest.builder()
                .assetNumber("AST-001")
                .name("Test Asset")
                .description("Test Description")
                .assetType("Equipment")
                .category("Machinery")
                .purchaseCost(new BigDecimal("10000.00"))
                .build();
    }

    @Test
    void create_ShouldCreateAsset_WhenAssetNumberDoesNotExist() {
        when(assetRepository.existsByAssetNumber("AST-001")).thenReturn(false);
        when(assetRepository.save(any(Asset.class))).thenReturn(testAsset);

        AssetDto result = assetService.create(createRequest);

        assertNotNull(result);
        assertEquals("AST-001", result.getAssetNumber());
        assertEquals("Test Asset", result.getName());
        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void create_ShouldThrowException_WhenAssetNumberExists() {
        when(assetRepository.existsByAssetNumber("AST-001")).thenReturn(true);

        assertThrows(ValidationException.class, () -> assetService.create(createRequest));
        verify(assetRepository, never()).save(any(Asset.class));
    }

    @Test
    void findById_ShouldReturnAsset_WhenExists() {
        when(assetRepository.findById(1L)).thenReturn(Optional.of(testAsset));

        Optional<AssetDto> result = assetService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("AST-001", result.get().getAssetNumber());
    }

    @Test
    void findById_ShouldThrowException_WhenNotExists() {
        when(assetRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> assetService.findById(999L));
    }

    @Test
    void update_ShouldUpdateAsset_WhenExists() {
        UpdateAssetRequest updateRequest = UpdateAssetRequest.builder()
                .name("Updated Name")
                .status("MAINTENANCE")
                .build();

        when(assetRepository.findById(1L)).thenReturn(Optional.of(testAsset));
        when(assetRepository.save(any(Asset.class))).thenReturn(testAsset);

        AssetDto result = assetService.update(1L, updateRequest);

        assertNotNull(result);
        verify(assetRepository).save(any(Asset.class));
    }

    @Test
    void findAll_ShouldReturnAllAssets() {
        when(assetRepository.findAll()).thenReturn(List.of(testAsset));

        List<AssetDto> result = assetService.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void search_ShouldReturnMatchingAssets() {
        when(assetRepository.findAll()).thenReturn(List.of(testAsset));

        List<AssetDto> result = assetService.search("Test");

        assertEquals(1, result.size());
        assertEquals("Test Asset", result.get(0).getName());
    }

    @Test
    void delete_ShouldDeleteAsset_WhenExists() {
        when(assetRepository.existsById(1L)).thenReturn(true);
        doNothing().when(assetRepository).deleteById(1L);

        assetService.delete(1L);

        verify(assetRepository).deleteById(1L);
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/test/java/com/ams/modules/assetcentral/service/AssetServiceTest.java
git commit -m "test: add AssetService unit tests"
```

---

### Task 4.2: Create WorkOrderServiceTest

- [ ] **Step 1: Create WorkOrderServiceTest.java**

```java
package com.ams.modules.assetcentral.service;

import com.ams.exception.ResourceNotFoundException;
import com.ams.exception.ValidationException;
import com.ams.modules.assetcentral.dto.WorkOrderDto;
import com.ams.modules.assetcentral.dto.CreateWorkOrderRequest;
import com.ams.modules.assetcentral.dto.UpdateWorkOrderRequest;
import com.ams.modules.assetcentral.entity.WorkOrder;
import com.ams.modules.assetcentral.repository.WorkOrderRepository;
import com.ams.modules.assetcentral.service.impl.WorkOrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkOrderServiceTest {

    @Mock
    private WorkOrderRepository workOrderRepository;

    @InjectMocks
    private WorkOrderServiceImpl workOrderService;

    private WorkOrder testWorkOrder;
    private CreateWorkOrderRequest createRequest;

    @BeforeEach
    void setUp() {
        testWorkOrder = WorkOrder.builder()
                .id(1L)
                .workOrderNumber("WO-2026-001")
                .assetId(1L)
                .description("Test Work Order")
                .workOrderType("PREVENTIVE")
                .priority("MEDIUM")
                .status("PENDING")
                .build();

        createRequest = CreateWorkOrderRequest.builder()
                .workOrderNumber("WO-2026-001")
                .assetId(1L)
                .description("Test Work Order")
                .workOrderType("PREVENTIVE")
                .priority("MEDIUM")
                .build();
    }

    @Test
    void create_ShouldCreateWorkOrder_WhenNumberDoesNotExist() {
        when(workOrderRepository.existsByWorkOrderNumber("WO-2026-001")).thenReturn(false);
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrderDto result = workOrderService.create(createRequest);

        assertNotNull(result);
        assertEquals("WO-2026-001", result.getWorkOrderNumber());
        assertEquals("PENDING", result.getStatus());
        verify(workOrderRepository).save(any(WorkOrder.class));
    }

    @Test
    void create_ShouldThrowException_WhenNumberExists() {
        when(workOrderRepository.existsByWorkOrderNumber("WO-2026-001")).thenReturn(true);

        assertThrows(ValidationException.class, () -> workOrderService.create(createRequest));
        verify(workOrderRepository, never()).save(any(WorkOrder.class));
    }

    @Test
    void findById_ShouldReturnWorkOrder_WhenExists() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));

        Optional<WorkOrderDto> result = workOrderService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("WO-2026-001", result.get().getWorkOrderNumber());
    }

    @Test
    void findById_ShouldThrowException_WhenNotExists() {
        when(workOrderRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> workOrderService.findById(999L));
    }

    @Test
    void updateStatus_ShouldUpdateStatus() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrderDto result = workOrderService.updateStatus(1L, "IN_PROGRESS");

        assertNotNull(result);
        verify(workOrderRepository).save(any(WorkOrder.class));
    }

    @Test
    void complete_ShouldSetStatusToCompleted() {
        when(workOrderRepository.findById(1L)).thenReturn(Optional.of(testWorkOrder));
        when(workOrderRepository.save(any(WorkOrder.class))).thenReturn(testWorkOrder);

        WorkOrderDto result = workOrderService.complete(1L);

        assertNotNull(result);
        verify(workOrderRepository).save(any(WorkOrder.class));
    }

    @Test
    void findByAssetId_ShouldReturnWorkOrdersForAsset() {
        when(workOrderRepository.findByAssetId(1L)).thenReturn(List.of(testWorkOrder));

        List<WorkOrderDto> result = workOrderService.findByAssetId(1L);

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getAssetId());
    }

    @Test
    void findByStatus_ShouldReturnWorkOrdersWithStatus() {
        when(workOrderRepository.findByStatus("PENDING")).thenReturn(List.of(testWorkOrder));

        List<WorkOrderDto> result = workOrderService.findByStatus("PENDING");

        assertEquals(1, result.size());
        assertEquals("PENDING", result.get(0).getStatus());
    }
}
```

- [ ] **Step 2: Commit**
```bash
git add code/src/test/java/com/ams/modules/assetcentral/service/WorkOrderServiceTest.java
git commit -m "test: add WorkOrderService unit tests"
```

---

## Task 5: Verify Build

- [ ] **Step 1: Run Maven compile**
```bash
cd code && mvn clean compile -q
```

- [ ] **Step 2: Run tests**
```bash
cd code && mvn test -q
```

- [ ] **Step 3: Package application**
```bash
cd code && mvn package -DskipTests -q
```

- [ ] **Step 4: Final commit**
```bash
git add -A && git commit -m "feat: complete Phase 1 - Asset Central core APIs and unit tests"
```

---

## Summary

**Phase 1 creates:**
- Base infrastructure (BaseEntity, BaseRepository, BaseService, GlobalExceptionHandler)
- Asset CRUD API at `/api/v1/assets`
- WorkOrder CRUD API at `/api/v1/work-orders`
- Unit tests for both services
- MySQL database schema (auto-created via JPA)

**API Endpoints:**
```
GET    /api/v1/assets                    # List all assets
GET    /api/v1/assets/{id}              # Get asset by ID
POST   /api/v1/assets                    # Create asset
PUT    /api/v1/assets/{id}              # Update asset
DELETE /api/v1/assets/{id}              # Delete asset
GET    /api/v1/assets/search?keyword=    # Search assets

GET    /api/v1/work-orders              # List all work orders
GET    /api/v1/work-orders/{id}         # Get work order by ID
POST   /api/v1/work-orders               # Create work order
PUT    /api/v1/work-orders/{id}         # Update work order
PATCH  /api/v1/work-orders/{id}/status # Update status
PATCH  /api/v1/work-orders/{id}/complete # Complete work order
DELETE /api/v1/work-orders/{id}         # Delete work order
```

---

*Plan complete. Files to modify: 24 new files*
