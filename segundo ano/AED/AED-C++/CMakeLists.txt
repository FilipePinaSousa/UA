cmake_minimum_required(VERSION 3.26)
project(AED_c__)

set(CMAKE_CXX_STANDARD 17)

add_executable(AED_c__ main.cpp
        aula13/Circle.cpp
        aula13/Figure.cpp
        aula13/CircleTest.cpp
        aula13/FiguresTest.cpp
        aula13/Point.cpp
        aula13/PointTest.cpp
        aula13/Rectangle.cpp
        aula13/RectangleTest.cpp
        aula13/Square.cpp
        aula13/SquareTest.cpp)
