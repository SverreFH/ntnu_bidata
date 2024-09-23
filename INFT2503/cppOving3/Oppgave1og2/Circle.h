//
// Created by sverr on 28/08/2024.
//

#pragma once

const double pi = 3.141592;

class Circle {
public:
    explicit Circle(double radius_);
    [[nodiscard]] double get_area() const;
    [[nodiscard]] double get_circumference() const;

private:
    double radius;
};