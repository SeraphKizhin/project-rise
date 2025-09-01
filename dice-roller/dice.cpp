#include <iostream>
#include <random>
using namespace std;

int main(){
    mt19937 generator(random_device{}());
    uniform_int_distribution<int>dist(1, 21);

    cout << "You rolled: " << dist(generator); 
    return 0;
}
