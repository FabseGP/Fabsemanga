#!/bin/bash

file_path="gradle.properties"

if ! grep -q "android.enableAapt2=false" "$file_path"; then
    # Perform action x
    echo "android.enableAapt2 = false not found in $file_path"
    # Add your actions here
else
    echo "android.enableAapt2 = false found in $file_path"
fi

