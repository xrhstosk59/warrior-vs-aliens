#!/bin/bash
# Run script for Warrior vs Aliens

# Check if classes are compiled
if [ ! -d "target/classes" ]; then
    echo "⚠️  Project not built yet. Building now..."
    ./build.sh
fi

echo "🚀 Starting Warrior vs Aliens..."
echo ""

# Run the game
java -cp target/classes gr.university.warriorgame.Main
