cmake_minimum_required(VERSION 3.27)
project(cppOving3)

set(CMAKE_CXX_STANDARD 17)

add_executable(Oppgave1og2 Oppgave1og2/Main.cpp
        Oppgave1og2/Circle.h
        Oppgave1og2/Circle.cpp
)

add_executable(Oppgave3 Oppgave3/Main.cpp
        Oppgave3/Commodity.cpp
        Oppgave3/Commodity.h
)

add_executable(Oppgave4 Oppgave4/Main.cpp
)
