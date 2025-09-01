#include <iostream>
#include <cstdlib>
#include <ctime>

int main(){
  srand(time(0));

  int dice = rand() % 6 + 1;
  cout << "You rolled: " << dice;
}
