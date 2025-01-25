
cmake_minimum_required(VERSION 3.31.5)

project(QBiTFoundationSMSv1 LANGUAGES CXX)

add_library(native-lib nats_client SHARED IMPORTED)
set_target_properties(nats_client PROPERTIES IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../nats_client/target/armv7-linux-androideabi/release/libnats_client.so)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../nats_client)
target_link_libraries(native-lib nats_client)
