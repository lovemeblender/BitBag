#include <iostream>
#include <string>
#include <cmath>
#include "BitBag.h"

using namespace std;
using namespace Storage;

int main() 
{
	BitBag* b = new BitBag();
	b->set(4);
	b->set(6);
	cout << b->decToBin() << endl;
	return 0;
}

BitBag::BitBag(void)
{
	BitBag(0);
}
BitBag::BitBag(int n)
{
	bitArray = n;
}
BitBag::~BitBag(void) 
{
}

string BitBag::decToBin() 
{
	int i = bitArray;
	string s = "";
	while(i > 0) {
		if(i % 2 == 0) s += "0";
		else s += "1";
		i /= 2;
	}
	return s;
}

void BitBag::set(int n)
{
	int mask = pow(2, n - (32 * (n/32))); 
	bitArray |= mask;
}

int BitBag::get(int n)
{
	int mask = pow(2, n - (32 * (n/32)));
	return (bitArray & mask == 0) ? 0 : 1;
}

void BitBag::clear(int n)
{
	int mask = pow(2, n - (32 * (n/32)));
	bitArray &= ~mask;
}

void BitBag::clearAll() 
{
	bitArray = 0;
}

void BitBag::resize(int n)
{
}


