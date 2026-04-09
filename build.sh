#!/bin/bash
# Build script for Asset Management System (Backend + Frontend)

set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
BACKEND_DIR="$PROJECT_DIR/code"
FRONTEND_DIR="$PROJECT_DIR/frontend"

echo "=== Building Asset Management System ==="

# Build backend (which now includes frontend build)
echo ""
echo "1. Building backend with frontend..."
cd "$BACKEND_DIR"
mvn clean package -DskipTests -q

echo ""
echo "=== Build Complete ==="
echo ""
echo "To run the application:"
echo "  cd $BACKEND_DIR"
echo "  mvn spring-boot:run"
echo ""
echo "Or run the JAR directly:"
echo "  java -jar target/asset-management-system-1.0.0-SNAPSHOT.jar"
echo ""
echo "Access the application at: http://localhost:8080/api/"
