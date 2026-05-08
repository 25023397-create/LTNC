#!/bin/bash

# --- Cấu hình ---
# Đảm bảo bạn có thư mục lib chứa các file .jar của JUnit và SLF4J
LIB_DIR="lib"
CP=".:$LIB_DIR/*"

echo "--- 1. Đang biên dịch mã nguồn (com/lab/MathUtils.java) ---"
# Biên dịch file theo đúng cấu trúc package
javac -cp "$CP" com/lab/MathUtils.java com/lab/MathUtilsTest.java

if [ $? -eq 0 ]; then
    echo "--- Biên dịch thành công! ---"
    
    echo -e "\n--- 2. Chạy Demo MathUtils (hàm main) ---"
    java -cp "$CP" com.lab.MathUtils

    echo -e "\n--- 3. Chạy Unit Tests ---"
    # Tìm file junit-standalone trong thư mục lib
    LAUNCHER=$(ls $LIB_DIR/junit-platform-console-standalone*.jar 2>/dev/null)
    
    if [ -f "$LAUNCHER" ]; then
        java -jar "$LAUNCHER" --class-path . --select-class com.lab.MathUtilsTest
    else
        echo "Lưu ý: Không tìm thấy file junit-platform-console-standalone.jar trong thư mục $LIB_DIR."
        echo "Bạn cần tải file này về để chạy được Unit Test."
    fi
else
    echo "--- Biên dịch thất bại. Hãy kiểm tra lại đường dẫn hoặc thư viện! ---"
    exit 1
fi