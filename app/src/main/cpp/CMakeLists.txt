#!cmake
cmake_minimum_required(VERSION 3.22.1)
project(QBiTFoundationSMSv1 LANGUAGES CXX)

# Set the minimum Android API level
set(CMAKE_ANDROID_API 21)

# Define the nats_client library
add_library(nats_client SHARED IMPORTED)
add_library(native-lib SHARED ${CMAKE_CURRENT_SOURCE_DIR}/../nats_client/src/lib.rs)

# Set the location of the pre-built libnats_client.so
set_target_properties(nats_client PROPERTIES
        IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../nats_client/target/armv7-linux-androideabi/release/libnats_client.so
)
# Set properties for the nats_client library (if needed)
set_target_properties(nats_client PROPERTIES
        CXX_STANDARD 17
        CXX_STANDARD_REQUIRED ON
)

# Include directories for native-lib (if needed)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../nats_client)

# Link native-lib to the nats_client library
target_link_libraries(native-lib nats_client)
