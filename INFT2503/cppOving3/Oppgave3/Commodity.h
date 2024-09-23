//
// Created by sverr on 28/08/2024.
//
#pragma once

#include <string>

using namespace std;

double const tax = 0.25;

class Commodity {
private:
    string name;
    int id;
public:
    double price;

    Commodity(const string &name_, int id_, double price_);
    string getName();
    [[nodiscard]] int getId() const;
    [[nodiscard]] double getPrice() const;
    [[nodiscard]] double getPrice(double quantity) const;
    double setPrice(double newPrice);
    [[nodiscard]] double getPriceWithTax() const;
    [[nodiscard]] double getPriceWithTax(double quantity) const;
};
