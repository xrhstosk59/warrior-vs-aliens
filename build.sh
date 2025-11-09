#!/bin/bash
# Build script for Warrior vs Aliens
# This script compiles the Java sources without requiring Maven

set -e

echo "🔨 Building Warrior vs Aliens..."

# Create output directory
mkdir -p target/classes

# Compile all Java sources
echo "Compiling Java sources..."
javac -d target/classes \
      -sourcepath src/main/java \
      src/main/java/gr/university/warriorgame/*.java

echo "✅ Build successful!"
echo ""
echo "To run the game, execute:"
echo "  java -cp target/classes gr.university.warriorgame.Main"
echo ""
echo "Or use the run script:"
echo "  ./run.sh"
