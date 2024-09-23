//
// Created by sverr on 28/08/2024.
//

#include "Commodity.h"

Commodity::Commodity(const string &name_, int id_, double price_)
    : name(name_), id(id_), price(price_){}

string Commodity::getName() {
    return name;
}

int Commodity::getId() const {
    return id;
}

double Commodity::getPrice() const {
    return price;
}

double Commodity::getPrice(double quantity) const {
    return price * quantity;
}

double Commodity::setPrice(double newPrice) {
    return price = newPrice;
}

double Commodity::getPriceWithTax() const {
    return price * (1 + tax);
}

double Commodity::getPriceWithTax(double quantity) const {
    return (price * (1 + tax)) * quantity;
}
